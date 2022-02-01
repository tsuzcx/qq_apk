package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ae;
import org.json.JSONObject;

public final class al
{
  public boolean CPG;
  public ak CPH;
  public String CPI;
  public String CPJ;
  public String nch;
  public String title;
  
  public static al aX(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69966);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(69966);
      return null;
    }
    al localal = new al();
    localal.title = paramJSONObject.optString("title");
    localal.nch = paramJSONObject.optString("sub_title");
    localal.CPG = paramJSONObject.optBoolean("is_lqt_user");
    localal.CPI = paramJSONObject.optString("lqt_operate_id");
    localal.CPJ = paramJSONObject.optString("lqt_trace_info");
    ae.aDQ(localal.CPJ);
    paramJSONObject = paramJSONObject.optJSONObject("open_lqt_info");
    if (paramJSONObject != null)
    {
      localal.CPH = new ak();
      localal.CPH.CPE = paramJSONObject.optString("open_info");
      localal.CPH.CPF = paramJSONObject.optString("open_url");
      localal.CPH.kzJ = paramJSONObject.optInt("route_type");
      localal.CPH.hBg = paramJSONObject.optString("appname");
    }
    AppMethodBeat.o(69966);
    return localal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.al
 * JD-Core Version:    0.7.0.1
 */