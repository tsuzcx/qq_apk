package com.tencent.xweb.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import java.util.Date;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

public final class b
{
  public static HashMap<String, b> aaeL;
  static String aaeM;
  SharedPreferences aaeC;
  private String aaeD;
  private String aaeE;
  private String aaeF;
  private long aaeG;
  private long aaeH;
  public long aaeI;
  private String aaeJ;
  boolean aaeK;
  
  static
  {
    AppMethodBeat.i(156967);
    aaeL = new HashMap();
    aaeM = "";
    AppMethodBeat.o(156967);
  }
  
  private b(String paramString, WebView.c paramc)
  {
    AppMethodBeat.i(156958);
    this.aaeK = false;
    this.aaeC = f(paramString, paramc);
    this.aaeD = "INIT_START_TIME".concat(String.valueOf(paramString));
    this.aaeE = "INIT_END_TIME".concat(String.valueOf(paramString));
    this.aaeF = "INIT_TRY_COUNT".concat(String.valueOf(paramString));
    this.aaeJ = paramString;
    if (this.aaeC == null)
    {
      AppMethodBeat.o(156958);
      return;
    }
    this.aaeG = this.aaeC.getLong(this.aaeD, 0L);
    this.aaeH = this.aaeC.getLong(this.aaeE, 0L);
    this.aaeI = this.aaeC.getLong(this.aaeF, 0L);
    AppMethodBeat.o(156958);
  }
  
