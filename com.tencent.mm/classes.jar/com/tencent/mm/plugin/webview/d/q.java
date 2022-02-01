package com.tencent.mm.plugin.webview.d;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.b;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/jsapi/WebViewJsApiPool;", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "()V", "TAG", "", "jsApiFrequentHelper", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper;", "jsApis", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "setJsApis", "(Ljava/util/Map;)V", "getJsApi", "function", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "initReportData", "", "report", "isSucc", "reportTooFrequent", "api", "support", "webview-sdk_release"})
public final class q
  implements e
{
  private static final g POA;
  public static final q POB;
  private static Map<String, a> POx;
  
  static
  {
    AppMethodBeat.i(206974);
    POB = new q();
    POx = (Map)new HashMap();
    POA = new g();
    AppMethodBeat.o(206974);
  }
  
  private static void a(f paramf, a parama)
  {
    AppMethodBeat.i(206971);
    paramf = paramf.context;
    if ((paramf instanceof b))
    {
      paramf = ((b)paramf).elY();
      POA.W(parama.fCn(), parama.fCm(), paramf);
    }
    AppMethodBeat.o(206971);
  }
  
  private static void a(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(206972);
    if (paramn == null)
    {
      Log.e("MicroMsg.WebViewJsApiPool", "msg is null when report.");
      AppMethodBeat.o(206972);
      return;
    }
    String str = paramn.function;
    Map localMap = paramn.gUk();
    Object localObject = paramn.params.get("key_wxapp_id");
    paramn = localObject;
    if (!(localObject instanceof String)) {
      paramn = null;
    }
    paramn = Util.nullAs((String)paramn, "");
    if (localMap != null)
    {
      localMap.put("isSuccess", Boolean.valueOf(paramBoolean));
      localMap.put("containerEnv", paramn);
    }
    s.S(str, localMap);
    AppMethodBeat.o(206972);
  }
  
  public static void bS(Map<String, a> paramMap)
  {
    AppMethodBeat.i(206966);
    p.k(paramMap, "<set-?>");
    POx = paramMap;
    AppMethodBeat.o(206966);
  }
  
  public static a bkj(String paramString)
  {
    AppMethodBeat.i(206973);
    p.k(paramString, "function");
    if (POx.containsKey(paramString))
    {
      paramString = (a)POx.get(paramString);
      AppMethodBeat.o(206973);
      return paramString;
    }
    AppMethodBeat.o(206973);
    return null;
  }
  
  private static void c(f paramf, n paramn)
  {
    AppMethodBeat.i(206969);
    if (!s.bkk(paramn.function))
    {
      AppMethodBeat.o(206969);
      return;
    }
    paramf = paramf.context;
    if ((paramf instanceof b)) {
      s.aY(((b)paramf).cDu(), ((b)paramf).elY(), ((b)paramf).getIntent().getStringExtra("srcUsername"));
    }
    AppMethodBeat.o(206969);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(206968);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    if ((BuildInfo.DEBUG) && (1 > Log.getLogLevel())) {
      if (POx.isEmpty()) {
        break label134;
      }
    }
    Object localObject;
    label134:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("handleMsg jsApis isEmpty", bool);
      if (!POx.containsKey(paramn.function)) {
        break label246;
      }
      localObject = POx.get(paramn.function);
      if (localObject == null) {
        p.iCn();
      }
      localObject = (a)localObject;
      if (!POA.anH(((a)localObject).fCn())) {
        break;
      }
      paramf.PNo.h(paramn.POu, "system:too_frequent", null);
      a(paramf, (a)localObject);
      AppMethodBeat.o(206968);
      return true;
    }
    if (paramf.so(((a)localObject).fCn())) {}
    for (bool = ((a)localObject).a(paramf, paramn); (!bool) && (Util.isEqual(((a)localObject).fCm(), "handleMPPageAction")); bool = false)
    {
      AppMethodBeat.o(206968);
      return false;
      Log.e("MicroMsg.WebViewJsApiPool", "handleMsg access denied func: " + paramn.function);
      paramf.PNo.h(paramn.POu, "system:access_denied", null);
    }
    c(paramf, paramn);
    a(paramn, bool);
    AppMethodBeat.o(206968);
    return true;
    label246:
    AppMethodBeat.o(206968);
    return false;
  }
  
  public final boolean b(f paramf, n paramn)
  {
    AppMethodBeat.i(206967);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    boolean bool = POx.containsKey(paramn.function);
    AppMethodBeat.o(206967);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.q
 * JD-Core Version:    0.7.0.1
 */