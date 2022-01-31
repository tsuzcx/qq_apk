package com.tencent.ttpic.filter;

import com.tencent.filter.m.n;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.WMGroup;

public class WatermarkStaticFilter
  extends StaticStickerFilter
{
  public WatermarkStaticFilter(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    if (this.item.wmGroup != null) {
      this.item.wmGroup.init();
    }
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    if (this.item.wmGroup != null) {
      this.item.wmGroup.clear();
    }
  }
  
  protected void updateTextureParam(int paramInt, long paramLong)
  {
    if (this.item.wmGroup != null)
    {
      this.item.wmGroup.updateTexture(paramLong);
      addParam(new m.n("inputImageTexture2", this.item.wmGroup.getTexture(), 33986));
      this.isImageReady = true;
      return;
    }
    this.isImageReady = false;
    clearTextureParam();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.filter.WatermarkStaticFilter
 * JD-Core Version:    0.7.0.1
 */