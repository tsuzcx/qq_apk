package com.tencent.mm.ui.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class a
  extends ImageSpan
  implements com.tencent.mm.ui.base.span.a
{
  public int Yal = 0;
  public boolean isPressed = false;
  
  public a(Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable, paramInt);
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(143319);
    paramCharSequence = getDrawable();
    paramCanvas.save();
    Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
    paramInt1 = localFontMetricsInt.descent;
    paramInt2 = localFontMetricsInt.ascent;
    paramCanvas.translate(paramFloat, localFontMetricsInt.descent + paramInt4 - (paramInt1 - paramInt2) / 2 - (paramCharSequence.getBounds().bottom - paramCharSequence.getBounds().top) / 2);
    paramInt1 = paramPaint.getAlpha();
    paramInt2 = paramCharSequence.getAlpha();
    if ((paramInt1 == 0) && (paramInt2 != paramInt1)) {
      paramCharSequence.setAlpha(paramInt1);
    }
    paramCharSequence.draw(paramCanvas);
    paramCharSequence.setAlpha(paramInt2);
    paramCanvas.restore();
    AppMethodBeat.o(143319);
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(143318);
    paramCharSequence = getDrawable().getBounds();
    if (paramFontMetricsInt != null)
    {
      paramPaint = paramPaint.getFontMetricsInt();
      paramInt2 = paramPaint.descent;
      int i = paramPaint.ascent;
      paramInt1 = paramCharSequence.bottom - paramCharSequence.top;
      paramInt2 = paramPaint.ascent + (paramInt2 - i) / 2;
      paramFontMetricsInt.ascent = (paramInt2 - paramInt1 / 2);
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = (paramInt2 + paramInt1 / 2);
      paramFontMetricsInt.descent = paramFontMetricsInt.bottom;
    }
    paramInt1 = paramCharSequence.right;
    AppMethodBeat.o(143318);
    return paramInt1;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(203776);
    Log.i("MicroMsg.FixImageSpan", "onClick view:%d", new Object[] { Integer.valueOf(paramView.hashCode()) });
    AppMethodBeat.o(203776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */