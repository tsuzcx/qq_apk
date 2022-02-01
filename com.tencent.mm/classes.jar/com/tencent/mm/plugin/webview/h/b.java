package com.tencent.mm.plugin.webview.h;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.webview.j.i;
import com.tencent.xweb.WebView;
import d.f;
import d.g.a.a;
import d.g.b.ac;
import d.g.b.p;
import d.g.b.y.e;
import d.l;
import d.n.n;
import d.o;
import d.u;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/reporter/WebViewPerformanceReporter;", "", "()V", "REPORT_ID", "", "REPORT_ID_SCENE_ALL", "REPORT_ID_SCENE_CHAT", "REPORT_ID_SCENE_MENU", "REPORT_ID_SCENE_OTHER", "REPORT_ID_SCENE_READER_COMMON", "REPORT_ID_SCENE_READER_TOP", "REPORT_ID_SCENE_SNS", "WebPrefecher", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "getWebPrefecher", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "WebPrefecher$delegate", "Lkotlin/Lazy;", "doPrintPagePerformence", "", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "webView", "Lcom/tencent/xweb/WebView;", "reportByScene", "key", "value", "scene", "", "reportCommonWebViewPerformance", "reportGetA8KeyLiteCount", "count", "reportHTTP200", "reportHTTP304", "reportHTTPOther", "reportInvokerCreate", "reportInvokerEnablePool", "reportInvokerReuse", "reportIsCssCached", "reportIsCssCachedByScene", "reportIsJsCached", "reportIsJsCachedByScene", "reportIsPageCached", "reportIsPageCachedByScene", "reportNonPrefeth", "reportPerformance", "reportPreDns", "reportPreGetA8Key", "reportPrefetchExpire", "reportPrefeth", "reportWebPrefetchCTR", "url", "", "isExposure", "", "isClick", "preGetA8Key", "preDns", "prefetch", "classifyUin", "reportWebView", "webview-sdk_release"})
public final class b
{
  private static final f EpO;
  public static final b EpP;
  
  static
  {
    AppMethodBeat.i(82530);
    EpP = new b();
    EpO = d.g.O((a)a.EpQ);
    AppMethodBeat.o(82530);
  }
  
  public static final void XG(int paramInt)
  {
    AppMethodBeat.i(82521);
    com.tencent.mm.plugin.report.service.g.yxI.n(1200L, 0L, paramInt);
    AppMethodBeat.o(82521);
  }
  
  public static final void XH(int paramInt)
  {
    AppMethodBeat.i(82522);
    com.tencent.mm.plugin.report.service.g.yxI.n(1200L, 1L, paramInt);
    AppMethodBeat.o(82522);
  }
  
  public static final void XI(int paramInt)
  {
    AppMethodBeat.i(175661);
    j(7L, 1L, paramInt);
    AppMethodBeat.o(175661);
  }
  
  public static final void XJ(int paramInt)
  {
    AppMethodBeat.i(175664);
    j(10L, 1L, paramInt);
    AppMethodBeat.o(175664);
  }
  
  public static final void XK(int paramInt)
  {
    AppMethodBeat.i(214208);
    j(3L, 1L, paramInt);
    AppMethodBeat.o(214208);
  }
  
  public static final void XL(int paramInt)
  {
    AppMethodBeat.i(214209);
    j(4L, 1L, paramInt);
    AppMethodBeat.o(214209);
  }
  
  public static final void XM(int paramInt)
  {
    AppMethodBeat.i(214210);
    j(5L, 1L, paramInt);
    AppMethodBeat.o(214210);
  }
  
