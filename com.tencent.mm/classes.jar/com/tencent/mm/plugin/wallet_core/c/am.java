package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ai;
import org.json.JSONObject;

public final class am
{
  public String VyA;
  public boolean Vyx;
  public al Vyy;
  public String Vyz;
  public String title;
  public String uCW;
  
  public static am cd(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69966);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(69966);
      return null;
    }
    am localam = new am();
    localam.title = paramJSONObject.optString("title");
    localam.uCW = paramJSONObject.optString("sub_title");
    localam.Vyx = paramJSONObject.optBoolean("is_lqt_user");
    localam.Vyz = paramJSONObject.optString("lqt_operate_id");
    localam.VyA = paramJSONObject.optString("lqt_trace_info");
    ai.bfU(localam.VyA);
    paramJSONObject = paramJSONObject.optJSONObject("open_lqt_info");
    if (paramJSONObject != null)
    {
      localam.Vyy = new al();
      localam.Vyy.Vyv = paramJSONObject.optString("open_info");
      localam.Vyy.Vyw = paramJSONObject.optString("open_url");
      localam.Vyy.rGS = paramJSONObject.optInt("route_type");
      localam.Vyy.nSt = paramJSONObject.optString("appname");
    }
    AppMethodBeat.o(69966);
    return localam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.am
 * JD-Core Version:    0.7.0.1
 */