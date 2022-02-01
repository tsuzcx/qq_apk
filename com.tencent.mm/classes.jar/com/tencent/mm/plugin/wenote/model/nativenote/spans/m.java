package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class m
  implements LeadingMarginSpan, f<Boolean>, g<Boolean>
{
  public static float xBM = 0.0F;
  private float mWidth;
  private final int xBG;
  public boolean xBH;
  private final int xBK;
  private float xBL;
  
  private m(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.xBL = 10.0F;
    this.xBK = paramInt1;
    this.xBG = paramInt2;
    this.xBH = paramBoolean;
  }
  
  public m(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(30648);
    this.xBL = 10.0F;
    this.xBK = paramInt1;
    this.xBG = paramInt2;
    if ((paramBoolean1) && (paramBoolean3) && (!paramBoolean2)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.xBH = paramBoolean1;
      AppMethodBeat.o(30648);
      return;
    }
  }
  
  public void drawLeadingMargin(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, CharSequence paramCharSequence, int paramInt6, int paramInt7, boolean paramBoolean, Layout paramLayout)
  {
    AppMethodBeat.i(30650);
    paramCharSequence = (Spanned)paramCharSequence;
    if ((!this.xBH) && (paramCharSequence.getSpanStart(this) == paramInt6))
    {
      paramCharSequence = paramPaint.getStyle();
      float f = paramPaint.getTextSize();
      paramPaint.setStyle(Paint.Style.FILL);
      this.xBL = (paramInt4 - paramInt3);
      this.mWidth = paramPaint.measureText(this.xBK + ".");
      paramCanvas.drawText(this.xBK + ".", paramInt1, paramInt4, paramPaint);
      paramPaint.setStyle(paramCharSequence);
      paramPaint.setTextSize(f);
    }
    AppMethodBeat.o(30650);
  }
  
  public int getLeadingMargin(boolean paramBoolean)
  {
    AppMethodBeat.i(30649);
    if (this.mWidth + 2.0F > xBM) {}
    for (float f = this.mWidth + 2.0F;; f = xBM)
    {
      xBM = Math.max(Math.round(f), this.xBG);
      if (!this.xBH) {
        break;
      }
      AppMethodBeat.o(30649);
      return 0;
    }
    int i = (int)xBM;
    AppMethodBeat.o(30649);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.m
 * JD-Core Version:    0.7.0.1
 */