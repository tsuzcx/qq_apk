package com.tencent.mm.plugin.webview.c;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.core.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import java.util.HashMap;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/jsapi/WebViewJsApiPool;", "", "()V", "TAG", "", "jsApiFrequentHelper", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper;", "jsApis", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "setJsApis", "(Ljava/util/Map;)V", "getJsApi", "function", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "initReportData", "", "report", "isSucc", "reportTooFrequent", "api", "webview-sdk_release"})
public final class m
{
  static Map<String, a> ASk;
  static final e ASl;
  public static final m ASm;
  
  static
  {
    AppMethodBeat.i(189407);
    ASm = new m();
    ASk = (Map)new HashMap();
    ASl = new e();
    AppMethodBeat.o(189407);
  }
  
  static void a(d paramd, a parama)
  {
    AppMethodBeat.i(189404);
    paramd = paramd.context;
    if ((paramd instanceof b))
    {
      paramd = ((b)paramd).ejo();
      ASl.N(parama.ekB(), parama.ekC(), paramd);
    }
    AppMethodBeat.o(189404);
  }
  
  static void a(l paraml, boolean paramBoolean)
  {
    AppMethodBeat.i(189405);
    if (paraml == null)
    {
      ad.e("MicroMsg.WebViewJsApiPool", "msg is null when report.");
      AppMethodBeat.o(189405);
      return;
    }
    String str = paraml.kbU;
    Map localMap = paraml.ekJ();
    Object localObject = paraml.uLu.get("key_wxapp_id");
    paraml = localObject;
    if (!(localObject instanceof String)) {
      paraml = null;
    }
    paraml = bt.by((String)paraml, "");
    if (localMap != null)
    {
      localMap.put("isSuccess", Boolean.valueOf(paramBoolean));
      localMap.put("containerEnv", paraml);
    }
    n.H(str, localMap);
    AppMethodBeat.o(189405);
  }
  
  public static a awd(String paramString)
  {
    AppMethodBeat.i(189406);
    k.h(paramString, "function");
    if (ASk.containsKey(paramString))
    {
      paramString = (a)ASk.get(paramString);
      AppMethodBeat.o(189406);
      return paramString;
    }
    AppMethodBeat.o(189406);
    return null;
  }
  
  static void b(d paramd, l paraml)
  {
    AppMethodBeat.i(189403);
    if (!n.awe(paraml.kbU))
    {
      AppMethodBeat.o(189403);
      return;
    }
    paramd = paramd.context;
    if ((paramd instanceof b)) {
      n.aH(((b)paramd).bEx(), ((b)paramd).ejo(), ((b)paramd).getIntent().getStringExtra("srcUsername"));
    }
    AppMethodBeat.o(189403);
  }
  
  public static void bu(Map<String, a> paramMap)
  {
    AppMethodBeat.i(189402);
    k.h(paramMap, "<set-?>");
    ASk = paramMap;
    AppMethodBeat.o(189402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.m
 * JD-Core Version:    0.7.0.1
 */