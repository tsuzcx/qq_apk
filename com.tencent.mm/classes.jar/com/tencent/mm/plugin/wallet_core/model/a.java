package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
{
  public String dyI;
  public String kCZ;
  public String kDa;
  public String phk;
  
  public final boolean eIw()
  {
    AppMethodBeat.i(70205);
    if ((!bu.isNullOrNil(this.dyI)) && (!bu.isNullOrNil(this.kCZ)) && (!bu.isNullOrNil(this.kDa)) && (!bu.isNullOrNil(this.phk)))
    {
      AppMethodBeat.o(70205);
      return true;
    }
    AppMethodBeat.o(70205);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.a
 * JD-Core Version:    0.7.0.1
 */