package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public final class g
{
  private static g Dnl;
  public int Dnm = 0;
  private JSONObject Dnn;
  public String wRu;
  
  public static g eII()
  {
    AppMethodBeat.i(70243);
    if (Dnl == null) {
      Dnl = new g();
    }
    g localg = Dnl;
    AppMethodBeat.o(70243);
    return localg;
  }
  
  public final void bc(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70244);
    this.Dnn = paramJSONObject;
    try
    {
      if (this.Dnn != null)
      {
        paramJSONObject = this.Dnn.optJSONObject("bind_newcard_switch");
        this.Dnm = paramJSONObject.optInt("forbid_bind_card");
      }
      for (this.wRu = paramJSONObject.optString("forbid_word");; this.wRu = "")
      {
        ae.i("MicroMsg.BindQueryComplexSwitchInfo", "feed result %s forbid_bind_card %s forbid_word %s", new Object[] { this.Dnn, Integer.valueOf(this.Dnm), this.wRu });
        AppMethodBeat.o(70244);
        return;
        this.Dnm = 0;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        this.Dnm = 0;
        this.wRu = "";
        ae.printErrStackTrace("MicroMsg.BindQueryComplexSwitchInfo", paramJSONObject, "", new Object[0]);
      }
    }
  }
  
  public final boolean bnS()
  {
    AppMethodBeat.i(70245);
    if ((this.Dnm == 1) && (!bu.isNullOrNil(this.wRu)))
    {
      AppMethodBeat.o(70245);
      return true;
    }
    AppMethodBeat.o(70245);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.g
 * JD-Core Version:    0.7.0.1
 */