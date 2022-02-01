package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class x
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama)
  {
    AppMethodBeat.i(78559);
    Log.i("MicroMsg.JsApiGetOpenDeviceId", "invokeInMM");
    paramContext = com.tencent.mm.plugin.webview.luggage.c.b.Zc(paramString);
    if (paramContext == null)
    {
      Log.e("MicroMsg.JsApiGetOpenDeviceId", "data is null");
      parama.i("fail", null);
      AppMethodBeat.o(78559);
      return;
    }
    paramString = paramContext.optString("preVerifyAppId");
    paramContext = q.dr(true);
    String str = q.aoG();
    if ((!Util.isNullOrNil(paramContext)) && (!Util.isNullOrNil(str)) && (!Util.isNullOrNil(paramString)))
    {
      paramContext = MD5Util.getMD5String(MD5Util.getMD5String(paramString + paramContext));
      str = MD5Util.getMD5String(MD5Util.getMD5String(paramString + str));
      paramString = new JSONObject();
    }
    try
    {
      paramString.put("deviceid", paramContext);
      paramString.put("newDeviceId", str);
      label157:
      parama.i(null, paramString);
      AppMethodBeat.o(78559);
      return;
      parama.i("fail", null);
      AppMethodBeat.o(78559);
      return;
    }
    catch (JSONException paramContext)
    {
      break label157;
    }
  }
  
  public final void b(com.tencent.luggage.d.b<g>.a paramb) {}
  
  public final int dTs()
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