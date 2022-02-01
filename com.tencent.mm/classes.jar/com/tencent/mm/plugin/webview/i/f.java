package com.tencent.mm.plugin.webview.i;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.j;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.aa.e;
import kotlin.g.b.p;
import kotlin.o;
import kotlin.s;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/reporter/WebViewPerformanceReporter;", "", "()V", "REPORT_ID", "", "REPORT_ID_SCENE_ALL", "REPORT_ID_SCENE_CHAT", "REPORT_ID_SCENE_MENU", "REPORT_ID_SCENE_OTHER", "REPORT_ID_SCENE_READER_COMMON", "REPORT_ID_SCENE_READER_TOP", "REPORT_ID_SCENE_SNS", "WebPrefecher", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "getWebPrefecher", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "WebPrefecher$delegate", "Lkotlin/Lazy;", "doPrintPagePerformence", "", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "webView", "Lcom/tencent/xweb/WebView;", "reportByScene", "key", "value", "scene", "", "reportCommonWebViewPerformance", "reportGetA8KeyLiteCount", "count", "reportHTTP200", "reportHTTP304", "reportHTTPOther", "reportInvokerCreate", "reportInvokerEnablePool", "reportInvokerReuse", "reportIsCssCached", "reportIsCssCachedByScene", "reportIsJsCached", "reportIsJsCachedByScene", "reportIsPageCached", "reportIsPageCachedByScene", "reportNonPrefeth", "reportPerformance", "reportPreDns", "reportPreGetA8Key", "reportPrefetchExpire", "reportPrefeth", "reportWebPrefetchCTR", "url", "", "isExposure", "", "isClick", "preGetA8Key", "preDns", "prefetch", "classifyUin", "reportWebView", "webview-sdk_release"})
public final class f
{
  private static final kotlin.f PZT;
  public static final f PZU;
  
  static
  {
    AppMethodBeat.i(82530);
    PZU = new f();
    PZT = g.ar((a)a.PZV);
    AppMethodBeat.o(82530);
  }
  
