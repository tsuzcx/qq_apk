package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/BoxWebViewPreloadManager;", "", "()V", "TAG", "", "cacheWebView", "Lcom/tencent/mm/plugin/box/webview/BoxWebView;", "createWebViewHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "enablePreloadNextWebViewAfterGet", "", "enablePreloadWebView", "enablePreloadWebViewFromFindTab", "syncObject", "createBoxWebView", "fetchBoxWebView", "context", "Landroid/content/Context;", "callback", "Lkotlin/Function3;", "", "getCachedBoxWebView", "preloadBoxWebView", "delay", "", "preloadBoxWebViewInner", "runTask", "block", "Lkotlin/Function0;", "startPreloadBoxWebView", "scene", "", "Scene", "plugin-scan_release"})
public final class h
{
  private static volatile BoxWebView CCp;
  private static boolean CCq;
  private static boolean CCr;
  private static boolean CCs;
  private static Object CCt;
  private static MMHandler CCu;
  public static final h CCv;
  
  static
  {
    AppMethodBeat.i(240252);
    CCv = new h();
    CCr = CCq;
    CCt = new Object();
    int i = ((b)g.af(b.class)).a(b.a.sel, 0);
    int j = ((b)g.af(b.class)).a(b.a.sem, 0);
    if ((i == 1) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED))
    {
      bool = true;
      CCq = bool;
      if ((j != 1) && (!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED)) {
        break label221;
      }
    }
    label221:
    for (boolean bool = true;; bool = false)
    {
      CCs = bool;
      CCr = CCq;
      Log.i("MicroMsg.BoxWebViewPreloadManager", "init enablePreloadWebView config: %d, configFindTab: %d, enablePreload: %b, enablePreloadAfterGet: %b, enablePreloadFromFindTab: %b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(CCq), Boolean.valueOf(CCr), Boolean.valueOf(CCs) });
      long l = System.currentTimeMillis();
      CCu = new MMHandler(Looper.getMainLooper());
      Log.d("MicroMsg.BoxWebViewPreloadManager", "createWebViewHandlerThread start cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(240252);
      return;
      bool = false;
      break;
    }
  }
  
  public static final BoxWebView a(Context paramContext, kotlin.g.a.q<? super Boolean, ? super Boolean, ? super Boolean, x> paramq)
  {
    AppMethodBeat.i(240249);
    p.h(paramContext, "context");
    p.h(paramq, "callback");
    BoxWebView localBoxWebView = ePl();
    boolean bool;
    if (localBoxWebView == null)
    {
      paramContext = new BoxWebView(paramContext);
      bool = false;
    }
    for (;;)
    {
      paramq.d(Boolean.valueOf(CCq), Boolean.valueOf(CCs), Boolean.valueOf(bool));
      if (CCr) {
        aC(1, 1500L);
      }
      AppMethodBeat.o(240249);
      return paramContext;
      localBoxWebView.aG(paramContext);
      bool = true;
      paramContext = localBoxWebView;
    }
  }
  
  public static final void aC(int paramInt, long paramLong)
  {
    AppMethodBeat.i(240248);
    if (!CCq)
    {
      AppMethodBeat.o(240248);
      return;
    }
    if (((paramInt == 1) && (CCr)) || ((paramInt == 2) && (CCs)))
    {
      Log.v("MicroMsg.BoxWebViewPreloadManager", "alvinluo preloadBoxWebView delay: %d", new Object[] { Long.valueOf(paramLong) });
      a locala = (a)a.CCw;
      MMHandler localMMHandler = CCu;
      if (localMMHandler != null)
      {
        localMMHandler.postDelayed((Runnable)new b(locala), paramLong);
        AppMethodBeat.o(240248);
        return;
      }
    }
    AppMethodBeat.o(240248);
  }
  
  private static BoxWebView ePl()
  {
    x localx = null;
    AppMethodBeat.i(240250);
    Object localObject3 = CCt;
    Object localObject1 = localx;
    try
    {
      if (CCp != null)
      {
        BoxWebView localBoxWebView = CCp;
        if (localBoxWebView == null) {
          p.hyc();
        }
        localObject1 = localx;
        if (!localBoxWebView.isDestroyed())
        {
          Log.v("MicroMsg.BoxWebViewPreloadManager", "alvinluo fetchBoxWebView use preload webView");
          localObject1 = CCp;
          CCp = null;
        }
      }
      localx = x.SXb;
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(240250);
    }
  }
  
  /* Error */
  private final void ePm()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 243
    //   4: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 224	com/tencent/mm/plugin/scanner/box/h:CCp	Lcom/tencent/mm/plugin/box/webview/BoxWebView;
    //   10: astore_2
    //   11: getstatic 224	com/tencent/mm/plugin/scanner/box/h:CCp	Lcom/tencent/mm/plugin/box/webview/BoxWebView;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +104 -> 120
    //   19: aload_1
    //   20: invokevirtual 231	com/tencent/mm/plugin/box/webview/BoxWebView:isDestroyed	()Z
    //   23: invokestatic 122	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   26: astore_1
    //   27: ldc 109
    //   29: ldc 245
    //   31: iconst_2
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload_2
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: aload_1
    //   42: aastore
    //   43: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: getstatic 76	com/tencent/mm/plugin/scanner/box/h:CCt	Ljava/lang/Object;
    //   49: astore_1
    //   50: aload_1
    //   51: monitorenter
    //   52: getstatic 224	com/tencent/mm/plugin/scanner/box/h:CCp	Lcom/tencent/mm/plugin/box/webview/BoxWebView;
    //   55: ifnull +21 -> 76
    //   58: getstatic 224	com/tencent/mm/plugin/scanner/box/h:CCp	Lcom/tencent/mm/plugin/box/webview/BoxWebView;
    //   61: astore_2
    //   62: aload_2
    //   63: ifnonnull +6 -> 69
    //   66: invokestatic 227	kotlin/g/b/p:hyc	()V
    //   69: aload_2
    //   70: invokevirtual 231	com/tencent/mm/plugin/box/webview/BoxWebView:isDestroyed	()Z
    //   73: ifeq +33 -> 106
    //   76: ldc 109
    //   78: ldc 247
    //   80: invokestatic 236	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: new 176	com/tencent/mm/plugin/box/webview/BoxWebView
    //   86: dup
    //   87: new 249	android/content/MutableContextWrapper
    //   90: dup
    //   91: invokestatic 255	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   94: invokespecial 256	android/content/MutableContextWrapper:<init>	(Landroid/content/Context;)V
    //   97: checkcast 258	android/content/Context
    //   100: invokespecial 179	com/tencent/mm/plugin/box/webview/BoxWebView:<init>	(Landroid/content/Context;)V
    //   103: putstatic 224	com/tencent/mm/plugin/scanner/box/h:CCp	Lcom/tencent/mm/plugin/box/webview/BoxWebView;
    //   106: getstatic 242	kotlin/x:SXb	Lkotlin/x;
    //   109: astore_2
    //   110: aload_1
    //   111: monitorexit
    //   112: ldc 243
    //   114: invokestatic 159	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_0
    //   118: monitorexit
    //   119: return
    //   120: aconst_null
    //   121: astore_1
    //   122: goto -95 -> 27
    //   125: astore_2
    //   126: aload_1
    //   127: monitorexit
    //   128: ldc 243
    //   130: invokestatic 159	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload_2
    //   134: athrow
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	h
    //   135	4	1	localObject2	Object
    //   10	100	2	localObject3	Object
    //   125	9	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   52	62	125	finally
    //   66	69	125	finally
    //   69	76	125	finally
    //   76	106	125	finally
    //   106	110	125	finally
    //   2	15	135	finally
    //   19	27	135	finally
    //   27	52	135	finally
    //   110	117	135	finally
    //   126	135	135	finally
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements a<x>
  {
    public static final a CCw;
    
    static
    {
      AppMethodBeat.i(240245);
      CCw = new a();
      AppMethodBeat.o(240245);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(240247);
      a locala = this.hvp;
      Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new a(locala));
      AppMethodBeat.o(240247);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
    public static final class a
      implements MessageQueue.IdleHandler
    {
      public a(a parama) {}
      
      public final boolean queueIdle()
      {
        AppMethodBeat.i(240246);
        Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
        this.hvp.invoke();
        AppMethodBeat.o(240246);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.h
 * JD-Core Version:    0.7.0.1
 */