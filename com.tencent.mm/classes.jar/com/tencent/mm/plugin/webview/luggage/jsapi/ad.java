package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class ad
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    int j = 1;
    AppMethodBeat.i(6330);
    ab.i("MicroMsg.JsApiLaunchMiniProgram", "invoke");
    JSONObject localJSONObject = b.BJ(paramString);
    if (localJSONObject == null)
    {
      ab.e("MicroMsg.JsApiLaunchMiniProgram", "data is null");
      parama.c("fail_null_data", null);
      AppMethodBeat.o(6330);
      return;
    }
    String str2 = localJSONObject.optString("targetAppId");
    String str3 = localJSONObject.optString("currentUrl");
    String str1 = localJSONObject.optString("preVerifyAppId");
    paramString = str1;
    if (bo.isNullOrNil(str1)) {
      paramString = localJSONObject.optString("referrerAppId");
    }
    if (bo.isNullOrNil(str2))
    {
      parama.c("invalid_targetAppId", null);
      AppMethodBeat.o(6330);
      return;
    }
    if (bo.isNullOrNil(paramString))
    {
      parama.c("invalid_referrerAppId", null);
      AppMethodBeat.o(6330);
      return;
    }
    str1 = bo.nullAsNil(localJSONObject.optString("envVersion"));
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
      ((j)g.E(j.class)).b(paramContext, str3, paramString, str2, j, str1, 0);
      parama.c(null, null);
      AppMethodBeat.o(6330);
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
  
  public final void b(a<e>.a parama) {}
  
  public final int bjL()
  {
    return 2;
  }
  
  public final String name()
  {
    return "launchMiniProgram";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ad
 * JD-Core Version:    0.7.0.1
 */