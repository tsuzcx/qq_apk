package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public class x
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama)
  {
    AppMethodBeat.i(78559);
    ae.i("MicroMsg.JsApiGetOpenDeviceId", "invokeInMM");
    paramContext = com.tencent.mm.plugin.webview.luggage.c.b.PM(paramString);
    if (paramContext == null)
    {
      ae.e("MicroMsg.JsApiGetOpenDeviceId", "data is null");
      parama.f("fail", null);
      AppMethodBeat.o(78559);
      return;
    }
    paramString = paramContext.optString("preVerifyAppId");
    paramContext = q.cH(true);
    String str = q.aaH();
    if ((!bu.isNullOrNil(paramContext)) && (!bu.isNullOrNil(str)) && (!bu.isNullOrNil(paramString)))
    {
      paramContext = aj.ej(aj.ej(paramString + paramContext));
      str = aj.ej(aj.ej(paramString + str));
      paramString = new JSONObject();
    }
    try
    {
      paramString.put("deviceid", paramContext);
      paramString.put("newDeviceId", str);
      label157:
      parama.f(null, paramString);
      AppMethodBeat.o(78559);
      return;
      parama.f("fail", null);
      AppMethodBeat.o(78559);
      return;
    }
    catch (JSONException paramContext)
    {
      break label157;
    }
  }
  
  public final void b(com.tencent.luggage.d.b<g>.a paramb) {}
  
  public final int ced()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getOpenDeviceId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.x
 * JD-Core Version:    0.7.0.1
 */