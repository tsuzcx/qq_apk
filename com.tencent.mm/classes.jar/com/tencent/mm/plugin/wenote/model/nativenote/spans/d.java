package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  implements LeadingMarginSpan, f<Boolean>, g<Boolean>
{
  private static Path pDK = null;
  private final int pDL;
  public boolean pDM;
  
  private d(int paramInt, boolean paramBoolean)
  {
    this.pDL = paramInt;
    this.pDM = paramBoolean;
  }
  
  public d(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(30631);
    this.pDL = paramInt;
    if ((paramBoolean1) && (paramBoolean3) && (!paramBoolean2)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.pDM = paramBoolean1;
      if (pDK == null) {
        pDK = new Path();
      }
      AppMethodBeat.o(30631);
      return;
    }
  }
  
  public final void drawLeadingMargin(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, CharSequence paramCharSequence, int paramInt6, int paramInt7, boolean paramBoolean, Layout paramLayout)
  {
    AppMethodBeat.i(30632);
    paramCharSequence = (Spanned)paramCharSequence;
    if ((!this.pDM) && (paramCharSequence.getSpanStart(this) == paramInt6))
    {
      paramCharSequence = paramPaint.getStyle();
      paramPaint.setStyle(Paint.Style.FILL);
      pDK.reset();
      pDK.addCircle(0.0F, 0.0F, 6.0F, Path.Direction.CW);
      paramLayout = paramPaint.getFontMetricsInt();
      paramInt3 = paramLayout.descent;
      paramInt3 = (paramLayout.ascent + (paramInt3 + paramInt4 + paramInt4)) / 2;
      paramCanvas.save();
      paramCanvas.translate(paramInt2 * 6 + paramInt1, paramInt3);
      paramCanvas.drawPath(pDK, paramPaint);
      paramCanvas.restore();
      paramPaint.setStyle(paramCharSequence);
    }
    AppMethodBeat.o(30632);
  }
  
  public final int getLeadingMargin(boolean paramBoolean)
  {
    if (this.pDM) {
      return 0;
    }
    return this.pDL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.d
 * JD-Core Version:    0.7.0.1
 */