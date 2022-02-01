package com.tencent.mm.plugin.webview.h;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.xweb.WebView;
import d.a.ae;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.v.e;
import d.g.b.w;
import d.g.b.y;
import d.n.n;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/reporter/WebViewPerformanceReporter;", "", "()V", "REPORT_ID", "", "REPORT_ID_SCENE_ALL", "REPORT_ID_SCENE_CHAT", "REPORT_ID_SCENE_MENU", "REPORT_ID_SCENE_OTHER", "REPORT_ID_SCENE_READER_COMMON", "REPORT_ID_SCENE_READER_TOP", "REPORT_ID_SCENE_SNS", "WebPrefecher", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "getWebPrefecher", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "WebPrefecher$delegate", "Lkotlin/Lazy;", "doPrintPagePerformence", "", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "webView", "Lcom/tencent/xweb/WebView;", "reportByScene", "key", "value", "scene", "", "reportCommonWebViewPerformance", "reportGetA8KeyLiteCount", "count", "reportHTTP200", "reportHTTP304", "reportHTTPOther", "reportInvokerCreate", "reportInvokerEnablePool", "reportInvokerReuse", "reportIsCssCached", "reportIsCssCachedByScene", "reportIsJsCached", "reportIsJsCachedByScene", "reportIsPageCached", "reportIsPageCachedByScene", "reportNonPrefeth", "reportPerformance", "reportPreDns", "reportPreGetA8Key", "reportPrefetchExpire", "reportPrefeth", "reportWebPrefetchCTR", "url", "", "isExposure", "", "isClick", "preGetA8Key", "preDns", "prefetch", "classifyUin", "reportWebView", "webview-sdk_release"})
public final class b
{
  private static final f Cuf;
  public static final b Cug;
  
