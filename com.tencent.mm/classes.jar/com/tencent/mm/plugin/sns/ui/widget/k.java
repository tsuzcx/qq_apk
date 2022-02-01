package com.tencent.mm.plugin.sns.ui.widget;

import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class k
  extends com.tencent.mm.ui.widget.a
{
  public k(Drawable paramDrawable)
  {
    super(paramDrawable, 1);
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(100564);
    int i = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    paramInt1 = super.getSize(paramPaint, paramCharSequence, paramInt1, paramInt2, paramFontMetricsInt);
    AppMethodBeat.o(100564);
    return i + paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.k
 * JD-Core Version:    0.7.0.1
 */