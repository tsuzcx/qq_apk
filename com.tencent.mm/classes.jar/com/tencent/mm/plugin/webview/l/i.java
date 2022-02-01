package com.tencent.mm.plugin.webview.l;

import android.os.Bundle;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.fku;
import com.tencent.mm.protocal.protobuf.fkv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.xweb.aa;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.br;
import kotlinx.coroutines.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "", "webComponent", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "webComptName", "", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;Ljava/lang/String;)V", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getJsPerm", "()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "setJsPerm", "(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;)V", "cgi", "", "callbackId", "request", "errReport", "errMsg", "errStack", "errLine", "", "errCol", "evaluate", "script", "idkey", "id", "", "key", "value", "idkeyList", "list", "invoke", "message", "kv", "data", "log", "level", "tag", "msg", "performance", "frontEndPerformance", "refreshA8Key", "sendMessage", "Companion", "webview-sdk_release"})
public final class i
{
  public static final a QDz;
  private static final String TAG = "WebComptContextJsApiHandler";
  private final com.tencent.mm.plugin.webview.d.b PvG;
  public JsapiPermissionWrapper PvI;
  private final String QCx;
  private final c QDy;
  
  static
  {
    AppMethodBeat.i(82957);
    QDz = new a((byte)0);
    TAG = "WebComptContextJsApiHandler";
    AppMethodBeat.o(82957);
  }
  
