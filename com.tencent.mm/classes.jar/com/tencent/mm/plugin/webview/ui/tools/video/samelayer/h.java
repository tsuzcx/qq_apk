package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.webview.ui.tools.video.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/IWebViewUIProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "activityLifecycleCallbacks", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "kotlin.jvm.PlatformType", "", "getContext", "()Landroid/content/Context;", "setContext", "immersiveMode", "", "getImmersiveMode", "()Z", "setImmersiveMode", "(Z)V", "webViewFullscreenImpl", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;", "getWebViewFullscreenImpl", "()Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;", "setWebViewFullscreenImpl", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;)V", "addFullScreenListener", "", "listener", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "addToFloatBall", "addWebViewLifeCycleCallback", "callback", "exitFullScreen", "force", "ct", "getWebViewPluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "isInFullScreen", "onDestroy", "onKeyBoardHide", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)Lkotlin/Unit;", "onKeyBoardShow", "onPause", "onResume", "removeFullScreenListener", "removeWebViewLifeCycleCallback", "resetContext", "webviewEnterFullscreen", "view", "Landroid/view/View;", "direction", "", "webviewExitFullscreen", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements e
{
  public static final a Xot;
  private final String TAG;
  public boolean Xou;
  private final Set<a.a> Xov;
  public b Xow;
  private Context context;
  
  static
  {
    AppMethodBeat.i(297143);
    Xot = new a((byte)0);
    AppMethodBeat.o(297143);
  }
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(297131);
    this.context = paramContext;
    this.TAG = "MicroMsg.WebViewUIProxyImpl";
    this.Xov = Collections.newSetFromMap((Map)new ConcurrentHashMap());
    AppMethodBeat.o(297131);
  }
  
  private final b lc(Context paramContext)
  {
    AppMethodBeat.i(297135);
    if (this.Xow == null) {
      this.Xow = new b(paramContext);
    }
    paramContext = this.Xow;
    s.checkNotNull(paramContext);
    AppMethodBeat.o(297135);
    return paramContext;
  }
  
  public final boolean IY(boolean paramBoolean)
  {
    AppMethodBeat.i(297236);
    if (this.Xow != null)
    {
      b localb = this.Xow;
      s.checkNotNull(localb);
      if (localb.cuZ()) {
        try
        {
          paramBoolean = lc(this.context).IX(paramBoolean);
          AppMethodBeat.o(297236);
          return paramBoolean;
        }
        catch (Exception localException)
        {
          Log.e(this.TAG, s.X("exitFullScreen ex=", localException.getMessage()));
        }
      }
    }
    AppMethodBeat.o(297236);
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.webview.ui.tools.video.c paramc)
  {
    AppMethodBeat.i(297200);
    lc(this.context).c(paramc);
    AppMethodBeat.o(297200);
  }
  
  public final void b(com.tencent.mm.plugin.webview.ui.tools.video.c paramc)
  {
    AppMethodBeat.i(297192);
    lc(this.context).d(paramc);
    AppMethodBeat.o(297192);
  }
  
  public final void bc(View paramView, int paramInt)
  {
    AppMethodBeat.i(297251);
    b localb = lc(this.context);
    Activity localActivity;
    if ((localb.mContext instanceof Activity))
    {
      localActivity = (Activity)localb.mContext;
      if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
      {
        Log.e("MicroMsg.WebViewFullscreenImpl", "enterFullscreen activity(%s) destroyed", new Object[] { localActivity });
        AppMethodBeat.o(297251);
        return;
      }
      View localView = localb.tKX;
      localb.tKX = paramView;
      ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
      if (localView == null)
      {
        if (!(paramView.getParent() instanceof ViewGroup)) {
          break label355;
        }
        localb.tLb = ((ViewGroup)paramView.getParent());
        localb.tKZ = localb.tLb.indexOfChild(paramView);
        localb.tLa = paramView.getLayoutParams();
        localb.tLb.removeView(paramView);
        localb.Xoo = localb.tKX.getDrawingCacheBackgroundColor();
        localb.tKX.setBackgroundColor(-16777216);
        localViewGroup.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
        localViewGroup.bringChildToFront(paramView);
        paramView.setX(0.0F);
        paramView.setY(0.0F);
      }
      if (localView == null)
      {
        localb.tLv = localViewGroup.getSystemUiVisibility();
        localb.tLw = localActivity.getRequestedOrientation();
        localb.tLx = new WindowManager.LayoutParams();
        localb.tLx.copyFrom(localActivity.getWindow().getAttributes());
        Log.d("MicroMsg.WebViewFullscreenImpl", "enterFullscreen mStashedOrientation=%d", new Object[] { Integer.valueOf(localb.tLw) });
      }
      localViewGroup.setSystemUiVisibility(5894);
      localActivity.getWindow().addFlags(1024);
      switch (paramInt)
      {
      default: 
        localActivity.setRequestedOrientation(9);
      }
    }
    for (;;)
    {
      f.d(true, true, true);
      localb.cHO();
      AppMethodBeat.o(297251);
      return;
      label355:
      localb.tKZ = 0;
      localb.tLb = null;
      localb.tLa = null;
      break;
      localActivity.setRequestedOrientation(0);
      continue;
      localActivity.setRequestedOrientation(8);
      continue;
      localActivity.setRequestedOrientation(1);
    }
  }
  
  public final void bm(Context paramContext)
  {
    AppMethodBeat.i(297148);
    s.u(paramContext, "ct");
    this.context = paramContext;
    b localb = this.Xow;
    if (localb != null) {
      localb.reset(paramContext);
    }
    AppMethodBeat.o(297148);
  }
  
  public final void c(a.a parama)
  {
    try
    {
      AppMethodBeat.i(297170);
      s.u(parama, "callback");
      if (!this.Xov.contains(parama)) {
        this.Xov.add(parama);
      }
      AppMethodBeat.o(297170);
      return;
    }
    finally {}
  }
  
  public final boolean cuZ()
  {
    AppMethodBeat.i(297268);
    b localb = this.Xow;
    if (localb == null)
    {
      AppMethodBeat.o(297268);
      return false;
    }
    boolean bool = localb.cuZ();
    AppMethodBeat.o(297268);
    return bool;
  }
  
  public final void d(a.a parama)
  {
    try
    {
      AppMethodBeat.i(297180);
      s.u(parama, "callback");
      this.Xov.remove(parama);
      AppMethodBeat.o(297180);
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
  
  public final void iBR()
  {
    AppMethodBeat.i(297160);
    Iterator localIterator = this.Xov.iterator();
    while (localIterator.hasNext()) {
      ((a.a)localIterator.next()).my(1);
    }
    AppMethodBeat.o(297160);
  }
  
  public final boolean iyp()
  {
    AppMethodBeat.i(297256);
    boolean bool = lc(this.context).IX(false);
    AppMethodBeat.o(297256);
    return bool;
  }
  
  /* Error */
  public final void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 380
    //   5: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 131	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:Xov	Ljava/util/Set;
    //   12: invokeinterface 363 1 0
    //   17: astore_1
    //   18: aload_1
    //   19: invokeinterface 368 1 0
    //   24: ifeq +38 -> 62
    //   27: aload_1
    //   28: invokeinterface 372 1 0
    //   33: checkcast 374	com/tencent/luggage/xweb_ext/extendplugin/a$a
    //   36: invokeinterface 382 1 0
    //   41: goto -23 -> 18
    //   44: astore_1
    //   45: aload_0
    //   46: getfield 118	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:TAG	Ljava/lang/String;
    //   49: ldc_w 384
    //   52: aload_1
    //   53: invokevirtual 163	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   56: invokestatic 167	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   59: invokestatic 173	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_0
    //   63: getfield 131	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:Xov	Ljava/util/Set;
    //   66: invokeinterface 387 1 0
    //   71: aload_0
    //   72: getfield 136	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:Xow	Lcom/tencent/mm/plugin/webview/ui/tools/video/b;
    //   75: astore_1
    //   76: aload_1
    //   77: ifnull +12 -> 89
    //   80: aload_1
    //   81: getfield 390	com/tencent/mm/plugin/webview/ui/tools/video/b:tLc	Ljava/util/Set;
    //   84: invokeinterface 387 1 0
    //   89: ldc_w 380
    //   92: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	h
    //   17	11	1	localIterator	Iterator
    //   44	9	1	localException	Exception
    //   75	6	1	localb	b
    //   98	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	18	44	java/lang/Exception
    //   18	41	44	java/lang/Exception
    //   2	8	98	finally
    //   8	18	98	finally
    //   18	41	98	finally
    //   45	62	98	finally
    //   62	76	98	finally
    //   80	89	98	finally
    //   89	95	98	finally
  }
  
  public final void onPause()
  {
    try
    {
      AppMethodBeat.i(297218);
      Iterator localIterator = this.Xov.iterator();
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).my(0);
      }
      AppMethodBeat.o(297218);
    }
    finally {}
  }
  
  public final void onResume()
  {
    try
    {
      AppMethodBeat.i(297208);
      Iterator localIterator = this.Xov.iterator();
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).onForeground();
      }
      AppMethodBeat.o(297208);
    }
    finally {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl$Companion;", "", "()V", "BackgroundTypeAddToFloatBall", "", "BackgroundTypeDefault", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h
 * JD-Core Version:    0.7.0.1
 */