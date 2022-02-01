package com.tencent.mm.plugin.textstatus.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusFinderMenuIconSpan;", "Lcom/tencent/mm/ui/widget/FixImageSpan;", "d", "Landroid/graphics/drawable/Drawable;", "verticalAlignment", "", "(Landroid/graphics/drawable/Drawable;I)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "Companion", "plugin-textstatus_release"})
public final class m
  extends com.tencent.mm.ui.widget.a
{
  private static final int MMY;
  public static final a MMZ;
  
  static
  {
    AppMethodBeat.i(232447);
    MMZ = new a((byte)0);
    MMY = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    AppMethodBeat.o(232447);
  }
  
  public m(Drawable paramDrawable)
  {
    super(paramDrawable, 1);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(232446);
    p.k(paramCanvas, "canvas");
    p.k(paramPaint, "paint");
    super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4, paramInt5, paramPaint);
    AppMethodBeat.o(232446);
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(232445);
    p.k(paramPaint, "paint");
    paramInt1 = super.getSize(paramPaint, paramCharSequence, paramInt1, paramInt2, paramFontMetricsInt);
    paramInt2 = MMY;
    AppMethodBeat.o(232445);
    return paramInt1 + paramInt2;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusFinderMenuIconSpan$Companion;", "", "()V", "PADDING", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.m
 * JD-Core Version:    0.7.0.1
 */