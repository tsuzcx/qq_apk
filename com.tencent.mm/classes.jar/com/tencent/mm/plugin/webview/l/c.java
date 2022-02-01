package com.tencent.mm.plugin.webview.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.n.e;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.protocal.protobuf.ghk;
import com.tencent.mm.protocal.protobuf.ghl;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.v;
import com.tencent.xweb.ad;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.d.f.c;
import kotlin.g.b.ah.f;
import kotlin.n.n;
import kotlin.r;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ay;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "", "weakJsapi", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Ljava/lang/ref/WeakReference;)V", "inited", "", "reporter", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "getReporter", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "getWeakJsapi", "()Ljava/lang/ref/WeakReference;", "workerManager", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "getWorkerManager", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "workerManager$delegate", "Lkotlin/Lazy;", "appendTags", "", "webCompt", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "performanceHelper", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "cleanMainFrame", "clear", "createJsContext", "appId", "", "url", "launchMainFrame", "dispatchEvent", "event", "message", "engine", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "errReport", "errMsg", "errStack", "errLine", "", "errCol", "evaluateMainFrame", "script", "callback", "Lkotlin/Function1;", "getA8Key", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "a8KeyUrl", "webComptName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppScript", "Lkotlin/Pair;", "paramsObject", "Lcom/tencent/mm/json/JSONObject;", "getInterceptResponse", "Lcom/tencent/xweb/WebResourceResponse;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "performance", "frontEndPerformance", "postToBack", "postToFront", "refreshA8Key", "onerror", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "onsuccess", "config", "webComptInfo", "configTimeStamps", "", "resume", "end", "step", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$PerformanceSteps;", "evaluate", "launch", "a8key", "records", "steps", "", "start", "toJson", "A8KeyResp", "Companion", "CreateJSContextException", "PerformanceSteps", "WebComptWorkerManager", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  static final String TAG;
  private static final kotlin.j<com.tencent.mm.ad.i> Wms;
  public static final b XuL;
  private static final kotlin.j<String> XuP;
  static final kotlin.j<List<Integer>> XuQ;
  static final kotlin.j<String> XuR;
  private static final kotlin.j<Boolean> XuS;
  private static final kotlin.j<c.e.1> XuT;
  private static String XuU;
  private static final LinkedList<m> XuV;
  private static final kotlin.j<c.b.e> XuW;
  private static final String XuX;
  private static final kotlin.j<c.b.b> XuY;
  private static final String scheme;
  final WeakReference<com.tencent.mm.plugin.webview.jsapi.j> XuM;
  final i XuN;
  private final kotlin.j XuO;
  private boolean lYs;
  
  static
  {
    AppMethodBeat.i(82898);
    XuL = new b((byte)0);
    scheme = "webcompt://";
    TAG = "MicroMsg.WebComponent";
    Wms = kotlin.k.cm((kotlin.g.a.a)g.Xvz);
    XuP = kotlin.k.cm((kotlin.g.a.a)d.Xvv);
    XuQ = kotlin.k.cm((kotlin.g.a.a)f.Xvy);
    XuR = kotlin.k.cm((kotlin.g.a.a)j.XvC);
    XuS = kotlin.k.cm((kotlin.g.a.a)h.XvA);
    XuT = kotlin.k.cm((kotlin.g.a.a)e.Xvx);
    XuU = "";
    XuV = new LinkedList();
    XuW = kotlin.k.cm((kotlin.g.a.a)i.XvB);
    XuX = kotlin.g.b.s.X(com.tencent.mm.loader.i.b.bmz(), "webcompt_debug/");
    XuY = kotlin.k.cm((kotlin.g.a.a)c.Xvt);
    AppMethodBeat.o(82898);
  }
  
  public c(WeakReference<com.tencent.mm.plugin.webview.jsapi.j> paramWeakReference)
  {
    AppMethodBeat.i(295422);
    this.XuM = paramWeakReference;
    this.XuN = new i();
    b.iDn().clear();
    this.XuO = kotlin.k.cm((kotlin.g.a.a)new y(this));
    AppMethodBeat.o(295422);
  }
  
  private final String a(a parama)
  {
    AppMethodBeat.i(82905);
    Object localObject3 = parama.Xva;
    Object localObject1 = (com.tencent.mm.plugin.webview.jsapi.j)this.XuM.get();
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      ((Map)localObject3).put("User-agent", localObject1);
      localObject1 = kotlin.ah.aiuX;
      localObject1 = new com.tencent.mm.ad.i((Map)localObject3).toString();
      kotlin.g.b.s.s(localObject1, "JSONObject(httpHeaders.a… \"\"\n        }).toString()");
      Object localObject2 = new StringBuilder("{clientVersion:");
      localObject3 = BuildInfo.CLIENT_VERSION;
      kotlin.g.b.s.s(localObject3, "CLIENT_VERSION");
      parama = a.bnf((String)localObject3) + ",headers:" + (String)localObject1 + ",fullUrl:" + a.bnf(parama.sMq) + '}';
      AppMethodBeat.o(82905);
      return parama;
      localObject1 = ((com.tencent.mm.plugin.webview.jsapi.j)localObject1).WDz.getSettings();
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject2 = ((ad)localObject1).getUserAgentString();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
  }
  
  private final r<String, String> a(com.tencent.mm.ad.i parami, ddx paramddx)
  {
    AppMethodBeat.i(82908);
    this.XuN.a(b.Xut);
    Log.i(TAG, kotlin.g.b.s.X("start getappscript:", paramddx.name));
    Object localObject1 = f.Xwq;
    int i;
    if (f.a.getDebug())
    {
      localObject1 = f.Xwq;
      localObject1 = g.cTb().getString("debugJS", "");
      kotlin.g.b.s.checkNotNull(localObject1);
      kotlin.g.b.s.s(localObject1, "kvCommand.getString(\"debugJS\", \"\")!!");
      if (!n.bp((CharSequence)localObject1))
      {
        i = 1;
        if (i == 0) {
          break label237;
        }
        parami = a(new URL((String)localObject1), this, paramddx, "command debug", 100101, null, c.b.a.Xvf, 16);
        label119:
        if (parami == null) {
          break label430;
        }
      }
    }
    Object localObject2;
    for (;;)
    {
      Log.i(TAG, kotlin.g.b.s.X("finish getappscript:", paramddx.name));
      if (((String)parami.bsD).length() <= 1) {
        break label990;
      }
      localObject1 = TAG;
      paramddx = new StringBuilder("appscript:").append(paramddx.name).append('\n');
      localObject2 = (String)parami.bsD;
      i = Math.min(100, ((String)parami.bsD).length() - 1);
      if (localObject2 == null)
      {
        parami = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(82908);
        throw parami;
        i = 0;
        break;
        label237:
        if (parami.has(kotlin.g.b.s.X("debugJS_", paramddx.name)))
        {
          parami = a(new URL(parami.getString(kotlin.g.b.s.X("debugJS_", paramddx.name))), this, paramddx, kotlin.g.b.s.X("param debugJS_", paramddx.name), 100102, null, c.b.a.Xvc, 16);
          break label119;
        }
        if (parami.has("debugJS"))
        {
          parami = a(new URL(parami.getString("debugJS")), this, paramddx, "param debugJS", 100103, null, c.b.a.Xvc, 16);
          break label119;
        }
        parami = kotlin.g.b.s.X(paramddx.name, ".js");
        if (new com.tencent.mm.vfs.u(kotlin.g.b.s.X(XuX, parami)).jKS())
        {
          parami = kotlin.g.b.s.X(paramddx.name, ".js");
          parami = a(new com.tencent.mm.vfs.u(kotlin.g.b.s.X(XuX, parami)), this, paramddx, "sdcard debug", 100104, null, c.b.a.Xvd, 16);
          break label119;
        }
        parami = null;
        break label119;
        label430:
        parami = (CharSequence)paramddx.url;
        if ((parami == null) || (n.bp(parami)))
        {
          i = 1;
          if (i == 0)
          {
            parami = (CharSequence)paramddx.md5;
            if ((parami != null) && (!n.bp(parami))) {
              break label520;
            }
          }
        }
        label520:
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label525;
          }
          parami = paramddx.name;
          kotlin.g.b.s.s(parami, "webCompt.name");
          parami = new k(21001, parami, "url invalid");
          AppMethodBeat.o(82908);
          throw parami;
          i = 0;
          break;
        }
        label525:
        if (new com.tencent.mm.vfs.u(kotlin.g.b.s.X(b.a(paramddx), ".js")).jKS())
        {
          parami = a(new com.tencent.mm.vfs.u(kotlin.g.b.s.X(b.a(paramddx), ".js")), this, paramddx, "cache file", 21004, c.b.c.Xvm, null, 32);
          this.XuN.a(b.XtS);
          continue;
        }
        localObject1 = new URL(paramddx.url);
        Log.d(TAG, kotlin.g.b.s.X("createJsContext appScript url:", localObject1));
        try
        {
          localObject2 = (Closeable)((URL)localObject1).openStream();
          try
          {
            parami = (InputStream)localObject2;
            kotlin.g.b.s.s(parami, "input");
            parami = kotlin.f.a.ag(parami);
            if (kotlin.g.b.s.p(paramddx.md5, com.tencent.mm.b.g.e((InputStream)new ByteArrayInputStream(parami), parami.length)))
            {
              Object localObject3 = new com.tencent.mm.vfs.u(kotlin.g.b.s.X(b.a(paramddx), ".js"));
              String str = ((com.tencent.mm.vfs.u)localObject3).jKO();
              kotlin.g.b.s.checkNotNull(str);
              new com.tencent.mm.vfs.u(str).jKY();
              ((com.tencent.mm.vfs.u)localObject3).jKZ();
              v.b((com.tencent.mm.vfs.u)localObject3, parami);
              localObject3 = b.iDn().Xvi;
              str = ((URL)localObject1).toString();
              kotlin.g.b.s.s(str, "url.toString()");
              ((LinkedList)localObject3).add(new c.b.d(str, c.b.c.Xvn, null, 4));
              parami = new r(((URL)localObject1).toString(), new String(parami, kotlin.n.d.UTF_8));
              this.XuN.a(b.XtT);
              kotlin.f.b.a((Closeable)localObject2, null);
              continue;
            }
            this.XuN.a(b.XtY);
            parami = paramddx.name;
            kotlin.g.b.s.s(parami, "webCompt.name");
            parami = new k(21003, parami, kotlin.g.b.s.X("load appScript file md5 fail:", localObject1));
            AppMethodBeat.o(82908);
            throw parami;
          }
          finally
          {
            try
            {
              AppMethodBeat.o(82908);
              throw parami;
            }
            finally
            {
              kotlin.f.b.a((Closeable)localObject2, parami);
              AppMethodBeat.o(82908);
            }
          }
          localObject2 = ((String)localObject2).substring(0, i);
        }
        catch (Exception parami)
        {
          paramddx = paramddx.name;
          kotlin.g.b.s.s(paramddx, "webCompt.name");
          parami = new k(21002, paramddx, "load appScript ex:" + parami.getMessage() + ", url=" + localObject1);
          AppMethodBeat.o(82908);
          throw parami;
        }
      }
    }
    kotlin.g.b.s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    Log.d((String)localObject1, (String)localObject2);
    label990:
    AppMethodBeat.o(82908);
    return parami;
  }
  
  private static final <T> r<String, String> a(T paramT, c paramc, ddx paramddx, String paramString, int paramInt, c.b.c paramc1, c.b.a parama)
  {
    AppMethodBeat.i(295479);
    Log.d(TAG, "createJsContext appScript " + paramString + ", " + paramT);
    for (;;)
    {
      try
      {
        Object localObject;
        if ((paramT instanceof com.tencent.mm.vfs.u))
        {
          localObject = new r(com.tencent.mm.vfs.ah.v(((com.tencent.mm.vfs.u)paramT).jKT()), v.an((com.tencent.mm.vfs.u)paramT));
          paramc.XuN.a(b.Xuu);
          b.iDn().Xvi.add(new c.b.d(n.bW((String)((r)localObject).bsC, XuX, ""), paramc1, parama));
          AppMethodBeat.o(295479);
          return localObject;
        }
        if ((paramT instanceof URL))
        {
          localObject = paramT.toString();
          URL localURL = (URL)paramT;
          Charset localCharset = kotlin.n.d.UTF_8;
          localObject = new r(localObject, new String(kotlin.f.d.e(localURL), localCharset));
          paramc.XuN.a(b.XtW);
        }
        else
        {
          localObject = new r("", "");
        }
      }
      catch (Exception paramc1)
      {
        if ((paramT instanceof URL)) {
          paramc.XuN.a(b.XtX);
        }
        paramc.XuN.a(b.Xuv);
        paramc.XuN.a(b.XtZ);
        paramc = paramddx.name;
        kotlin.g.b.s.s(paramc, "webCompt.name");
        paramT = new k(paramInt, paramc, "load " + paramString + " fail:" + paramT + ", " + paramc1);
        AppMethodBeat.o(295479);
        throw paramT;
      }
    }
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.n.g paramg, ddx paramddx, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(295435);
    StringBuilder localStringBuilder = new StringBuilder("WeixinWebCompt.config({resume:").append(paramBoolean).append(", debug:");
    f.a locala = f.Xwq;
    c(paramg, f.a.getDebug() + ", iframeUrlPattern:'" + (String)XuP.getValue() + "', configFinishTs:" + paramLong + ", bizReportId:" + paramddx.aaJr + ", options:" + paramddx.APF + "})");
    Log.i(TAG, kotlin.g.b.s.X("WeixinWebCompt.config:", paramddx.APF));
    AppMethodBeat.o(295435);
  }
  
  private static final void a(c paramc, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc1)
  {
    AppMethodBeat.i(295491);
    kotlin.g.b.s.u(paramc, "this$0");
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      paramc.XuN.a(b.XuF);
    }
    AppMethodBeat.o(295491);
  }
  
  static void a(com.tencent.mm.pluginsdk.s params, l paraml)
  {
    AppMethodBeat.i(82901);
    params.cf(kotlin.g.b.s.X(paraml.sUP, "_START"), System.currentTimeMillis());
    AppMethodBeat.o(82901);
  }
  
  private final Object c(String paramString1, final String paramString2, kotlin.d.d<? super a> paramd)
  {
    AppMethodBeat.i(82906);
    kotlin.d.h localh = new kotlin.d.h(kotlin.d.a.b.au(paramd));
    kotlin.d.d locald = (kotlin.d.d)localh;
    this.XuN.a(b.Xuq);
    Log.i(TAG, kotlin.g.b.s.X("start geta8key:", paramString1));
    final com.tencent.mm.plugin.webview.e.c localc = new com.tencent.mm.plugin.webview.e.c();
    Object localObject = (com.tencent.mm.plugin.webview.jsapi.j)this.XuM.get();
    if (localObject == null) {}
    for (localObject = null;; localObject = (String)((com.tencent.mm.plugin.webview.jsapi.j)localObject).hVt.get("srcUsername"))
    {
      localc.setUsername((String)localObject);
      localc.a(paramString1, (com.tencent.mm.plugin.webview.e.a)new u(locald, localc, this, paramString2));
      paramString1 = localh.kli();
      if (paramString1 == kotlin.d.a.a.aiwj) {
        kotlin.g.b.s.u(paramd, "frame");
      }
      AppMethodBeat.o(82906);
      return paramString1;
    }
  }
  
  static void c(com.tencent.mm.plugin.appbrand.n.g paramg, String paramString)
  {
    AppMethodBeat.i(295442);
    paramg.evaluateJavascript(paramString, null);
    AppMethodBeat.o(295442);
  }
  
  public static final void iDc()
  {
    AppMethodBeat.i(82923);
    b.Jg(false);
    AppMethodBeat.o(82923);
  }
  
  static final List<String> mn(List<Integer> paramList)
  {
    AppMethodBeat.i(295488);
    SecureRandom localSecureRandom = new SecureRandom();
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = new byte[((Number)((Iterator)localObject1).next()).intValue()];
      localSecureRandom.nextBytes((byte[])localObject2);
      CharSequence localCharSequence1 = (CharSequence)"";
      kotlin.g.a.b localb = (kotlin.g.a.b)v.Xwk;
      CharSequence localCharSequence2 = (CharSequence)"";
      CharSequence localCharSequence3 = (CharSequence)"";
      CharSequence localCharSequence4 = (CharSequence)"...";
      kotlin.g.b.s.u(localObject2, "$this$joinToString");
      kotlin.g.b.s.u(localCharSequence1, "separator");
      kotlin.g.b.s.u(localCharSequence2, "prefix");
      kotlin.g.b.s.u(localCharSequence3, "postfix");
      kotlin.g.b.s.u(localCharSequence4, "truncated");
      localObject2 = ((StringBuilder)kotlin.a.k.a((byte[])localObject2, (Appendable)new StringBuilder(), localCharSequence1, localCharSequence2, localCharSequence3, localCharSequence4, localb)).toString();
      kotlin.g.b.s.s(localObject2, "joinTo(StringBuilder(), …ed, transform).toString()");
      paramList.add(localObject2);
    }
    paramList = (List)paramList;
    AppMethodBeat.o(295488);
    return paramList;
  }
  
  private final void w(final String paramString, final kotlin.g.a.b<? super String, kotlin.ah> paramb)
  {
    AppMethodBeat.i(82912);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new t(this, paramString, paramb));
    AppMethodBeat.o(82912);
  }
  
  public final com.tencent.mm.plugin.appbrand.n.g bng(String paramString)
  {
    AppMethodBeat.i(295599);
    kotlin.g.b.s.u(paramString, "webCompt");
    paramString = (c.m.a)iDa().get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(295599);
      return null;
    }
    paramString = paramString.iDs();
    AppMethodBeat.o(295599);
    return paramString;
  }
  
  public final void bw(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(295595);
    kotlin.g.b.s.u(paramString1, "webCompt");
    kotlin.g.b.s.u(paramString2, "event");
    if (Util.isNullOrNil(paramString2))
    {
      Log.w(TAG, "dispatch event is null");
      AppMethodBeat.o(295595);
      return;
    }
    Log.v(TAG, "dispatch event=%s, value=%s", new Object[] { paramString2, paramString3 });
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new r(this, paramString1, paramString2, paramString3));
    this.XuN.a(b.XuG);
    AppMethodBeat.o(295595);
  }
  
  public final void clear()
  {
    int i;
    for (;;)
    {
      Object localObject2;
      c.m.a locala;
      try
      {
        AppMethodBeat.i(82900);
        b.iDn().clear();
        if (!this.lYs) {
          break label335;
        }
        m localm = iDa();
        i locali = this.XuN;
        kotlin.g.b.s.u(locali, "reporter");
        Log.i(TAG, kotlin.g.b.s.X("clear workerManager#", Integer.valueOf(localm.id)));
        Iterator localIterator = ((Map)localm).entrySet().iterator();
        i = -1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (Map.Entry)localIterator.next();
        locala = (c.m.a)((Map.Entry)localObject2).getValue();
        if ((!locala.bgt) && (locala.XvQ) && (!localm.XvM.containsKey(((Map.Entry)localObject2).getKey())))
        {
          locala.Xvs = true;
          locala.XvU = null;
          Log.i(TAG, "WebComptWorker.recycle " + locala.appId + '@' + locala.XvO.name + ':' + locala.XvN);
          ((Map)localm.XvM).put(((Map.Entry)localObject2).getKey(), locala);
          locali.a(b.XuI);
          continue;
        }
        if (locala.bgt) {
          break label275;
        }
      }
      finally {}
      if (locala.XvN == localObject1.XvK)
      {
        i = localObject1.XvK;
      }
      else
      {
        label275:
        localObject2 = locala.XvP;
        String str = locala.XvO.name;
        kotlin.g.b.s.s(str, "webComptInfo.name");
        ((c)localObject2).bw(str, "onWebComptDestroy", "{}");
        locala.iDs().destroy();
      }
    }
    localObject1.XvK = i;
    localObject1.clear();
    label335:
    AppMethodBeat.o(82900);
  }
  
  final m iDa()
  {
    AppMethodBeat.i(82899);
    m localm = (m)this.XuO.getValue();
    AppMethodBeat.o(82899);
    return localm;
  }
  
  public final void iDb()
  {
    AppMethodBeat.i(295608);
    if (this.lYs)
    {
      a(this, "window.WeixinOpenTags && window.WeixinOpenTags.onClean()");
      this.XuN.a(b.Xuf);
    }
    AppMethodBeat.o(295608);
  }
  
  public final void j(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82910);
    kotlin.g.b.s.u(paramString1, "webCompt");
    kotlin.g.b.s.u(paramString2, "errMsg");
    c.m.a locala = (c.m.a)iDa().get(paramString1);
    ghk localghk;
    if (locala != null)
    {
      localghk = new ghk();
      localghk.hNw = paramString2;
      localghk.acdt = paramString3;
      localghk.acdu = paramInt1;
      localghk.acdv = paramInt2;
      paramString2 = (com.tencent.mm.plugin.webview.jsapi.j)this.XuM.get();
      if (paramString2 != null) {
        break label243;
      }
      paramString2 = "";
    }
    for (;;)
    {
      localghk.acat = paramString2;
      localghk.vTt = locala.vTt;
      localghk.appid = locala.appId;
      localghk.acdw = paramString1;
      localghk.acdx = b.iDm().getVersion();
      localghk.acdy = locala.XvS;
      localghk.acdz = locala.XvT;
      this.XuN.a(b.XuE);
      paramString1 = new com.tencent.mm.am.c.a();
      paramString1.otE = ((com.tencent.mm.bx.a)localghk);
      paramString1.otF = ((com.tencent.mm.bx.a)new ghl());
      paramString1.uri = "/cgi-bin/mmbiz-bin/webcompt/reportjserr";
      paramString1.funcId = 2914;
      paramString1.otG = 0;
      paramString1.respCmdId = 0;
      IPCRunCgi.a(paramString1.bEF(), new c..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(82910);
      return;
      label243:
      paramString2 = paramString2.WDz.getSettings();
      if (paramString2 == null)
      {
        paramString2 = "";
      }
      else
      {
        paramString3 = paramString2.getUserAgentString();
        paramString2 = paramString3;
        if (paramString3 == null) {
          paramString2 = "";
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "", "a8key", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "fullUrl", "", "httpHeaders", "", "(Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;Ljava/lang/String;Ljava/util/Map;)V", "getFullUrl", "()Ljava/lang/String;", "getHttpHeaders", "()Ljava/util/Map;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getJsPerm", "()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final com.tencent.mm.plugin.webview.e.c XuZ;
    final Map<String, String> Xva;
    final String sMq;
    
    public a(com.tencent.mm.plugin.webview.e.c paramc, String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(295482);
      this.XuZ = paramc;
      this.sMq = paramString;
      this.Xva = paramMap;
      AppMethodBeat.o(295482);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion;", "", "()V", "PREFIX_DEBUG_PATH", "", "TAG", "getTAG$webview_sdk_release", "()Ljava/lang/String;", "_cachedFilePath", "debugInfo", "getDebugInfo", "debugger", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "getDebugger", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "debugger$delegate", "Lkotlin/Lazy;", "iframeUrlPattern", "getIframeUrlPattern", "iframeUrlPattern$delegate", "manager", "com/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$2$1", "getManager", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$2$1;", "manager$delegate", "matrix", "", "", "getMatrix", "()Ljava/util/List;", "matrix$delegate", "meta", "Lcom/tencent/mm/json/JSONObject;", "getMeta", "()Lcom/tencent/mm/json/JSONObject;", "meta$delegate", "pauseOnBackForeground", "", "getPauseOnBackForeground", "()Z", "pauseOnBackForeground$delegate", "preloadWorkers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "scheme", "getScheme$annotations", "getScheme", "scriptManager", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "getScriptManager", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "scriptManager$delegate", "skeleton", "getSkeleton", "skeleton$delegate", "debugPath", "getDebugPath", "(Ljava/lang/String;)Ljava/lang/String;", "savePath", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "getSavePath", "(Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;)Ljava/lang/String;", "version", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getVersion", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "clearDebugPath", "", "jsapiOnly", "appOnly", "getCachedFilePath", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedfilePathInMain", "getLocalScript", "path", "scripts", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScript", "initBackForegroundListener", "preloadWorker", "force", "readText", "DebugType", "Debugger", "ResType", "Script", "ScriptManager", "Worker", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static void Jg(boolean paramBoolean)
    {
      AppMethodBeat.i(82822);
      if (c.iDh().size() < 3)
      {
        if (paramBoolean) {
          break label50;
        }
        if (((Collection)c.iDh()).isEmpty()) {
          break label45;
        }
      }
      label45:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(82822);
        return;
      }
      label50:
      kotlinx.coroutines.j.a((aq)bu.ajwo, (kotlin.d.f)bg.kCi(), null, (kotlin.g.a.m)new j(null), 2);
      AppMethodBeat.o(82822);
    }
    
    static String a(ddx paramddx)
    {
      AppMethodBeat.i(295547);
      paramddx = com.tencent.mm.loader.i.b.bmr() + "webcompt/" + paramddx.name + '/' + paramddx.md5;
      AppMethodBeat.o(295547);
      return paramddx;
    }
    
    private static final boolean ab(com.tencent.mm.vfs.u paramu)
    {
      AppMethodBeat.i(295576);
      kotlin.g.b.s.u(paramu, "filter");
      if (paramu.jKV())
      {
        String str = paramu.getName();
        kotlin.g.b.s.s(str, "filter.name");
        if (!n.rs(str, ".js"))
        {
          paramu = paramu.getName();
          kotlin.g.b.s.s(paramu, "filter.name");
          if (!n.rs(paramu, ".json")) {}
        }
        else
        {
          AppMethodBeat.o(295576);
          return true;
        }
      }
      AppMethodBeat.o(295576);
      return false;
    }
    
    private static final void ac(com.tencent.mm.vfs.u paramu)
    {
      AppMethodBeat.i(295582);
      paramu = paramu.a(c.b..ExternalSyntheticLambda0.INSTANCE);
      kotlin.g.b.s.checkNotNull(paramu);
      kotlin.g.b.s.s(paramu, "listFiles { filter ->\n  …on\"))\n                }!!");
      paramu = (Object[])paramu;
      int j = paramu.length;
      int i = 0;
      while (i < j)
      {
        ((com.tencent.mm.vfs.u)paramu[i]).diJ();
        i += 1;
      }
      AppMethodBeat.o(295582);
    }
    
    private static String d(q paramq, String paramString)
    {
      AppMethodBeat.i(82826);
      paramq = paramq.Va(paramString);
      if (paramq == null)
      {
        AppMethodBeat.o(82826);
        return "";
      }
      paramq = (Closeable)paramq;
      try
      {
        paramString = new String(kotlin.f.a.ag((InputStream)paramq), kotlin.n.d.UTF_8);
        kotlin.f.b.a(paramq, null);
        AppMethodBeat.o(82826);
        return paramString;
      }
      finally
      {
        try
        {
          AppMethodBeat.o(82826);
          throw paramString;
        }
        finally
        {
          kotlin.f.b.a(paramq, paramString);
          AppMethodBeat.o(82826);
        }
      }
    }
    
    static String g(String paramString, LinkedList<d> paramLinkedList)
    {
      AppMethodBeat.i(82824);
      Log.i(c.access$getTAG$cp(), "getLocalScript: %s", new Object[] { paramString });
      Object localObject1 = f.Xwq;
      if (f.a.getDebug())
      {
        localObject1 = kotlin.g.b.s.X("jsapi", paramString);
        localObject1 = new com.tencent.mm.vfs.u(kotlin.g.b.s.X(c.iDj(), localObject1));
        if (((com.tencent.mm.vfs.u)localObject1).jKS())
        {
          if (paramLinkedList != null) {
            paramLinkedList.add(new d(paramString, null, a.Xvd, 2));
          }
          paramString = v.an((com.tencent.mm.vfs.u)localObject1);
          AppMethodBeat.o(82824);
          return paramString;
        }
        localObject1 = new com.tencent.mm.vfs.u(kotlin.g.b.s.X(c.iDj(), "jsapi/webcompt.wcpkg"));
        if (((com.tencent.mm.vfs.u)localObject1).jKS())
        {
          if (paramLinkedList != null) {
            paramLinkedList.add(new d(paramString, null, a.Xve, 2));
          }
          paramLinkedList = (Closeable)new WxaPkg((com.tencent.mm.vfs.u)localObject1);
          try
          {
            localObject1 = (WxaPkg)paramLinkedList;
            ((WxaPkg)localObject1).cfK();
            localb = c.XuL;
            paramString = d((q)localObject1, paramString);
            kotlin.f.b.a(paramLinkedList, null);
            AppMethodBeat.o(82824);
            return paramString;
          }
          finally
          {
            try
            {
              AppMethodBeat.o(82824);
              throw paramString;
            }
            finally
            {
              kotlin.f.b.a(paramLinkedList, paramString);
              AppMethodBeat.o(82824);
            }
          }
        }
      }
      Object localObject3 = iDm();
      kotlin.g.b.s.u(paramString, "path");
      b localb = c.XuL;
      localObject3 = d(((e)localObject3).WkR, paramString);
      if (paramLinkedList != null)
      {
        localb = c.XuL;
        paramLinkedList.add(new d(paramString, iDn().Xvj, null, 4));
      }
      AppMethodBeat.o(82824);
      return localObject3;
    }
    
    public static String gca()
    {
      AppMethodBeat.i(82831);
      Object localObject = iDn();
      StringBuilder localStringBuilder = new StringBuilder("\n            [debug]\n            debug: ");
      f.a locala = f.Xwq;
      localObject = n.bJB(f.a.getDebug() + "\n\n            [lib]\n            version: " + ((b)localObject).Xvk + "\n            res: " + ((b)localObject).Xvj + "\n\n            " + p.a((Iterable)((b)localObject).Xvi, (CharSequence)"\n\n", null, null, 0, null, null, 62) + "\n\n            " + p.a((Iterable)((b)localObject).Xvh, (CharSequence)"\n\n", null, null, 0, null, null, 62) + "\n            ");
      AppMethodBeat.o(82831);
      return localObject;
    }
    
    static int i(q paramq)
    {
      AppMethodBeat.i(295541);
      try
      {
        paramq = d(paramq, "/meta.json");
        if (((CharSequence)paramq).length() != 0) {
          break label85;
        }
        i = 1;
      }
      catch (Exception paramq)
      {
        for (;;)
        {
          Log.e(c.access$getTAG$cp(), kotlin.g.b.s.X("parse IWxaPkg.version Error:", paramq.getMessage()));
          int i = 0;
          continue;
          i = 0;
        }
      }
      if (i != 0)
      {
        AppMethodBeat.o(295541);
        return 0;
      }
      i = new com.tencent.mm.ad.i(paramq).optInt("version");
      AppMethodBeat.o(295541);
      return i;
    }
    
    static e iDm()
    {
      AppMethodBeat.i(82827);
      e locale = (e)c.iDi().getValue();
      AppMethodBeat.o(82827);
      return locale;
    }
    
    static b iDn()
    {
      AppMethodBeat.i(82830);
      b localb = (b)c.iDk().getValue();
      AppMethodBeat.o(82830);
      return localb;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "", "(Ljava/lang/String;I)V", "NA", "PARAM", "SDCARD", "SDCARD_PKG", "COMMAND", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    static enum a
    {
      static
      {
        AppMethodBeat.i(82775);
        Xvb = new a("NA", 0);
        Xvc = new a("PARAM", 1);
        Xvd = new a("SDCARD", 2);
        Xve = new a("SDCARD_PKG", 3);
        Xvf = new a("COMMAND", 4);
        Xvg = new a[] { Xvb, Xvc, Xvd, Xve, Xvf };
        AppMethodBeat.o(82775);
      }
      
      private a() {}
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "", "()V", "isPreload", "", "()Z", "setPreload", "(Z)V", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "getResType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "setResType", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;)V", "scripts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScripts", "()Ljava/util/LinkedList;", "verion", "", "getVerion", "()I", "setVerion", "(I)V", "workers", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "getWorkers", "clear", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    static final class b
    {
      final LinkedList<c.b.f> Xvh;
      final LinkedList<c.b.d> Xvi;
      c.b.c Xvj;
      int Xvk;
      boolean rsE;
      
      public b()
      {
        AppMethodBeat.i(82780);
        this.Xvh = new LinkedList();
        this.Xvi = new LinkedList();
        this.Xvj = c.b.c.Xvl;
        AppMethodBeat.o(82780);
      }
      
      public final void a(c.b.c paramc)
      {
        AppMethodBeat.i(82778);
        kotlin.g.b.s.u(paramc, "<set-?>");
        this.Xvj = paramc;
        AppMethodBeat.o(82778);
      }
      
      public final void clear()
      {
        AppMethodBeat.i(82779);
        this.Xvh.clear();
        this.Xvi.clear();
        AppMethodBeat.o(82779);
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "", "(Ljava/lang/String;I)V", "NA", "CACHE", "NETWORK", "ASSETS", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    static enum c
    {
      static
      {
        AppMethodBeat.i(82781);
        Xvl = new c("NA", 0);
        Xvm = new c("CACHE", 1);
        Xvn = new c("NETWORK", 2);
        Xvo = new c("ASSETS", 3);
        Xvp = new c[] { Xvl, Xvm, Xvn, Xvo };
        AppMethodBeat.o(82781);
      }
      
      private c() {}
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "", "uri", "", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "debugType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;)V", "getDebugType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "getResType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "getUri", "()Ljava/lang/String;", "toString", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    static final class d
    {
      private final c.b.c Xvj;
      private final c.b.a Xvq;
      private final String uri;
      
      public d(String paramString, c.b.c paramc, c.b.a parama)
      {
        AppMethodBeat.i(82785);
        this.uri = paramString;
        this.Xvj = paramc;
        this.Xvq = parama;
        AppMethodBeat.o(82785);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(82784);
        StringBuilder localStringBuilder = new StringBuilder("[script]\n                ");
        if (this.Xvj != c.b.c.Xvl) {}
        for (String str = kotlin.g.b.s.X("resType: ", this.Xvj);; str = kotlin.g.b.s.X("debugType: ", this.Xvq))
        {
          str = n.bJB(str + "\n                " + this.uri + "\n                ");
          AppMethodBeat.o(82784);
          return str;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "", "wxaPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)V", "version", "", "getVersion", "()I", "version$delegate", "Lkotlin/Lazy;", "getScript", "", "path", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    static final class e
    {
      final q WkR;
      private final kotlin.j Wmt;
      
      public e(q paramq)
      {
        AppMethodBeat.i(82790);
        this.WkR = paramq;
        this.Wmt = kotlin.k.cm((kotlin.g.a.a)new a(this));
        AppMethodBeat.o(82790);
      }
      
      public final int getVersion()
      {
        AppMethodBeat.i(82789);
        int i = ((Number)this.Wmt.getValue()).intValue();
        AppMethodBeat.o(82789);
        return i;
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends kotlin.g.b.u
        implements kotlin.g.a.a<Integer>
      {
        a(c.b.e parame)
        {
          super();
        }
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "", "id", "", "isPreload", "", "isRecycled", "(IZZ)V", "getId", "()I", "()Z", "scripts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScripts", "()Ljava/util/LinkedList;", "toString", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    static final class f
    {
      final LinkedList<c.b.d> Xvi;
      private final boolean Xvs;
      private final int id;
      private final boolean rsE;
      
      private f(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
      {
        AppMethodBeat.i(82792);
        this.id = paramInt;
        this.rsE = paramBoolean1;
        this.Xvs = paramBoolean2;
        this.Xvi = new LinkedList();
        AppMethodBeat.o(82792);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(82791);
        String str = n.bJB("[worker #" + this.id + "]\n                preload: " + this.rsE + "\n                recycled: " + this.Xvs + "\n\n                " + p.a((Iterable)this.Xvi, (CharSequence)"\n\n", null, null, 0, null, null, 62) + "\n                ");
        AppMethodBeat.o(82791);
        return str;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class g<InputType, ResultType>
      implements com.tencent.mm.ipcinvoker.d
    {
      public static final g<InputType, ResultType> Xvu;
      
      static
      {
        AppMethodBeat.i(82802);
        Xvu = new g();
        AppMethodBeat.o(82802);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCString;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class h
      extends kotlin.g.b.u
      implements kotlin.g.a.b<IPCString, kotlin.ah>
    {
      h(kotlin.d.d<? super String> paramd)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$initBackForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "isPaused", "", "()Z", "setPaused", "(Z)V", "onAppBackground", "", "activity", "", "onAppForeground", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class i
      extends q.a
    {
      boolean isPaused;
      
      public final void onAppBackground(String paramString)
      {
        AppMethodBeat.i(295466);
        com.tencent.mm.ae.d.a(10000L, (kotlin.g.a.a)new a(this));
        AppMethodBeat.o(295466);
      }
      
      public final void onAppForeground(String paramString)
      {
        AppMethodBeat.i(295458);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this));
        AppMethodBeat.o(295458);
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends kotlin.g.b.u
        implements kotlin.g.a.a<kotlin.ah>
      {
        a(c.b.i parami)
        {
          super();
        }
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class b
        extends kotlin.g.b.u
        implements kotlin.g.a.a<kotlin.ah>
      {
        b(c.b.i parami)
        {
          super();
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class j
      extends kotlin.d.b.a.k
      implements kotlin.g.a.m<aq, kotlin.d.d<? super kotlin.ah>, Object>
    {
      int label;
      
      j(kotlin.d.d<? super j> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(82813);
        paramObject = (kotlin.d.d)new j(paramd);
        AppMethodBeat.o(82813);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(82812);
        Object localObject = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(82812);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = c.XuL;
          paramObject = (kotlin.d.d)this;
          this.label = 1;
          if (c.b.ar(paramObject) == localObject)
          {
            AppMethodBeat.o(82812);
            return localObject;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = new c.m();
        if (paramObject.XvK == -1)
        {
          localObject = c.XuL;
          localObject = c.b.iDo();
          c.b localb = c.XuL;
          paramObject.XvK = ((c.e.1)localObject).create(c.b.g("/wxwebcompt.js", paramObject.XvL.Xvi));
          localObject = c.XuL;
          Log.i(c.access$getTAG$cp(), kotlin.g.b.s.X("preload workerManager#", Integer.valueOf(paramObject.id)));
        }
        for (;;)
        {
          c.iDh().offerFirst(paramObject);
          paramObject = kotlin.ah.aiuX;
          AppMethodBeat.o(82812);
          return paramObject;
          localObject = c.XuL;
          Log.w(c.access$getTAG$cp(), kotlin.g.b.s.X("preload twice #", Integer.valueOf(paramObject.id)));
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<c.b.b>
  {
    public static final c Xvt;
    
    static
    {
      AppMethodBeat.i(82800);
      Xvt = new c();
      AppMethodBeat.o(82800);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<String>
  {
    public static final d Xvv;
    
    static
    {
      AppMethodBeat.i(82805);
      Xvv = new d();
      AppMethodBeat.o(82805);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<1>
  {
    public static final e Xvx;
    
    static
    {
      AppMethodBeat.i(295480);
      Xvx = new e();
      AppMethodBeat.o(295480);
    }
    
    e()
    {
      super();
    }
    
    private static final void iDq()
    {
      AppMethodBeat.i(295478);
      c.b localb = c.XuL;
      if (((Boolean)c.iDf().getValue()).booleanValue()) {
        new c.b.i().alive();
      }
      AppMethodBeat.o(295478);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<List<? extends Integer>>
  {
    public static final f Xvy;
    
    static
    {
      AppMethodBeat.i(82809);
      Xvy = new f();
      AppMethodBeat.o(82809);
    }
    
    f()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/json/JSONObject;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.ad.i>
  {
    public static final g Xvz;
    
    static
    {
      AppMethodBeat.i(82811);
      Xvz = new g();
      AppMethodBeat.o(82811);
    }
    
    g()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    public static final h XvA;
    
    static
    {
      AppMethodBeat.i(295473);
      XvA = new h();
      AppMethodBeat.o(295473);
    }
    
    h()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<c.b.e>
  {
    public static final i XvB;
    
    static
    {
      AppMethodBeat.i(82816);
      XvB = new i();
      AppMethodBeat.o(82816);
    }
    
    i()
    {
      super();
    }
    
    /* Error */
    private static c.b.e iDr()
    {
      // Byte code:
      //   0: ldc 50
      //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 52	com/tencent/mm/plugin/appbrand/appcache/f
      //   8: dup
      //   9: invokestatic 58	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   12: ldc 60
      //   14: invokespecial 63	com/tencent/mm/plugin/appbrand/appcache/f:<init>	(Landroid/content/Context;Ljava/lang/String;)V
      //   17: astore_2
      //   18: aload_2
      //   19: invokevirtual 67	com/tencent/mm/plugin/appbrand/appcache/f:cfK	()Z
      //   22: pop
      //   23: getstatic 71	com/tencent/mm/plugin/webview/l/c:XuL	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   26: astore_3
      //   27: aload_2
      //   28: checkcast 73	com/tencent/mm/plugin/appbrand/appcache/q
      //   31: invokestatic 78	com/tencent/mm/plugin/webview/l/c$b:i	(Lcom/tencent/mm/plugin/appbrand/appcache/q;)I
      //   34: istore_1
      //   35: invokestatic 82	com/tencent/mm/plugin/webview/l/c:iDl	()Ljava/lang/String;
      //   38: checkcast 84	java/lang/CharSequence
      //   41: invokestatic 90	kotlin/n/n:bp	(Ljava/lang/CharSequence;)Z
      //   44: ifne +119 -> 163
      //   47: iconst_1
      //   48: istore_0
      //   49: iload_0
      //   50: ifeq +118 -> 168
      //   53: invokestatic 82	com/tencent/mm/plugin/webview/l/c:iDl	()Ljava/lang/String;
      //   56: invokestatic 96	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
      //   59: ifeq +109 -> 168
      //   62: new 98	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
      //   65: dup
      //   66: invokestatic 82	com/tencent/mm/plugin/webview/l/c:iDl	()Ljava/lang/String;
      //   69: invokespecial 101	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Ljava/lang/String;)V
      //   72: astore_3
      //   73: aload_3
      //   74: invokevirtual 102	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:cfK	()Z
      //   77: pop
      //   78: getstatic 71	com/tencent/mm/plugin/webview/l/c:XuL	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   81: astore 4
      //   83: aload_3
      //   84: checkcast 73	com/tencent/mm/plugin/appbrand/appcache/q
      //   87: invokestatic 78	com/tencent/mm/plugin/webview/l/c$b:i	(Lcom/tencent/mm/plugin/appbrand/appcache/q;)I
      //   90: istore_0
      //   91: iload_0
      //   92: iload_1
      //   93: if_icmple +75 -> 168
      //   96: getstatic 71	com/tencent/mm/plugin/webview/l/c:XuL	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   99: astore 4
      //   101: invokestatic 105	com/tencent/mm/plugin/webview/l/c:access$getTAG$cp	()Ljava/lang/String;
      //   104: ldc 107
      //   106: iload_0
      //   107: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   110: invokestatic 119	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   113: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   116: getstatic 71	com/tencent/mm/plugin/webview/l/c:XuL	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   119: astore 4
      //   121: invokestatic 128	com/tencent/mm/plugin/webview/l/c$b:iDn	()Lcom/tencent/mm/plugin/webview/l/c$b$b;
      //   124: getstatic 134	com/tencent/mm/plugin/webview/l/c$b$c:Xvn	Lcom/tencent/mm/plugin/webview/l/c$b$c;
      //   127: invokevirtual 140	com/tencent/mm/plugin/webview/l/c$b$b:a	(Lcom/tencent/mm/plugin/webview/l/c$b$c;)V
      //   130: getstatic 71	com/tencent/mm/plugin/webview/l/c:XuL	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   133: astore 4
      //   135: invokestatic 128	com/tencent/mm/plugin/webview/l/c$b:iDn	()Lcom/tencent/mm/plugin/webview/l/c$b$b;
      //   138: iload_0
      //   139: putfield 144	com/tencent/mm/plugin/webview/l/c$b$b:Xvk	I
      //   142: aload_3
      //   143: astore_2
      //   144: new 146	com/tencent/mm/plugin/webview/l/c$b$e
      //   147: dup
      //   148: aload_2
      //   149: checkcast 73	com/tencent/mm/plugin/appbrand/appcache/q
      //   152: invokespecial 149	com/tencent/mm/plugin/webview/l/c$b$e:<init>	(Lcom/tencent/mm/plugin/appbrand/appcache/q;)V
      //   155: astore_2
      //   156: ldc 50
      //   158: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   161: aload_2
      //   162: areturn
      //   163: iconst_0
      //   164: istore_0
      //   165: goto -116 -> 49
      //   168: getstatic 71	com/tencent/mm/plugin/webview/l/c:XuL	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   171: astore_3
      //   172: invokestatic 105	com/tencent/mm/plugin/webview/l/c:access$getTAG$cp	()Ljava/lang/String;
      //   175: ldc 151
      //   177: iload_1
      //   178: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   181: invokestatic 119	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   184: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   187: getstatic 71	com/tencent/mm/plugin/webview/l/c:XuL	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   190: astore_3
      //   191: invokestatic 128	com/tencent/mm/plugin/webview/l/c$b:iDn	()Lcom/tencent/mm/plugin/webview/l/c$b$b;
      //   194: getstatic 154	com/tencent/mm/plugin/webview/l/c$b$c:Xvo	Lcom/tencent/mm/plugin/webview/l/c$b$c;
      //   197: invokevirtual 140	com/tencent/mm/plugin/webview/l/c$b$b:a	(Lcom/tencent/mm/plugin/webview/l/c$b$c;)V
      //   200: getstatic 71	com/tencent/mm/plugin/webview/l/c:XuL	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   203: astore_3
      //   204: invokestatic 128	com/tencent/mm/plugin/webview/l/c$b:iDn	()Lcom/tencent/mm/plugin/webview/l/c$b$b;
      //   207: iload_1
      //   208: putfield 144	com/tencent/mm/plugin/webview/l/c$b$b:Xvk	I
      //   211: goto -67 -> 144
      //   214: astore_3
      //   215: getstatic 71	com/tencent/mm/plugin/webview/l/c:XuL	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   218: astore 4
      //   220: invokestatic 105	com/tencent/mm/plugin/webview/l/c:access$getTAG$cp	()Ljava/lang/String;
      //   223: ldc 156
      //   225: aload_3
      //   226: invokevirtual 159	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   229: invokestatic 119	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   232: invokestatic 162	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   235: new 164	com/tencent/mm/plugin/webview/l/i
      //   238: dup
      //   239: invokespecial 165	com/tencent/mm/plugin/webview/l/i:<init>	()V
      //   242: getstatic 171	com/tencent/mm/plugin/webview/l/b:XuH	Lcom/tencent/mm/plugin/webview/l/b;
      //   245: invokevirtual 174	com/tencent/mm/plugin/webview/l/i:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
      //   248: goto -37 -> 211
      // Local variable table:
      //   start	length	slot	name	signature
      //   48	117	0	i	int
      //   34	174	1	j	int
      //   17	145	2	localObject1	Object
      //   26	178	3	localObject2	Object
      //   214	12	3	localException	Exception
      //   81	138	4	localb	c.b
      // Exception table:
      //   from	to	target	type
      //   23	47	214	java/lang/Exception
      //   53	91	214	java/lang/Exception
      //   96	142	214	java/lang/Exception
      //   168	211	214	java/lang/Exception
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<String>
  {
    public static final j XvC;
    
    static
    {
      AppMethodBeat.i(82818);
      XvC = new j();
      AppMethodBeat.o(82818);
    }
    
    j()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "retCode", "", "webComptName", "", "errMsg", "(ILjava/lang/String;Ljava/lang/String;)V", "toJsonString", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    extends Exception
  {
    final String XvD;
    final String errMsg;
    final int retCode;
    
    public k(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(82842);
      this.retCode = paramInt;
      this.XvD = paramString1;
      this.errMsg = paramString2;
      AppMethodBeat.o(82842);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$PerformanceSteps;", "", "stepName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStepName", "()Ljava/lang/String;", "STEP_CREATE_JS_CXT", "STEP_EVAL_MAIN_FRAME", "STEP_GET_A8KEY", "STEP_FETCH_WORKER", "STEP_GET_APP_SCRIPT", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static enum l
  {
    final String sUP;
    
    static
    {
      AppMethodBeat.i(82843);
      XvE = new l("STEP_CREATE_JS_CXT", 0, "createJsContext");
      XvF = new l("STEP_EVAL_MAIN_FRAME", 1, "evalMainFrame");
      XvG = new l("STEP_GET_A8KEY", 2, "GetA8Key");
      XvH = new l("STEP_FETCH_WORKER", 3, "FetchWorker");
      XvI = new l("STEP_GET_APP_SCRIPT", 4, "GetAppScript");
      XvJ = new l[] { XvE, XvF, XvG, XvH, XvI };
      AppMethodBeat.o(82843);
    }
    
    private l(String paramString)
    {
      this.sUP = paramString;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager$WebComptWorker;", "Lkotlin/collections/HashMap;", "()V", "id", "", "getId", "()I", "preloadDebugger", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "preloadId", "recycleWorkers", "fetch", "appId", "webComptInfo", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "webCompt", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "preload", "", "recycle", "reporter", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "WebComptWorker", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class m
    extends HashMap<String, a>
  {
    int XvK;
    c.b.f XvL;
    final HashMap<String, a> XvM;
    final int id;
    
    public m()
    {
      AppMethodBeat.i(82849);
      this.id = ((int)(System.currentTimeMillis() % 1000L));
      this.XvK = -1;
      this.XvL = new c.b.f(this.id, true, false, 4);
      this.XvM = new HashMap();
      AppMethodBeat.o(82849);
    }
    
    public final a a(String paramString, ddx paramddx, c paramc)
    {
      boolean bool = false;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(295509);
          kotlin.g.b.s.u(paramString, "appId");
          kotlin.g.b.s.u(paramddx, "webComptInfo");
          kotlin.g.b.s.u(paramc, "webCompt");
          String str = paramddx.name;
          if (this.XvM.containsKey(str))
          {
            localObject = (a)this.XvM.get(str);
            if ((localObject != null) && (kotlin.g.b.s.p(((a)localObject).appId, paramString)))
            {
              this.XvM.remove(str);
              paramString = (Map)this;
              kotlin.g.b.s.s(str, "webComptName");
              paramString.put(str, localObject);
              paramString = c.XuL;
              c.b.iDn().Xvh.add(new c.b.f(this.id, false, true, 2));
              AppMethodBeat.o(295509);
              paramString = (String)localObject;
              return paramString;
            }
          }
          if (this.XvK != -1) {
            bool = true;
          }
          if (bool == true)
          {
            paramString = c.XuL;
            Log.i(c.access$getTAG$cp(), kotlin.g.b.s.X("use preload workerManager#", Integer.valueOf(this.id)));
            paramString = this.XvL;
            localObject = c.XuL;
            c.b.iDn().Xvh.add(paramString);
            localObject = c.XuL;
            c.b.iDn().rsE = bool;
            if (bool == true)
            {
              i = this.XvK;
              paramString = new a(i, paramddx, paramc);
              this.XvK = -1;
              paramddx = (Map)this;
              kotlin.g.b.s.s(str, "webComptName");
              paramddx.put(str, paramString);
              AppMethodBeat.o(295509);
            }
          }
          else
          {
            paramString = c.XuL;
            Log.i(c.access$getTAG$cp(), kotlin.g.b.s.X("create new workerManager#", Integer.valueOf(this.id)));
            paramString = new c.b.f(this.id, false, false, 4);
            continue;
          }
          localObject = c.XuL;
        }
        finally {}
        Object localObject = c.b.iDo();
        c.b localb = c.XuL;
        int i = ((c.e.1)localObject).create(c.b.g("/wxwebcompt.js", paramString.Xvi));
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager$WebComptWorker;", "", "workerId", "", "webComptInfo", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "webCompt", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;ILcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;)V", "a8KeyUrl", "", "getA8KeyUrl", "()Ljava/lang/String;", "setA8KeyUrl", "(Ljava/lang/String;)V", "appId", "getAppId", "setAppId", "appScriptMD5", "getAppScriptMD5", "setAppScriptMD5", "appScriptUrl", "getAppScriptUrl", "setAppScriptUrl", "engine", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "getEngine", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "isRecycled", "", "()Z", "setRecycled", "(Z)V", "jsapi", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "getJsapi", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "setJsapi", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;)V", "launched", "getLaunched", "setLaunched", "performanceHelper", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "getPerformanceHelper", "()Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "setPerformanceHelper", "(Lcom/tencent/mm/pluginsdk/PerformanceHelper;)V", "refer", "getRefer", "setRefer", "used", "getUsed", "setUsed", "getWebCompt", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "getWebComptInfo", "()Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "getWorkerId", "()I", "recycle", "", "reuse", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public final class a
    {
      final int XvN;
      final ddx XvO;
      final c XvP;
      boolean XvQ;
      String XvR;
      String XvS;
      String XvT;
      com.tencent.mm.pluginsdk.s XvU;
      h XvV;
      boolean Xvs;
      String appId;
      boolean bgt;
      String vTt;
      
      public a(ddx paramddx, c paramc)
      {
        AppMethodBeat.i(82848);
        this.XvN = paramddx;
        this.XvO = paramc;
        this.XvP = localObject;
        this.appId = "";
        this.vTt = "";
        this.XvR = "";
        this.XvS = "";
        this.XvT = "";
        this$1 = this.XvP;
        paramc = this.XvO.name;
        kotlin.g.b.s.s(paramc, "webComptInfo.name");
        this.XvV = new h(c.m.this, paramc);
        iDs().addJavascriptInterface(this.XvV, "__webcompt");
        AppMethodBeat.o(82848);
      }
      
      public final void bni(String paramString)
      {
        AppMethodBeat.i(82846);
        kotlin.g.b.s.u(paramString, "<set-?>");
        this.XvS = paramString;
        AppMethodBeat.o(82846);
      }
      
      public final com.tencent.mm.plugin.appbrand.n.g iDs()
      {
        AppMethodBeat.i(295472);
        Object localObject = c.XuL;
        localObject = c.b.iDo().BK(this.XvN);
        kotlin.g.b.s.s(localObject, "manager.getJsContext(workerId)");
        AppMethodBeat.o(295472);
        return localObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class o
    extends kotlin.d.a
    implements CoroutineExceptionHandler
  {
    public o(CoroutineExceptionHandler.a parama, c paramc, ah.f paramf)
    {
      super();
      AppMethodBeat.i(295503);
      AppMethodBeat.o(295503);
    }
    
    public final void handleException(kotlin.d.f paramf, Throwable paramThrowable)
    {
      AppMethodBeat.i(82863);
      this.XvX.XuN.a(b.Xul);
      if ((paramThrowable instanceof c.k))
      {
        ((kotlin.g.a.b)this.XvY.aqH).invoke(paramThrowable);
        AppMethodBeat.o(82863);
        return;
      }
      AppMethodBeat.o(82863);
      throw paramThrowable;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    Object Uf;
    Object VC;
    Object VD;
    Object Ze;
    Object aqc;
    int label;
    
    p(boolean paramBoolean, c paramc, com.tencent.mm.pluginsdk.s params, ddx paramddx, String paramString1, String paramString2, String paramString3, ah.f<kotlin.g.a.b<c.k, kotlin.ah>> paramf, kotlin.d.d<? super p> paramd)
    {
      super(paramd);
    }
    
    private static final void a(String paramString1, c paramc, String paramString2, String paramString3)
    {
      AppMethodBeat.i(295532);
      c.b localb = c.XuL;
      Log.e(c.access$getTAG$cp(), "engine " + paramString1 + " exception: " + paramString2 + " \nstackTrace:\n" + paramString3);
      kotlin.g.b.s.s(paramString1, "name");
      kotlin.g.b.s.s(paramString2, "message");
      c.a(paramc, paramString1, paramString2, paramString3);
      paramc.XuN.a(b.Xuw);
      AppMethodBeat.o(295532);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(82875);
      paramd = new p(this.XvZ, this.XvX, this.Xwa, this.Xwb, this.aCx, this.eug, this.mrs, this.Xwc, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(82875);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(82874);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject7;
      Object localObject2;
      Object localObject4;
      Object localObject3;
      label420:
      label471:
      Object localObject6;
      Object localObject5;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(82874);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject1 = (aq)this.L$0;
        paramObject = c.XuL;
        paramObject = (kotlin.d.d)this;
        this.L$0 = localObject1;
        this.label = 1;
        if (c.b.ar(paramObject) == locala)
        {
          AppMethodBeat.o(82874);
          return locala;
        }
      case 1: 
        localObject1 = (aq)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        if (this.XvZ) {
          c.a(this.XvX, this.Xwa);
        }
        localObject7 = new com.tencent.mm.ad.i();
        paramObject = this.mrs;
        localObject2 = f.Xwq;
        if (f.a.getDebug())
        {
          paramObject = ((Iterable)n.a((CharSequence)n.rw(paramObject, "#"), new String[] { "&" })).iterator();
          while (paramObject.hasNext())
          {
            localObject2 = n.a((CharSequence)paramObject.next(), new String[] { "=" });
            if (((List)localObject2).size() == 2) {
              try
              {
                ((com.tencent.mm.ad.i)localObject7).m((String)((List)localObject2).get(0), URLDecoder.decode((String)((List)localObject2).get(1), "UTF-8"));
              }
              catch (Exception localException)
              {
                localObject4 = c.XuL;
                Log.e(c.access$getTAG$cp(), "parse paramsObject '" + (String)((List)localObject2).get(0) + "' exception: " + localException);
              }
            }
          }
        }
        localObject2 = this.aCx;
        localObject3 = this.eug;
        localObject4 = this.mrs;
        paramObject = f.Xwq;
        final com.tencent.mm.pluginsdk.s locals;
        final ddx localddx;
        final ah.f localf;
        if (f.a.getDebug())
        {
          paramObject = f.Xwq;
          paramObject = g.cTb().getString("debugA8Key", "");
          kotlin.g.b.s.checkNotNull(paramObject);
          kotlin.g.b.s.s(paramObject, "kvCommand.getString(\"debugA8Key\", \"\")!!");
          if (!n.bp((CharSequence)paramObject))
          {
            i = 1;
            if (i == 0) {
              break label767;
            }
            paramObject = new r(paramObject, c.b.a.Xvf);
            if (paramObject == null) {
              break label805;
            }
            localObject2 = (String)paramObject.bsC;
            paramObject = (c.b.a)paramObject.bsD;
            localObject3 = c.XuL;
            c.b.iDn().Xvi.add(new c.b.d((String)localObject2, null, paramObject, 2));
            paramObject = localObject2;
            localObject2 = c.XuL;
            Log.d(c.access$getTAG$cp(), kotlin.g.b.s.X("createJsContext a8key:", paramObject));
            c.b(this.Xwa, c.l.XvE);
            localObject2 = c.XuL;
            Log.i(c.access$getTAG$cp(), kotlin.g.b.s.X("createJsContext init ", this.aCx));
            c.c(this.Xwa, c.l.XvH);
            localObject6 = c.a(this.XvX).a(this.eug, this.Xwb, this.XvX);
            localObject4 = this.XvX;
            locals = this.Xwa;
            localObject5 = this.mrs;
            localObject2 = this.eug;
            localddx = this.Xwb;
            localf = this.Xwc;
            localObject3 = this.aCx;
            c.b(locals, c.l.XvH);
            kotlin.g.b.s.u(localObject5, "<set-?>");
            ((c.m.a)localObject6).vTt = ((String)localObject5);
            ((c.m.a)localObject6).XvU = locals;
            kotlin.g.b.s.u(localObject2, "appId");
            if ((!((c.m.a)localObject6).Xvs) || (!kotlin.g.b.s.p(((c.m.a)localObject6).appId, localObject2))) {
              break label862;
            }
            ((c.m.a)localObject6).Xvs = false;
            localObject5 = c.XuL;
            Log.i(c.access$getTAG$cp(), "WebComptWorker.reuse " + (String)localObject2 + '@' + ((c.m.a)localObject6).XvO.name + ':' + ((c.m.a)localObject6).XvN);
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label867;
          }
          c.b(((c.m.a)localObject6).iDs(), localddx, locals.XNW);
          ((c)localObject4).XuN.a(b.XuJ);
          paramObject = kotlin.ah.aiuX;
          AppMethodBeat.o(82874);
          return paramObject;
          i = 0;
          break;
          if (((com.tencent.mm.ad.i)localObject7).has("debugA8Key"))
          {
            paramObject = new r(((com.tencent.mm.ad.i)localObject7).getString("debugA8Key"), c.b.a.Xvc);
            break label420;
          }
          paramObject = null;
          break label420;
          paramObject = new StringBuilder();
          localObject5 = c.XuL;
          paramObject = c.iDd() + localObject2 + "?appId=" + (String)localObject3 + "&src=" + a.bne((String)localObject4);
          break label471;
        }
        kotlin.g.b.s.u(localObject2, "<set-?>");
        ((c.m.a)localObject6).appId = ((String)localObject2);
        kotlin.g.b.s.u(paramObject, "<set-?>");
        ((c.m.a)localObject6).XvR = paramObject;
        localObject2 = localddx.md5;
        kotlin.g.b.s.s(localObject2, "webCompt.md5");
        kotlin.g.b.s.u(localObject2, "<set-?>");
        ((c.m.a)localObject6).XvT = ((String)localObject2);
        localObject2 = localddx.url;
        kotlin.g.b.s.s(localObject2, "webCompt.url");
        ((c.m.a)localObject6).bni((String)localObject2);
        localObject2 = ((c.m.a)localObject6).iDs();
        ((com.tencent.mm.plugin.appbrand.n.g)localObject2).setJsExceptionHandler(new c.p..ExternalSyntheticLambda0((String)localObject3, (c)localObject4));
        localf.aqH = new a((c)localObject4, (com.tencent.mm.plugin.appbrand.n.g)localObject2);
        c.a((com.tencent.mm.plugin.appbrand.n.g)localObject2, localddx, locals.XNW);
        localObject5 = kotlinx.coroutines.j.a((aq)localObject1, ((aq)localObject1).getCoroutineContext(), (kotlin.g.a.m)new b((c)localObject4, locals, paramObject, localddx, null), 2);
        paramObject = kotlinx.coroutines.j.a((aq)localObject1, ((aq)localObject1).getCoroutineContext(), (kotlin.g.a.m)new c((c)localObject4, locals, (com.tencent.mm.ad.i)localObject7, localddx, localf, (com.tencent.mm.plugin.appbrand.n.g)localObject2, null), 2);
        this.L$0 = localObject4;
        this.Uf = localObject3;
        this.VC = localObject6;
        this.VD = localObject2;
        this.Ze = localObject2;
        this.aqc = localObject5;
        this.label = 2;
        localObject7 = paramObject.e(this);
        if (localObject7 == locala)
        {
          AppMethodBeat.o(82874);
          return locala;
        }
        break;
      case 2: 
        label767:
        localObject5 = (ay)this.aqc;
        label805:
        label862:
        label867:
        localObject6 = (com.tencent.mm.plugin.appbrand.n.g)this.Ze;
        localObject4 = (com.tencent.mm.plugin.appbrand.n.g)this.VD;
        localObject7 = (c.m.a)this.VC;
        localObject3 = (String)this.Uf;
        localObject1 = (c)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject2 = paramObject;
        paramObject = localObject6;
        localObject6 = localObject2;
        localObject2 = localObject7;
      }
      for (;;)
      {
        localObject7 = (r)localObject6;
        localObject6 = (String)((r)localObject7).bsC;
        localObject7 = (String)((r)localObject7).bsD;
        ((c.m.a)localObject2).bni((String)localObject6);
        c.d(paramObject, "(function(WeixinWebCompt){" + (String)localObject7 + "})(WeixinWebCompt);");
        this.L$0 = localObject1;
        this.Uf = localObject3;
        this.VC = localObject2;
        this.VD = localObject4;
        this.Ze = paramObject;
        this.aqc = null;
        this.label = 3;
        localObject7 = ((ay)localObject5).e(this);
        if (localObject7 == locala)
        {
          AppMethodBeat.o(82874);
          return locala;
          localObject5 = (com.tencent.mm.plugin.appbrand.n.g)this.Ze;
          localObject3 = (com.tencent.mm.plugin.appbrand.n.g)this.VD;
          localObject4 = (c.m.a)this.VC;
          localObject2 = (String)this.Uf;
          localObject1 = (c)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject6 = paramObject;
        }
        for (;;)
        {
          paramObject = (c.a)localObject6;
          localObject6 = ((c.m.a)localObject4).XvV;
          localObject7 = paramObject.XuZ.blb(paramObject.sMq);
          kotlin.g.b.s.checkNotNull(localObject7);
          kotlin.g.b.s.u(localObject7, "<set-?>");
          ((h)localObject6).WlV = ((JsapiPermissionWrapper)localObject7);
          c.a((c)localObject1, (com.tencent.mm.plugin.appbrand.n.g)localObject5, paramObject);
          ((c.m.a)localObject4).XvQ = true;
          this.L$0 = localObject1;
          this.Uf = localObject2;
          this.VC = localObject3;
          this.VD = null;
          this.Ze = null;
          this.label = 4;
          if (bb.e(1000L, this) == locala)
          {
            AppMethodBeat.o(82874);
            return locala;
            localObject2 = (String)this.Uf;
            localObject1 = (c)this.L$0;
            ResultKt.throwOnFailure(paramObject);
          }
          paramObject = c.XuL;
          c.b.Jg(true);
          ((c)localObject1).XuN.a(b.Xuo);
          paramObject = c.XuL;
          Log.d(c.access$getTAG$cp(), kotlin.g.b.s.X("createJsContext init finish ", localObject2));
          paramObject = c.XuL;
          if (c.b.iDn().rsE) {
            ((c)localObject1).XuN.a(b.Xup);
          }
          paramObject = kotlin.ah.aiuX;
          AppMethodBeat.o(82874);
          return paramObject;
          localObject6 = localObject4;
          localObject4 = localObject3;
          localObject5 = localObject2;
          localObject3 = localObject6;
          localObject6 = localObject7;
          localObject2 = localObject4;
          localObject4 = localObject5;
          localObject5 = paramObject;
        }
        localObject1 = localObject4;
        localObject4 = localObject2;
        paramObject = localObject2;
        localObject2 = localObject6;
        localObject6 = localObject7;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "ex", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.b<c.k, kotlin.ah>
    {
      a(c paramc, com.tencent.mm.plugin.appbrand.n.g paramg)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.d.b.a.k
      implements kotlin.g.a.m<aq, kotlin.d.d<? super c.a>, Object>
    {
      int label;
      
      b(c paramc, com.tencent.mm.pluginsdk.s params, String paramString, ddx paramddx, kotlin.d.d<? super b> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(295520);
        paramObject = (kotlin.d.d)new b(this.XvX, locals, paramObject, localddx, paramd);
        AppMethodBeat.o(295520);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(295516);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(295516);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          c.c(locals, c.l.XvG);
          paramObject = this.XvX;
          Object localObject = paramObject;
          String str = localddx.name;
          kotlin.g.b.s.s(str, "webCompt.name");
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          localObject = c.a(paramObject, (String)localObject, str, locald);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(295516);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        c.b(locals, c.l.XvG);
        AppMethodBeat.o(295516);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends kotlin.d.b.a.k
      implements kotlin.g.a.m<aq, kotlin.d.d<? super r<? extends String, ? extends String>>, Object>
    {
      Object L$0;
      Object Uf;
      Object VC;
      Object VD;
      Object Ze;
      int label;
      
      c(c paramc, com.tencent.mm.pluginsdk.s params, com.tencent.mm.ad.i parami, ddx paramddx, ah.f<kotlin.g.a.b<c.k, kotlin.ah>> paramf, com.tencent.mm.plugin.appbrand.n.g paramg, kotlin.d.d<? super c> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(295531);
        paramObject = (kotlin.d.d)new c(this.XvX, locals, this.Xwe, localddx, localf, this.SLf, paramd);
        AppMethodBeat.o(295531);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(295522);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(295522);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          c.c(locals, c.l.XvI);
          paramObject = this.XvX;
          Object localObject = this.Xwe;
          final ddx localddx = localddx;
          final ah.f localf = localf;
          final com.tencent.mm.plugin.appbrand.n.g localg = this.SLf;
          this.L$0 = paramObject;
          this.Uf = localObject;
          this.VC = localddx;
          this.VD = localf;
          this.Ze = localg;
          this.label = 1;
          kotlin.d.h localh = new kotlin.d.h(kotlin.d.a.b.au((kotlin.d.d)this));
          final kotlin.d.d locald = (kotlin.d.d)localh;
          c.b localb = c.XuL;
          com.tencent.mm.ae.d.d(c.access$getTAG$cp(), (kotlin.g.a.a)new a(paramObject, (com.tencent.mm.ad.i)localObject, localddx, locald, localf, localg));
          localObject = localh.kli();
          if (localObject == kotlin.d.a.a.aiwj) {
            kotlin.g.b.s.u((kotlin.d.d)this, "frame");
          }
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(295522);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        c.b(locals, c.l.XvI);
        AppMethodBeat.o(295522);
        return paramObject;
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends kotlin.g.b.u
        implements kotlin.g.a.a<kotlin.ah>
      {
        a(c paramc, com.tencent.mm.ad.i parami, ddx paramddx, kotlin.d.d<? super r<String, String>> paramd, ah.f<kotlin.g.a.b<c.k, kotlin.ah>> paramf, com.tencent.mm.plugin.appbrand.n.g paramg)
        {
          super();
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends kotlin.g.b.u
    implements kotlin.g.a.b<c.k, kotlin.ah>
  {
    public static final q Xwf;
    
    static
    {
      AppMethodBeat.i(82878);
      Xwf = new q();
      AppMethodBeat.o(82878);
    }
    
    q()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    r(c paramc, String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, kotlin.ah>
  {
    public static final s Xwh;
    
    static
    {
      AppMethodBeat.i(82881);
      Xwh = new s();
      AppMethodBeat.o(82881);
    }
    
    s()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    t(c paramc, String paramString, kotlin.g.a.b<? super String, kotlin.ah> paramb)
    {
      super();
    }
    
    private static final void b(kotlin.g.a.b paramb, String paramString)
    {
      AppMethodBeat.i(295499);
      kotlin.g.b.s.u(paramb, "$callback");
      kotlin.g.b.s.s(paramString, "it");
      paramb.invoke(paramString);
      AppMethodBeat.o(295499);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/webcompt/WebComponent$getA8Key$2$1$1", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthStart", "onContentRedirect", "content", "onError", "errType", "errCode", "errMsg", "onPermissionUpdate", "fullUrl", "response", "onProcessResult", "", "onUrlRedirect", "forceRedirect", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class u
    implements com.tencent.mm.plugin.webview.e.a<cdf>
  {
    u(kotlin.d.d<? super c.a> paramd, com.tencent.mm.plugin.webview.e.c paramc, c paramc1, String paramString) {}
    
    public final void J(int paramInt, String paramString1, String paramString2) {}
    
    public final void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
    {
      AppMethodBeat.i(295526);
      kotlin.g.b.s.u(paramString1, "reqUrl");
      kotlin.g.b.s.u(paramString2, "errMsg");
      paramString1 = this.ntL;
      paramString2 = (Throwable)new c.k(20001, paramString2, "getA8Key error:" + paramInt2 + ", " + paramInt3 + ", " + paramString2);
      Result.Companion localCompanion = Result.Companion;
      paramString1.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramString2)));
      jdField_this.XuN.a(b.Xus);
      AppMethodBeat.o(295526);
    }
    
    public final void ca(int paramInt, String paramString)
    {
      AppMethodBeat.i(295507);
      kotlin.g.b.s.u(paramString, "reqUrl");
      AppMethodBeat.o(295507);
    }
    
    public final void cb(int paramInt, String paramString)
    {
      AppMethodBeat.i(295505);
      kotlin.g.b.s.u(paramString, "reqUrl");
      AppMethodBeat.o(295505);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Byte, CharSequence>
  {
    public static final v Xwk;
    
    static
    {
      AppMethodBeat.i(295486);
      Xwk = new v();
      AppMethodBeat.o(295486);
    }
    
    v()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, kotlin.ah>
  {
    w(c paramc, com.tencent.mm.pluginsdk.s params)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class x
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    x(c paramc, c.m.a parama, kotlin.g.a.b<? super String, kotlin.ah> paramb, kotlin.g.a.b<? super c.k, kotlin.ah> paramb1, kotlin.d.d<? super x> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(295497);
      paramObject = (kotlin.d.d)new x(this.XvX, this.Xwl, this.Xwm, this.Xwn, paramd);
      AppMethodBeat.o(295497);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(295493);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(295493);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        paramObject = this.XvX;
        Object localObject = this.Xwl.XvR;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        paramObject = c.a(paramObject, (String)localObject, locald);
        localObject = paramObject;
        if (paramObject == locala)
        {
          AppMethodBeat.o(295493);
          return locala;
          ResultKt.throwOnFailure(paramObject);
          localObject = paramObject;
        }
        paramObject = (c.a)localObject;
        this.Xwm.invoke(c.a(this.XvX, paramObject));
      }
      catch (c.k paramObject)
      {
        for (;;)
        {
          this.Xwn.invoke(paramObject);
        }
      }
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(295493);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class y
    extends kotlin.g.b.u
    implements kotlin.g.a.a<c.m>
  {
    y(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.c
 * JD-Core Version:    0.7.0.1
 */