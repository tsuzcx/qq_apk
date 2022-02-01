package com.tencent.mm.plugin.webview.k;

import android.os.Bundle;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.eec;
import com.tencent.mm.protocal.protobuf.eed;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "", "webComponent", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "webComptName", "", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;Ljava/lang/String;Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getJsPerm", "()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "setJsPerm", "(Lcom/tencent/mm/protocal/JsapiPermissionWrapper;)V", "cgi", "", "callbackId", "request", "errReport", "errMsg", "errStack", "errLine", "", "errCol", "evaluate", "script", "idkey", "id", "", "key", "value", "idkeyList", "list", "invoke", "message", "kv", "data", "log", "level", "tag", "msg", "performance", "frontEndPerformance", "refreshA8Key", "sendMessage", "Companion", "webview-sdk_release"})
public final class i
{
  public static final a Ewy;
  private static final String TAG = "WebComptContextJsApiHandler";
  private final com.tencent.mm.plugin.webview.c.f Dyx;
  private final com.tencent.mm.plugin.webview.c.b DzM;
  public JsapiPermissionWrapper DzO;
  private final String Evw;
  private final c Ewx;
  
  static
  {
    AppMethodBeat.i(82957);
    Ewy = new a((byte)0);
    TAG = "WebComptContextJsApiHandler";
    AppMethodBeat.o(82957);
  }
  
