package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.c.c;

public final class al
{
  private static ak ynO = null;
  private ak mqF;
  public HandlerThread oNc;
  private String threadName;
  
  public al()
  {
    AppMethodBeat.i(52124);
    this.oNc = null;
    this.mqF = null;
    this.threadName = null;
    ab.i("MicroMsg.MMHandlerThread", "init stack:%s", new Object[] { bo.dtY() });
    Eg(null);
    AppMethodBeat.o(52124);
  }
  
  public al(String paramString)
  {
    AppMethodBeat.i(52125);
    this.oNc = null;
    this.mqF = null;
    this.threadName = null;
    Eg(paramString);
    AppMethodBeat.o(52125);
  }
  
  private void Eg(String paramString)
  {
    AppMethodBeat.i(52118);
    this.mqF = null;
    String str = paramString;
    if (bo.isNullOrNil(paramString)) {
      str = "MMHandlerThread";
    }
    this.threadName = str;
    this.oNc = c.aqv(this.threadName);
    this.oNc.start();
    AppMethodBeat.o(52118);
  }
  
  public static void Nf(int paramInt)
  {
    AppMethodBeat.i(52119);
    try
    {
      Process.setThreadPriority(paramInt);
      ab.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d ok", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(52119);
      return;
    }
    catch (Exception localException)
    {
      ab.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d fail, %s", new Object[] { Integer.valueOf(paramInt), localException.getMessage() });
      ab.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      AppMethodBeat.o(52119);
    }
  }
  
