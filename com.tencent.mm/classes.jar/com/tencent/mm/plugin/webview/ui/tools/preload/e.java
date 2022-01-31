package com.tencent.mm.plugin.webview.ui.tools.preload;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.SparseArray;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.LinkedList;
import java.util.List;

public final class e
{
  static SparseArray<List<c>> rBv = new SparseArray();
  
  private static List<c> De(int paramInt)
  {
    try
    {
      List localList = (List)rBv.get(paramInt);
      Object localObject1 = localList;
      if (localList == null)
      {
        localObject1 = new LinkedList();
        rBv.put(paramInt, localObject1);
      }
      return localObject1;
    }
    finally {}
  }
  
  public static MMWebView a(Context paramContext, TmplParams paramTmplParams)
  {
    if (paramTmplParams == null) {}
    for (;;)
    {
      try
      {
        y.w("MicroMsg.Preload.PreloadWebviewManager", "[obtainPreloadWebview]tmplParams is null");
        paramContext = null;
        return paramContext;
      }
      finally {}
      y.v("MicroMsg.Preload.PreloadWebviewManager", "[obtainPreloadWebview]tmplParams:%s", new Object[] { paramTmplParams });
      paramTmplParams = (List)rBv.get(paramTmplParams.rjv);
      if ((paramTmplParams != null) && (paramTmplParams.size() > 0))
      {
        y.v("MicroMsg.Preload.PreloadWebviewManager", "[obtainPreloadWebview] preloadWebviews.size():%d", new Object[] { Integer.valueOf(paramTmplParams.size()) });
        paramContext = a((MMWebView)paramTmplParams.remove(0), paramContext);
      }
      else
      {
        paramContext = null;
      }
    }
  }
  
