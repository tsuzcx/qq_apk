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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/IWebViewUIProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "activityLifecycleCallbacks", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "kotlin.jvm.PlatformType", "", "getContext", "()Landroid/content/Context;", "setContext", "webViewFullscreenImpl", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;", "getWebViewFullscreenImpl", "()Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;", "setWebViewFullscreenImpl", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;)V", "addFullScreenListener", "", "listener", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "addToFloatBall", "addWebViewLifeCycleCallback", "callback", "exitFullScreen", "", "force", "ct", "getWebViewPluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "isInFullScreen", "onDestroy", "onKeyBoardHide", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)Lkotlin/Unit;", "onKeyBoardShow", "onPause", "onResume", "removeFullScreenListener", "removeWebViewLifeCycleCallback", "resetContext", "webviewEnterFullscreen", "view", "Landroid/view/View;", "direction", "", "webviewExitFullscreen", "Companion", "plugin-webview_release"})
public final class h
  implements e
{
  public static final a Qwb;
  private final Set<a.a> QvZ;
  public b Qwa;
  private final String TAG;
  private Context context;
  
  static
  {
    AppMethodBeat.i(265439);
    Qwb = new a((byte)0);
    AppMethodBeat.o(265439);
  }
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(265438);
    this.context = paramContext;
    this.TAG = "MicroMsg.WebViewUIProxyImpl";
    this.QvZ = Collections.newSetFromMap((Map)new ConcurrentHashMap());
    AppMethodBeat.o(265438);
  }
  
  private final b jc(Context paramContext)
  {
    AppMethodBeat.i(265433);
    if (this.Qwa == null) {
      this.Qwa = new b(paramContext);
    }
    paramContext = this.Qwa;
    if (paramContext == null) {
      p.iCn();
    }
    AppMethodBeat.o(265433);
    return paramContext;
  }
  
  public final boolean Dq(boolean paramBoolean)
  {
    AppMethodBeat.i(265434);
    if (this.Qwa != null)
    {
      b localb = this.Qwa;
      if (localb == null) {
        p.iCn();
      }
      if (localb.bUK()) {
        try
        {
          paramBoolean = jc(this.context).Dp(paramBoolean);
          AppMethodBeat.o(265434);
          return paramBoolean;
        }
        catch (Exception localException)
        {
          Log.e(this.TAG, "exitFullScreen ex=" + localException.getMessage());
        }
      }
    }
    AppMethodBeat.o(265434);
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.webview.ui.tools.video.c paramc)
  {
    AppMethodBeat.i(265429);
    jc(this.context).c(paramc);
    AppMethodBeat.o(265429);
  }
  
  public final void aD(Context paramContext)
  {
    AppMethodBeat.i(265423);
    p.k(paramContext, "ct");
    this.context = paramContext;
    b localb = this.Qwa;
    if (localb != null)
    {
      localb.reset(paramContext);
      AppMethodBeat.o(265423);
      return;
    }
    AppMethodBeat.o(265423);
  }
  
  public final void aG(View paramView, int paramInt)
  {
    AppMethodBeat.i(265435);
    jc(this.context).O(paramView, paramInt);
    AppMethodBeat.o(265435);
  }
  
  public final void b(com.tencent.mm.plugin.webview.ui.tools.video.c paramc)
  {
    AppMethodBeat.i(265428);
    jc(this.context).d(paramc);
    AppMethodBeat.o(265428);
  }
  
  public final boolean bUK()
  {
    AppMethodBeat.i(265437);
    b localb = this.Qwa;
    if (localb != null)
    {
      boolean bool = localb.bUK();
      AppMethodBeat.o(265437);
      return bool;
    }
    AppMethodBeat.o(265437);
    return false;
  }
  
  public final void c(a.a parama)
  {
    try
    {
      AppMethodBeat.i(265426);
      p.k(parama, "callback");
      if (!this.QvZ.contains(parama)) {
        this.QvZ.add(parama);
      }
      AppMethodBeat.o(265426);
      return;
    }
    finally {}
  }
  
  public final void d(a.a parama)
  {
    try
    {
      AppMethodBeat.i(265427);
      p.k(parama, "callback");
      this.QvZ.remove(parama);
      AppMethodBeat.o(265427);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final boolean gYv()
  {
    AppMethodBeat.i(265436);
    boolean bool = jc(this.context).Dp(false);
    AppMethodBeat.o(265436);
    return bool;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy()
  {
    return null;
  }
  
  public final void hbE()
  {
    AppMethodBeat.i(265425);
    Iterator localIterator = this.QvZ.iterator();
    while (localIterator.hasNext()) {
      ((a.a)localIterator.next()).iW(1);
    }
    AppMethodBeat.o(265425);
  }
  
  /* Error */
  public final void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 234
    //   4: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 121	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:QvZ	Ljava/util/Set;
    //   11: invokeinterface 219 1 0
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface 224 1 0
    //   23: ifeq +47 -> 70
    //   26: aload_1
    //   27: invokeinterface 228 1 0
    //   32: checkcast 230	com/tencent/luggage/xweb_ext/extendplugin/a$a
    //   35: invokeinterface 236 1 0
    //   40: goto -23 -> 17
    //   43: astore_1
    //   44: aload_0
    //   45: getfield 108	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:TAG	Ljava/lang/String;
    //   48: new 149	java/lang/StringBuilder
    //   51: dup
    //   52: ldc 238
    //   54: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: aload_1
    //   58: invokevirtual 158	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   61: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: getfield 121	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:QvZ	Ljava/util/Set;
    //   74: invokeinterface 241 1 0
    //   79: aload_0
    //   80: getfield 126	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:Qwa	Lcom/tencent/mm/plugin/webview/ui/tools/video/b;
    //   83: astore_1
    //   84: aload_1
    //   85: ifnull +15 -> 100
    //   88: aload_1
    //   89: invokevirtual 244	com/tencent/mm/plugin/webview/ui/tools/video/b:release	()V
    //   92: ldc 234
    //   94: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: ldc 234
    //   102: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      AppMethodBeat.i(265431);
      Iterator localIterator = this.QvZ.iterator();
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).iW(0);
      }
      AppMethodBeat.o(265431);
    }
    finally {}
  }
  
  public final void onResume()
  {
    try
    {
      AppMethodBeat.i(265430);
      Iterator localIterator = this.QvZ.iterator();
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).onForeground();
      }
      AppMethodBeat.o(265430);
    }
    finally {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl$Companion;", "", "()V", "BackgroundTypeAddToFloatBall", "", "BackgroundTypeDefault", "plugin-webview_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h
 * JD-Core Version:    0.7.0.1
 */