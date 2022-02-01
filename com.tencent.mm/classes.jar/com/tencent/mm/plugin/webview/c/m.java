package com.tencent.mm.plugin.webview.c;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.core.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import java.util.HashMap;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/jsapi/WebViewJsApiPool;", "", "()V", "TAG", "", "jsApiFrequentHelper", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper;", "jsApis", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "setJsApis", "(Ljava/util/Map;)V", "getJsApi", "function", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "initReportData", "", "report", "isSucc", "reportTooFrequent", "api", "webview-sdk_release"})
public final class m
{
  static Map<String, a> EfB;
  static final e EfC;
  public static final m EfD;
  
  static
  {
    AppMethodBeat.i(214169);
    EfD = new m();
    EfB = (Map)new HashMap();
    EfC = new e();
    AppMethodBeat.o(214169);
  }
  
  static void a(d paramd, a parama)
  {
    AppMethodBeat.i(214166);
    paramd = paramd.context;
    if ((paramd instanceof b))
    {
      paramd = ((b)paramd).eRj();
      EfC.Q(parama.eSw(), parama.eSx(), paramd);
    }
    AppMethodBeat.o(214166);
  }
  
  static void a(l paraml, boolean paramBoolean)
  {
    AppMethodBeat.i(214167);
    if (paraml == null)
    {
      ae.e("MicroMsg.WebViewJsApiPool", "msg is null when report.");
      AppMethodBeat.o(214167);
      return;
    }
    String str = paraml.lcx;
    Map localMap = paraml.eSE();
    Object localObject = paraml.xqN.get("key_wxapp_id");
    paraml = localObject;
    if (!(localObject instanceof String)) {
      paraml = null;
    }
    paraml = bu.bI((String)paraml, "");
    if (localMap != null)
    {
      localMap.put("isSuccess", Boolean.valueOf(paramBoolean));
      localMap.put("containerEnv", paraml);
    }
    n.K(str, localMap);
    AppMethodBeat.o(214167);
  }
  
  public static a aIm(String paramString)
  {
    AppMethodBeat.i(214168);
    p.h(paramString, "function");
    if (EfB.containsKey(paramString))
    {
      paramString = (a)EfB.get(paramString);
      AppMethodBeat.o(214168);
      return paramString;
    }
    AppMethodBeat.o(214168);
    return null;
  }
  
  static void b(d paramd, l paraml)
  {
    AppMethodBeat.i(214165);
    if (!n.aIn(paraml.lcx))
    {
      AppMethodBeat.o(214165);
      return;
    }
    paramd = paramd.context;
    if ((paramd instanceof b)) {
      n.aT(((b)paramd).bRn(), ((b)paramd).eRj(), ((b)paramd).getIntent().getStringExtra("srcUsername"));
    }
    AppMethodBeat.o(214165);
  }
  
  public static void bI(Map<String, a> paramMap)
  {
    AppMethodBeat.i(214164);
    p.h(paramMap, "<set-?>");
    EfB = paramMap;
    AppMethodBeat.o(214164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.m
 * JD-Core Version:    0.7.0.1
 */