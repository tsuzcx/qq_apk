package com.tencent.xweb;

import android.content.Context;
import com.tencent.xweb.c.j;
import com.tencent.xweb.c.j.a;
import com.tencent.xweb.util.b;
import com.tencent.xweb.util.e;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public final class t
{
  static boolean xhy = false;
  static boolean xhz = false;
  
  public static void a(Context paramContext, b paramb)
  {
    a(paramContext, paramb, null, null);
  }
  
  public static void a(Context paramContext, b paramb, r paramr, WebViewExtensionListener paramWebViewExtensionListener)
  {
    if (paramb != null) {}
    try
    {
      Log.SetLogCallBack(paramb);
      if (paramr != null) {
        e.a(paramr);
      }
      if (((paramContext != null) && (XWalkEnvironment.getApplicationContext() == null)) || (!xhy))
      {
        xhy = true;
        XWalkEnvironment.init(paramContext);
        paramb = j.c(WebView.d.xho);
        if (paramb != null) {
          paramb.initEnviroment(paramContext);
        }
        paramb = j.c(WebView.d.xhp);
        if (paramb != null) {
          paramb.initEnviroment(paramContext);
        }
      }
      if (paramWebViewExtensionListener != null) {
        j.c(WebView.d.xho).initCallback(paramWebViewExtensionListener);
      }
      XWebCoreContentProvider.cSw();
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
    //   3: getstatic 13	com/tencent/xweb/t:xhz	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 13	com/tencent/xweb/t:xhz	Z
    //   19: getstatic 46	com/tencent/xweb/WebView$d:xho	Lcom/tencent/xweb/WebView$d;
    //   22: invokestatic 52	com/tencent/xweb/c/j:c	(Lcom/tencent/xweb/WebView$d;)Lcom/tencent/xweb/c/j$a;
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +9 -> 36
    //   30: aload_1
    //   31: invokeinterface 72 1 0
    //   36: getstatic 60	com/tencent/xweb/WebView$d:xhp	Lcom/tencent/xweb/WebView$d;
    //   39: invokestatic 52	com/tencent/xweb/c/j:c	(Lcom/tencent/xweb/WebView$d;)Lcom/tencent/xweb/c/j$a;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull -33 -> 11
    //   47: aload_1
    //   48: invokeinterface 72 1 0
    //   53: goto -42 -> 11
    //   56: astore_1
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   25	23	1	locala	j.a
    //   56	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	56	finally
    //   15	26	56	finally
    //   30	36	56	finally
    //   36	43	56	finally
    //   47	53	56	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.t
 * JD-Core Version:    0.7.0.1
 */