package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public class t
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(6313);
    ab.i("MicroMsg.JsApiGetOpenDeviceId", "invokeInMM");
    paramContext = b.BJ(paramString);
    if (paramContext == null)
    {
      ab.e("MicroMsg.JsApiGetOpenDeviceId", "data is null");
      parama.c("fail", null);
      AppMethodBeat.o(6313);
      return;
    }
    paramString = paramContext.optString("preVerifyAppId");
    paramContext = q.bP(true);
    String str = q.LK();
    if ((!bo.isNullOrNil(paramContext)) && (!bo.isNullOrNil(str)) && (!bo.isNullOrNil(paramString)))
    {
      paramContext = ag.cE(ag.cE(paramString + paramContext));
      str = ag.cE(ag.cE(paramString + str));
      paramString = new JSONObject();
    }
    try
    {
      paramString.put("deviceid", paramContext);
      paramString.put("newDeviceId", str);
      label159:
      parama.c(null, paramString);
      AppMethodBeat.o(6313);
      return;
      parama.c("fail", null);
      AppMethodBeat.o(6313);
      return;
    }
    catch (JSONException paramContext)
    {
      break label159;
    }
  }
  
  public final void b(a<e>.a parama) {}
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getOpenDeviceId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.t
 * JD-Core Version:    0.7.0.1
 */