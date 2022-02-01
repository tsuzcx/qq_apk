package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.a.zp.a;
import com.tencent.mm.autogen.a.zp.b;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class as
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(78591);
    Log.i("MicroMsg.JsApiOpenWeApp", "invokeInMM");
    paramString = c.ZL(paramString);
    if (paramString == null)
    {
      parama.j("fail_invalid_data", null);
      AppMethodBeat.o(78591);
      return;
    }
    String str1 = paramString.optString("currentUrl");
    String str2 = paramString.optString("preVerifyAppId");
    zp localzp = new zp();
    localzp.icM.context = paramContext;
    localzp.icM.userName = paramString.optString("userName");
    localzp.icM.appId = paramString.optString("appId");
    localzp.icM.icO = paramString.optString("relativeURL");
    localzp.icM.appVersion = paramString.optInt("appVersion", 0);
    localzp.icM.scene = paramString.optInt("scene", 1018);
    localzp.icM.hzx = paramString.optString("sceneNote");
    if (Util.isNullOrNil(localzp.icM.hzx)) {
      localzp.icM.hzx = r.cg(Util.nullAsNil(str1));
    }
    localzp.icM.icR = paramString.optString("downloadURL");
    localzp.icM.icP = paramString.optInt("openType", 0);
    localzp.icM.icS = paramString.optString("checkSumMd5");
    localzp.icM.icU = false;
    localzp.icM.icV.opW = paramString.optString("extJsonInfo");
    localzp.icM.idb = str2;
    if (Util.isNullOrNil(localzp.icM.idb)) {
      localzp.icM.idb = paramString.optString("sourceAppId");
    }
    localzp.icM.idc = str1;
    localzp.icM.idd = paramString.optString("privateExtraData");
    localzp.publish();
    if (localzp.icN.idi)
    {
      parama.j(null, null);
      AppMethodBeat.o(78591);
      return;
    }
    parama.j(Util.nullAsNil(localzp.icN.idj), null);
    AppMethodBeat.o(78591);
  }
  
  public final void b(b<g>.a paramb) {}
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "openWeApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.as
 * JD-Core Version:    0.7.0.1
 */