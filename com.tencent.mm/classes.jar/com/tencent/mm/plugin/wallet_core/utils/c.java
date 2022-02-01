package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.l;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public dfc VXQ;
  public dfc VXR;
  public int VXS;
  public String wording;
  
  public static c cC(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(301406);
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.InterceptWin", "createFromJSONObject() jsonObject == null");
      AppMethodBeat.o(301406);
      return null;
    }
    c localc = new c();
    localc.wording = paramJSONObject.optString("wording");
    try
    {
      localc.VXQ = l.cO(paramJSONObject.getJSONObject("left_button"));
      localc.VXR = l.cO(paramJSONObject.getJSONObject("right_button"));
      localc.VXS = paramJSONObject.optInt("win_type");
      AppMethodBeat.o(301406);
      return localc;
    }
    catch (JSONException paramJSONObject)
    {
      Log.e("MicroMsg.InterceptWin", "createFromJSONObject() Exception:%s", new Object[] { paramJSONObject.getMessage() });
      AppMethodBeat.o(301406);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.c
 * JD-Core Version:    0.7.0.1
 */