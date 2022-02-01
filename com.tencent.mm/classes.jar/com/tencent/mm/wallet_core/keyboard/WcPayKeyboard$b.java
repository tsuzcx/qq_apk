package com.tencent.mm.wallet_core.keyboard;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum WcPayKeyboard$b
{
  static
  {
    AppMethodBeat.i(72670);
    agRU = new b("NORMAL_STATE", 0);
    agRV = new b("SINGLE_ACTION_STATE", 1);
    agRW = new b("INIT_STATE", 2);
    agRX = new b[] { agRU, agRV, agRW };
    AppMethodBeat.o(72670);
  }
  
  private WcPayKeyboard$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.b
 * JD-Core Version:    0.7.0.1
 */