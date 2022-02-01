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
  public static float qTi = 0.0F;
  private float gPN;
  private float mWidth;
  private final int qTd;
  public boolean qTe;
  private final int qTh;
  
  private m(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.gPN = 10.0F;
    this.qTh = paramInt1;
    this.qTd = paramInt2;
    this.qTe = paramBoolean;
  }
  
  public m(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(30648);
    this.gPN = 10.0F;
    this.qTh = paramInt1;
    this.qTd = paramInt2;
    if ((paramBoolean1) && (paramBoolean3) && (!paramBoolean2)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.qTe = paramBoolean1;
      AppMethodBeat.o(30648);
      return;
    }
  }
  
  public void drawLeadingMargin(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, CharSequence paramCharSequence, int paramInt6, int paramInt7, boolean paramBoolean, Layout paramLayout)
  {
    AppMethodBeat.i(30650);
    paramCharSequence = (Spanned)paramCharSequence;
    if ((!this.qTe) && (paramCharSequence.getSpanStart(this) == paramInt6))
    {
      paramCharSequence = paramPaint.getStyle();
      float f = paramPaint.getTextSize();
      paramPaint.setStyle(Paint.Style.FILL);
      this.gPN = (paramInt4 - paramInt3);
      this.mWidth = paramPaint.measureText(this.qTh + ".");
      paramCanvas.drawText(this.qTh + ".", paramInt1, paramInt4, paramPaint);
      paramPaint.setStyle(paramCharSequence);
      paramPaint.setTextSize(f);
    }
    AppMethodBeat.o(30650);
  }
  
  public int getLeadingMargin(boolean paramBoolean)
  {
    AppMethodBeat.i(30649);
    if (this.mWidth + 2.0F > qTi) {}
    for (float f = this.mWidth + 2.0F;; f = qTi)
    {
      qTi = Math.max(Math.round(f), this.qTd);
      if (!this.qTe) {
        break;
      }
      AppMethodBeat.o(30649);
      return 0;
    }
    int i = (int)qTi;
    AppMethodBeat.o(30649);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.m
 * JD-Core Version:    0.7.0.1
 */