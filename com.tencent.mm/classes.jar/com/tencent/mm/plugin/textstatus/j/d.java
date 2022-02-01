package com.tencent.mm.plugin.textstatus.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/util/TextStatusIconSpan;", "Lcom/tencent/mm/ui/widget/FixImageSpan;", "d", "Landroid/graphics/drawable/Drawable;", "verticalAlignment", "", "(Landroid/graphics/drawable/Drawable;I)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "Companion", "plugin-textstatus_release"})
public final class d
  extends com.tencent.mm.ui.widget.a
{
  private static final int Ggg;
  public static final a Ggh;
  
  static
  {
    AppMethodBeat.i(216697);
    Ggh = new a((byte)0);
    Ggg = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    AppMethodBeat.o(216697);
  }
  
  public d(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(216696);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat + Ggg, paramInt3, paramInt4, paramInt5, paramPaint);
    AppMethodBeat.o(216696);
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(216695);
    p.h(paramPaint, "paint");
    paramInt1 = super.getSize(paramPaint, paramCharSequence, paramInt1, paramInt2, paramFontMetricsInt);
    paramInt2 = Ggg;
    AppMethodBeat.o(216695);
    return paramInt1 + paramInt2;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/util/TextStatusIconSpan$Companion;", "", "()V", "PADDING", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.j.d
 * JD-Core Version:    0.7.0.1
 */