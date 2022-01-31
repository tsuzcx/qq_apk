package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.webview.luggage.d.c;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class z
  extends ax<e>
{
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    int j = 1;
    y.i("MicroMsg.JsApiLaunchMiniProgram", "invoke");
    JSONObject localJSONObject = c.tJ(paramString);
    if (localJSONObject == null)
    {
      y.e("MicroMsg.JsApiLaunchMiniProgram", "data is null");
      parama.e("fail_null_data", null);
      return;
    }
    String str2 = localJSONObject.optString("targetAppId");
    String str3 = localJSONObject.optString("currentUrl");
    String str1 = localJSONObject.optString("preVerifyAppId");
    paramString = str1;
    if (bk.bl(str1)) {
      paramString = localJSONObject.optString("referrerAppId");
    }
    if (bk.bl(str2))
    {
      parama.e("invalid_targetAppId", null);
      return;
    }
    if (bk.bl(paramString))
    {
      parama.e("invalid_referrerAppId", null);
      return;
    }
    str1 = bk.pm(localJSONObject.optString("envVersion"));
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
      ((d)g.r(d.class)).a(paramContext, str3, paramString, str2, j, str1);
      parama.e(null, null);
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
  
  public final int aGj()
  {
    return 2;
  }
  
  public final void b(a<e>.a parama) {}
  
  public final String name()
  {
    return "launchMiniProgram";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.z
 * JD-Core Version:    0.7.0.1
 */