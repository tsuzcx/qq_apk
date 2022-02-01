package com.tencent.mm.plugin.webview.h;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.a.a;
import kotlin.g.b.ah.e;
import kotlin.g.b.al;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/reporter/WebViewPerformanceReporter;", "", "()V", "REPORT_ID", "", "REPORT_ID_SCENE_ALL", "REPORT_ID_SCENE_CHAT", "REPORT_ID_SCENE_MENU", "REPORT_ID_SCENE_OTHER", "REPORT_ID_SCENE_READER_COMMON", "REPORT_ID_SCENE_READER_TOP", "REPORT_ID_SCENE_SNS", "WebPrefecher", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "getWebPrefecher", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "WebPrefecher$delegate", "Lkotlin/Lazy;", "doPrintPagePerformence", "", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "webView", "Lcom/tencent/xweb/WebView;", "reportByScene", "key", "value", "scene", "", "reportCommonWebViewPerformance", "reportGetA8KeyLiteCount", "count", "reportHTTP200", "reportHTTP304", "reportHTTPOther", "reportInvokerCreate", "reportInvokerEnablePool", "reportInvokerReuse", "reportIsCssCached", "reportIsCssCachedByScene", "reportIsJsCached", "reportIsJsCachedByScene", "reportIsPageCached", "reportIsPageCachedByScene", "reportNonPrefeth", "reportPerformance", "reportPreDns", "reportPreGetA8Key", "reportPrefetchExpire", "reportPrefeth", "reportWebPrefetchCTR", "url", "", "isExposure", "", "isClick", "preGetA8Key", "preDns", "prefetch", "classifyUin", "reportWebView", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h WQU;
  private static final j WQV;
  
  static
  {
    AppMethodBeat.i(82530);
    WQU = new h();
    WQV = k.cm((a)a.WQW);
    AppMethodBeat.o(82530);
  }
  
  private static final long a(String paramString, com.tencent.mm.plugin.webview.k.r paramr, long paramLong)
  {
    AppMethodBeat.i(294841);
    paramLong = paramr.cg(paramString, paramLong) - paramLong;
    if (paramLong > 0L)
    {
      AppMethodBeat.o(294841);
      return paramLong;
    }
    AppMethodBeat.o(294841);
    return 0L;
  }
  
  private static final long a(String paramString, com.tencent.mm.plugin.webview.k.r paramr, ah.e parame)
  {
    AppMethodBeat.i(294830);
    long l1 = paramr.cg(paramString, parame.aixc);
    long l2 = parame.aixc;
    AppMethodBeat.o(294830);
    return l1 - l2;
  }
  
  public static final void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    int i = 1;
    AppMethodBeat.i(160474);
    s.u(paramString, "url");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt).append(",");
    localStringBuilder.append(com.tencent.mm.compatible.util.r.as(paramString, "utf-8")).append(",");
    String str2 = ((com.tencent.mm.plugin.brandservice.api.h)WQV.getValue()).aiN(paramString);
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
        break label256;
      }
      paramInt = 1;
      label121:
      localStringBuilder.append(paramInt).append(",");
      localStringBuilder.append(Uri.parse(paramString).getHost()).append(",");
      if (!paramBoolean3) {
        break label261;
      }
      paramInt = 1;
      label158:
      localStringBuilder.append(paramInt).append(",");
      if (!paramBoolean4) {
        break label266;
      }
      paramInt = 1;
      label177:
      localStringBuilder.append(paramInt).append(",");
      if (!paramBoolean5) {
        break label271;
      }
      paramInt = 1;
      label196:
      localStringBuilder.append(paramInt).append(",");
      if (!paramBoolean6) {
        break label276;
      }
    }
    label256:
    label261:
    label266:
    label271:
    label276:
    for (paramInt = i;; paramInt = 0)
    {
      localStringBuilder.append(paramInt);
      paramString = localStringBuilder.toString();
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(18919, paramString);
      Log.v("ReportWebPrefetchCTR", paramString);
      AppMethodBeat.o(160474);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label121;
      paramInt = 0;
      break label158;
      paramInt = 0;
      break label177;
      paramInt = 0;
      break label196;
    }
  }
  
  public static final void a(com.tencent.mm.plugin.webview.k.r paramr, int paramInt)
  {
    AppMethodBeat.i(175658);
    s.u(paramr, "performanceHelper");
    if (paramr.WPG) {
      q(1L, 1L, paramInt);
    }
    AppMethodBeat.o(175658);
  }
  
  public static final void a(com.tencent.mm.plugin.webview.k.r paramr, WebView paramWebView)
  {
    AppMethodBeat.i(82529);
    s.u(paramr, "performanceHelper");
    s.u(paramWebView, "webView");
    boolean bool1 = paramr.WPG;
    boolean bool2 = paramr.WPH;
    paramWebView = com.tencent.mm.plugin.report.service.h.OAn;
    if (bool1) {
      paramWebView.p(1200L, 2L, 1L);
    }
    if (bool2) {
      paramWebView.p(1200L, 3L, 1L);
    }
    paramWebView = new ah.e();
    paramWebView.aixc = paramr.XtF;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a("onCreate", paramr, paramWebView)).append(",");
    ((StringBuilder)localObject).append(a("onUIInitEnd", paramr, paramWebView)).append(",");
    ((StringBuilder)localObject).append(a("onWebViewCreateStart", paramr, paramWebView)).append(",");
    ((StringBuilder)localObject).append(a("onWebViewCreateEnd", paramr, paramWebView)).append(",");
    ((StringBuilder)localObject).append(a("getA8KeyStart", paramr, paramWebView)).append(",");
    ((StringBuilder)localObject).append(a("getA8KeyEnd", paramr, paramWebView)).append(",");
    ((StringBuilder)localObject).append(a("onTryBindServiceStart", paramr, paramWebView)).append(",");
    ((StringBuilder)localObject).append(a("onPostBindedEnd", paramr, paramWebView)).append(",");
    ((StringBuilder)localObject).append("0,0,");
    ((StringBuilder)localObject).append(a("navigationStart", paramr, paramWebView)).append(",");
    ((StringBuilder)localObject).append(a("domLoading", paramr, paramWebView)).append(",");
    ((StringBuilder)localObject).append(a("domainLookupStart", paramr, paramWebView)).append(",");
    ((StringBuilder)localObject).append(a("domainLookupEnd", paramr, paramWebView)).append(",");
    ((StringBuilder)localObject).append(a("navigationStart", paramr, paramWebView)).append(",");
    ((StringBuilder)localObject).append(a("firstContentfulPaint", paramr, paramWebView)).append(",");
    ((StringBuilder)localObject).append(a("domContentLoadedEventStart", paramr, paramWebView)).append(",");
    ((StringBuilder)localObject).append(a("loadEventStart", paramr, paramWebView)).append(",");
    ((StringBuilder)localObject).append(a("onPageStarted", paramr, paramWebView)).append(",");
    ((StringBuilder)localObject).append(a("onPageCommit", paramr, paramWebView)).append(",");
    ((StringBuilder)localObject).append(a("onPageFinished", paramr, paramWebView));
    paramWebView = ((StringBuilder)localObject).toString();
    s.s(paramWebView, "StringBuilder().apply {\n…())\n\n        }.toString()");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(com.tencent.mm.compatible.util.r.as(paramr.WET, "utf-8")).append(",");
    ((StringBuilder)localObject).append(Uri.parse(paramr.WET).getHost()).append(",");
    if (paramr.WPG)
    {
      i = 1;
      ((StringBuilder)localObject).append(i).append(",");
      if (!paramr.WPH) {
        break label723;
      }
      i = 1;
      label539:
      ((StringBuilder)localObject).append(i).append(",");
      ((StringBuilder)localObject).append(0).append(",");
      if (!paramr.WPF) {
        break label728;
      }
    }
    label723:
    label728:
    for (int i = 1;; i = 0)
    {
      ((StringBuilder)localObject).append(i).append(",");
      ((StringBuilder)localObject).append(paramr.XtC.size() + paramr.XtD.size()).append(",");
      ((StringBuilder)localObject).append(0).append(",");
      ((StringBuilder)localObject).append(0).append(",");
      ((StringBuilder)localObject).append(0).append(",");
      ((StringBuilder)localObject).append(paramWebView);
      localObject = ((StringBuilder)localObject).toString();
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(18497, (String)localObject);
      Log.v("MicroMsg.WebViewPerformanceReporter", s.X("webview performance:\n", paramWebView));
      a(paramr.WXq, paramr.WET, false, true, paramr.WPG, paramr.WPH, paramr.WPF, 128);
      AppMethodBeat.o(82529);
      return;
      i = 0;
      break;
      i = 0;
      break label539;
    }
  }
  
  public static final void atV(int paramInt)
  {
    AppMethodBeat.i(82521);
    com.tencent.mm.plugin.report.service.h.OAn.p(1200L, 0L, paramInt);
    AppMethodBeat.o(82521);
  }
  
  public static final void atW(int paramInt)
  {
    AppMethodBeat.i(82522);
    com.tencent.mm.plugin.report.service.h.OAn.p(1200L, 1L, paramInt);
    AppMethodBeat.o(82522);
  }
  
  public static final void atX(int paramInt)
  {
    AppMethodBeat.i(175661);
    q(7L, 1L, paramInt);
    AppMethodBeat.o(175661);
  }
  
  public static final void atY(int paramInt)
  {
    AppMethodBeat.i(175664);
    q(10L, 1L, paramInt);
    AppMethodBeat.o(175664);
  }
  
  public static final void atZ(int paramInt)
  {
    AppMethodBeat.i(294779);
    q(3L, 1L, paramInt);
    AppMethodBeat.o(294779);
  }
  
  public static final void aua(int paramInt)
  {
    AppMethodBeat.i(294783);
    q(4L, 1L, paramInt);
    AppMethodBeat.o(294783);
  }
  
  public static final void aub(int paramInt)
  {
    AppMethodBeat.i(294788);
    q(5L, 1L, paramInt);
    AppMethodBeat.o(294788);
  }
  
  private static final String b(String paramString, com.tencent.mm.plugin.webview.k.r paramr, ah.e parame)
  {
    AppMethodBeat.i(294837);
    paramString = paramr.cg(paramString, parame.aixc) - parame.aixc + ',';
    AppMethodBeat.o(294837);
    return paramString;
  }
  
  public static final void b(com.tencent.mm.plugin.webview.k.r paramr, WebView paramWebView)
  {
    int n = 4;
    int i1 = 2;
    int m = 1;
    AppMethodBeat.i(182649);
    s.u(paramr, "performanceHelper");
    s.u(paramWebView, "webView");
    ah.e locale = new ah.e();
    locale.aixc = paramr.XtF;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Uri.parse(paramr.WET).getHost()).append(",");
    localStringBuilder.append(com.tencent.mm.compatible.util.r.as(paramr.WET, "utf-8")).append(",");
    int i;
    int j;
    label113:
    int k;
    if (paramr.Xtz)
    {
      i = 1;
      if (!paramr.WPG) {
        break label699;
      }
      j = 2;
      if (!paramr.XtB) {
        break label704;
      }
      k = 4;
      label123:
      localStringBuilder.append(i | j | k).append(",");
      if (!paramr.WPF) {
        break label710;
      }
      i = 1;
      label149:
      if (paramr.XtC.size() <= 0) {
        break label715;
      }
      j = i1;
      label162:
      if (paramr.XtD.size() <= 0) {
        break label720;
      }
      k = n;
      label176:
      localStringBuilder.append(i | j | k).append(",");
      if (!paramr.WPH) {
        break label726;
      }
      i = m;
      label203:
      localStringBuilder.append(i).append(",");
      localStringBuilder.append(paramr.WXq).append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(0).append(",");
      localStringBuilder.append(b("pageAppear", paramr, locale));
      localStringBuilder.append(b("onWebViewCreateStart", paramr, locale));
      localStringBuilder.append(b("onWebViewCreateEnd", paramr, locale));
      localStringBuilder.append(b("getA8KeyStart", paramr, locale));
      localStringBuilder.append(b("getA8KeyEnd", paramr, locale));
      localStringBuilder.append(b("clientLoadUrl", paramr, locale));
      localStringBuilder.append(b("navigationStart", paramr, locale));
      localStringBuilder.append(b("domainLookupStart", paramr, locale));
      localStringBuilder.append(b("domainLookupEnd", paramr, locale));
      localStringBuilder.append(b("connectStart", paramr, locale));
      localStringBuilder.append(b("connectEnd", paramr, locale));
      localStringBuilder.append(b("responseStart", paramr, locale));
      localStringBuilder.append(b("responseEnd", paramr, locale));
      if (!paramr.Xtz) {
        break label731;
      }
    }
    label699:
    label704:
    label710:
    label715:
    label720:
    label726:
    label731:
    for (String str = paramr.XtA - locale.aixc + ',';; str = b("domLoading", paramr, locale))
    {
      localStringBuilder.append(str);
      localStringBuilder.append(b("domInteractive", paramr, locale));
      localStringBuilder.append(b("domContentLoadedEventStart", paramr, locale));
      localStringBuilder.append(b("domContentLoadedEventEnd", paramr, locale));
      localStringBuilder.append(b("loadEventStart", paramr, locale));
      localStringBuilder.append(b("loadEventEnd", paramr, locale));
      localStringBuilder.append(b("onTryBindServiceStart", paramr, locale));
      localStringBuilder.append(b("onPostBindedEnd", paramr, locale));
      localStringBuilder.append(b("onCreate", paramr, locale));
      localStringBuilder.append(b("onUIInitEnd", paramr, locale));
      str = localStringBuilder.toString();
      s.s(str, "StringBuilder().apply {\n…())\n\n        }.toString()");
      Log.i("WebViewPerformanceReporter", str);
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(19471, str);
      if (com.tencent.mm.plugin.webview.jsapi.n.itP()) {
        c(paramr, paramWebView);
      }
      AppMethodBeat.o(182649);
      return;
      i = 0;
      break;
      j = 0;
      break label113;
      k = 0;
      break label123;
      i = 0;
      break label149;
      j = 0;
      break label162;
      k = 0;
      break label176;
      i = 0;
      break label203;
    }
  }
  
  private static void c(com.tencent.mm.plugin.webview.k.r paramr, WebView paramWebView)
  {
    AppMethodBeat.i(294824);
    long l = paramr.XtF;
    Object localObject1 = (List)new ArrayList();
    ((List)localObject1).add(Long.valueOf(0L));
    ((List)localObject1).add(Long.valueOf(a("pageAppear", paramr, l)));
    ((List)localObject1).add(Long.valueOf(a("onWebViewCreateStart", paramr, l)));
    ((List)localObject1).add(Long.valueOf(a("onWebViewCreateEnd", paramr, l)));
    ((List)localObject1).add(Long.valueOf(a("getA8KeyStart", paramr, l)));
    ((List)localObject1).add(Long.valueOf(a("getA8KeyEnd", paramr, l)));
    ((List)localObject1).add(Long.valueOf(a("clientLoadUrl", paramr, l)));
    ((List)localObject1).add(Long.valueOf(a("navigationStart", paramr, l)));
    ((List)localObject1).add(Long.valueOf(a("domainLookupStart", paramr, l)));
    ((List)localObject1).add(Long.valueOf(a("domainLookupEnd", paramr, l)));
    ((List)localObject1).add(Long.valueOf(a("connectStart", paramr, l)));
    ((List)localObject1).add(Long.valueOf(a("connectEnd", paramr, l)));
    ((List)localObject1).add(Long.valueOf(a("responseStart", paramr, l)));
    ((List)localObject1).add(Long.valueOf(a("responseEnd", paramr, l)));
    ((List)localObject1).add(Long.valueOf(a("domLoading", paramr, l)));
    ((List)localObject1).add(Long.valueOf(a("domInteractive", paramr, l)));
    ((List)localObject1).add(Long.valueOf(a("onTryBindServiceStart", paramr, l)));
    ((List)localObject1).add(Long.valueOf(a("onPostBindedEnd", paramr, l)));
    ((List)localObject1).add(Long.valueOf(a("onCreate", paramr, l)));
    ((List)localObject1).add(Long.valueOf(a("onUIInitEnd", paramr, l)));
    String str1 = "[" + p.a((Iterable)p.c((Iterable)localObject1, 20), null, null, null, 0, null, null, 63) + ']';
    localObject1 = paramr.Xty;
    Object localObject3;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject3 = new al(10);
      ((al)localObject3).add(v.Y("section", "GetA8Key"));
      ((al)localObject3).add(v.Y("preGetA8Key", String.valueOf(paramr.WPG)));
      ((al)localObject3).add(v.Y("preDns", String.valueOf(paramr.WPH)));
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (kotlin.r[])new kotlin.r[0];
      }
      ((al)localObject3).hx(localObject2);
      ((al)localObject3).add(v.Y("section", "Prefetch"));
      ((al)localObject3).add(v.Y("prefetch", String.valueOf(paramr.WPF)));
      ((al)localObject3).add(v.Y("prefetchJS", p.a((Iterable)paramr.XtC, (CharSequence)"<br/>", null, null, 0, null, null, 62)));
      ((al)localObject3).add(v.Y("prefetchCSS", p.a((Iterable)paramr.XtD, (CharSequence)"<br/>", null, null, 0, null, null, 62)));
      ((al)localObject3).add(v.Y("section", "Prefetch Headers"));
      localObject1 = (Map)paramr.XtE;
      paramr = (Map)new LinkedHashMap();
      localObject1 = ((Map)localObject1).entrySet().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label982;
      }
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      String str2 = (String)((Map.Entry)localObject2).getKey();
      ((Map.Entry)localObject2).getValue();
      if (str2 == null)
      {
        paramr = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(294824);
        throw paramr;
        localObject1 = (Object[])localObject1;
        localObject2 = (Collection)new ArrayList(localObject1.length);
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          localObject3 = (String[])localObject1[i];
          ((Collection)localObject2).add(v.Y(localObject3[0], localObject3[1]));
          i += 1;
        }
        localObject1 = ((Collection)localObject2).toArray(new kotlin.r[0]);
        if (localObject1 == null)
        {
          paramr = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(294824);
          throw paramr;
        }
        localObject1 = (kotlin.r[])localObject1;
        break;
      }
      str2 = kotlin.n.n.bq((CharSequence)str2).toString();
      if (str2 == null)
      {
        paramr = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(294824);
        throw paramr;
      }
      str2 = str2.toLowerCase();
      s.s(str2, "(this as java.lang.String).toLowerCase()");
      if (kotlin.n.n.U(str2, "x-wx-", false)) {
        paramr.put(((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
      }
    }
    label982:
    paramr = ((Collection)ak.dy(paramr)).toArray(new kotlin.r[0]);
    if (paramr == null)
    {
      paramr = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(294824);
      throw paramr;
    }
    ((al)localObject3).hx(paramr);
    com.tencent.mm.plugin.webview.k.r.a("['PageAppear', 'WebView', 'GetA8key', 'ClientLoadToNavStart', 'DomainLookUp', 'ConnectStart', 'Response', 'DomLoadingToInteractive', 'Invoker', 'WebViewUICreate']", str1, paramWebView, p.listOf(((al)localObject3).toArray(new kotlin.r[((al)localObject3).hqL.size()])));
    AppMethodBeat.o(294824);
  }
  
  public static final void iwF()
  {
    AppMethodBeat.i(82523);
    com.tencent.mm.plugin.report.service.h.OAn.p(1200L, 10L, 1L);
    AppMethodBeat.o(82523);
  }
  
  public static final void iwG()
  {
    AppMethodBeat.i(82524);
    com.tencent.mm.plugin.report.service.h.OAn.p(1200L, 11L, 1L);
    AppMethodBeat.o(82524);
  }
  
  public static final void iwH()
  {
    AppMethodBeat.i(82525);
    com.tencent.mm.plugin.report.service.h.OAn.p(1200L, 12L, 1L);
    AppMethodBeat.o(82525);
  }
  
  public static final void iwI()
  {
    AppMethodBeat.i(82526);
    com.tencent.mm.plugin.report.service.h.OAn.p(1200L, 100L, 1L);
    AppMethodBeat.o(82526);
  }
  
  public static final void iwJ()
  {
    AppMethodBeat.i(82527);
    com.tencent.mm.plugin.report.service.h.OAn.p(1200L, 101L, 1L);
    AppMethodBeat.o(82527);
  }
  
  public static final void iwK()
  {
    AppMethodBeat.i(82528);
    com.tencent.mm.plugin.report.service.h.OAn.p(1200L, 102L, 1L);
    AppMethodBeat.o(82528);
  }
  
  public static final void nl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175657);
    q(0L, paramInt1, paramInt2);
    AppMethodBeat.o(175657);
  }
  
  public static final void nm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175659);
    q(2L, paramInt1, paramInt2);
    AppMethodBeat.o(175659);
  }
  
  public static final void nn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175660);
    q(6L, paramInt1, paramInt2);
    AppMethodBeat.o(175660);
  }
  
  private static final void q(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(175668);
    com.tencent.mm.plugin.report.service.h.OAn.p(1281L, paramLong1, paramLong2);
    switch (paramInt)
    {
    default: 
      com.tencent.mm.plugin.report.service.h.OAn.p(1287L, paramLong1, paramLong2);
    }
    for (;;)
    {
      Log.v("MicroMsg.WebViewPerformanceReporter", "reportByScene scene = " + paramInt + ", key = " + paramLong1 + ", value = " + paramLong2);
      AppMethodBeat.o(175668);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(1283L, paramLong1, paramLong2);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.p(1282L, paramLong1, paramLong2);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.p(1284L, paramLong1, paramLong2);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.p(1285L, paramLong1, paramLong2);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.p(1286L, paramLong1, paramLong2);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<com.tencent.mm.plugin.brandservice.api.h>
  {
    public static final a WQW;
    
    static
    {
      AppMethodBeat.i(294709);
      WQW = new a();
      AppMethodBeat.o(294709);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.h.h
 * JD-Core Version:    0.7.0.1
 */