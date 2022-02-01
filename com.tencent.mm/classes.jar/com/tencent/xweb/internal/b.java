package com.tencent.xweb.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.c;
import java.util.Date;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

public final class b
{
  public static HashMap<String, b> IQC;
  static String IQD;
  private String IQA;
  boolean IQB;
  private String IQu;
  private String IQv;
  private String IQw;
  private long IQx;
  private long IQy;
  public long IQz;
  SharedPreferences xZp;
  
  static
  {
    AppMethodBeat.i(156967);
    IQC = new HashMap();
    IQD = "";
    AppMethodBeat.o(156967);
  }
  
  private b(String paramString, WebView.c paramc)
  {
    AppMethodBeat.i(156958);
    this.IQB = false;
    this.xZp = e(paramString, paramc);
    this.IQu = "INIT_START_TIME".concat(String.valueOf(paramString));
    this.IQv = "INIT_END_TIME".concat(String.valueOf(paramString));
    this.IQw = "INIT_TRY_COUNT".concat(String.valueOf(paramString));
    this.IQA = paramString;
    if (this.xZp == null)
    {
      AppMethodBeat.o(156958);
      return;
    }
    this.IQx = this.xZp.getLong(this.IQu, 0L);
    this.IQy = this.xZp.getLong(this.IQv, 0L);
    this.IQz = this.xZp.getLong(this.IQw, 0L);
    AppMethodBeat.o(156958);
  }
  
