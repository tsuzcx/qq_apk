package com.tencent.mm.plugin.webview.c;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.core.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import java.util.HashMap;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/jsapi/WebViewJsApiPool;", "", "()V", "TAG", "", "jsApiFrequentHelper", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper;", "jsApis", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "setJsApis", "(Ljava/util/Map;)V", "getJsApi", "function", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "initReportData", "", "report", "isSucc", "reportTooFrequent", "api", "webview-sdk_release"})
public final class m
{
  static Map<String, a> DNC;
  static final e DND;
  public static final m DNE;
  
  static
  {
    AppMethodBeat.i(214328);
    DNE = new m();
    DNC = (Map)new HashMap();
    DND = new e();
    AppMethodBeat.o(214328);
  }
  
  static void a(d paramd, a parama)
  {
    AppMethodBeat.i(214325);
    paramd = paramd.context;
    if ((paramd instanceof b))
    {
      paramd = ((b)paramd).eNy();
      DND.Q(parama.eOL(), parama.eOM(), paramd);
    }
    AppMethodBeat.o(214325);
  }
  
  static void a(l paraml, boolean paramBoolean)
  {
    AppMethodBeat.i(214326);
    if (paraml == null)
    {
      ad.e("MicroMsg.WebViewJsApiPool", "msg is null when report.");
      AppMethodBeat.o(214326);
      return;
    }
    String str = paraml.kYO;
    Map localMap = paraml.eOT();
    Object localObject = paraml.xaW.get("key_wxapp_id");
    paraml = localObject;
    if (!(localObject instanceof String)) {
      paraml = null;
    }
    paraml = bt.bI((String)paraml, "");
    if (localMap != null)
    {
      localMap.put("isSuccess", Boolean.valueOf(paramBoolean));
      localMap.put("containerEnv", paraml);
    }
    n.J(str, localMap);
    AppMethodBeat.o(214326);
  }
  
  public static a aGS(String paramString)
  {
    AppMethodBeat.i(214327);
    p.h(paramString, "function");
    if (DNC.containsKey(paramString))
    {
      paramString = (a)DNC.get(paramString);
      AppMethodBeat.o(214327);
      return paramString;
    }
    AppMethodBeat.o(214327);
    return null;
  }
  
  static void b(d paramd, l paraml)
  {
    AppMethodBeat.i(214324);
    if (!n.aGT(paraml.kYO))
    {
      AppMethodBeat.o(214324);
      return;
    }
    paramd = paramd.context;
    if ((paramd instanceof b)) {
      n.aS(((b)paramd).bQm(), ((b)paramd).eNy(), ((b)paramd).getIntent().getStringExtra("srcUsername"));
    }
    AppMethodBeat.o(214324);
  }
  
  public static void bC(Map<String, a> paramMap)
  {
    AppMethodBeat.i(214323);
    p.h(paramMap, "<set-?>");
    DNC = paramMap;
    AppMethodBeat.o(214323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.m
 * JD-Core Version:    0.7.0.1
 */