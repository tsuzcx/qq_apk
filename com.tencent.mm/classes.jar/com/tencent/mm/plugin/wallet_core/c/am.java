package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ah;
import org.json.JSONObject;

public final class am
{
  public boolean OIL;
  public al OIM;
  public String OIN;
  public String OIO;
  public String rsw;
  public String title;
  
  public static am bI(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69966);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(69966);
      return null;
    }
    am localam = new am();
    localam.title = paramJSONObject.optString("title");
    localam.rsw = paramJSONObject.optString("sub_title");
    localam.OIL = paramJSONObject.optBoolean("is_lqt_user");
    localam.OIN = paramJSONObject.optString("lqt_operate_id");
    localam.OIO = paramJSONObject.optString("lqt_trace_info");
    ah.bgp(localam.OIO);
    paramJSONObject = paramJSONObject.optJSONObject("open_lqt_info");
    if (paramJSONObject != null)
    {
      localam.OIM = new al();
      localam.OIM.OIJ = paramJSONObject.optString("open_info");
      localam.OIM.OIK = paramJSONObject.optString("open_url");
      localam.OIM.oDH = paramJSONObject.optInt("route_type");
      localam.OIM.lnp = paramJSONObject.optString("appname");
    }
    AppMethodBeat.o(69966);
    return localam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.am
 * JD-Core Version:    0.7.0.1
 */