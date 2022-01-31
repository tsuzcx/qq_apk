package com.tencent.ttpic.util;

import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.ttpic.model.TextWMElement;

class WMTextDrawer$TextVerticalLayout
  extends WMTextDrawer.TextLayout
{
  public WMTextDrawer$TextVerticalLayout(WMTextDrawer paramWMTextDrawer, String paramString, TextPaint paramTextPaint, TextWMElement paramTextWMElement)
  {
    super(paramWMTextDrawer, paramString, paramTextPaint, paramTextWMElement);
  }
  
  private float calculateYByAlign(TextWMElement paramTextWMElement, float paramFloat, int paramInt, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if ((!TextUtils.isEmpty(paramTextWMElement.alignment)) && (!TextUtils.isEmpty(paramTextWMElement.alignment)))
    {
      if (this.mWMElement.alignment.equals("center")) {
        return (this.mWMElement.height + paramFontMetricsInt.ascent - (paramInt - 1) * paramFloat) / 2.0F;
      }
      if (this.mWMElement.alignment.equals("down")) {
        return this.mWMElement.height + paramFontMetricsInt.ascent - (paramInt - 1) * paramFloat;
      }
      return -paramFontMetricsInt.ascent;
    }
    return 0.0F;
  }
  
  protected void drawText(Canvas paramCanvas)
  {
    Object localObject = this.mPaint.getFontMetricsInt();
    Rect localRect = new Rect();
    this.mPaint.getTextBounds(this.mSource, 0, this.mSource.length(), localRect);
    int j = localRect.height();
    int i = this.mSource.length();
    float f2 = this.mWMElement.width / 2;
    float f1 = calculateYByAlign(this.mWMElement, j, i, (Paint.FontMetricsInt)localObject);
    setTextRect(this.mWMElement, f2, f1, j, this.mSource, (Paint.FontMetricsInt)localObject);
    paramCanvas.save();
    i = 0;
    while (i < this.mSource.length())
    {
      localObject = this.mSource.substring(i, i + 1);
      paramCanvas.rotate(this.mWMElement.rotate, f2, f1);
      paramCanvas.drawText((String)localObject, 0, ((String)localObject).length(), f2, f1, this.mPaint);
      paramCanvas.rotate(-this.mWMElement.rotate, f2, f1);
      f1 += this.mWMElement.kern + j;
      i += 1;
    }
    paramCanvas.restore();
  }
  
  protected void fitText()
  {
    if (this.mWMElement.fontFit == 0)
    {
      Rect localRect = new Rect();
      this.mPaint.getTextBounds(this.mSource, 0, this.mSource.length(), localRect);
      int i = localRect.height();
      int j = this.mSource.length();
      int k = this.mWMElement.height - (j - 1) * this.mWMElement.kern;
      if (j * i > k)
      {
        j = k / i - 3;
        i = j;
        if (j < 0) {
          i = 0;
        }
        this.mSource = this.mSource.substring(0, i);
        this.mSource += "...";
      }
    }
  }
  
  public void setTextRect(TextWMElement paramTextWMElement, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (this.mPaint == null) {
      return;
    }
    float[] arrayOfFloat = new float[paramString.length()];
    this.mPaint.getTextWidths(paramString, arrayOfFloat);
    float f1 = 0.0F;
    int i = 0;
    while (i < arrayOfFloat.length)
    {
      float f2 = f1;
      if (arrayOfFloat[i] > f1) {
        f2 = arrayOfFloat[i];
      }
      i += 1;
      f1 = f2;
    }
    paramTextWMElement.mTextRect.left = paramFloat1;
    paramTextWMElement.mTextRect.top = (paramFontMetricsInt.ascent + paramFloat2);
    paramTextWMElement.mTextRect.right = (f1 + paramTextWMElement.mTextRect.left);
    paramTextWMElement.mTextRect.bottom = (paramTextWMElement.mTextRect.top + paramString.length() * paramFloat3 + (paramString.length() - 1) * paramTextWMElement.kern);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.WMTextDrawer.TextVerticalLayout
 * JD-Core Version:    0.7.0.1
 */