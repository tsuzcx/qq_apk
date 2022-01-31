package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.sdk.f.e;

public class ai
{
  private static ah ufo = null;
  private ah jWn = null;
  public HandlerThread mnU = null;
  private String threadName = null;
  
  public ai()
  {
    y.i("MicroMsg.MMHandlerThread", "init stack:%s", new Object[] { bk.csb() });
    tA(null);
  }
  
  public ai(String paramString)
  {
    tA(paramString);
  }
  
  public static void Fd(int paramInt)
  {
    try
    {
      Process.setThreadPriority(paramInt);
      y.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d ok", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception localException)
    {
      y.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d fail, %s", new Object[] { Integer.valueOf(paramInt), localException.getMessage() });
      y.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
    }
  }
  
  public static void S(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    crh().removeCallbacks(paramRunnable);
  }
  
  private static ah crh()
  {
    if (ufo == null) {
      ufo = new ah(Looper.getMainLooper());
    }
    return ufo;
  }
  
  public static void d(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    crh().post(paramRunnable);
  }
  
  public static boolean isMainThread()
  {
    return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
  }
  
  public static void l(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {
      return;
    }
    crh().postDelayed(paramRunnable, paramLong);
  }
  
  private void tA(String paramString)
  {
    this.jWn = null;
    String str = paramString;
    if (bk.bl(paramString)) {
      str = "MMHandlerThread";
    }
    this.threadName = str;
    this.mnU = e.ds(this.threadName, 0);
    this.mnU.start();
  }
  
  public int O(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return -1;
    }
    crf().post(paramRunnable);
    return 0;
  }
  
  public final int R(Runnable paramRunnable)
  {
    crf().postAtFrontOfQueueV2(paramRunnable);
    return 0;
  }
  
  public final int a(final a parama)
  {
    if (new ah(this.mnU.getLooper()).postAtFrontOfQueueV2(new Runnable()
    {
      public final void run()
      {
        parama.JS();
        ai.T(new Runnable()
        {
          public final void run()
          {
            ai.2.this.ufs.JT();
          }
        });
      }
      
      public final String toString()
      {
        return super.toString() + "|" + parama.toString();
      }
    })) {
      return 0;
    }
    return -2;
  }
  
  /* Error */
  public final int a(final b paramb)
  {
    // Byte code:
    //   0: ldc 39
    //   2: ldc 171
    //   4: iconst_2
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: invokestatic 125	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   13: invokevirtual 129	java/lang/Thread:getId	()J
    //   16: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: invokestatic 47	com/tencent/mm/sdk/platformtools/bk:csb	()Lcom/tencent/mm/sdk/platformtools/ak;
    //   25: aastore
    //   26: invokestatic 53	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   29: ldc 178
    //   31: invokestatic 180	com/tencent/mm/sdk/platformtools/ai:isMainThread	()Z
    //   34: invokestatic 186	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   37: aload_0
    //   38: getfield 33	com/tencent/mm/sdk/platformtools/ai:mnU	Landroid/os/HandlerThread;
    //   41: invokevirtual 187	android/os/HandlerThread:getId	()J
    //   44: lstore_3
    //   45: iconst_0
    //   46: newarray byte
    //   48: astore 7
    //   50: new 6	com/tencent/mm/sdk/platformtools/ai$1
    //   53: dup
    //   54: aload_0
    //   55: aload_1
    //   56: aload_0
    //   57: getfield 37	com/tencent/mm/sdk/platformtools/ai:threadName	Ljava/lang/String;
    //   60: aload 7
    //   62: invokespecial 190	com/tencent/mm/sdk/platformtools/ai$1:<init>	(Lcom/tencent/mm/sdk/platformtools/ai;Lcom/tencent/mm/sdk/platformtools/ai$b;Ljava/lang/String;Ljava/lang/Object;)V
    //   65: astore_1
    //   66: aload 7
    //   68: monitorenter
    //   69: aload_0
    //   70: aload_1
    //   71: invokevirtual 192	com/tencent/mm/sdk/platformtools/ai:a	(Lcom/tencent/mm/sdk/platformtools/ai$a;)I
    //   74: istore_2
    //   75: aload_0
    //   76: getfield 33	com/tencent/mm/sdk/platformtools/ai:mnU	Landroid/os/HandlerThread;
    //   79: invokevirtual 187	android/os/HandlerThread:getId	()J
    //   82: lstore 5
    //   84: ldc 39
    //   86: ldc 194
    //   88: iconst_3
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: iload_2
    //   95: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: lload_3
    //   102: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   105: aastore
    //   106: dup
    //   107: iconst_2
    //   108: lload 5
    //   110: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   113: aastore
    //   114: invokestatic 53	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: iload_2
    //   118: ifne +15 -> 133
    //   121: lload_3
    //   122: lload 5
    //   124: lcmp
    //   125: ifne +8 -> 133
    //   128: aload 7
    //   130: invokevirtual 197	java/lang/Object:wait	()V
    //   133: aload 7
    //   135: monitorexit
    //   136: iload_2
    //   137: ireturn
    //   138: astore_1
    //   139: ldc 39
    //   141: ldc 199
    //   143: iconst_1
    //   144: anewarray 4	java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: aload_1
    //   150: invokevirtual 80	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   153: aastore
    //   154: invokestatic 201	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: goto -24 -> 133
    //   160: astore_1
    //   161: aload 7
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	ai
    //   0	166	1	paramb	b
    //   74	63	2	i	int
    //   44	78	3	l1	long
    //   82	41	5	l2	long
    //   48	114	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   128	133	138	java/lang/Exception
    //   69	117	160	finally
    //   128	133	160	finally
    //   133	136	160	finally
    //   139	157	160	finally
    //   161	164	160	finally
  }
  
