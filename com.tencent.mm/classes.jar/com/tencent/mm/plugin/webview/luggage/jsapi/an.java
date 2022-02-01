package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.vm.a;
import com.tencent.mm.g.a.vm.b;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class an
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama)
  {
    AppMethodBeat.i(78591);
    ad.i("MicroMsg.JsApiOpenWeApp", "invokeInMM");
    paramString = com.tencent.mm.plugin.webview.luggage.c.b.Pe(paramString);
    if (paramString == null)
    {
      parama.f("fail_invalid_data", null);
      AppMethodBeat.o(78591);
      return;
    }
    String str1 = paramString.optString("currentUrl");
    String str2 = paramString.optString("preVerifyAppId");
    vm localvm = new vm();
    localvm.dJF.context = paramContext;
    localvm.dJF.userName = paramString.optString("userName");
    localvm.dJF.appId = paramString.optString("appId");
    localvm.dJF.dJH = paramString.optString("relativeURL");
    localvm.dJF.aDD = paramString.optInt("appVersion", 0);
    localvm.dJF.scene = paramString.optInt("scene", 1018);
    localvm.dJF.dkh = paramString.optString("sceneNote");
    if (bt.isNullOrNil(localvm.dJF.dkh)) {
      localvm.dJF.dkh = q.encode(bt.nullAsNil(str1));
    }
    localvm.dJF.dJJ = paramString.optString("downloadURL");
    localvm.dJF.dJI = paramString.optInt("openType", 0);
    localvm.dJF.dJK = paramString.optString("checkSumMd5");
    localvm.dJF.dJM = false;
    localvm.dJF.dJN.hKu = paramString.optString("extJsonInfo");
    localvm.dJF.dJS = str2;
    if (bt.isNullOrNil(localvm.dJF.dJS)) {
      localvm.dJF.dJS = paramString.optString("sourceAppId");
    }
    localvm.dJF.dJT = str1;
    localvm.dJF.dJU = paramString.optString("privateExtraData");
    a.IbL.l(localvm);
    if (localvm.dJG.dJY)
    {
      parama.f(null, null);
      AppMethodBeat.o(78591);
      return;
    }
    parama.f(bt.nullAsNil(localvm.dJG.dJZ), null);
    AppMethodBeat.o(78591);
  }
  
  public final void b(com.tencent.luggage.d.b<g>.a paramb) {}
  
  public final int ccO()
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