package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.VideoPngDecoder;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.thread.VideoThreadPool;
import com.tencent.ttpic.util.VideoBitmapUtil;
import java.io.File;
import java.util.Map;

public class VideoPreLoader
  extends PreLoader
{
  private static final String TAG = VideoPreLoader.class.getSimpleName();
  private int curFrameIndex;
  private volatile boolean stop;
  private VideoPngDecoder videoPngDecoder;
  
  public VideoPreLoader(Map<String, Bitmap> paramMap, String paramString, StickerItem paramStickerItem, int paramInt)
  {
    super(paramMap, paramString, paramStickerItem, paramInt);
  }
  
  private boolean isInRange(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 <= paramInt2) {
      if ((paramInt1 > paramInt3) || (paramInt3 > paramInt2)) {}
    }
    while ((paramInt3 <= paramInt2) || (paramInt1 <= paramInt3))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void clear()
  {
    this.stop = true;
    VideoThreadPool.getInstance().submit(new VideoPreLoader.1(this));
  }
  
  public void preloadNewImages(int paramInt)
  {
    if (this.stop) {
      return;
    }
    this.frontIndex = paramInt;
    this.rearIndex = ((this.frontIndex + this.capacity) % this.item.frames);
    new StringBuilder("item.id = ").append(this.item.id).append(", frontIndex = ").append(this.frontIndex).append(", rearIndex = ").append(this.rearIndex);
    label78:
    Bitmap localBitmap;
    String str;
    if (this.curFrameIndex != this.rearIndex)
    {
      if (this.videoPngDecoder.pG())
      {
        this.videoPngDecoder.release();
        this.videoPngDecoder = new VideoPngDecoder(this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + ".mp4");
        this.curFrameIndex = 0;
      }
      new StringBuilder("    i = ").append(this.curFrameIndex);
      localBitmap = this.videoPngDecoder.dZ(1);
      if (isInRange(this.frontIndex, this.rearIndex, this.curFrameIndex))
      {
        str = this.item.id + "_" + this.curFrameIndex + ".png";
        if (!TextUtils.isEmpty(this.materialId)) {
          break label309;
        }
      }
    }
    for (;;)
    {
      if (VideoBitmapUtil.isLegal(localBitmap)) {
        this.cache.put(str, localBitmap);
      }
      this.curFrameIndex = ((this.curFrameIndex + 1) % this.item.frames);
      break label78;
      break;
      label309:
      str = this.materialId + File.separator + str;
    }
  }
  
  public void prepareImages()
  {
    try
    {
      this.frontIndex = 0;
      this.videoPngDecoder = new VideoPngDecoder(this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + ".mp4");
      int i = 0;
      if ((i < this.capacity) && (!this.videoPngDecoder.pG()))
      {
        Bitmap localBitmap = this.videoPngDecoder.dZ(1);
        String str = this.item.id + "_" + i + ".png";
        if (TextUtils.isEmpty(this.materialId)) {}
        for (;;)
        {
          if (VideoBitmapUtil.isLegal(localBitmap)) {
            this.cache.put(str, localBitmap);
          }
          int j = i + 1;
          this.curFrameIndex = j;
          this.rearIndex = j;
          i += 1;
          break;
          str = this.materialId + File.separator + str;
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.cache.VideoPreLoader
 * JD-Core Version:    0.7.0.1
 */