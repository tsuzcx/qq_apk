package com.tencent.mm.pluginsdk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AutoLoginActivity$a
{
  static
  {
    AppMethodBeat.i(73688);
    vPN = new a("LOGIN_OK", 0);
    vPO = new a("LOGIN_FAIL", 1);
    vPP = new a("LOGIN_CANCEL", 2);
    vPQ = new a[] { vPN, vPO, vPP };
    AppMethodBeat.o(73688);
  }
  
  private AutoLoginActivity$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a
 * JD-Core Version:    0.7.0.1
 */