package com.tencent.mm.plugin.webview.ui.tools.d.a;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.k.a.a.a;
import com.tencent.luggage.k.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.d.a;
import com.tencent.mm.plugin.webview.ui.tools.d.b;
import d.g.b.k;
import d.l;
import java.util.HashSet;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/IWebViewUIProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "activityLifecycleCallbacks", "Ljava/util/HashSet;", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "Lkotlin/collections/HashSet;", "getContext", "()Landroid/content/Context;", "webViewFullscreenImpl", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;", "getWebViewFullscreenImpl", "()Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;", "setWebViewFullscreenImpl", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;)V", "addFullScreenListener", "", "listener", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "addWebViewLifeCycleCallback", "callback", "exitFullScreen", "", "ct", "getWebViewPluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "isInFullScreen", "onDestroy", "onPause", "onResume", "removeFullScreenListener", "removeWebViewLifeCycleCallback", "webviewEnterFullscreen", "view", "Landroid/view/View;", "direction", "", "webviewExitFullscreen", "plugin-webview_release"})
public final class h
  implements e
{
  private final HashSet<a.a> BtH;
  public a BtI;
  private final String TAG;
  public final Context context;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(188960);
    this.context = paramContext;
    this.TAG = "MicroMsg.WebViewUIProxyImpl";
    this.BtH = new HashSet();
    AppMethodBeat.o(188960);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(188953);
    gG(this.context).c(paramb);
    AppMethodBeat.o(188953);
  }
  
  public final void at(View paramView, int paramInt)
  {
    AppMethodBeat.i(188958);
    gG(this.context).O(paramView, paramInt);
    AppMethodBeat.o(188958);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(188952);
    gG(this.context).d(paramb);
    AppMethodBeat.o(188952);
  }
  
  public final void c(a.a parama)
  {
    try
    {
      AppMethodBeat.i(188950);
      k.h(parama, "callback");
      this.BtH.add(parama);
      AppMethodBeat.o(188950);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void d(a.a parama)
  {
    try
    {
      AppMethodBeat.i(188951);
      k.h(parama, "callback");
      this.BtH.remove(parama);
      AppMethodBeat.o(188951);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final boolean eop()
  {
    AppMethodBeat.i(188959);
    boolean bool = gG(this.context).aNT();
    AppMethodBeat.o(188959);
    return bool;
  }
  
  public final a gG(Context paramContext)
  {
    AppMethodBeat.i(188957);
    if (this.BtI == null) {
      this.BtI = new a(paramContext);
    }
    paramContext = this.BtI;
    if (paramContext == null) {
      k.fvU();
    }
    AppMethodBeat.o(188957);
    return paramContext;
  }
  
  public final c getWebViewPluginClientProxy()
  {
    return null;
  }
  
  public final void onDestroy()
  {
    try
    {
      AppMethodBeat.i(188956);
      Iterator localIterator = this.BtH.iterator();
      k.g(localIterator, "activityLifecycleCallbacks.iterator()");
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).onDestroy();
      }
      this.BtH.clear();
    }
    finally {}
    a locala = this.BtI;
    if (locala != null)
    {
      locala.release();
      AppMethodBeat.o(188956);
    }
    for (;;)
    {
      return;
      AppMethodBeat.o(188956);
    }
  }
  
  public final void onPause()
  {
    try
    {
      AppMethodBeat.i(188955);
      Iterator localIterator = this.BtH.iterator();
      k.g(localIterator, "activityLifecycleCallbacks.iterator()");
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).gP(0);
      }
      AppMethodBeat.o(188955);
    }
    finally {}
  }
  
  public final void onResume()
  {
    try
    {
      AppMethodBeat.i(188954);
      Iterator localIterator = this.BtH.iterator();
      k.g(localIterator, "activityLifecycleCallbacks.iterator()");
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).onForeground();
      }
      AppMethodBeat.o(188954);
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.d.a.h
 * JD-Core Version:    0.7.0.1
 */