package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ae;
import org.json.JSONObject;

public final class al
{
  public boolean Bpr;
  public ak Bps;
  public String Bpt;
  public String Bpu;
  public String mBH;
  public String title;
  
  public static al aP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69966);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(69966);
      return null;
    }
    al localal = new al();
    localal.title = paramJSONObject.optString("title");
    localal.mBH = paramJSONObject.optString("sub_title");
    localal.Bpr = paramJSONObject.optBoolean("is_lqt_user");
    localal.Bpt = paramJSONObject.optString("lqt_operate_id");
    localal.Bpu = paramJSONObject.optString("lqt_trace_info");
    ae.ayI(localal.Bpu);
    paramJSONObject = paramJSONObject.optJSONObject("open_lqt_info");
    if (paramJSONObject != null)
    {
      localal.Bps = new ak();
      localal.Bps.Bpo = paramJSONObject.optString("open_info");
      localal.Bps.Bpp = paramJSONObject.optString("open_url");
      localal.Bps.Bpq = paramJSONObject.optInt("route_type");
      localal.Bps.hiX = paramJSONObject.optString("appname");
    }
    AppMethodBeat.o(69966);
    return localal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.al
 * JD-Core Version:    0.7.0.1
 */