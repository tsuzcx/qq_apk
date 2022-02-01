package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ae;
import org.json.JSONObject;

public final class al
{
  public boolean Dhk;
  public ak Dhl;
  public String Dhm;
  public String Dhn;
  public String nhq;
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
    localal.nhq = paramJSONObject.optString("sub_title");
    localal.Dhk = paramJSONObject.optBoolean("is_lqt_user");
    localal.Dhm = paramJSONObject.optString("lqt_operate_id");
    localal.Dhn = paramJSONObject.optString("lqt_trace_info");
    ae.aFj(localal.Dhn);
    paramJSONObject = paramJSONObject.optJSONObject("open_lqt_info");
    if (paramJSONObject != null)
    {
      localal.Dhl = new ak();
      localal.Dhl.Dhi = paramJSONObject.optString("open_info");
      localal.Dhl.Dhj = paramJSONObject.optString("open_url");
      localal.Dhl.kCY = paramJSONObject.optInt("route_type");
      localal.Dhl.hDU = paramJSONObject.optString("appname");
    }
    AppMethodBeat.o(69966);
    return localal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.al
 * JD-Core Version:    0.7.0.1
 */