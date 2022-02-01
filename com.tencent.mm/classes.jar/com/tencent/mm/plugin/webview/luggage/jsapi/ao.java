package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.a.xw.a;
import com.tencent.mm.f.a.xw.b;
import com.tencent.mm.plugin.webview.luggage.c.c;
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
    paramString = c.agO(paramString);
    if (paramString == null)
    {
      parama.i("fail_invalid_data", null);
      AppMethodBeat.o(78591);
      return;
    }
    String str1 = paramString.optString("currentUrl");
    String str2 = paramString.optString("preVerifyAppId");
    xw localxw = new xw();
    localxw.fWN.context = paramContext;
    localxw.fWN.userName = paramString.optString("userName");
    localxw.fWN.appId = paramString.optString("appId");
    localxw.fWN.fWP = paramString.optString("relativeURL");
    localxw.fWN.appVersion = paramString.optInt("appVersion", 0);
    localxw.fWN.scene = paramString.optInt("scene", 1018);
    localxw.fWN.fvd = paramString.optString("sceneNote");
    if (Util.isNullOrNil(localxw.fWN.fvd)) {
      localxw.fWN.fvd = q.aT(Util.nullAsNil(str1));
    }
    localxw.fWN.fWS = paramString.optString("downloadURL");
    localxw.fWN.fWQ = paramString.optInt("openType", 0);
    localxw.fWN.fWT = paramString.optString("checkSumMd5");
    localxw.fWN.fWV = false;
    localxw.fWN.fWW.lyv = paramString.optString("extJsonInfo");
    localxw.fWN.fXc = str2;
    if (Util.isNullOrNil(localxw.fWN.fXc)) {
      localxw.fWN.fXc = paramString.optString("sourceAppId");
    }
    localxw.fWN.fXd = str1;
    localxw.fWN.fXe = paramString.optString("privateExtraData");
    EventCenter.instance.publish(localxw);
    if (localxw.fWO.fXi)
    {
      parama.i(null, null);
      AppMethodBeat.o(78591);
      return;
    }
    parama.i(Util.nullAsNil(localxw.fWO.fXj), null);
    AppMethodBeat.o(78591);
  }
  
  public final void b(b<g>.a paramb) {}
  
  public final int cDj()
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