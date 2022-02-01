package com.tencent.mm.plugin.webview.d;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.b;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/jsapi/WebViewJsApiPool;", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "()V", "TAG", "", "jsApiFrequentHelper", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper;", "jsApis", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "setJsApis", "(Ljava/util/Map;)V", "getJsApi", "function", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "initReportData", "", "report", "isSucc", "reportTooFrequent", "api", "support", "webview-sdk_release"})
public final class p
  implements e
{
  private static Map<String, a> ISh;
  private static final g ISj;
  public static final p ISk;
  
  static
  {
    AppMethodBeat.i(225119);
    ISk = new p();
    ISh = (Map)new HashMap();
    ISj = new g();
    AppMethodBeat.o(225119);
  }
  
  public static a aYo(String paramString)
  {
    AppMethodBeat.i(225118);
    kotlin.g.b.p.h(paramString, "function");
    if (ISh.containsKey(paramString))
    {
      paramString = (a)ISh.get(paramString);
      AppMethodBeat.o(225118);
      return paramString;
    }
    AppMethodBeat.o(225118);
    return null;
  }
  
  public static void bN(Map<String, a> paramMap)
  {
    AppMethodBeat.i(225115);
    kotlin.g.b.p.h(paramMap, "<set-?>");
    ISh = paramMap;
    AppMethodBeat.o(225115);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(225117);
    kotlin.g.b.p.h(paramf, "env");
    kotlin.g.b.p.h(paramn, "msg");
    if ((BuildInfo.DEBUG) && (1 > Log.getLogLevel())) {
      if (ISh.isEmpty()) {
        break label169;
      }
    }
    Object localObject;
    label169:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("handleMsg jsApis isEmpty", bool);
      if (!ISh.containsKey(paramn.mhO)) {
        break label435;
      }
      localObject = ISh.get(paramn.mhO);
      if (localObject == null) {
        kotlin.g.b.p.hyc();
      }
      localObject = (a)localObject;
      if (!ISj.afT(((a)localObject).ePA())) {
        break;
      }
      paramf.IQZ.h(paramn.ISe, "system:too_frequent", null);
      paramf = paramf.context;
      if ((paramf instanceof b))
      {
        paramf = ((b)paramf).fZM();
        ISj.S(((a)localObject).ePA(), ((a)localObject).ePz(), paramf);
      }
      AppMethodBeat.o(225117);
      return true;
    }
    int i = ((a)localObject).ePA();
    if (paramf.IBv.pP(i)) {}
    for (bool = ((a)localObject).a(paramf, paramn); (!bool) && (Util.isEqual(((a)localObject).ePz(), "handleMPPageAction")); bool = false)
    {
      AppMethodBeat.o(225117);
      return false;
      Log.e("MicroMsg.WebViewJsApiPool", "handleMsg access denied func: " + paramn.mhO);
      paramf.IQZ.h(paramn.ISe, "system:access_denied", null);
    }
    if (r.aYp(paramn.mhO))
    {
      paramf = paramf.context;
      if ((paramf instanceof b)) {
        r.bd(((b)paramf).coX(), ((b)paramf).fZM(), ((b)paramf).getIntent().getStringExtra("srcUsername"));
      }
    }
    if (paramn == null) {
      Log.e("MicroMsg.WebViewJsApiPool", "msg is null when report.");
    }
    for (;;)
    {
      AppMethodBeat.o(225117);
      return true;
      localObject = paramn.mhO;
      Map localMap = paramn.gbq();
      paramn = paramn.params.get("key_wxapp_id");
      paramf = paramn;
      if (!(paramn instanceof String)) {
        paramf = null;
      }
      paramf = Util.nullAs((String)paramf, "");
      if (localMap != null)
      {
        localMap.put("isSuccess", Boolean.valueOf(bool));
        localMap.put("containerEnv", paramf);
      }
      r.P((String)localObject, localMap);
    }
    label435:
    AppMethodBeat.o(225117);
    return false;
  }
  
  public final boolean b(f paramf, n paramn)
  {
    AppMethodBeat.i(225116);
    kotlin.g.b.p.h(paramf, "env");
    kotlin.g.b.p.h(paramn, "msg");
    boolean bool = ISh.containsKey(paramn.mhO);
    AppMethodBeat.o(225116);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.p
 * JD-Core Version:    0.7.0.1
 */