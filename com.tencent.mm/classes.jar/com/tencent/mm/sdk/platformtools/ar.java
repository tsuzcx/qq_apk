package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class ar
{
  private static aq hXp = null;
  public HandlerThread IxZ;
  private aq rxJ;
  private String threadName;
  
  @Deprecated
  public ar(HandlerThread paramHandlerThread)
  {
    AppMethodBeat.i(182963);
    this.IxZ = null;
    this.rxJ = null;
    this.threadName = null;
    this.rxJ = null;
    this.IxZ = paramHandlerThread;
    this.threadName = paramHandlerThread.getName();
    AppMethodBeat.o(182963);
  }
  
  public static void abe(int paramInt)
  {
    AppMethodBeat.i(157676);
    try
    {
      Process.setThreadPriority(paramInt);
      ae.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d ok", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(157676);
      return;
    }
    catch (Exception localException)
    {
      ae.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d fail, %s", new Object[] { Integer.valueOf(paramInt), localException.getMessage() });
      ae.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      AppMethodBeat.o(157676);
    }
  }
  
  public static void ay(Runnable paramRunnable)
  {
    AppMethodBeat.i(157697);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(157697);
      return;
    }
    foP().removeCallbacks(paramRunnable);
    AppMethodBeat.o(157697);
  }
  
  public static void f(Runnable paramRunnable)
  {
    AppMethodBeat.i(157695);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(157695);
      return;
    }
    foP().post(paramRunnable);
    AppMethodBeat.o(157695);
  }
  
  private static aq foP()
  {
    AppMethodBeat.i(157694);
    if (hXp == null) {
      hXp = new aq(Looper.getMainLooper());
    }
    aq localaq = hXp;
    AppMethodBeat.o(157694);
    return localaq;
  }
  
  public static boolean isMainThread()
  {
    AppMethodBeat.i(157692);
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId())
    {
      AppMethodBeat.o(157692);
      return true;
    }
    AppMethodBeat.o(157692);
    return false;
  }
  
  public static void o(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(157696);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(157696);
      return;
    }
    foP().postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(157696);
  }
  
  public final void Mh()
  {
    AppMethodBeat.i(157679);
    if ((this.IxZ == null) || (!this.IxZ.isAlive()))
    {
      ae.e("MicroMsg.MMHandlerThread", "setHighPriority failed thread is dead");
      AppMethodBeat.o(157679);
      return;
    }
    int i = this.IxZ.getThreadId();
    try
    {
      if (-8 == Process.getThreadPriority(i))
      {
        ae.w("MicroMsg.MMHandlerThread", "setHighPriority No Need.");
        AppMethodBeat.o(157679);
        return;
      }
      Process.setThreadPriority(i, -8);
      ae.i("MicroMsg.MMHandlerThread", "thread:%d setHighPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      AppMethodBeat.o(157679);
      return;
    }
    catch (Exception localException)
    {
      ae.w("MicroMsg.MMHandlerThread", "thread:%d setHighPriority failed", new Object[] { Integer.valueOf(i) });
      ae.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      AppMethodBeat.o(157679);
    }
  }
  
  public final int a(final a parama)
  {
    AppMethodBeat.i(157691);
    if (new aq(this.IxZ.getLooper()).postAtFrontOfQueue(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(157673);
        parama.aEC();
        ar.ac(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(157672);
            ar.2.this.Iyc.aED();
            AppMethodBeat.o(157672);
          }
        });
        AppMethodBeat.o(157673);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(157674);
        String str = super.toString() + "|" + parama.toString();
        AppMethodBeat.o(157674);
        return str;
      }
    }))
    {
      AppMethodBeat.o(157691);
      return 0;
    }
    AppMethodBeat.o(157691);
    return -2;
  }
  
  /* Error */
  public final int a(final b paramb)
  {
    // Byte code:
    //   0: ldc 206
    //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 84
    //   7: ldc 208
    //   9: iconst_2
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: invokestatic 150	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   18: invokevirtual 154	java/lang/Thread:getId	()J
    //   21: invokestatic 213	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: invokestatic 217	com/tencent/mm/sdk/platformtools/bu:fpN	()Lcom/tencent/mm/sdk/platformtools/au;
    //   30: aastore
    //   31: invokestatic 97	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: ldc 219
    //   36: invokestatic 221	com/tencent/mm/sdk/platformtools/ar:isMainThread	()Z
    //   39: invokestatic 227	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   42: aload_0
    //   43: getfield 42	com/tencent/mm/sdk/platformtools/ar:IxZ	Landroid/os/HandlerThread;
    //   46: invokevirtual 228	android/os/HandlerThread:getId	()J
    //   49: lstore_3
    //   50: iconst_0
    //   51: newarray byte
    //   53: astore 7
    //   55: new 6	com/tencent/mm/sdk/platformtools/ar$1
    //   58: dup
    //   59: aload_0
    //   60: aload_1
    //   61: aload_0
    //   62: getfield 46	com/tencent/mm/sdk/platformtools/ar:threadName	Ljava/lang/String;
    //   65: aload 7
    //   67: invokespecial 231	com/tencent/mm/sdk/platformtools/ar$1:<init>	(Lcom/tencent/mm/sdk/platformtools/ar;Lcom/tencent/mm/sdk/platformtools/ar$b;Ljava/lang/String;Ljava/lang/Object;)V
    //   70: astore_1
    //   71: aload 7
    //   73: monitorenter
    //   74: aload_0
    //   75: aload_1
    //   76: invokevirtual 233	com/tencent/mm/sdk/platformtools/ar:a	(Lcom/tencent/mm/sdk/platformtools/ar$a;)I
    //   79: istore_2
    //   80: aload_0
    //   81: getfield 42	com/tencent/mm/sdk/platformtools/ar:IxZ	Landroid/os/HandlerThread;
    //   84: invokevirtual 228	android/os/HandlerThread:getId	()J
    //   87: lstore 5
    //   89: ldc 84
    //   91: ldc 235
    //   93: iconst_3
    //   94: anewarray 4	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: iload_2
    //   100: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: lload_3
    //   107: invokestatic 213	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   110: aastore
    //   111: dup
    //   112: iconst_2
    //   113: lload 5
    //   115: invokestatic 213	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   118: aastore
    //   119: invokestatic 97	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: iload_2
    //   123: ifne +15 -> 138
    //   126: lload_3
    //   127: lload 5
    //   129: lcmp
    //   130: ifne +8 -> 138
    //   133: aload 7
    //   135: invokevirtual 238	java/lang/Object:wait	()V
    //   138: aload 7
    //   140: monitorexit
    //   141: ldc 206
    //   143: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iload_2
    //   147: ireturn
    //   148: astore_1
    //   149: ldc 84
    //   151: ldc 240
    //   153: iconst_1
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload_1
    //   160: invokevirtual 102	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   163: aastore
    //   164: invokestatic 243	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: goto -29 -> 138
    //   170: astore_1
    //   171: aload 7
    //   173: monitorexit
    //   174: ldc 206
    //   176: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload_1
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	ar
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
  
  public final int aw(Runnable paramRunnable)
  {
    AppMethodBeat.i(157688);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(157688);
      return -1;
    }
    cZF().post(paramRunnable);
    AppMethodBeat.o(157688);
    return 0;
  }
  
  public final int ax(Runnable paramRunnable)
  {
    AppMethodBeat.i(157689);
    cZF().postAtFrontOfQueue(paramRunnable);
    AppMethodBeat.o(157689);
    return 0;
  }
  
  public final aq cZF()
  {
    AppMethodBeat.i(157684);
    if (this.rxJ == null) {
      this.rxJ = new aq(this.IxZ.getLooper());
    }
    aq localaq = this.rxJ;
    AppMethodBeat.o(157684);
    return localaq;
  }
  
  public final void foM()
  {
    AppMethodBeat.i(157677);
    if ((this.IxZ == null) || (!this.IxZ.isAlive()))
    {
      ae.e("MicroMsg.MMHandlerThread", "setLowestPriority failed thread is dead");
      AppMethodBeat.o(157677);
      return;
    }
    int i = this.IxZ.getThreadId();
    try
    {
      if (19 == Process.getThreadPriority(i))
      {
        ae.w("MicroMsg.MMHandlerThread", "setLowestPriority No Need.");
        AppMethodBeat.o(157677);
        return;
      }
      Process.setThreadPriority(i, 19);
      ae.i("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      AppMethodBeat.o(157677);
      return;
    }
    catch (Exception localException)
    {
      ae.w("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority failed", new Object[] { Integer.valueOf(i) });
      ae.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      AppMethodBeat.o(157677);
    }
  }
  
  public final int foN()
  {
    AppMethodBeat.i(157678);
    if (this.IxZ == null)
    {
      AppMethodBeat.o(157678);
      return -1;
    }
    int i = this.IxZ.getThreadId();
    AppMethodBeat.o(157678);
    return i;
  }
  
  public final void foO()
  {
    AppMethodBeat.i(157680);
    if ((this.IxZ == null) || (!this.IxZ.isAlive()))
    {
      ae.e("MicroMsg.MMHandlerThread", "setLowPriority failed thread is dead");
      AppMethodBeat.o(157680);
      return;
    }
    int i = this.IxZ.getThreadId();
    try
    {
      if (Process.getThreadPriority(i) == 0)
      {
        ae.w("MicroMsg.MMHandlerThread", "setLowPriority No Need.");
        AppMethodBeat.o(157680);
        return;
      }
      Process.setThreadPriority(i, 0);
      ae.i("MicroMsg.MMHandlerThread", "thread:%d setLowPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      AppMethodBeat.o(157680);
      return;
    }
    catch (Exception localException)
    {
      ae.w("MicroMsg.MMHandlerThread", "thread:%d setLowPriority failed", new Object[] { Integer.valueOf(i) });
      ae.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      AppMethodBeat.o(157680);
    }
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(224551);
    Looper localLooper = this.IxZ.getLooper();
    AppMethodBeat.o(224551);
    return localLooper;
  }
  
  public final int n(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(157690);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(157690);
      return -1;
    }
    cZF().postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(157690);
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract boolean aEC();
    
    public abstract boolean aED();
  }
  
  public static abstract interface b
  {
    public abstract void BK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ar
 * JD-Core Version:    0.7.0.1
 */