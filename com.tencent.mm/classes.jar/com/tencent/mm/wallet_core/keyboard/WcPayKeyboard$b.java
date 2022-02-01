package com.tencent.mm.wallet_core.keyboard;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum WcPayKeyboard$b
{
  static
  {
    AppMethodBeat.i(72670);
    LTK = new b("NORMAL_STATE", 0);
    LTL = new b("SINGLE_ACTION_STATE", 1);
    LTM = new b("INIT_STATE", 2);
    LTN = new b[] { LTK, LTL, LTM };
    AppMethodBeat.o(72670);
  }
  
  private WcPayKeyboard$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.b
 * JD-Core Version:    0.7.0.1
 */