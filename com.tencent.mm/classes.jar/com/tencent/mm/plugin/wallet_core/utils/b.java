package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.l;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public bjt Avj;
  public bjt Avk;
  public int Avl;
  public String doh;
  
  public static b bm(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(187185);
    if (paramJSONObject == null)
    {
      ad.w("MicroMsg.InterceptWin", "createFromJSONObject() jsonObject == null");
      AppMethodBeat.o(187185);
      return null;
    }
    b localb = new b();
    localb.doh = paramJSONObject.optString("wording");
    try
    {
      localb.Avj = l.by(paramJSONObject.getJSONObject("left_button"));
      localb.Avk = l.by(paramJSONObject.getJSONObject("right_button"));
      localb.Avl = paramJSONObject.optInt("win_type");
      AppMethodBeat.o(187185);
      return localb;
    }
    catch (JSONException paramJSONObject)
    {
      ad.e("MicroMsg.InterceptWin", "createFromJSONObject() Exception:%s", new Object[] { paramJSONObject.getMessage() });
      AppMethodBeat.o(187185);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.b
 * JD-Core Version:    0.7.0.1
 */