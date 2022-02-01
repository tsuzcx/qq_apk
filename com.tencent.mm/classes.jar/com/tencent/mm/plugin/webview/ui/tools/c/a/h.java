package com.tencent.mm.plugin.webview.ui.tools.c.a;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.k.a.a.a;
import com.tencent.luggage.k.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.c.a;
import com.tencent.mm.plugin.webview.ui.tools.c.b;
import d.g.b.k;
import d.l;
import java.util.HashSet;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/IWebViewUIProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "activityLifecycleCallbacks", "Ljava/util/HashSet;", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "Lkotlin/collections/HashSet;", "getContext", "()Landroid/content/Context;", "webViewFullscreenImpl", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;", "getWebViewFullscreenImpl", "()Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;", "setWebViewFullscreenImpl", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;)V", "addFullScreenListener", "", "listener", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "addWebViewLifeCycleCallback", "callback", "exitFullScreen", "", "ct", "getWebViewPluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "isInFullScreen", "onDestroy", "onPause", "onResume", "removeFullScreenListener", "removeWebViewLifeCycleCallback", "webviewEnterFullscreen", "view", "Landroid/view/View;", "direction", "", "webviewExitFullscreen", "plugin-webview_release"})
public final class h
  implements e
{
  private final HashSet<a.a> CLQ;
  public a CLS;
  private final String TAG;
  public final Context context;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(189543);
    this.context = paramContext;
    this.TAG = "MicroMsg.WebViewUIProxyImpl";
    this.CLQ = new HashSet();
    AppMethodBeat.o(189543);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(189536);
    gR(this.context).c(paramb);
    AppMethodBeat.o(189536);
  }
  
  public final void av(View paramView, int paramInt)
  {
    AppMethodBeat.i(189541);
    gR(this.context).O(paramView, paramInt);
    AppMethodBeat.o(189541);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(189535);
    gR(this.context).d(paramb);
    AppMethodBeat.o(189535);
  }
  
  public final void c(a.a parama)
  {
    try
    {
      AppMethodBeat.i(189533);
      k.h(parama, "callback");
      this.CLQ.add(parama);
      AppMethodBeat.o(189533);
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
      AppMethodBeat.i(189534);
      k.h(parama, "callback");
      this.CLQ.remove(parama);
      AppMethodBeat.o(189534);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final boolean eDK()
  {
    AppMethodBeat.i(189542);
    boolean bool = gR(this.context).aUJ();
    AppMethodBeat.o(189542);
    return bool;
  }
  
  public final a gR(Context paramContext)
  {
    AppMethodBeat.i(189540);
    if (this.CLS == null) {
      this.CLS = new a(paramContext);
    }
    paramContext = this.CLS;
    if (paramContext == null) {
      k.fOy();
    }
    AppMethodBeat.o(189540);
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
      AppMethodBeat.i(189539);
      Iterator localIterator = this.CLQ.iterator();
      k.g(localIterator, "activityLifecycleCallbacks.iterator()");
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).onDestroy();
      }
      this.CLQ.clear();
    }
    finally {}
    a locala = this.CLS;
    if (locala != null)
    {
      locala.release();
      AppMethodBeat.o(189539);
    }
    for (;;)
    {
      return;
      AppMethodBeat.o(189539);
    }
  }
  
  public final void onPause()
  {
    try
    {
      AppMethodBeat.i(189538);
      Iterator localIterator = this.CLQ.iterator();
      k.g(localIterator, "activityLifecycleCallbacks.iterator()");
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).gz(0);
      }
      AppMethodBeat.o(189538);
    }
    finally {}
  }
  
  public final void onResume()
  {
    try
    {
      AppMethodBeat.i(189537);
      Iterator localIterator = this.CLQ.iterator();
      k.g(localIterator, "activityLifecycleCallbacks.iterator()");
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).onForeground();
      }
      AppMethodBeat.o(189537);
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c.a.h
 * JD-Core Version:    0.7.0.1
 */