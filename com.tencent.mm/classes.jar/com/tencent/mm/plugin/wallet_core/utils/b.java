package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.l;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public bry DnV;
  public bry DnW;
  public int DnX;
  public String dxD;
  
  public static b bw(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(199350);
    if (paramJSONObject == null)
    {
      ad.w("MicroMsg.InterceptWin", "createFromJSONObject() jsonObject == null");
      AppMethodBeat.o(199350);
      return null;
    }
    b localb = new b();
    localb.dxD = paramJSONObject.optString("wording");
    try
    {
      localb.DnV = l.bI(paramJSONObject.getJSONObject("left_button"));
      localb.DnW = l.bI(paramJSONObject.getJSONObject("right_button"));
      localb.DnX = paramJSONObject.optInt("win_type");
      AppMethodBeat.o(199350);
      return localb;
    }
    catch (JSONException paramJSONObject)
    {
      ad.e("MicroMsg.InterceptWin", "createFromJSONObject() Exception:%s", new Object[] { paramJSONObject.getMessage() });
      AppMethodBeat.o(199350);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.b
 * JD-Core Version:    0.7.0.1
 */