  public static void ae(Runnable paramRunnable)
  {
    AppMethodBeat.i(52139);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(52139);
      return;
    }
    dtf().removeCallbacks(paramRunnable);
    AppMethodBeat.o(52139);
  }
  
  public static void d(Runnable paramRunnable)
  {
    AppMethodBeat.i(52137);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(52137);
      return;
    }
    dtf().post(paramRunnable);
    AppMethodBeat.o(52137);
  }
  
  private static ak dtf()
  {
    AppMethodBeat.i(52136);
    if (ynO == null) {
      ynO = new ak(Looper.getMainLooper());
    }
    ak localak = ynO;
    AppMethodBeat.o(52136);
    return localak;
  }
  
  public static boolean isMainThread()
  {
    AppMethodBeat.i(52134);
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId())
    {
      AppMethodBeat.o(52134);
      return true;
    }
    AppMethodBeat.o(52134);
    return false;
  }
  
  public static void p(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(52138);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(52138);
      return;
    }
    dtf().postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(52138);
  }
  
  public final void Bk()
  {
    AppMethodBeat.i(52122);
    if ((this.oNc == null) || (!this.oNc.isAlive()))
    {
      ab.e("MicroMsg.MMHandlerThread", "setHighPriority failed thread is dead");
      AppMethodBeat.o(52122);
      return;
    }
    int i = this.oNc.getThreadId();
    try
    {
      if (-8 == Process.getThreadPriority(i))
      {
        ab.w("MicroMsg.MMHandlerThread", "setHighPriority No Need.");
        AppMethodBeat.o(52122);
        return;
      }
      Process.setThreadPriority(i, -8);
      ab.i("MicroMsg.MMHandlerThread", "thread:%d setHighPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      AppMethodBeat.o(52122);
      return;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.MMHandlerThread", "thread:%d setHighPriority failed", new Object[] { Integer.valueOf(i) });
      ab.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      AppMethodBeat.o(52122);
    }
  }
  
  public final int a(final a parama)
  {
    AppMethodBeat.i(52133);
    if (new ak(this.oNc.getLooper()).postAtFrontOfQueueV2(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(52116);
        parama.acS();
        al.af(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(52115);
            al.2.this.ynS.acT();
            AppMethodBeat.o(52115);
          }
        });
        AppMethodBeat.o(52116);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(52117);
        String str = super.toString() + "|" + parama.toString();
        AppMethodBeat.o(52117);
        return str;
      }
    }))
    {
      AppMethodBeat.o(52133);
      return 0;
    }
    AppMethodBeat.o(52133);
    return -2;
  }
  
  /* Error */
  public final int a(final b paramb)
  {
    // Byte code:
    //   0: ldc 216
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 46
    //   7: ldc 218
    //   9: iconst_2
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: invokestatic 159	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   18: invokevirtual 163	java/lang/Thread:getId	()J
    //   21: invokestatic 223	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: invokestatic 54	com/tencent/mm/sdk/platformtools/bo:dtY	()Lcom/tencent/mm/sdk/platformtools/an;
    //   30: aastore
    //   31: invokestatic 59	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: ldc 225
    //   36: invokestatic 227	com/tencent/mm/sdk/platformtools/al:isMainThread	()Z
    //   39: invokestatic 233	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   42: aload_0
    //   43: getfield 40	com/tencent/mm/sdk/platformtools/al:oNc	Landroid/os/HandlerThread;
    //   46: invokevirtual 234	android/os/HandlerThread:getId	()J
    //   49: lstore_3
    //   50: iconst_0
    //   51: newarray byte
    //   53: astore 7
    //   55: new 6	com/tencent/mm/sdk/platformtools/al$1
    //   58: dup
    //   59: aload_0
    //   60: aload_1
    //   61: aload_0
    //   62: getfield 44	com/tencent/mm/sdk/platformtools/al:threadName	Ljava/lang/String;
    //   65: aload 7
    //   67: invokespecial 237	com/tencent/mm/sdk/platformtools/al$1:<init>	(Lcom/tencent/mm/sdk/platformtools/al;Lcom/tencent/mm/sdk/platformtools/al$b;Ljava/lang/String;Ljava/lang/Object;)V
    //   70: astore_1
    //   71: aload 7
    //   73: monitorenter
    //   74: aload_0
    //   75: aload_1
    //   76: invokevirtual 239	com/tencent/mm/sdk/platformtools/al:a	(Lcom/tencent/mm/sdk/platformtools/al$a;)I
    //   79: istore_2
    //   80: aload_0
    //   81: getfield 40	com/tencent/mm/sdk/platformtools/al:oNc	Landroid/os/HandlerThread;
    //   84: invokevirtual 234	android/os/HandlerThread:getId	()J
    //   87: lstore 5
    //   89: ldc 46
    //   91: ldc 241
    //   93: iconst_3
    //   94: anewarray 4	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: iload_2
    //   100: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: lload_3
    //   107: invokestatic 223	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   110: aastore
    //   111: dup
    //   112: iconst_2
    //   113: lload 5
    //   115: invokestatic 223	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   118: aastore
    //   119: invokestatic 59	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: iload_2
    //   123: ifne +15 -> 138
    //   126: lload_3
    //   127: lload 5
    //   129: lcmp
    //   130: ifne +8 -> 138
    //   133: aload 7
    //   135: invokevirtual 244	java/lang/Object:wait	()V
    //   138: aload 7
    //   140: monitorexit
    //   141: ldc 216
    //   143: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iload_2
    //   147: ireturn
    //   148: astore_1
    //   149: ldc 46
    //   151: ldc 246
    //   153: iconst_1
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload_1
    //   160: invokevirtual 108	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   163: aastore
    //   164: invokestatic 248	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: goto -29 -> 138
    //   170: astore_1
    //   171: aload 7
    //   173: monitorexit
    //   174: ldc 216
    //   176: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload_1
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	al
    //   0	181	1	paramb	b
    //   79	68	2	i	int
    //   49	78	3	l1	long
    //   87	41	5	l2	long
    //   53	119	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   133	138	148	java/lang/Exception
    //   74	122	170	finally
    //   133	138	170	finally
    //   138	141	170	finally
    //   149	167	170	finally
    //   171	174	170	finally
  }
  
  public final int ac(Runnable paramRunnable)
  {
    AppMethodBeat.i(52130);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(52130);
      return -1;
    }
    caB().post(paramRunnable);
    AppMethodBeat.o(52130);
    return 0;
  }
  
  public final int ad(Runnable paramRunnable)
  {
    AppMethodBeat.i(52131);
    caB().postAtFrontOfQueueV2(paramRunnable);
    AppMethodBeat.o(52131);
    return 0;
  }
  
  public final ak caB()
  {
    AppMethodBeat.i(52127);
    if (this.mqF == null) {
      this.mqF = new ak(this.oNc.getLooper());
    }
    ak localak = this.mqF;
    AppMethodBeat.o(52127);
    return localak;
  }
  
  public final void dtb()
  {
    AppMethodBeat.i(52120);
    if ((this.oNc == null) || (!this.oNc.isAlive()))
    {
      ab.e("MicroMsg.MMHandlerThread", "setLowestPriority failed thread is dead");
      AppMethodBeat.o(52120);
      return;
    }
    int i = this.oNc.getThreadId();
    try
    {
      if (19 == Process.getThreadPriority(i))
      {
        ab.w("MicroMsg.MMHandlerThread", "setLowestPriority No Need.");
        AppMethodBeat.o(52120);
        return;
      }
      Process.setThreadPriority(i, 19);
      ab.i("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      AppMethodBeat.o(52120);
      return;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority failed", new Object[] { Integer.valueOf(i) });
      ab.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      AppMethodBeat.o(52120);
    }
  }
  
  public final int dtc()
  {
    AppMethodBeat.i(52121);
    if (this.oNc == null)
    {
      AppMethodBeat.o(52121);
      return -1;
    }
    int i = this.oNc.getThreadId();
    AppMethodBeat.o(52121);
    return i;
  }
  
  public final void dtd()
  {
    AppMethodBeat.i(52123);
    if ((this.oNc == null) || (!this.oNc.isAlive()))
    {
      ab.e("MicroMsg.MMHandlerThread", "setLowPriority failed thread is dead");
      AppMethodBeat.o(52123);
      return;
    }
    int i = this.oNc.getThreadId();
    try
    {
      if (Process.getThreadPriority(i) == 0)
      {
        ab.w("MicroMsg.MMHandlerThread", "setLowPriority No Need.");
        AppMethodBeat.o(52123);
        return;
      }
      Process.setThreadPriority(i, 0);
      ab.i("MicroMsg.MMHandlerThread", "thread:%d setLowPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      AppMethodBeat.o(52123);
      return;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.MMHandlerThread", "thread:%d setLowPriority failed", new Object[] { Integer.valueOf(i) });
      ab.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      AppMethodBeat.o(52123);
    }
  }
  
  public final boolean dte()
  {
    AppMethodBeat.i(52135);
    if (Thread.currentThread().getId() == this.oNc.getId())
    {
      AppMethodBeat.o(52135);
      return true;
    }
    AppMethodBeat.o(52135);
    return false;
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(156808);
    Looper localLooper = this.oNc.getLooper();
    AppMethodBeat.o(156808);
    return localLooper;
  }
  
  public final int o(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(52132);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(52132);
      return -1;
    }
    caB().postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(52132);
    return 0;
  }
  
  public final boolean quit()
  {
    AppMethodBeat.i(156809);
    boolean bool = this.oNc.quit();
    AppMethodBeat.o(156809);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean acS();
    
    public abstract boolean acT();
  }
  
  public static abstract interface b
  {
    public abstract void tU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.al
 * JD-Core Version:    0.7.0.1
 */