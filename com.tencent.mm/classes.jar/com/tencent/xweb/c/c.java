package com.tencent.xweb.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.xweb.WebView.d;
import java.util.Date;
import java.util.HashMap;

public final class c
{
  public static HashMap<String, c> xjw = new HashMap();
  static String xjx = "";
  SharedPreferences xjn;
  private String xjo;
  private String xjp;
  private String xjq;
  private long xjr;
  private long xjs;
  private long xjt;
  private String xju;
  boolean xjv = false;
  
  private c(String paramString, WebView.d paramd)
  {
    this.xjn = d(paramString, paramd);
    this.xjo = ("INIT_START_TIME" + paramString);
    this.xjp = ("INIT_END_TIME" + paramString);
    this.xjq = ("INIT_TRY_COUNT" + paramString);
    this.xju = paramString;
    if (this.xjn == null) {
      return;
    }
    this.xjr = this.xjn.getLong(this.xjo, 0L);
    this.xjs = this.xjn.getLong(this.xjp, 0L);
    this.xjt = this.xjn.getLong(this.xjq, 0L);
  }
  
  public static c b(String paramString, WebView.d paramd)
  {
    try
    {
      String str = c(paramString, paramd);
      c localc2 = (c)xjw.get(str);
      c localc1 = localc2;
      if (localc2 == null)
      {
        localc1 = new c(paramString, paramd);
        xjw.put(str, localc1);
      }
      return localc1;
    }
    finally {}
  }
  
