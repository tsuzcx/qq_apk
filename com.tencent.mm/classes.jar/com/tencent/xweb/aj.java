package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import com.tencent.xweb.util.IXWebLogClient;
import com.tencent.xweb.util.h;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public final class aj
{
  static boolean SAU = false;
  static boolean SAV = false;
  
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
        h.a(paramaf);
      }
      if (paramISharedPreferenceProvider != null) {
        ah.setSharedPreferenceProvider(paramISharedPreferenceProvider);
      }
      lD(paramContext);
      if (paramWebViewExtensionListener != null) {
        l.g(WebView.c.SAt).initCallback(paramWebViewExtensionListener);
      }
      if (paramWebViewExtensionListener != null) {
        l.g(WebView.c.SAu).initCallback(paramWebViewExtensionListener);
      }
      XWebCoreContentProvider.htb();
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
    //   3: ldc 79
    //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 11	com/tencent/xweb/aj:SAU	Z
    //   11: ifeq +12 -> 23
    //   14: ldc 79
    //   16: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: iconst_1
    //   24: putstatic 11	com/tencent/xweb/aj:SAU	Z
    //   27: getstatic 57	com/tencent/xweb/WebView$c:SAt	Lcom/tencent/xweb/WebView$c;
    //   30: invokestatic 63	com/tencent/xweb/internal/l:g	(Lcom/tencent/xweb/WebView$c;)Lcom/tencent/xweb/internal/l$a;
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull +9 -> 44
    //   38: aload_0
    //   39: invokeinterface 81 1 0
    //   44: getstatic 72	com/tencent/xweb/WebView$c:SAu	Lcom/tencent/xweb/WebView$c;
    //   47: invokestatic 63	com/tencent/xweb/internal/l:g	(Lcom/tencent/xweb/WebView$c;)Lcom/tencent/xweb/internal/l$a;
    //   50: astore_0
    //   51: aload_0
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: invokeinterface 81 1 0
    //   61: ldc 79
    //   63: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: goto -47 -> 19
    //   69: astore_0
    //   70: ldc 2
    //   72: monitorexit
    //   73: aload_0
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   33	23	0	locala	l.a
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
  
  private static void lD(Context paramContext)
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
        if (SAV)
        {
          AppMethodBeat.o(156945);
          continue;
        }
        XWalkEnvironment.init(paramContext);
      }
      finally {}
      l.a locala = l.g(WebView.c.SAt);
      if (locala != null) {
        locala.initEnviroment(paramContext);
      }
      locala = l.g(WebView.c.SAu);
      if (locala != null) {
        locala.initEnviroment(paramContext);
      }
      SAV = true;
      AppMethodBeat.o(156945);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.aj
 * JD-Core Version:    0.7.0.1
 */