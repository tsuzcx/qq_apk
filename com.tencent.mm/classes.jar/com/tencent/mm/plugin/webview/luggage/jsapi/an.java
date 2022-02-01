package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.net.Uri;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public class an
  extends bo<com.tencent.mm.plugin.webview.luggage.f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<com.tencent.mm.plugin.webview.luggage.f>.a parama)
  {
    AppMethodBeat.i(78592);
    ad.i("MicroMsg.JsApiOpenWeAppPage", "invokeInOwn %s", new Object[] { parama.bZV.bZb });
    String str3 = parama.bZV.bZb.optString("userName");
    String str2 = parama.bZV.bZb.optString("relativeURL");
    String str1 = str2;
    if (str2.contains("render_data")) {
      str1 = str2;
    }
    try
    {
      new StringBuilder();
      str1 = str2;
      localObject = new JSONObject(Uri.parse(str2).getQueryParameter("widgetData"));
      str1 = str2;
      ((JSONObject)localObject).remove("render_data");
      str1 = str2;
      str2 = str2.replaceAll("(widgetData=.*&)|(widgetData=.*$)", "&");
      str1 = str2;
      str2 = str2 + "&widgetData=" + ((JSONObject)localObject).toString();
      str1 = str2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject;
        int i;
        int j;
        int k;
        String str4;
        com.tencent.mm.plugin.appbrand.a.f localf;
        String str5;
        String str6;
        String str7;
        ad.printErrStackTrace("MicroMsg.JsApiOpenWeAppPage", localJSONException, "", new Object[0]);
        continue;
        if (k == 3) {
          localf.scene = 1005;
        } else if (k == 16) {
          localf.scene = 1042;
        } else if (k == 20) {
          localf.scene = 1053;
        } else {
          localf.scene = 1000;
        }
      }
    }
    i = parama.bZV.bZb.optInt("appVersion", 0);
    str2 = parama.bZV.bZb.optString("searchId");
    localObject = parama.bZV.bZb.optString("docId");
    j = parama.bZV.bZb.optInt("position", 1);
    k = parama.bZV.bZb.optInt("scene", 1000);
    str4 = parama.bZV.bZb.optString("privateExtraData");
    localf = new com.tencent.mm.plugin.appbrand.a.f();
    if ((k == 201) || (k == 14) || (k == 22))
    {
      localf.scene = 1006;
      str5 = parama.bZV.bZb.optString("statSessionId");
      str6 = parama.bZV.bZb.optString("statKeywordId");
      str7 = parama.bZV.bZb.optString("subScene");
      localf.dbt = (str5 + ":" + str6 + ":" + str2 + ":" + (String)localObject + ":" + j + ":" + str7);
      localf.iJk = new AppBrandLaunchReferrer();
      localf.iJk.jdD = str4;
      localf.username = str3;
      localf.version = i;
      localf.iJb = str1;
      ((n)g.ab(n.class)).a(((com.tencent.mm.plugin.webview.luggage.f)parama.bZU).mContext, localf);
      parama.a("", null);
      AppMethodBeat.o(78592);
      return;
    }
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openWeAppPage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.an
 * JD-Core Version:    0.7.0.1
 */