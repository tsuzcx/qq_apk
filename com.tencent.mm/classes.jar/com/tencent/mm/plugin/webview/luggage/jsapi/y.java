package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class y
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(78559);
    Log.i("MicroMsg.JsApiGetOpenDeviceId", "invokeInMM");
    paramContext = c.ZL(paramString);
    if (paramContext == null)
    {
      Log.e("MicroMsg.JsApiGetOpenDeviceId", "data is null");
      parama.j("fail", null);
      AppMethodBeat.o(78559);
      return;
    }
    paramString = paramContext.optString("preVerifyAppId");
    paramContext = q.eD(true);
    String str = q.aPg();
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
      parama.j(null, paramString);
      AppMethodBeat.o(78559);
      return;
      parama.j("fail", null);
      AppMethodBeat.o(78559);
      return;
    }
    catch (JSONException paramContext)
    {
      break label157;
    }
  }
  
  public final void b(b<g>.a paramb) {}
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getOpenDeviceId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.y
 * JD-Core Version:    0.7.0.1
 */