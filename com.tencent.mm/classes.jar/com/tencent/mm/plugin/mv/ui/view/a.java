package com.tencent.mm.plugin.mv.ui.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class a
  extends ImageSpan
{
  private WeakReference<Drawable> xCl;
  
  public a(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  private Drawable gro()
  {
    AppMethodBeat.i(286900);
    Object localObject = this.xCl;
    Drawable localDrawable = null;
    if (localObject != null) {
      localDrawable = (Drawable)((WeakReference)localObject).get();
    }
    localObject = localDrawable;
    if (localDrawable == null)
    {
      localObject = getDrawable();
      this.xCl = new WeakReference(localObject);
    }
    AppMethodBeat.o(286900);
    return localObject;
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(286923);
    paramCharSequence = gro();
    paramCanvas.save();
    paramCanvas.translate(paramFloat, paramInt5 - paramCharSequence.getBounds().bottom - paramPaint.getFontMetricsInt().descent / 2);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(286923);
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(286913);
    paramCharSequence = gro().getBounds();
    if (paramFontMetricsInt != null)
    {
      paramPaint = paramPaint.getFontMetricsInt();
      paramFontMetricsInt.ascent = paramPaint.ascent;
      paramFontMetricsInt.descent = paramPaint.descent;
      paramFontMetricsInt.top = paramPaint.top;
      paramFontMetricsInt.bottom = paramPaint.bottom;
    }
    paramInt1 = paramCharSequence.right;
    AppMethodBeat.o(286913);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.a
 * JD-Core Version:    0.7.0.1
 */