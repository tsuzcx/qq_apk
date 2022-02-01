package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ao;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/util/WebViewControllerPreloadMrg;", "", "()V", "TAG", "", "controllers", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "stubCallbacks", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/PreloadWebViewStubCallback;", "addToCache", "", "url", "controller", "halfScreen", "", "width", "", "height", "addToCacheForReUse", "clear", "getFromCache", "reuse", "getStubFromCache", "shouldPreload", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l Xtf;
  public static final ConcurrentHashMap<String, BaseWebViewController> Xtg;
  private static final ConcurrentHashMap<String, com.tencent.mm.plugin.webview.ui.tools.widget.s> Xth;
  
  static
  {
    AppMethodBeat.i(295736);
    Xtf = new l();
    Xtg = new ConcurrentHashMap();
    Xth = new ConcurrentHashMap();
    AppMethodBeat.o(295736);
  }
  
  public static boolean bmX(String paramString)
  {
    AppMethodBeat.i(295711);
    kotlin.g.b.s.u(paramString, "url");
    if (ao.kgl())
    {
      AppMethodBeat.o(295711);
      return false;
    }
    if (Xtg.get(paramString) == null)
    {
      AppMethodBeat.o(295711);
      return true;
    }
    AppMethodBeat.o(295711);
    return false;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(295727);
    Iterator localIterator = ((Map)Xtg).entrySet().iterator();
    label124:
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (BaseWebViewController)((Map.Entry)localObject).getValue();
      if ((localObject != null) && (!((BaseWebViewController)localObject).WwD)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label124;
        }
        if (localObject != null)
        {
          MMWebView localMMWebView = ((BaseWebViewController)localObject).sMP;
          if (localMMWebView != null) {
            localMMWebView.destroy();
          }
        }
        if (localObject != null) {
          ((BaseWebViewController)localObject).onDestroy();
        }
        Log.i("MicroMsg.WebViewControllerPreloadMrg", kotlin.g.b.s.X("destroy ", str));
        break;
      }
    }
    Xtg.clear();
    Xth.clear();
    AppMethodBeat.o(295727);
  }
  
  public static BaseWebViewController dN(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(295703);
    kotlin.g.b.s.u(paramString, "url");
    if (paramBoolean)
    {
      paramString = (BaseWebViewController)Xtg.get(paramString);
      AppMethodBeat.o(295703);
      return paramString;
    }
    paramString = (BaseWebViewController)Xtg.remove(paramString);
    AppMethodBeat.o(295703);
    return paramString;
  }
  
  public static com.tencent.mm.plugin.webview.ui.tools.widget.s dO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(295708);
    kotlin.g.b.s.u(paramString, "url");
    if (paramBoolean)
    {
      paramString = (com.tencent.mm.plugin.webview.ui.tools.widget.s)Xth.get(paramString);
      AppMethodBeat.o(295708);
      return paramString;
    }
    paramString = (com.tencent.mm.plugin.webview.ui.tools.widget.s)Xth.remove(paramString);
    AppMethodBeat.o(295708);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/util/WebViewControllerPreloadMrg$addToCache$1$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onBinded", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends com.tencent.mm.plugin.webview.core.l
  {
    a(BaseWebViewController paramBaseWebViewController, String paramString) {}
    
    public final void cxX()
    {
      AppMethodBeat.i(295761);
      try
      {
        com.tencent.mm.plugin.webview.ui.tools.widget.s locals = new com.tencent.mm.plugin.webview.ui.tools.widget.s(new WeakReference(this.Xti));
        ((Map)l.iCV()).put(this.mrs, locals);
        Object localObject = this.Xti.getJsapi();
        if (localObject != null) {
          ((j)localObject).WDH = ((f)locals);
        }
        localObject = this.Xti.irJ();
        if (localObject != null) {
          ((e)localObject).a((f)locals, this.Xti.irL());
        }
      }
      finally
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.WebViewControllerPreloadMrg", localThrowable, "addToCache exception", new Object[0]);
        }
      }
      this.Xti.b((com.tencent.mm.plugin.webview.core.l)this);
      AppMethodBeat.o(295761);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.l
 * JD-Core Version:    0.7.0.1
 */