package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.WMTextDrawer;

public class TextWMElement
  extends WMElement
{
  public RectF mTextRect = new RectF();
  public int rotate = 0;
  public WMTextDrawer wmTextDrawer = new WMTextDrawer();
  
  private String getValue()
  {
    if ((this.userValue != null) && (!isDateWatermark())) {
      return this.userValue;
    }
    String str1 = "";
    if (this.fmtstr != null) {
      str1 = new String(this.fmtstr);
    }
    String str2 = str1;
    if (this.logic != null) {
      str2 = str1.replace("[logic]", this.logic.getValue(this.userValue));
    }
    BenchUtil.benchStart("replaceWithData");
    str1 = LogicDataManager.getInstance().replaceWithData(str2, this.dataKeys);
    BenchUtil.benchEnd("replaceWithData");
    return str1;
  }
  
  private boolean isDateWatermark()
  {
    return (this.logic != null) && (this.logic.type != null) && ((this.logic.type.equals("since")) || (this.logic.type.equals("countdown")));
  }
  
  private boolean needUpdateTextBitmap()
  {
    return ((this.curValue != null) && (!this.curValue.equals(this.lastValue))) || (!TextUtils.isEmpty(this.animateType));
  }
  
  public Bitmap getBitmap()
  {
    this.isContentChanged = false;
    return super.getBitmap();
  }
  
  public RectF getTextRect()
  {
    return this.mTextRect;
  }
  
  public void init()
  {
    super.init();
    if (this.vertical == 2) {
      this.rotate = 90;
    }
    for (;;)
    {
      this.curValue = getValue();
      return;
      if (this.vertical == 3) {
        this.rotate = -90;
      }
    }
  }
  
  public boolean isContentChanged()
  {
    return this.isContentChanged;
  }
  
  public void updateBitmap(long paramLong)
  {
    BenchUtil.benchStart("TextUpdateBitmap");
    this.curValue = getValue();
    if ((this.curValue != null) && (needUpdateTextBitmap()))
    {
      this.wmTextDrawer.drawTextToBitmap(this, this.curValue);
      this.isContentChanged = true;
    }
    this.lastValue = this.curValue;
    BenchUtil.benchEnd("TextUpdateBitmap");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.model.TextWMElement
 * JD-Core Version:    0.7.0.1
 */