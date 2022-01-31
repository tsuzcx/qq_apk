package com.tencent.ttpic.util;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import com.tencent.ttpic.model.TextWMElement;

abstract class WMTextDrawer$TextLayout
{
  protected TextPaint mPaint;
  protected String mSource;
  protected TextWMElement mWMElement;
  
  protected WMTextDrawer$TextLayout(WMTextDrawer paramWMTextDrawer, String paramString, TextPaint paramTextPaint, TextWMElement paramTextWMElement)
  {
    this.mSource = paramString;
    this.mPaint = paramTextPaint;
    this.mWMElement = paramTextWMElement;
  }
  
  private void drawStroke(Canvas paramCanvas)
  {
    if (this.mWMElement.strokeSize > 0.0F)
    {
      Paint.Style localStyle = this.mPaint.getStyle();
      int i = this.mPaint.getColor();
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setColor(Color.parseColor(this.mWMElement.strokeColor));
      this.mPaint.setStrokeWidth(this.mWMElement.strokeSize * (this.mPaint.getTextSize() / 20.0F) * 1.2F);
      drawText(paramCanvas);
      this.mPaint.setStyle(localStyle);
      this.mPaint.setColor(i);
      this.mPaint.setStrokeWidth(0.0F);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    drawStroke(paramCanvas);
    fitText();
    drawText(paramCanvas);
  }
  
  protected abstract void drawText(Canvas paramCanvas);
  
  protected abstract void fitText();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.util.WMTextDrawer.TextLayout
 * JD-Core Version:    0.7.0.1
 */