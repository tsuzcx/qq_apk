package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.pluginsdk.r.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lkotlin.o<Ljava.lang.String;Ljava.lang.String;>;>;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.o;
import kotlin.t;
import org.apache.commons.b.f;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "()V", "createTime", "", "getCreateTime", "()J", "setCreateTime", "(J)V", "<set-?>", "Ljava/util/HashMap;", "", "headers", "getHeaders", "()Ljava/util/HashMap;", "initUrl", "getInitUrl", "()Ljava/lang/String;", "setInitUrl", "(Ljava/lang/String;)V", "invokerReused", "", "getInvokerReused", "()Z", "setInvokerReused", "(Z)V", "isTemplate", "setTemplate", "openArticleScene", "", "getOpenArticleScene", "()I", "setOpenArticleScene", "(I)V", "preAuthInfo", "", "getPreAuthInfo", "()[[Ljava/lang/String;", "setPreAuthInfo", "([[Ljava/lang/String;)V", "[[Ljava/lang/String;", "preauth", "getPreauth", "setPreauth", "predns", "getPredns", "setPredns", "prefetch", "getPrefetch", "setPrefetch", "Ljava/util/LinkedList;", "prefetchCSS", "getPrefetchCSS", "()Ljava/util/LinkedList;", "prefetchJS", "getPrefetchJS", "startActivity", "getStartActivity", "setStartActivity", "templateUpdateDataTime", "getTemplateUpdateDataTime", "setTemplateUpdateDataTime", "fetchDocumentTime", "", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "callback", "Lkotlin/Function0;", "formatPerformanceInfo", "performanceInfo", "", "Lkotlin/Pair;", "onCreate", "print", "titles", "data", "webview", "Lcom/tencent/xweb/WebView;", "printPerformance", "openScene", "fromScene", "Companion", "webview-sdk_release"})
public final class n
  extends r
{
  public static final a QAy;
  private static final String TAG = "MicroMsg.WebViewPerformanceHelper";
  public String POG;
  public boolean PZb;
  public boolean PZc;
  public boolean PZd;
  public String[][] QAq;
  public boolean QAr;
  public long QAs;
  public boolean QAt;
  public LinkedList<String> QAu;
  public LinkedList<String> QAv;
  public HashMap<String, String> QAw;
  public long QAx;
  public int Qfr;
  public long createTime;
  
  static
  {
    AppMethodBeat.i(82764);
    QAy = new a((byte)0);
    TAG = "MicroMsg.WebViewPerformanceHelper";
    AppMethodBeat.o(82764);
  }
  
  public n()
  {
    AppMethodBeat.i(82763);
    this.QAu = new LinkedList();
    this.QAv = new LinkedList();
    this.QAw = new HashMap();
    this.POG = "";
    AppMethodBeat.o(82763);
  }
  
  public static void a(String paramString1, String paramString2, WebView paramWebView, List<o<String, String>> paramList)
  {
    AppMethodBeat.i(82761);
    p.k(paramString1, "titles");
    p.k(paramString2, "data");
    p.k(paramWebView, "webview");
    if (com.tencent.mm.plugin.webview.d.l.gUi())
    {
      Object localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = org.apache.commons.a.d.toByteArray(((Context)localObject).getAssets().open("jsapi/vconsole_performance.js"));
      p.j(localObject, "IOUtils.toByteArray(MMAp…console_performance.js\"))");
      paramWebView.evaluateJavascript(kotlin.n.n.bx(kotlin.n.n.bx(kotlin.n.n.bx(new String((byte[])localObject, kotlin.n.d.UTF_8), "$WF_DATAS$", paramString2), "$WF_TITLES$", paramString1), "$WF_LOG$", jd(paramList)), null);
    }
    AppMethodBeat.o(82761);
  }
  
  private static String jd(List<o<String, String>> paramList)
  {
    AppMethodBeat.i(82762);
    if (paramList != null)
    {
      Object localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (o)((Iterator)localObject1).next();
        String str = (String)((o)localObject2).Mx;
        localObject2 = (String)((o)localObject2).My;
        paramList.add("{k:'" + str + "', v:'" + kotlin.n.n.l((String)localObject2, "'", "\\'", false) + "'}");
      }
      localObject1 = j.a((Iterable)paramList, (CharSequence)",", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56);
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
  
  public final void hcs()
  {
    AppMethodBeat.i(82760);
    if ((this.QSg == null) || (this.QSg.isEmpty()))
    {
      AppMethodBeat.o(82760);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.QSg.iterator();
    while (localIterator.hasNext())
    {
      r.a locala = (r.a)localIterator.next();
      localStringBuilder.append("[");
      localStringBuilder.append(locala.key);
      localStringBuilder.append(": ");
      localStringBuilder.append(locala.time);
      if (locala.time > this.createTime) {
        localStringBuilder.append(", ").append(locala.time - this.createTime);
      }
      if (!Util.isNullOrNil(locala.detail)) {
        localStringBuilder.append(", ").append(locala.detail);
      }
      localStringBuilder.append("] ");
    }
    Log.i(TAG, "webview Performance: %s", new Object[] { localStringBuilder.toString() });
    this.QSg.clear();
    AppMethodBeat.o(82760);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper$Companion;", "", "()V", "TAG", "", "webview-sdk_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "s", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
  public static final class b<T>
    implements ValueCallback<String>
  {
    public b(n paramn, a parama) {}
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
    public static final class a
      implements MessageQueue.IdleHandler
    {
      public a(n.b paramb, String paramString) {}
      
      public final boolean queueIdle()
      {
        AppMethodBeat.i(205196);
        Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
        long l = System.currentTimeMillis();
        int i;
        try
        {
          Object localObject1 = this.QAB;
          p.j(localObject1, "s");
          i = this.QAB.length();
          if (localObject1 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(205196);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          Log.w(n.access$getTAG$cp(), "fetchDocumentTime ex: %s", new Object[] { localException.getMessage() });
        }
        for (;;)
        {
          this.QAA.QAz.hcs();
          Log.v(n.access$getTAG$cp(), "onReceiveValue cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(205196);
          return false;
          Object localObject2 = localException.substring(1, i - 1);
          p.j(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          localObject2 = new JSONObject(f.bIl((String)localObject2));
          Iterator localIterator1 = ((JSONObject)localObject2).keys();
          p.j(localIterator1, "keys()");
          while (localIterator1.hasNext())
          {
            JSONObject localJSONObject = ((JSONObject)localObject2).optJSONObject((String)localIterator1.next());
            Iterator localIterator2 = localJSONObject.keys();
            p.j(localIterator2, "keys()");
            while (localIterator2.hasNext())
            {
              String str = (String)localIterator2.next();
              this.QAA.QAz.bU(str, localJSONObject.optLong(str));
            }
          }
          this.QAA.kWs.invoke();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.n
 * JD-Core Version:    0.7.0.1
 */