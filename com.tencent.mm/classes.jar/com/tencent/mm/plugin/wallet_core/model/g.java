package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class g
{
  private static g HWD;
  public String ANp;
  public int HWE = 0;
  private JSONObject HWF;
  
  public static g fQl()
  {
    AppMethodBeat.i(70243);
    if (HWD == null) {
      HWD = new g();
    }
    g localg = HWD;
    AppMethodBeat.o(70243);
    return localg;
  }
  
  public final void bC(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70244);
    this.HWF = paramJSONObject;
    try
    {
      if (this.HWF != null)
      {
        paramJSONObject = this.HWF.optJSONObject("bind_newcard_switch");
        this.HWE = paramJSONObject.optInt("forbid_bind_card");
      }
      for (this.ANp = paramJSONObject.optString("forbid_word");; this.ANp = "")
      {
        Log.i("MicroMsg.BindQueryComplexSwitchInfo", "feed result %s forbid_bind_card %s forbid_word %s", new Object[] { this.HWF, Integer.valueOf(this.HWE), this.ANp });
        AppMethodBeat.o(70244);
        return;
        this.HWE = 0;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        this.HWE = 0;
        this.ANp = "";
        Log.printErrStackTrace("MicroMsg.BindQueryComplexSwitchInfo", paramJSONObject, "", new Object[0]);
      }
    }
  }
  
  public final boolean bJw()
  {
    AppMethodBeat.i(70245);
    if ((this.HWE == 1) && (!Util.isNullOrNil(this.ANp)))
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