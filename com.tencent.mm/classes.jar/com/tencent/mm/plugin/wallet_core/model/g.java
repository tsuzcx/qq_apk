package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class g
{
  private static g CVF;
  public int CVG = 0;
  private JSONObject CVH;
  public String wBJ;
  
  public static g eFb()
  {
    AppMethodBeat.i(70243);
    if (CVF == null) {
      CVF = new g();
    }
    g localg = CVF;
    AppMethodBeat.o(70243);
    return localg;
  }
  
  public final void bc(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70244);
    this.CVH = paramJSONObject;
    try
    {
      if (this.CVH != null)
      {
        paramJSONObject = this.CVH.optJSONObject("bind_newcard_switch");
        this.CVG = paramJSONObject.optInt("forbid_bind_card");
      }
      for (this.wBJ = paramJSONObject.optString("forbid_word");; this.wBJ = "")
      {
        ad.i("MicroMsg.BindQueryComplexSwitchInfo", "feed result %s forbid_bind_card %s forbid_word %s", new Object[] { this.CVH, Integer.valueOf(this.CVG), this.wBJ });
        AppMethodBeat.o(70244);
        return;
        this.CVG = 0;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        this.CVG = 0;
        this.wBJ = "";
        ad.printErrStackTrace("MicroMsg.BindQueryComplexSwitchInfo", paramJSONObject, "", new Object[0]);
      }
    }
  }
  
  public final boolean bni()
  {
    AppMethodBeat.i(70245);
    if ((this.CVG == 1) && (!bt.isNullOrNil(this.wBJ)))
    {
      AppMethodBeat.o(70245);
      return true;
    }
    AppMethodBeat.o(70245);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.g
 * JD-Core Version:    0.7.0.1
 */