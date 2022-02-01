package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.video.b;
import d.g.b.p;
import d.l;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/IWebViewUIProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "activityLifecycleCallbacks", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "kotlin.jvm.PlatformType", "", "getContext", "()Landroid/content/Context;", "webViewFullscreenImpl", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;", "getWebViewFullscreenImpl", "()Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;", "setWebViewFullscreenImpl", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;)V", "addFullScreenListener", "", "listener", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "addWebViewLifeCycleCallback", "callback", "exitFullScreen", "", "ct", "getWebViewPluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "isInFullScreen", "onDestroy", "onPause", "onResume", "removeFullScreenListener", "removeWebViewLifeCycleCallback", "webviewEnterFullscreen", "view", "Landroid/view/View;", "direction", "", "webviewExitFullscreen", "plugin-webview_release"})
public final class h
  implements e
{
  private final Set<a.a> EIf;
  private b EIg;
  private final String TAG;
  private final Context context;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(199474);
    this.context = paramContext;
    this.TAG = "MicroMsg.WebViewUIProxyImpl";
    this.EIf = Collections.newSetFromMap((Map)new ConcurrentHashMap());
    AppMethodBeat.o(199474);
  }
  
  private final b hc(Context paramContext)
  {
    AppMethodBeat.i(199469);
    if (this.EIg == null) {
      this.EIg = new b(paramContext);
    }
    paramContext = this.EIg;
    if (paramContext == null) {
      p.gkB();
    }
    AppMethodBeat.o(199469);
    return paramContext;
  }
  
  public final void a(com.tencent.mm.plugin.webview.ui.tools.video.c paramc)
  {
    AppMethodBeat.i(199465);
    hc(this.context).c(paramc);
    AppMethodBeat.o(199465);
  }
  
  public final void aw(View paramView, int paramInt)
  {
    AppMethodBeat.i(199471);
    hc(this.context).O(paramView, paramInt);
    AppMethodBeat.o(199471);
  }
  
  public final void b(com.tencent.mm.plugin.webview.ui.tools.video.c paramc)
  {
    AppMethodBeat.i(199464);
    hc(this.context).d(paramc);
    AppMethodBeat.o(199464);
  }
  
  public final boolean bnx()
  {
    AppMethodBeat.i(199473);
    b localb = this.EIg;
    if (localb != null)
    {
      boolean bool = localb.bnx();
      AppMethodBeat.o(199473);
      return bool;
    }
    AppMethodBeat.o(199473);
    return false;
  }
  
  public final void c(a.a parama)
  {
    try
    {
      AppMethodBeat.i(199462);
      p.h(parama, "callback");
      if (!this.EIf.contains(parama)) {
        this.EIf.add(parama);
      }
      AppMethodBeat.o(199462);
      return;
    }
    finally {}
  }
  
  public final void d(a.a parama)
  {
    try
    {
      AppMethodBeat.i(199463);
      p.h(parama, "callback");
      this.EIf.remove(parama);
      AppMethodBeat.o(199463);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final boolean eWo()
  {
    AppMethodBeat.i(199472);
    boolean bool = hc(this.context).aYo();
    AppMethodBeat.o(199472);
    return bool;
  }
  
  public final boolean eYX()
  {
    AppMethodBeat.i(199470);
    if (this.EIg != null)
    {
      b localb = this.EIg;
      if (localb == null) {
        p.gkB();
      }
      if (localb.bnx())
      {
        boolean bool = hc(this.context).aYo();
        AppMethodBeat.o(199470);
        return bool;
      }
    }
    AppMethodBeat.o(199470);
    return false;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy()
  {
    return null;
  }
  
  /* Error */
  public final void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 162
    //   4: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 95	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:EIf	Ljava/util/Set;
    //   11: invokeinterface 166 1 0
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface 171 1 0
    //   23: ifeq +47 -> 70
    //   26: aload_1
    //   27: invokeinterface 175 1 0
    //   32: checkcast 177	com/tencent/luggage/xweb_ext/extendplugin/a$a
    //   35: invokeinterface 179 1 0
    //   40: goto -23 -> 17
    //   43: astore_1
    //   44: aload_0
    //   45: getfield 82	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:TAG	Ljava/lang/String;
    //   48: new 181	java/lang/StringBuilder
    //   51: dup
    //   52: ldc 183
    //   54: invokespecial 186	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: aload_1
    //   58: invokevirtual 190	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   61: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 203	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: getfield 95	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:EIf	Ljava/util/Set;
    //   74: invokeinterface 206 1 0
    //   79: aload_0
    //   80: getfield 104	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:EIg	Lcom/tencent/mm/plugin/webview/ui/tools/video/b;
    //   83: astore_1
    //   84: aload_1
    //   85: ifnull +15 -> 100
    //   88: aload_1
    //   89: invokevirtual 209	com/tencent/mm/plugin/webview/ui/tools/video/b:release	()V
    //   92: ldc 162
    //   94: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: ldc 162
    //   102: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: goto -8 -> 97
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	h
    //   16	11	1	localIterator	Iterator
    //   43	15	1	localException	java.lang.Exception
    //   83	6	1	localb	b
    //   108	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	17	43	java/lang/Exception
    //   17	40	43	java/lang/Exception
    //   2	7	108	finally
    //   7	17	108	finally
    //   17	40	108	finally
    //   44	70	108	finally
    //   70	84	108	finally
    //   88	97	108	finally
    //   100	105	108	finally
  }
  
  public final void onPause()
  {
    try
    {
      AppMethodBeat.i(199467);
      Iterator localIterator = this.EIf.iterator();
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).gF(0);
      }
      AppMethodBeat.o(199467);
    }
    finally {}
  }
  
  public final void onResume()
  {
    try
    {
      AppMethodBeat.i(199466);
      Iterator localIterator = this.EIf.iterator();
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).onForeground();
      }
      AppMethodBeat.o(199466);
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h
 * JD-Core Version:    0.7.0.1
 */