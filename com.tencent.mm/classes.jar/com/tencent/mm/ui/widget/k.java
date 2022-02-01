package com.tencent.mm.ui.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.text.style.ReplacementSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;

public final class k
  extends ReplacementSpan
{
  private int afVh;
  private int bgColor;
  private int ePP;
  private int mWidth;
  private final int padding;
  private final Paint rsW;
  private int textColor;
  private int textSize;
  
  public k(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(251554);
    this.textColor = -1;
    this.bgColor = -1;
    this.textSize = -1;
    this.afVh = -1;
    this.ePP = 0;
    this.padding = a.fromDPToPix(MMApplicationContext.getContext(), 4);
    this.textColor = paramInt1;
    this.bgColor = paramInt2;
    this.ePP = paramInt4;
    this.textSize = 12;
    this.afVh = paramInt3;
    this.rsW = new Paint();
    this.rsW.setStyle(Paint.Style.FILL);
    this.rsW.setColor(this.bgColor);
    this.rsW.setAntiAlias(true);
    AppMethodBeat.o(251554);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(251565);
    paramInt3 = paramInt5 - paramInt3;
    if (paramInt3 > this.afVh) {}
    for (paramInt3 = (paramInt3 - this.afVh) / 2;; paramInt3 = 0)
    {
      paramCanvas.drawRoundRect(paramFloat, paramInt3, paramFloat + this.mWidth, this.afVh + paramInt3, this.ePP, this.ePP, this.rsW);
      paramInt4 = paramPaint.getColor();
      float f1 = paramPaint.getTextSize();
      paramPaint.setColor(this.textColor);
      paramPaint.setTextSize(a.fromDPToPix(MMApplicationContext.getContext(), this.textSize));
      float f2 = Math.abs(paramPaint.ascent() + paramPaint.descent()) / 2.0F;
      float f3 = this.afVh / 2;
      float f4 = paramInt3;
      aw.a(paramPaint, 0.8F);
      paramCanvas.drawText(paramCharSequence.subSequence(paramInt1, paramInt2).toString(), this.padding + paramFloat, f2 + f3 + f4, paramPaint);
      paramPaint.setColor(paramInt4);
      paramPaint.setTextSize(f1);
      aw.e(paramPaint);
      AppMethodBeat.o(251565);
      return;
    }
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(251559);
    float f = paramPaint.getTextSize();
    paramPaint.setTextSize(a.fromDPToPix(MMApplicationContext.getContext(), this.textSize));
    this.mWidth = ((int)paramPaint.measureText(paramCharSequence, paramInt1, paramInt2) + this.padding * 2);
    paramCharSequence = paramPaint.getFontMetrics();
    if (paramFontMetricsInt != null)
    {
      paramFontMetricsInt.ascent = ((int)paramCharSequence.ascent);
      paramFontMetricsInt.bottom = ((int)paramCharSequence.bottom);
      paramFontMetricsInt.descent = ((int)paramCharSequence.descent);
      paramFontMetricsInt.leading = ((int)paramCharSequence.leading);
      paramFontMetricsInt.top = ((int)paramCharSequence.top);
    }
    paramPaint.setTextSize(f);
    paramInt1 = this.mWidth;
    AppMethodBeat.o(251559);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.k
 * JD-Core Version:    0.7.0.1
 */