package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public class w
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama)
  {
    AppMethodBeat.i(78559);
    ac.i("MicroMsg.JsApiGetOpenDeviceId", "invokeInMM");
    paramContext = b.LK(paramString);
    if (paramContext == null)
    {
      ac.e("MicroMsg.JsApiGetOpenDeviceId", "data is null");
      parama.f("fail", null);
      AppMethodBeat.o(78559);
      return;
    }
    paramString = paramContext.optString("preVerifyAppId");
    paramContext = q.cF(true);
    String str = q.XX();
    if ((!bs.isNullOrNil(paramContext)) && (!bs.isNullOrNil(str)) && (!bs.isNullOrNil(paramString)))
    {
      paramContext = ah.dg(ah.dg(paramString + paramContext));
      str = ah.dg(ah.dg(paramString + str));
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
  
  public final void b(a<f>.a parama) {}
  
  public final int bYk()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getOpenDeviceId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.w
 * JD-Core Version:    0.7.0.1
 */