package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public String rGU;
  public String right_button_wording;
  public String wYO;
  public String wording;
  
  public final boolean ihT()
  {
    AppMethodBeat.i(70205);
    if ((!Util.isNullOrNil(this.wording)) && (!Util.isNullOrNil(this.rGU)) && (!Util.isNullOrNil(this.right_button_wording)) && (!Util.isNullOrNil(this.wYO)))
    {
      AppMethodBeat.o(70205);
      return true;
    }
    AppMethodBeat.o(70205);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.a
 * JD-Core Version:    0.7.0.1
 */