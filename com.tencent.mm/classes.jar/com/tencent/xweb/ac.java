package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.l;
import com.tencent.xweb.c.l.a;
import com.tencent.xweb.util.c;
import com.tencent.xweb.util.f;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public final class ac
{
  static boolean BEL = false;
  static boolean BEM = false;
  
  public static void a(Context paramContext, c paramc)
  {
    AppMethodBeat.i(3959);
    a(paramContext, paramc, null, null, null);
    AppMethodBeat.o(3959);
  }
  
  public static void a(Context paramContext, c paramc, h paramh, y paramy, WebViewExtensionListener paramWebViewExtensionListener)
  {
    try
    {
      AppMethodBeat.i(3960);
      if (paramc != null) {
        Log.SetLogCallBack(paramc);
      }
      if (paramy != null) {
        f.a(paramy);
      }
      if (paramh != null) {
        ab.setSharedPreferenceProvider(paramh);
      }
      jT(paramContext);
      if (paramWebViewExtensionListener != null) {
        l.e(WebView.d.BEq).initCallback(paramWebViewExtensionListener);
      }
      XWebCoreContentProvider.dYC();
      AppMethodBeat.o(3960);
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
    //   3: sipush 3961
    //   6: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 11	com/tencent/xweb/ac:BEL	Z
    //   12: ifeq +13 -> 25
    //   15: sipush 3961
    //   18: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: iconst_1
    //   26: putstatic 11	com/tencent/xweb/ac:BEL	Z
    //   29: getstatic 55	com/tencent/xweb/WebView$d:BEq	Lcom/tencent/xweb/WebView$d;
    //   32: invokestatic 61	com/tencent/xweb/c/l:e	(Lcom/tencent/xweb/WebView$d;)Lcom/tencent/xweb/c/l$a;
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull +9 -> 46
    //   40: aload_0
    //   41: invokeinterface 75 1 0
    //   46: getstatic 78	com/tencent/xweb/WebView$d:BEr	Lcom/tencent/xweb/WebView$d;
    //   49: invokestatic 61	com/tencent/xweb/c/l:e	(Lcom/tencent/xweb/WebView$d;)Lcom/tencent/xweb/c/l$a;
    //   52: astore_0
    //   53: aload_0
    //   54: ifnull +9 -> 63
    //   57: aload_0
    //   58: invokeinterface 75 1 0
    //   63: sipush 3961
    //   66: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: goto -48 -> 21
    //   72: astore_0
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_0
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   35	23	0	locala	l.a
    //   72	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	21	72	finally
    //   25	36	72	finally
    //   40	46	72	finally
    //   46	53	72	finally
    //   57	63	72	finally
    //   63	69	72	finally
  }
  
  private static void jT(Context paramContext)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(3962);
        if (paramContext == null)
        {
          AppMethodBeat.o(3962);
          return;
        }
        if (BEM)
        {
          AppMethodBeat.o(3962);
          continue;
        }
        XWalkEnvironment.init(paramContext);
      }
      finally {}
      l.a locala = l.e(WebView.d.BEq);
      if (locala != null) {
        locala.initEnviroment(paramContext);
      }
      locala = l.e(WebView.d.BEr);
      if (locala != null) {
        locala.initEnviroment(paramContext);
      }
      BEM = true;
      AppMethodBeat.o(3962);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.ac
 * JD-Core Version:    0.7.0.1
 */