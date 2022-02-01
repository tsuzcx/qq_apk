package com.tencent.mm.plugin.wallet_core.utils;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TextAppearanceSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WcPayTextApppearanceSpan
  extends TextAppearanceSpan
{
  Typeface Dof;
  
  public WcPayTextApppearanceSpan(int paramInt, ColorStateList paramColorStateList)
  {
    super(null, 0, paramInt, paramColorStateList, null);
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(71650);
    super.updateMeasureState(paramTextPaint);
    if (this.Dof != null) {
      paramTextPaint.setTypeface(this.Dof);
    }
    AppMethodBeat.o(71650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.WcPayTextApppearanceSpan
 * JD-Core Version:    0.7.0.1
 */