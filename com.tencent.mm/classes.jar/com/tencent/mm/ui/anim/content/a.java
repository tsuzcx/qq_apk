package com.tencent.mm.ui.anim.content;

import android.graphics.Paint.FontMetricsInt;
import android.text.TextPaint;
import android.text.style.LineHeightSpan.WithDensity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/anim/content/FixLineSpaceSpan;", "Landroid/text/style/LineHeightSpan$WithDensity;", "()V", "chooseHeight", "", "text", "", "start", "", "end", "spanstartv", "lineHeight", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "paint", "Landroid/text/TextPaint;", "Companion", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements LineHeightSpan.WithDensity
{
  public static final a.a adMr;
  
  static
  {
    AppMethodBeat.i(251220);
    adMr = new a.a((byte)0);
    AppMethodBeat.o(251220);
  }
  
  public final void chooseHeight(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint.FontMetricsInt paramFontMetricsInt) {}
  
  public final void chooseHeight(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint.FontMetricsInt paramFontMetricsInt, TextPaint paramTextPaint)
  {
    paramInt2 = 0;
    AppMethodBeat.i(251228);
    if (paramFontMetricsInt == null)
    {
      paramInt1 = 0;
      if (paramFontMetricsInt != null) {
        break label93;
      }
      label19:
      paramInt2 = paramInt1 - paramInt2;
      if (paramTextPaint != null) {
        break label102;
      }
    }
    label93:
    label102:
    for (paramInt1 = -1;; paramInt1 = kotlin.h.a.eH(paramTextPaint.getTextSize() * 1.45F))
    {
      if (paramInt1 != paramInt2)
      {
        float f = paramInt1 * 1.0F / paramInt2;
        if (paramFontMetricsInt != null)
        {
          paramFontMetricsInt.descent = Math.round(f * paramFontMetricsInt.descent);
          paramFontMetricsInt.ascent = (paramFontMetricsInt.descent - paramInt1);
        }
      }
      AppMethodBeat.o(251228);
      return;
      paramInt1 = paramFontMetricsInt.descent;
      break;
      paramInt2 = paramFontMetricsInt.ascent;
      break label19;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.anim.content.a
 * JD-Core Version:    0.7.0.1
 */