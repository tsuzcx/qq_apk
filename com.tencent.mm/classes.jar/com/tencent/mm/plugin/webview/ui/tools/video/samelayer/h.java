package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.video.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/IWebViewUIProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "activityLifecycleCallbacks", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "kotlin.jvm.PlatformType", "", "getContext", "()Landroid/content/Context;", "setContext", "webViewFullscreenImpl", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;", "getWebViewFullscreenImpl", "()Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;", "setWebViewFullscreenImpl", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;)V", "addFullScreenListener", "", "listener", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "addWebViewLifeCycleCallback", "callback", "exitFullScreen", "", "force", "ct", "getWebViewPluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "isInFullScreen", "onDestroy", "onKeyBoardHide", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)Lkotlin/Unit;", "onKeyBoardShow", "onPause", "onResume", "removeFullScreenListener", "removeWebViewLifeCycleCallback", "resetContext", "webviewEnterFullscreen", "view", "Landroid/view/View;", "direction", "", "webviewExitFullscreen", "plugin-webview_release"})
public final class h
  implements e
{
  private final Set<a.a> JxU;
  public b JxV;
  private final String TAG;
  public Context context;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(210697);
    this.context = paramContext;
    this.TAG = "MicroMsg.WebViewUIProxyImpl";
    this.JxU = Collections.newSetFromMap((Map)new ConcurrentHashMap());
    AppMethodBeat.o(210697);
  }
  
  private final b hX(Context paramContext)
  {
    AppMethodBeat.i(210692);
    if (this.JxV == null) {
      this.JxV = new b(paramContext);
    }
    paramContext = this.JxV;
    if (paramContext == null) {
      p.hyc();
    }
    AppMethodBeat.o(210692);
    return paramContext;
  }
  
  public final void a(com.tencent.mm.plugin.webview.ui.tools.video.c paramc)
  {
    AppMethodBeat.i(210688);
    hX(this.context).c(paramc);
    AppMethodBeat.o(210688);
  }
  
  public final void aB(View paramView, int paramInt)
  {
    AppMethodBeat.i(210694);
    hX(this.context).N(paramView, paramInt);
    AppMethodBeat.o(210694);
  }
  
  public final void b(com.tencent.mm.plugin.webview.ui.tools.video.c paramc)
  {
    AppMethodBeat.i(210687);
    hX(this.context).d(paramc);
    AppMethodBeat.o(210687);
  }
  
  public final boolean bJb()
  {
    AppMethodBeat.i(210696);
    b localb = this.JxV;
    if (localb != null)
    {
      boolean bool = localb.bJb();
      AppMethodBeat.o(210696);
      return bool;
    }
    AppMethodBeat.o(210696);
    return false;
  }
  
  public final void c(a.a parama)
  {
    try
    {
      AppMethodBeat.i(210685);
      p.h(parama, "callback");
      if (!this.JxU.contains(parama)) {
        this.JxU.add(parama);
      }
      AppMethodBeat.o(210685);
      return;
    }
    finally {}
  }
  
  public final void d(a.a parama)
  {
    try
    {
      AppMethodBeat.i(210686);
      p.h(parama, "callback");
      this.JxU.remove(parama);
      AppMethodBeat.o(210686);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy()
  {
    return null;
  }
  
  public final boolean gfl()
  {
    AppMethodBeat.i(210695);
    boolean bool = hX(this.context).zr(false);
    AppMethodBeat.o(210695);
    return bool;
  }
  
  /* Error */
  public final void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 169
    //   4: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 103	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:JxU	Ljava/util/Set;
    //   11: invokeinterface 173 1 0
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface 178 1 0
    //   23: ifeq +47 -> 70
    //   26: aload_1
    //   27: invokeinterface 182 1 0
    //   32: checkcast 184	com/tencent/luggage/xweb_ext/extendplugin/a$a
    //   35: invokeinterface 186 1 0
    //   40: goto -23 -> 17
    //   43: astore_1
    //   44: aload_0
    //   45: getfield 90	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:TAG	Ljava/lang/String;
    //   48: new 188	java/lang/StringBuilder
    //   51: dup
    //   52: ldc 190
    //   54: invokespecial 193	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: aload_1
    //   58: invokevirtual 197	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   61: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: getfield 103	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:JxU	Ljava/util/Set;
    //   74: invokeinterface 213 1 0
    //   79: aload_0
    //   80: getfield 112	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:JxV	Lcom/tencent/mm/plugin/webview/ui/tools/video/b;
    //   83: astore_1
    //   84: aload_1
    //   85: ifnull +15 -> 100
    //   88: aload_1
    //   89: invokevirtual 216	com/tencent/mm/plugin/webview/ui/tools/video/b:release	()V
    //   92: ldc 169
    //   94: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: ldc 169
    //   102: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   43	15	1	localException	Exception
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
      AppMethodBeat.i(210690);
      Iterator localIterator = this.JxU.iterator();
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).hU(0);
      }
      AppMethodBeat.o(210690);
    }
    finally {}
  }
  
  public final void onResume()
  {
    try
    {
      AppMethodBeat.i(210689);
      Iterator localIterator = this.JxU.iterator();
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).onForeground();
      }
      AppMethodBeat.o(210689);
    }
    finally {}
  }
  
  public final boolean zs(boolean paramBoolean)
  {
    AppMethodBeat.i(210693);
    if (this.JxV != null)
    {
      b localb = this.JxV;
      if (localb == null) {
        p.hyc();
      }
      if (localb.bJb()) {
        try
        {
          paramBoolean = hX(this.context).zr(paramBoolean);
          AppMethodBeat.o(210693);
          return paramBoolean;
        }
        catch (Exception localException)
        {
          Log.e(this.TAG, "exitFullScreen ex=" + localException.getMessage());
        }
      }
    }
    AppMethodBeat.o(210693);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h
 * JD-Core Version:    0.7.0.1
 */