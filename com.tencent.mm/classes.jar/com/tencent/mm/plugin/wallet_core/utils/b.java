package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.l;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public bss DFA;
  public bss DFB;
  public int DFC;
  public String dyI;
  
  public static b bw(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(190230);
    if (paramJSONObject == null)
    {
      ae.w("MicroMsg.InterceptWin", "createFromJSONObject() jsonObject == null");
      AppMethodBeat.o(190230);
      return null;
    }
    b localb = new b();
    localb.dyI = paramJSONObject.optString("wording");
    try
    {
      localb.DFA = l.bI(paramJSONObject.getJSONObject("left_button"));
      localb.DFB = l.bI(paramJSONObject.getJSONObject("right_button"));
      localb.DFC = paramJSONObject.optInt("win_type");
      AppMethodBeat.o(190230);
      return localb;
    }
    catch (JSONException paramJSONObject)
    {
      ae.e("MicroMsg.InterceptWin", "createFromJSONObject() Exception:%s", new Object[] { paramJSONObject.getMessage() });
      AppMethodBeat.o(190230);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.b
 * JD-Core Version:    0.7.0.1
 */