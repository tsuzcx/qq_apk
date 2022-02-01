package com.tencent.mm.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/FixCenteredImageSpan;", "Lcom/tencent/mm/ui/widget/FixImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "cachedDrawable", "getCachedDrawable", "()Landroid/graphics/drawable/Drawable;", "mDrawableRef", "Ljava/lang/ref/WeakReference;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends a
{
  private WeakReference<Drawable> xCl;
  
  public h(Drawable paramDrawable)
  {
    super(paramDrawable, 0);
    AppMethodBeat.i(234680);
    AppMethodBeat.o(234680);
  }
  
  private final Drawable gro()
  {
    AppMethodBeat.i(234684);
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
    AppMethodBeat.o(234684);
    return localObject;
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(234693);
    s.u(paramCanvas, "canvas");
    s.u(paramCharSequence, "text");
    s.u(paramPaint, "paint");
    paramCharSequence = gro();
    if (paramCharSequence != null)
    {
      paramCanvas.save();
      paramCanvas.translate(paramFloat, paramInt5 - paramCharSequence.getBounds().bottom - paramPaint.getFontMetricsInt().descent / 2);
      paramCharSequence.draw(paramCanvas);
      paramCanvas.restore();
    }
    AppMethodBeat.o(234693);
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(234689);
    s.u(paramPaint, "paint");
    paramCharSequence = gro();
    if (paramCharSequence == null) {}
    for (paramCharSequence = null;; paramCharSequence = paramCharSequence.getBounds())
    {
      if (paramFontMetricsInt != null)
      {
        paramPaint = paramPaint.getFontMetricsInt();
        paramFontMetricsInt.ascent = paramPaint.ascent;
        paramFontMetricsInt.descent = paramPaint.descent;
        paramFontMetricsInt.top = paramPaint.top;
        paramFontMetricsInt.bottom = paramPaint.bottom;
      }
      if (paramCharSequence != null) {
        break;
      }
      AppMethodBeat.o(234689);
      return 0;
    }
    paramInt1 = paramCharSequence.right;
    AppMethodBeat.o(234689);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.h
 * JD-Core Version:    0.7.0.1
 */