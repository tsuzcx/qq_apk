package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.uj.a;
import com.tencent.mm.g.a.uj.b;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class am
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama)
  {
    AppMethodBeat.i(78591);
    ad.i("MicroMsg.JsApiOpenWeApp", "invokeInMM");
    paramString = b.HG(paramString);
    if (paramString == null)
    {
      parama.f("fail_invalid_data", null);
      AppMethodBeat.o(78591);
      return;
    }
    String str1 = paramString.optString("currentUrl");
    String str2 = paramString.optString("preVerifyAppId");
    uj localuj = new uj();
    localuj.dzH.context = paramContext;
    localuj.dzH.userName = paramString.optString("userName");
    localuj.dzH.appId = paramString.optString("appId");
    localuj.dzH.dzJ = paramString.optString("relativeURL");
    localuj.dzH.aAS = paramString.optInt("appVersion", 0);
    localuj.dzH.scene = paramString.optInt("scene", 1018);
    localuj.dzH.dbt = paramString.optString("sceneNote");
    if (bt.isNullOrNil(localuj.dzH.dbt)) {
      localuj.dzH.dbt = p.encode(bt.nullAsNil(str1));
    }
    localuj.dzH.dzL = paramString.optString("downloadURL");
    localuj.dzH.dzK = paramString.optInt("openType", 0);
    localuj.dzH.dzM = paramString.optString("checkSumMd5");
    localuj.dzH.dzO = false;
    localuj.dzH.dzP.gRC = paramString.optString("extJsonInfo");
    localuj.dzH.dzU = str2;
    if (bt.isNullOrNil(localuj.dzH.dzU)) {
      localuj.dzH.dzU = paramString.optString("sourceAppId");
    }
    localuj.dzH.dzV = str1;
    localuj.dzH.dzW = paramString.optString("privateExtraData");
    com.tencent.mm.sdk.b.a.ESL.l(localuj);
    if (localuj.dzI.dzZ)
    {
      parama.f(null, null);
      AppMethodBeat.o(78591);
      return;
    }
    parama.f(bt.nullAsNil(localuj.dzI.dAa), null);
    AppMethodBeat.o(78591);
  }
  
  public final void b(com.tencent.luggage.d.a<f>.a parama) {}
  
  public final int bQV()
  {
    return 1;
  }
  
  public final String name()
  {
    return "openWeApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.am
 * JD-Core Version:    0.7.0.1
 */