package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class g
{
  private static g OOD;
  public String GGD;
  public int OOE = 0;
  private JSONObject OOF;
  
  public static g gIR()
  {
    AppMethodBeat.i(70243);
    if (OOD == null) {
      OOD = new g();
    }
    g localg = OOD;
    AppMethodBeat.o(70243);
    return localg;
  }
  
  public final void bN(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70244);
    this.OOF = paramJSONObject;
    try
    {
      if (this.OOF != null)
      {
        paramJSONObject = this.OOF.optJSONObject("bind_newcard_switch");
        this.OOE = paramJSONObject.optInt("forbid_bind_card");
      }
      for (this.GGD = paramJSONObject.optString("forbid_word");; this.GGD = "")
      {
        Log.i("MicroMsg.BindQueryComplexSwitchInfo", "feed result %s forbid_bind_card %s forbid_word %s", new Object[] { this.OOF, Integer.valueOf(this.OOE), this.GGD });
        AppMethodBeat.o(70244);
        return;
        this.OOE = 0;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        this.OOE = 0;
        this.GGD = "";
        Log.printErrStackTrace("MicroMsg.BindQueryComplexSwitchInfo", paramJSONObject, "", new Object[0]);
      }
    }
  }
  
  public final boolean bVd()
  {
    AppMethodBeat.i(70245);
    if ((this.OOE == 1) && (!Util.isNullOrNil(this.GGD)))
    {
      AppMethodBeat.o(70245);
      return true;
    }
    AppMethodBeat.o(70245);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.g
 * JD-Core Version:    0.7.0.1
 */