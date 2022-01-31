package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import com.tencent.ttpic.util.BenchUtil;

public class ImageWMElement
  extends WMElement
{
  private static final String TAG = ImageWMElement.class.getSimpleName();
  private long firstTimestamp;
  private boolean loadImageSuccess;
  
  private int getFrameIndex(long paramLong)
  {
    if (this.firstTimestamp <= 0L) {
      this.firstTimestamp = paramLong;
    }
    if (this.frames <= 0) {
      return 0;
    }
    return (int)((paramLong - this.firstTimestamp) / this.frameDuration) % this.frames;
  }
  
  private String getValue(int paramInt)
  {
    if (!TextUtils.isEmpty(this.userValue)) {
      return this.userValue;
    }
    String str1 = "";
    if (this.imgPath != null) {
      str1 = new String(this.imgPath);
    }
    String str2 = str1;
    if (this.logic != null) {
      str2 = str1.replace("[logic]", this.logic.getValue(this.userValue));
    }
    return LogicDataManager.getInstance().replaceWithData(str2, this.dataKeys).replace("%d", String.valueOf(paramInt));
  }
  
  private boolean needUpdateImage()
  {
    return (!this.curValue.equals(this.lastValue)) || (!this.loadImageSuccess) || (!TextUtils.isEmpty(this.animateType));
  }
  
  public Bitmap getBitmap()
  {
    this.lastValue = this.curValue;
    this.isContentChanged = false;
    return super.getBitmap();
  }
  
  public void init()
  {
    super.init();
    this.curValue = getValue(0);
  }
  
  public boolean isContentChanged()
  {
    return this.isContentChanged;
  }
  
  public void reset()
  {
    this.firstTimestamp = 0L;
  }
  
  public void updateBitmap(long paramLong)
  {
    BenchUtil.benchStart("ImageUpdateBitmap");
    this.curValue = getValue(getFrameIndex(paramLong));
    if (needUpdateImage())
    {
      Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(this.itemId, this.curValue);
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        break label73;
      }
      this.bitmap = localBitmap;
      this.loadImageSuccess = true;
      this.isContentChanged = true;
    }
    for (;;)
    {
      BenchUtil.benchEnd("ImageUpdateBitmap");
      return;
      label73:
      this.loadImageSuccess = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.model.ImageWMElement
 * JD-Core Version:    0.7.0.1
 */