  public static b c(String paramString, WebView.c paramc)
  {
    try
    {
      AppMethodBeat.i(156959);
      String str = d(paramString, paramc);
      b localb2 = (b)IQC.get(str);
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b(paramString, paramc);
        IQC.put(str, localb1);
      }
      AppMethodBeat.o(156959);
      return localb1;
    }
    finally {}
  }
  
  /* Error */
  public static boolean c(WebView.c paramc)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 111
    //   7: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 117	com/tencent/xweb/x:fqR	()Lcom/tencent/xweb/x;
    //   13: getfield 120	com/tencent/xweb/x:INg	Z
    //   16: ifeq +13 -> 29
    //   19: ldc 111
    //   21: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc 2
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: ldc 122
    //   31: aload_0
    //   32: invokestatic 124	com/tencent/xweb/internal/b:c	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)Lcom/tencent/xweb/internal/b;
    //   35: invokespecial 128	com/tencent/xweb/internal/b:frK	()Z
    //   38: ifeq +20 -> 58
    //   41: aload_0
    //   42: getstatic 134	com/tencent/xweb/util/g$b$a:IRI	I
    //   45: invokestatic 140	com/tencent/xweb/util/g:a	(Lcom/tencent/xweb/WebView$c;I)V
    //   48: ldc 111
    //   50: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: iconst_1
    //   54: istore_1
    //   55: goto -31 -> 24
    //   58: new 2	com/tencent/xweb/internal/b
    //   61: dup
    //   62: ldc 142
    //   64: aload_0
    //   65: invokespecial 105	com/tencent/xweb/internal/b:<init>	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)V
    //   68: invokespecial 128	com/tencent/xweb/internal/b:frK	()Z
    //   71: ifeq +20 -> 91
    //   74: aload_0
    //   75: getstatic 145	com/tencent/xweb/util/g$b$a:IRJ	I
    //   78: invokestatic 140	com/tencent/xweb/util/g:a	(Lcom/tencent/xweb/WebView$c;I)V
    //   81: ldc 111
    //   83: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: iconst_1
    //   87: istore_1
    //   88: goto -64 -> 24
    //   91: ldc 111
    //   93: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: goto -72 -> 24
    //   99: astore_0
    //   100: ldc 2
    //   102: monitorexit
    //   103: aload_0
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramc	WebView.c
    //   1	87	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	24	99	finally
    //   29	53	99	finally
    //   58	86	99	finally
    //   91	96	99	finally
  }
  
  private static String d(String paramString, WebView.c paramc)
  {
    AppMethodBeat.i(156965);
    paramString = "INIT_SP_TAG_" + paramc.toString() + paramString;
    AppMethodBeat.o(156965);
    return paramString;
  }
  
  /* Error */
  private static SharedPreferences e(String paramString, WebView.c paramc)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 165
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: getstatic 169	com/tencent/xweb/WebView$c:INC	Lcom/tencent/xweb/WebView$c;
    //   12: if_acmpeq +22 -> 34
    //   15: aload_1
    //   16: getstatic 172	com/tencent/xweb/WebView$c:INE	Lcom/tencent/xweb/WebView$c;
    //   19: if_acmpeq +15 -> 34
    //   22: aconst_null
    //   23: astore_0
    //   24: ldc 165
    //   26: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: ldc 2
    //   31: monitorexit
    //   32: aload_0
    //   33: areturn
    //   34: aload_0
    //   35: aload_1
    //   36: invokestatic 99	com/tencent/xweb/internal/b:d	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)Ljava/lang/String;
    //   39: astore_0
    //   40: aload_0
    //   41: putstatic 41	com/tencent/xweb/internal/b:IQD	Ljava/lang/String;
    //   44: aload_0
    //   45: invokestatic 178	org/xwalk/core/XWalkEnvironment:getMMKVSharedTransportOld	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   48: astore_0
    //   49: ldc 165
    //   51: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: goto -25 -> 29
    //   57: astore_0
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload_0
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramString	String
    //   0	63	1	paramc	WebView.c
    // Exception table:
    //   from	to	target	type
    //   3	22	57	finally
    //   24	29	57	finally
    //   34	54	57	finally
  }
  
  private boolean frK()
  {
    boolean bool = false;
    for (;;)
    {
      long l;
      try
      {
        AppMethodBeat.i(156964);
        if (this.xZp == null)
        {
          AppMethodBeat.o(156964);
          return bool;
        }
        l = new Date().getTime();
        if (!xr(l))
        {
          AppMethodBeat.o(156964);
          continue;
        }
        if (this.IQz <= 4L) {
          break label132;
        }
      }
      finally {}
      XWalkEnvironment.addXWalkInitializeLog("Scene " + this.IQA + " crashed " + (l - this.IQx) / 60000L + " minutes ago, try count = " + this.IQz);
      bool = true;
      AppMethodBeat.o(156964);
      continue;
      label132:
      AppMethodBeat.o(156964);
    }
  }
  
  private boolean xr(long paramLong)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156963);
        if (0L == this.IQx)
        {
          AppMethodBeat.o(156963);
          return bool;
        }
        if ((this.IQy - this.IQx >= 0L) || (Math.abs(paramLong - this.IQx) > 10800000L))
        {
          AppMethodBeat.o(156963);
          continue;
        }
        if (this.IQy >= this.IQx) {
          break label94;
        }
      }
      finally {}
      bool = true;
      AppMethodBeat.o(156963);
      continue;
      label94:
      AppMethodBeat.o(156963);
    }
  }
  
  public final void frI()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156960);
        if (this.IQB)
        {
          AppMethodBeat.o(156960);
          return;
        }
        this.IQB = true;
        if (this.xZp == null)
        {
          AppMethodBeat.o(156960);
          continue;
        }
        localEditor = this.xZp.edit();
      }
      finally {}
      SharedPreferences.Editor localEditor;
      localEditor.putLong(this.IQw, this.IQz + 1L);
      long l = new Date().getTime();
      if (xr(l))
      {
        localEditor.commit();
        AppMethodBeat.o(156960);
      }
      else
      {
        localEditor.putLong(this.IQu, l);
        localEditor.commit();
        AppMethodBeat.o(156960);
      }
    }
  }
  
  /* Error */
  public final void frJ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 232
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 56	com/tencent/xweb/internal/b:xZp	Landroid/content/SharedPreferences;
    //   11: ifnonnull +11 -> 22
    //   14: ldc 232
    //   16: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 56	com/tencent/xweb/internal/b:xZp	Landroid/content/SharedPreferences;
    //   26: invokeinterface 221 1 0
    //   31: astore_1
    //   32: aload_1
    //   33: aload_0
    //   34: getfield 74	com/tencent/xweb/internal/b:IQv	Ljava/lang/String;
    //   37: new 181	java/util/Date
    //   40: dup
    //   41: invokespecial 182	java/util/Date:<init>	()V
    //   44: invokevirtual 186	java/util/Date:getTime	()J
    //   47: invokeinterface 227 4 0
    //   52: pop
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 78	com/tencent/xweb/internal/b:IQw	Ljava/lang/String;
    //   58: lconst_0
    //   59: invokeinterface 227 4 0
    //   64: pop
    //   65: aload_1
    //   66: invokeinterface 230 1 0
    //   71: pop
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 56	com/tencent/xweb/internal/b:xZp	Landroid/content/SharedPreferences;
    //   77: ldc 232
    //   79: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: goto -63 -> 19
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	b
    //   31	35	1	localEditor	SharedPreferences.Editor
    //   85	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	85	finally
    //   22	82	85	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.internal.b
 * JD-Core Version:    0.7.0.1
 */