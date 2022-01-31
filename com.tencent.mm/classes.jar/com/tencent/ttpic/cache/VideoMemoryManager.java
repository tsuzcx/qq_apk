package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.opengl.ETC1Util.ETC1Texture;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.filter.FabbyMvPart;
import com.tencent.ttpic.filter.FabbyParts;
import com.tencent.ttpic.gameplaysdk.model.GameParams;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.model.FaceFeatureItem;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.MultiViewerItem;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class VideoMemoryManager
{
  private static final String TAG;
  public static final int VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB = 51200;
  public static final int VIDEO_CACHE_MEM_CACHE_REMAIN_SIZE = 10240;
  private static final VideoMemoryManager mInstance;
  private final Map<String, Bitmap> mBeautyFaceCache;
  private final Map<String, Bitmap> mCache;
  private double mCurMaterialSizeInMB;
  private final Map<String, ETC1Util.ETC1Texture> mETCCache;
  private final Map<FaceOffUtil.FEATURE_TYPE, Bitmap> mGrayCache;
  private final Handler mHandler;
  private int mInitSampleSize;
  private int mMaxPreloadSizeInKB;
  private int mSampleSize;
  private final Map<String, LoadItemManager> managers;
  
  static
  {
    AppMethodBeat.i(81850);
    TAG = VideoMemoryManager.class.getSimpleName();
    mInstance = new VideoMemoryManager();
    AppMethodBeat.o(81850);
  }
  
  private VideoMemoryManager()
  {
    AppMethodBeat.i(81833);
    this.mInitSampleSize = 1;
    this.managers = new ConcurrentHashMap();
    this.mCache = new ConcurrentHashMap();
    this.mGrayCache = new ConcurrentHashMap();
    this.mETCCache = new ConcurrentHashMap();
    this.mHandler = new Handler(HandlerThreadManager.getInstance().getHanderThread(TAG).getLooper());
    this.mBeautyFaceCache = new ConcurrentHashMap();
    AppMethodBeat.o(81833);
  }
  
  public static VideoMemoryManager getInstance()
  {
    return mInstance;
  }
  
  private long getMaterialImageSizeInKB(VideoMaterial paramVideoMaterial)
  {
    long l2 = 0L;
    AppMethodBeat.i(81837);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(81837);
      return 0L;
    }
    Object localObject1 = new ArrayList();
    if (paramVideoMaterial.getItemList() != null) {
      ((List)localObject1).addAll(paramVideoMaterial.getItemList());
    }
    if (paramVideoMaterial.getHeadCropItemList() != null) {
      ((List)localObject1).addAll(paramVideoMaterial.getHeadCropItemList());
    }
    Object localObject2;
    Object localObject3;
    if (paramVideoMaterial.getFabbyParts() != null)
    {
      localObject2 = paramVideoMaterial.getFabbyParts().getParts().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FabbyMvPart)((Iterator)localObject2).next();
        if (((FabbyMvPart)localObject3).bgItem != null) {
          ((List)localObject1).add(((FabbyMvPart)localObject3).bgItem);
        }
        if (((FabbyMvPart)localObject3).fgItem != null) {
          ((List)localObject1).add(((FabbyMvPart)localObject3).fgItem);
        }
        if (((FabbyMvPart)localObject3).coverItem != null) {
          ((List)localObject1).add(((FabbyMvPart)localObject3).coverItem);
        }
        if (((FabbyMvPart)localObject3).transitionItem != null) {
          ((List)localObject1).add(((FabbyMvPart)localObject3).transitionItem);
        }
      }
    }
    if (paramVideoMaterial.getFaceFeatureItemList() != null)
    {
      localObject2 = paramVideoMaterial.getFaceFeatureItemList().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FaceFeatureItem)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((FaceFeatureItem)localObject3).getStickerItems() != null)) {
          ((List)localObject1).addAll(((FaceFeatureItem)localObject3).getStickerItems());
        }
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StickerItem)((Iterator)localObject1).next();
      l2 = VideoMaterialUtil.getAllImageSize(paramVideoMaterial.getDataPath() + File.separator + ((StickerItem)localObject2).subFolder) / 1024 + l2;
    }
    long l1 = l2;
    if (paramVideoMaterial.getFaceOffItemList() != null)
    {
      localObject1 = paramVideoMaterial.getFaceOffItemList().iterator();
      for (;;)
      {
        l1 = l2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (FaceItem)((Iterator)localObject1).next();
        if (!TextUtils.isEmpty(((FaceItem)localObject2).id)) {
          l2 += VideoMaterialUtil.getAllImageSize(paramVideoMaterial.getDataPath() + File.separator + ((FaceItem)localObject2).id) / 1024;
        }
      }
    }
    l2 = l1;
    if (paramVideoMaterial.getFaceFeatureItemList() != null)
    {
      localObject1 = paramVideoMaterial.getFaceFeatureItemList().iterator();
      do
      {
        l2 = l1;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (FaceFeatureItem)((Iterator)localObject1).next();
      } while ((localObject2 == null) || (((FaceFeatureItem)localObject2).getFaceOffItemList() == null));
      localObject2 = ((FaceFeatureItem)localObject2).getFaceOffItemList().iterator();
      l2 = l1;
      for (;;)
      {
        l1 = l2;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (FaceItem)((Iterator)localObject2).next();
        if (!TextUtils.isEmpty(((FaceItem)localObject3).id)) {
          l2 += VideoMaterialUtil.getAllImageSize(paramVideoMaterial.getDataPath() + File.separator + ((FaceItem)localObject3).id) / 1024;
        }
      }
    }
    paramVideoMaterial = paramVideoMaterial.getMultiViewerItemList();
    l1 = l2;
    if (paramVideoMaterial != null)
    {
      paramVideoMaterial = paramVideoMaterial.iterator();
      for (;;)
      {
        l1 = l2;
        if (!paramVideoMaterial.hasNext()) {
          break;
        }
        localObject1 = (MultiViewerItem)paramVideoMaterial.next();
        if (localObject1 != null) {
          l2 += getMaterialImageSizeInKB(((MultiViewerItem)localObject1).videoMaterial);
        }
      }
    }
    AppMethodBeat.o(81837);
    return l1;
  }
  
  private void loadAllItemsAppend(VideoMaterial paramVideoMaterial, int paramInt)
  {
    AppMethodBeat.i(81836);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(81836);
      return;
    }
    Object localObject3;
    if (paramVideoMaterial.getFaceOffItemList() != null)
    {
      localObject2 = paramVideoMaterial.getFaceOffItemList().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FaceItem)((Iterator)localObject2).next();
        if (!VideoMaterialUtil.isEmptyItem((FaceItem)localObject3))
        {
          if (TextUtils.isEmpty(((FaceItem)localObject3).id)) {}
          for (localObject1 = ((FaceItem)localObject3).faceExchangeImage;; localObject1 = ((FaceItem)localObject3).id)
          {
            this.managers.put(localObject1, new LoadFaceItemManager(this.mCache, this.mGrayCache, paramVideoMaterial.getDataPath(), (FaceItem)localObject3, paramInt));
            break;
          }
        }
      }
    }
    Object localObject4;
    if (paramVideoMaterial.getFaceFeatureItemList() != null)
    {
      localObject2 = paramVideoMaterial.getFaceFeatureItemList().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FaceFeatureItem)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((FaceFeatureItem)localObject3).getFaceOffItemList() != null))
        {
          localObject4 = ((FaceFeatureItem)localObject3).getFaceOffItemList().iterator();
          label192:
          FaceItem localFaceItem;
          while (((Iterator)localObject4).hasNext())
          {
            localFaceItem = (FaceItem)((Iterator)localObject4).next();
            if (!VideoMaterialUtil.isEmptyItem(localFaceItem)) {
              if (!TextUtils.isEmpty(localFaceItem.id)) {
                break label276;
              }
            }
          }
          label276:
          for (localObject1 = localFaceItem.faceExchangeImage;; localObject1 = localFaceItem.id)
          {
            this.managers.put(localObject1, new LoadFaceItemManager(this.mCache, this.mGrayCache, ((FaceFeatureItem)localObject3).getDataPath(), localFaceItem, paramInt));
            break label192;
            break;
          }
        }
      }
    }
    Object localObject1 = new ArrayList();
    if (paramVideoMaterial.getItemList() != null) {
      ((List)localObject1).addAll(paramVideoMaterial.getItemList());
    }
    if (paramVideoMaterial.getHeadCropItemList() != null) {
      ((List)localObject1).addAll(paramVideoMaterial.getHeadCropItemList());
    }
    if (paramVideoMaterial.getFabbyParts() != null)
    {
      localObject2 = paramVideoMaterial.getFabbyParts().getParts().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FabbyMvPart)((Iterator)localObject2).next();
        if (((FabbyMvPart)localObject3).bgItem != null) {
          ((List)localObject1).add(((FabbyMvPart)localObject3).bgItem);
        }
        if (((FabbyMvPart)localObject3).fgItem != null) {
          ((List)localObject1).add(((FabbyMvPart)localObject3).fgItem);
        }
        if (((FabbyMvPart)localObject3).coverItem != null) {
          ((List)localObject1).add(((FabbyMvPart)localObject3).coverItem);
        }
        if (((FabbyMvPart)localObject3).transitionItem != null) {
          ((List)localObject1).add(((FabbyMvPart)localObject3).transitionItem);
        }
      }
    }
    if (paramVideoMaterial.getFaceFeatureItemList() != null)
    {
      localObject2 = paramVideoMaterial.getFaceFeatureItemList().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FaceFeatureItem)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((FaceFeatureItem)localObject3).getStickerItems() != null)) {
          ((List)localObject1).addAll(((FaceFeatureItem)localObject3).getStickerItems());
        }
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StickerItem)((Iterator)localObject1).next();
      if ((!this.managers.containsKey(((StickerItem)localObject2).id)) && (!VideoMaterialUtil.isEmptyItem((StickerItem)localObject2))) {
        if (((StickerItem)localObject2).stickerType == VideoFilterFactory.STICKER_TYPE.ETC.type) {
          this.managers.put(((StickerItem)localObject2).id, new LoadETCItemManager(this.mETCCache, paramVideoMaterial.getDataPath(), (StickerItem)localObject2));
        } else {
          this.managers.put(((StickerItem)localObject2).id, new LoadStickerItemManager(this.mCache, paramVideoMaterial.getDataPath(), (StickerItem)localObject2, LoadItemManager.LOAD_TYPE.LOAD_ALL, paramInt));
        }
      }
    }
    Object localObject2 = paramVideoMaterial.getItemList3D();
    if (localObject2 != null)
    {
      if ((paramVideoMaterial.getGameParams() != null) && (paramVideoMaterial.getGameParams().textureImages != null)) {
        this.managers.put("", new Load3DTextureManager(paramVideoMaterial.getDataPath(), paramVideoMaterial.getGameParams().textureImages));
      }
      localObject1 = new HashSet();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (StickerItem3D)((Iterator)localObject2).next();
        if (((StickerItem3D)localObject3).id.contains(":"))
        {
          localObject4 = ((StickerItem3D)localObject3).id.split(":");
          if (localObject4.length == 2)
          {
            localObject4 = localObject4[1];
            if (!((Set)localObject1).contains(localObject4))
            {
              this.managers.put(((StickerItem3D)localObject3).id, new LoadStickerItemManager3D(paramVideoMaterial.getDataPath(), (StickerItem3D)localObject3, (String)localObject4, LoadItemManager.LOAD_TYPE.LOAD_ALL));
              ((Set)localObject1).add(localObject4);
            }
          }
        }
      }
    }
    AppMethodBeat.o(81836);
  }
  
  private void loadImportMaterial(VideoMaterial paramVideoMaterial, int paramInt)
  {
    AppMethodBeat.i(81835);
    paramVideoMaterial = paramVideoMaterial.getMultiViewerItemList().iterator();
    while (paramVideoMaterial.hasNext())
    {
      MultiViewerItem localMultiViewerItem = (MultiViewerItem)paramVideoMaterial.next();
      if (localMultiViewerItem != null) {
        loadAllItemsAppend(localMultiViewerItem.videoMaterial, paramInt);
      }
    }
    AppMethodBeat.o(81835);
  }
  
  public void clear()
  {
    AppMethodBeat.i(81843);
    ??? = this.managers.values().iterator();
    while (((Iterator)???).hasNext()) {
      ((LoadItemManager)((Iterator)???).next()).clear();
    }
    this.managers.clear();
    Bitmap localBitmap;
    synchronized (PreLoader.LOCK_IMAGE_PRE_LOADER)
    {
      Iterator localIterator1 = this.mCache.values().iterator();
      while (localIterator1.hasNext())
      {
        localBitmap = (Bitmap)localIterator1.next();
        if (BitmapUtils.isLegal(localBitmap)) {
          localBitmap.recycle();
        }
      }
    }
    Iterator localIterator2 = this.mGrayCache.values().iterator();
    while (localIterator2.hasNext())
    {
      localBitmap = (Bitmap)localIterator2.next();
      if (BitmapUtils.isLegal(localBitmap)) {
        localBitmap.recycle();
      }
    }
    this.mCache.clear();
    this.mGrayCache.clear();
    this.mCurMaterialSizeInMB = 0.0D;
    AppMethodBeat.o(81843);
  }
  
  public Bitmap getBeautyFaceCacheBitmap(String paramString)
  {
    AppMethodBeat.i(81845);
    paramString = (Bitmap)this.mBeautyFaceCache.get(paramString);
    AppMethodBeat.o(81845);
    return paramString;
  }
  
  public double getMaterialSizeInMB()
  {
    return this.mCurMaterialSizeInMB;
  }
  
  public int getSampleSize()
  {
    return this.mSampleSize;
  }
  
  public void loadAllImages(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(81834);
    clear();
    this.mHandler.post(new VideoMemoryManager.1(this, paramVideoMaterial));
    AppMethodBeat.o(81834);
  }
  
  public void loadBeautyFaceCacheBitmap(List<String> paramList)
  {
    AppMethodBeat.i(81846);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((!this.mBeautyFaceCache.containsKey(str)) || (BitmapUtils.isLegal((Bitmap)this.mBeautyFaceCache.get(str)))) {}
    }
    AppMethodBeat.o(81846);
  }
  
  public ETC1Util.ETC1Texture loadETCAlphaTexture(String paramString, int paramInt)
  {
    AppMethodBeat.i(81842);
    paramString = (LoadItemManager)this.managers.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.loadETCAlphaTexture(paramInt);
      AppMethodBeat.o(81842);
      return paramString;
    }
    AppMethodBeat.o(81842);
    return null;
  }
  
  public ETC1Util.ETC1Texture loadETCRGBTexture(String paramString, int paramInt)
  {
    AppMethodBeat.i(81841);
    paramString = (LoadItemManager)this.managers.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.loadETCRGBTexture(paramInt);
      AppMethodBeat.o(81841);
      return paramString;
    }
    AppMethodBeat.o(81841);
    return null;
  }
  
  public Bitmap loadImage(FaceOffUtil.FEATURE_TYPE paramFEATURE_TYPE)
  {
    AppMethodBeat.i(81840);
    paramFEATURE_TYPE = (Bitmap)this.mGrayCache.get(paramFEATURE_TYPE);
    AppMethodBeat.o(81840);
    return paramFEATURE_TYPE;
  }
  
  public Bitmap loadImage(String paramString, int paramInt)
  {
    AppMethodBeat.i(81839);
    paramString = (LoadItemManager)this.managers.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.loadImage(paramInt);
      AppMethodBeat.o(81839);
      return paramString;
    }
    AppMethodBeat.o(81839);
    return null;
  }
  
  public Bitmap loadImage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(81838);
    paramString1 = (LoadItemManager)this.managers.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.loadImage(paramString2);
      AppMethodBeat.o(81838);
      return paramString1;
    }
    AppMethodBeat.o(81838);
    return null;
  }
  
  public void reset(String paramString)
  {
    AppMethodBeat.i(81844);
    paramString = (LoadItemManager)this.managers.get(paramString);
    if (paramString != null) {
      paramString.reset();
    }
    AppMethodBeat.o(81844);
  }
  
  public void setMaxPreloadMemorySizeInKB(int paramInt)
  {
    this.mMaxPreloadSizeInKB = paramInt;
  }
  
  public void setSampleSize(int paramInt)
  {
    this.mInitSampleSize = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.cache.VideoMemoryManager
 * JD-Core Version:    0.7.0.1
 */