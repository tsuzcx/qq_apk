package com.tencent.mm.plugin.webview.h;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.WebView;
import d.a.ae;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.v.d;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/reporter/WebViewPerformanceReporter;", "", "()V", "REPORT_ID", "", "REPORT_ID_SCENE_ALL", "REPORT_ID_SCENE_CHAT", "REPORT_ID_SCENE_MENU", "REPORT_ID_SCENE_OTHER", "REPORT_ID_SCENE_READER_COMMON", "REPORT_ID_SCENE_READER_TOP", "REPORT_ID_SCENE_SNS", "WebPrefecher", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "getWebPrefecher", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "WebPrefecher$delegate", "Lkotlin/Lazy;", "doPrintPagePerformence", "", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "webView", "Lcom/tencent/xweb/WebView;", "reportByScene", "key", "value", "scene", "", "reportCommonWebViewPerformance", "reportGetA8KeyLiteCount", "count", "reportHTTP200", "reportHTTP304", "reportHTTPOther", "reportInvokerCreate", "reportInvokerEnablePool", "reportInvokerReuse", "reportIsCssCached", "reportIsCssCachedByScene", "reportIsJsCached", "reportIsJsCachedByScene", "reportIsPageCached", "reportIsPageCachedByScene", "reportNonPrefeth", "reportPerformance", "reportPreDns", "reportPreGetA8Key", "reportPrefetchExpire", "reportPrefeth", "reportWebPrefetchCTR", "url", "", "isExposure", "", "isClick", "preGetA8Key", "preDns", "prefetch", "classifyUin", "reportWebView", "webview-sdk_release"})
public final class b
{
  private static final f BbT;
  public static final b BbU;
  
