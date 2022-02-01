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
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.n.d;
import kotlin.n.n;
import kotlin.o;
import kotlin.t;
import org.apache.commons.a.e;
import org.apache.commons.b.f;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "()V", "createTime", "", "getCreateTime", "()J", "setCreateTime", "(J)V", "<set-?>", "Ljava/util/HashMap;", "", "headers", "getHeaders", "()Ljava/util/HashMap;", "initUrl", "getInitUrl", "()Ljava/lang/String;", "setInitUrl", "(Ljava/lang/String;)V", "invokerReused", "", "getInvokerReused", "()Z", "setInvokerReused", "(Z)V", "isTemplate", "setTemplate", "openArticleScene", "", "getOpenArticleScene", "()I", "setOpenArticleScene", "(I)V", "preAuthInfo", "", "getPreAuthInfo", "()[[Ljava/lang/String;", "setPreAuthInfo", "([[Ljava/lang/String;)V", "[[Ljava/lang/String;", "preauth", "getPreauth", "setPreauth", "predns", "getPredns", "setPredns", "prefetch", "getPrefetch", "setPrefetch", "Ljava/util/LinkedList;", "prefetchCSS", "getPrefetchCSS", "()Ljava/util/LinkedList;", "prefetchJS", "getPrefetchJS", "startActivity", "getStartActivity", "setStartActivity", "templateUpdateDataTime", "getTemplateUpdateDataTime", "setTemplateUpdateDataTime", "fetchDocumentTime", "", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "callback", "Lkotlin/Function0;", "formatPerformanceInfo", "performanceInfo", "", "Lkotlin/Pair;", "onCreate", "print", "titles", "data", "webview", "Lcom/tencent/xweb/WebView;", "printPerformance", "openScene", "fromScene", "Companion", "webview-sdk_release"})
public final class j
  extends r
{
  public static final a JBQ;
  private static final String TAG = "MicroMsg.WebViewPerformanceHelper";
  public String ISo;
  public String[][] JBI;
  public boolean JBJ;
  public long JBK;
  public boolean JBL;
  public LinkedList<String> JBM;
  public LinkedList<String> JBN;
  public HashMap<String, String> JBO;
  public long JBP;
  public boolean Jct;
  public boolean Jcu;
  public boolean Jcv;
  public int Jis;
  public long createTime;
  
  static
  {
    AppMethodBeat.i(82764);
    JBQ = new a((byte)0);
    TAG = "MicroMsg.WebViewPerformanceHelper";
    AppMethodBeat.o(82764);
  }
  
  public j()
  {
    AppMethodBeat.i(82763);
    this.JBM = new LinkedList();
    this.JBN = new LinkedList();
    this.JBO = new HashMap();
    this.ISo = "";
    AppMethodBeat.o(82763);
  }
  
  public static void a(String paramString1, String paramString2, WebView paramWebView, List<o<String, String>> paramList)
  {
    AppMethodBeat.i(82761);
    p.h(paramString1, "titles");
    p.h(paramString2, "data");
    p.h(paramWebView, "webview");
    if (com.tencent.mm.plugin.webview.d.l.gbo())
    {
      Object localObject = MMApplicationContext.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      localObject = e.toByteArray(((Context)localObject).getAssets().open("jsapi/vconsole_performance.js"));
      p.g(localObject, "IOUtils.toByteArray(MMAp…console_performance.js\"))");
      paramWebView.evaluateJavascript(n.by(n.by(n.by(new String((byte[])localObject, d.UTF_8), "$WF_DATAS$", paramString2), "$WF_TITLES$", paramString1), "$WF_LOG$", im(paramList)), null);
    }
    AppMethodBeat.o(82761);
  }
  
  private static String im(List<o<String, String>> paramList)
  {
    AppMethodBeat.i(82762);
    if (paramList != null)
    {
      Object localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (o)((Iterator)localObject1).next();
        String str = (String)((o)localObject2).first;
        localObject2 = (String)((o)localObject2).second;
        paramList.add("{k:'" + str + "', v:'" + n.j((String)localObject2, "'", "\\'", false) + "'}");
      }
      localObject1 = kotlin.a.j.a((Iterable)paramList, (CharSequence)",", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56);
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
  
  public final void giI()
  {
    AppMethodBeat.i(82760);
    if ((this.JTb == null) || (this.JTb.isEmpty()))
    {
      AppMethodBeat.o(82760);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.JTb.iterator();
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
    this.JTb.clear();
    AppMethodBeat.o(82760);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper$Companion;", "", "()V", "TAG", "", "webview-sdk_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "s", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
  public static final class b<T>
    implements ValueCallback<String>
  {
    public b(j paramj, a parama) {}
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
    public static final class a
      implements MessageQueue.IdleHandler
    {
      public a(j.b paramb, String paramString) {}
      
      public final boolean queueIdle()
      {
        AppMethodBeat.i(225175);
        Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
        long l = System.currentTimeMillis();
        int i;
        try
        {
          Object localObject1 = this.JBT;
          p.g(localObject1, "s");
          i = this.JBT.length();
          if (localObject1 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(225175);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          Log.w(j.access$getTAG$cp(), "fetchDocumentTime ex: %s", new Object[] { localException.getMessage() });
        }
        for (;;)
        {
          this.JBS.JBR.giI();
          Log.v(j.access$getTAG$cp(), "onReceiveValue cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(225175);
          return false;
          Object localObject2 = localException.substring(1, i - 1);
          p.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          localObject2 = new JSONObject(f.bvh((String)localObject2));
          Iterator localIterator1 = ((JSONObject)localObject2).keys();
          p.g(localIterator1, "keys()");
          while (localIterator1.hasNext())
          {
            JSONObject localJSONObject = ((JSONObject)localObject2).optJSONObject((String)localIterator1.next());
            Iterator localIterator2 = localJSONObject.keys();
            p.g(localIterator2, "keys()");
            while (localIterator2.hasNext())
            {
              String str = (String)localIterator2.next();
              this.JBS.JBR.bN(str, localJSONObject.optLong(str));
            }
          }
          this.JBS.ihE.invoke();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.j
 * JD-Core Version:    0.7.0.1
 */