package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wq.a;
import com.tencent.mm.g.a.wq.b;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class ao
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama)
  {
    AppMethodBeat.i(78591);
    Log.i("MicroMsg.JsApiOpenWeApp", "invokeInMM");
    paramString = com.tencent.mm.plugin.webview.luggage.c.b.Zc(paramString);
    if (paramString == null)
    {
      parama.i("fail_invalid_data", null);
      AppMethodBeat.o(78591);
      return;
    }
    String str1 = paramString.optString("currentUrl");
    String str2 = paramString.optString("preVerifyAppId");
    wq localwq = new wq();
    localwq.ecI.context = paramContext;
    localwq.ecI.userName = paramString.optString("userName");
    localwq.ecI.appId = paramString.optString("appId");
    localwq.ecI.ecK = paramString.optString("relativeURL");
    localwq.ecI.appVersion = paramString.optInt("appVersion", 0);
    localwq.ecI.scene = paramString.optInt("scene", 1018);
    localwq.ecI.dCw = paramString.optString("sceneNote");
    if (Util.isNullOrNil(localwq.ecI.dCw)) {
      localwq.ecI.dCw = q.encode(Util.nullAsNil(str1));
    }
    localwq.ecI.ecN = paramString.optString("downloadURL");
    localwq.ecI.ecL = paramString.optInt("openType", 0);
    localwq.ecI.ecO = paramString.optString("checkSumMd5");
    localwq.ecI.ecQ = false;
    localwq.ecI.ecR.iIt = paramString.optString("extJsonInfo");
    localwq.ecI.ecW = str2;
    if (Util.isNullOrNil(localwq.ecI.ecW)) {
      localwq.ecI.ecW = paramString.optString("sourceAppId");
    }
    localwq.ecI.ecX = str1;
    localwq.ecI.ecY = paramString.optString("privateExtraData");
    EventCenter.instance.publish(localwq);
    if (localwq.ecJ.edc)
    {
      parama.i(null, null);
      AppMethodBeat.o(78591);
      return;
    }
    parama.i(Util.nullAsNil(localwq.ecJ.edd), null);
    AppMethodBeat.o(78591);
  }
  
  public final void b(com.tencent.luggage.d.b<g>.a paramb) {}
  
  public final int dTs()
  {
    return 1;
  }
  
  public final String name()
  {
    return "openWeApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ao
 * JD-Core Version:    0.7.0.1
 */