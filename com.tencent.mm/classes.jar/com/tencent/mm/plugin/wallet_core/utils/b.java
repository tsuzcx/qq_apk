package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.l;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public cfl IoL;
  public cfl IoM;
  public int IoN;
  public String dQx;
  
  public static b bV(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(214250);
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.InterceptWin", "createFromJSONObject() jsonObject == null");
      AppMethodBeat.o(214250);
      return null;
    }
    b localb = new b();
    localb.dQx = paramJSONObject.optString("wording");
    try
    {
      localb.IoL = l.ci(paramJSONObject.getJSONObject("left_button"));
      localb.IoM = l.ci(paramJSONObject.getJSONObject("right_button"));
      localb.IoN = paramJSONObject.optInt("win_type");
      AppMethodBeat.o(214250);
      return localb;
    }
    catch (JSONException paramJSONObject)
    {
      Log.e("MicroMsg.InterceptWin", "createFromJSONObject() Exception:%s", new Object[] { paramJSONObject.getMessage() });
      AppMethodBeat.o(214250);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.b
 * JD-Core Version:    0.7.0.1
 */