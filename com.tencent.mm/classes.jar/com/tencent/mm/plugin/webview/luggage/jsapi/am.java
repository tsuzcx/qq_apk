package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.a.ut.a;
import com.tencent.mm.g.a.ut.b;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public class am
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama)
  {
    AppMethodBeat.i(78591);
    ac.i("MicroMsg.JsApiOpenWeApp", "invokeInMM");
    paramString = b.LK(paramString);
    if (paramString == null)
    {
      parama.f("fail_invalid_data", null);
      AppMethodBeat.o(78591);
      return;
    }
    String str1 = paramString.optString("currentUrl");
    String str2 = paramString.optString("preVerifyAppId");
    ut localut = new ut();
    localut.dxt.context = paramContext;
    localut.dxt.userName = paramString.optString("userName");
    localut.dxt.appId = paramString.optString("appId");
    localut.dxt.dxv = paramString.optString("relativeURL");
    localut.dxt.aBM = paramString.optInt("appVersion", 0);
    localut.dxt.scene = paramString.optInt("scene", 1018);
    localut.dxt.cYP = paramString.optString("sceneNote");
    if (bs.isNullOrNil(localut.dxt.cYP)) {
      localut.dxt.cYP = p.encode(bs.nullAsNil(str1));
    }
    localut.dxt.dxx = paramString.optString("downloadURL");
    localut.dxt.dxw = paramString.optInt("openType", 0);
    localut.dxt.dxy = paramString.optString("checkSumMd5");
    localut.dxt.dxA = false;
    localut.dxt.dxB.hsc = paramString.optString("extJsonInfo");
    localut.dxt.dxG = str2;
    if (bs.isNullOrNil(localut.dxt.dxG)) {
      localut.dxt.dxG = paramString.optString("sourceAppId");
    }
    localut.dxt.dxH = str1;
    localut.dxt.dxI = paramString.optString("privateExtraData");
    com.tencent.mm.sdk.b.a.GpY.l(localut);
    if (localut.dxu.dxL)
    {
      parama.f(null, null);
      AppMethodBeat.o(78591);
      return;
    }
    parama.f(bs.nullAsNil(localut.dxu.dxM), null);
    AppMethodBeat.o(78591);
  }
  
  public final void b(com.tencent.luggage.d.a<f>.a parama) {}
  
  public final int bYk()
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