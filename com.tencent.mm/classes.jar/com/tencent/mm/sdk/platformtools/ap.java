package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class ap
{
  private static ao hBR = null;
  public HandlerThread GrZ;
  private ao qFN;
  private String threadName;
  
  @Deprecated
  public ap(HandlerThread paramHandlerThread)
  {
    AppMethodBeat.i(182963);
    this.GrZ = null;
    this.qFN = null;
    this.threadName = null;
    this.qFN = null;
    this.GrZ = paramHandlerThread;
    this.threadName = paramHandlerThread.getName();
    AppMethodBeat.o(182963);
  }
  
  public static void Yt(int paramInt)
  {
    AppMethodBeat.i(157676);
    try
    {
      Process.setThreadPriority(paramInt);
      ac.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d ok", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(157676);
      return;
    }
    catch (Exception localException)
    {
      ac.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d fail, %s", new Object[] { Integer.valueOf(paramInt), localException.getMessage() });
      ac.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      AppMethodBeat.o(157676);
    }
  }
  
  public static void aB(Runnable paramRunnable)
  {
    AppMethodBeat.i(157697);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(157697);
      return;
    }
    eVn().removeCallbacks(paramRunnable);
    AppMethodBeat.o(157697);
  }
  
  private static ao eVn()
  {
    AppMethodBeat.i(157694);
    if (hBR == null) {
      hBR = new ao(Looper.getMainLooper());
    }
    ao localao = hBR;
    AppMethodBeat.o(157694);
    return localao;
  }
  
  public static void f(Runnable paramRunnable)
  {
    AppMethodBeat.i(157695);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(157695);
      return;
    }
    eVn().post(paramRunnable);
    AppMethodBeat.o(157695);
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
  
  public static void n(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(157696);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(157696);
      return;
    }
    eVn().postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(157696);
  }
  
  public final void Kw()
  {
    AppMethodBeat.i(157679);
    if ((this.GrZ == null) || (!this.GrZ.isAlive()))
    {
      ac.e("MicroMsg.MMHandlerThread", "setHighPriority failed thread is dead");
      AppMethodBeat.o(157679);
      return;
    }
    int i = this.GrZ.getThreadId();
    try
    {
      if (-8 == Process.getThreadPriority(i))
      {
        ac.w("MicroMsg.MMHandlerThread", "setHighPriority No Need.");
        AppMethodBeat.o(157679);
        return;
      }
      Process.setThreadPriority(i, -8);
      ac.i("MicroMsg.MMHandlerThread", "thread:%d setHighPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      AppMethodBeat.o(157679);
      return;
    }
    catch (Exception localException)
    {
      ac.w("MicroMsg.MMHandlerThread", "thread:%d setHighPriority failed", new Object[] { Integer.valueOf(i) });
      ac.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      AppMethodBeat.o(157679);
    }
  }
  
  public final int a(final a parama)
  {
    AppMethodBeat.i(157691);
    if (new ao(this.GrZ.getLooper()).postAtFrontOfQueue(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(157673);
        parama.aBj();
        ap.af(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(157672);
            ap.2.this.Gsc.aBk();
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
    //   0: ldc 207
    //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 67
    //   7: ldc 209
    //   9: iconst_2
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: invokestatic 150	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   18: invokevirtual 154	java/lang/Thread:getId	()J
    //   21: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: invokestatic 218	com/tencent/mm/sdk/platformtools/bs:eWi	()Lcom/tencent/mm/sdk/platformtools/as;
    //   30: aastore
    //   31: invokestatic 80	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: ldc 220
    //   36: invokestatic 222	com/tencent/mm/sdk/platformtools/ap:isMainThread	()Z
    //   39: invokestatic 228	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   42: aload_0
    //   43: getfield 42	com/tencent/mm/sdk/platformtools/ap:GrZ	Landroid/os/HandlerThread;
    //   46: invokevirtual 229	android/os/HandlerThread:getId	()J
    //   49: lstore_3
    //   50: iconst_0
    //   51: newarray byte
    //   53: astore 7
    //   55: new 6	com/tencent/mm/sdk/platformtools/ap$1
    //   58: dup
    //   59: aload_0
    //   60: aload_1
    //   61: aload_0
    //   62: getfield 46	com/tencent/mm/sdk/platformtools/ap:threadName	Ljava/lang/String;
    //   65: aload 7
    //   67: invokespecial 232	com/tencent/mm/sdk/platformtools/ap$1:<init>	(Lcom/tencent/mm/sdk/platformtools/ap;Lcom/tencent/mm/sdk/platformtools/ap$b;Ljava/lang/String;Ljava/lang/Object;)V
    //   70: astore_1
    //   71: aload 7
    //   73: monitorenter
    //   74: aload_0
    //   75: aload_1
    //   76: invokevirtual 234	com/tencent/mm/sdk/platformtools/ap:a	(Lcom/tencent/mm/sdk/platformtools/ap$a;)I
    //   79: istore_2
    //   80: aload_0
    //   81: getfield 42	com/tencent/mm/sdk/platformtools/ap:GrZ	Landroid/os/HandlerThread;
    //   84: invokevirtual 229	android/os/HandlerThread:getId	()J
    //   87: lstore 5
    //   89: ldc 67
    //   91: ldc 236
    //   93: iconst_3
    //   94: anewarray 4	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: iload_2
    //   100: invokestatic 75	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: lload_3
    //   107: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   110: aastore
    //   111: dup
    //   112: iconst_2
    //   113: lload 5
    //   115: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   118: aastore
    //   119: invokestatic 80	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: iload_2
    //   123: ifne +15 -> 138
    //   126: lload_3
    //   127: lload 5
    //   129: lcmp
    //   130: ifne +8 -> 138
    //   133: aload 7
    //   135: invokevirtual 239	java/lang/Object:wait	()V
    //   138: aload 7
    //   140: monitorexit
    //   141: ldc 207
    //   143: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iload_2
    //   147: ireturn
    //   148: astore_1
    //   149: ldc 67
    //   151: ldc 241
    //   153: iconst_1
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload_1
    //   160: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   163: aastore
    //   164: invokestatic 244	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: goto -29 -> 138
    //   170: astore_1
    //   171: aload 7
    //   173: monitorexit
    //   174: ldc 207
    //   176: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload_1
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	ap
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
  
  public final int aA(Runnable paramRunnable)
  {
    AppMethodBeat.i(157689);
    cOC().postAtFrontOfQueue(paramRunnable);
    AppMethodBeat.o(157689);
    return 0;
  }
  
  public final int az(Runnable paramRunnable)
  {
    AppMethodBeat.i(157688);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(157688);
      return -1;
    }
    cOC().post(paramRunnable);
    AppMethodBeat.o(157688);
    return 0;
  }
  
  public final ao cOC()
  {
    AppMethodBeat.i(157684);
    if (this.qFN == null) {
      this.qFN = new ao(this.GrZ.getLooper());
    }
    ao localao = this.qFN;
    AppMethodBeat.o(157684);
    return localao;
  }
  
  public final void eVk()
  {
    AppMethodBeat.i(157677);
    if ((this.GrZ == null) || (!this.GrZ.isAlive()))
    {
      ac.e("MicroMsg.MMHandlerThread", "setLowestPriority failed thread is dead");
      AppMethodBeat.o(157677);
      return;
    }
    int i = this.GrZ.getThreadId();
    try
    {
      if (19 == Process.getThreadPriority(i))
      {
        ac.w("MicroMsg.MMHandlerThread", "setLowestPriority No Need.");
        AppMethodBeat.o(157677);
        return;
      }
      Process.setThreadPriority(i, 19);
      ac.i("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      AppMethodBeat.o(157677);
      return;
    }
    catch (Exception localException)
    {
      ac.w("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority failed", new Object[] { Integer.valueOf(i) });
      ac.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      AppMethodBeat.o(157677);
    }
  }
  
  public final int eVl()
  {
    AppMethodBeat.i(157678);
    if (this.GrZ == null)
    {
      AppMethodBeat.o(157678);
      return -1;
    }
    int i = this.GrZ.getThreadId();
    AppMethodBeat.o(157678);
    return i;
  }
  
  public final void eVm()
  {
    AppMethodBeat.i(157680);
    if ((this.GrZ == null) || (!this.GrZ.isAlive()))
    {
      ac.e("MicroMsg.MMHandlerThread", "setLowPriority failed thread is dead");
      AppMethodBeat.o(157680);
      return;
    }
    int i = this.GrZ.getThreadId();
    try
    {
      if (Process.getThreadPriority(i) == 0)
      {
        ac.w("MicroMsg.MMHandlerThread", "setLowPriority No Need.");
        AppMethodBeat.o(157680);
        return;
      }
      Process.setThreadPriority(i, 0);
      ac.i("MicroMsg.MMHandlerThread", "thread:%d setLowPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
      AppMethodBeat.o(157680);
      return;
    }
    catch (Exception localException)
    {
      ac.w("MicroMsg.MMHandlerThread", "thread:%d setLowPriority failed", new Object[] { Integer.valueOf(i) });
      ac.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      AppMethodBeat.o(157680);
    }
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(210341);
    Looper localLooper = this.GrZ.getLooper();
    AppMethodBeat.o(210341);
    return localLooper;
  }
  
  public final int m(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(157690);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(157690);
      return -1;
    }
    cOC().postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(157690);
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract boolean aBj();
    
    public abstract boolean aBk();
  }
  
  public static abstract interface b
  {
    public abstract void Am();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ap
 * JD-Core Version:    0.7.0.1
 */