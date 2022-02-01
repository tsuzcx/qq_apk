package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.net.Uri;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public class ao
  extends br<com.tencent.mm.plugin.webview.luggage.g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<com.tencent.mm.plugin.webview.luggage.g>.a paramb)
  {
    AppMethodBeat.i(78592);
    ad.i("MicroMsg.JsApiOpenWeAppPage", "invokeInOwn %s", new Object[] { paramb.chh.cgn });
    String str3 = paramb.chh.cgn.optString("userName");
    String str2 = paramb.chh.cgn.optString("relativeURL");
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
        f localf;
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
    i = paramb.chh.cgn.optInt("appVersion", 0);
    str2 = paramb.chh.cgn.optString("searchId");
    localObject = paramb.chh.cgn.optString("docId");
    j = paramb.chh.cgn.optInt("position", 1);
    k = paramb.chh.cgn.optInt("scene", 1000);
    str4 = paramb.chh.cgn.optString("privateExtraData");
    localf = new f();
    if ((k == 201) || (k == 14) || (k == 22))
    {
      localf.scene = 1006;
      str5 = paramb.chh.cgn.optString("statSessionId");
      str6 = paramb.chh.cgn.optString("statKeywordId");
      str7 = paramb.chh.cgn.optString("subScene");
      localf.dkh = (str5 + ":" + str6 + ":" + str2 + ":" + (String)localObject + ":" + j + ":" + str7);
      localf.jCW = new AppBrandLaunchReferrer();
      localf.jCW.jXS = str4;
      localf.username = str3;
      localf.version = i;
      localf.jCN = str1;
      ((o)com.tencent.mm.kernel.g.ab(o.class)).a(((com.tencent.mm.plugin.webview.luggage.g)paramb.chg).mContext, localf);
      paramb.a("", null);
      AppMethodBeat.o(78592);
      return;
    }
  }
  
  public final int ccO()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openWeAppPage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ao
 * JD-Core Version:    0.7.0.1
 */