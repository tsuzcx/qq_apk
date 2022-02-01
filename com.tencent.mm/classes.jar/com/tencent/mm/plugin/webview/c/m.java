package com.tencent.mm.plugin.webview.c;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.core.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import java.util.HashMap;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/jsapi/WebViewJsApiPool;", "", "()V", "TAG", "", "jsApiFrequentHelper", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper;", "jsApis", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "setJsApis", "(Ljava/util/Map;)V", "getJsApi", "function", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "initReportData", "", "report", "isSucc", "reportTooFrequent", "api", "webview-sdk_release"})
public final class m
{
  static Map<String, a> Ckx;
  static final e Cky;
  public static final m Ckz;
  
  static
  {
    AppMethodBeat.i(205539);
    Ckz = new m();
    Ckx = (Map)new HashMap();
    Cky = new e();
    AppMethodBeat.o(205539);
  }
  
  static void a(d paramd, a parama)
  {
    AppMethodBeat.i(205536);
    paramd = paramd.context;
    if ((paramd instanceof b))
    {
      paramd = ((b)paramd).eyJ();
      Cky.N(parama.ezX(), parama.ezY(), paramd);
    }
    AppMethodBeat.o(205536);
  }
  
  static void a(l paraml, boolean paramBoolean)
  {
    AppMethodBeat.i(205537);
    if (paraml == null)
    {
      ac.e("MicroMsg.WebViewJsApiPool", "msg is null when report.");
      AppMethodBeat.o(205537);
      return;
    }
    String str = paraml.kCH;
    Map localMap = paraml.eAf();
    Object localObject = paraml.vUl.get("key_wxapp_id");
    paraml = localObject;
    if (!(localObject instanceof String)) {
      paraml = null;
    }
    paraml = bs.bG((String)paraml, "");
    if (localMap != null)
    {
      localMap.put("isSuccess", Boolean.valueOf(paramBoolean));
      localMap.put("containerEnv", paraml);
    }
    n.I(str, localMap);
    AppMethodBeat.o(205537);
  }
  
  public static a aBv(String paramString)
  {
    AppMethodBeat.i(205538);
    k.h(paramString, "function");
    if (Ckx.containsKey(paramString))
    {
      paramString = (a)Ckx.get(paramString);
      AppMethodBeat.o(205538);
      return paramString;
    }
    AppMethodBeat.o(205538);
    return null;
  }
  
  static void b(d paramd, l paraml)
  {
    AppMethodBeat.i(205535);
    if (!n.aBw(paraml.kCH))
    {
      AppMethodBeat.o(205535);
      return;
    }
    paramd = paramd.context;
    if ((paramd instanceof b)) {
      n.aK(((b)paramd).bLL(), ((b)paramd).eyJ(), ((b)paramd).getIntent().getStringExtra("srcUsername"));
    }
    AppMethodBeat.o(205535);
  }
  
  public static void bz(Map<String, a> paramMap)
  {
    AppMethodBeat.i(205534);
    k.h(paramMap, "<set-?>");
    Ckx = paramMap;
    AppMethodBeat.o(205534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.m
 * JD-Core Version:    0.7.0.1
 */