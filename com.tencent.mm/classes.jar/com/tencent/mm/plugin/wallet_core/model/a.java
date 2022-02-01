package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  public String dxD;
  public String kzK;
  public String kzL;
  public String paG;
  
  public final boolean eEP()
  {
    AppMethodBeat.i(70205);
    if ((!bt.isNullOrNil(this.dxD)) && (!bt.isNullOrNil(this.kzK)) && (!bt.isNullOrNil(this.kzL)) && (!bt.isNullOrNil(this.paG)))
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