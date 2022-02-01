package com.tencent.mm.plugin.webview.k;

import android.os.Bundle;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.dsl;
import com.tencent.mm.protocal.protobuf.dsm;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.a.m;
import d.g.b.k;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.d;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "", "webComponent", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "webComptName", "", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;Ljava/lang/String;Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getJsPerm", "()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "setJsPerm", "(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;)V", "cgi", "", "callbackId", "request", "errReport", "errMsg", "errStack", "errLine", "", "errCol", "evaluate", "script", "idkey", "id", "", "key", "value", "idkeyList", "list", "invoke", "message", "kv", "data", "log", "level", "tag", "msg", "performance", "frontEndPerformance", "refreshA8Key", "sendMessage", "Companion", "webview-sdk_release"})
public final class i
{
  public static final a BAq;
  private static final String TAG = "WebComptContextJsApiHandler";
  public JsapiPermissionWrapper ARc;
  private final com.tencent.mm.plugin.webview.c.f ARd;
  private final com.tencent.mm.plugin.webview.c.b BAo;
  private final c BAp;
  private final String Bzk;
  
  static
  {
    AppMethodBeat.i(82957);
    BAq = new a((byte)0);
    TAG = "WebComptContextJsApiHandler";
    AppMethodBeat.o(82957);
  }
  
