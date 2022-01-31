package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.a.so.a;
import com.tencent.mm.g.a.so.b;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class aj
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(153123);
    ab.i("MicroMsg.JsApiOpenWeApp", "invokeInMM");
    paramString = b.BJ(paramString);
    if (paramString == null)
    {
      parama.c("fail_invalid_data", null);
      AppMethodBeat.o(153123);
      return;
    }
    String str1 = paramString.optString("currentUrl");
    String str2 = paramString.optString("preVerifyAppId");
    so localso = new so();
    localso.cIQ.context = paramContext;
    localso.cIQ.userName = paramString.optString("userName");
    localso.cIQ.appId = paramString.optString("appId");
    localso.cIQ.cIS = paramString.optString("relativeURL");
    localso.cIQ.bDc = paramString.optInt("appVersion", 0);
    localso.cIQ.scene = paramString.optInt("scene", 1018);
    localso.cIQ.cmF = paramString.optString("sceneNote");
    if (bo.isNullOrNil(localso.cIQ.cmF)) {
      localso.cIQ.cmF = q.encode(bo.nullAsNil(str1));
    }
    localso.cIQ.cIU = paramString.optString("downloadURL");
    localso.cIQ.cIT = paramString.optInt("openType", 0);
    localso.cIQ.cIV = paramString.optString("checkSumMd5");
    localso.cIQ.cIX = false;
    localso.cIQ.cIY.fpV = paramString.optString("extJsonInfo");
    localso.cIQ.cJd = str2;
    if (bo.isNullOrNil(localso.cIQ.cJd)) {
      localso.cIQ.cJd = paramString.optString("sourceAppId");
    }
    localso.cIQ.cJe = str1;
    localso.cIQ.cJf = paramString.optString("privateExtraData");
    com.tencent.mm.sdk.b.a.ymk.l(localso);
    if (localso.cIR.cJh)
    {
      parama.c(null, null);
      AppMethodBeat.o(153123);
      return;
    }
    parama.c(bo.nullAsNil(localso.cIR.cJi), null);
    AppMethodBeat.o(153123);
  }
  
  public final void b(com.tencent.luggage.d.a<e>.a parama) {}
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "openWeApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aj
 * JD-Core Version:    0.7.0.1
 */