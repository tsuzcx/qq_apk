package com.tencent.mm.plugin.wallet_core.utils;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TextAppearanceSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ar;

public class WcPayTextApppearanceSpan
  extends TextAppearanceSpan
{
  public Typeface PhE = Typeface.DEFAULT;
  public int PhF = 0;
  
  public WcPayTextApppearanceSpan(int paramInt, ColorStateList paramColorStateList)
  {
    super(null, 0, paramInt, paramColorStateList, null);
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(71650);
    super.updateMeasureState(paramTextPaint);
    switch (this.PhF)
    {
    case 2: 
    default: 
      this.PhF = 0;
    }
    for (;;)
    {
      paramTextPaint.setTypeface(Typeface.create(this.PhE, this.PhF));
      AppMethodBeat.o(71650);
      return;
      this.PhF = 1;
      continue;
      ar.a(paramTextPaint, 0.8F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.WcPayTextApppearanceSpan
 * JD-Core Version:    0.7.0.1
 */