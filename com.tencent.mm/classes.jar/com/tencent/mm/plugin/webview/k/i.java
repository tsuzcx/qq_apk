package com.tencent.mm.plugin.webview.k;

import android.os.Bundle;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.eft;
import com.tencent.mm.protocal.protobuf.efu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.bk;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "", "webComponent", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "webComptName", "", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;Ljava/lang/String;Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getJsPerm", "()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "setJsPerm", "(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;)V", "cgi", "", "callbackId", "request", "errReport", "errMsg", "errStack", "errLine", "", "errCol", "evaluate", "script", "idkey", "id", "", "key", "value", "idkeyList", "list", "invoke", "message", "kv", "data", "log", "level", "tag", "msg", "performance", "frontEndPerformance", "refreshA8Key", "sendMessage", "Companion", "webview-sdk_release"})
public final class i
{
  public static final a EOU;
  private static final String TAG = "WebComptContextJsApiHandler";
  private final com.tencent.mm.plugin.webview.c.f DQe;
  private final com.tencent.mm.plugin.webview.c.b DRu;
  public JsapiPermissionWrapper DRw;
  private final String ENR;
  private final c EOT;
  
  static
  {
    AppMethodBeat.i(82957);
    EOU = new a((byte)0);
    TAG = "WebComptContextJsApiHandler";
    AppMethodBeat.o(82957);
  }
  