  static
  {
    AppMethodBeat.i(82530);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(b.class), "WebPrefecher", "getWebPrefecher()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;")) };
    Cug = new b();
    Cuf = g.K((a)a.Cuh);
    AppMethodBeat.o(82530);
  }
  
  public static final void Vk(int paramInt)
  {
    AppMethodBeat.i(82521);
    com.tencent.mm.plugin.report.service.h.wUl.n(1200L, 0L, paramInt);
    AppMethodBeat.o(82521);
  }
  
  public static final void Vl(int paramInt)
  {
    AppMethodBeat.i(82522);
    com.tencent.mm.plugin.report.service.h.wUl.n(1200L, 1L, paramInt);
    AppMethodBeat.o(82522);
  }
  
  public static final void Vm(int paramInt)
  {
    AppMethodBeat.i(175661);
    j(7L, 1L, paramInt);
    AppMethodBeat.o(175661);
  }
  
  public static final void Vn(int paramInt)
  {
    AppMethodBeat.i(175664);
    j(10L, 1L, paramInt);
    AppMethodBeat.o(175664);
  }
  
  public static final void Vo(int paramInt)
  {
    AppMethodBeat.i(205582);
    j(3L, 1L, paramInt);
    AppMethodBeat.o(205582);
  }
  
  public static final void Vp(int paramInt)
  {
    AppMethodBeat.i(205583);
    j(4L, 1L, paramInt);
    AppMethodBeat.o(205583);
  }
  
  public static final void Vq(int paramInt)
  {
    AppMethodBeat.i(205584);
    j(5L, 1L, paramInt);
    AppMethodBeat.o(205584);
  }
  
  public static final void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    int i = 1;
    AppMethodBeat.i(160474);
    d.g.b.k.h(paramString, "url");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt).append(",");
    localStringBuilder.append(p.encode(paramString, "utf-8")).append(",");
    String str2 = ((d)Cuf.getValue()).Tr(paramString);
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
      d.g.b.k.g(paramString, "Uri.parse(url)");
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
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(18919, paramString);
      ac.v("ReportWebPrefetchCTR", paramString);
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
  
  public static final void a(com.tencent.mm.plugin.webview.j.h paramh, int paramInt)
  {
    AppMethodBeat.i(175658);
    d.g.b.k.h(paramh, "performanceHelper");
    if (paramh.CtF) {
      j(1L, 1L, paramInt);
    }
    AppMethodBeat.o(175658);
  }
  
  public static final void a(com.tencent.mm.plugin.webview.j.h paramh, final WebView paramWebView)
  {
    AppMethodBeat.i(82529);
    d.g.b.k.h(paramh, "performanceHelper");
    d.g.b.k.h(paramWebView, "webView");
    boolean bool1 = paramh.CtF;
    boolean bool2 = paramh.CtG;
    paramWebView = com.tencent.mm.plugin.report.service.h.wUl;
    if (bool1) {
      paramWebView.n(1200L, 2L, 1L);
    }
    if (bool2) {
      paramWebView.n(1200L, 3L, 1L);
    }
    paramWebView = new v.e();
    paramWebView.KUP = paramh.CPA;
    Object localObject1 = e.Cul;
    paramWebView = new f(paramh, paramWebView);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramWebView.aCL("onCreate")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aCL("onUIInitEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aCL("onWebViewCreateStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aCL("onWebViewCreateEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aCL("getA8KeyStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aCL("getA8KeyEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aCL("onTryBindServiceStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aCL("onPostBindedEnd")).append(",");
    ((StringBuilder)localObject1).append("0,0,");
    ((StringBuilder)localObject1).append(paramWebView.aCL("navigationStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aCL("domLoading")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aCL("domainLookupStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aCL("domainLookupEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aCL("navigationStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aCL("firstContentfulPaint")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aCL("domContentLoadedEventStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aCL("loadEventStart"));
    paramWebView = ((StringBuilder)localObject1).toString();
    d.g.b.k.g(paramWebView, "StringBuilder().apply {\n…d())\n        }.toString()");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(p.encode(paramh.CkB, "utf-8")).append(",");
    Object localObject2 = Uri.parse(paramh.CkB);
    d.g.b.k.g(localObject2, "Uri.parse(performanceHelper.initUrl)");
    ((StringBuilder)localObject1).append(((Uri)localObject2).getHost()).append(",");
    localObject2 = e.Cul;
    ((StringBuilder)localObject1).append(e.up(paramh.CtF)).append(",");
    localObject2 = e.Cul;
    ((StringBuilder)localObject1).append(e.up(paramh.CtG)).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    localObject2 = e.Cul;
    ((StringBuilder)localObject1).append(e.up(paramh.CtE)).append(",");
    ((StringBuilder)localObject1).append(paramh.CPx.size() + paramh.CPy.size()).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    ((StringBuilder)localObject1).append(paramWebView);
    localObject1 = ((StringBuilder)localObject1).toString();
    com.tencent.mm.plugin.report.service.h.wUl.kvStat(18497, (String)localObject1);
    ac.v("MicroMsg.WebViewPerformanceReporter", "webview performance:\n".concat(String.valueOf(paramWebView)));
    a(paramh.Czo, paramh.CkB, false, true, paramh.CtF, paramh.CtG, paramh.CtE, 128);
    AppMethodBeat.o(82529);
  }
  
  public static final void b(com.tencent.mm.plugin.webview.j.h paramh, WebView paramWebView)
  {
    int m = 4;
    int n = 2;
    int i1 = 1;
    AppMethodBeat.i(182649);
    d.g.b.k.h(paramh, "performanceHelper");
    d.g.b.k.h(paramWebView, "webView");
    Object localObject1 = c.Cuj;
    localObject1 = new v.e();
    ((v.e)localObject1).KUP = paramh.CPA;
    d locald = new d(paramh, (v.e)localObject1);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2 = Uri.parse(paramh.CkB);
    d.g.b.k.g(localObject2, "Uri.parse(performanceHelper.initUrl)");
    localStringBuilder.append(((Uri)localObject2).getHost()).append(",");
    localStringBuilder.append(p.encode(paramh.CkB, "utf-8")).append(",");
    int i;
    int j;
    label144:
    int k;
    if (paramh.CPu)
    {
      i = 1;
      if (!paramh.CtF) {
        break label717;
      }
      j = 2;
      if (!paramh.CPw) {
        break label722;
      }
      k = 4;
      label154:
      localStringBuilder.append(i | j | k).append(",");
      if (!paramh.CtE) {
        break label728;
      }
      i = i1;
      label181:
      if (paramh.CPx.size() <= 0) {
        break label733;
      }
      j = n;
      label194:
      if (paramh.CPy.size() <= 0) {
        break label738;
      }
      k = m;
      label208:
      localStringBuilder.append(i | j | k).append(",");
      localObject2 = c.Cuj;
      localStringBuilder.append(c.up(paramh.CtG)).append(",");
      localStringBuilder.append(paramh.Czo).append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(0).append(",");
      localStringBuilder.append(locald.aAX("pageAppear"));
      localStringBuilder.append(locald.aAX("onWebViewCreateStart"));
      localStringBuilder.append(locald.aAX("onWebViewCreateEnd"));
      localStringBuilder.append(locald.aAX("getA8KeyStart"));
      localStringBuilder.append(locald.aAX("getA8KeyEnd"));
      localStringBuilder.append(locald.aAX("clientLoadUrl"));
      localStringBuilder.append(locald.aAX("navigationStart"));
      localStringBuilder.append(locald.aAX("domainLookupStart"));
      localStringBuilder.append(locald.aAX("domainLookupEnd"));
      localStringBuilder.append(locald.aAX("connectStart"));
      localStringBuilder.append(locald.aAX("connectEnd"));
      localStringBuilder.append(locald.aAX("responseStart"));
      localStringBuilder.append(locald.aAX("responseEnd"));
      if (!paramh.CPu) {
        break label744;
      }
    }
    label717:
    label722:
    label728:
    label733:
    label738:
    label744:
    for (localObject1 = paramh.CPv - ((v.e)localObject1).KUP + ',';; localObject1 = locald.aAX("domLoading"))
    {
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(locald.aAX("domInteractive"));
      localStringBuilder.append(locald.aAX("domContentLoadedEventStart"));
      localStringBuilder.append(locald.aAX("domContentLoadedEventEnd"));
      localStringBuilder.append(locald.aAX("loadEventStart"));
      localStringBuilder.append(locald.aAX("loadEventEnd"));
      localStringBuilder.append(locald.aAX("onTryBindServiceStart"));
      localStringBuilder.append(locald.aAX("onPostBindedEnd"));
      localStringBuilder.append(locald.aAX("onCreate"));
      localStringBuilder.append(locald.aAX("onUIInitEnd"));
      localObject1 = localStringBuilder.toString();
      d.g.b.k.g(localObject1, "StringBuilder().apply {\n…())\n\n        }.toString()");
      ac.i("WebViewPerformanceReporter", (String)localObject1);
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(19471, (String)localObject1);
      if (com.tencent.mm.plugin.webview.c.j.eAd()) {
        c(paramh, paramWebView);
      }
      AppMethodBeat.o(182649);
      return;
      i = 0;
      break;
      j = 0;
      break label144;
      k = 0;
      break label154;
      i = 0;
      break label181;
      j = 0;
      break label194;
      k = 0;
      break label208;
    }
  }
  
  private static void c(com.tencent.mm.plugin.webview.j.h paramh, WebView paramWebView)
  {
    AppMethodBeat.i(205585);
    final long l = paramh.CPA;
    Object localObject1 = (List)new ArrayList();
    Object localObject2 = new b(paramh, l);
    ((List)localObject1).add(Long.valueOf(0L));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aCL("pageAppear")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aCL("onWebViewCreateStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aCL("onWebViewCreateEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aCL("getA8KeyStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aCL("getA8KeyEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aCL("clientLoadUrl")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aCL("navigationStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aCL("domainLookupStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aCL("domainLookupEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aCL("connectStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aCL("connectEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aCL("responseStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aCL("responseEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aCL("domLoading")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aCL("domInteractive")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aCL("onTryBindServiceStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aCL("onPostBindedEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aCL("onCreate")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aCL("onUIInitEnd")));
    String str1 = "[" + d.a.j.a((Iterable)d.a.j.b((Iterable)localObject1, 20), null, null, null, 0, null, null, 63) + ']';
    localObject1 = paramh.CPt;
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
        ((Collection)localObject2).add(d.u.Q(localObject3[0], localObject3[1]));
        i += 1;
      }
      localObject1 = ((Collection)localObject2).toArray(new o[0]);
      if (localObject1 == null)
      {
        paramh = new v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(205585);
        throw paramh;
      }
      localObject1 = (o[])localObject1;
      localObject3 = new y(10);
      ((y)localObject3).add(d.u.Q("section", "GetA8Key"));
      ((y)localObject3).add(d.u.Q("preGetA8Key", String.valueOf(paramh.CtF)));
      ((y)localObject3).add(d.u.Q("preDns", String.valueOf(paramh.CtG)));
      if (localObject1 != null) {
        break label1059;
      }
      localObject1 = new o[0];
    }
    label1059:
    for (;;)
    {
      localObject2 = localObject3;
      ((y)localObject3).eL(localObject1);
      ((y)localObject2).add(d.u.Q("section", "Prefetch"));
      ((y)localObject2).add(d.u.Q("prefetch", String.valueOf(paramh.CtE)));
      ((y)localObject2).add(d.u.Q("prefetchJS", d.a.j.a((Iterable)paramh.CPx, (CharSequence)"<br/>", null, null, 0, null, null, 62)));
      ((y)localObject2).add(d.u.Q("prefetchCSS", d.a.j.a((Iterable)paramh.CPy, (CharSequence)"<br/>", null, null, 0, null, null, 62)));
      ((y)localObject2).add(d.u.Q("section", "Prefetch Headers"));
      localObject1 = (Map)paramh.CPz;
      paramh = (Map)new LinkedHashMap();
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
          paramh = new v("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(205585);
          throw paramh;
          localObject1 = null;
          break;
        }
        str2 = n.trim((CharSequence)str2).toString();
        if (str2 == null)
        {
          paramh = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(205585);
          throw paramh;
        }
        str2 = str2.toLowerCase();
        d.g.b.k.g(str2, "(this as java.lang.String).toLowerCase()");
        if (n.nb(str2, "x-wx-")) {
          paramh.put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
        }
      }
      label975:
      paramh = ((Collection)ae.cb(paramh)).toArray(new o[0]);
      if (paramh == null)
      {
        paramh = new v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(205585);
        throw paramh;
      }
      ((y)localObject2).eL(paramh);
      com.tencent.mm.plugin.webview.j.h.a("['PageAppear', 'WebView', 'GetA8key', 'ClientLoadToNavStart', 'DomainLookUp', 'ConnectStart', 'Response', 'DomLoadingToInteractive', 'Invoker', 'WebViewUICreate']", str1, paramWebView, d.a.j.listOf((o[])((y)localObject2).toArray(new o[((y)localObject2).cQJ.size()])));
      AppMethodBeat.o(205585);
      return;
    }
  }
  
  public static final void eCs()
  {
    AppMethodBeat.i(82523);
    com.tencent.mm.plugin.report.service.h.wUl.n(1200L, 10L, 1L);
    AppMethodBeat.o(82523);
  }
  
  public static final void eCt()
  {
    AppMethodBeat.i(82524);
    com.tencent.mm.plugin.report.service.h.wUl.n(1200L, 11L, 1L);
    AppMethodBeat.o(82524);
  }
  
  public static final void eCu()
  {
    AppMethodBeat.i(82525);
    com.tencent.mm.plugin.report.service.h.wUl.n(1200L, 12L, 1L);
    AppMethodBeat.o(82525);
  }
  
  public static final void eCv()
  {
    AppMethodBeat.i(82526);
    com.tencent.mm.plugin.report.service.h.wUl.n(1200L, 100L, 1L);
    AppMethodBeat.o(82526);
  }
  
  public static final void eCw()
  {
    AppMethodBeat.i(82527);
    com.tencent.mm.plugin.report.service.h.wUl.n(1200L, 101L, 1L);
    AppMethodBeat.o(82527);
  }
  
  public static final void eCx()
  {
    AppMethodBeat.i(82528);
    com.tencent.mm.plugin.report.service.h.wUl.n(1200L, 102L, 1L);
    AppMethodBeat.o(82528);
  }
  
  public static final void iK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175657);
    j(0L, paramInt1, paramInt2);
    AppMethodBeat.o(175657);
  }
  
  public static final void iL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175659);
    j(2L, paramInt1, paramInt2);
    AppMethodBeat.o(175659);
  }
  
  public static final void iM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175660);
    j(6L, paramInt1, paramInt2);
    AppMethodBeat.o(175660);
  }
  
  private static final void j(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(175668);
    com.tencent.mm.plugin.report.service.h.wUl.n(1281L, paramLong1, paramLong2);
    switch (paramInt)
    {
    default: 
      com.tencent.mm.plugin.report.service.h.wUl.n(1287L, paramLong1, paramLong2);
    }
    for (;;)
    {
      ac.v("MicroMsg.WebViewPerformanceReporter", "reportByScene scene = " + paramInt + ", key = " + paramLong1 + ", value = " + paramLong2);
      AppMethodBeat.o(175668);
      return;
      com.tencent.mm.plugin.report.service.h.wUl.n(1283L, paramLong1, paramLong2);
      continue;
      com.tencent.mm.plugin.report.service.h.wUl.n(1282L, paramLong1, paramLong2);
      continue;
      com.tencent.mm.plugin.report.service.h.wUl.n(1284L, paramLong1, paramLong2);
      continue;
      com.tencent.mm.plugin.report.service.h.wUl.n(1285L, paramLong1, paramLong2);
      continue;
      com.tencent.mm.plugin.report.service.h.wUl.n(1286L, paramLong1, paramLong2);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<d>
  {
    public static final a Cuh;
    
    static
    {
      AppMethodBeat.i(205579);
      Cuh = new a();
      AppMethodBeat.o(205579);
    }
    
    a()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"getRecord", "", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<String, Long>
  {
    b(com.tencent.mm.plugin.webview.j.h paramh, long paramLong)
    {
      super();
    }
    
    public final long aCL(String paramString)
    {
      AppMethodBeat.i(205581);
      d.g.b.k.h(paramString, "$this$getRecord");
      long l = this.Cui.bJ(paramString, l) - l;
      if (l > 0L)
      {
        AppMethodBeat.o(205581);
        return l;
      }
      AppMethodBeat.o(205581);
      return 0L;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"toInt", "", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<Boolean, Integer>
  {
    public static final c Cuj;
    
    static
    {
      AppMethodBeat.i(182646);
      Cuj = new c();
      AppMethodBeat.o(182646);
    }
    
    c()
    {
      super();
    }
    
    public static int up(boolean paramBoolean)
    {
      if (paramBoolean) {
        return 1;
      }
      return 0;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"getRecord", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<String, String>
  {
    d(com.tencent.mm.plugin.webview.j.h paramh, v.e parame)
    {
      super();
    }
    
    public final String aAX(String paramString)
    {
      AppMethodBeat.i(182648);
      d.g.b.k.h(paramString, "$this$getRecord");
      paramString = this.Cui.bJ(paramString, this.Cuk.KUP) - this.Cuk.KUP + ',';
      AppMethodBeat.o(182648);
      return paramString;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"toInt", "", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<Boolean, Integer>
  {
    public static final e Cul;
    
    static
    {
      AppMethodBeat.i(82518);
      Cul = new e();
      AppMethodBeat.o(82518);
    }
    
    e()
    {
      super();
    }
    
    public static int up(boolean paramBoolean)
    {
      if (paramBoolean) {
        return 1;
      }
      return 0;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"getRecord", "", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<String, Long>
  {
    f(com.tencent.mm.plugin.webview.j.h paramh, v.e parame)
    {
      super();
    }
    
    public final long aCL(String paramString)
    {
      AppMethodBeat.i(82520);
      d.g.b.k.h(paramString, "$this$getRecord");
      long l1 = this.Cui.bJ(paramString, paramWebView.KUP);
      long l2 = paramWebView.KUP;
      AppMethodBeat.o(82520);
      return l1 - l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.h.b
 * JD-Core Version:    0.7.0.1
 */