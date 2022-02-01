package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.l;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public bnn BND;
  public bnn BNE;
  public int BNF;
  public String dlQ;
  
  public static b bn(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(207308);
    if (paramJSONObject == null)
    {
      ac.w("MicroMsg.InterceptWin", "createFromJSONObject() jsonObject == null");
      AppMethodBeat.o(207308);
      return null;
    }
    b localb = new b();
    localb.dlQ = paramJSONObject.optString("wording");
    try
    {
      localb.BND = l.bz(paramJSONObject.getJSONObject("left_button"));
      localb.BNE = l.bz(paramJSONObject.getJSONObject("right_button"));
      localb.BNF = paramJSONObject.optInt("win_type");
      AppMethodBeat.o(207308);
      return localb;
    }
    catch (JSONException paramJSONObject)
    {
      ac.e("MicroMsg.InterceptWin", "createFromJSONObject() Exception:%s", new Object[] { paramJSONObject.getMessage() });
      AppMethodBeat.o(207308);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.b
 * JD-Core Version:    0.7.0.1
 */