  public i(c paramc, String paramString, com.tencent.mm.plugin.webview.c.f paramf)
  {
    AppMethodBeat.i(214417);
    this.Ewx = paramc;
    this.Evw = paramString;
    this.Dyx = paramf;
    this.DzM = ((com.tencent.mm.plugin.webview.c.b)new b(this));
    AppMethodBeat.o(214417);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void cgi(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(82955);
    p.h(paramString1, "callbackId");
    p.h(paramString2, "request");
    this.Ewx.EuF.a(b.Euw);
    b.a locala = new b.a();
    eec localeec = new eec();
    localeec.HPn = paramString2;
    locala.c((com.tencent.mm.bx.a)localeec);
    locala.d((com.tencent.mm.bx.a)new eed());
    locala.Dl("/cgi-bin/mmbiz-bin/webcompt/webcomptcommcgi");
    locala.oP(2936);
    locala.oR(0);
    locala.oS(0);
    IPCRunCgi.a(locala.aDC(), (IPCRunCgi.a)new c(this, paramString1));
    AppMethodBeat.o(82955);
  }
  
  public final JsapiPermissionWrapper eRg()
  {
    AppMethodBeat.i(82945);
    JsapiPermissionWrapper localJsapiPermissionWrapper = this.DzO;
    if (localJsapiPermissionWrapper == null) {
      p.bcb("jsPerm");
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
    this.Ewx.h(this.Evw, paramString1, paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(82949);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void idkey(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(82953);
    g.yhR.n(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(82953);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void idkeyList(String paramString)
  {
    AppMethodBeat.i(82954);
    p.h(paramString, "list");
    paramString = a.b(new com.tencent.mm.ac.f(paramString), (m)d.EwB);
    g.yhR.b(new ArrayList((Collection)paramString), false);
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
      ad.d(TAG, "invoke: ".concat(String.valueOf(paramString)));
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
    p.h(paramString, "data");
    g.yhR.kvStat(paramInt, paramString);
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
      ad.v(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      ad.d(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      ad.i(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      ad.w(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      ad.e(paramString1, paramString2);
      AppMethodBeat.o(82951);
      return;
      ad.f(paramString1, paramString2);
    }
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final String performance(String paramString)
  {
    AppMethodBeat.i(82950);
    p.h(paramString, "frontEndPerformance");
    Object localObject1 = this.Ewx;
    String str1 = this.Evw;
    p.h(str1, "webCompt");
    p.h(paramString, "frontEndPerformance");
    c.l.a locala = (c.l.a)((c)localObject1).eVS().get(str1);
    if (locala != null)
    {
      Object localObject2 = locala.EvK;
      if (localObject2 != null)
      {
        paramString = c.a((r)localObject2, d.a.j.listOf(new c.k[] { c.k.Evy, c.k.EvA, c.k.EvB, c.k.Evz })) + paramString;
        ad.i(c.TAG, "performance: ".concat(String.valueOf(paramString)));
        localObject1 = ((c)localObject1).DzP.getSettings();
        p.g(localObject1, "jsapi.settings");
        localObject1 = ((com.tencent.xweb.z)localObject1).getUserAgentString();
        p.g(localObject1, "jsapi.settings.userAgentString");
        localObject1 = a.htmlEncode((String)localObject1);
        localObject2 = a.htmlEncode(locala.okh);
        String str2 = locala.appId;
        c.b localb = c.EuR;
        str1 = d.a.j.a((Iterable)d.a.j.listOf(new Object[] { localObject1, localObject2, str2, str1, Integer.valueOf(c.b.eWd().getVersion()), locala.EvJ }), (CharSequence)",", null, (CharSequence)",", 0, null, null, 58);
        g.yhR.kvStat(18151, str1 + paramString);
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
    c localc = this.Ewx;
    Object localObject = this.Evw;
    d.g.a.b localb = (d.g.a.b)new g(this);
    paramString = (d.g.a.b)new h(this, paramString);
    p.h(localObject, "webCompt");
    p.h(localb, "onerror");
    p.h(paramString, "onsuccess");
    localObject = (c.l.a)localc.eVS().get(localObject);
    if (localObject != null)
    {
      if (!n.aE((CharSequence)((c.l.a)localObject).EvH)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          kotlinx.coroutines.f.b((ah)bk.NII, null, (m)new c.y((c.l.a)localObject, null, localc, paramString, localb), 3);
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
    c localc = this.Ewx;
    p.h(paramString, "message");
    ad.v(c.TAG, "postToFront ".concat(String.valueOf(paramString)));
    c.a(localc, "WeixinOpenTags && WeixinOpenTags.onMessage(" + paramString + ')');
    localc.EuF.a(b.Euv);
    AppMethodBeat.o(82947);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler$Companion;", "", "()V", "LEVEL_DEBUG", "", "LEVEL_ERROR", "LEVEL_FATAL", "LEVEL_INFO", "LEVEL_NONE", "LEVEL_VERBOSE", "LEVEL_WARNING", "TAG", "", "TAG$annotations", "getTAG", "()Ljava/lang/String;", "webview-sdk_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "callbackId", "", "kotlin.jvm.PlatformType", "ret", "retValue", "", "", "", "doCallback"})
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
      localObject = i.Ewy;
      ad.d(i.access$getTAG$cp(), "invoke callback: " + paramString2 + ", " + paramMap);
      paramString2 = this.Ewz;
      localObject = new StringBuilder("WeixinWebCompt._callback(");
      p.g(paramString1, "callbackId");
      i.a(paramString2, a.aJG(paramString1) + ", " + paramMap + "['__params'])");
      AppMethodBeat.o(82936);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class c
    implements IPCRunCgi.a
  {
    c(i parami, String paramString) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(82937);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        localObject = this.Ewz;
        StringBuilder localStringBuilder = new StringBuilder("WeixinWebCompt._callback(").append(a.aJG(paramString1)).append(", {errType:").append(paramInt1).append(", errCode:").append(paramInt2).append(", errMsg:");
        if (paramString != null)
        {
          paramb = a.aJG(paramString);
          paramString = paramb;
          if (paramb != null) {}
        }
        else
        {
          paramString = "";
        }
        i.a((i)localObject, paramString + "})");
        i.d(this.Ewz).EuF.a(b.Eux);
        AppMethodBeat.o(82937);
        return;
      }
      paramString = this.Ewz;
      Object localObject = new StringBuilder("WeixinWebCompt._callback(").append(a.aJG(paramString1)).append(", ");
      p.g(paramb, "rr");
      paramb = paramb.aEF();
      if (paramb == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.WebComptCommCgiResp");
        AppMethodBeat.o(82937);
        throw paramString;
      }
      i.a(paramString, ((eed)paramb).HPo + ')');
      AppMethodBeat.o(82937);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mars/smc/IDKey;", "i", "", "jsonArray", "Lcom/tencent/mm/json/JSONArray;", "invoke"})
  static final class d
    extends q
    implements m<Integer, com.tencent.mm.ac.f, IDKey>
  {
    public static final d EwB;
    
    static
    {
      AppMethodBeat.i(82939);
      EwB = new d();
      AppMethodBeat.o(82939);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"dealMsg", "", "invoke"})
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
      com.tencent.mm.plugin.webview.c.f localf = i.a(this.Ewz);
      String str = paramString;
      JsapiPermissionWrapper localJsapiPermissionWrapper = this.Ewz.eRg();
      Bundle localBundle = new Bundle();
      localBundle.putString("name", i.b(this.Ewz));
      localf.a(str, localJsapiPermissionWrapper, localBundle, i.c(this.Ewz));
      AppMethodBeat.o(82941);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(i.e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(82942);
      this.EwC.invoke();
      AppMethodBeat.o(82942);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "ex", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "invoke"})
  static final class g
    extends q
    implements d.g.a.b<c.j, d.z>
  {
    g(i parami)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
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