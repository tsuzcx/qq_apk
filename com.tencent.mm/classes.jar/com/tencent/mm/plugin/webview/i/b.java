package com.tencent.mm.plugin.webview.i;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.a.e;
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
import kotlin.a.ae;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.ad;
import kotlin.g.b.p;
import kotlin.g.b.z.e;
import kotlin.n.n;
import kotlin.o;
import kotlin.s;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/reporter/WebViewPerformanceReporter;", "", "()V", "REPORT_ID", "", "REPORT_ID_SCENE_ALL", "REPORT_ID_SCENE_CHAT", "REPORT_ID_SCENE_MENU", "REPORT_ID_SCENE_OTHER", "REPORT_ID_SCENE_READER_COMMON", "REPORT_ID_SCENE_READER_TOP", "REPORT_ID_SCENE_SNS", "WebPrefecher", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "getWebPrefecher", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "WebPrefecher$delegate", "Lkotlin/Lazy;", "doPrintPagePerformence", "", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "webView", "Lcom/tencent/xweb/WebView;", "reportByScene", "key", "value", "scene", "", "reportCommonWebViewPerformance", "reportGetA8KeyLiteCount", "count", "reportHTTP200", "reportHTTP304", "reportHTTPOther", "reportInvokerCreate", "reportInvokerEnablePool", "reportInvokerReuse", "reportIsCssCached", "reportIsCssCachedByScene", "reportIsJsCached", "reportIsJsCachedByScene", "reportIsPageCached", "reportIsPageCachedByScene", "reportNonPrefeth", "reportPerformance", "reportPreDns", "reportPreGetA8Key", "reportPrefetchExpire", "reportPrefeth", "reportWebPrefetchCTR", "url", "", "isExposure", "", "isClick", "preGetA8Key", "preDns", "prefetch", "classifyUin", "reportWebView", "webview-sdk_release"})
public final class b
{
  private static final f JcT;
  public static final b JcU;
  
  static
  {
    AppMethodBeat.i(82530);
    JcU = new b();
    JcT = g.ah((a)a.JcV);
    AppMethodBeat.o(82530);
  }
  
