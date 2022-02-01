package com.tencent.mm.plugin.textstatus.ui.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/span/TextStatusFinderMenuIconSpan;", "Lcom/tencent/mm/ui/widget/FixImageSpan;", "d", "Landroid/graphics/drawable/Drawable;", "verticalAlignment", "", "(Landroid/graphics/drawable/Drawable;I)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.ui.widget.a
{
  public static final a.a TAH;
  private static final int TAI;
  
  static
  {
    AppMethodBeat.i(291643);
    TAH = new a.a((byte)0);
    TAI = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    AppMethodBeat.o(291643);
  }
  
  public a(Drawable paramDrawable)
  {
    super(paramDrawable, 1);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(291655);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4, paramInt5, paramPaint);
    AppMethodBeat.o(291655);
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(291651);
    s.u(paramPaint, "paint");
    paramInt1 = super.getSize(paramPaint, paramCharSequence, paramInt1, paramInt2, paramFontMetricsInt);
    paramInt2 = TAI;
    AppMethodBeat.o(291651);
    return paramInt1 + paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.b.a
 * JD-Core Version:    0.7.0.1
 */