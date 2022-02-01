package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class ah
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama)
  {
    int j = 1;
    AppMethodBeat.i(78578);
    Log.i("MicroMsg.JsApiLaunchMiniProgram", "invoke");
    JSONObject localJSONObject = c.agO(paramString);
    if (localJSONObject == null)
    {
      Log.e("MicroMsg.JsApiLaunchMiniProgram", "data is null");
      parama.i("fail_null_data", null);
      AppMethodBeat.o(78578);
      return;
    }
    String str2 = localJSONObject.optString("targetAppId");
    String str3 = localJSONObject.optString("currentUrl");
    String str1 = localJSONObject.optString("preVerifyAppId");
    paramString = str1;
    if (Util.isNullOrNil(str1)) {
      paramString = localJSONObject.optString("referrerAppId");
    }
    if (Util.isNullOrNil(str2))
    {
      parama.i("invalid_targetAppId", null);
      AppMethodBeat.o(78578);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      parama.i("invalid_referrerAppId", null);
      AppMethodBeat.o(78578);
      return;
    }
    str1 = Util.nullAsNil(localJSONObject.optString("envVersion"));
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
      ((r)h.ae(r.class)).b(paramContext, str3, paramString, str2, j, str1, 0);
      parama.i(null, null);
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
  
  public final void b(b<g>.a paramb) {}
  
  public final int cDj()
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