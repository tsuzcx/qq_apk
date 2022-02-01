package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.luggage.xweb_ext.extendplugin.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.video.a;
import com.tencent.mm.plugin.webview.ui.tools.video.b;
import d.g.b.p;
import d.l;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/IWebViewUIProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "activityLifecycleCallbacks", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "kotlin.jvm.PlatformType", "", "getContext", "()Landroid/content/Context;", "webViewFullscreenImpl", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;", "getWebViewFullscreenImpl", "()Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;", "setWebViewFullscreenImpl", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;)V", "addFullScreenListener", "", "listener", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "addWebViewLifeCycleCallback", "callback", "exitFullScreen", "", "ct", "getWebViewPluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "isInFullScreen", "onDestroy", "onPause", "onResume", "removeFullScreenListener", "removeWebViewLifeCycleCallback", "webviewEnterFullscreen", "view", "Landroid/view/View;", "direction", "", "webviewExitFullscreen", "plugin-webview_release"})
public final class h
  implements e
{
  private final Set<a.a> EpP;
  private a EpQ;
  private final String TAG;
  private final Context context;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(207700);
    this.context = paramContext;
    this.TAG = "MicroMsg.WebViewUIProxyImpl";
    this.EpP = Collections.newSetFromMap((Map)new ConcurrentHashMap());
    AppMethodBeat.o(207700);
  }
  
  private final a gW(Context paramContext)
  {
    AppMethodBeat.i(207695);
    if (this.EpQ == null) {
      this.EpQ = new a(paramContext);
    }
    paramContext = this.EpQ;
    if (paramContext == null) {
      p.gfZ();
    }
    AppMethodBeat.o(207695);
    return paramContext;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(207691);
    gW(this.context).c(paramb);
    AppMethodBeat.o(207691);
  }
  
  public final void aw(View paramView, int paramInt)
  {
    AppMethodBeat.i(207697);
    gW(this.context).O(paramView, paramInt);
    AppMethodBeat.o(207697);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(207690);
    gW(this.context).d(paramb);
    AppMethodBeat.o(207690);
  }
  
  public final boolean bmN()
  {
    AppMethodBeat.i(207699);
    a locala = this.EpQ;
    if (locala != null)
    {
      boolean bool = locala.bmN();
      AppMethodBeat.o(207699);
      return bool;
    }
    AppMethodBeat.o(207699);
    return false;
  }
  
  public final void c(a.a parama)
  {
    try
    {
      AppMethodBeat.i(207688);
      p.h(parama, "callback");
      if (!this.EpP.contains(parama)) {
        this.EpP.add(parama);
      }
      AppMethodBeat.o(207688);
      return;
    }
    finally {}
  }
  
  public final void d(a.a parama)
  {
    try
    {
      AppMethodBeat.i(207689);
      p.h(parama, "callback");
      this.EpP.remove(parama);
      AppMethodBeat.o(207689);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final boolean eSC()
  {
    AppMethodBeat.i(207698);
    boolean bool = gW(this.context).aXV();
    AppMethodBeat.o(207698);
    return bool;
  }
  
  public final boolean eVk()
  {
    AppMethodBeat.i(207696);
    if (this.EpQ != null)
    {
      a locala = this.EpQ;
      if (locala == null) {
        p.gfZ();
      }
      if (locala.bmN())
      {
        boolean bool = gW(this.context).aXV();
        AppMethodBeat.o(207696);
        return bool;
      }
    }
    AppMethodBeat.o(207696);
    return false;
  }
  
  public final c getWebViewPluginClientProxy()
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
    //   8: getfield 95	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:EpP	Ljava/util/Set;
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
    //   67: invokestatic 203	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: getfield 95	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:EpP	Ljava/util/Set;
    //   74: invokeinterface 206 1 0
    //   79: aload_0
    //   80: getfield 104	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:EpQ	Lcom/tencent/mm/plugin/webview/ui/tools/video/a;
    //   83: astore_1
    //   84: aload_1
    //   85: ifnull +15 -> 100
    //   88: aload_1
    //   89: invokevirtual 209	com/tencent/mm/plugin/webview/ui/tools/video/a:release	()V
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
    //   83	6	1	locala	a
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
      AppMethodBeat.i(207693);
      Iterator localIterator = this.EpP.iterator();
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).gE(0);
      }
      AppMethodBeat.o(207693);
    }
    finally {}
  }
  
  public final void onResume()
  {
    try
    {
      AppMethodBeat.i(207692);
      Iterator localIterator = this.EpP.iterator();
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).onForeground();
      }
      AppMethodBeat.o(207692);
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h
 * JD-Core Version:    0.7.0.1
 */