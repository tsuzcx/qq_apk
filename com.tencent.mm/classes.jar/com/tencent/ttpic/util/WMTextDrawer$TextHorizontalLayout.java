package com.tencent.ttpic.util;

import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.ttpic.model.TextWMElement;

class WMTextDrawer$TextHorizontalLayout
  extends WMTextDrawer.TextLayout
{
  public WMTextDrawer$TextHorizontalLayout(WMTextDrawer paramWMTextDrawer, String paramString, TextPaint paramTextPaint, TextWMElement paramTextWMElement)
  {
    super(paramWMTextDrawer, paramString, paramTextPaint, paramTextWMElement);
  }
  
  private float calculateXByAlign(TextWMElement paramTextWMElement, String paramString)
  {
    if ((TextUtils.isEmpty(paramTextWMElement.alignment)) || (paramTextWMElement.alignment.equals("left"))) {}
    do
    {
      return 0.0F;
      if (paramTextWMElement.alignment.equals("center"))
      {
        f = (paramString.length() - 1) * paramTextWMElement.kern;
        return paramTextWMElement.width / 2 - (f + WMTextDrawer.access$000(this.this$0, this.mPaint, paramString, false)) / 2.0F;
      }
    } while (!paramTextWMElement.alignment.equals("right"));
    float f = (paramString.length() - 1) * paramTextWMElement.kern;
    return paramTextWMElement.width - (f + WMTextDrawer.access$000(this.this$0, this.mPaint, paramString, false));
  }
  
  protected void drawText(Canvas paramCanvas)
  {
    Object localObject = this.mPaint.getFontMetrics();
    float f2 = calculateXByAlign(this.mWMElement, this.mSource);
    float f3 = this.mWMElement.height / 2;
    float f4 = ((Paint.FontMetrics)localObject).descent;
    float f5 = (((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent) / 2.0F;
    TextWMElement localTextWMElement = this.mWMElement;
    if ((((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent) / 2.0F > this.mWMElement.height / 2) {}
    for (float f1 = 0.0F;; f1 = this.mWMElement.height / 2 - (((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent) / 2.0F)
    {
      setTextRect(localTextWMElement, f2, f1, this.mSource);
      localObject = new float[this.mSource.length()];
      this.mPaint.getTextWidths(this.mSource, (float[])localObject);
      int i = 0;
      f1 = f2;
      while (i < this.mSource.length())
      {
        paramCanvas.drawText(this.mSource.charAt(i), f1, (f3 - f4 + f5) * 1.05F, this.mPaint);
        f1 += localObject[i] + this.mWMElement.kern;
        i += 1;
      }
    }
  }
  
  protected void fitText()
  {
    int j;
    int k;
    int m;
    int i;
    if (this.mWMElement.fontFit == 0)
    {
      j = this.mWMElement.width;
      k = this.mSource.length();
      m = this.mWMElement.kern;
      i = 1;
    }
    for (;;)
    {
      String str;
      if (i <= this.mSource.length())
      {
        if (WMTextDrawer.access$000(this.this$0, this.mPaint, this.mSource.substring(0, i), false) < j - (k - 1) * m) {
          break label143;
        }
        str = this.mSource;
        if (i - 2 <= 0) {
          break label136;
        }
        i -= 2;
      }
      for (;;)
      {
        this.mSource = str.substring(0, i);
        this.mSource += "...";
        return;
        label136:
        i -= 1;
      }
      label143:
      i += 1;
    }
  }
  
  public void setTextRect(TextWMElement paramTextWMElement, float paramFloat1, float paramFloat2, String paramString)
  {
    if (this.mPaint == null) {
      return;
    }
    float f1 = WMTextDrawer.access$000(this.this$0, this.mPaint, paramString, false);
    float f2 = WMTextDrawer.access$100(this.this$0, this.mPaint, paramString, false);
    paramTextWMElement.mTextRect.left = paramFloat1;
    paramTextWMElement.mTextRect.top = paramFloat2;
    paramTextWMElement.mTextRect.right = (f1 + paramTextWMElement.mTextRect.left + (paramString.length() - 1) * paramTextWMElement.kern);
    paramTextWMElement.mTextRect.bottom = (f2 + paramTextWMElement.mTextRect.top);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.WMTextDrawer.TextHorizontalLayout
 * JD-Core Version:    0.7.0.1
 */