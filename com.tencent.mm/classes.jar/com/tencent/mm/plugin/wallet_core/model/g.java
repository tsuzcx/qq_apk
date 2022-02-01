package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class g
{
  private static g AcW;
  public int AcX = 0;
  private JSONObject AcY;
  public String unt;
  
  public static g ebF()
  {
    AppMethodBeat.i(70243);
    if (AcW == null) {
      AcW = new g();
    }
    g localg = AcW;
    AppMethodBeat.o(70243);
    return localg;
  }
  
  public final void aT(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70244);
    this.AcY = paramJSONObject;
    try
    {
      if (this.AcY != null)
      {
        paramJSONObject = this.AcY.optJSONObject("bind_newcard_switch");
        this.AcX = paramJSONObject.optInt("forbid_bind_card");
      }
      for (this.unt = paramJSONObject.optString("forbid_word");; this.unt = "")
      {
        ad.i("MicroMsg.BindQueryComplexSwitchInfo", "feed result %s forbid_bind_card %s forbid_word %s", new Object[] { this.AcY, Integer.valueOf(this.AcX), this.unt });
        AppMethodBeat.o(70244);
        return;
        this.AcX = 0;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        this.AcX = 0;
        this.unt = "";
        ad.printErrStackTrace("MicroMsg.BindQueryComplexSwitchInfo", paramJSONObject, "", new Object[0]);
      }
    }
  }
  
  public final boolean bcB()
  {
    AppMethodBeat.i(70245);
    if ((this.AcX == 1) && (!bt.isNullOrNil(this.unt)))
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