  /* Error */
  public static boolean b(WebView.d paramd)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 107	com/tencent/xweb/k:cSk	()Lcom/tencent/xweb/k;
    //   8: getfield 110	com/tencent/xweb/k:xgR	Z
    //   11: istore_2
    //   12: iload_2
    //   13: ifeq +8 -> 21
    //   16: ldc 2
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: ldc 112
    //   23: aload_0
    //   24: invokestatic 114	com/tencent/xweb/c/c:b	(Ljava/lang/String;Lcom/tencent/xweb/WebView$d;)Lcom/tencent/xweb/c/c;
    //   27: invokespecial 118	com/tencent/xweb/c/c:cSI	()Z
    //   30: ifeq +8 -> 38
    //   33: iconst_1
    //   34: istore_1
    //   35: goto -19 -> 16
    //   38: new 2	com/tencent/xweb/c/c
    //   41: dup
    //   42: ldc 120
    //   44: aload_0
    //   45: invokespecial 96	com/tencent/xweb/c/c:<init>	(Ljava/lang/String;Lcom/tencent/xweb/WebView$d;)V
    //   48: invokespecial 118	com/tencent/xweb/c/c:cSI	()Z
    //   51: istore_2
    //   52: iload_2
    //   53: ifeq -37 -> 16
    //   56: iconst_1
    //   57: istore_1
    //   58: goto -42 -> 16
    //   61: astore_0
    //   62: ldc 2
    //   64: monitorexit
    //   65: aload_0
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramd	WebView.d
    //   1	57	1	bool1	boolean
    //   11	42	2	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   5	12	61	finally
    //   21	33	61	finally
    //   38	52	61	finally
  }
  
  private static String c(String paramString, WebView.d paramd)
  {
    return "INIT_SP_TAG_" + paramd.toString() + paramString;
  }
  
  /* Error */
  private boolean cSI()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 45	com/tencent/xweb/c/c:xjn	Landroid/content/SharedPreferences;
    //   8: astore 5
    //   10: aload 5
    //   12: ifnonnull +9 -> 21
    //   15: iload_2
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: new 127	java/util/Date
    //   24: dup
    //   25: invokespecial 128	java/util/Date:<init>	()V
    //   28: invokevirtual 132	java/util/Date:getTime	()J
    //   31: lstore_3
    //   32: iload_2
    //   33: istore_1
    //   34: aload_0
    //   35: lload_3
    //   36: invokespecial 136	com/tencent/xweb/c/c:is	(J)Z
    //   39: ifeq -22 -> 17
    //   42: iload_2
    //   43: istore_1
    //   44: aload_0
    //   45: getfield 84	com/tencent/xweb/c/c:xjt	J
    //   48: ldc2_w 137
    //   51: lcmp
    //   52: ifle -35 -> 17
    //   55: new 47	java/lang/StringBuilder
    //   58: dup
    //   59: ldc 140
    //   61: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: aload_0
    //   65: getfield 72	com/tencent/xweb/c/c:xju	Ljava/lang/String;
    //   68: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 142
    //   73: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: lload_3
    //   77: aload_0
    //   78: getfield 80	com/tencent/xweb/c/c:xjr	J
    //   81: lsub
    //   82: ldc2_w 143
    //   85: ldiv
    //   86: invokevirtual 147	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   89: ldc 149
    //   91: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 154	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   100: iconst_1
    //   101: istore_1
    //   102: goto -85 -> 17
    //   105: astore 5
    //   107: aload_0
    //   108: monitorexit
    //   109: aload 5
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	c
    //   16	86	1	bool1	boolean
    //   1	42	2	bool2	boolean
    //   31	46	3	l	long
    //   8	3	5	localSharedPreferences	SharedPreferences
    //   105	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	10	105	finally
    //   21	32	105	finally
    //   34	42	105	finally
    //   44	100	105	finally
  }
  
  /* Error */
  private static SharedPreferences d(String paramString, WebView.d paramd)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: getstatic 158	com/tencent/xweb/WebView$d:xho	Lcom/tencent/xweb/WebView$d;
    //   7: if_acmpeq +19 -> 26
    //   10: getstatic 161	com/tencent/xweb/WebView$d:xhq	Lcom/tencent/xweb/WebView$d;
    //   13: astore_2
    //   14: aload_1
    //   15: aload_2
    //   16: if_acmpeq +10 -> 26
    //   19: aconst_null
    //   20: astore_0
    //   21: ldc 2
    //   23: monitorexit
    //   24: aload_0
    //   25: areturn
    //   26: aload_0
    //   27: aload_1
    //   28: invokestatic 90	com/tencent/xweb/c/c:c	(Ljava/lang/String;Lcom/tencent/xweb/WebView$d;)Ljava/lang/String;
    //   31: astore_0
    //   32: aload_0
    //   33: putstatic 34	com/tencent/xweb/c/c:xjx	Ljava/lang/String;
    //   36: invokestatic 165	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   39: pop
    //   40: aload_0
    //   41: iconst_4
    //   42: invokestatic 169	org/xwalk/core/XWalkEnvironment:getProcessSafePreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   45: astore_0
    //   46: goto -25 -> 21
    //   49: astore_0
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramString	String
    //   0	55	1	paramd	WebView.d
    //   13	3	2	locald	WebView.d
    // Exception table:
    //   from	to	target	type
    //   3	14	49	finally
    //   26	46	49	finally
  }
  
  /* Error */
  private boolean is(long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 80	com/tencent/xweb/c/c:xjr	J
    //   9: lstore_3
    //   10: lconst_0
    //   11: lload_3
    //   12: lcmp
    //   13: ifne +12 -> 25
    //   16: iload 6
    //   18: istore 5
    //   20: aload_0
    //   21: monitorexit
    //   22: iload 5
    //   24: ireturn
    //   25: iload 6
    //   27: istore 5
    //   29: aload_0
    //   30: getfield 82	com/tencent/xweb/c/c:xjs	J
    //   33: aload_0
    //   34: getfield 80	com/tencent/xweb/c/c:xjr	J
    //   37: lsub
    //   38: lconst_0
    //   39: lcmp
    //   40: ifge -20 -> 20
    //   43: iload 6
    //   45: istore 5
    //   47: lload_1
    //   48: aload_0
    //   49: getfield 80	com/tencent/xweb/c/c:xjr	J
    //   52: lsub
    //   53: invokestatic 175	java/lang/Math:abs	(J)J
    //   56: ldc2_w 176
    //   59: lcmp
    //   60: ifgt -40 -> 20
    //   63: aload_0
    //   64: getfield 82	com/tencent/xweb/c/c:xjs	J
    //   67: lstore_1
    //   68: aload_0
    //   69: getfield 80	com/tencent/xweb/c/c:xjr	J
    //   72: lstore_3
    //   73: iload 6
    //   75: istore 5
    //   77: lload_1
    //   78: lload_3
    //   79: lcmp
    //   80: ifge -60 -> 20
    //   83: iconst_1
    //   84: istore 5
    //   86: goto -66 -> 20
    //   89: astore 7
    //   91: aload_0
    //   92: monitorexit
    //   93: aload 7
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	c
    //   0	96	1	paramLong	long
    //   9	70	3	l	long
    //   18	67	5	bool1	boolean
    //   1	73	6	bool2	boolean
    //   89	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	10	89	finally
    //   29	43	89	finally
    //   47	73	89	finally
  }
  
  public final void cSG()
  {
    for (;;)
    {
      long l;
      try
      {
        boolean bool = this.xjv;
        if (bool) {
          return;
        }
        this.xjv = true;
        if (this.xjn == null) {
          continue;
        }
        l = new Date().getTime();
        if (is(l))
        {
          SharedPreferences.Editor localEditor1 = this.xjn.edit();
          localEditor1.putLong(this.xjq, this.xjt + 1L);
          localEditor1.commit();
          continue;
        }
        localEditor2 = this.xjn.edit();
      }
      finally {}
      SharedPreferences.Editor localEditor2;
      localEditor2.putLong(this.xjo, l);
      localEditor2.commit();
    }
  }
  
  /* Error */
  public final void cSH()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	com/tencent/xweb/c/c:xjn	Landroid/content/SharedPreferences;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 45	com/tencent/xweb/c/c:xjn	Landroid/content/SharedPreferences;
    //   18: invokeinterface 182 1 0
    //   23: astore_1
    //   24: aload_1
    //   25: aload_0
    //   26: getfield 66	com/tencent/xweb/c/c:xjp	Ljava/lang/String;
    //   29: new 127	java/util/Date
    //   32: dup
    //   33: invokespecial 128	java/util/Date:<init>	()V
    //   36: invokevirtual 132	java/util/Date:getTime	()J
    //   39: invokeinterface 188 4 0
    //   44: pop
    //   45: aload_1
    //   46: aload_0
    //   47: getfield 70	com/tencent/xweb/c/c:xjq	Ljava/lang/String;
    //   50: lconst_0
    //   51: invokeinterface 188 4 0
    //   56: pop
    //   57: aload_1
    //   58: invokeinterface 191 1 0
    //   63: pop
    //   64: aload_0
    //   65: aconst_null
    //   66: putfield 45	com/tencent/xweb/c/c:xjn	Landroid/content/SharedPreferences;
    //   69: goto -58 -> 11
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	c
    //   6	52	1	localObject1	Object
    //   72	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	72	finally
    //   14	69	72	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.c.c
 * JD-Core Version:    0.7.0.1
 */