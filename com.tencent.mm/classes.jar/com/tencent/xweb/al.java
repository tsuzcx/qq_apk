package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import com.tencent.xweb.util.IXWebLogClient;
import com.tencent.xweb.util.h;
import java.util.Locale;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public final class al
{
  static boolean aabP = false;
  static boolean aabQ = false;
  
  public static void a(Context paramContext, IXWebLogClient paramIXWebLogClient)
  {
    try
    {
      AppMethodBeat.i(156942);
      b(paramContext, paramIXWebLogClient);
      AppMethodBeat.o(156942);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static void a(Context paramContext, Locale paramLocale)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(197103);
        if (paramContext == null)
        {
          AppMethodBeat.o(197103);
          return;
        }
        if (aabQ)
        {
          AppMethodBeat.o(197103);
          continue;
        }
        XWalkEnvironment.init(paramContext);
      }
      finally {}
      XWalkEnvironment.setLocale(paramLocale);
      paramLocale = l.h(WebView.c.aabm);
      if (paramLocale != null) {
        paramLocale.initEnviroment(paramContext);
      }
      paramLocale = l.h(WebView.c.aabn);
      if (paramLocale != null) {
        paramLocale.initEnviroment(paramContext);
      }
      aabQ = true;
      AppMethodBeat.o(197103);
    }
  }
  
  public static void a(Context paramContext, Locale paramLocale, IXWebLogClient paramIXWebLogClient, ISharedPreferenceProvider paramISharedPreferenceProvider, ag paramag, WebViewExtensionListener paramWebViewExtensionListener)
  {
    try
    {
      AppMethodBeat.i(197094);
      b(paramContext, paramLocale, paramIXWebLogClient, paramISharedPreferenceProvider, paramag, paramWebViewExtensionListener);
      AppMethodBeat.o(197094);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static void b(Context paramContext, IXWebLogClient paramIXWebLogClient)
  {
    try
    {
      AppMethodBeat.i(197089);
      c(paramContext, paramIXWebLogClient);
      AppMethodBeat.o(197089);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static void b(Context paramContext, Locale paramLocale, IXWebLogClient paramIXWebLogClient, ISharedPreferenceProvider paramISharedPreferenceProvider, ag paramag, WebViewExtensionListener paramWebViewExtensionListener)
  {
    try
    {
      AppMethodBeat.i(197098);
      if (paramIXWebLogClient != null) {
        Log.SetLogCallBack(paramIXWebLogClient);
      }
      if (paramag != null) {
        h.a(paramag);
      }
      if (paramISharedPreferenceProvider != null) {
        aj.setSharedPreferenceProvider(paramISharedPreferenceProvider);
      }
      a(paramContext, paramLocale);
      if (paramWebViewExtensionListener != null) {
        l.h(WebView.c.aabm).initCallback(paramWebViewExtensionListener);
      }
      if (paramWebViewExtensionListener != null) {
        l.h(WebView.c.aabn).initCallback(paramWebViewExtensionListener);
      }
      XWebCoreContentProvider.iwJ();
      AppMethodBeat.o(197098);
      return;
    }
    finally {}
  }
  
  private static void c(Context paramContext, IXWebLogClient paramIXWebLogClient)
  {
    try
    {
      AppMethodBeat.i(197091);
      a(paramContext, null, paramIXWebLogClient, null, null, null);
      AppMethodBeat.o(197091);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  public static void initInterface()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 103
    //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 11	com/tencent/xweb/al:aabP	Z
    //   11: ifeq +12 -> 23
    //   14: ldc 103
    //   16: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: iconst_1
    //   24: putstatic 11	com/tencent/xweb/al:aabP	Z
    //   27: getstatic 47	com/tencent/xweb/WebView$c:aabm	Lcom/tencent/xweb/WebView$c;
    //   30: invokestatic 53	com/tencent/xweb/internal/l:h	(Lcom/tencent/xweb/WebView$c;)Lcom/tencent/xweb/internal/l$a;
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull +9 -> 44
    //   38: aload_0
    //   39: invokeinterface 105 1 0
    //   44: getstatic 61	com/tencent/xweb/WebView$c:aabn	Lcom/tencent/xweb/WebView$c;
    //   47: invokestatic 53	com/tencent/xweb/internal/l:h	(Lcom/tencent/xweb/WebView$c;)Lcom/tencent/xweb/internal/l$a;
    //   50: astore_0
    //   51: aload_0
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: invokeinterface 105 1 0
    //   61: ldc 103
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.al
 * JD-Core Version:    0.7.0.1
 */