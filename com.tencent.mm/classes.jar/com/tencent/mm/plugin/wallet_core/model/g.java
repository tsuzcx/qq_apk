package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public final class g
{
  private static g Bvq;
  public int Bvr = 0;
  private JSONObject Bvs;
  public String vwp;
  
  public static g erb()
  {
    AppMethodBeat.i(70243);
    if (Bvq == null) {
      Bvq = new g();
    }
    g localg = Bvq;
    AppMethodBeat.o(70243);
    return localg;
  }
  
  public final void aU(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70244);
    this.Bvs = paramJSONObject;
    try
    {
      if (this.Bvs != null)
      {
        paramJSONObject = this.Bvs.optJSONObject("bind_newcard_switch");
        this.Bvr = paramJSONObject.optInt("forbid_bind_card");
      }
      for (this.vwp = paramJSONObject.optString("forbid_word");; this.vwp = "")
      {
        ac.i("MicroMsg.BindQueryComplexSwitchInfo", "feed result %s forbid_bind_card %s forbid_word %s", new Object[] { this.Bvs, Integer.valueOf(this.Bvr), this.vwp });
        AppMethodBeat.o(70244);
        return;
        this.Bvr = 0;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        this.Bvr = 0;
        this.vwp = "";
        ac.printErrStackTrace("MicroMsg.BindQueryComplexSwitchInfo", paramJSONObject, "", new Object[0]);
      }
    }
  }
  
  public final boolean bjw()
  {
    AppMethodBeat.i(70245);
    if ((this.Bvr == 1) && (!bs.isNullOrNil(this.vwp)))
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