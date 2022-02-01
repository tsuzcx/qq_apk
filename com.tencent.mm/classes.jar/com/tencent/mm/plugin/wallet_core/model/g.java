package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class g
{
  private static g VEx;
  public String MDu;
  public int VEy = 0;
  private JSONObject VEz;
  
  public static g iif()
  {
    AppMethodBeat.i(70243);
    if (VEx == null) {
      VEx = new g();
    }
    g localg = VEx;
    AppMethodBeat.o(70243);
    return localg;
  }
  
  public final void ci(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70244);
    this.VEz = paramJSONObject;
    try
    {
      if (this.VEz != null)
      {
        paramJSONObject = this.VEz.optJSONObject("bind_newcard_switch");
        this.VEy = paramJSONObject.optInt("forbid_bind_card");
      }
      for (this.MDu = paramJSONObject.optString("forbid_word");; this.MDu = "")
      {
        Log.i("MicroMsg.BindQueryComplexSwitchInfo", "feed result %s forbid_bind_card %s forbid_word %s", new Object[] { this.VEz, Integer.valueOf(this.VEy), this.MDu });
        AppMethodBeat.o(70244);
        return;
        this.VEy = 0;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        this.VEy = 0;
        this.MDu = "";
        Log.printErrStackTrace("MicroMsg.BindQueryComplexSwitchInfo", paramJSONObject, "", new Object[0]);
      }
    }
  }
  
  public final boolean cvt()
  {
    AppMethodBeat.i(70245);
    if ((this.VEy == 1) && (!Util.isNullOrNil(this.MDu)))
    {
      AppMethodBeat.o(70245);
      return true;
    }
    AppMethodBeat.o(70245);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.g
 * JD-Core Version:    0.7.0.1
 */