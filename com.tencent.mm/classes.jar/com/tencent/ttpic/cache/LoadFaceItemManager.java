package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.thread.VideoThreadPool;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LoadFaceItemManager
  implements LoadItemManager
{
  private final String dataPath;
  private final FaceItem item;
  private final Map<String, Bitmap> mCache;
  private AsyncTask<Void, Integer, Boolean> mFaceImageTask;
  private final Map<FaceOffUtil.FEATURE_TYPE, Bitmap> mGrayCache;
  private AsyncTask<Void, Integer, Boolean> mGrayImageTask;
  private AsyncTask<Void, Integer, Boolean> mImageTask;
  private final int sampleSize;
  
  public LoadFaceItemManager(Map<String, Bitmap> paramMap, Map<FaceOffUtil.FEATURE_TYPE, Bitmap> paramMap1, String paramString, FaceItem paramFaceItem, int paramInt)
  {
    this.dataPath = paramString;
    this.item = paramFaceItem;
    this.mCache = paramMap;
    this.mGrayCache = paramMap1;
    this.sampleSize = paramInt;
  }
  
  public void clear()
  {
    if (this.mImageTask != null) {
      this.mImageTask.cancel(true);
    }
    if (this.mGrayImageTask != null) {
      this.mGrayImageTask.cancel(true);
    }
    if (this.mFaceImageTask != null) {
      this.mFaceImageTask.cancel(true);
    }
  }
  
  public Bitmap loadImage(int paramInt)
  {
    String str = VideoMaterialUtil.getMaterialId(this.dataPath) + File.separator + this.item.id + "_" + paramInt + ".png";
    return (Bitmap)this.mCache.get(str);
  }
  
  public Bitmap loadImage(String paramString)
  {
    paramString = VideoMaterialUtil.getMaterialId(this.dataPath) + File.separator + paramString;
    return (Bitmap)this.mCache.get(paramString);
  }
  
  public void prepareImages()
  {
    this.mGrayImageTask = new LoadGrayImageTask(this.mGrayCache, this.item.featureType, this.sampleSize);
    this.mGrayImageTask.executeOnExecutor(VideoThreadPool.getInstance().getDualThreadExecutor(), new Void[0]);
    if (TextUtils.isEmpty(this.item.id))
    {
      this.mFaceImageTask = new LoadImageTask(this.mCache, Collections.singletonList(this.item.faceExchangeImage), this.dataPath, VideoMaterialUtil.getMaterialId(this.dataPath), this.sampleSize);
      this.mFaceImageTask.executeOnExecutor(VideoThreadPool.getInstance().getDualThreadExecutor(), new Void[0]);
      return;
    }
    ArrayList localArrayList = new ArrayList(this.item.frames);
    int i = 0;
    while (i < this.item.frames)
    {
      localArrayList.add(this.item.id + "_" + i + ".png");
      i += 1;
    }
    this.mImageTask = new LoadImageTask(this.mCache, localArrayList, this.dataPath + File.separator + this.item.id, VideoMaterialUtil.getMaterialId(this.dataPath), this.sampleSize);
    this.mImageTask.executeOnExecutor(VideoThreadPool.getInstance().getDualThreadExecutor(), new Void[0]);
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadFaceItemManager
 * JD-Core Version:    0.7.0.1
 */