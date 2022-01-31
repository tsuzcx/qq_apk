package com.tencent.mm.ui.base;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.f;

public final class MMTagPanel$c
  implements InputFilter
{
  int zmK = 36;
  private int zmL = 256;
  private int zmM;
  
  public MMTagPanel$c(MMTagPanel paramMMTagPanel) {}
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(106827);
    paramInt1 = f.auQ(paramSpanned.toString()) + f.auQ(paramCharSequence.toString());
    if (paramInt4 > paramInt3) {
      if (paramInt1 - (paramInt4 - paramInt3) > this.zmK)
      {
        MMTagPanel.a(this.zmE, true);
        this.zmM = (paramInt1 - (paramInt4 - paramInt3) - this.zmK);
      }
    }
    for (;;)
    {
      if ((MMTagPanel.h(this.zmE)) && (1 == this.zmM) && (paramCharSequence.equals("\n"))) {
        this.zmM = 0;
      }
      if (MMTagPanel.e(this.zmE) != null) {
        this.zmE.post(new MMTagPanel.c.1(this));
      }
      if (paramInt1 <= this.zmL) {
        break;
      }
      AppMethodBeat.o(106827);
      return "";
      MMTagPanel.a(this.zmE, false);
      continue;
      if (paramInt1 > this.zmK)
      {
        MMTagPanel.a(this.zmE, true);
        this.zmM = (paramInt1 - this.zmK);
      }
      else
      {
        MMTagPanel.a(this.zmE, false);
      }
    }
    AppMethodBeat.o(106827);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel.c
 * JD-Core Version:    0.7.0.1
 */