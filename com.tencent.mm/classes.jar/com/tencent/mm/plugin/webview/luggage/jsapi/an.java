package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.vq.a;
import com.tencent.mm.g.a.vq.b;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public class an
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama)
  {
    AppMethodBeat.i(78591);
    ae.i("MicroMsg.JsApiOpenWeApp", "invokeInMM");
    paramString = com.tencent.mm.plugin.webview.luggage.c.b.PM(paramString);
    if (paramString == null)
    {
      parama.f("fail_invalid_data", null);
      AppMethodBeat.o(78591);
      return;
    }
    String str1 = paramString.optString("currentUrl");
    String str2 = paramString.optString("preVerifyAppId");
    vq localvq = new vq();
    localvq.dKT.context = paramContext;
    localvq.dKT.userName = paramString.optString("userName");
    localvq.dKT.appId = paramString.optString("appId");
    localvq.dKT.dKV = paramString.optString("relativeURL");
    localvq.dKT.aDD = paramString.optInt("appVersion", 0);
    localvq.dKT.scene = paramString.optInt("scene", 1018);
    localvq.dKT.dlj = paramString.optString("sceneNote");
    if (bu.isNullOrNil(localvq.dKT.dlj)) {
      localvq.dKT.dlj = q.encode(bu.nullAsNil(str1));
    }
    localvq.dKT.dKY = paramString.optString("downloadURL");
    localvq.dKT.dKW = paramString.optInt("openType", 0);
    localvq.dKT.dKZ = paramString.optString("checkSumMd5");
    localvq.dKT.dLb = false;
    localvq.dKT.dLc.hNn = paramString.optString("extJsonInfo");
    localvq.dKT.dLh = str2;
    if (bu.isNullOrNil(localvq.dKT.dLh)) {
      localvq.dKT.dLh = paramString.optString("sourceAppId");
    }
    localvq.dKT.dLi = str1;
    localvq.dKT.dLj = paramString.optString("privateExtraData");
    a.IvT.l(localvq);
    if (localvq.dKU.dLn)
    {
      parama.f(null, null);
      AppMethodBeat.o(78591);
      return;
    }
    parama.f(bu.nullAsNil(localvq.dKU.dLo), null);
    AppMethodBeat.o(78591);
  }
  
  public final void b(com.tencent.luggage.d.b<g>.a paramb) {}
  
  public final int ced()
  {
    return 1;
  }
  
  public final String name()
  {
    return "openWeApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.an
 * JD-Core Version:    0.7.0.1
 */