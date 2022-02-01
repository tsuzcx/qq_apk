package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.s.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.a;
import org.apache.commons.c.h;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "()V", "createTime", "", "getCreateTime", "()J", "setCreateTime", "(J)V", "<set-?>", "Ljava/util/HashMap;", "", "headers", "getHeaders", "()Ljava/util/HashMap;", "initUrl", "getInitUrl", "()Ljava/lang/String;", "setInitUrl", "(Ljava/lang/String;)V", "invokerReused", "", "getInvokerReused", "()Z", "setInvokerReused", "(Z)V", "isTemplate", "setTemplate", "openArticleScene", "", "getOpenArticleScene", "()I", "setOpenArticleScene", "(I)V", "preAuthInfo", "", "getPreAuthInfo", "()[[Ljava/lang/String;", "setPreAuthInfo", "([[Ljava/lang/String;)V", "[[Ljava/lang/String;", "preauth", "getPreauth", "setPreauth", "predns", "getPredns", "setPredns", "prefetch", "getPrefetch", "setPrefetch", "Ljava/util/LinkedList;", "prefetchCSS", "getPrefetchCSS", "()Ljava/util/LinkedList;", "prefetchJS", "getPrefetchJS", "startActivity", "getStartActivity", "setStartActivity", "templateUpdateDataTime", "getTemplateUpdateDataTime", "setTemplateUpdateDataTime", "fetchDocumentTime", "", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "callback", "Lkotlin/Function0;", "formatPerformanceInfo", "performanceInfo", "", "Lkotlin/Pair;", "onCreate", "print", "titles", "data", "webview", "Lcom/tencent/xweb/WebView;", "printPerformance", "openScene", "fromScene", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends com.tencent.mm.pluginsdk.s
{
  private static final String TAG;
  public static final a Xtx;
  public String WET;
  public boolean WPF;
  public boolean WPG;
  public boolean WPH;
  public int WXq;
  public long XtA;
  public boolean XtB;
  public LinkedList<String> XtC;
  public LinkedList<String> XtD;
  public HashMap<String, String> XtE;
  public long XtF;
  public String[][] Xty;
  public boolean Xtz;
  public long createTime;
  
  static
  {
    AppMethodBeat.i(82764);
    Xtx = new a((byte)0);
    TAG = "MicroMsg.WebViewPerformanceHelper";
    AppMethodBeat.o(82764);
  }
  
  public r()
  {
    AppMethodBeat.i(82763);
    this.XtC = new LinkedList();
    this.XtD = new LinkedList();
    this.XtE = new HashMap();
    this.WET = "";
    AppMethodBeat.o(82763);
  }
  
  private static final void a(final r paramr, final a parama, String paramString)
  {
    AppMethodBeat.i(295709);
    kotlin.g.b.s.u(paramr, "this$0");
    kotlin.g.b.s.u(parama, "$callback");
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new b(paramString, paramr, parama));
    AppMethodBeat.o(295709);
  }
  
  public static void a(String paramString1, String paramString2, WebView paramWebView, List<kotlin.r<String, String>> paramList)
  {
    AppMethodBeat.i(82761);
    kotlin.g.b.s.u(paramString1, "titles");
    kotlin.g.b.s.u(paramString2, "data");
    kotlin.g.b.s.u(paramWebView, "webview");
    if (com.tencent.mm.plugin.webview.jsapi.n.itP())
    {
      byte[] arrayOfByte = org.apache.commons.b.d.toByteArray(MMApplicationContext.getContext().getAssets().open("jsapi/vconsole_performance.js"));
      kotlin.g.b.s.s(arrayOfByte, "toByteArray(MMApplicatio…console_performance.js\"))");
      paramWebView.evaluateJavascript(kotlin.n.n.bW(kotlin.n.n.bW(kotlin.n.n.bW(new String(arrayOfByte, kotlin.n.d.UTF_8), "$WF_DATAS$", paramString2), "$WF_TITLES$", paramString1), "$WF_LOG$", mm(paramList)), null);
    }
    AppMethodBeat.o(82761);
  }
  
  private static String mm(List<kotlin.r<String, String>> paramList)
  {
    AppMethodBeat.i(82762);
    if (paramList == null)
    {
      AppMethodBeat.o(82762);
      return "[]";
    }
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (kotlin.r)((Iterator)localObject1).next();
      String str = (String)((kotlin.r)localObject2).bsC;
      localObject2 = (String)((kotlin.r)localObject2).bsD;
      paramList.add("{k:'" + str + "', v:'" + kotlin.n.n.bV((String)localObject2, "'", "\\'") + "'}");
    }
    paramList = p.a((Iterable)paramList, (CharSequence)",", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56);
    if (paramList == null)
    {
      AppMethodBeat.o(82762);
      return "[]";
    }
    AppMethodBeat.o(82762);
    return paramList;
  }
  
  public final void a(MMWebView paramMMWebView, a<ah> parama)
  {
    AppMethodBeat.i(295728);
    kotlin.g.b.s.u(paramMMWebView, "webView");
    kotlin.g.b.s.u(parama, "callback");
    paramMMWebView.evaluateJavascript("JSON.stringify(Object.assign({timing: performance && performance.timing}, {paint:{'firstContentfulPaint':(function(p){return p[0] && parseInt(p[0].startTime + performance.timeOrigin)})(performance.getEntriesByName('first-contentful-paint'))}}))", new r..ExternalSyntheticLambda0(this, parama));
    AppMethodBeat.o(295728);
  }
  
  public final void iCW()
  {
    AppMethodBeat.i(82760);
    if ((this.XNX == null) || (this.XNX.isEmpty()))
    {
      AppMethodBeat.o(82760);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.XNX.iterator();
    while (localIterator.hasNext())
    {
      s.a locala = (s.a)localIterator.next();
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
    this.XNX.clear();
    AppMethodBeat.o(82760);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper$Companion;", "", "()V", "TAG", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements MessageQueue.IdleHandler
  {
    public b(String paramString, r paramr, a parama) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(295729);
      Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
      long l = System.currentTimeMillis();
      int i;
      try
      {
        kotlin.g.b.s.s(this.XtG, "s");
        Object localObject1 = this.XtG;
        i = this.XtG.length();
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(295729);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        Log.w(r.access$getTAG$cp(), "fetchDocumentTime ex: %s", new Object[] { localException.getMessage() });
      }
      for (;;)
      {
        paramr.iCW();
        Log.v(r.access$getTAG$cp(), "onReceiveValue cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(295729);
        return false;
        Object localObject2 = localException.substring(1, i - 1);
        kotlin.g.b.s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject2 = new JSONObject(h.bLf((String)localObject2));
        Iterator localIterator1 = ((JSONObject)localObject2).keys();
        kotlin.g.b.s.s(localIterator1, "keys()");
        while (localIterator1.hasNext())
        {
          JSONObject localJSONObject = ((JSONObject)localObject2).optJSONObject((String)localIterator1.next());
          Iterator localIterator2 = localJSONObject.keys();
          kotlin.g.b.s.s(localIterator2, "keys()");
          while (localIterator2.hasNext())
          {
            String str = (String)localIterator2.next();
            paramr.cf(str, localJSONObject.optLong(str));
          }
        }
        parama.invoke();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.r
 * JD-Core Version:    0.7.0.1
 */