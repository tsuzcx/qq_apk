package com.tencent.mm.plugin.webview.l;

import android.os.Bundle;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.n.g;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.ghi;
import com.tencent.mm.protocal.protobuf.ghj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ad;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bu;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "", "webComponent", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "webComptName", "", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;Ljava/lang/String;)V", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getJsPerm", "()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "setJsPerm", "(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;)V", "cgi", "", "callbackId", "request", "errReport", "errMsg", "errStack", "errLine", "", "errCol", "evaluate", "script", "idkey", "id", "", "key", "value", "idkeyList", "list", "invoke", "message", "kv", "data", "log", "level", "tag", "msg", "performance", "frontEndPerformance", "refreshA8Key", "sendMessage", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  private static final String TAG;
  public static final a Xwr;
  public JsapiPermissionWrapper WlV;
  private final com.tencent.mm.plugin.webview.jsapi.c WlW;
  private final String XvD;
  private final c Xws;
  
  static
  {
    AppMethodBeat.i(82957);
    Xwr = new a((byte)0);
    TAG = "WebComptContextJsApiHandler";
    AppMethodBeat.o(82957);
  }
  
  public h(c paramc, String paramString)
  {
    AppMethodBeat.i(295399);
    this.Xws = paramc;
    this.XvD = paramString;
    this.WlW = new h..ExternalSyntheticLambda1(this);
    AppMethodBeat.o(295399);
  }
  
  private static final void a(h paramh, String paramString)
  {
    AppMethodBeat.i(295420);
    Object localObject = paramh.Xws.XuM;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.webview.jsapi.j)((WeakReference)localObject).get();
      if (localObject != null)
      {
        JsapiPermissionWrapper localJsapiPermissionWrapper = paramh.iwo();
        Bundle localBundle = new Bundle();
        localBundle.putString("name", paramh.XvD);
        ah localah = ah.aiuX;
        ((com.tencent.mm.plugin.webview.jsapi.j)localObject).a(paramString, localJsapiPermissionWrapper, localBundle, paramh.WlW);
      }
    }
    AppMethodBeat.o(295420);
  }
  
  private static final void a(h paramh, String paramString1, int paramInt1, int paramInt2, String paramString2, com.tencent.mm.am.c paramc)
  {
    AppMethodBeat.i(295434);
    kotlin.g.b.s.u(paramh, "this$0");
    kotlin.g.b.s.u(paramString1, "$callbackId");
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      paramc = new StringBuilder("WeixinWebCompt._callback(").append(a.bnf(paramString1)).append(", {errType:").append(paramInt1).append(", errCode:").append(paramInt2).append(", errMsg:");
      if (paramString2 == null) {
        paramString1 = "";
      }
      for (;;)
      {
        paramh.ey(paramString1 + "})");
        paramh = paramh.Xws.XuN;
        if (paramh == null) {
          break;
        }
        paramh.a(b.XuD);
        AppMethodBeat.o(295434);
        return;
        paramString2 = a.bnf(paramString2);
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "";
        }
      }
    }
    paramString1 = new StringBuilder("WeixinWebCompt._callback(").append(a.bnf(paramString1)).append(", ");
    paramString2 = c.c.b(paramc.otC);
    if (paramString2 == null)
    {
      paramh = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.WebComptCommCgiResp");
      AppMethodBeat.o(295434);
      throw paramh;
    }
    paramh.ey(((ghj)paramString2).acdq + ')');
    AppMethodBeat.o(295434);
  }
  
  private static final void a(h paramh, String paramString1, String paramString2, Map paramMap)
  {
    AppMethodBeat.i(295415);
    kotlin.g.b.s.u(paramh, "this$0");
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    kotlin.g.b.s.s(paramString2, "ret");
    localMap.put("err_msg", paramString2);
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    paramMap = p.a.a(paramString1, (Map)localHashMap, false, "");
    Log.d(TAG, "invoke callback: " + paramString2 + ", " + paramMap);
    paramString2 = new StringBuilder("WeixinWebCompt._callback(");
    kotlin.g.b.s.s(paramString1, "callbackId");
    paramh.ey(a.bnf(paramString1) + ", " + paramMap + "['__params'])");
    AppMethodBeat.o(295415);
  }
  
  private static final void b(h paramh, String paramString)
  {
    AppMethodBeat.i(295426);
    kotlin.g.b.s.u(paramh, "this$0");
    kotlin.g.b.s.u(paramString, "$message");
    a(paramh, paramString);
    AppMethodBeat.o(295426);
  }
  
  private final void ey(String paramString)
  {
    AppMethodBeat.i(295410);
    g localg = this.Xws.bng(this.XvD);
    if (localg != null) {
      localg.evaluateJavascript(paramString, null);
    }
    AppMethodBeat.o(295410);
  }
  
  private JsapiPermissionWrapper iwo()
  {
    AppMethodBeat.i(82945);
    JsapiPermissionWrapper localJsapiPermissionWrapper = this.WlV;
    if (localJsapiPermissionWrapper != null)
    {
      AppMethodBeat.o(82945);
      return localJsapiPermissionWrapper;
    }
    kotlin.g.b.s.bIx("jsPerm");
    AppMethodBeat.o(82945);
    return null;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void cgi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(82955);
    kotlin.g.b.s.u(paramString1, "callbackId");
    kotlin.g.b.s.u(paramString2, "request");
    Object localObject = this.Xws.XuN;
    if (localObject != null) {
      ((i)localObject).a(b.XuC);
    }
    localObject = new c.a();
    ghi localghi = new ghi();
    localghi.acdp = paramString2;
    paramString2 = ah.aiuX;
    ((c.a)localObject).otE = ((com.tencent.mm.bx.a)localghi);
    ((c.a)localObject).otF = ((com.tencent.mm.bx.a)new ghj());
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/webcompt/webcomptcommcgi";
    ((c.a)localObject).funcId = 2936;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    IPCRunCgi.a(((c.a)localObject).bEF(), new h..ExternalSyntheticLambda0(this, paramString1));
    AppMethodBeat.o(82955);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void errReport(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82949);
    kotlin.g.b.s.u(paramString1, "errMsg");
    kotlin.g.b.s.u(paramString2, "errStack");
    this.Xws.j(this.XvD, paramString1, paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(82949);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void idkey(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(82953);
    com.tencent.mm.plugin.report.service.h.OAn.p(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(82953);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void idkeyList(String paramString)
  {
    AppMethodBeat.i(82954);
    kotlin.g.b.s.u(paramString, "list");
    paramString = new f(paramString);
    LinkedList localLinkedList = new LinkedList();
    int k = paramString.length();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      f localf = paramString.sr(i);
      localLinkedList.add(new IDKey(localf.getLong(0), localf.getLong(1), localf.getLong(2)));
      if (j >= k)
      {
        paramString = (List)localLinkedList;
        com.tencent.mm.plugin.report.service.h.OAn.b(new ArrayList((Collection)paramString), false);
        AppMethodBeat.o(82954);
        return;
      }
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void invoke(String paramString)
  {
    AppMethodBeat.i(82946);
    kotlin.g.b.s.u(paramString, "message");
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    }
    while (i == 0)
    {
      Log.d(TAG, kotlin.g.b.s.X("invoke: ", paramString));
      if (MMHandlerThread.isMainThread())
      {
        a(this, paramString);
        AppMethodBeat.o(82946);
        return;
        i = 0;
      }
      else
      {
        MMHandlerThread.postToMainThread(new h..ExternalSyntheticLambda2(this, paramString));
      }
    }
    AppMethodBeat.o(82946);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void kv(int paramInt, String paramString)
  {
    AppMethodBeat.i(82952);
    kotlin.g.b.s.u(paramString, "data");
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(paramInt, paramString);
    AppMethodBeat.o(82952);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void log(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(82951);
    kotlin.g.b.s.u(paramString1, "tag");
    kotlin.g.b.s.u(paramString2, "msg");
    paramString1 = "webCompt[" + paramString1 + ']';
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(82951);
      return;
      Log.v(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      Log.d(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      Log.i(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      Log.w(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      Log.e(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      Log.f(paramString1, paramString2);
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final String performance(String paramString)
  {
    AppMethodBeat.i(82950);
    kotlin.g.b.s.u(paramString, "frontEndPerformance");
    Object localObject2 = this.Xws;
    String str = this.XvD;
    kotlin.g.b.s.u(str, "webCompt");
    kotlin.g.b.s.u(paramString, "frontEndPerformance");
    c.m.a locala = (c.m.a)((c)localObject2).iDa().get(str);
    Object localObject1;
    if (locala != null)
    {
      localObject1 = locala.XvU;
      if (localObject1 != null)
      {
        Object localObject3 = p.listOf(new c.l[] { c.l.XvF, c.l.XvH, c.l.XvI, c.l.XvG });
        Object localObject4 = new LinkedList();
        Iterator localIterator = ((Iterable)localObject3).iterator();
        while (localIterator.hasNext())
        {
          c.l locall = (c.l)localIterator.next();
          ((LinkedList)localObject4).add(String.valueOf(((com.tencent.mm.pluginsdk.s)localObject1).cg(kotlin.g.b.s.X(locall.sUP, "_START"), ((com.tencent.mm.pluginsdk.s)localObject1).XNW) - ((com.tencent.mm.pluginsdk.s)localObject1).XNW));
          ((LinkedList)localObject4).add(String.valueOf(((com.tencent.mm.pluginsdk.s)localObject1).cg(kotlin.g.b.s.X(locall.sUP, "_END"), ((com.tencent.mm.pluginsdk.s)localObject1).XNW) - ((com.tencent.mm.pluginsdk.s)localObject1).XNW));
        }
        localObject1 = kotlin.g.b.s.X(kotlin.g.b.s.X(p.a((Iterable)localObject4, (CharSequence)",", null, (CharSequence)",", 0, null, null, 58), n.p((CharSequence)"0,", (9 - ((List)localObject3).size()) * 2)), paramString);
        Log.i(c.TAG, kotlin.g.b.s.X("performance: ", localObject1));
        paramString = (com.tencent.mm.plugin.webview.jsapi.j)((c)localObject2).XuM.get();
        if (paramString == null)
        {
          paramString = "";
          paramString = a.bne(paramString);
          localObject2 = a.bne(locala.vTt);
          localObject3 = locala.appId;
          localObject4 = c.XuL;
          paramString = p.a((Iterable)p.listOf(new Object[] { paramString, localObject2, localObject3, str, Integer.valueOf(c.b.iDm().getVersion()), locala.XvT }), (CharSequence)",", null, (CharSequence)",", 0, null, null, 58);
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(18151, kotlin.g.b.s.X(paramString, localObject1));
        }
      }
    }
    for (paramString = (String)localObject1;; paramString = "")
    {
      if (paramString != null) {
        break label466;
      }
      AppMethodBeat.o(82950);
      return "";
      paramString = paramString.WDz.getSettings();
      if (paramString == null)
      {
        paramString = "";
        break;
      }
      localObject2 = paramString.getUserAgentString();
      paramString = (String)localObject2;
      if (localObject2 != null) {
        break;
      }
      paramString = "";
      break;
    }
    label466:
    AppMethodBeat.o(82950);
    return paramString;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void refreshA8Key(final String paramString)
  {
    AppMethodBeat.i(82948);
    kotlin.g.b.s.u(paramString, "callbackId");
    c localc = this.Xws;
    Object localObject = this.XvD;
    kotlin.g.a.b localb = (kotlin.g.a.b)new b(this);
    paramString = (kotlin.g.a.b)new c(this, paramString);
    kotlin.g.b.s.u(localObject, "webCompt");
    kotlin.g.b.s.u(localb, "onerror");
    kotlin.g.b.s.u(paramString, "onsuccess");
    localObject = (c.m.a)localc.iDa().get(localObject);
    if (localObject != null) {
      if (n.bp((CharSequence)((c.m.a)localObject).XvR)) {
        break label149;
      }
    }
    label149:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        kotlinx.coroutines.j.a((aq)bu.ajwo, null, null, (m)new c.x(localc, (c.m.a)localObject, paramString, localb, null), 3);
      }
      AppMethodBeat.o(82948);
      return;
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void sendMessage(String paramString)
  {
    AppMethodBeat.i(82947);
    kotlin.g.b.s.u(paramString, "data");
    c localc = this.Xws;
    kotlin.g.b.s.u(paramString, "message");
    Log.v(c.TAG, kotlin.g.b.s.X("postToFront ", paramString));
    c.a(localc, "window.WeixinOpenTags && window.WeixinOpenTags.onMessage(" + paramString + ')');
    localc.XuN.a(b.XuB);
    AppMethodBeat.o(82947);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler$Companion;", "", "()V", "LEVEL_DEBUG", "", "LEVEL_ERROR", "LEVEL_FATAL", "LEVEL_INFO", "LEVEL_NONE", "LEVEL_VERBOSE", "LEVEL_WARNING", "TAG", "", "getTAG$annotations", "getTAG", "()Ljava/lang/String;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "ex", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<c.k, ah>
  {
    b(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    c(h paramh, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.h
 * JD-Core Version:    0.7.0.1
 */