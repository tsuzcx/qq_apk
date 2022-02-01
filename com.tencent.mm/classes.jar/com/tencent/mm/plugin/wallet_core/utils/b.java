package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.coi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.l;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public coi Phd;
  public coi Phe;
  public int Phf;
  public String wording;
  
  public static b cg(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(270023);
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.InterceptWin", "createFromJSONObject() jsonObject == null");
      AppMethodBeat.o(270023);
      return null;
    }
    b localb = new b();
    localb.wording = paramJSONObject.optString("wording");
    try
    {
      localb.Phd = l.ct(paramJSONObject.getJSONObject("left_button"));
      localb.Phe = l.ct(paramJSONObject.getJSONObject("right_button"));
      localb.Phf = paramJSONObject.optInt("win_type");
      AppMethodBeat.o(270023);
      return localb;
    }
    catch (JSONException paramJSONObject)
    {
      Log.e("MicroMsg.InterceptWin", "createFromJSONObject() Exception:%s", new Object[] { paramJSONObject.getMessage() });
      AppMethodBeat.o(270023);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.b
 * JD-Core Version:    0.7.0.1
 */