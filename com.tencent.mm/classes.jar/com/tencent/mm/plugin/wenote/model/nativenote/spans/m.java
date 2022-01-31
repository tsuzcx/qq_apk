package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;

public class m
  implements LeadingMarginSpan, f<Boolean>, g<Boolean>
{
  public static float rKD = 0.0F;
  private float lgI = 10.0F;
  private float mWidth;
  private final int rKC;
  private final int rKt;
  public boolean rKu;
  
  private m(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.rKC = paramInt1;
    this.rKt = paramInt2;
    this.rKu = paramBoolean;
  }
  
  public m(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.rKC = paramInt1;
    this.rKt = paramInt2;
    if ((paramBoolean1) && (paramBoolean3) && (!paramBoolean2)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.rKu = paramBoolean1;
      return;
    }
  }
  
  public void drawLeadingMargin(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, CharSequence paramCharSequence, int paramInt6, int paramInt7, boolean paramBoolean, Layout paramLayout)
  {
    paramCharSequence = (Spanned)paramCharSequence;
    if ((!this.rKu) && (paramCharSequence.getSpanStart(this) == paramInt6))
    {
      paramCharSequence = paramPaint.getStyle();
      float f = paramPaint.getTextSize();
      paramPaint.setStyle(Paint.Style.FILL);
      this.lgI = (paramInt4 - paramInt3);
      this.mWidth = paramPaint.measureText(this.rKC + ".");
      paramCanvas.drawText(this.rKC + ".", paramInt1, paramInt4, paramPaint);
      paramPaint.setStyle(paramCharSequence);
      paramPaint.setTextSize(f);
    }
  }
  
  public int getLeadingMargin(boolean paramBoolean)
  {
    if (this.mWidth + 2.0F > rKD) {}
    for (float f = this.mWidth + 2.0F;; f = rKD)
    {
      rKD = Math.max(Math.round(f), this.rKt);
      if (!this.rKu) {
        break;
      }
      return 0;
    }
    return (int)rKD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.m
 * JD-Core Version:    0.7.0.1
 */