package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public String oDJ;
  public String oDK;
  public String tVu;
  public String wording;
  
  public final boolean gIF()
  {
    AppMethodBeat.i(70205);
    if ((!Util.isNullOrNil(this.wording)) && (!Util.isNullOrNil(this.oDJ)) && (!Util.isNullOrNil(this.oDK)) && (!Util.isNullOrNil(this.tVu)))
    {
      AppMethodBeat.o(70205);
      return true;
    }
    AppMethodBeat.o(70205);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.a
 * JD-Core Version:    0.7.0.1
 */