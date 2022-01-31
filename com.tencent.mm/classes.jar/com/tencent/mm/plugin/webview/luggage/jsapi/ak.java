package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.net.Uri;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.webview.fts.h;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public class ak
  extends bi<com.tencent.mm.plugin.webview.luggage.e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    int j = 1;
    i = 0;
    AppMethodBeat.i(153124);
    ab.i("MicroMsg.JsApiOpenWeAppPage", "invokeInOwn %s", new Object[] { parama.byF.bxK });
    String str3 = parama.byF.bxK.optString("userName");
    String str2 = parama.byF.bxK.optString("relativeURL");
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
        int m;
        int n;
        int i1;
        int k;
        AppBrandStatObject localAppBrandStatObject;
        String str4;
        String str5;
        String str6;
        ab.printErrStackTrace("MicroMsg.JsApiOpenWeAppPage", localJSONException, "", new Object[0]);
        continue;
        if (i1 == 3)
        {
          localAppBrandStatObject.scene = 1005;
        }
        else if (i1 == 16)
        {
          localAppBrandStatObject.scene = 1042;
        }
        else if (i1 == 20)
        {
          localAppBrandStatObject.scene = 1053;
        }
        else
        {
          localAppBrandStatObject.scene = 1000;
          continue;
          continue;
          i = k;
        }
      }
    }
    m = parama.byF.bxK.optInt("appVersion", 0);
    str2 = parama.byF.bxK.optString("searchId");
    localObject = parama.byF.bxK.optString("docId");
    n = parama.byF.bxK.optInt("position", 1);
    i1 = parama.byF.bxK.optInt("scene", 1000);
    k = parama.byF.bxK.optInt("debugMode", 0);
    if (k < 0) {
      if (com.tencent.mm.plugin.webview.modeltools.g.dcC().uIS != null)
      {
        i = j;
        localAppBrandStatObject = new AppBrandStatObject();
        if ((i1 == 201) || (i1 == 14) || (i1 == 22))
        {
          localAppBrandStatObject.scene = 1006;
          str4 = parama.byF.bxK.optString("statSessionId");
          str5 = parama.byF.bxK.optString("statKeywordId");
          str6 = parama.byF.bxK.optString("subScene");
          localAppBrandStatObject.cmF = (str4 + ":" + str5 + ":" + str2 + ":" + (String)localObject + ":" + n + ":" + str6);
          ((j)com.tencent.mm.kernel.g.E(j.class)).a(((com.tencent.mm.plugin.webview.luggage.e)parama.byE).mContext, str3, null, i, m, str1, localAppBrandStatObject);
          parama.a("", null);
          AppMethodBeat.o(153124);
          return;
        }
      }
    }
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openWeAppPage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ak
 * JD-Core Version:    0.7.0.1
 */