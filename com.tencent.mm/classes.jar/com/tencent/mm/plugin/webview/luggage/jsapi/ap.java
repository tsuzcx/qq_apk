package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.net.Uri;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class ap
  extends bs<com.tencent.mm.plugin.webview.luggage.g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<com.tencent.mm.plugin.webview.luggage.g>.a paramb)
  {
    AppMethodBeat.i(78592);
    Log.i("MicroMsg.JsApiOpenWeAppPage", "invokeInOwn %s", new Object[] { paramb.crh.cqn });
    String str3 = paramb.crh.cqn.optString("userName");
    String str2 = paramb.crh.cqn.optString("relativeURL");
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
        com.tencent.mm.plugin.appbrand.api.g localg;
        String str5;
        String str6;
        String str7;
        Log.printErrStackTrace("MicroMsg.JsApiOpenWeAppPage", localJSONException, "", new Object[0]);
        continue;
        if (k == 3) {
          localg.scene = 1005;
        } else if (k == 16) {
          localg.scene = 1042;
        } else if (k == 20) {
          localg.scene = 1053;
        } else {
          localg.scene = 1000;
        }
      }
    }
    i = paramb.crh.cqn.optInt("appVersion", 0);
    str2 = paramb.crh.cqn.optString("searchId");
    localObject = paramb.crh.cqn.optString("docId");
    j = paramb.crh.cqn.optInt("position", 1);
    k = paramb.crh.cqn.optInt("scene", 1000);
    str4 = paramb.crh.cqn.optString("privateExtraData");
    localg = new com.tencent.mm.plugin.appbrand.api.g();
    if ((k == 201) || (k == 14) || (k == 22))
    {
      localg.scene = 1006;
      str5 = paramb.crh.cqn.optString("statSessionId");
      str6 = paramb.crh.cqn.optString("statKeywordId");
      str7 = paramb.crh.cqn.optString("subScene");
      localg.fvd = (str5 + ":" + str6 + ":" + str2 + ":" + (String)localObject + ":" + j + ":" + str7);
      localg.nBz = new AppBrandLaunchReferrer();
      localg.nBz.nYC = str4;
      localg.username = str3;
      localg.version = i;
      localg.nBq = str1;
      ((r)com.tencent.mm.kernel.h.ae(r.class)).a(((com.tencent.mm.plugin.webview.luggage.g)paramb.crg).mContext, localg);
      paramb.a("", null);
      AppMethodBeat.o(78592);
      return;
    }
  }
  
  public final int cDj()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openWeAppPage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ap
 * JD-Core Version:    0.7.0.1
 */