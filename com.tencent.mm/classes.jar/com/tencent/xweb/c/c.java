package com.tencent.xweb.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.d;
import java.util.Date;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

public final class c
{
  public static HashMap<String, c> BGT;
  static String BGU;
  SharedPreferences BGK;
  private String BGL;
  private String BGM;
  private String BGN;
  private long BGO;
  private long BGP;
  public long BGQ;
  private String BGR;
  boolean BGS;
  
  static
  {
    AppMethodBeat.i(3980);
    BGT = new HashMap();
    BGU = "";
    AppMethodBeat.o(3980);
  }
  
  private c(String paramString, WebView.d paramd)
  {
    AppMethodBeat.i(3971);
    this.BGS = false;
    this.BGK = e(paramString, paramd);
    this.BGL = "INIT_START_TIME".concat(String.valueOf(paramString));
    this.BGM = "INIT_END_TIME".concat(String.valueOf(paramString));
    this.BGN = "INIT_TRY_COUNT".concat(String.valueOf(paramString));
    this.BGR = paramString;
    if (this.BGK == null)
    {
      AppMethodBeat.o(3971);
      return;
    }
    this.BGO = this.BGK.getLong(this.BGL, 0L);
    this.BGP = this.BGK.getLong(this.BGM, 0L);
    this.BGQ = this.BGK.getLong(this.BGN, 0L);
    AppMethodBeat.o(3971);
  }
  
