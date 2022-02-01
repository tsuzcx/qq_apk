package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  public String doh;
  public String nTQ;
  public String tfH;
  public String tfI;
  
  public final boolean ebt()
  {
    AppMethodBeat.i(70205);
    if ((!bt.isNullOrNil(this.doh)) && (!bt.isNullOrNil(this.tfH)) && (!bt.isNullOrNil(this.tfI)) && (!bt.isNullOrNil(this.nTQ)))
    {
      AppMethodBeat.o(70205);
      return true;
    }
    AppMethodBeat.o(70205);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.a
 * JD-Core Version:    0.7.0.1
 */