  private static MMWebView a(MMWebView paramMMWebView, Context paramContext)
  {
    if ((paramMMWebView.getContext() instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)paramMMWebView.getContext()).setBaseContext(paramContext);
    }
    return paramMMWebView;
  }
  
  public static void a(int paramInt, String paramString, long paramLong)
  {
    try
    {
      List localList = (List)rBv.get(paramInt);
      if ((localList != null) && (localList.size() > 0))
      {
        y.v("MicroMsg.Preload.PreloadWebviewManager", "[updateTmplWebview] preloadWebviews.size():%d", new Object[] { Integer.valueOf(localList.size()) });
        ((c)localList.get(0)).w(paramString, paramLong, System.currentTimeMillis());
      }
      return;
    }
    finally {}
  }
  
  public static void a(TmplParams paramTmplParams)
  {
    try
    {
      ai.d(new Runnable()
      {
        public final void run()
        {
          Looper.myQueue().addIdleHandler(new e.1.1(this));
        }
      });
      return;
    }
    finally
    {
      paramTmplParams = finally;
      throw paramTmplParams;
    }
  }
  
  /* Error */
  public static MMWebView b(Context paramContext, TmplParams paramTmplParams)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 40
    //   5: ldc 50
    //   7: iconst_1
    //   8: anewarray 4	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: aload_1
    //   14: aastore
    //   15: invokestatic 54	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_1
    //   19: ifnonnull +28 -> 47
    //   22: ldc 40
    //   24: ldc 117
    //   26: iconst_1
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: aload_1
    //   33: getfield 121	com/tencent/mm/plugin/webview/preload/TmplParams:rfY	Ljava/lang/String;
    //   36: aastore
    //   37: invokestatic 123	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   40: aconst_null
    //   41: astore_0
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload_0
    //   46: areturn
    //   47: getstatic 18	com/tencent/mm/plugin/webview/ui/tools/preload/e:rBv	Landroid/util/SparseArray;
    //   50: aload_1
    //   51: getfield 60	com/tencent/mm/plugin/webview/preload/TmplParams:rjv	I
    //   54: invokevirtual 25	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   57: checkcast 27	java/util/List
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull +53 -> 115
    //   65: aload_2
    //   66: invokeinterface 64 1 0
    //   71: ifle +44 -> 115
    //   74: ldc 40
    //   76: ldc 66
    //   78: iconst_1
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload_2
    //   85: invokeinterface 64 1 0
    //   90: invokestatic 72	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   93: aastore
    //   94: invokestatic 54	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aload_2
    //   98: iconst_0
    //   99: invokeinterface 75 2 0
    //   104: checkcast 77	com/tencent/mm/ui/widget/MMWebView
    //   107: aload_0
    //   108: invokestatic 80	com/tencent/mm/plugin/webview/ui/tools/preload/e:a	(Lcom/tencent/mm/ui/widget/MMWebView;Landroid/content/Context;)Lcom/tencent/mm/ui/widget/MMWebView;
    //   111: astore_0
    //   112: goto -70 -> 42
    //   115: aload_1
    //   116: invokestatic 127	com/tencent/mm/plugin/webview/ui/tools/preload/e:c	(Lcom/tencent/mm/plugin/webview/preload/TmplParams;)Lcom/tencent/mm/plugin/webview/ui/tools/preload/c;
    //   119: astore_1
    //   120: aload_1
    //   121: ifnonnull +8 -> 129
    //   124: aconst_null
    //   125: astore_0
    //   126: goto -84 -> 42
    //   129: aload_1
    //   130: aload_0
    //   131: invokestatic 80	com/tencent/mm/plugin/webview/ui/tools/preload/e:a	(Lcom/tencent/mm/ui/widget/MMWebView;Landroid/content/Context;)Lcom/tencent/mm/ui/widget/MMWebView;
    //   134: astore_0
    //   135: goto -93 -> 42
    //   138: astore_0
    //   139: ldc 2
    //   141: monitorexit
    //   142: aload_0
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramContext	Context
    //   0	144	1	paramTmplParams	TmplParams
    //   60	38	2	localList	List
    // Exception table:
    //   from	to	target	type
    //   3	18	138	finally
    //   22	40	138	finally
    //   47	61	138	finally
    //   65	112	138	finally
    //   115	120	138	finally
    //   129	135	138	finally
  }
  
  /* Error */
  private static void b(TmplParams paramTmplParams)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 40
    //   5: ldc 129
    //   7: iconst_1
    //   8: anewarray 4	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: aload_0
    //   14: aastore
    //   15: invokestatic 132	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_0
    //   19: getfield 60	com/tencent/mm/plugin/webview/preload/TmplParams:rjv	I
    //   22: invokestatic 134	com/tencent/mm/plugin/webview/ui/tools/preload/e:De	(I)Ljava/util/List;
    //   25: astore_1
    //   26: aload_1
    //   27: invokeinterface 64 1 0
    //   32: ifle +14 -> 46
    //   35: ldc 40
    //   37: ldc 136
    //   39: invokestatic 48	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: ldc 2
    //   44: monitorexit
    //   45: return
    //   46: aload_0
    //   47: invokestatic 127	com/tencent/mm/plugin/webview/ui/tools/preload/e:c	(Lcom/tencent/mm/plugin/webview/preload/TmplParams;)Lcom/tencent/mm/plugin/webview/ui/tools/preload/c;
    //   50: astore_0
    //   51: aload_0
    //   52: ifnull -10 -> 42
    //   55: aload_0
    //   56: invokevirtual 139	com/tencent/mm/plugin/webview/ui/tools/preload/c:cgI	()V
    //   59: aload_0
    //   60: invokevirtual 142	com/tencent/mm/plugin/webview/ui/tools/preload/c:cgJ	()V
    //   63: aload_0
    //   64: new 144	com/tencent/mm/plugin/webview/ui/tools/preload/e$2
    //   67: dup
    //   68: aload_0
    //   69: aload_1
    //   70: invokespecial 147	com/tencent/mm/plugin/webview/ui/tools/preload/e$2:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/preload/c;Ljava/util/List;)V
    //   73: invokevirtual 151	com/tencent/mm/plugin/webview/ui/tools/preload/c:setOnStateChange	(Lcom/tencent/mm/plugin/webview/ui/tools/preload/c$a;)V
    //   76: goto -34 -> 42
    //   79: astore_0
    //   80: ldc 2
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramTmplParams	TmplParams
    //   25	45	1	localList	List
    // Exception table:
    //   from	to	target	type
    //   3	42	79	finally
    //   46	51	79	finally
    //   55	76	79	finally
  }
  
  private static c c(TmplParams paramTmplParams)
  {
    if (paramTmplParams == null)
    {
      y.w("MicroMsg.Preload.PreloadWebviewManager", "[preloadWebViewInner] tmplParams %s is null", new Object[] { paramTmplParams.rfY });
      return null;
    }
    if (paramTmplParams.rjv == -1)
    {
      y.w("MicroMsg.Preload.PreloadWebviewManager", "[preloadWebViewInner] tmplType %d", new Object[] { Integer.valueOf(paramTmplParams.rjv) });
      return null;
    }
    if (bk.bl(paramTmplParams.rfY))
    {
      y.w("MicroMsg.Preload.PreloadWebviewManager", "[preloadWebViewInner] initUrl %s is empty", new Object[] { paramTmplParams.rfY });
      return null;
    }
    if (!com.tencent.mm.a.e.bK(paramTmplParams.rjA))
    {
      y.w("MicroMsg.Preload.PreloadWebviewManager", "[preloadWebViewInner] filePath %s isn't exist", new Object[] { paramTmplParams.rjA });
      return null;
    }
    return new c(new MutableContextWrapper(ae.getContext()), paramTmplParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.preload.e
 * JD-Core Version:    0.7.0.1
 */