  public static final void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    int i = 1;
    AppMethodBeat.i(160474);
    p.h(paramString, "url");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt).append(",");
    localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(paramString, "utf-8")).append(",");
    String str2 = ((d)EpO.getValue()).XK(paramString);
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
      p.g(paramString, "Uri.parse(url)");
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
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(18919, paramString);
      com.tencent.mm.sdk.platformtools.ae.v("ReportWebPrefetchCTR", paramString);
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
  
  public static final void a(i parami, int paramInt)
  {
    AppMethodBeat.i(175658);
    p.h(parami, "performanceHelper");
    if (parami.Epo) {
      j(1L, 1L, paramInt);
    }
    AppMethodBeat.o(175658);
  }
  
  public static final void a(i parami, final WebView paramWebView)
  {
    AppMethodBeat.i(82529);
    p.h(parami, "performanceHelper");
    p.h(paramWebView, "webView");
    boolean bool1 = parami.Epo;
    boolean bool2 = parami.Epp;
    paramWebView = com.tencent.mm.plugin.report.service.g.yxI;
    if (bool1) {
      paramWebView.n(1200L, 2L, 1L);
    }
    if (bool2) {
      paramWebView.n(1200L, 3L, 1L);
    }
    paramWebView = new y.e();
    paramWebView.NiX = parami.ELW;
    Object localObject1 = e.EpU;
    paramWebView = new f(parami, paramWebView);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramWebView.aJG("onCreate")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aJG("onUIInitEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aJG("onWebViewCreateStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aJG("onWebViewCreateEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aJG("getA8KeyStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aJG("getA8KeyEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aJG("onTryBindServiceStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aJG("onPostBindedEnd")).append(",");
    ((StringBuilder)localObject1).append("0,0,");
    ((StringBuilder)localObject1).append(paramWebView.aJG("navigationStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aJG("domLoading")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aJG("domainLookupStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aJG("domainLookupEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aJG("navigationStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aJG("firstContentfulPaint")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aJG("domContentLoadedEventStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aJG("loadEventStart"));
    paramWebView = ((StringBuilder)localObject1).toString();
    p.g(paramWebView, "StringBuilder().apply {\n…d())\n        }.toString()");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(com.tencent.mm.compatible.util.q.encode(parami.EfF, "utf-8")).append(",");
    Object localObject2 = Uri.parse(parami.EfF);
    p.g(localObject2, "Uri.parse(performanceHelper.initUrl)");
    ((StringBuilder)localObject1).append(((Uri)localObject2).getHost()).append(",");
    localObject2 = e.EpU;
    ((StringBuilder)localObject1).append(e.vl(parami.Epo)).append(",");
    localObject2 = e.EpU;
    ((StringBuilder)localObject1).append(e.vl(parami.Epp)).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    localObject2 = e.EpU;
    ((StringBuilder)localObject1).append(e.vl(parami.Epn)).append(",");
    ((StringBuilder)localObject1).append(parami.ELT.size() + parami.ELU.size()).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    ((StringBuilder)localObject1).append(paramWebView);
    localObject1 = ((StringBuilder)localObject1).toString();
    com.tencent.mm.plugin.report.service.g.yxI.kvStat(18497, (String)localObject1);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebViewPerformanceReporter", "webview performance:\n".concat(String.valueOf(paramWebView)));
    a(parami.EuZ, parami.EfF, false, true, parami.Epo, parami.Epp, parami.Epn, 128);
    AppMethodBeat.o(82529);
  }
  
  public static final void b(i parami, WebView paramWebView)
  {
    int m = 4;
    int n = 2;
    int i1 = 1;
    AppMethodBeat.i(182649);
    p.h(parami, "performanceHelper");
    p.h(paramWebView, "webView");
    Object localObject1 = c.EpS;
    localObject1 = new y.e();
    ((y.e)localObject1).NiX = parami.ELW;
    d locald = new d(parami, (y.e)localObject1);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2 = Uri.parse(parami.EfF);
    p.g(localObject2, "Uri.parse(performanceHelper.initUrl)");
    localStringBuilder.append(((Uri)localObject2).getHost()).append(",");
    localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(parami.EfF, "utf-8")).append(",");
    int i;
    int j;
    label142:
    int k;
    if (parami.ELQ)
    {
      i = 1;
      if (!parami.Epo) {
        break label715;
      }
      j = 2;
      if (!parami.ELS) {
        break label720;
      }
      k = 4;
      label152:
      localStringBuilder.append(i | j | k).append(",");
      if (!parami.Epn) {
        break label726;
      }
      i = i1;
      label179:
      if (parami.ELT.size() <= 0) {
        break label731;
      }
      j = n;
      label192:
      if (parami.ELU.size() <= 0) {
        break label736;
      }
      k = m;
      label206:
      localStringBuilder.append(i | j | k).append(",");
      localObject2 = c.EpS;
      localStringBuilder.append(c.vl(parami.Epp)).append(",");
      localStringBuilder.append(parami.EuZ).append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(0).append(",");
      localStringBuilder.append(locald.aHM("pageAppear"));
      localStringBuilder.append(locald.aHM("onWebViewCreateStart"));
      localStringBuilder.append(locald.aHM("onWebViewCreateEnd"));
      localStringBuilder.append(locald.aHM("getA8KeyStart"));
      localStringBuilder.append(locald.aHM("getA8KeyEnd"));
      localStringBuilder.append(locald.aHM("clientLoadUrl"));
      localStringBuilder.append(locald.aHM("navigationStart"));
      localStringBuilder.append(locald.aHM("domainLookupStart"));
      localStringBuilder.append(locald.aHM("domainLookupEnd"));
      localStringBuilder.append(locald.aHM("connectStart"));
      localStringBuilder.append(locald.aHM("connectEnd"));
      localStringBuilder.append(locald.aHM("responseStart"));
      localStringBuilder.append(locald.aHM("responseEnd"));
      if (!parami.ELQ) {
        break label742;
      }
    }
    label715:
    label720:
    label726:
    label731:
    label736:
    label742:
    for (localObject1 = parami.ELR - ((y.e)localObject1).NiX + ',';; localObject1 = locald.aHM("domLoading"))
    {
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(locald.aHM("domInteractive"));
      localStringBuilder.append(locald.aHM("domContentLoadedEventStart"));
      localStringBuilder.append(locald.aHM("domContentLoadedEventEnd"));
      localStringBuilder.append(locald.aHM("loadEventStart"));
      localStringBuilder.append(locald.aHM("loadEventEnd"));
      localStringBuilder.append(locald.aHM("onTryBindServiceStart"));
      localStringBuilder.append(locald.aHM("onPostBindedEnd"));
      localStringBuilder.append(locald.aHM("onCreate"));
      localStringBuilder.append(locald.aHM("onUIInitEnd"));
      localObject1 = localStringBuilder.toString();
      p.g(localObject1, "StringBuilder().apply {\n…())\n\n        }.toString()");
      com.tencent.mm.sdk.platformtools.ae.i("WebViewPerformanceReporter", (String)localObject1);
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(19471, (String)localObject1);
      if (com.tencent.mm.plugin.webview.c.j.eSC()) {
        c(parami, paramWebView);
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
  
  private static void c(i parami, WebView paramWebView)
  {
    AppMethodBeat.i(214211);
    final long l = parami.ELW;
    Object localObject1 = (List)new ArrayList();
    Object localObject2 = new b(parami, l);
    ((List)localObject1).add(Long.valueOf(0L));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aJG("pageAppear")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aJG("onWebViewCreateStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aJG("onWebViewCreateEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aJG("getA8KeyStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aJG("getA8KeyEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aJG("clientLoadUrl")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aJG("navigationStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aJG("domainLookupStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aJG("domainLookupEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aJG("connectStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aJG("connectEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aJG("responseStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aJG("responseEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aJG("domLoading")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aJG("domInteractive")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aJG("onTryBindServiceStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aJG("onPostBindedEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aJG("onCreate")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aJG("onUIInitEnd")));
    String str1 = "[" + d.a.j.a((Iterable)d.a.j.b((Iterable)localObject1, 20), null, null, null, 0, null, null, 63) + ']';
    localObject1 = parami.ELP;
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
        ((Collection)localObject2).add(u.R(localObject3[0], localObject3[1]));
        i += 1;
      }
      localObject1 = ((Collection)localObject2).toArray(new o[0]);
      if (localObject1 == null)
      {
        parami = new v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(214211);
        throw parami;
      }
      localObject1 = (o[])localObject1;
      localObject3 = new ac(10);
      ((ac)localObject3).add(u.R("section", "GetA8Key"));
      ((ac)localObject3).add(u.R("preGetA8Key", String.valueOf(parami.Epo)));
      ((ac)localObject3).add(u.R("preDns", String.valueOf(parami.Epp)));
      if (localObject1 != null) {
        break label1059;
      }
      localObject1 = new o[0];
    }
    label1059:
    for (;;)
    {
      localObject2 = localObject3;
      ((ac)localObject3).eR(localObject1);
      ((ac)localObject2).add(u.R("section", "Prefetch"));
      ((ac)localObject2).add(u.R("prefetch", String.valueOf(parami.Epn)));
      ((ac)localObject2).add(u.R("prefetchJS", d.a.j.a((Iterable)parami.ELT, (CharSequence)"<br/>", null, null, 0, null, null, 62)));
      ((ac)localObject2).add(u.R("prefetchCSS", d.a.j.a((Iterable)parami.ELU, (CharSequence)"<br/>", null, null, 0, null, null, 62)));
      ((ac)localObject2).add(u.R("section", "Prefetch Headers"));
      localObject1 = (Map)parami.ELV;
      parami = (Map)new LinkedHashMap();
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
          parami = new v("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(214211);
          throw parami;
          localObject1 = null;
          break;
        }
        str2 = n.trim((CharSequence)str2).toString();
        if (str2 == null)
        {
          parami = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(214211);
          throw parami;
        }
        str2 = str2.toLowerCase();
        p.g(str2, "(this as java.lang.String).toLowerCase()");
        if (n.nF(str2, "x-wx-")) {
          parami.put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
        }
      }
      label975:
      parami = ((Collection)d.a.ae.cj(parami)).toArray(new o[0]);
      if (parami == null)
      {
        parami = new v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(214211);
        throw parami;
      }
      ((ac)localObject2).eR(parami);
      i.a("['PageAppear', 'WebView', 'GetA8key', 'ClientLoadToNavStart', 'DomainLookUp', 'ConnectStart', 'Response', 'DomLoadingToInteractive', 'Invoker', 'WebViewUICreate']", str1, paramWebView, d.a.j.listOf((o[])((ac)localObject2).toArray(new o[((ac)localObject2).ddb.size()])));
      AppMethodBeat.o(214211);
      return;
    }
  }
  
  public static final void eUY()
  {
    AppMethodBeat.i(82523);
    com.tencent.mm.plugin.report.service.g.yxI.n(1200L, 10L, 1L);
    AppMethodBeat.o(82523);
  }
  
  public static final void eUZ()
  {
    AppMethodBeat.i(82524);
    com.tencent.mm.plugin.report.service.g.yxI.n(1200L, 11L, 1L);
    AppMethodBeat.o(82524);
  }
  
  public static final void eVa()
  {
    AppMethodBeat.i(82525);
    com.tencent.mm.plugin.report.service.g.yxI.n(1200L, 12L, 1L);
    AppMethodBeat.o(82525);
  }
  
  public static final void eVb()
  {
    AppMethodBeat.i(82526);
    com.tencent.mm.plugin.report.service.g.yxI.n(1200L, 100L, 1L);
    AppMethodBeat.o(82526);
  }
  
  public static final void eVc()
  {
    AppMethodBeat.i(82527);
    com.tencent.mm.plugin.report.service.g.yxI.n(1200L, 101L, 1L);
    AppMethodBeat.o(82527);
  }
  
  public static final void eVd()
  {
    AppMethodBeat.i(82528);
    com.tencent.mm.plugin.report.service.g.yxI.n(1200L, 102L, 1L);
    AppMethodBeat.o(82528);
  }
  
  private static final void j(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(175668);
    com.tencent.mm.plugin.report.service.g.yxI.n(1281L, paramLong1, paramLong2);
    switch (paramInt)
    {
    default: 
      com.tencent.mm.plugin.report.service.g.yxI.n(1287L, paramLong1, paramLong2);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WebViewPerformanceReporter", "reportByScene scene = " + paramInt + ", key = " + paramLong1 + ", value = " + paramLong2);
      AppMethodBeat.o(175668);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.n(1283L, paramLong1, paramLong2);
      continue;
      com.tencent.mm.plugin.report.service.g.yxI.n(1282L, paramLong1, paramLong2);
      continue;
      com.tencent.mm.plugin.report.service.g.yxI.n(1284L, paramLong1, paramLong2);
      continue;
      com.tencent.mm.plugin.report.service.g.yxI.n(1285L, paramLong1, paramLong2);
      continue;
      com.tencent.mm.plugin.report.service.g.yxI.n(1286L, paramLong1, paramLong2);
    }
  }
  
  public static final void jb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175657);
    j(0L, paramInt1, paramInt2);
    AppMethodBeat.o(175657);
  }
  
  public static final void jc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175659);
    j(2L, paramInt1, paramInt2);
    AppMethodBeat.o(175659);
  }
  
  public static final void jd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175660);
    j(6L, paramInt1, paramInt2);
    AppMethodBeat.o(175660);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends d.g.b.q
    implements a<d>
  {
    public static final a EpQ;
    
    static
    {
      AppMethodBeat.i(214205);
      EpQ = new a();
      AppMethodBeat.o(214205);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"getRecord", "", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.b<String, Long>
  {
    b(i parami, long paramLong)
    {
      super();
    }
    
    public final long aJG(String paramString)
    {
      AppMethodBeat.i(214207);
      p.h(paramString, "$this$getRecord");
      long l = this.EpR.bN(paramString, l) - l;
      if (l > 0L)
      {
        AppMethodBeat.o(214207);
        return l;
      }
      AppMethodBeat.o(214207);
      return 0L;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"toInt", "", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.b<Boolean, Integer>
  {
    public static final c EpS;
    
    static
    {
      AppMethodBeat.i(182646);
      EpS = new c();
      AppMethodBeat.o(182646);
    }
    
    c()
    {
      super();
    }
    
    public static int vl(boolean paramBoolean)
    {
      if (paramBoolean) {
        return 1;
      }
      return 0;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"getRecord", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.b<String, String>
  {
    d(i parami, y.e parame)
    {
      super();
    }
    
    public final String aHM(String paramString)
    {
      AppMethodBeat.i(182648);
      p.h(paramString, "$this$getRecord");
      paramString = this.EpR.bN(paramString, this.EpT.NiX) - this.EpT.NiX + ',';
      AppMethodBeat.o(182648);
      return paramString;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"toInt", "", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.b<Boolean, Integer>
  {
    public static final e EpU;
    
    static
    {
      AppMethodBeat.i(82518);
      EpU = new e();
      AppMethodBeat.o(82518);
    }
    
    e()
    {
      super();
    }
    
    public static int vl(boolean paramBoolean)
    {
      if (paramBoolean) {
        return 1;
      }
      return 0;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"getRecord", "", "", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.b<String, Long>
  {
    f(i parami, y.e parame)
    {
      super();
    }
    
    public final long aJG(String paramString)
    {
      AppMethodBeat.i(82520);
      p.h(paramString, "$this$getRecord");
      long l1 = this.EpR.bN(paramString, paramWebView.NiX);
      long l2 = paramWebView.NiX;
      AppMethodBeat.o(82520);
      return l1 - l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.h.b
 * JD-Core Version:    0.7.0.1
 */