  public i(c paramc, String paramString)
  {
    AppMethodBeat.i(205243);
    this.QDy = paramc;
    this.QCx = paramString;
    this.PvG = ((com.tencent.mm.plugin.webview.d.b)new b(this));
    AppMethodBeat.o(205243);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void cgi(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(82955);
    p.k(paramString1, "callbackId");
    p.k(paramString2, "request");
    Object localObject = this.QDy.QBB;
    if (localObject != null) {
      ((j)localObject).a(b.QBs);
    }
    localObject = new d.a();
    fku localfku = new fku();
    localfku.UJh = paramString2;
    ((d.a)localObject).c((com.tencent.mm.cd.a)localfku);
    ((d.a)localObject).d((com.tencent.mm.cd.a)new fkv());
    ((d.a)localObject).TW("/cgi-bin/mmbiz-bin/webcompt/webcomptcommcgi");
    ((d.a)localObject).vD(2936);
    ((d.a)localObject).vF(0);
    ((d.a)localObject).vG(0);
    IPCRunCgi.a(((d.a)localObject).bgN(), (IPCRunCgi.a)new c(this, paramString1));
    AppMethodBeat.o(82955);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void errReport(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82949);
    p.k(paramString1, "errMsg");
    p.k(paramString2, "errStack");
    this.QDy.j(this.QCx, paramString1, paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(82949);
  }
  
  public final JsapiPermissionWrapper gWI()
  {
    AppMethodBeat.i(82945);
    JsapiPermissionWrapper localJsapiPermissionWrapper = this.PvI;
    if (localJsapiPermissionWrapper == null) {
      p.bGy("jsPerm");
    }
    AppMethodBeat.o(82945);
    return localJsapiPermissionWrapper;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void idkey(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(82953);
    com.tencent.mm.plugin.report.service.h.IzE.p(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(82953);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void idkeyList(String paramString)
  {
    AppMethodBeat.i(82954);
    p.k(paramString, "list");
    paramString = new f(paramString);
    LinkedList localLinkedList = new LinkedList();
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      f localf = paramString.sv(i);
      localLinkedList.add(new IDKey(localf.getLong(0), localf.getLong(1), localf.getLong(2)));
      i += 1;
    }
    paramString = (List)localLinkedList;
    com.tencent.mm.plugin.report.service.h.IzE.b(new ArrayList((Collection)paramString), false);
    AppMethodBeat.o(82954);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void invoke(final String paramString)
  {
    AppMethodBeat.i(82946);
    p.k(paramString, "message");
    d locald = new d(this, paramString);
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    }
    while (i == 0)
    {
      Log.d(TAG, "invoke: ".concat(String.valueOf(paramString)));
      if (MMHandlerThread.isMainThread())
      {
        locald.invoke();
        AppMethodBeat.o(82946);
        return;
        i = 0;
      }
      else
      {
        MMHandlerThread.postToMainThread((Runnable)new e(locald));
      }
    }
    AppMethodBeat.o(82946);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void kv(int paramInt, String paramString)
  {
    AppMethodBeat.i(82952);
    p.k(paramString, "data");
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(paramInt, paramString);
    AppMethodBeat.o(82952);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void log(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(82951);
    p.k(paramString1, "tag");
    p.k(paramString2, "msg");
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
    p.k(paramString, "frontEndPerformance");
    Object localObject2 = this.QDy;
    String str1 = this.QCx;
    p.k(str1, "webCompt");
    p.k(paramString, "frontEndPerformance");
    c.m.a locala = (c.m.a)((c)localObject2).hct().get(str1);
    Object localObject1;
    if (locala != null)
    {
      localObject1 = locala.QCL;
      if (localObject1 != null)
      {
        localObject1 = c.a((r)localObject1, kotlin.a.j.listOf(new c.l[] { c.l.QCz, c.l.QCB, c.l.QCC, c.l.QCA })) + paramString;
        Log.i(c.TAG, "performance: ".concat(String.valueOf(localObject1)));
        paramString = (com.tencent.mm.plugin.webview.d.h)((c)localObject2).QBD.get();
        if (paramString != null)
        {
          paramString = paramString.getSettings();
          if (paramString != null)
          {
            localObject2 = paramString.getUserAgentString();
            paramString = (String)localObject2;
            if (localObject2 != null) {
              break label176;
            }
          }
        }
        paramString = "";
        label176:
        paramString = a.bnr(paramString);
        localObject2 = a.bnr(locala.sNY);
        String str2 = locala.appId;
        c.b localb = c.QBP;
        paramString = kotlin.a.j.a((Iterable)kotlin.a.j.listOf(new Object[] { paramString, localObject2, str2, str1, Integer.valueOf(c.b.hcF().getVersion()), locala.QCK }), (CharSequence)",", null, (CharSequence)",", 0, null, null, 58);
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(18151, paramString + (String)localObject1);
      }
    }
    for (paramString = (String)localObject1;; paramString = "")
    {
      localObject1 = paramString;
      if (paramString == null) {
        localObject1 = "";
      }
      AppMethodBeat.o(82950);
      return localObject1;
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void refreshA8Key(final String paramString)
  {
    AppMethodBeat.i(82948);
    p.k(paramString, "callbackId");
    c localc = this.QDy;
    Object localObject = this.QCx;
    kotlin.g.a.b localb = (kotlin.g.a.b)new f(this);
    paramString = (kotlin.g.a.b)new g(this, paramString);
    p.k(localObject, "webCompt");
    p.k(localb, "onerror");
    p.k(paramString, "onsuccess");
    localObject = (c.m.a)localc.hct().get(localObject);
    if (localObject != null)
    {
      if (!n.ba((CharSequence)((c.m.a)localObject).QCI)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          g.b((ak)br.abxo, null, (m)new c.z((c.m.a)localObject, null, localc, paramString, localb), 3);
        }
        AppMethodBeat.o(82948);
        return;
      }
    }
    AppMethodBeat.o(82948);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void sendMessage(String paramString)
  {
    AppMethodBeat.i(82947);
    p.k(paramString, "data");
    c localc = this.QDy;
    p.k(paramString, "message");
    Log.v(c.TAG, "postToFront ".concat(String.valueOf(paramString)));
    c.a(localc, "window.WeixinOpenTags && window.WeixinOpenTags.onMessage(" + paramString + ')');
    localc.QBB.a(b.QBr);
    AppMethodBeat.o(82947);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler$Companion;", "", "()V", "LEVEL_DEBUG", "", "LEVEL_ERROR", "LEVEL_FATAL", "LEVEL_INFO", "LEVEL_NONE", "LEVEL_VERBOSE", "LEVEL_WARNING", "TAG", "", "TAG$annotations", "getTAG", "()Ljava/lang/String;", "webview-sdk_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "callbackId", "", "kotlin.jvm.PlatformType", "ret", "retValue", "", "", "", "doCallback"})
  static final class b
    implements com.tencent.mm.plugin.webview.d.b
  {
    b(i parami) {}
    
    public final void h(String paramString1, String paramString2, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(82936);
      Object localObject = new HashMap();
      Map localMap = (Map)localObject;
      p.j(paramString2, "ret");
      localMap.put("err_msg", paramString2);
      if (paramMap != null) {
        ((HashMap)localObject).putAll(paramMap);
      }
      paramMap = n.a.a(paramString1, (Map)localObject, false, "");
      localObject = i.QDz;
      Log.d(i.access$getTAG$cp(), "invoke callback: " + paramString2 + ", " + paramMap);
      paramString2 = this.QDA;
      localObject = new StringBuilder("WeixinWebCompt._callback(");
      p.j(paramString1, "callbackId");
      i.a(paramString2, a.bns(paramString1) + ", " + paramMap + "['__params'])");
      AppMethodBeat.o(82936);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class c
    implements IPCRunCgi.a
  {
    c(i parami, String paramString) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
    {
      AppMethodBeat.i(82937);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        localObject = this.QDA;
        StringBuilder localStringBuilder = new StringBuilder("WeixinWebCompt._callback(").append(a.bns(paramString1)).append(", {errType:").append(paramInt1).append(", errCode:").append(paramInt2).append(", errMsg:");
        if (paramString != null)
        {
          paramd = a.bns(paramString);
          paramString = paramd;
          if (paramd != null) {}
        }
        else
        {
          paramString = "";
        }
        i.a((i)localObject, paramString + "})");
        paramString = i.a(this.QDA).QBB;
        if (paramString != null)
        {
          paramString.a(b.QBt);
          AppMethodBeat.o(82937);
          return;
        }
        AppMethodBeat.o(82937);
        return;
      }
      paramString = this.QDA;
      Object localObject = new StringBuilder("WeixinWebCompt._callback(").append(a.bns(paramString1)).append(", ");
      p.j(paramd, "rr");
      paramd = paramd.bhY();
      if (paramd == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.WebComptCommCgiResp");
        AppMethodBeat.o(82937);
        throw paramString;
      }
      i.a(paramString, ((fkv)paramd).UJi + ')');
      AppMethodBeat.o(82937);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"dealMsg", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(i parami, String paramString)
    {
      super();
    }
    
    public final void invoke()
    {
      AppMethodBeat.i(82941);
      Object localObject = i.a(this.QDA).QBD;
      if (localObject != null)
      {
        localObject = (com.tencent.mm.plugin.webview.d.h)((WeakReference)localObject).get();
        if (localObject != null)
        {
          String str = paramString;
          JsapiPermissionWrapper localJsapiPermissionWrapper = this.QDA.gWI();
          Bundle localBundle = new Bundle();
          localBundle.putString("name", i.b(this.QDA));
          ((com.tencent.mm.plugin.webview.d.h)localObject).a(str, localJsapiPermissionWrapper, localBundle, i.c(this.QDA));
          AppMethodBeat.o(82941);
          return;
        }
      }
      AppMethodBeat.o(82941);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(i.d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(82942);
      this.QDB.invoke();
      AppMethodBeat.o(82942);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ex", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<c.k, x>
  {
    f(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.b<String, x>
  {
    g(i parami, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.i
 * JD-Core Version:    0.7.0.1
 */