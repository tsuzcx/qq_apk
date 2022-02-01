package com.tencent.mm.plugin.webview.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.d;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/jsapi/WebViewJsApiPool;", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "()V", "TAG", "", "jsApiFrequentHelper", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper;", "jsApis", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "setJsApis", "(Ljava/util/Map;)V", "getJsApi", "function", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "initReportData", "", "report", "isSucc", "reportTooFrequent", "api", "support", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  implements g
{
  private static Map<String, a> WEL;
  public static final s WEN;
  private static final i WEO;
  
  static
  {
    AppMethodBeat.i(295341);
    WEN = new s();
    WEL = (Map)new HashMap();
    WEO = new i();
    AppMethodBeat.o(295341);
  }
  
  private static void a(h paramh, a parama)
  {
    AppMethodBeat.i(295313);
    paramh = paramh.context;
    if ((paramh instanceof d))
    {
      paramh = ((d)paramh).fqa();
      WEO.Z(parama.gPZ(), parama.gPX(), paramh);
    }
    AppMethodBeat.o(295313);
  }
  
  private static void a(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(295326);
    if (paramp == null)
    {
      Log.e("MicroMsg.WebViewJsApiPool", "msg is null when report.");
      AppMethodBeat.o(295326);
      return;
    }
    String str = paramp.function;
    Map localMap = paramp.WEJ;
    paramp = paramp.params.get("key_wxapp_id");
    if ((paramp instanceof String)) {}
    for (paramp = (String)paramp;; paramp = null)
    {
      paramp = Util.nullAs(paramp, "");
      if (localMap != null)
      {
        localMap.put("isSuccess", Boolean.valueOf(paramBoolean));
        localMap.put("containerEnv", paramp);
      }
      u.w(str, localMap);
      AppMethodBeat.o(295326);
      return;
    }
  }
  
  public static a bjT(String paramString)
  {
    AppMethodBeat.i(295331);
    kotlin.g.b.s.u(paramString, "function");
    if (WEL.containsKey(paramString))
    {
      paramString = (a)WEL.get(paramString);
      AppMethodBeat.o(295331);
      return paramString;
    }
    AppMethodBeat.o(295331);
    return null;
  }
  
  private static void c(h paramh, p paramp)
  {
    AppMethodBeat.i(295303);
    if (!u.bjU(paramp.function))
    {
      AppMethodBeat.o(295303);
      return;
    }
    paramh = paramh.context;
    if ((paramh instanceof d)) {
      u.br(((d)paramh).dgY(), ((d)paramh).fqa(), ((d)paramh).getIntent().getStringExtra("srcUsername"));
    }
    AppMethodBeat.o(295303);
  }
  
  public static void cl(Map<String, a> paramMap)
  {
    AppMethodBeat.i(295292);
    kotlin.g.b.s.u(paramMap, "<set-?>");
    WEL = paramMap;
    AppMethodBeat.o(295292);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(295368);
    kotlin.g.b.s.u(paramh, "env");
    kotlin.g.b.s.u(paramp, "msg");
    if ((BuildInfo.DEBUG) && (1 > Log.getLogLevel())) {
      if (WEL.isEmpty()) {
        break label133;
      }
    }
    Object localObject;
    label133:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("handleMsg jsApis isEmpty", bool);
      if (!WEL.containsKey(paramp.function)) {
        break label244;
      }
      localObject = WEL.get(paramp.function);
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = (a)localObject;
      if (!WEO.atB(((a)localObject).gPZ())) {
        break;
      }
      paramh.WDy.doCallback(paramp.WEH, "system:too_frequent", null);
      a(paramh, (a)localObject);
      AppMethodBeat.o(295368);
      return true;
    }
    if (paramh.sk(((a)localObject).gPZ())) {}
    for (bool = ((a)localObject).a(paramh, paramp); (!bool) && (((a)localObject).itW()); bool = false)
    {
      AppMethodBeat.o(295368);
      return false;
      Log.e("MicroMsg.WebViewJsApiPool", kotlin.g.b.s.X("handleMsg access denied func: ", paramp.function));
      if (!kotlin.g.b.s.p(paramp.function, "log")) {
        paramh.WDy.doCallback(paramp.WEH, "system:access_denied", null);
      }
    }
    c(paramh, paramp);
    a(paramp, bool);
    AppMethodBeat.o(295368);
    return true;
    label244:
    AppMethodBeat.o(295368);
    return false;
  }
  
  public final boolean b(h paramh, p paramp)
  {
    AppMethodBeat.i(295349);
    kotlin.g.b.s.u(paramh, "env");
    kotlin.g.b.s.u(paramp, "msg");
    boolean bool = WEL.containsKey(paramp.function);
    AppMethodBeat.o(295349);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.s
 * JD-Core Version:    0.7.0.1
 */