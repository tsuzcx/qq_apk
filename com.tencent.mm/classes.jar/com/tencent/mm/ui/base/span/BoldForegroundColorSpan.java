package com.tencent.mm.ui.base.span;

import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aw;

public class BoldForegroundColorSpan
  extends ForegroundColorSpan
{
  public BoldForegroundColorSpan(int paramInt)
  {
    super(paramInt);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(251487);
    super.updateDrawState(paramTextPaint);
    aw.a(paramTextPaint, 0.8F);
    AppMethodBeat.o(251487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.span.BoldForegroundColorSpan
 * JD-Core Version:    0.7.0.1
 */