package com.tencent.mm.plugin.webview.k;

import android.os.Bundle;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.dyc;
import com.tencent.mm.protocal.protobuf.dyd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.xweb.z;
import d.g.a.m;
import d.g.b.k;
import d.n.n;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlinx.coroutines.ag;
import kotlinx.coroutines.bh;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "", "webComponent", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "webComptName", "", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;Ljava/lang/String;Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getJsPerm", "()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "setJsPerm", "(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;)V", "cgi", "", "callbackId", "request", "errReport", "errMsg", "errStack", "errLine", "", "errCol", "evaluate", "script", "idkey", "id", "", "key", "value", "idkeyList", "list", "invoke", "message", "kv", "data", "log", "level", "tag", "msg", "performance", "frontEndPerformance", "refreshA8Key", "sendMessage", "Companion", "webview-sdk_release"})
public final class i
{
  public static final a CSx;
  private static final String TAG = "WebComptContextJsApiHandler";
  private final String CRs;
  private final com.tencent.mm.plugin.webview.c.b CSv;
  private final c CSw;
  public JsapiPermissionWrapper Cjp;
  private final com.tencent.mm.plugin.webview.c.f Cjq;
  
  static
  {
    AppMethodBeat.i(82957);
    CSx = new a((byte)0);
    TAG = "WebComptContextJsApiHandler";
    AppMethodBeat.o(82957);
  }
  
