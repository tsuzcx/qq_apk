package com.tencent.mm.plugin.sns.ui.widget;

import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class g
  extends com.tencent.mm.ui.widget.a
{
  public g(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(40524);
    int i = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 4);
    paramInt1 = super.getSize(paramPaint, paramCharSequence, paramInt1, paramInt2, paramFontMetricsInt);
    AppMethodBeat.o(40524);
    return i + paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */