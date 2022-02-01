package com.tencent.mm.plugin.wallet.wecoin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g
{
  static
  {
    AppMethodBeat.i(315692);
    VtW = new g("DIRECT_CHARGE", 0);
    VtX = new g("COMMON_CHARGE", 1);
    VtY = new g[] { VtW, VtX };
    AppMethodBeat.o(315692);
  }
  
  private g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.a.g
 * JD-Core Version:    0.7.0.1
 */