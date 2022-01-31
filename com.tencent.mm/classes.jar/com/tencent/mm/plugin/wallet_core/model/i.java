package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class i
{
  private static i ugO;
  public String pot;
  public int ugP = 0;
  private JSONObject ugQ;
  
  public static i cTp()
  {
    AppMethodBeat.i(46726);
    if (ugO == null) {
      ugO = new i();
    }
    i locali = ugO;
    AppMethodBeat.o(46726);
    return locali;
  }
  
  public final boolean Pk()
  {
    AppMethodBeat.i(46728);
    if ((this.ugP == 1) && (!bo.isNullOrNil(this.pot)))
    {
      AppMethodBeat.o(46728);
      return true;
    }
    AppMethodBeat.o(46728);
    return false;
  }
  
  public final void ay(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46727);
    this.ugQ = paramJSONObject;
    try
    {
      if (this.ugQ != null)
      {
        paramJSONObject = this.ugQ.optJSONObject("bind_newcard_switch");
        this.ugP = paramJSONObject.optInt("forbid_bind_card");
      }
      for (this.pot = paramJSONObject.optString("forbid_word");; this.pot = "")
      {
        ab.i("MicroMsg.BindQueryComplexSwitchInfo", "feed result %s forbid_bind_card %s forbid_word %s", new Object[] { this.ugQ, Integer.valueOf(this.ugP), this.pot });
        AppMethodBeat.o(46727);
        return;
        this.ugP = 0;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        this.ugP = 0;
        this.pot = "";
        ab.printErrStackTrace("MicroMsg.BindQueryComplexSwitchInfo", paramJSONObject, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.i
 * JD-Core Version:    0.7.0.1
 */