  public static final void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    int i = 1;
    AppMethodBeat.i(160474);
    p.k(paramString, "url");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt).append(",");
    localStringBuilder.append(com.tencent.mm.compatible.util.q.an(paramString, "utf-8")).append(",");
    String str2 = ((com.tencent.mm.plugin.brandservice.a.f)PZT.getValue()).aps(paramString);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localStringBuilder.append(str1).append(",");
    if (paramBoolean1)
    {
      paramInt = 1;
      localStringBuilder.append(paramInt).append(",");
      if (!paramBoolean2) {
        break label264;
      }
      paramInt = 1;
      label121:
      localStringBuilder.append(paramInt).append(",");
      paramString = Uri.parse(paramString);
      p.j(paramString, "Uri.parse(url)");
      localStringBuilder.append(paramString.getHost()).append(",");
      if (!paramBoolean3) {
        break label269;
      }
      paramInt = 1;
      label166:
      localStringBuilder.append(paramInt).append(",");
      if (!paramBoolean4) {
        break label274;
      }
      paramInt = 1;
      label185:
      localStringBuilder.append(paramInt).append(",");
      if (!paramBoolean5) {
        break label279;
      }
      paramInt = 1;
      label204:
      localStringBuilder.append(paramInt).append(",");
      if (!paramBoolean6) {
        break label284;
      }
    }
    label264:
    label269:
    label274:
    label279:
    label284:
    for (paramInt = i;; paramInt = 0)
    {
      localStringBuilder.append(paramInt);
      paramString = localStringBuilder.toString();
      h.IzE.kvStat(18919, paramString);
      Log.v("ReportWebPrefetchCTR", paramString);
      AppMethodBeat.o(160474);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label121;
      paramInt = 0;
      break label166;
      paramInt = 0;
      break label185;
      paramInt = 0;
      break label204;
    }
  }
  
  public static final void a(com.tencent.mm.plugin.webview.k.n paramn, int paramInt)
  {
    AppMethodBeat.i(175658);
    p.k(paramn, "performanceHelper");
    if (paramn.PZc) {
      k(1L, 1L, paramInt);
    }
    AppMethodBeat.o(175658);
  }
  
  public static final void a(com.tencent.mm.plugin.webview.k.n paramn, final WebView paramWebView)
  {
    AppMethodBeat.i(82529);
    p.k(paramn, "performanceHelper");
    p.k(paramWebView, "webView");
    boolean bool1 = paramn.PZc;
    boolean bool2 = paramn.PZd;
    paramWebView = h.IzE;
    if (bool1) {
      paramWebView.p(1200L, 2L, 1L);
    }
    if (bool2) {
      paramWebView.p(1200L, 3L, 1L);
    }
    paramWebView = new aa.e();
    paramWebView.aaBB = paramn.QAx;
    Object localObject1 = e.PZZ;
    paramWebView = new f(paramn, paramWebView);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramWebView.blI("onCreate")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.blI("onUIInitEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.blI("onWebViewCreateStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.blI("onWebViewCreateEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.blI("getA8KeyStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.blI("getA8KeyEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.blI("onTryBindServiceStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.blI("onPostBindedEnd")).append(",");
    ((StringBuilder)localObject1).append("0,0,");
    ((StringBuilder)localObject1).append(paramWebView.blI("navigationStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.blI("domLoading")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.blI("domainLookupStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.blI("domainLookupEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.blI("navigationStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.blI("firstContentfulPaint")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.blI("domContentLoadedEventStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.blI("loadEventStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.blI("onPageStarted")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.blI("onPageCommit")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.blI("onPageFinished"));
    paramWebView = ((StringBuilder)localObject1).toString();
    p.j(paramWebView, "StringBuilder().apply {\n…())\n\n        }.toString()");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(com.tencent.mm.compatible.util.q.an(paramn.POG, "utf-8")).append(",");
    Object localObject2 = Uri.parse(paramn.POG);
    p.j(localObject2, "Uri.parse(performanceHelper.initUrl)");
    ((StringBuilder)localObject1).append(((Uri)localObject2).getHost()).append(",");
    localObject2 = e.PZZ;
    ((StringBuilder)localObject1).append(e.Db(paramn.PZc)).append(",");
    localObject2 = e.PZZ;
    ((StringBuilder)localObject1).append(e.Db(paramn.PZd)).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    localObject2 = e.PZZ;
    ((StringBuilder)localObject1).append(e.Db(paramn.PZb)).append(",");
    ((StringBuilder)localObject1).append(paramn.QAu.size() + paramn.QAv.size()).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    ((StringBuilder)localObject1).append(paramWebView);
    localObject1 = ((StringBuilder)localObject1).toString();
    h.IzE.kvStat(18497, (String)localObject1);
    Log.v("MicroMsg.WebViewPerformanceReporter", "webview performance:\n".concat(String.valueOf(paramWebView)));
    a(paramn.Qfr, paramn.POG, false, true, paramn.PZc, paramn.PZd, paramn.PZb, 128);
    AppMethodBeat.o(82529);
  }
  
  public static final void aod(int paramInt)
  {
    AppMethodBeat.i(82521);
    h.IzE.p(1200L, 0L, paramInt);
    AppMethodBeat.o(82521);
  }
  
  public static final void aoe(int paramInt)
  {
    AppMethodBeat.i(82522);
    h.IzE.p(1200L, 1L, paramInt);
    AppMethodBeat.o(82522);
  }
  
  public static final void aof(int paramInt)
  {
    AppMethodBeat.i(175661);
    k(7L, 1L, paramInt);
    AppMethodBeat.o(175661);
  }
  
  public static final void aog(int paramInt)
  {
    AppMethodBeat.i(175664);
    k(10L, 1L, paramInt);
    AppMethodBeat.o(175664);
  }
  
  public static final void aoh(int paramInt)
  {
    AppMethodBeat.i(205186);
    k(3L, 1L, paramInt);
    AppMethodBeat.o(205186);
  }
  
  public static final void aoi(int paramInt)
  {
    AppMethodBeat.i(205187);
    k(4L, 1L, paramInt);
    AppMethodBeat.o(205187);
  }
  
  public static final void aoj(int paramInt)
  {
    AppMethodBeat.i(205189);
    k(5L, 1L, paramInt);
    AppMethodBeat.o(205189);
  }
  
  public static final void b(com.tencent.mm.plugin.webview.k.n paramn, WebView paramWebView)
  {
    int m = 4;
    int n = 2;
    int i1 = 1;
    AppMethodBeat.i(182649);
    p.k(paramn, "performanceHelper");
    p.k(paramWebView, "webView");
    Object localObject1 = c.PZX;
    localObject1 = new aa.e();
    ((aa.e)localObject1).aaBB = paramn.QAx;
    d locald = new d(paramn, (aa.e)localObject1);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2 = Uri.parse(paramn.POG);
    p.j(localObject2, "Uri.parse(performanceHelper.initUrl)");
    localStringBuilder.append(((Uri)localObject2).getHost()).append(",");
    localStringBuilder.append(com.tencent.mm.compatible.util.q.an(paramn.POG, "utf-8")).append(",");
    int i;
    int j;
    label142:
    int k;
    if (paramn.QAr)
    {
      i = 1;
      if (!paramn.PZc) {
        break label714;
      }
      j = 2;
      if (!paramn.QAt) {
        break label719;
      }
      k = 4;
      label152:
      localStringBuilder.append(i | j | k).append(",");
      if (!paramn.PZb) {
        break label725;
      }
      i = i1;
      label179:
      if (paramn.QAu.size() <= 0) {
        break label730;
      }
      j = n;
      label192:
      if (paramn.QAv.size() <= 0) {
        break label735;
      }
      k = m;
      label206:
      localStringBuilder.append(i | j | k).append(",");
      localObject2 = c.PZX;
      localStringBuilder.append(c.Db(paramn.PZd)).append(",");
      localStringBuilder.append(paramn.Qfr).append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(0).append(",");
      localStringBuilder.append(locald.invoke("pageAppear"));
      localStringBuilder.append(locald.invoke("onWebViewCreateStart"));
      localStringBuilder.append(locald.invoke("onWebViewCreateEnd"));
      localStringBuilder.append(locald.invoke("getA8KeyStart"));
      localStringBuilder.append(locald.invoke("getA8KeyEnd"));
      localStringBuilder.append(locald.invoke("clientLoadUrl"));
      localStringBuilder.append(locald.invoke("navigationStart"));
      localStringBuilder.append(locald.invoke("domainLookupStart"));
      localStringBuilder.append(locald.invoke("domainLookupEnd"));
      localStringBuilder.append(locald.invoke("connectStart"));
      localStringBuilder.append(locald.invoke("connectEnd"));
      localStringBuilder.append(locald.invoke("responseStart"));
      localStringBuilder.append(locald.invoke("responseEnd"));
      if (!paramn.QAr) {
        break label741;
      }
    }
    label714:
    label719:
    label725:
    label730:
    label735:
    label741:
    for (localObject1 = paramn.QAs - ((aa.e)localObject1).aaBB + ',';; localObject1 = locald.invoke("domLoading"))
    {
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(locald.invoke("domInteractive"));
      localStringBuilder.append(locald.invoke("domContentLoadedEventStart"));
      localStringBuilder.append(locald.invoke("domContentLoadedEventEnd"));
      localStringBuilder.append(locald.invoke("loadEventStart"));
      localStringBuilder.append(locald.invoke("loadEventEnd"));
      localStringBuilder.append(locald.invoke("onTryBindServiceStart"));
      localStringBuilder.append(locald.invoke("onPostBindedEnd"));
      localStringBuilder.append(locald.invoke("onCreate"));
      localStringBuilder.append(locald.invoke("onUIInitEnd"));
      localObject1 = localStringBuilder.toString();
      p.j(localObject1, "StringBuilder().apply {\n…())\n\n        }.toString()");
      Log.i("WebViewPerformanceReporter", (String)localObject1);
      h.IzE.kvStat(19471, (String)localObject1);
      if (com.tencent.mm.plugin.webview.d.l.gUi()) {
        c(paramn, paramWebView);
      }
      AppMethodBeat.o(182649);
      return;
      i = 0;
      break;
      j = 0;
      break label142;
      k = 0;
      break label152;
      i = 0;
      break label179;
      j = 0;
      break label192;
      k = 0;
      break label206;
    }
  }
  
  private static void c(com.tencent.mm.plugin.webview.k.n paramn, WebView paramWebView)
  {
    AppMethodBeat.i(205193);
    final long l = paramn.QAx;
    Object localObject1 = (List)new ArrayList();
    Object localObject2 = new b(paramn, l);
    ((List)localObject1).add(Long.valueOf(0L));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).blI("pageAppear")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).blI("onWebViewCreateStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).blI("onWebViewCreateEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).blI("getA8KeyStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).blI("getA8KeyEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).blI("clientLoadUrl")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).blI("navigationStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).blI("domainLookupStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).blI("domainLookupEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).blI("connectStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).blI("connectEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).blI("responseStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).blI("responseEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).blI("domLoading")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).blI("domInteractive")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).blI("onTryBindServiceStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).blI("onPostBindedEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).blI("onCreate")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).blI("onUIInitEnd")));
    String str1 = "[" + j.a((Iterable)j.c((Iterable)localObject1, 20), null, null, null, 0, null, null, 63) + ']';
    localObject1 = paramn.QAq;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = (Object[])localObject1;
      localObject2 = (Collection)new ArrayList(localObject1.length);
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localObject3 = (String[])localObject1[i];
        ((Collection)localObject2).add(s.M(localObject3[0], localObject3[1]));
        i += 1;
      }
      localObject1 = ((Collection)localObject2).toArray(new o[0]);
      if (localObject1 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(205193);
        throw paramn;
      }
      localObject1 = (o[])localObject1;
      localObject3 = new kotlin.g.b.ae(10);
      ((kotlin.g.b.ae)localObject3).add(s.M("section", "GetA8Key"));
      ((kotlin.g.b.ae)localObject3).add(s.M("preGetA8Key", String.valueOf(paramn.PZc)));
      ((kotlin.g.b.ae)localObject3).add(s.M("preDns", String.valueOf(paramn.PZd)));
      if (localObject1 != null) {
        break label1059;
      }
      localObject1 = new o[0];
    }
    label1059:
    for (;;)
    {
      localObject2 = localObject3;
      ((kotlin.g.b.ae)localObject3).eZ(localObject1);
      ((kotlin.g.b.ae)localObject2).add(s.M("section", "Prefetch"));
      ((kotlin.g.b.ae)localObject2).add(s.M("prefetch", String.valueOf(paramn.PZb)));
      ((kotlin.g.b.ae)localObject2).add(s.M("prefetchJS", j.a((Iterable)paramn.QAu, (CharSequence)"<br/>", null, null, 0, null, null, 62)));
      ((kotlin.g.b.ae)localObject2).add(s.M("prefetchCSS", j.a((Iterable)paramn.QAv, (CharSequence)"<br/>", null, null, 0, null, null, 62)));
      ((kotlin.g.b.ae)localObject2).add(s.M("section", "Prefetch Headers"));
      localObject1 = (Map)paramn.QAw;
      paramn = (Map)new LinkedHashMap();
      localObject1 = ((Map)localObject1).entrySet().iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label975;
        }
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        String str2 = (String)((Map.Entry)localObject3).getKey();
        ((Map.Entry)localObject3).getValue();
        if (str2 == null)
        {
          paramn = new t("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(205193);
          throw paramn;
          localObject1 = null;
          break;
        }
        str2 = kotlin.n.n.bb((CharSequence)str2).toString();
        if (str2 == null)
        {
          paramn = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(205193);
          throw paramn;
        }
        str2 = str2.toLowerCase();
        p.j(str2, "(this as java.lang.String).toLowerCase()");
        if (kotlin.n.n.M(str2, "x-wx-", false)) {
          paramn.put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
        }
      }
      label975:
      paramn = ((Collection)kotlin.a.ae.cC(paramn)).toArray(new o[0]);
      if (paramn == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(205193);
        throw paramn;
      }
      ((kotlin.g.b.ae)localObject2).eZ(paramn);
      com.tencent.mm.plugin.webview.k.n.a("['PageAppear', 'WebView', 'GetA8key', 'ClientLoadToNavStart', 'DomainLookUp', 'ConnectStart', 'Response', 'DomLoadingToInteractive', 'Invoker', 'WebViewUICreate']", str1, paramWebView, j.listOf((o[])((kotlin.g.b.ae)localObject2).toArray(new o[((kotlin.g.b.ae)localObject2).fmA.size()])));
      AppMethodBeat.o(205193);
      return;
    }
  }
  
  public static final void gWO()
  {
    AppMethodBeat.i(82523);
    h.IzE.p(1200L, 10L, 1L);
    AppMethodBeat.o(82523);
  }
  
  public static final void gWP()
  {
    AppMethodBeat.i(82524);
    h.IzE.p(1200L, 11L, 1L);
    AppMethodBeat.o(82524);
  }
  
  public static final void gWQ()
  {
    AppMethodBeat.i(82525);
    h.IzE.p(1200L, 12L, 1L);
    AppMethodBeat.o(82525);
  }
  
  public static final void gWR()
  {
    AppMethodBeat.i(82526);
    h.IzE.p(1200L, 100L, 1L);
    AppMethodBeat.o(82526);
  }
  
  public static final void gWS()
  {
    AppMethodBeat.i(82527);
    h.IzE.p(1200L, 101L, 1L);
    AppMethodBeat.o(82527);
  }
  
  public static final void gWT()
  {
    AppMethodBeat.i(82528);
    h.IzE.p(1200L, 102L, 1L);
    AppMethodBeat.o(82528);
  }
  
  private static final void k(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(175668);
    h.IzE.p(1281L, paramLong1, paramLong2);
    switch (paramInt)
    {
    default: 
      h.IzE.p(1287L, paramLong1, paramLong2);
    }
    for (;;)
    {
      Log.v("MicroMsg.WebViewPerformanceReporter", "reportByScene scene = " + paramInt + ", key = " + paramLong1 + ", value = " + paramLong2);
      AppMethodBeat.o(175668);
      return;
      h.IzE.p(1283L, paramLong1, paramLong2);
      continue;
      h.IzE.p(1282L, paramLong1, paramLong2);
      continue;
      h.IzE.p(1284L, paramLong1, paramLong2);
      continue;
      h.IzE.p(1285L, paramLong1, paramLong2);
      continue;
      h.IzE.p(1286L, paramLong1, paramLong2);
    }
  }
  
  public static final void lA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175657);
    k(0L, paramInt1, paramInt2);
    AppMethodBeat.o(175657);
  }
  
  public static final void lB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175659);
    k(2L, paramInt1, paramInt2);
    AppMethodBeat.o(175659);
  }
  
  public static final void lC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175660);
    k(6L, paramInt1, paramInt2);
    AppMethodBeat.o(175660);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements a<com.tencent.mm.plugin.brandservice.a.f>
  {
    public static final a PZV;
    
    static
    {
      AppMethodBeat.i(206460);
      PZV = new a();
      AppMethodBeat.o(206460);
    }
    
    a()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"getRecord", "", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements b<String, Long>
  {
    b(com.tencent.mm.plugin.webview.k.n paramn, long paramLong)
    {
      super();
    }
    
    public final long blI(String paramString)
    {
      AppMethodBeat.i(213774);
      p.k(paramString, "$this$getRecord");
      long l = this.PZW.bV(paramString, l) - l;
      if (l > 0L)
      {
        AppMethodBeat.o(213774);
        return l;
      }
      AppMethodBeat.o(213774);
      return 0L;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"toInt", "", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements b<Boolean, Integer>
  {
    public static final c PZX;
    
    static
    {
      AppMethodBeat.i(182646);
      PZX = new c();
      AppMethodBeat.o(182646);
    }
    
    c()
    {
      super();
    }
    
    public static int Db(boolean paramBoolean)
    {
      if (paramBoolean) {
        return 1;
      }
      return 0;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"getRecord", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements b<String, String>
  {
    d(com.tencent.mm.plugin.webview.k.n paramn, aa.e parame)
    {
      super();
    }
    
    public final String invoke(String paramString)
    {
      AppMethodBeat.i(182648);
      p.k(paramString, "$this$getRecord");
      paramString = this.PZW.bV(paramString, this.PZY.aaBB) - this.PZY.aaBB + ',';
      AppMethodBeat.o(182648);
      return paramString;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"toInt", "", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements b<Boolean, Integer>
  {
    public static final e PZZ;
    
    static
    {
      AppMethodBeat.i(82518);
      PZZ = new e();
      AppMethodBeat.o(82518);
    }
    
    e()
    {
      super();
    }
    
    public static int Db(boolean paramBoolean)
    {
      if (paramBoolean) {
        return 1;
      }
      return 0;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"getRecord", "", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements b<String, Long>
  {
    f(com.tencent.mm.plugin.webview.k.n paramn, aa.e parame)
    {
      super();
    }
    
    public final long blI(String paramString)
    {
      AppMethodBeat.i(82520);
      p.k(paramString, "$this$getRecord");
      long l1 = this.PZW.bV(paramString, paramWebView.aaBB);
      long l2 = paramWebView.aaBB;
      AppMethodBeat.o(82520);
      return l1 - l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.i.f
 * JD-Core Version:    0.7.0.1
 */