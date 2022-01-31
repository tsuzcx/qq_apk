package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
{
  public String cyA;
  public String kNB;
  public String opC;
  public String opD;
  
  public final boolean cTd()
  {
    AppMethodBeat.i(46694);
    if ((!bo.isNullOrNil(this.cyA)) && (!bo.isNullOrNil(this.opC)) && (!bo.isNullOrNil(this.opD)) && (!bo.isNullOrNil(this.kNB)))
    {
      AppMethodBeat.o(46694);
      return true;
    }
    AppMethodBeat.o(46694);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.b
 * JD-Core Version:    0.7.0.1
 */