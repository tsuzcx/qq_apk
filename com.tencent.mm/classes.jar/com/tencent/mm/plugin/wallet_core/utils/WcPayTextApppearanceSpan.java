package com.tencent.mm.plugin.wallet_core.utils;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TextAppearanceSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aw;

public class WcPayTextApppearanceSpan
  extends TextAppearanceSpan
{
  public Typeface VYs = Typeface.DEFAULT;
  public int VYt = 0;
  
  public WcPayTextApppearanceSpan(int paramInt, ColorStateList paramColorStateList)
  {
    super(null, 0, paramInt, paramColorStateList, null);
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(71650);
    super.updateMeasureState(paramTextPaint);
    switch (this.VYt)
    {
    case 2: 
    default: 
      this.VYt = 0;
    }
    for (;;)
    {
      paramTextPaint.setTypeface(Typeface.create(this.VYs, this.VYt));
      AppMethodBeat.o(71650);
      return;
      this.VYt = 1;
      continue;
      aw.a(paramTextPaint, 0.8F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.WcPayTextApppearanceSpan
 * JD-Core Version:    0.7.0.1
 */