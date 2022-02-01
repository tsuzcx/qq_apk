package com.tencent.mm.plugin.webview.j;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.xweb.WebView;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.n.d;
import d.n.n;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Ld.o<Ljava.lang.String;Ljava.lang.String;>;>;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.apache.commons.a.e;
import org.apache.commons.b.f;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "()V", "createTime", "", "<set-?>", "Ljava/util/HashMap;", "", "headers", "getHeaders", "()Ljava/util/HashMap;", "initUrl", "getInitUrl", "()Ljava/lang/String;", "setInitUrl", "(Ljava/lang/String;)V", "invokerReused", "", "getInvokerReused", "()Z", "setInvokerReused", "(Z)V", "isTemplate", "setTemplate", "openArticleScene", "", "getOpenArticleScene", "()I", "setOpenArticleScene", "(I)V", "preAuthInfo", "", "getPreAuthInfo", "()[[Ljava/lang/String;", "setPreAuthInfo", "([[Ljava/lang/String;)V", "[[Ljava/lang/String;", "preauth", "getPreauth", "setPreauth", "predns", "getPredns", "setPredns", "prefetch", "getPrefetch", "setPrefetch", "Ljava/util/LinkedList;", "prefetchCSS", "getPrefetchCSS", "()Ljava/util/LinkedList;", "prefetchJS", "getPrefetchJS", "startActivity", "getStartActivity", "()J", "setStartActivity", "(J)V", "templateUpdateDataTime", "getTemplateUpdateDataTime", "setTemplateUpdateDataTime", "fetchDocumentTime", "", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "callback", "Lkotlin/Function0;", "formatPerformanceInfo", "performanceInfo", "", "Lkotlin/Pair;", "onCreate", "print", "titles", "data", "webview", "Lcom/tencent/xweb/WebView;", "printPerformance", "openScene", "fromScene", "Companion", "webview-sdk_release"})
public final class h
  extends q
{
  public static final a CPB;
  private static final String TAG = "MicroMsg.WebViewPerformanceHelper";
  public long CPA;
  public String[][] CPt;
  public boolean CPu;
  public long CPv;
  public boolean CPw;
  public LinkedList<String> CPx;
  public LinkedList<String> CPy;
  public HashMap<String, String> CPz;
  public String CkB;
  public boolean CtE;
  public boolean CtF;
  public boolean CtG;
  public int Czo;
  public long createTime;
  
  static
  {
    AppMethodBeat.i(82764);
    CPB = new a((byte)0);
    TAG = "MicroMsg.WebViewPerformanceHelper";
    AppMethodBeat.o(82764);
  }
  
  public h()
  {
    AppMethodBeat.i(82763);
    this.CPx = new LinkedList();
    this.CPy = new LinkedList();
    this.CPz = new HashMap();
    this.CkB = "";
    AppMethodBeat.o(82763);
  }
  
  public static void a(String paramString1, String paramString2, WebView paramWebView, List<o<String, String>> paramList)
  {
    AppMethodBeat.i(82761);
    k.h(paramString1, "titles");
    k.h(paramString2, "data");
    k.h(paramWebView, "webview");
    if (com.tencent.mm.plugin.webview.c.j.eAd())
    {
      Object localObject = ai.getContext();
      k.g(localObject, "MMApplicationContext.getContext()");
      localObject = e.toByteArray(((Context)localObject).getAssets().open("jsapi/vconsole_performance.js"));
      k.g(localObject, "IOUtils.toByteArray(MMAp…console_performance.js\"))");
      paramWebView.evaluateJavascript(n.bg(n.bg(n.bg(new String((byte[])localObject, d.UTF_8), "$WF_DATAS$", paramString2), "$WF_TITLES$", paramString1), "$WF_LOG$", gK(paramList)), null);
    }
    AppMethodBeat.o(82761);
  }
  
  private static String gK(List<o<String, String>> paramList)
  {
    AppMethodBeat.i(82762);
    if (paramList != null)
    {
      Object localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (o)((Iterator)localObject1).next();
        String str = (String)((o)localObject2).first;
        localObject2 = (String)((o)localObject2).second;
        paramList.add("{k:'" + str + "', v:'" + n.h((String)localObject2, "'", "\\'", false) + "'}");
      }
      localObject1 = d.a.j.a((Iterable)paramList, (CharSequence)",", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56);
      paramList = (List<o<String, String>>)localObject1;
      if (localObject1 != null) {}
    }
    else
    {
      paramList = "[]";
    }
    AppMethodBeat.o(82762);
    return paramList;
  }
  
  public final void eGP()
  {
    AppMethodBeat.i(82760);
    if ((this.DfI == null) || (this.DfI.isEmpty()))
    {
      AppMethodBeat.o(82760);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.DfI.iterator();
    while (localIterator.hasNext())
    {
      q.a locala = (q.a)localIterator.next();
      localStringBuilder.append("[");
      localStringBuilder.append(locala.key);
      localStringBuilder.append(": ");
      localStringBuilder.append(locala.time);
      if (locala.time > this.createTime) {
        localStringBuilder.append(", ").append(locala.time - this.createTime);
      }
      if (!bs.isNullOrNil(locala.detail)) {
        localStringBuilder.append(", ").append(locala.detail);
      }
      localStringBuilder.append("] ");
    }
    ac.i(TAG, "webview Performance: %s", new Object[] { localStringBuilder.toString() });
    this.DfI.clear();
    AppMethodBeat.o(82760);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper$Companion;", "", "()V", "TAG", "", "webview-sdk_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "s", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
  public static final class b<T>
    implements ValueCallback<String>
  {
    public b(h paramh, a parama) {}
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
    public static final class a
      implements MessageQueue.IdleHandler
    {
      public a(h.b paramb, String paramString) {}
      
      public final boolean queueIdle()
      {
        AppMethodBeat.i(205586);
        Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
        long l = System.currentTimeMillis();
        int i;
        try
        {
          Object localObject1 = this.CPE;
          k.g(localObject1, "s");
          i = this.CPE.length();
          if (localObject1 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(205586);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          ac.w(h.access$getTAG$cp(), "fetchDocumentTime ex: %s", new Object[] { localException.getMessage() });
        }
        for (;;)
        {
          this.CPD.CPC.eGP();
          ac.v(h.access$getTAG$cp(), "onReceiveValue cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(205586);
          return false;
          Object localObject2 = localException.substring(1, i - 1);
          k.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          localObject2 = new JSONObject(f.aXt((String)localObject2));
          Iterator localIterator1 = ((JSONObject)localObject2).keys();
          k.g(localIterator1, "keys()");
          while (localIterator1.hasNext())
          {
            JSONObject localJSONObject = ((JSONObject)localObject2).optJSONObject((String)localIterator1.next());
            Iterator localIterator2 = localJSONObject.keys();
            k.g(localIterator2, "keys()");
            while (localIterator2.hasNext())
            {
              String str = (String)localIterator2.next();
              this.CPD.CPC.bI(str, localJSONObject.optLong(str));
            }
          }
          this.CPD.gTu.invoke();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.h
 * JD-Core Version:    0.7.0.1
 */