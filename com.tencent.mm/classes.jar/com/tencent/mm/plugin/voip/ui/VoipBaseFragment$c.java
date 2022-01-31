package com.tencent.mm.plugin.voip.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public final class VoipBaseFragment$c
{
  ap bAz;
  TextView md;
  int[] tCH;
  private int tCI;
  int tCJ;
  
  protected VoipBaseFragment$c()
  {
    AppMethodBeat.i(4849);
    this.bAz = new ap(new VoipBaseFragment.c.1(this), true);
    AppMethodBeat.o(4849);
  }
  
  public final void a(TextView paramTextView, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(4850);
    if ((paramArrayOfInt == null) || (paramTextView == null))
    {
      ab.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
      AppMethodBeat.o(4850);
      return;
    }
    cOZ();
    this.tCJ = 0;
    this.tCH = paramArrayOfInt;
    this.md = paramTextView;
    this.tCI = 500;
    if (this.bAz != null)
    {
      paramArrayOfInt = this.bAz;
      long l = this.tCI;
      paramArrayOfInt.ag(l, l);
    }
    ab.a("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(paramTextView)), new Object[0]);
    AppMethodBeat.o(4850);
  }
  
  public final void cOZ()
  {
    AppMethodBeat.i(4851);
    if (this.bAz != null) {
      this.bAz.stopTimer();
    }
    ab.a("MicroMsg.DynamicTextWrap", "stop textview: " + this.md, new Object[0]);
    this.md = null;
    AppMethodBeat.o(4851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment.c
 * JD-Core Version:    0.7.0.1
 */