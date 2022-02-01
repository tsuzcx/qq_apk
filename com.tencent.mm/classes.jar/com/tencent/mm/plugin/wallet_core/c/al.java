package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ae;
import org.json.JSONObject;

public final class al
{
  public String lZG;
  public String title;
  public boolean zWX;
  public ak zWY;
  public String zWZ;
  public String zXa;
  
  public static al aO(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69966);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(69966);
      return null;
    }
    al localal = new al();
    localal.title = paramJSONObject.optString("title");
    localal.lZG = paramJSONObject.optString("sub_title");
    localal.zWX = paramJSONObject.optBoolean("is_lqt_user");
    localal.zWZ = paramJSONObject.optString("lqt_operate_id");
    localal.zXa = paramJSONObject.optString("lqt_trace_info");
    ae.atq(localal.zXa);
    paramJSONObject = paramJSONObject.optJSONObject("open_lqt_info");
    if (paramJSONObject != null)
    {
      localal.zWY = new ak();
      localal.zWY.zWU = paramJSONObject.optString("open_info");
      localal.zWY.zWV = paramJSONObject.optString("open_url");
      localal.zWY.zWW = paramJSONObject.optInt("route_type");
      localal.zWY.gIw = paramJSONObject.optString("appname");
    }
    AppMethodBeat.o(69966);
    return localal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.al
 * JD-Core Version:    0.7.0.1
 */