  static
  {
    AppMethodBeat.i(82530);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(b.class), "WebPrefecher", "getWebPrefecher()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;")) };
    BbU = new b();
    BbT = g.E((a)a.BbV);
    AppMethodBeat.o(82530);
  }
  
  public static final void Tc(int paramInt)
  {
    AppMethodBeat.i(82521);
    com.tencent.mm.plugin.report.service.h.vKh.m(1200L, 0L, paramInt);
    AppMethodBeat.o(82521);
  }
  
  public static final void Td(int paramInt)
  {
    AppMethodBeat.i(82522);
    com.tencent.mm.plugin.report.service.h.vKh.m(1200L, 1L, paramInt);
    AppMethodBeat.o(82522);
  }
  
  public static final void Te(int paramInt)
  {
    AppMethodBeat.i(175661);
    j(7L, 1L, paramInt);
    AppMethodBeat.o(175661);
  }
  
  public static final void Tf(int paramInt)
  {
    AppMethodBeat.i(175664);
    j(10L, 1L, paramInt);
    AppMethodBeat.o(175664);
  }
  
  public static final void Tg(int paramInt)
  {
    AppMethodBeat.i(189450);
    j(3L, 1L, paramInt);
    AppMethodBeat.o(189450);
  }
  
  public static final void Th(int paramInt)
  {
    AppMethodBeat.i(189451);
    j(4L, 1L, paramInt);
    AppMethodBeat.o(189451);
  }
  
  public static final void Ti(int paramInt)
  {
    AppMethodBeat.i(189452);
    j(5L, 1L, paramInt);
    AppMethodBeat.o(189452);
  }
  
  public static final void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    int i = 1;
    AppMethodBeat.i(160474);
    d.g.b.k.h(paramString, "url");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt).append(",");
    localStringBuilder.append(p.encode(paramString, "utf-8")).append(",");
    String str2 = ((d)BbT.getValue()).Ph(paramString);
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
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(18919, paramString);
      ad.v("ReportWebPrefetchCTR", paramString);
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
    if (paramh.Bbt) {
      j(1L, 1L, paramInt);
    }
    AppMethodBeat.o(175658);
  }
  
  public static final void a(com.tencent.mm.plugin.webview.j.h paramh, final WebView paramWebView)
  {
    AppMethodBeat.i(82529);
    d.g.b.k.h(paramh, "performanceHelper");
    d.g.b.k.h(paramWebView, "webView");
    boolean bool1 = paramh.Bbt;
    boolean bool2 = paramh.Bbu;
    paramWebView = com.tencent.mm.plugin.report.service.h.vKh;
    if (bool1) {
      paramWebView.m(1200L, 2L, 1L);
    }
    if (bool2) {
      paramWebView.m(1200L, 3L, 1L);
    }
    paramWebView = new v.d();
    paramWebView.Jhv = paramh.Bxs;
    Object localObject1 = e.BbZ;
    paramWebView = new f(paramh, paramWebView);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramWebView.axt("onCreate")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.axt("onUIInitEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.axt("onWebViewCreateStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.axt("onWebViewCreateEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.axt("getA8KeyStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.axt("getA8KeyEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.axt("onTryBindServiceStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.axt("onPostBindedEnd")).append(",");
    ((StringBuilder)localObject1).append("0,0,");
    ((StringBuilder)localObject1).append(paramWebView.axt("navigationStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.axt("domLoading")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.axt("domainLookupStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.axt("domainLookupEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.axt("navigationStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.axt("firstContentfulPaint")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.axt("domContentLoadedEventStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.axt("loadEventStart"));
    paramWebView = ((StringBuilder)localObject1).toString();
    d.g.b.k.g(paramWebView, "StringBuilder().apply {\n…d())\n        }.toString()");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(p.encode(paramh.ASo, "utf-8")).append(",");
    Object localObject2 = Uri.parse(paramh.ASo);
    d.g.b.k.g(localObject2, "Uri.parse(performanceHelper.initUrl)");
    ((StringBuilder)localObject1).append(((Uri)localObject2).getHost()).append(",");
    localObject2 = e.BbZ;
    ((StringBuilder)localObject1).append(e.tn(paramh.Bbt)).append(",");
    localObject2 = e.BbZ;
    ((StringBuilder)localObject1).append(e.tn(paramh.Bbu)).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    localObject2 = e.BbZ;
    ((StringBuilder)localObject1).append(e.tn(paramh.Bbs)).append(",");
    ((StringBuilder)localObject1).append(paramh.Bxp.size() + paramh.Bxq.size()).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    ((StringBuilder)localObject1).append(paramWebView);
    localObject1 = ((StringBuilder)localObject1).toString();
    com.tencent.mm.plugin.report.service.h.vKh.kvStat(18497, (String)localObject1);
    ad.v("MicroMsg.WebViewPerformanceReporter", "webview performance:\n".concat(String.valueOf(paramWebView)));
    a(paramh.Bhb, paramh.ASo, false, true, paramh.Bbt, paramh.Bbu, paramh.Bbs, 128);
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
    Object localObject1 = c.BbX;
    localObject1 = new v.d();
    ((v.d)localObject1).Jhv = paramh.Bxs;
    d locald = new d(paramh, (v.d)localObject1);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2 = Uri.parse(paramh.ASo);
    d.g.b.k.g(localObject2, "Uri.parse(performanceHelper.initUrl)");
    localStringBuilder.append(((Uri)localObject2).getHost()).append(",");
    localStringBuilder.append(p.encode(paramh.ASo, "utf-8")).append(",");
    int i;
    int j;
    label144:
    int k;
    if (paramh.Bxm)
    {
      i = 1;
      if (!paramh.Bbt) {
        break label717;
      }
      j = 2;
      if (!paramh.Bxo) {
        break label722;
      }
      k = 4;
      label154:
      localStringBuilder.append(i | j | k).append(",");
      if (!paramh.Bbs) {
        break label728;
      }
      i = i1;
      label181:
      if (paramh.Bxp.size() <= 0) {
        break label733;
      }
      j = n;
      label194:
      if (paramh.Bxq.size() <= 0) {
        break label738;
      }
      k = m;
      label208:
      localStringBuilder.append(i | j | k).append(",");
      localObject2 = c.BbX;
      localStringBuilder.append(c.tn(paramh.Bbu)).append(",");
      localStringBuilder.append(paramh.Bhb).append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(0).append(",");
      localStringBuilder.append(locald.avF("pageAppear"));
      localStringBuilder.append(locald.avF("onWebViewCreateStart"));
      localStringBuilder.append(locald.avF("onWebViewCreateEnd"));
      localStringBuilder.append(locald.avF("getA8KeyStart"));
      localStringBuilder.append(locald.avF("getA8KeyEnd"));
      localStringBuilder.append(locald.avF("clientLoadUrl"));
      localStringBuilder.append(locald.avF("navigationStart"));
      localStringBuilder.append(locald.avF("domainLookupStart"));
      localStringBuilder.append(locald.avF("domainLookupEnd"));
      localStringBuilder.append(locald.avF("connectStart"));
      localStringBuilder.append(locald.avF("connectEnd"));
      localStringBuilder.append(locald.avF("responseStart"));
      localStringBuilder.append(locald.avF("responseEnd"));
      if (!paramh.Bxm) {
        break label744;
      }
    }
    label717:
    label722:
    label728:
    label733:
    label738:
    label744:
    for (localObject1 = paramh.Bxn - ((v.d)localObject1).Jhv + ',';; localObject1 = locald.avF("domLoading"))
    {
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(locald.avF("domInteractive"));
      localStringBuilder.append(locald.avF("domContentLoadedEventStart"));
      localStringBuilder.append(locald.avF("domContentLoadedEventEnd"));
      localStringBuilder.append(locald.avF("loadEventStart"));
      localStringBuilder.append(locald.avF("loadEventEnd"));
      localStringBuilder.append(locald.avF("onTryBindServiceStart"));
      localStringBuilder.append(locald.avF("onPostBindedEnd"));
      localStringBuilder.append(locald.avF("onCreate"));
      localStringBuilder.append(locald.avF("onUIInitEnd"));
      localObject1 = localStringBuilder.toString();
      d.g.b.k.g(localObject1, "StringBuilder().apply {\n…())\n\n        }.toString()");
      ad.i("WebViewPerformanceReporter", (String)localObject1);
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(19471, (String)localObject1);
      if (com.tencent.mm.plugin.webview.c.j.ekH()) {
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
    AppMethodBeat.i(189453);
    final long l = paramh.Bxs;
    Object localObject1 = (List)new ArrayList();
    Object localObject2 = new b(paramh, l);
    ((List)localObject1).add(Long.valueOf(0L));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).axt("pageAppear")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).axt("onWebViewCreateStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).axt("onWebViewCreateEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).axt("getA8KeyStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).axt("getA8KeyEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).axt("clientLoadUrl")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).axt("navigationStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).axt("domainLookupStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).axt("domainLookupEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).axt("connectStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).axt("connectEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).axt("responseStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).axt("responseEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).axt("domLoading")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).axt("domInteractive")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).axt("onTryBindServiceStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).axt("onPostBindedEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).axt("onCreate")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).axt("onUIInitEnd")));
    String str1 = "[" + d.a.j.a((Iterable)d.a.j.b((Iterable)localObject1, 20), null, null, null, 0, null, null, 63) + ']';
    localObject1 = paramh.Bxl;
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
        ((Collection)localObject2).add(d.u.P(localObject3[0], localObject3[1]));
        i += 1;
      }
      localObject1 = ((Collection)localObject2).toArray(new o[0]);
      if (localObject1 == null)
      {
        paramh = new v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(189453);
        throw paramh;
      }
      localObject1 = (o[])localObject1;
      localObject3 = new y(10);
      ((y)localObject3).add(d.u.P("section", "GetA8Key"));
      ((y)localObject3).add(d.u.P("preGetA8Key", String.valueOf(paramh.Bbt)));
      ((y)localObject3).add(d.u.P("preDns", String.valueOf(paramh.Bbu)));
      if (localObject1 != null) {
        break label1059;
      }
      localObject1 = new o[0];
    }
    label1059:
    for (;;)
    {
      localObject2 = localObject3;
      ((y)localObject3).eI(localObject1);
      ((y)localObject2).add(d.u.P("section", "Prefetch"));
      ((y)localObject2).add(d.u.P("prefetch", String.valueOf(paramh.Bbs)));
      ((y)localObject2).add(d.u.P("prefetchJS", d.a.j.a((Iterable)paramh.Bxp, (CharSequence)"<br/>", null, null, 0, null, null, 62)));
      ((y)localObject2).add(d.u.P("prefetchCSS", d.a.j.a((Iterable)paramh.Bxq, (CharSequence)"<br/>", null, null, 0, null, null, 62)));
      ((y)localObject2).add(d.u.P("section", "Prefetch Headers"));
      localObject1 = (Map)paramh.Bxr;
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
          AppMethodBeat.o(189453);
          throw paramh;
          localObject1 = null;
          break;
        }
        str2 = n.trim((CharSequence)str2).toString();
        if (str2 == null)
        {
          paramh = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(189453);
          throw paramh;
        }
        str2 = str2.toLowerCase();
        d.g.b.k.g(str2, "(this as java.lang.String).toLowerCase()");
        if (n.mA(str2, "x-wx-")) {
          paramh.put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
        }
      }
      label975:
      paramh = ((Collection)ae.bS(paramh)).toArray(new o[0]);
      if (paramh == null)
      {
        paramh = new v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(189453);
        throw paramh;
      }
      ((y)localObject2).eI(paramh);
      com.tencent.mm.plugin.webview.j.h.a("['PageAppear', 'WebView', 'GetA8key', 'ClientLoadToNavStart', 'DomainLookUp', 'ConnectStart', 'Response', 'DomLoadingToInteractive', 'Invoker', 'WebViewUICreate']", str1, paramWebView, d.a.j.listOf((o[])((y)localObject2).toArray(new o[((y)localObject2).cTm.size()])));
      AppMethodBeat.o(189453);
      return;
    }
  }
  
  public static final void emX()
  {
    AppMethodBeat.i(82523);
    com.tencent.mm.plugin.report.service.h.vKh.m(1200L, 10L, 1L);
    AppMethodBeat.o(82523);
  }
  
  public static final void emY()
  {
    AppMethodBeat.i(82524);
    com.tencent.mm.plugin.report.service.h.vKh.m(1200L, 11L, 1L);
    AppMethodBeat.o(82524);
  }
  
  public static final void emZ()
  {
    AppMethodBeat.i(82525);
    com.tencent.mm.plugin.report.service.h.vKh.m(1200L, 12L, 1L);
    AppMethodBeat.o(82525);
  }
  
  public static final void ena()
  {
    AppMethodBeat.i(82526);
    com.tencent.mm.plugin.report.service.h.vKh.m(1200L, 100L, 1L);
    AppMethodBeat.o(82526);
  }
  
  public static final void enb()
  {
    AppMethodBeat.i(82527);
    com.tencent.mm.plugin.report.service.h.vKh.m(1200L, 101L, 1L);
    AppMethodBeat.o(82527);
  }
  
  public static final void enc()
  {
    AppMethodBeat.i(82528);
    com.tencent.mm.plugin.report.service.h.vKh.m(1200L, 102L, 1L);
    AppMethodBeat.o(82528);
  }
  
  public static final void iw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175657);
    j(0L, paramInt1, paramInt2);
    AppMethodBeat.o(175657);
  }
  
  public static final void ix(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175659);
    j(2L, paramInt1, paramInt2);
    AppMethodBeat.o(175659);
  }
  
  public static final void iy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175660);
    j(6L, paramInt1, paramInt2);
    AppMethodBeat.o(175660);
  }
  
  private static final void j(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(175668);
    com.tencent.mm.plugin.report.service.h.vKh.m(1281L, paramLong1, paramLong2);
    switch (paramInt)
    {
    default: 
      com.tencent.mm.plugin.report.service.h.vKh.m(1287L, paramLong1, paramLong2);
    }
    for (;;)
    {
      ad.v("MicroMsg.WebViewPerformanceReporter", "reportByScene scene = " + paramInt + ", key = " + paramLong1 + ", value = " + paramLong2);
      AppMethodBeat.o(175668);
      return;
      com.tencent.mm.plugin.report.service.h.vKh.m(1283L, paramLong1, paramLong2);
      continue;
      com.tencent.mm.plugin.report.service.h.vKh.m(1282L, paramLong1, paramLong2);
      continue;
      com.tencent.mm.plugin.report.service.h.vKh.m(1284L, paramLong1, paramLong2);
      continue;
      com.tencent.mm.plugin.report.service.h.vKh.m(1285L, paramLong1, paramLong2);
      continue;
      com.tencent.mm.plugin.report.service.h.vKh.m(1286L, paramLong1, paramLong2);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<d>
  {
    public static final a BbV;
    
    static
    {
      AppMethodBeat.i(189447);
      BbV = new a();
      AppMethodBeat.o(189447);
    }
    
    a()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"getRecord", "", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<String, Long>
  {
    b(com.tencent.mm.plugin.webview.j.h paramh, long paramLong)
    {
      super();
    }
    
    public final long axt(String paramString)
    {
      AppMethodBeat.i(189449);
      d.g.b.k.h(paramString, "$this$getRecord");
      long l = this.BbW.bH(paramString, l) - l;
      if (l > 0L)
      {
        AppMethodBeat.o(189449);
        return l;
      }
      AppMethodBeat.o(189449);
      return 0L;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"toInt", "", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<Boolean, Integer>
  {
    public static final c BbX;
    
    static
    {
      AppMethodBeat.i(182646);
      BbX = new c();
      AppMethodBeat.o(182646);
    }
    
    c()
    {
      super();
    }
    
    public static int tn(boolean paramBoolean)
    {
      if (paramBoolean) {
        return 1;
      }
      return 0;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"getRecord", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<String, String>
  {
    d(com.tencent.mm.plugin.webview.j.h paramh, v.d paramd)
    {
      super();
    }
    
    public final String avF(String paramString)
    {
      AppMethodBeat.i(182648);
      d.g.b.k.h(paramString, "$this$getRecord");
      paramString = this.BbW.bH(paramString, this.BbY.Jhv) - this.BbY.Jhv + ',';
      AppMethodBeat.o(182648);
      return paramString;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"toInt", "", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<Boolean, Integer>
  {
    public static final e BbZ;
    
    static
    {
      AppMethodBeat.i(82518);
      BbZ = new e();
      AppMethodBeat.o(82518);
    }
    
    e()
    {
      super();
    }
    
    public static int tn(boolean paramBoolean)
    {
      if (paramBoolean) {
        return 1;
      }
      return 0;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"getRecord", "", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<String, Long>
  {
    f(com.tencent.mm.plugin.webview.j.h paramh, v.d paramd)
    {
      super();
    }
    
    public final long axt(String paramString)
    {
      AppMethodBeat.i(82520);
      d.g.b.k.h(paramString, "$this$getRecord");
      long l1 = this.BbW.bH(paramString, paramWebView.Jhv);
      long l2 = paramWebView.Jhv;
      AppMethodBeat.o(82520);
      return l1 - l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.h.b
 * JD-Core Version:    0.7.0.1
 */