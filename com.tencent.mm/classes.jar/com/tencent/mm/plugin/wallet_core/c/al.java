package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ag;
import org.json.JSONObject;

public final class al
{
  public boolean HQD;
  public ak HQE;
  public String HQF;
  public String HQG;
  public String oqZ;
  public String title;
  
  public static al bx(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69966);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(69966);
      return null;
    }
    al localal = new al();
    localal.title = paramJSONObject.optString("title");
    localal.oqZ = paramJSONObject.optString("sub_title");
    localal.HQD = paramJSONObject.optBoolean("is_lqt_user");
    localal.HQF = paramJSONObject.optString("lqt_operate_id");
    localal.HQG = paramJSONObject.optString("lqt_trace_info");
    ag.aUH(localal.HQG);
    paramJSONObject = paramJSONObject.optJSONObject("open_lqt_info");
    if (paramJSONObject != null)
    {
      localal.HQE = new ak();
      localal.HQE.HQB = paramJSONObject.optString("open_info");
      localal.HQE.HQC = paramJSONObject.optString("open_url");
      localal.HQE.lHz = paramJSONObject.optInt("route_type");
      localal.HQE.ixZ = paramJSONObject.optString("appname");
    }
    AppMethodBeat.o(69966);
    return localal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.al
 * JD-Core Version:    0.7.0.1
 */