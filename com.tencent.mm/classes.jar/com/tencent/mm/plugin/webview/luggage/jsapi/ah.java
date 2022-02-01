package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class ah
  extends br<com.tencent.mm.plugin.webview.luggage.g>
{
  public final void a(Context paramContext, String paramString, bq.a parama)
  {
    int j = 1;
    AppMethodBeat.i(78578);
    ad.i("MicroMsg.JsApiLaunchMiniProgram", "invoke");
    JSONObject localJSONObject = com.tencent.mm.plugin.webview.luggage.c.b.Pe(paramString);
    if (localJSONObject == null)
    {
      ad.e("MicroMsg.JsApiLaunchMiniProgram", "data is null");
      parama.f("fail_null_data", null);
      AppMethodBeat.o(78578);
      return;
    }
    String str2 = localJSONObject.optString("targetAppId");
    String str3 = localJSONObject.optString("currentUrl");
    String str1 = localJSONObject.optString("preVerifyAppId");
    paramString = str1;
    if (bt.isNullOrNil(str1)) {
      paramString = localJSONObject.optString("referrerAppId");
    }
    if (bt.isNullOrNil(str2))
    {
      parama.f("invalid_targetAppId", null);
      AppMethodBeat.o(78578);
      return;
    }
    if (bt.isNullOrNil(paramString))
    {
      parama.f("invalid_referrerAppId", null);
      AppMethodBeat.o(78578);
      return;
    }
    str1 = bt.nullAsNil(localJSONObject.optString("envVersion"));
    int i = -1;
    switch (str1.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (j = 0;; j = 2)
    {
      str1 = localJSONObject.optString("path");
      ((o)com.tencent.mm.kernel.g.ab(o.class)).b(paramContext, str3, paramString, str2, j, str1, 0);
      parama.f(null, null);
      AppMethodBeat.o(78578);
      return;
      if (!str1.equals("develop")) {
        break;
      }
      i = 0;
      break;
      if (!str1.equals("trial")) {
        break;
      }
      i = 1;
      break;
    }
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>.a paramb) {}
  
  public final int ccO()
  {
    return 2;
  }
  
  public final String name()
  {
    return "launchMiniProgram";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ah
 * JD-Core Version:    0.7.0.1
 */