  /* Error */
  public static boolean b(WebView.d paramd)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: sipush 3975
    //   8: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: invokestatic 98	com/tencent/xweb/q:dYn	()Lcom/tencent/xweb/q;
    //   14: getfield 101	com/tencent/xweb/q:BDP	Z
    //   17: ifeq +14 -> 31
    //   20: sipush 3975
    //   23: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: ldc 2
    //   28: monitorexit
    //   29: iload_1
    //   30: ireturn
    //   31: ldc 103
    //   33: aload_0
    //   34: invokestatic 107	com/tencent/xweb/c/c:c	(Ljava/lang/String;Lcom/tencent/xweb/WebView$d;)Lcom/tencent/xweb/c/c;
    //   37: invokespecial 111	com/tencent/xweb/c/c:dYP	()Z
    //   40: ifeq +14 -> 54
    //   43: sipush 3975
    //   46: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: iconst_1
    //   50: istore_1
    //   51: goto -25 -> 26
    //   54: new 2	com/tencent/xweb/c/c
    //   57: dup
    //   58: ldc 113
    //   60: aload_0
    //   61: invokespecial 115	com/tencent/xweb/c/c:<init>	(Ljava/lang/String;Lcom/tencent/xweb/WebView$d;)V
    //   64: invokespecial 111	com/tencent/xweb/c/c:dYP	()Z
    //   67: ifeq +14 -> 81
    //   70: sipush 3975
    //   73: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: iconst_1
    //   77: istore_1
    //   78: goto -52 -> 26
    //   81: sipush 3975
    //   84: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: goto -61 -> 26
    //   90: astore_0
    //   91: ldc 2
    //   93: monitorexit
    //   94: aload_0
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramd	WebView.d
    //   1	77	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	26	90	finally
    //   31	49	90	finally
    //   54	76	90	finally
    //   81	87	90	finally
  }
  
  public static c c(String paramString, WebView.d paramd)
  {
    try
    {
      AppMethodBeat.i(3972);
      String str = d(paramString, paramd);
      c localc2 = (c)BGT.get(str);
      c localc1 = localc2;
      if (localc2 == null)
      {
        localc1 = new c(paramString, paramd);
        BGT.put(str, localc1);
      }
      AppMethodBeat.o(3972);
      return localc1;
    }
    finally {}
  }
  
  private static String d(String paramString, WebView.d paramd)
  {
    AppMethodBeat.i(3978);
    paramString = "INIT_SP_TAG_" + paramd.toString() + paramString;
    AppMethodBeat.o(3978);
    return paramString;
  }
  
  private boolean dYP()
  {
    boolean bool = false;
    for (;;)
    {
      long l;
      try
      {
        AppMethodBeat.i(3977);
        if (this.BGK == null)
        {
          AppMethodBeat.o(3977);
          return bool;
        }
        l = new Date().getTime();
        if (!pe(l))
        {
          AppMethodBeat.o(3977);
          continue;
        }
        if (this.BGQ <= 4L) {
          break label136;
        }
      }
      finally {}
      XWalkEnvironment.addXWalkInitializeLog("Scene " + this.BGR + " crashed " + (l - this.BGO) / 60000L + " minutes ago, try count = " + this.BGQ);
      bool = true;
      AppMethodBeat.o(3977);
      continue;
      label136:
      AppMethodBeat.o(3977);
    }
  }
  
  /* Error */
  private static SharedPreferences e(String paramString, WebView.d paramd)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: sipush 3979
    //   6: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: getstatic 178	com/tencent/xweb/WebView$d:BEq	Lcom/tencent/xweb/WebView$d;
    //   13: if_acmpeq +23 -> 36
    //   16: aload_1
    //   17: getstatic 181	com/tencent/xweb/WebView$d:BEs	Lcom/tencent/xweb/WebView$d;
    //   20: if_acmpeq +16 -> 36
    //   23: aconst_null
    //   24: astore_0
    //   25: sipush 3979
    //   28: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_0
    //   35: areturn
    //   36: aload_0
    //   37: aload_1
    //   38: invokestatic 119	com/tencent/xweb/c/c:d	(Ljava/lang/String;Lcom/tencent/xweb/WebView$d;)Ljava/lang/String;
    //   41: astore_0
    //   42: aload_0
    //   43: putstatic 40	com/tencent/xweb/c/c:BGU	Ljava/lang/String;
    //   46: aload_0
    //   47: invokestatic 185	org/xwalk/core/XWalkEnvironment:getMMKVSharedTransportOld	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   50: astore_0
    //   51: sipush 3979
    //   54: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: goto -26 -> 31
    //   60: astore_0
    //   61: ldc 2
    //   63: monitorexit
    //   64: aload_0
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	paramString	String
    //   0	66	1	paramd	WebView.d
    // Exception table:
    //   from	to	target	type
    //   3	23	60	finally
    //   25	31	60	finally
    //   36	57	60	finally
  }
  
  private boolean pe(long paramLong)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(3976);
        if (0L == this.BGO)
        {
          AppMethodBeat.o(3976);
          return bool;
        }
        if ((this.BGP - this.BGO >= 0L) || (Math.abs(paramLong - this.BGO) > 10800000L))
        {
          AppMethodBeat.o(3976);
          continue;
        }
        if (this.BGP >= this.BGO) {
          break label98;
        }
      }
      finally {}
      bool = true;
      AppMethodBeat.o(3976);
      continue;
      label98:
      AppMethodBeat.o(3976);
    }
  }
  
  public final void dYN()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(3973);
        if (this.BGS)
        {
          AppMethodBeat.o(3973);
          return;
        }
        this.BGS = true;
        if (this.BGK == null)
        {
          AppMethodBeat.o(3973);
          continue;
        }
        localEditor = this.BGK.edit();
      }
      finally {}
      SharedPreferences.Editor localEditor;
      localEditor.putLong(this.BGN, this.BGQ + 1L);
      long l = new Date().getTime();
      if (pe(l))
      {
        localEditor.commit();
        AppMethodBeat.o(3973);
      }
      else
      {
        localEditor.putLong(this.BGL, l);
        localEditor.commit();
        AppMethodBeat.o(3973);
      }
    }
  }
  
  /* Error */
  public final void dYO()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 3974
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 54	com/tencent/xweb/c/c:BGK	Landroid/content/SharedPreferences;
    //   12: ifnonnull +12 -> 24
    //   15: sipush 3974
    //   18: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 54	com/tencent/xweb/c/c:BGK	Landroid/content/SharedPreferences;
    //   28: invokeinterface 198 1 0
    //   33: astore_1
    //   34: aload_1
    //   35: aload_0
    //   36: getfield 72	com/tencent/xweb/c/c:BGM	Ljava/lang/String;
    //   39: new 147	java/util/Date
    //   42: dup
    //   43: invokespecial 148	java/util/Date:<init>	()V
    //   46: invokevirtual 152	java/util/Date:getTime	()J
    //   49: invokeinterface 204 4 0
    //   54: pop
    //   55: aload_1
    //   56: aload_0
    //   57: getfield 76	com/tencent/xweb/c/c:BGN	Ljava/lang/String;
    //   60: lconst_0
    //   61: invokeinterface 204 4 0
    //   66: pop
    //   67: aload_1
    //   68: invokeinterface 207 1 0
    //   73: pop
    //   74: aload_0
    //   75: aconst_null
    //   76: putfield 54	com/tencent/xweb/c/c:BGK	Landroid/content/SharedPreferences;
    //   79: sipush 3974
    //   82: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: goto -64 -> 21
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	c
    //   33	35	1	localEditor	SharedPreferences.Editor
    //   88	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	88	finally
    //   24	85	88	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.c.c
 * JD-Core Version:    0.7.0.1
 */