  private boolean Xe(long paramLong)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156963);
        if (0L == this.aaeG)
        {
          AppMethodBeat.o(156963);
          return bool;
        }
        if ((this.aaeH - this.aaeG >= 0L) || (Math.abs(paramLong - this.aaeG) > 10800000L))
        {
          AppMethodBeat.o(156963);
          continue;
        }
        if (this.aaeH >= this.aaeG) {
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
  
  private static b a(String paramString1, WebView.c paramc, String paramString2)
  {
    try
    {
      AppMethodBeat.i(196245);
      paramString1 = c(paramString1 + ":" + paramString2, paramc);
      AppMethodBeat.o(196245);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static b c(String paramString, WebView.c paramc)
  {
    try
    {
      AppMethodBeat.i(156959);
      e(paramString, paramc);
      paramString = new b(paramString, paramc);
      AppMethodBeat.o(156959);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static boolean c(WebView.c paramc)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 132
    //   7: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 138	com/tencent/xweb/y:iwp	()Lcom/tencent/xweb/y;
    //   13: getfield 141	com/tencent/xweb/y:aaaP	Z
    //   16: ifeq +13 -> 29
    //   19: ldc 132
    //   21: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc 2
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: ldc 143
    //   31: aload_0
    //   32: invokestatic 146	com/tencent/xweb/internal/b:d	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)Lcom/tencent/xweb/internal/b;
    //   35: invokespecial 150	com/tencent/xweb/internal/b:ixl	()Z
    //   38: ifeq +20 -> 58
    //   41: aload_0
    //   42: getstatic 156	com/tencent/xweb/util/h$b$a:aafW	I
    //   45: invokestatic 161	com/tencent/xweb/util/h:a	(Lcom/tencent/xweb/WebView$c;I)V
    //   48: ldc 132
    //   50: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: iconst_1
    //   54: istore_1
    //   55: goto -31 -> 24
    //   58: ldc 163
    //   60: aload_0
    //   61: invokestatic 146	com/tencent/xweb/internal/b:d	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)Lcom/tencent/xweb/internal/b;
    //   64: invokespecial 150	com/tencent/xweb/internal/b:ixl	()Z
    //   67: ifeq +20 -> 87
    //   70: aload_0
    //   71: getstatic 166	com/tencent/xweb/util/h$b$a:aafX	I
    //   74: invokestatic 161	com/tencent/xweb/util/h:a	(Lcom/tencent/xweb/WebView$c;I)V
    //   77: ldc 132
    //   79: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: iconst_1
    //   83: istore_1
    //   84: goto -60 -> 24
    //   87: ldc 132
    //   89: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: goto -68 -> 24
    //   95: astore_0
    //   96: ldc 2
    //   98: monitorexit
    //   99: aload_0
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramc	WebView.c
    //   1	83	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	24	95	finally
    //   29	53	95	finally
    //   58	82	95	finally
    //   87	92	95	finally
  }
  
  public static b d(String paramString, WebView.c paramc)
  {
    try
    {
      AppMethodBeat.i(196247);
      paramString = a(paramString, paramc, WebView.getCurStrModule());
      AppMethodBeat.o(196247);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static boolean d(WebView.c paramc)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 175
    //   7: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 138	com/tencent/xweb/y:iwp	()Lcom/tencent/xweb/y;
    //   13: getfield 141	com/tencent/xweb/y:aaaP	Z
    //   16: ifeq +13 -> 29
    //   19: ldc 175
    //   21: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc 2
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: ldc 143
    //   31: aload_0
    //   32: invokestatic 146	com/tencent/xweb/internal/b:d	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)Lcom/tencent/xweb/internal/b;
    //   35: invokespecial 150	com/tencent/xweb/internal/b:ixl	()Z
    //   38: ifeq +20 -> 58
    //   41: aload_0
    //   42: getstatic 156	com/tencent/xweb/util/h$b$a:aafW	I
    //   45: invokestatic 161	com/tencent/xweb/util/h:a	(Lcom/tencent/xweb/WebView$c;I)V
    //   48: ldc 175
    //   50: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: iconst_1
    //   54: istore_1
    //   55: goto -31 -> 24
    //   58: ldc 163
    //   60: aload_0
    //   61: invokestatic 146	com/tencent/xweb/internal/b:d	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)Lcom/tencent/xweb/internal/b;
    //   64: invokespecial 150	com/tencent/xweb/internal/b:ixl	()Z
    //   67: ifeq +20 -> 87
    //   70: aload_0
    //   71: getstatic 166	com/tencent/xweb/util/h$b$a:aafX	I
    //   74: invokestatic 161	com/tencent/xweb/util/h:a	(Lcom/tencent/xweb/WebView$c;I)V
    //   77: ldc 175
    //   79: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: iconst_1
    //   83: istore_1
    //   84: goto -60 -> 24
    //   87: ldc 175
    //   89: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: goto -68 -> 24
    //   95: astore_0
    //   96: ldc 2
    //   98: monitorexit
    //   99: aload_0
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramc	WebView.c
    //   1	83	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	24	95	finally
    //   29	53	95	finally
    //   58	82	95	finally
    //   87	92	95	finally
  }
  
  private static String e(String paramString, WebView.c paramc)
  {
    AppMethodBeat.i(156965);
    paramString = "INIT_SP_TAG_" + paramc.toString() + paramString;
    AppMethodBeat.o(156965);
    return paramString;
  }
  
  /* Error */
  private static SharedPreferences f(String paramString, WebView.c paramc)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 185
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: getstatic 189	com/tencent/xweb/WebView$c:aabm	Lcom/tencent/xweb/WebView$c;
    //   12: if_acmpeq +22 -> 34
    //   15: aload_1
    //   16: getstatic 192	com/tencent/xweb/WebView$c:aabo	Lcom/tencent/xweb/WebView$c;
    //   19: if_acmpeq +15 -> 34
    //   22: aconst_null
    //   23: astore_0
    //   24: ldc 185
    //   26: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: ldc 2
    //   31: monitorexit
    //   32: aload_0
    //   33: areturn
    //   34: aload_0
    //   35: aload_1
    //   36: invokestatic 128	com/tencent/xweb/internal/b:e	(Ljava/lang/String;Lcom/tencent/xweb/WebView$c;)Ljava/lang/String;
    //   39: astore_0
    //   40: aload_0
    //   41: putstatic 41	com/tencent/xweb/internal/b:aaeM	Ljava/lang/String;
    //   44: aload_0
    //   45: invokestatic 198	org/xwalk/core/XWalkEnvironment:getMMKVSharedTransportOld	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   48: astore_0
    //   49: ldc 185
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
  
  private boolean ixl()
  {
    boolean bool = false;
    for (;;)
    {
      long l;
      try
      {
        AppMethodBeat.i(156964);
        if (this.aaeC == null)
        {
          AppMethodBeat.o(156964);
          return bool;
        }
        l = new Date().getTime();
        if (!Xe(l))
        {
          AppMethodBeat.o(156964);
          continue;
        }
        if (this.aaeI <= 4L) {
          break label132;
        }
      }
      finally {}
      XWalkEnvironment.addXWalkInitializeLog("Scene " + this.aaeJ + " crashed " + (l - this.aaeG) / 60000L + " minutes ago, try count = " + this.aaeI);
      bool = true;
      AppMethodBeat.o(156964);
      continue;
      label132:
      AppMethodBeat.o(156964);
    }
  }
  
  public final void ixj()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156960);
        if (this.aaeK)
        {
          AppMethodBeat.o(156960);
          return;
        }
        this.aaeK = true;
        if (this.aaeC == null)
        {
          AppMethodBeat.o(156960);
          continue;
        }
        localEditor = this.aaeC.edit();
      }
      finally {}
      SharedPreferences.Editor localEditor;
      localEditor.putLong(this.aaeF, this.aaeI + 1L);
      long l = new Date().getTime();
      if (Xe(l))
      {
        localEditor.commit();
        AppMethodBeat.o(156960);
      }
      else
      {
        localEditor.putLong(this.aaeD, l);
        localEditor.commit();
        AppMethodBeat.o(156960);
      }
    }
  }
  
  /* Error */
  public final void ixk()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 241
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 56	com/tencent/xweb/internal/b:aaeC	Landroid/content/SharedPreferences;
    //   11: ifnonnull +11 -> 22
    //   14: ldc 241
    //   16: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 56	com/tencent/xweb/internal/b:aaeC	Landroid/content/SharedPreferences;
    //   26: invokeinterface 230 1 0
    //   31: astore_1
    //   32: aload_1
    //   33: aload_0
    //   34: getfield 74	com/tencent/xweb/internal/b:aaeE	Ljava/lang/String;
    //   37: new 201	java/util/Date
    //   40: dup
    //   41: invokespecial 202	java/util/Date:<init>	()V
    //   44: invokevirtual 206	java/util/Date:getTime	()J
    //   47: invokeinterface 236 4 0
    //   52: pop
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 78	com/tencent/xweb/internal/b:aaeF	Ljava/lang/String;
    //   58: lconst_0
    //   59: invokeinterface 236 4 0
    //   64: pop
    //   65: aload_1
    //   66: invokeinterface 239 1 0
    //   71: pop
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 56	com/tencent/xweb/internal/b:aaeC	Landroid/content/SharedPreferences;
    //   77: ldc 241
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