  public i(c paramc, String paramString, com.tencent.mm.plugin.webview.c.f paramf)
  {
    AppMethodBeat.i(189490);
    this.BAp = paramc;
    this.Bzk = paramString;
    this.ARd = paramf;
    this.BAo = ((com.tencent.mm.plugin.webview.c.b)new b(this));
    AppMethodBeat.o(189490);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void cgi(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(82955);
    k.h(paramString1, "callbackId");
    k.h(paramString2, "request");
    this.BAp.Bys.a(b.Byk);
    b.a locala = new b.a();
    dsl localdsl = new dsl();
    localdsl.EGV = paramString2;
    locala.c((com.tencent.mm.bx.a)localdsl);
    locala.d((com.tencent.mm.bx.a)new dsm());
    locala.wg("/cgi-bin/mmbiz-bin/webcompt/webcomptcommcgi");
    locala.nB(2936);
    locala.nD(0);
    locala.nE(0);
    IPCRunCgi.a(locala.atI(), (IPCRunCgi.a)new c(this, paramString1));
    AppMethodBeat.o(82955);
  }
  
  public final JsapiPermissionWrapper emR()
  {
    AppMethodBeat.i(82945);
    JsapiPermissionWrapper localJsapiPermissionWrapper = this.ARc;
    if (localJsapiPermissionWrapper == null) {
      k.aPZ("jsPerm");
    }
    AppMethodBeat.o(82945);
    return localJsapiPermissionWrapper;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void errReport(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82949);
    k.h(paramString1, "errMsg");
    k.h(paramString2, "errStack");
    this.BAp.h(this.Bzk, paramString1, paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(82949);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void idkey(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(82953);
    h.vKh.m(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(82953);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void idkeyList(String paramString)
  {
    AppMethodBeat.i(82954);
    k.h(paramString, "list");
    paramString = a.a(new com.tencent.mm.ac.f(paramString), (m)d.BAt);
    h.vKh.b(new ArrayList((Collection)paramString), false);
    AppMethodBeat.o(82954);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void invoke(final String paramString)
  {
    AppMethodBeat.i(82946);
    k.h(paramString, "message");
    e locale = new e(this, paramString);
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    }
    while (i == 0)
    {
      com.tencent.mm.sdk.platformtools.ad.d(TAG, "invoke: ".concat(String.valueOf(paramString)));
      if (aq.isMainThread())
      {
        locale.invoke();
        AppMethodBeat.o(82946);
        return;
        i = 0;
      }
      else
      {
        aq.f((Runnable)new f(locale));
      }
    }
    AppMethodBeat.o(82946);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void kv(int paramInt, String paramString)
  {
    AppMethodBeat.i(82952);
    k.h(paramString, "data");
    h.vKh.kvStat(paramInt, paramString);
    AppMethodBeat.o(82952);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void log(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(82951);
    k.h(paramString1, "tag");
    k.h(paramString2, "msg");
    paramString1 = "webCompt[" + paramString1 + ']';
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(82951);
      return;
      com.tencent.mm.sdk.platformtools.ad.v(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      com.tencent.mm.sdk.platformtools.ad.d(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      com.tencent.mm.sdk.platformtools.ad.i(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      com.tencent.mm.sdk.platformtools.ad.w(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      com.tencent.mm.sdk.platformtools.ad.e(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      com.tencent.mm.sdk.platformtools.ad.f(paramString1, paramString2);
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final String performance(String paramString)
  {
    AppMethodBeat.i(82950);
    k.h(paramString, "frontEndPerformance");
    Object localObject1 = this.BAp;
    String str1 = this.Bzk;
    k.h(str1, "webCompt");
    k.h(paramString, "frontEndPerformance");
    c.l.a locala = (c.l.a)((c)localObject1).erw().get(str1);
    if (locala != null)
    {
      Object localObject2 = locala.Bzy;
      if (localObject2 != null)
      {
        paramString = c.a((q)localObject2, d.a.j.listOf(new c.k[] { c.k.Bzm, c.k.Bzo, c.k.Bzp, c.k.Bzn })) + paramString;
        com.tencent.mm.sdk.platformtools.ad.i(c.TAG, "performance: ".concat(String.valueOf(paramString)));
        localObject1 = ((c)localObject1).AQP.getSettings();
        k.g(localObject1, "jsapi.settings");
        localObject1 = ((com.tencent.xweb.y)localObject1).getUserAgentString();
        k.g(localObject1, "jsapi.settings.userAgentString");
        localObject1 = a.htmlEncode((String)localObject1);
        localObject2 = a.htmlEncode(locala.neR);
        String str2 = locala.appId;
        c.b localb = c.ByF;
        str1 = d.a.j.a((Iterable)d.a.j.listOf(new Object[] { localObject1, localObject2, str2, str1, Integer.valueOf(c.b.erS().getVersion()), locala.Bzx }), (CharSequence)",", null, (CharSequence)",", 0, null, null, 58);
        h.vKh.kvStat(18151, str1 + paramString);
        AppMethodBeat.o(82950);
        return paramString;
      }
    }
    AppMethodBeat.o(82950);
    return "";
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void refreshA8Key(final String paramString)
  {
    AppMethodBeat.i(82948);
    k.h(paramString, "callbackId");
    c localc = this.BAp;
    Object localObject = this.Bzk;
    d.g.a.b localb = (d.g.a.b)new g(this);
    paramString = (d.g.a.b)new h(this, paramString);
    k.h(localObject, "webCompt");
    k.h(localb, "onerror");
    k.h(paramString, "onsuccess");
    localObject = (c.l.a)localc.erw().get(localObject);
    if (localObject != null)
    {
      if (!n.aC((CharSequence)((c.l.a)localObject).Bzv)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          d.a((kotlinx.coroutines.ad)bc.Kem, null, (m)new c.y((c.l.a)localObject, null, localc, paramString, localb), 3);
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
    k.h(paramString, "data");
    c localc = this.BAp;
    k.h(paramString, "message");
    com.tencent.mm.sdk.platformtools.ad.v(c.TAG, "postToFront ".concat(String.valueOf(paramString)));
    c.a(localc, "WeixinOpenTags.onMessage(" + paramString + ')');
    localc.Bys.a(b.Byj);
    AppMethodBeat.o(82947);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler$Companion;", "", "()V", "LEVEL_DEBUG", "", "LEVEL_ERROR", "LEVEL_FATAL", "LEVEL_INFO", "LEVEL_NONE", "LEVEL_VERBOSE", "LEVEL_WARNING", "TAG", "", "TAG$annotations", "getTAG", "()Ljava/lang/String;", "webview-sdk_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "callbackId", "", "kotlin.jvm.PlatformType", "ret", "retValue", "", "", "", "doCallback"})
  static final class b
    implements com.tencent.mm.plugin.webview.c.b
  {
    b(i parami) {}
    
    public final void h(String paramString1, String paramString2, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(82936);
      Object localObject = new HashMap();
      Map localMap = (Map)localObject;
      k.g(paramString2, "ret");
      localMap.put("err_msg", paramString2);
      if (paramMap != null) {
        ((HashMap)localObject).putAll(paramMap);
      }
      paramMap = l.a.a(paramString1, (Map)localObject, false, "");
      localObject = i.BAq;
      com.tencent.mm.sdk.platformtools.ad.d(i.access$getTAG$cp(), "invoke callback: " + paramString2 + ", " + paramMap);
      paramString2 = this.BAr;
      localObject = new StringBuilder("WeixinWebCompt._callback(");
      k.g(paramString1, "callbackId");
      i.a(paramString2, a.ayN(paramString1) + ", " + paramMap + "['__params'])");
      AppMethodBeat.o(82936);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class c
    implements IPCRunCgi.a
  {
    c(i parami, String paramString) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(82937);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        localObject = this.BAr;
        StringBuilder localStringBuilder = new StringBuilder("WeixinWebCompt._callback(").append(a.ayN(paramString1)).append(", {errType:").append(paramInt1).append(", errCode:").append(paramInt2).append(", errMsg:");
        if (paramString != null)
        {
          paramb = a.ayN(paramString);
          paramString = paramb;
          if (paramb != null) {}
        }
        else
        {
          paramString = "";
        }
        i.a((i)localObject, paramString + "})");
        i.d(this.BAr).Bys.a(b.Byl);
        AppMethodBeat.o(82937);
        return;
      }
      paramString = this.BAr;
      Object localObject = new StringBuilder("WeixinWebCompt._callback(").append(a.ayN(paramString1)).append(", ");
      k.g(paramb, "rr");
      paramb = paramb.auM();
      if (paramb == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.WebComptCommCgiResp");
        AppMethodBeat.o(82937);
        throw paramString;
      }
      i.a(paramString, ((dsm)paramb).EGW + ')');
      AppMethodBeat.o(82937);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mars/smc/IDKey;", "i", "", "jsonArray", "Lcom/tencent/mm/json/JSONArray;", "invoke"})
  static final class d
    extends d.g.b.l
    implements m<Integer, com.tencent.mm.ac.f, IDKey>
  {
    public static final d BAt;
    
    static
    {
      AppMethodBeat.i(82939);
      BAt = new d();
      AppMethodBeat.o(82939);
    }
    
    d()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"dealMsg", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    e(i parami, String paramString)
    {
      super();
    }
    
    public final void invoke()
    {
      AppMethodBeat.i(82941);
      com.tencent.mm.plugin.webview.c.f localf = i.a(this.BAr);
      String str = "[" + paramString + ']';
      JsapiPermissionWrapper localJsapiPermissionWrapper = this.BAr.emR();
      Bundle localBundle = new Bundle();
      localBundle.putString("name", i.b(this.BAr));
      localf.a(str, localJsapiPermissionWrapper, localBundle, i.c(this.BAr));
      AppMethodBeat.o(82941);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(i.e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(82942);
      this.BAu.invoke();
      AppMethodBeat.o(82942);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "ex", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<c.j, d.y>
  {
    g(i parami)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.b<String, d.y>
  {
    h(i parami, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.i
 * JD-Core Version:    0.7.0.1
 */