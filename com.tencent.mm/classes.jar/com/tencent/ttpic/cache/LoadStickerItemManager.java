package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.thread.VideoThreadPool;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LoadStickerItemManager
  implements LoadItemManager
{
  private static final int CAPACITY = 5;
  public static final Comparator<String> mPngComperator = new LoadStickerItemManager.1();
  private String dataPath;
  private StickerItem item;
  private LoadItemManager.LOAD_TYPE loadType;
  private Map<String, Bitmap> mCache;
  private AsyncTask<Void, Integer, Boolean> mImageTask;
  private PreLoader mPreLoader;
  private int sampleSize;
  
  public LoadStickerItemManager(Map<String, Bitmap> paramMap, String paramString, StickerItem paramStickerItem, LoadItemManager.LOAD_TYPE paramLOAD_TYPE, int paramInt)
  {
    this.dataPath = paramString;
    this.item = paramStickerItem;
    this.mCache = paramMap;
    this.sampleSize = paramInt;
    if (paramStickerItem.markMode != 0)
    {
      this.loadType = LoadItemManager.LOAD_TYPE.LOAD_ALL;
      return;
    }
    this.loadType = paramLOAD_TYPE;
  }
  
  public void clear()
  {
    if (this.mImageTask != null) {
      this.mImageTask.cancel(true);
    }
    if (this.mPreLoader != null) {
      this.mPreLoader.clear();
    }
  }
  
  public Bitmap loadImage(int paramInt)
  {
    if (this.mPreLoader != null) {
      this.mPreLoader.updateIndex(paramInt);
    }
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
    if (this.loadType == LoadItemManager.LOAD_TYPE.LOAD_ALL) {
      if (this.item.sourceType == VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE)
      {
        localHashSet = new HashSet();
        localArrayList = new ArrayList(this.item.frames);
        if (this.item.markMode != 0)
        {
          i = 0;
          while (i <= 10)
          {
            j = 0;
            while (j < this.item.frames)
            {
              localArrayList.add(this.item.id + "_" + j + "_" + i + ".png");
              j += 1;
            }
            i += 1;
          }
          i = 0;
          while (i < this.item.frames)
          {
            localArrayList.add(this.item.id + "_" + i + "_x.png");
            i += 1;
          }
        }
        localHashSet.addAll(VideoFileUtil.getAllPngFileNames(this.dataPath + File.separator + this.item.subFolder));
        i = 0;
        while (i < this.item.frames)
        {
          localHashSet.add(this.item.id + "_" + i + ".png");
          i += 1;
        }
        localArrayList.addAll(localHashSet);
        Collections.sort(localArrayList, mPngComperator);
        this.mImageTask = new LoadImageTask(this.mCache, localArrayList, this.dataPath + File.separator + this.item.subFolder, VideoMaterialUtil.getMaterialId(this.dataPath), this.sampleSize);
        this.mImageTask.executeOnExecutor(VideoThreadPool.getInstance().getDualThreadExecutor(), new Void[0]);
      }
    }
    while (this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE)
    {
      HashSet localHashSet;
      ArrayList localArrayList;
      int i;
      int j;
      return;
    }
    this.mPreLoader = new ImagePreLoader(this.mCache, this.dataPath, this.item, 5);
    this.mPreLoader.prepare();
  }
  
  public void reset()
  {
    if (this.mPreLoader != null) {
      this.mPreLoader.reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadStickerItemManager
 * JD-Core Version:    0.7.0.1
 */