  public i(c paramc, String paramString, com.tencent.mm.plugin.webview.c.f paramf)
  {
    AppMethodBeat.i(205623);
    this.CSw = paramc;
    this.CRs = paramString;
    this.Cjq = paramf;
    this.CSv = ((com.tencent.mm.plugin.webview.c.b)new b(this));
    AppMethodBeat.o(205623);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void cgi(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(82955);
    k.h(paramString1, "callbackId");
    k.h(paramString2, "request");
    this.CSw.CQA.a(b.CQs);
    b.a locala = new b.a();
    dyc localdyc = new dyc();
    localdyc.Geh = paramString2;
    locala.c((com.tencent.mm.bw.a)localdyc);
    locala.d((com.tencent.mm.bw.a)new dyd());
    locala.Am("/cgi-bin/mmbiz-bin/webcompt/webcomptcommcgi");
    locala.op(2936);
    locala.or(0);
    locala.os(0);
    IPCRunCgi.a(locala.aAz(), (IPCRunCgi.a)new c(this, paramString1));
    AppMethodBeat.o(82955);
  }
  
  public final JsapiPermissionWrapper eCm()
  {
    AppMethodBeat.i(82945);
    JsapiPermissionWrapper localJsapiPermissionWrapper = this.Cjp;
    if (localJsapiPermissionWrapper == null) {
      k.aVY("jsPerm");
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
    this.CSw.h(this.CRs, paramString1, paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(82949);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void idkey(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(82953);
    h.wUl.n(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(82953);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void idkeyList(String paramString)
  {
    AppMethodBeat.i(82954);
    k.h(paramString, "list");
    paramString = a.a(new com.tencent.mm.ab.f(paramString), (m)d.CSA);
    h.wUl.b(new ArrayList((Collection)paramString), false);
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
      ac.d(TAG, "invoke: ".concat(String.valueOf(paramString)));
      if (ap.isMainThread())
      {
        locale.invoke();
        AppMethodBeat.o(82946);
        return;
        i = 0;
      }
      else
      {
        ap.f((Runnable)new f(locale));
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
    h.wUl.kvStat(paramInt, paramString);
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
      ac.v(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      ac.d(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      ac.i(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      ac.w(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      ac.e(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      ac.f(paramString1, paramString2);
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final String performance(String paramString)
  {
    AppMethodBeat.i(82950);
    k.h(paramString, "frontEndPerformance");
    Object localObject1 = this.CSw;
    String str1 = this.CRs;
    k.h(str1, "webCompt");
    k.h(paramString, "frontEndPerformance");
    c.l.a locala = (c.l.a)((c)localObject1).eGQ().get(str1);
    if (locala != null)
    {
      Object localObject2 = locala.CRG;
      if (localObject2 != null)
      {
        paramString = c.a((q)localObject2, d.a.j.listOf(new c.k[] { c.k.CRu, c.k.CRw, c.k.CRx, c.k.CRv })) + paramString;
        ac.i(c.TAG, "performance: ".concat(String.valueOf(paramString)));
        localObject1 = ((c)localObject1).Cjc.getSettings();
        k.g(localObject1, "jsapi.settings");
        localObject1 = ((z)localObject1).getUserAgentString();
        k.g(localObject1, "jsapi.settings.userAgentString");
        localObject1 = a.htmlEncode((String)localObject1);
        localObject2 = a.htmlEncode(locala.nHD);
        String str2 = locala.appId;
        c.b localb = c.CQN;
        str1 = d.a.j.a((Iterable)d.a.j.listOf(new Object[] { localObject1, localObject2, str2, str1, Integer.valueOf(c.b.eHm().getVersion()), locala.CRF }), (CharSequence)",", null, (CharSequence)",", 0, null, null, 58);
        h.wUl.kvStat(18151, str1 + paramString);
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
    c localc = this.CSw;
    Object localObject = this.CRs;
    d.g.a.b localb = (d.g.a.b)new g(this);
    paramString = (d.g.a.b)new h(this, paramString);
    k.h(localObject, "webCompt");
    k.h(localb, "onerror");
    k.h(paramString, "onsuccess");
    localObject = (c.l.a)localc.eGQ().get(localObject);
    if (localObject != null)
    {
      if (!n.aD((CharSequence)((c.l.a)localObject).CRD)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          kotlinx.coroutines.f.b((ag)bh.LRM, null, (m)new c.y((c.l.a)localObject, null, localc, paramString, localb), 3);
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
    c localc = this.CSw;
    k.h(paramString, "message");
    ac.v(c.TAG, "postToFront ".concat(String.valueOf(paramString)));
    c.a(localc, "WeixinOpenTags && WeixinOpenTags.onMessage(" + paramString + ')');
    localc.CQA.a(b.CQr);
    AppMethodBeat.o(82947);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler$Companion;", "", "()V", "LEVEL_DEBUG", "", "LEVEL_ERROR", "LEVEL_FATAL", "LEVEL_INFO", "LEVEL_NONE", "LEVEL_VERBOSE", "LEVEL_WARNING", "TAG", "", "TAG$annotations", "getTAG", "()Ljava/lang/String;", "webview-sdk_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "callbackId", "", "kotlin.jvm.PlatformType", "ret", "retValue", "", "", "", "doCallback"})
  static final class b
    implements com.tencent.mm.plugin.webview.c.b
  {
    b(i parami) {}
    
    public final void j(String paramString1, String paramString2, Map<String, Object> paramMap)
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
      localObject = i.CSx;
      ac.d(i.access$getTAG$cp(), "invoke callback: " + paramString2 + ", " + paramMap);
      paramString2 = this.CSy;
      localObject = new StringBuilder("WeixinWebCompt._callback(");
      k.g(paramString1, "callbackId");
      i.a(paramString2, a.aEe(paramString1) + ", " + paramMap + "['__params'])");
      AppMethodBeat.o(82936);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class c
    implements IPCRunCgi.a
  {
    c(i parami, String paramString) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(82937);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        localObject = this.CSy;
        StringBuilder localStringBuilder = new StringBuilder("WeixinWebCompt._callback(").append(a.aEe(paramString1)).append(", {errType:").append(paramInt1).append(", errCode:").append(paramInt2).append(", errMsg:");
        if (paramString != null)
        {
          paramb = a.aEe(paramString);
          paramString = paramb;
          if (paramb != null) {}
        }
        else
        {
          paramString = "";
        }
        i.a((i)localObject, paramString + "})");
        i.d(this.CSy).CQA.a(b.CQt);
        AppMethodBeat.o(82937);
        return;
      }
      paramString = this.CSy;
      Object localObject = new StringBuilder("WeixinWebCompt._callback(").append(a.aEe(paramString1)).append(", ");
      k.g(paramb, "rr");
      paramb = paramb.aBD();
      if (paramb == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.WebComptCommCgiResp");
        AppMethodBeat.o(82937);
        throw paramString;
      }
      i.a(paramString, ((dyd)paramb).Gei + ')');
      AppMethodBeat.o(82937);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mars/smc/IDKey;", "i", "", "jsonArray", "Lcom/tencent/mm/json/JSONArray;", "invoke"})
  static final class d
    extends d.g.b.l
    implements m<Integer, com.tencent.mm.ab.f, IDKey>
  {
    public static final d CSA;
    
    static
    {
      AppMethodBeat.i(82939);
      CSA = new d();
      AppMethodBeat.o(82939);
    }
    
    d()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"dealMsg", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(i parami, String paramString)
    {
      super();
    }
    
    public final void invoke()
    {
      AppMethodBeat.i(82941);
      com.tencent.mm.plugin.webview.c.f localf = i.a(this.CSy);
      String str = "[" + paramString + ']';
      JsapiPermissionWrapper localJsapiPermissionWrapper = this.CSy.eCm();
      Bundle localBundle = new Bundle();
      localBundle.putString("name", i.b(this.CSy));
      localf.a(str, localJsapiPermissionWrapper, localBundle, i.c(this.CSy));
      AppMethodBeat.o(82941);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(i.e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(82942);
      this.CSB.invoke();
      AppMethodBeat.o(82942);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "ex", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<c.j, y>
  {
    g(i parami)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.b<String, y>
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