  public final void crc()
  {
    if ((this.mnU == null) || (!this.mnU.isAlive()))
    {
      y.e("MicroMsg.MMHandlerThread", "setLowestPriority failed thread is dead");
      return;
    }
    int i = this.mnU.getThreadId();
    try
    {
      if (19 == Process.getThreadPriority(i))
      {
        y.w("MicroMsg.MMHandlerThread", "setLowestPriority No Need.");
        return;
      }
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority failed", new Object[] { Integer.valueOf(i) });
      y.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      return;
    }
    Process.setThreadPriority(i, 19);
    y.i("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
  }
  
  public final int crd()
  {
    if (this.mnU == null) {
      return -1;
    }
    return this.mnU.getThreadId();
  }
  
  public final void cre()
  {
    if ((this.mnU == null) || (!this.mnU.isAlive()))
    {
      y.e("MicroMsg.MMHandlerThread", "setLowPriority failed thread is dead");
      return;
    }
    int i = this.mnU.getThreadId();
    try
    {
      if (Process.getThreadPriority(i) == 0)
      {
        y.w("MicroMsg.MMHandlerThread", "setLowPriority No Need.");
        return;
      }
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.MMHandlerThread", "thread:%d setLowPriority failed", new Object[] { Integer.valueOf(i) });
      y.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      return;
    }
    Process.setThreadPriority(i, 0);
    y.i("MicroMsg.MMHandlerThread", "thread:%d setLowPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
  }
  
  public final ah crf()
  {
    if (this.jWn == null) {
      this.jWn = new ah(this.mnU.getLooper());
    }
    return this.jWn;
  }
  
  public final boolean crg()
  {
    return Thread.currentThread().getId() == this.mnU.getId();
  }
  
  public final Looper getLooper()
  {
    return this.mnU.getLooper();
  }
  
  public final int k(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {
      return -1;
    }
    crf().postDelayed(paramRunnable, paramLong);
    return 0;
  }
  
  public final boolean quit()
  {
    return this.mnU.quit();
  }
  
  public final void sQ()
  {
    if ((this.mnU == null) || (!this.mnU.isAlive()))
    {
      y.e("MicroMsg.MMHandlerThread", "setHighPriority failed thread is dead");
      return;
    }
    int i = this.mnU.getThreadId();
    try
    {
      if (-8 == Process.getThreadPriority(i))
      {
        y.w("MicroMsg.MMHandlerThread", "setHighPriority No Need.");
        return;
      }
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.MMHandlerThread", "thread:%d setHighPriority failed", new Object[] { Integer.valueOf(i) });
      y.printErrStackTrace("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
      return;
    }
    Process.setThreadPriority(i, -8);
    y.i("MicroMsg.MMHandlerThread", "thread:%d setHighPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
  }
  
  public static abstract interface a
  {
    public abstract boolean JS();
    
    public abstract boolean JT();
  }
  
  public static abstract interface b
  {
    public abstract void pQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ai
 * JD-Core Version:    0.7.0.1
 */