  public static final void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    int i = 1;
    AppMethodBeat.i(160474);
    p.h(paramString, "url");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt).append(",");
    localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(paramString, "utf-8")).append(",");
    String str2 = ((e)JcT.getValue()).ahH(paramString);
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
      h.CyF.kvStat(18919, paramString);
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
  
  public static final void a(com.tencent.mm.plugin.webview.k.j paramj, int paramInt)
  {
    AppMethodBeat.i(175658);
    p.h(paramj, "performanceHelper");
    if (paramj.Jcu) {
      k(1L, 1L, paramInt);
    }
    AppMethodBeat.o(175658);
  }
  
  public static final void a(com.tencent.mm.plugin.webview.k.j paramj, final WebView paramWebView)
  {
    AppMethodBeat.i(82529);
    p.h(paramj, "performanceHelper");
    p.h(paramWebView, "webView");
    boolean bool1 = paramj.Jcu;
    boolean bool2 = paramj.Jcv;
    paramWebView = h.CyF;
    if (bool1) {
      paramWebView.n(1200L, 2L, 1L);
    }
    if (bool2) {
      paramWebView.n(1200L, 3L, 1L);
    }
    paramWebView = new z.e();
    paramWebView.SYF = paramj.JBP;
    Object localObject1 = e.JcZ;
    paramWebView = new f(paramj, paramWebView);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramWebView.aZN("onCreate")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aZN("onUIInitEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aZN("onWebViewCreateStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aZN("onWebViewCreateEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aZN("getA8KeyStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aZN("getA8KeyEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aZN("onTryBindServiceStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aZN("onPostBindedEnd")).append(",");
    ((StringBuilder)localObject1).append("0,0,");
    ((StringBuilder)localObject1).append(paramWebView.aZN("navigationStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aZN("domLoading")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aZN("domainLookupStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aZN("domainLookupEnd")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aZN("navigationStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aZN("firstContentfulPaint")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aZN("domContentLoadedEventStart")).append(",");
    ((StringBuilder)localObject1).append(paramWebView.aZN("loadEventStart"));
    paramWebView = ((StringBuilder)localObject1).toString();
    p.g(paramWebView, "StringBuilder().apply {\n…d())\n        }.toString()");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(com.tencent.mm.compatible.util.q.encode(paramj.ISo, "utf-8")).append(",");
    Object localObject2 = Uri.parse(paramj.ISo);
    p.g(localObject2, "Uri.parse(performanceHelper.initUrl)");
    ((StringBuilder)localObject1).append(((Uri)localObject2).getHost()).append(",");
    localObject2 = e.JcZ;
    ((StringBuilder)localObject1).append(e.zg(paramj.Jcu)).append(",");
    localObject2 = e.JcZ;
    ((StringBuilder)localObject1).append(e.zg(paramj.Jcv)).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    localObject2 = e.JcZ;
    ((StringBuilder)localObject1).append(e.zg(paramj.Jct)).append(",");
    ((StringBuilder)localObject1).append(paramj.JBM.size() + paramj.JBN.size()).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    ((StringBuilder)localObject1).append(0).append(",");
    ((StringBuilder)localObject1).append(paramWebView);
    localObject1 = ((StringBuilder)localObject1).toString();
    h.CyF.kvStat(18497, (String)localObject1);
    Log.v("MicroMsg.WebViewPerformanceReporter", "webview performance:\n".concat(String.valueOf(paramWebView)));
    a(paramj.Jis, paramj.ISo, false, true, paramj.Jcu, paramj.Jcv, paramj.Jct, 128);
    AppMethodBeat.o(82529);
  }
  
  public static final void ago(int paramInt)
  {
    AppMethodBeat.i(82521);
    h.CyF.n(1200L, 0L, paramInt);
    AppMethodBeat.o(82521);
  }
  
  public static final void agp(int paramInt)
  {
    AppMethodBeat.i(82522);
    h.CyF.n(1200L, 1L, paramInt);
    AppMethodBeat.o(82522);
  }
  
  public static final void agq(int paramInt)
  {
    AppMethodBeat.i(175661);
    k(7L, 1L, paramInt);
    AppMethodBeat.o(175661);
  }
  
  public static final void agr(int paramInt)
  {
    AppMethodBeat.i(175664);
    k(10L, 1L, paramInt);
    AppMethodBeat.o(175664);
  }
  
  public static final void ags(int paramInt)
  {
    AppMethodBeat.i(225162);
    k(3L, 1L, paramInt);
    AppMethodBeat.o(225162);
  }
  
  public static final void agt(int paramInt)
  {
    AppMethodBeat.i(225163);
    k(4L, 1L, paramInt);
    AppMethodBeat.o(225163);
  }
  
  public static final void agu(int paramInt)
  {
    AppMethodBeat.i(225164);
    k(5L, 1L, paramInt);
    AppMethodBeat.o(225164);
  }
  
  public static final void b(com.tencent.mm.plugin.webview.k.j paramj, WebView paramWebView)
  {
    int m = 4;
    int n = 2;
    int i1 = 1;
    AppMethodBeat.i(182649);
    p.h(paramj, "performanceHelper");
    p.h(paramWebView, "webView");
    Object localObject1 = c.JcX;
    localObject1 = new z.e();
    ((z.e)localObject1).SYF = paramj.JBP;
    d locald = new d(paramj, (z.e)localObject1);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2 = Uri.parse(paramj.ISo);
    p.g(localObject2, "Uri.parse(performanceHelper.initUrl)");
    localStringBuilder.append(((Uri)localObject2).getHost()).append(",");
    localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(paramj.ISo, "utf-8")).append(",");
    int i;
    int j;
    label142:
    int k;
    if (paramj.JBJ)
    {
      i = 1;
      if (!paramj.Jcu) {
        break label714;
      }
      j = 2;
      if (!paramj.JBL) {
        break label719;
      }
      k = 4;
      label152:
      localStringBuilder.append(i | j | k).append(",");
      if (!paramj.Jct) {
        break label725;
      }
      i = i1;
      label179:
      if (paramj.JBM.size() <= 0) {
        break label730;
      }
      j = n;
      label192:
      if (paramj.JBN.size() <= 0) {
        break label735;
      }
      k = m;
      label206:
      localStringBuilder.append(i | j | k).append(",");
      localObject2 = c.JcX;
      localStringBuilder.append(c.zg(paramj.Jcv)).append(",");
      localStringBuilder.append(paramj.Jis).append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(",");
      localStringBuilder.append(0).append(",");
      localStringBuilder.append(locald.aXM("pageAppear"));
      localStringBuilder.append(locald.aXM("onWebViewCreateStart"));
      localStringBuilder.append(locald.aXM("onWebViewCreateEnd"));
      localStringBuilder.append(locald.aXM("getA8KeyStart"));
      localStringBuilder.append(locald.aXM("getA8KeyEnd"));
      localStringBuilder.append(locald.aXM("clientLoadUrl"));
      localStringBuilder.append(locald.aXM("navigationStart"));
      localStringBuilder.append(locald.aXM("domainLookupStart"));
      localStringBuilder.append(locald.aXM("domainLookupEnd"));
      localStringBuilder.append(locald.aXM("connectStart"));
      localStringBuilder.append(locald.aXM("connectEnd"));
      localStringBuilder.append(locald.aXM("responseStart"));
      localStringBuilder.append(locald.aXM("responseEnd"));
      if (!paramj.JBJ) {
        break label741;
      }
    }
    label714:
    label719:
    label725:
    label730:
    label735:
    label741:
    for (localObject1 = paramj.JBK - ((z.e)localObject1).SYF + ',';; localObject1 = locald.aXM("domLoading"))
    {
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(locald.aXM("domInteractive"));
      localStringBuilder.append(locald.aXM("domContentLoadedEventStart"));
      localStringBuilder.append(locald.aXM("domContentLoadedEventEnd"));
      localStringBuilder.append(locald.aXM("loadEventStart"));
      localStringBuilder.append(locald.aXM("loadEventEnd"));
      localStringBuilder.append(locald.aXM("onTryBindServiceStart"));
      localStringBuilder.append(locald.aXM("onPostBindedEnd"));
      localStringBuilder.append(locald.aXM("onCreate"));
      localStringBuilder.append(locald.aXM("onUIInitEnd"));
      localObject1 = localStringBuilder.toString();
      p.g(localObject1, "StringBuilder().apply {\n…())\n\n        }.toString()");
      Log.i("WebViewPerformanceReporter", (String)localObject1);
      h.CyF.kvStat(19471, (String)localObject1);
      if (com.tencent.mm.plugin.webview.d.l.gbo()) {
        c(paramj, paramWebView);
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
  
  private static void c(com.tencent.mm.plugin.webview.k.j paramj, WebView paramWebView)
  {
    AppMethodBeat.i(225165);
    final long l = paramj.JBP;
    Object localObject1 = (List)new ArrayList();
    Object localObject2 = new b(paramj, l);
    ((List)localObject1).add(Long.valueOf(0L));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aZN("pageAppear")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aZN("onWebViewCreateStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aZN("onWebViewCreateEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aZN("getA8KeyStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aZN("getA8KeyEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aZN("clientLoadUrl")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aZN("navigationStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aZN("domainLookupStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aZN("domainLookupEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aZN("connectStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aZN("connectEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aZN("responseStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aZN("responseEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aZN("domLoading")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aZN("domInteractive")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aZN("onTryBindServiceStart")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aZN("onPostBindedEnd")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aZN("onCreate")));
    ((List)localObject1).add(Long.valueOf(((b)localObject2).aZN("onUIInitEnd")));
    String str1 = "[" + kotlin.a.j.a((Iterable)kotlin.a.j.b((Iterable)localObject1, 20), null, null, null, 0, null, null, 63) + ']';
    localObject1 = paramj.JBI;
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
        ((Collection)localObject2).add(s.U(localObject3[0], localObject3[1]));
        i += 1;
      }
      localObject1 = ((Collection)localObject2).toArray(new o[0]);
      if (localObject1 == null)
      {
        paramj = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(225165);
        throw paramj;
      }
      localObject1 = (o[])localObject1;
      localObject3 = new ad(10);
      ((ad)localObject3).add(s.U("section", "GetA8Key"));
      ((ad)localObject3).add(s.U("preGetA8Key", String.valueOf(paramj.Jcu)));
      ((ad)localObject3).add(s.U("preDns", String.valueOf(paramj.Jcv)));
      if (localObject1 != null) {
        break label1059;
      }
      localObject1 = new o[0];
    }
    label1059:
    for (;;)
    {
      localObject2 = localObject3;
      ((ad)localObject3).eS(localObject1);
      ((ad)localObject2).add(s.U("section", "Prefetch"));
      ((ad)localObject2).add(s.U("prefetch", String.valueOf(paramj.Jct)));
      ((ad)localObject2).add(s.U("prefetchJS", kotlin.a.j.a((Iterable)paramj.JBM, (CharSequence)"<br/>", null, null, 0, null, null, 62)));
      ((ad)localObject2).add(s.U("prefetchCSS", kotlin.a.j.a((Iterable)paramj.JBN, (CharSequence)"<br/>", null, null, 0, null, null, 62)));
      ((ad)localObject2).add(s.U("section", "Prefetch Headers"));
      localObject1 = (Map)paramj.JBO;
      paramj = (Map)new LinkedHashMap();
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
          paramj = new t("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(225165);
          throw paramj;
          localObject1 = null;
          break;
        }
        str2 = n.trim((CharSequence)str2).toString();
        if (str2 == null)
        {
          paramj = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(225165);
          throw paramj;
        }
        str2 = str2.toLowerCase();
        p.g(str2, "(this as java.lang.String).toLowerCase()");
        if (n.J(str2, "x-wx-", false)) {
          paramj.put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
        }
      }
      label975:
      paramj = ((Collection)ae.cv(paramj)).toArray(new o[0]);
      if (paramj == null)
      {
        paramj = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(225165);
        throw paramj;
      }
      ((ad)localObject2).eS(paramj);
      com.tencent.mm.plugin.webview.k.j.a("['PageAppear', 'WebView', 'GetA8key', 'ClientLoadToNavStart', 'DomainLookUp', 'ConnectStart', 'Response', 'DomLoadingToInteractive', 'Invoker', 'WebViewUICreate']", str1, paramWebView, kotlin.a.j.listOf((o[])((ad)localObject2).toArray(new o[((ad)localObject2).dtS.size()])));
      AppMethodBeat.o(225165);
      return;
    }
  }
  
  public static final void gdN()
  {
    AppMethodBeat.i(82523);
    h.CyF.n(1200L, 10L, 1L);
    AppMethodBeat.o(82523);
  }
  
  public static final void gdO()
  {
    AppMethodBeat.i(82524);
    h.CyF.n(1200L, 11L, 1L);
    AppMethodBeat.o(82524);
  }
  
  public static final void gdP()
  {
    AppMethodBeat.i(82525);
    h.CyF.n(1200L, 12L, 1L);
    AppMethodBeat.o(82525);
  }
  
  public static final void gdQ()
  {
    AppMethodBeat.i(82526);
    h.CyF.n(1200L, 100L, 1L);
    AppMethodBeat.o(82526);
  }
  
  public static final void gdR()
  {
    AppMethodBeat.i(82527);
    h.CyF.n(1200L, 101L, 1L);
    AppMethodBeat.o(82527);
  }
  
  public static final void gdS()
  {
    AppMethodBeat.i(82528);
    h.CyF.n(1200L, 102L, 1L);
    AppMethodBeat.o(82528);
  }
  
  private static final void k(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(175668);
    h.CyF.n(1281L, paramLong1, paramLong2);
    switch (paramInt)
    {
    default: 
      h.CyF.n(1287L, paramLong1, paramLong2);
    }
    for (;;)
    {
      Log.v("MicroMsg.WebViewPerformanceReporter", "reportByScene scene = " + paramInt + ", key = " + paramLong1 + ", value = " + paramLong2);
      AppMethodBeat.o(175668);
      return;
      h.CyF.n(1283L, paramLong1, paramLong2);
      continue;
      h.CyF.n(1282L, paramLong1, paramLong2);
      continue;
      h.CyF.n(1284L, paramLong1, paramLong2);
      continue;
      h.CyF.n(1285L, paramLong1, paramLong2);
      continue;
      h.CyF.n(1286L, paramLong1, paramLong2);
    }
  }
  
  public static final void ki(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175657);
    k(0L, paramInt1, paramInt2);
    AppMethodBeat.o(175657);
  }
  
  public static final void kj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175659);
    k(2L, paramInt1, paramInt2);
    AppMethodBeat.o(175659);
  }
  
  public static final void kk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175660);
    k(6L, paramInt1, paramInt2);
    AppMethodBeat.o(175660);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements a<e>
  {
    public static final a JcV;
    
    static
    {
      AppMethodBeat.i(225159);
      JcV = new a();
      AppMethodBeat.o(225159);
    }
    
    a()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"getRecord", "", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, Long>
  {
    b(com.tencent.mm.plugin.webview.k.j paramj, long paramLong)
    {
      super();
    }
    
    public final long aZN(String paramString)
    {
      AppMethodBeat.i(225161);
      p.h(paramString, "$this$getRecord");
      long l = this.JcW.bO(paramString, l) - l;
      if (l > 0L)
      {
        AppMethodBeat.o(225161);
        return l;
      }
      AppMethodBeat.o(225161);
      return 0L;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"toInt", "", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, Integer>
  {
    public static final c JcX;
    
    static
    {
      AppMethodBeat.i(182646);
      JcX = new c();
      AppMethodBeat.o(182646);
    }
    
    c()
    {
      super();
    }
    
    public static int zg(boolean paramBoolean)
    {
      if (paramBoolean) {
        return 1;
      }
      return 0;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"getRecord", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, String>
  {
    d(com.tencent.mm.plugin.webview.k.j paramj, z.e parame)
    {
      super();
    }
    
    public final String aXM(String paramString)
    {
      AppMethodBeat.i(182648);
      p.h(paramString, "$this$getRecord");
      paramString = this.JcW.bO(paramString, this.JcY.SYF) - this.JcY.SYF + ',';
      AppMethodBeat.o(182648);
      return paramString;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"toInt", "", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, Integer>
  {
    public static final e JcZ;
    
    static
    {
      AppMethodBeat.i(82518);
      JcZ = new e();
      AppMethodBeat.o(82518);
    }
    
    e()
    {
      super();
    }
    
    public static int zg(boolean paramBoolean)
    {
      if (paramBoolean) {
        return 1;
      }
      return 0;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"getRecord", "", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, Long>
  {
    f(com.tencent.mm.plugin.webview.k.j paramj, z.e parame)
    {
      super();
    }
    
    public final long aZN(String paramString)
    {
      AppMethodBeat.i(82520);
      p.h(paramString, "$this$getRecord");
      long l1 = this.JcW.bO(paramString, paramWebView.SYF);
      long l2 = paramWebView.SYF;
      AppMethodBeat.o(82520);
      return l1 - l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.i.b
 * JD-Core Version:    0.7.0.1
 */