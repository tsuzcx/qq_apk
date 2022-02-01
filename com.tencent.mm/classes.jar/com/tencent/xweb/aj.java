package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.internal.j.a;
import com.tencent.xweb.util.IXWebLogClient;
import com.tencent.xweb.util.g;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public final class aj
{
  static boolean MqU = false;
  static boolean MqV = false;
  
  public static void a(Context paramContext, IXWebLogClient paramIXWebLogClient)
  {
    AppMethodBeat.i(156942);
    a(paramContext, paramIXWebLogClient, null, null, null);
    AppMethodBeat.o(156942);
  }
  
  public static void a(Context paramContext, IXWebLogClient paramIXWebLogClient, ISharedPreferenceProvider paramISharedPreferenceProvider, af paramaf, WebViewExtensionListener paramWebViewExtensionListener)
  {
    try
    {
      AppMethodBeat.i(156943);
      if (paramIXWebLogClient != null) {
        Log.SetLogCallBack(paramIXWebLogClient);
      }
      if (paramaf != null) {
        g.a(paramaf);
      }
      if (paramISharedPreferenceProvider != null) {
        ah.setSharedPreferenceProvider(paramISharedPreferenceProvider);
      }
      ly(paramContext);
      if (paramWebViewExtensionListener != null) {
        j.g(WebView.c.Mqu).initCallback(paramWebViewExtensionListener);
      }
      XWebCoreContentProvider.gbh();
      AppMethodBeat.o(156943);
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void initInterface()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 76
    //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 11	com/tencent/xweb/aj:MqU	Z
    //   11: ifeq +12 -> 23
    //   14: ldc 76
    //   16: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: iconst_1
    //   24: putstatic 11	com/tencent/xweb/aj:MqU	Z
    //   27: getstatic 57	com/tencent/xweb/WebView$c:Mqu	Lcom/tencent/xweb/WebView$c;
    //   30: invokestatic 63	com/tencent/xweb/internal/j:g	(Lcom/tencent/xweb/WebView$c;)Lcom/tencent/xweb/internal/j$a;
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull +9 -> 44
    //   38: aload_0
    //   39: invokeinterface 78 1 0
    //   44: getstatic 81	com/tencent/xweb/WebView$c:Mqv	Lcom/tencent/xweb/WebView$c;
    //   47: invokestatic 63	com/tencent/xweb/internal/j:g	(Lcom/tencent/xweb/WebView$c;)Lcom/tencent/xweb/internal/j$a;
    //   50: astore_0
    //   51: aload_0
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: invokeinterface 78 1 0
    //   61: ldc 76
    //   63: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: goto -47 -> 19
    //   69: astore_0
    //   70: ldc 2
    //   72: monitorexit
    //   73: aload_0
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   33	23	0	locala	j.a
    //   69	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	69	finally
    //   23	34	69	finally
    //   38	44	69	finally
    //   44	51	69	finally
    //   55	61	69	finally
    //   61	66	69	finally
  }
  
  private static void ly(Context paramContext)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156945);
        if (paramContext == null)
        {
          AppMethodBeat.o(156945);
          return;
        }
        if (MqV)
        {
          AppMethodBeat.o(156945);
          continue;
        }
        XWalkEnvironment.init(paramContext);
      }
      finally {}
      j.a locala = j.g(WebView.c.Mqu);
      if (locala != null) {
        locala.initEnviroment(paramContext);
      }
      locala = j.g(WebView.c.Mqv);
      if (locala != null) {
        locala.initEnviroment(paramContext);
      }
      MqV = true;
      AppMethodBeat.o(156945);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.aj
 * JD-Core Version:    0.7.0.1
 */