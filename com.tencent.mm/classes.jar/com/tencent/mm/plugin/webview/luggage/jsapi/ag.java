package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public class ag
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama)
  {
    int j = 1;
    AppMethodBeat.i(78578);
    ac.i("MicroMsg.JsApiLaunchMiniProgram", "invoke");
    JSONObject localJSONObject = b.LK(paramString);
    if (localJSONObject == null)
    {
      ac.e("MicroMsg.JsApiLaunchMiniProgram", "data is null");
      parama.f("fail_null_data", null);
      AppMethodBeat.o(78578);
      return;
    }
    String str2 = localJSONObject.optString("targetAppId");
    String str3 = localJSONObject.optString("currentUrl");
    String str1 = localJSONObject.optString("preVerifyAppId");
    paramString = str1;
    if (bs.isNullOrNil(str1)) {
      paramString = localJSONObject.optString("referrerAppId");
    }
    if (bs.isNullOrNil(str2))
    {
      parama.f("invalid_targetAppId", null);
      AppMethodBeat.o(78578);
      return;
    }
    if (bs.isNullOrNil(paramString))
    {
      parama.f("invalid_referrerAppId", null);
      AppMethodBeat.o(78578);
      return;
    }
    str1 = bs.nullAsNil(localJSONObject.optString("envVersion"));
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
      ((n)g.ab(n.class)).b(paramContext, str3, paramString, str2, j, str1, 0);
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
  
  public final void b(a<f>.a parama) {}
  
  public final int bYk()
  {
    return 2;
  }
  
  public final String name()
  {
    return "launchMiniProgram";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ag
 * JD-Core Version:    0.7.0.1
 */