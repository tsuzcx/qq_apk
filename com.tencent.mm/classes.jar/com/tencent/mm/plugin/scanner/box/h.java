package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.widget.MMWebView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/BoxWebViewPreloadManager;", "", "()V", "TAG", "", "cacheWebView", "Lcom/tencent/mm/plugin/box/webview/BoxWebView;", "createWebViewHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "enablePreloadNextWebViewAfterGet", "", "enablePreloadWebView", "enablePreloadWebViewFromFindTab", "syncObject", "createBoxWebView", "fetchBoxWebView", "context", "Landroid/content/Context;", "callback", "Lkotlin/Function3;", "", "getCachedBoxWebView", "preloadBoxWebView", "delay", "", "preloadBoxWebViewInner", "runTask", "block", "Lkotlin/Function0;", "startPreloadBoxWebView", "scene", "", "Scene", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  private static MMHandler GXA;
  private static volatile BoxWebView GXv;
  private static boolean GXw;
  private static boolean GXx;
  private static boolean GXy;
  private static Object GXz;
  public static final h ONe;
  
  static
  {
    AppMethodBeat.i(313844);
    ONe = new h();
    GXx = GXw;
    GXz = new Object();
    int i = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zfX, 0);
    int j = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zfY, 0);
    if ((i == 1) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED))
    {
      bool = true;
      GXw = bool;
      if ((j != 1) && (!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED)) {
        break label221;
      }
    }
    label221:
    for (boolean bool = true;; bool = false)
    {
      GXy = bool;
      GXx = GXw;
      Log.i("MicroMsg.BoxWebViewPreloadManager", "init enablePreloadWebView config: %d, configFindTab: %d, enablePreload: %b, enablePreloadAfterGet: %b, enablePreloadFromFindTab: %b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(GXw), Boolean.valueOf(GXx), Boolean.valueOf(GXy) });
      long l = System.currentTimeMillis();
      GXA = new MMHandler(Looper.getMainLooper());
      Log.d("MicroMsg.BoxWebViewPreloadManager", "createWebViewHandlerThread start cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(313844);
      return;
      bool = false;
      break;
    }
  }
  
  public static final BoxWebView a(Context paramContext, q<? super Boolean, ? super Boolean, ? super Boolean, ah> paramq)
  {
    AppMethodBeat.i(313793);
    s.u(paramContext, "context");
    s.u(paramq, "callback");
    BoxWebView localBoxWebView = fpK();
    boolean bool;
    if (localBoxWebView == null)
    {
      paramContext = new BoxWebView(paramContext);
      bool = false;
    }
    for (;;)
    {
      paramq.invoke(Boolean.valueOf(GXw), Boolean.valueOf(GXy), Boolean.valueOf(bool));
      if (GXx) {
        aV(1, 1500L);
      }
      AppMethodBeat.o(313793);
      return paramContext;
      localBoxWebView.bm(paramContext);
      bool = true;
      paramContext = localBoxWebView;
    }
  }
  
  private static final void aF(a parama)
  {
    AppMethodBeat.i(313824);
    s.u(parama, "$block");
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new b(parama));
    AppMethodBeat.o(313824);
  }
  
  public static final void aV(int paramInt, long paramLong)
  {
    AppMethodBeat.i(313781);
    if (!GXw)
    {
      AppMethodBeat.o(313781);
      return;
    }
    if (((paramInt == 1) && (GXx)) || ((paramInt == 2) && (GXy)))
    {
      Log.v("MicroMsg.BoxWebViewPreloadManager", "alvinluo preloadBoxWebView delay: %d", new Object[] { Long.valueOf(paramLong) });
      a locala = (a)a.ONf;
      MMHandler localMMHandler = GXA;
      if (localMMHandler != null) {
        localMMHandler.postDelayed(new h..ExternalSyntheticLambda0(locala), paramLong);
      }
    }
    AppMethodBeat.o(313781);
  }
  
  private static BoxWebView fpK()
  {
    ah localah = null;
    AppMethodBeat.i(313807);
    Object localObject3 = GXz;
    Object localObject1 = localah;
    try
    {
      if (GXv != null)
      {
        BoxWebView localBoxWebView = GXv;
        s.checkNotNull(localBoxWebView);
        localObject1 = localah;
        if (!localBoxWebView.mDestroyed)
        {
          Log.v("MicroMsg.BoxWebViewPreloadManager", "alvinluo fetchBoxWebView use preload webView");
          localObject1 = GXv;
          GXv = null;
        }
      }
      localah = ah.aiuX;
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(313807);
    }
  }
  
  /* Error */
  private final void fpL()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 268
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 247	com/tencent/mm/plugin/scanner/box/h:GXv	Lcom/tencent/mm/plugin/box/webview/BoxWebView;
    //   11: astore_2
    //   12: getstatic 247	com/tencent/mm/plugin/scanner/box/h:GXv	Lcom/tencent/mm/plugin/box/webview/BoxWebView;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +98 -> 115
    //   20: aconst_null
    //   21: astore_1
    //   22: ldc 120
    //   24: ldc_w 270
    //   27: iconst_2
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: aload_2
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: aload_1
    //   38: aastore
    //   39: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: getstatic 87	com/tencent/mm/plugin/scanner/box/h:GXz	Ljava/lang/Object;
    //   45: astore_1
    //   46: aload_1
    //   47: monitorenter
    //   48: getstatic 247	com/tencent/mm/plugin/scanner/box/h:GXv	Lcom/tencent/mm/plugin/box/webview/BoxWebView;
    //   51: ifnull +18 -> 69
    //   54: getstatic 247	com/tencent/mm/plugin/scanner/box/h:GXv	Lcom/tencent/mm/plugin/box/webview/BoxWebView;
    //   57: astore_2
    //   58: aload_2
    //   59: invokestatic 251	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   62: aload_2
    //   63: getfield 256	com/tencent/mm/ui/widget/MMWebView:mDestroyed	Z
    //   66: ifeq +34 -> 100
    //   69: ldc 120
    //   71: ldc_w 272
    //   74: invokestatic 261	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: new 183	com/tencent/mm/plugin/box/webview/BoxWebView
    //   80: dup
    //   81: new 274	android/content/MutableContextWrapper
    //   84: dup
    //   85: invokestatic 280	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   88: invokespecial 281	android/content/MutableContextWrapper:<init>	(Landroid/content/Context;)V
    //   91: checkcast 283	android/content/Context
    //   94: invokespecial 186	com/tencent/mm/plugin/box/webview/BoxWebView:<init>	(Landroid/content/Context;)V
    //   97: putstatic 247	com/tencent/mm/plugin/scanner/box/h:GXv	Lcom/tencent/mm/plugin/box/webview/BoxWebView;
    //   100: getstatic 267	kotlin/ah:aiuX	Lkotlin/ah;
    //   103: astore_2
    //   104: aload_1
    //   105: monitorexit
    //   106: ldc_w 268
    //   109: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload_0
    //   113: monitorexit
    //   114: return
    //   115: aload_1
    //   116: getfield 256	com/tencent/mm/ui/widget/MMWebView:mDestroyed	Z
    //   119: invokestatic 133	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   122: astore_1
    //   123: goto -101 -> 22
    //   126: astore_2
    //   127: aload_1
    //   128: monitorexit
    //   129: ldc_w 268
    //   132: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_2
    //   136: athrow
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	h
    //   137	4	1	localObject2	Object
    //   11	93	2	localObject3	Object
    //   126	10	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   48	69	126	finally
    //   69	100	126	finally
    //   100	104	126	finally
    //   2	16	137	finally
    //   22	48	137	finally
    //   104	112	137	finally
    //   115	123	137	finally
    //   127	137	137	finally
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    public static final a ONf;
    
    static
    {
      AppMethodBeat.i(313739);
      ONf = new a();
      AppMethodBeat.o(313739);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements MessageQueue.IdleHandler
  {
    public b(a parama) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(313740);
      Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
      this.$block.invoke();
      AppMethodBeat.o(313740);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.h
 * JD-Core Version:    0.7.0.1
 */