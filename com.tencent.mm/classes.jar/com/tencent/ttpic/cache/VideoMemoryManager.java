package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.ttpic.filter.FabbyMvPart;
import com.tencent.ttpic.filter.FabbyParts;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.MultiViewerItem;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoMemoryManager
{
  private static final String TAG = VideoMemoryManager.class.getSimpleName();
  public static final int VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB = 51200;
  public static final int VIDEO_CACHE_MEM_CACHE_REMAIN_SIZE = 10240;
  private static final VideoMemoryManager mInstance = new VideoMemoryManager();
  private final Map<String, Bitmap> mCache = new ConcurrentHashMap();
  private double mCurMaterialSizeInMB;
  private final Map<FaceOffUtil.FEATURE_TYPE, Bitmap> mGrayCache = new ConcurrentHashMap();
  private final Handler mHandler = new Handler(HandlerThreadManager.getInstance().getHanderThread(TAG).getLooper());
  private int mMaxPreloadSizeInKB;
  private int mSampleSize;
  private final Map<String, LoadItemManager> managers = new ConcurrentHashMap();
  
  public static VideoMemoryManager getInstance()
  {
    return mInstance;
  }
  
  private long getMaterialImageSizeInKB(VideoMaterial paramVideoMaterial)
  {
    long l2 = 0L;
    if (paramVideoMaterial == null) {}
    long l1;
    do
    {
      return l2;
      Object localObject1 = new ArrayList();
      if (paramVideoMaterial.getItemList() != null) {
        ((List)localObject1).addAll(paramVideoMaterial.getItemList());
      }
      if (paramVideoMaterial.getHeadCropItemList() != null) {
        ((List)localObject1).addAll(paramVideoMaterial.getHeadCropItemList());
      }
      Object localObject2;
      if (paramVideoMaterial.getFabbyParts() != null)
      {
        localObject2 = paramVideoMaterial.getFabbyParts().getParts().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          FabbyMvPart localFabbyMvPart = (FabbyMvPart)((Iterator)localObject2).next();
          if (localFabbyMvPart.bgItem != null) {
            ((List)localObject1).add(localFabbyMvPart.bgItem);
          }
          if (localFabbyMvPart.fgItem != null) {
            ((List)localObject1).add(localFabbyMvPart.fgItem);
          }
          if (localFabbyMvPart.coverItem != null) {
            ((List)localObject1).add(localFabbyMvPart.coverItem);
          }
          if (localFabbyMvPart.transitionItem != null) {
            ((List)localObject1).add(localFabbyMvPart.transitionItem);
          }
        }
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (StickerItem)((Iterator)localObject1).next();
        l2 = VideoMaterialUtil.getAllImageSize(paramVideoMaterial.getDataPath() + File.separator + ((StickerItem)localObject2).subFolder) / 1024 + l2;
      }
      l1 = l2;
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
      paramVideoMaterial = paramVideoMaterial.getMultiViewerItemList();
      l2 = l1;
    } while (paramVideoMaterial == null);
    paramVideoMaterial = paramVideoMaterial.iterator();
    for (;;)
    {
      l2 = l1;
      if (!paramVideoMaterial.hasNext()) {
        break;
      }
      l1 += getMaterialImageSizeInKB(((MultiViewerItem)paramVideoMaterial.next()).videoMaterial);
    }
  }
  
  private void loadAllItemsAppend(VideoMaterial paramVideoMaterial, int paramInt)
  {
    if (paramVideoMaterial == null) {}
    for (;;)
    {
      return;
      Object localObject2;
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
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (StickerItem)((Iterator)localObject1).next();
        if ((!this.managers.containsKey(((StickerItem)localObject2).id)) && (!VideoMaterialUtil.isEmptyItem((StickerItem)localObject2))) {
          this.managers.put(((StickerItem)localObject2).id, new LoadStickerItemManager(this.mCache, paramVideoMaterial.getDataPath(), (StickerItem)localObject2, LoadItemManager.LOAD_TYPE.LOAD_ALL, paramInt));
        }
      }
      localObject1 = paramVideoMaterial.getItemList3D();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (StickerItem3D)((Iterator)localObject1).next();
          if (((StickerItem3D)localObject2).id.contains(":"))
          {
            localObject3 = ((StickerItem3D)localObject2).id.split(":");
            if (localObject3.length == 2)
            {
              localObject3 = localObject3[1];
              this.managers.put(((StickerItem3D)localObject2).id, new LoadStickerItemManager3D(paramVideoMaterial.getDataPath(), (StickerItem3D)localObject2, (String)localObject3, LoadItemManager.LOAD_TYPE.LOAD_ALL));
            }
          }
        }
      }
    }
  }
  
  private void loadImportMaterial(VideoMaterial paramVideoMaterial, int paramInt)
  {
    paramVideoMaterial = paramVideoMaterial.getMultiViewerItemList();
    if (paramVideoMaterial != null)
    {
      paramVideoMaterial = paramVideoMaterial.iterator();
      while (paramVideoMaterial.hasNext()) {
        loadAllItemsAppend(((MultiViewerItem)paramVideoMaterial.next()).videoMaterial, paramInt);
      }
    }
  }
  
  public void clear()
  {
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
        if (VideoBitmapUtil.isLegal(localBitmap)) {
          localBitmap.recycle();
        }
      }
    }
    Iterator localIterator2 = this.mGrayCache.values().iterator();
    while (localIterator2.hasNext())
    {
      localBitmap = (Bitmap)localIterator2.next();
      if (VideoBitmapUtil.isLegal(localBitmap)) {
        localBitmap.recycle();
      }
    }
    this.mCache.clear();
    this.mGrayCache.clear();
    this.mCurMaterialSizeInMB = 0.0D;
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
    clear();
    this.mHandler.post(new VideoMemoryManager.1(this, paramVideoMaterial));
  }
  
  public Bitmap loadImage(FaceOffUtil.FEATURE_TYPE paramFEATURE_TYPE)
  {
    return (Bitmap)this.mGrayCache.get(paramFEATURE_TYPE);
  }
  
  public Bitmap loadImage(String paramString, int paramInt)
  {
    paramString = (LoadItemManager)this.managers.get(paramString);
    if (paramString != null) {
      return paramString.loadImage(paramInt);
    }
    return null;
  }
  
  public Bitmap loadImage(String paramString1, String paramString2)
  {
    paramString1 = (LoadItemManager)this.managers.get(paramString1);
    if (paramString1 != null) {
      return paramString1.loadImage(paramString2);
    }
    return null;
  }
  
  public void reset(String paramString)
  {
    paramString = (LoadItemManager)this.managers.get(paramString);
    if (paramString != null) {
      paramString.reset();
    }
  }
  
  public void setMaxPreloadMemorySizeInKB(int paramInt)
  {
    this.mMaxPreloadSizeInKB = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.cache.VideoMemoryManager
 * JD-Core Version:    0.7.0.1
 */