  public i(c paramc, String paramString, com.tencent.mm.plugin.webview.c.f paramf)
  {
    AppMethodBeat.i(214258);
    this.EOT = paramc;
    this.ENR = paramString;
    this.DQe = paramf;
    this.DRu = ((com.tencent.mm.plugin.webview.c.b)new b(this));
    AppMethodBeat.o(214258);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void cgi(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(82955);
    p.h(paramString1, "callbackId");
    p.h(paramString2, "request");
    this.EOT.EMZ.a(b.EMQ);
    b.a locala = new b.a();
    eft localeft = new eft();
    localeft.Iju = paramString2;
    locala.c((com.tencent.mm.bw.a)localeft);
    locala.d((com.tencent.mm.bw.a)new efu());
    locala.DN("/cgi-bin/mmbiz-bin/webcompt/webcomptcommcgi");
    locala.oS(2936);
    locala.oU(0);
    locala.oV(0);
    IPCRunCgi.a(locala.aDS(), (IPCRunCgi.a)new c(this, paramString1));
    AppMethodBeat.o(82955);
  }
  
  public final JsapiPermissionWrapper eUS()
  {
    AppMethodBeat.i(82945);
    JsapiPermissionWrapper localJsapiPermissionWrapper = this.DRw;
    if (localJsapiPermissionWrapper == null) {
      p.bdF("jsPerm");
    }
    AppMethodBeat.o(82945);
    return localJsapiPermissionWrapper;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void errReport(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82949);
    p.h(paramString1, "errMsg");
    p.h(paramString2, "errStack");
    this.EOT.h(this.ENR, paramString1, paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(82949);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void idkey(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(82953);
    g.yxI.n(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(82953);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void idkeyList(String paramString)
  {
    AppMethodBeat.i(82954);
    p.h(paramString, "list");
    paramString = a.b(new com.tencent.mm.ab.f(paramString), (m)d.EOX);
    g.yxI.b(new ArrayList((Collection)paramString), false);
    AppMethodBeat.o(82954);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void invoke(final String paramString)
  {
    AppMethodBeat.i(82946);
    p.h(paramString, "message");
    e locale = new e(this, paramString);
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    }
    while (i == 0)
    {
      ae.d(TAG, "invoke: ".concat(String.valueOf(paramString)));
      if (ar.isMainThread())
      {
        locale.invoke();
        AppMethodBeat.o(82946);
        return;
        i = 0;
      }
      else
      {
        ar.f((Runnable)new f(locale));
      }
    }
    AppMethodBeat.o(82946);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void kv(int paramInt, String paramString)
  {
    AppMethodBeat.i(82952);
    p.h(paramString, "data");
    g.yxI.kvStat(paramInt, paramString);
    AppMethodBeat.o(82952);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void log(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(82951);
    p.h(paramString1, "tag");
    p.h(paramString2, "msg");
    paramString1 = "webCompt[" + paramString1 + ']';
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(82951);
      return;
      ae.v(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      ae.d(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      ae.i(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      ae.w(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      ae.e(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      ae.f(paramString1, paramString2);
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final String performance(String paramString)
  {
    AppMethodBeat.i(82950);
    p.h(paramString, "frontEndPerformance");
    Object localObject1 = this.EOT;
    String str1 = this.ENR;
    p.h(str1, "webCompt");
    p.h(paramString, "frontEndPerformance");
    c.l.a locala = (c.l.a)((c)localObject1).eZE().get(str1);
    if (locala != null)
    {
      Object localObject2 = locala.EOf;
      if (localObject2 != null)
      {
        paramString = c.a((r)localObject2, d.a.j.listOf(new c.k[] { c.k.ENT, c.k.ENV, c.k.ENW, c.k.ENU })) + paramString;
        ae.i(c.TAG, "performance: ".concat(String.valueOf(paramString)));
        localObject1 = ((c)localObject1).DRx.getSettings();
        p.g(localObject1, "jsapi.settings");
        localObject1 = ((com.tencent.xweb.z)localObject1).getUserAgentString();
        p.g(localObject1, "jsapi.settings.userAgentString");
        localObject1 = a.htmlEncode((String)localObject1);
        localObject2 = a.htmlEncode(locala.oqi);
        String str2 = locala.appId;
        c.b localb = c.ENl;
        str1 = d.a.j.a((Iterable)d.a.j.listOf(new Object[] { localObject1, localObject2, str2, str1, Integer.valueOf(c.b.eZP().getVersion()), locala.EOe }), (CharSequence)",", null, (CharSequence)",", 0, null, null, 58);
        g.yxI.kvStat(18151, str1 + paramString);
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
    p.h(paramString, "callbackId");
    c localc = this.EOT;
    Object localObject = this.ENR;
    d.g.a.b localb = (d.g.a.b)new g(this);
    paramString = (d.g.a.b)new h(this, paramString);
    p.h(localObject, "webCompt");
    p.h(localb, "onerror");
    p.h(paramString, "onsuccess");
    localObject = (c.l.a)localc.eZE().get(localObject);
    if (localObject != null)
    {
      if (!n.aD((CharSequence)((c.l.a)localObject).EOc)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          kotlinx.coroutines.f.b((ah)bk.OfO, null, (m)new c.y((c.l.a)localObject, null, localc, paramString, localb), 3);
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
    p.h(paramString, "data");
    c localc = this.EOT;
    p.h(paramString, "message");
    ae.v(c.TAG, "postToFront ".concat(String.valueOf(paramString)));
    c.a(localc, "WeixinOpenTags && WeixinOpenTags.onMessage(" + paramString + ')');
    localc.EMZ.a(b.EMP);
    AppMethodBeat.o(82947);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler$Companion;", "", "()V", "LEVEL_DEBUG", "", "LEVEL_ERROR", "LEVEL_FATAL", "LEVEL_INFO", "LEVEL_NONE", "LEVEL_VERBOSE", "LEVEL_WARNING", "TAG", "", "TAG$annotations", "getTAG", "()Ljava/lang/String;", "webview-sdk_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "callbackId", "", "kotlin.jvm.PlatformType", "ret", "retValue", "", "", "", "doCallback"})
  static final class b
    implements com.tencent.mm.plugin.webview.c.b
  {
    b(i parami) {}
    
    public final void i(String paramString1, String paramString2, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(82936);
      Object localObject = new HashMap();
      Map localMap = (Map)localObject;
      p.g(paramString2, "ret");
      localMap.put("err_msg", paramString2);
      if (paramMap != null) {
        ((HashMap)localObject).putAll(paramMap);
      }
      paramMap = l.a.a(paramString1, (Map)localObject, false, "");
      localObject = i.EOU;
      ae.d(i.access$getTAG$cp(), "invoke callback: " + paramString2 + ", " + paramMap);
      paramString2 = this.EOV;
      localObject = new StringBuilder("WeixinWebCompt._callback(");
      p.g(paramString1, "callbackId");
      i.a(paramString2, a.aLc(paramString1) + ", " + paramMap + "['__params'])");
      AppMethodBeat.o(82936);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class c
    implements IPCRunCgi.a
  {
    c(i parami, String paramString) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(82937);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        localObject = this.EOV;
        StringBuilder localStringBuilder = new StringBuilder("WeixinWebCompt._callback(").append(a.aLc(paramString1)).append(", {errType:").append(paramInt1).append(", errCode:").append(paramInt2).append(", errMsg:");
        if (paramString != null)
        {
          paramb = a.aLc(paramString);
          paramString = paramb;
          if (paramb != null) {}
        }
        else
        {
          paramString = "";
        }
        i.a((i)localObject, paramString + "})");
        i.d(this.EOV).EMZ.a(b.EMR);
        AppMethodBeat.o(82937);
        return;
      }
      paramString = this.EOV;
      Object localObject = new StringBuilder("WeixinWebCompt._callback(").append(a.aLc(paramString1)).append(", ");
      p.g(paramb, "rr");
      paramb = paramb.aEV();
      if (paramb == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.WebComptCommCgiResp");
        AppMethodBeat.o(82937);
        throw paramString;
      }
      i.a(paramString, ((efu)paramb).Ijv + ')');
      AppMethodBeat.o(82937);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mars/smc/IDKey;", "i", "", "jsonArray", "Lcom/tencent/mm/json/JSONArray;", "invoke"})
  static final class d
    extends q
    implements m<Integer, com.tencent.mm.ab.f, IDKey>
  {
    public static final d EOX;
    
    static
    {
      AppMethodBeat.i(82939);
      EOX = new d();
      AppMethodBeat.o(82939);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"dealMsg", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<d.z>
  {
    e(i parami, String paramString)
    {
      super();
    }
    
    public final void invoke()
    {
      AppMethodBeat.i(82941);
      com.tencent.mm.plugin.webview.c.f localf = i.a(this.EOV);
      String str = paramString;
      JsapiPermissionWrapper localJsapiPermissionWrapper = this.EOV.eUS();
      Bundle localBundle = new Bundle();
      localBundle.putString("name", i.b(this.EOV));
      localf.a(str, localJsapiPermissionWrapper, localBundle, i.c(this.EOV));
      AppMethodBeat.o(82941);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(i.e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(82942);
      this.EOY.invoke();
      AppMethodBeat.o(82942);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "ex", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "invoke"})
  static final class g
    extends q
    implements d.g.a.b<c.j, d.z>
  {
    g(i parami)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.b<String, d.z>
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