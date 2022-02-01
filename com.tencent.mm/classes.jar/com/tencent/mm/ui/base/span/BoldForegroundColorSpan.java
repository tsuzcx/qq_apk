package com.tencent.mm.ui.base.span;

import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.al;

public class BoldForegroundColorSpan
  extends ForegroundColorSpan
{
  public BoldForegroundColorSpan(int paramInt)
  {
    super(paramInt);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(193745);
    super.updateDrawState(paramTextPaint);
    al.a(paramTextPaint, 0.8F);
    AppMethodBeat.o(193745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.span.BoldForegroundColorSpan
 * JD-Core Version:    0.7.0.1
 */