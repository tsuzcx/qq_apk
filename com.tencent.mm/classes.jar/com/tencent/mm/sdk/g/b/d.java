package com.tencent.mm.sdk.g.b;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class d
  implements a
{
  private static final RuntimePermission ysU;
  private volatile int cgb;
  private final AtomicInteger ysK;
  private final BlockingQueue<Runnable> ysL;
  private final HashSet<c> ysM;
  private final HashSet<c> ysN;
  private final Condition ysO;
  private int ysP;
  private long ysQ;
  private volatile int ysS;
  volatile com.tencent.mm.sdk.g.c.e ysY;
  private volatile b ysZ;
  private final ReentrantLock yss;
  private volatile int yta;
  private volatile boolean ytb;
  private final BlockingQueue<Runnable> ytc;
  private a ytd;
  
  static
  {
    AppMethodBeat.i(52663);
    ysU = new RuntimePermission("modifyThread");
    AppMethodBeat.o(52663);
  }
  
  public d(int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue, com.tencent.mm.sdk.g.c.e parame, b paramb, a parama)
  {
    AppMethodBeat.i(52643);
    this.ysK = new AtomicInteger(-536870912);
    this.ytb = false;
    this.yss = new ReentrantLock();
    this.ysO = this.yss.newCondition();
    this.ysM = new HashSet();
    this.ysN = new HashSet();
    this.cgb = paramInt1;
    this.yta = paramInt2;
    this.ysS = paramInt1;
    this.ysL = paramBlockingQueue;
    this.ysY = parame;
    this.ysZ = paramb;
    this.ytc = new LinkedBlockingDeque();
    this.ytd = parama;
    AppMethodBeat.o(52643);
  }
  
  private void Nl(int paramInt)
  {
    AppMethodBeat.i(52641);
    int i;
    do
    {
      i = this.ysK.get();
    } while (((paramInt == -536870912) || (!hm(i, paramInt))) && (!this.ysK.compareAndSet(i, 0x1FFFFFFF & i | paramInt)));
    AppMethodBeat.o(52641);
  }
  
  private void a(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(52646);
    if ((this.ysK.get() & 0xE0000000) >= 0) {
      paramBoolean = true;
    }
    if (paramBoolean) {
      dux();
    }
    localReentrantLock = this.yss;
    localReentrantLock.lock();
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.ysQ += paramc.ysX;
        this.ysM.remove(paramc);
        paramc.oNc.quit();
        paramc.release(1);
        paramc.ysW = null;
        paramc.ytf = null;
        localReentrantLock.unlock();
        duy();
        AppMethodBeat.o(52646);
        return;
      }
      finally
      {
        localReentrantLock.unlock();
        AppMethodBeat.o(52646);
      }
      this.ysN.add(paramc);
    }
  }
  
  private static void a(BlockingQueue<Runnable> paramBlockingQueue)
  {
    int i = 0;
    AppMethodBeat.i(52639);
    ArrayList localArrayList = new ArrayList();
    paramBlockingQueue.drainTo(localArrayList);
    if (!paramBlockingQueue.isEmpty())
    {
      Runnable[] arrayOfRunnable = (Runnable[])paramBlockingQueue.toArray(new Runnable[0]);
      int j = arrayOfRunnable.length;
      while (i < j)
      {
        Runnable localRunnable = arrayOfRunnable[i];
        if (paramBlockingQueue.remove(localRunnable)) {
          localArrayList.add(localRunnable);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(52639);
  }
  
  private boolean a(Runnable paramRunnable, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(52658);
    int i;
    int k;
    do
    {
      i = this.ysK.get();
      k = i & 0xE0000000;
      if ((k < 0) || ((k == 0) && (paramRunnable == null) && (!duD()))) {
        break label387;
      }
      AppMethodBeat.o(52658);
      return false;
      if (this.ysK.compareAndSet(i, i + 1)) {
        break;
      }
      i = this.ysK.get();
    } while ((i & 0xE0000000) != k);
    label387:
    for (;;)
    {
      int m = i & 0x1FFFFFFF;
      if (m < 536870911) {
        if (!paramBoolean) {
          break label118;
        }
      }
      label118:
      for (int j = this.cgb; m >= j; j = this.ysS)
      {
        AppMethodBeat.o(52658);
        return false;
      }
      break;
      for (;;)
      {
        try
        {
          localc = new c(paramRunnable);
        }
        finally
        {
          HandlerThread localHandlerThread;
          ReentrantLock localReentrantLock;
          c localc = null;
          continue;
          i = 0;
          continue;
        }
        try
        {
          localHandlerThread = localc.oNc;
          paramBoolean = bool;
          if (localHandlerThread == null) {
            continue;
          }
          localReentrantLock = this.yss;
          localReentrantLock.lock();
          try
          {
            i = this.ysK.get() & 0xE0000000;
            if ((i >= 0) && ((i != 0) || (paramRunnable != null))) {
              continue;
            }
            if (localHandlerThread.isAlive())
            {
              paramRunnable = new IllegalThreadStateException();
              AppMethodBeat.o(52658);
              throw paramRunnable;
            }
          }
          finally
          {
            localReentrantLock.unlock();
            AppMethodBeat.o(52658);
          }
          paramBoolean = ez(aq(paramRunnable), this.yta);
        }
        finally
        {
          b(localc);
          AppMethodBeat.o(52658);
        }
      }
      if (paramBoolean)
      {
        localReentrantLock.unlock();
        b(localc);
        AppMethodBeat.o(52658);
        return false;
      }
      this.ysM.add(localc);
      i = this.ysM.size();
      if (i > this.ysP) {
        this.ysP = i;
      }
      i = 1;
      localReentrantLock.unlock();
      paramBoolean = bool;
      if (i != 0)
      {
        localc.oNc.start();
        localc.handler = new Handler(localc.oNc.getLooper());
        localc.handler.post(localc);
        paramBoolean = true;
      }
      if (!paramBoolean) {
        b(localc);
      }
      AppMethodBeat.o(52658);
      return paramBoolean;
    }
  }
  
  private void ap(Runnable paramRunnable)
  {
    AppMethodBeat.i(52655);
    this.ysZ.as(paramRunnable);
    AppMethodBeat.o(52655);
  }
  
  private static String aq(Runnable paramRunnable)
  {
    AppMethodBeat.i(52649);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(52649);
      return "";
    }
    if ((paramRunnable instanceof b)) {}
    for (paramRunnable = ((b)paramRunnable).getKey();; paramRunnable = paramRunnable.getClass().getName())
    {
      AppMethodBeat.o(52649);
      return paramRunnable;
    }
  }
  
  private void b(c paramc)
  {
    AppMethodBeat.i(52659);
    ReentrantLock localReentrantLock = this.yss;
    localReentrantLock.lock();
    if (paramc != null) {}
    try
    {
      paramc.oNc.quit();
      this.ysM.remove(paramc);
      dux();
      duy();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(52659);
    }
  }
  
  private boolean duA()
  {
    AppMethodBeat.i(52645);
    if ((this.ysK.get() & 0xE0000000) >= 0)
    {
      AppMethodBeat.o(52645);
      return false;
    }
    ReentrantLock localReentrantLock = this.yss;
    localReentrantLock.lock();
    try
    {
      Iterator localIterator = this.ysN.iterator();
      c localc;
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        if ((!localc.ytg) && (localc.oNc.isAlive()))
        {
          localc.ysW = null;
          localc.ytf = aq(null);
          localc.handler.post(localc);
          localIterator.remove();
          return true;
        }
      }
      if (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        localc.ysW = null;
        localc.ytf = aq(null);
        localc.handler.post(localc);
        localIterator.remove();
        ab.w("HandlerThreadPool", "[notifyWorker] fallback! thread id:%s %s", new Object[] { Integer.valueOf(localc.oNc.getThreadId()), localc.ytf });
        return true;
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(52645);
    }
  }
  
  private void duC()
  {
    AppMethodBeat.i(52640);
    SecurityManager localSecurityManager = System.getSecurityManager();
    if (localSecurityManager != null)
    {
      localSecurityManager.checkPermission(ysU);
      ReentrantLock localReentrantLock = this.yss;
      localReentrantLock.lock();
      try
      {
        Iterator localIterator = this.ysM.iterator();
        while (localIterator.hasNext()) {
          localSecurityManager.checkAccess(((c)localIterator.next()).oNc);
        }
        localReentrantLock.unlock();
      }
      finally
      {
        localReentrantLock.unlock();
        AppMethodBeat.o(52640);
      }
      AppMethodBeat.o(52640);
      return;
    }
    AppMethodBeat.o(52640);
  }
  
  private boolean duD()
  {
    AppMethodBeat.i(52648);
    if ((this.ysL.isEmpty()) && (this.ytc.isEmpty()))
    {
      AppMethodBeat.o(52648);
      return true;
    }
    AppMethodBeat.o(52648);
    return false;
  }
  
  private String duF()
  {
    AppMethodBeat.i(52661);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("print:\n-------------------------------------------------------------------------\n");
    Object localObject1 = this.yss;
    try
    {
      ((ReentrantLock)localObject1).lock();
      Iterator localIterator = this.ysM.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        localStringBuilder.append(String.format("worker[%s]:", new Object[] { localc.oNc.getName() }));
        int i = 0;
        while (i < localc.ysX)
        {
          localStringBuilder.append("*");
          i += 1;
        }
        localStringBuilder.append("\n");
      }
      ((ReentrantLock)localObject1).unlock();
    }
    finally
    {
      ((ReentrantLock)localObject1).unlock();
      AppMethodBeat.o(52661);
    }
    localObject1 = localObject2.toString();
    AppMethodBeat.o(52661);
    return localObject1;
  }
  
  private void dux()
  {
    AppMethodBeat.i(52642);
    int i;
    do
    {
      i = this.ysK.get();
    } while (!this.ysK.compareAndSet(i, i - 1));
    AppMethodBeat.o(52642);
  }
  
  private void duy()
  {
    AppMethodBeat.i(52651);
    for (;;)
    {
      int j = this.ysK.get();
      if (j < 0) {}
      for (int i = 1; (i != 0) || (hm(j, 1073741824)) || (((0xE0000000 & j) == 0) && (!duD())); i = 0)
      {
        AppMethodBeat.o(52651);
        return;
      }
      if ((0x1FFFFFFF & j) != 0)
      {
        pQ(true);
        AppMethodBeat.o(52651);
        return;
      }
      ReentrantLock localReentrantLock = this.yss;
      localReentrantLock.lock();
      try
      {
        if (this.ysK.compareAndSet(j, 1073741824))
        {
          this.ysK.set(1610612736);
          this.ysO.signalAll();
          return;
        }
        localReentrantLock.unlock();
      }
      finally
      {
        localReentrantLock.unlock();
        AppMethodBeat.o(52651);
      }
    }
  }
  
  private Runnable duz()
  {
    AppMethodBeat.i(52647);
    int i = this.ysK.get() & 0xE0000000;
    if ((i >= 0) && ((i >= 536870912) || (duD())))
    {
      AppMethodBeat.o(52647);
      return null;
    }
    Object localObject2 = (Runnable)this.ysL.poll();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (getActiveCount() < this.yta)
      {
        localObject1 = localObject2;
        if (!this.ytc.isEmpty())
        {
          this.ytc.size();
          localObject1 = (Runnable)this.ytc.poll();
          localObject2 = this.ytd;
          aq((Runnable)localObject1);
          ((a)localObject2).dus();
        }
      }
    }
    AppMethodBeat.o(52647);
    return localObject1;
  }
  
  private boolean ez(String paramString, int paramInt)
  {
    AppMethodBeat.i(52656);
    ReentrantLock localReentrantLock = this.yss;
    localReentrantLock.lock();
    try
    {
      Iterator localIterator = this.ysM.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.isLocked())
        {
          boolean bool = paramString.equals(localc.ytf);
          if (bool)
          {
            int j = i + 1;
            i = j;
            if (j >= paramInt) {
              return true;
            }
          }
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(52656);
    }
  }
  
  private int getActiveCount()
  {
    AppMethodBeat.i(52652);
    ReentrantLock localReentrantLock = this.yss;
    localReentrantLock.lock();
    int i = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.ysM.iterator();
        if (localIterator.hasNext())
        {
          boolean bool = ((c)localIterator.next()).isLocked();
          if (bool) {
            i += 1;
          }
        }
        else
        {
          return i;
        }
      }
      finally
      {
        localReentrantLock.unlock();
        AppMethodBeat.o(52652);
      }
    }
  }
  
  private static boolean hm(int paramInt1, int paramInt2)
  {
    return paramInt1 >= paramInt2;
  }
  
  /* Error */
  private void pQ(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 419
    //   3: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 89	com/tencent/mm/sdk/g/b/d:yss	Ljava/util/concurrent/locks/ReentrantLock;
    //   10: astore_3
    //   11: aload_3
    //   12: invokevirtual 148	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   15: aload_0
    //   16: getfield 100	com/tencent/mm/sdk/g/b/d:ysM	Ljava/util/HashSet;
    //   19: invokevirtual 298	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   22: astore 5
    //   24: aload 5
    //   26: invokeinterface 303 1 0
    //   31: ifeq +62 -> 93
    //   34: aload 5
    //   36: invokeinterface 307 1 0
    //   41: checkcast 16	com/tencent/mm/sdk/g/b/d$c
    //   44: astore 4
    //   46: aload 4
    //   48: getfield 161	com/tencent/mm/sdk/g/b/d$c:oNc	Landroid/os/HandlerThread;
    //   51: astore 6
    //   53: aload 6
    //   55: invokevirtual 422	android/os/HandlerThread:isInterrupted	()Z
    //   58: ifne +31 -> 89
    //   61: aload 4
    //   63: invokevirtual 425	com/tencent/mm/sdk/g/b/d$c:tryLock	()Z
    //   66: istore_2
    //   67: iload_2
    //   68: ifeq +21 -> 89
    //   71: aload 6
    //   73: invokevirtual 167	android/os/HandlerThread:quit	()Z
    //   76: pop
    //   77: aload 6
    //   79: invokevirtual 428	android/os/HandlerThread:interrupt	()V
    //   82: aload 4
    //   84: iconst_1
    //   85: invokevirtual 171	com/tencent/mm/sdk/g/b/d$c:release	(I)Z
    //   88: pop
    //   89: iload_1
    //   90: ifeq -66 -> 24
    //   93: aload_3
    //   94: invokevirtual 182	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   97: ldc_w 419
    //   100: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: return
    //   104: astore 6
    //   106: ldc_w 315
    //   109: aload 6
    //   111: invokevirtual 429	java/lang/SecurityException:toString	()Ljava/lang/String;
    //   114: invokestatic 433	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload 4
    //   119: iconst_1
    //   120: invokevirtual 171	com/tencent/mm/sdk/g/b/d$c:release	(I)Z
    //   123: pop
    //   124: goto -35 -> 89
    //   127: astore 4
    //   129: aload_3
    //   130: invokevirtual 182	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   133: ldc_w 419
    //   136: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload 4
    //   141: athrow
    //   142: astore 5
    //   144: aload 4
    //   146: iconst_1
    //   147: invokevirtual 171	com/tencent/mm/sdk/g/b/d$c:release	(I)Z
    //   150: pop
    //   151: ldc_w 419
    //   154: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aload 5
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	d
    //   0	160	1	paramBoolean	boolean
    //   66	2	2	bool	boolean
    //   10	120	3	localReentrantLock	ReentrantLock
    //   44	74	4	localc	c
    //   127	18	4	localObject1	Object
    //   22	13	5	localIterator	Iterator
    //   142	16	5	localObject2	Object
    //   51	27	6	localHandlerThread	HandlerThread
    //   104	6	6	localSecurityException	SecurityException
    // Exception table:
    //   from	to	target	type
    //   71	82	104	java/lang/SecurityException
    //   15	24	127	finally
    //   24	67	127	finally
    //   82	89	127	finally
    //   117	124	127	finally
    //   144	160	127	finally
    //   71	82	142	finally
    //   106	117	142	finally
  }
  
  private List<Runnable> shutdownNow()
  {
    AppMethodBeat.i(52638);
    ReentrantLock localReentrantLock1 = this.yss;
    localReentrantLock1.lock();
    try
    {
      duC();
      Nl(536870912);
      ReentrantLock localReentrantLock2 = this.yss;
      localReentrantLock2.lock();
      try
      {
        Iterator localIterator = this.ysM.iterator();
        while (localIterator.hasNext())
        {
          ((c)localIterator.next()).duG();
          continue;
          localObject1 = finally;
        }
      }
      finally {}
      localObject1.unlock();
    }
    finally
    {
      localReentrantLock1.unlock();
      AppMethodBeat.o(52638);
    }
    ArrayList localArrayList = new ArrayList();
    a(this.ysL);
    a(this.ytc);
    localReentrantLock1.unlock();
    duy();
    AppMethodBeat.o(52638);
    return localArrayList;
  }
  
  /* Error */
  final void a(c paramc)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: ldc_w 453
    //   6: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: getfield 161	com/tencent/mm/sdk/g/b/d$c:oNc	Landroid/os/HandlerThread;
    //   13: astore 9
    //   15: aload_1
    //   16: getfield 175	com/tencent/mm/sdk/g/b/d$c:ysW	Ljava/lang/Runnable;
    //   19: ifnonnull +162 -> 181
    //   22: aload_0
    //   23: invokespecial 455	com/tencent/mm/sdk/g/b/d:duz	()Ljava/lang/Runnable;
    //   26: astore 6
    //   28: aload_1
    //   29: aload 6
    //   31: invokestatic 236	com/tencent/mm/sdk/g/b/d:aq	(Ljava/lang/Runnable;)Ljava/lang/String;
    //   34: putfield 179	com/tencent/mm/sdk/g/b/d$c:ytf	Ljava/lang/String;
    //   37: aload_1
    //   38: aconst_null
    //   39: putfield 175	com/tencent/mm/sdk/g/b/d$c:ysW	Ljava/lang/Runnable;
    //   42: aload_1
    //   43: iconst_1
    //   44: invokevirtual 171	com/tencent/mm/sdk/g/b/d$c:release	(I)Z
    //   47: pop
    //   48: iconst_1
    //   49: istore_2
    //   50: iconst_0
    //   51: istore 5
    //   53: aload 6
    //   55: astore 7
    //   57: aload 6
    //   59: ifnonnull +22 -> 81
    //   62: iload 5
    //   64: ifeq +100 -> 164
    //   67: iload_2
    //   68: istore 4
    //   70: aload_0
    //   71: invokespecial 455	com/tencent/mm/sdk/g/b/d:duz	()Ljava/lang/Runnable;
    //   74: astore 7
    //   76: aload 7
    //   78: ifnull +86 -> 164
    //   81: iload_2
    //   82: istore 4
    //   84: aload_1
    //   85: iconst_1
    //   86: invokevirtual 458	com/tencent/mm/sdk/g/b/d$c:acquire	(I)V
    //   89: iload_2
    //   90: istore 4
    //   92: aload_0
    //   93: getfield 82	com/tencent/mm/sdk/g/b/d:ysK	Ljava/util/concurrent/atomic/AtomicInteger;
    //   96: invokevirtual 129	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   99: ldc_w 398
    //   102: invokestatic 133	com/tencent/mm/sdk/g/b/d:hm	(II)Z
    //   105: ifne +31 -> 136
    //   108: iload_2
    //   109: istore 4
    //   111: invokestatic 461	java/lang/Thread:interrupted	()Z
    //   114: ifeq +76 -> 190
    //   117: iload_2
    //   118: istore 4
    //   120: aload_0
    //   121: getfield 82	com/tencent/mm/sdk/g/b/d:ysK	Ljava/util/concurrent/atomic/AtomicInteger;
    //   124: invokevirtual 129	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   127: ldc_w 398
    //   130: invokestatic 133	com/tencent/mm/sdk/g/b/d:hm	(II)Z
    //   133: ifeq +57 -> 190
    //   136: iload_2
    //   137: istore 4
    //   139: aload 9
    //   141: invokevirtual 422	android/os/HandlerThread:isInterrupted	()Z
    //   144: ifne +46 -> 190
    //   147: iload_2
    //   148: istore 4
    //   150: aload 9
    //   152: invokevirtual 167	android/os/HandlerThread:quit	()Z
    //   155: pop
    //   156: iload_2
    //   157: istore 4
    //   159: aload 9
    //   161: invokevirtual 428	android/os/HandlerThread:interrupt	()V
    //   164: iload_2
    //   165: ifeq +322 -> 487
    //   168: aload_0
    //   169: aload_1
    //   170: iconst_0
    //   171: invokespecial 463	com/tencent/mm/sdk/g/b/d:a	(Lcom/tencent/mm/sdk/g/b/d$c;Z)V
    //   174: ldc_w 453
    //   177: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: return
    //   181: aload_1
    //   182: getfield 175	com/tencent/mm/sdk/g/b/d$c:ysW	Ljava/lang/Runnable;
    //   185: astore 6
    //   187: goto -159 -> 28
    //   190: aload_1
    //   191: aload 7
    //   193: invokestatic 236	com/tencent/mm/sdk/g/b/d:aq	(Ljava/lang/Runnable;)Ljava/lang/String;
    //   196: putfield 179	com/tencent/mm/sdk/g/b/d$c:ytf	Ljava/lang/String;
    //   199: aload_0
    //   200: aload 9
    //   202: aload 7
    //   204: invokevirtual 467	com/tencent/mm/sdk/g/b/d:beforeExecute	(Ljava/lang/Thread;Ljava/lang/Runnable;)V
    //   207: aload 8
    //   209: astore 6
    //   211: aload 7
    //   213: invokeinterface 470 1 0
    //   218: aload_0
    //   219: aload 7
    //   221: aconst_null
    //   222: invokevirtual 474	com/tencent/mm/sdk/g/b/d:afterExecute	(Ljava/lang/Runnable;Ljava/lang/Throwable;)V
    //   225: aload_1
    //   226: invokevirtual 477	com/tencent/mm/sdk/g/b/d$c:duB	()Z
    //   229: istore 5
    //   231: iload_2
    //   232: istore_3
    //   233: iload 5
    //   235: ifne +14 -> 249
    //   238: aload_1
    //   239: getfield 261	com/tencent/mm/sdk/g/b/d$c:handler	Landroid/os/Handler;
    //   242: aload_1
    //   243: invokevirtual 265	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   246: pop
    //   247: iconst_0
    //   248: istore_3
    //   249: iload_3
    //   250: istore 4
    //   252: aload_1
    //   253: aload_1
    //   254: getfield 153	com/tencent/mm/sdk/g/b/d$c:ysX	J
    //   257: lconst_1
    //   258: ladd
    //   259: putfield 153	com/tencent/mm/sdk/g/b/d$c:ysX	J
    //   262: iload_3
    //   263: istore 4
    //   265: aload_1
    //   266: iconst_1
    //   267: invokevirtual 171	com/tencent/mm/sdk/g/b/d$c:release	(I)Z
    //   270: pop
    //   271: iload_3
    //   272: istore 4
    //   274: getstatic 482	com/tencent/mm/sdk/g/d:ysh	Z
    //   277: ifeq +202 -> 479
    //   280: iload_3
    //   281: istore 4
    //   283: ldc_w 315
    //   286: aload_0
    //   287: invokespecial 484	com/tencent/mm/sdk/g/b/d:duF	()Ljava/lang/String;
    //   290: invokestatic 486	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aconst_null
    //   294: astore 6
    //   296: iload_3
    //   297: istore_2
    //   298: goto -245 -> 53
    //   301: astore 8
    //   303: aload 8
    //   305: astore 6
    //   307: ldc_w 453
    //   310: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   313: aload 8
    //   315: astore 6
    //   317: aload 8
    //   319: athrow
    //   320: astore 8
    //   322: aload_0
    //   323: aload 7
    //   325: aload 6
    //   327: invokevirtual 474	com/tencent/mm/sdk/g/b/d:afterExecute	(Ljava/lang/Runnable;Ljava/lang/Throwable;)V
    //   330: aload 6
    //   332: ifnonnull +175 -> 507
    //   335: aload_1
    //   336: invokevirtual 477	com/tencent/mm/sdk/g/b/d$c:duB	()Z
    //   339: ifne +168 -> 507
    //   342: aload_1
    //   343: getfield 261	com/tencent/mm/sdk/g/b/d$c:handler	Landroid/os/Handler;
    //   346: aload_1
    //   347: invokevirtual 265	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   350: pop
    //   351: iconst_0
    //   352: istore_2
    //   353: ldc_w 453
    //   356: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   359: aload 8
    //   361: athrow
    //   362: astore 6
    //   364: aload_1
    //   365: aload_1
    //   366: getfield 153	com/tencent/mm/sdk/g/b/d$c:ysX	J
    //   369: lconst_1
    //   370: ladd
    //   371: putfield 153	com/tencent/mm/sdk/g/b/d$c:ysX	J
    //   374: aload_1
    //   375: iconst_1
    //   376: invokevirtual 171	com/tencent/mm/sdk/g/b/d$c:release	(I)Z
    //   379: pop
    //   380: getstatic 482	com/tencent/mm/sdk/g/d:ysh	Z
    //   383: ifeq +13 -> 396
    //   386: ldc_w 315
    //   389: aload_0
    //   390: invokespecial 484	com/tencent/mm/sdk/g/b/d:duF	()Ljava/lang/String;
    //   393: invokestatic 486	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: ldc_w 453
    //   399: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   402: aload 6
    //   404: athrow
    //   405: astore 6
    //   407: iload_2
    //   408: ifeq +9 -> 417
    //   411: aload_0
    //   412: aload_1
    //   413: iconst_1
    //   414: invokespecial 463	com/tencent/mm/sdk/g/b/d:a	(Lcom/tencent/mm/sdk/g/b/d$c;Z)V
    //   417: ldc_w 453
    //   420: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   423: aload 6
    //   425: athrow
    //   426: astore 8
    //   428: aload 8
    //   430: astore 6
    //   432: ldc_w 453
    //   435: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   438: aload 8
    //   440: astore 6
    //   442: aload 8
    //   444: athrow
    //   445: astore 8
    //   447: aload 8
    //   449: astore 6
    //   451: new 450	java/lang/Error
    //   454: dup
    //   455: aload 8
    //   457: invokespecial 489	java/lang/Error:<init>	(Ljava/lang/Throwable;)V
    //   460: astore 9
    //   462: aload 8
    //   464: astore 6
    //   466: ldc_w 453
    //   469: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   472: aload 8
    //   474: astore 6
    //   476: aload 9
    //   478: athrow
    //   479: aconst_null
    //   480: astore 6
    //   482: iload_3
    //   483: istore_2
    //   484: goto -431 -> 53
    //   487: ldc_w 453
    //   490: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   493: return
    //   494: astore 6
    //   496: iload 4
    //   498: istore_2
    //   499: goto -92 -> 407
    //   502: astore 6
    //   504: goto -140 -> 364
    //   507: goto -154 -> 353
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	510	0	this	d
    //   0	510	1	paramc	c
    //   49	450	2	i	int
    //   232	251	3	j	int
    //   68	429	4	k	int
    //   51	183	5	bool	boolean
    //   26	305	6	localObject1	Object
    //   362	41	6	localObject2	Object
    //   405	19	6	localObject3	Object
    //   430	51	6	localObject4	Object
    //   494	1	6	localObject5	Object
    //   502	1	6	localObject6	Object
    //   55	269	7	localObject7	Object
    //   1	207	8	localObject8	Object
    //   301	17	8	localRuntimeException	java.lang.RuntimeException
    //   320	40	8	localObject9	Object
    //   426	17	8	localError	java.lang.Error
    //   445	28	8	localThrowable	Throwable
    //   13	464	9	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   211	218	301	java/lang/RuntimeException
    //   211	218	320	finally
    //   307	313	320	finally
    //   317	320	320	finally
    //   432	438	320	finally
    //   442	445	320	finally
    //   451	462	320	finally
    //   466	472	320	finally
    //   476	479	320	finally
    //   353	362	362	finally
    //   364	396	405	finally
    //   396	405	405	finally
    //   211	218	426	java/lang/Error
    //   211	218	445	java/lang/Throwable
    //   70	76	494	finally
    //   84	89	494	finally
    //   92	108	494	finally
    //   111	117	494	finally
    //   120	136	494	finally
    //   139	147	494	finally
    //   150	156	494	finally
    //   159	164	494	finally
    //   252	262	494	finally
    //   265	271	494	finally
    //   274	280	494	finally
    //   283	293	494	finally
    //   190	207	502	finally
    //   218	231	502	finally
    //   238	247	502	finally
    //   322	330	502	finally
    //   335	351	502	finally
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable) {}
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable) {}
  
  public final String duE()
  {
    AppMethodBeat.i(52660);
    Object localObject1 = this.yss;
    StringBuilder localStringBuilder = new StringBuilder();
    c localc;
    try
    {
      ((ReentrantLock)localObject1).lock();
      localIterator = this.ysN.iterator();
      localStringBuilder.append("recycleWorker:\n");
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        localStringBuilder.append(localc.oNc.getThreadId()).append(" ").append(localc.ytg).append(" ").append(localc.isLocked()).append(", ");
      }
      localObject2.append("\nworker:\n");
    }
    finally
    {
      ((ReentrantLock)localObject1).unlock();
      AppMethodBeat.o(52660);
    }
    Iterator localIterator = this.ysM.iterator();
    while (localIterator.hasNext())
    {
      localc = (c)localIterator.next();
      localObject2.append(localc.oNc.getThreadId()).append(" ").append(localc.ytg).append(" ").append(localc.isLocked()).append(", ");
    }
    ((ReentrantLock)localObject1).unlock();
    localObject1 = localObject2.toString();
    AppMethodBeat.o(52660);
    return localObject1;
  }
  
  public void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(52653);
    if (paramRunnable == null)
    {
      paramRunnable = new NullPointerException();
      AppMethodBeat.o(52653);
      throw paramRunnable;
    }
    int i = this.ysK.get();
    int k = i & 0x1FFFFFFF;
    if (k < this.cgb)
    {
      if (a(paramRunnable, true))
      {
        AppMethodBeat.o(52653);
        return;
      }
      i = this.ysK.get();
    }
    String str = aq(paramRunnable);
    if (i < 0) {}
    for (int j = 1; (j != 0) && (ez(str, this.yta)); j = 0)
    {
      this.ytc.offer(paramRunnable);
      this.ytd.Nj(k);
      AppMethodBeat.o(52653);
      return;
    }
    if (i < 0) {
      i = 1;
    }
    while ((i != 0) && (this.ysL.offer(paramRunnable))) {
      if (duA())
      {
        AppMethodBeat.o(52653);
        return;
        i = 0;
      }
      else
      {
        j = this.ysK.get();
        if (j < 0) {}
        for (i = 1; (i == 0) && (remove(paramRunnable)); i = 0)
        {
          ap(paramRunnable);
          AppMethodBeat.o(52653);
          return;
        }
        if ((j & 0x1FFFFFFF) == 0) {
          a(null, false);
        }
        AppMethodBeat.o(52653);
        return;
      }
    }
    if (!a(paramRunnable, false)) {
      ap(paramRunnable);
    }
    AppMethodBeat.o(52653);
  }
  
  public final int getCorePoolSize()
  {
    return this.cgb;
  }
  
  public final void r(final Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(52654);
    com.tencent.mm.sdk.g.d.ysm.r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(52626);
        d.this.execute(paramRunnable);
        AppMethodBeat.o(52626);
      }
    }, paramLong);
    AppMethodBeat.o(52654);
  }
  
  public final boolean remove(Runnable paramRunnable)
  {
    AppMethodBeat.i(52657);
    boolean bool1 = this.ysL.remove(paramRunnable);
    boolean bool2 = this.ytc.remove(paramRunnable);
    duy();
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(52657);
      return true;
    }
    AppMethodBeat.o(52657);
    return false;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(52636);
    shutdownNow();
    Nl(-536870912);
    AppMethodBeat.o(52636);
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(52637);
    ReentrantLock localReentrantLock = this.yss;
    localReentrantLock.lock();
    try
    {
      duC();
      Nl(0);
      pQ(false);
      localReentrantLock.unlock();
      duy();
      AppMethodBeat.o(52637);
      return;
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(52637);
    }
  }
  
  public static abstract interface a
  {
    public abstract void Nj(int paramInt);
    
    public abstract void dus();
  }
  
  public static abstract interface b
  {
    public abstract void as(Runnable paramRunnable);
  }
  
  final class c
    extends AbstractQueuedSynchronizer
    implements Printer, Runnable
  {
    Handler handler;
    final HandlerThread oNc;
    volatile Runnable ysW;
    volatile long ysX;
    volatile String ytf;
    volatile boolean ytg;
    
    c(Runnable paramRunnable)
    {
      AppMethodBeat.i(52627);
      this.ytg = false;
      setState(-1);
      this.ysW = paramRunnable;
      this.ytf = d.ar(paramRunnable);
      int i = d.Nm(d.a(d.this).get());
      this.oNc = d.this.ysY.a(this, "HandlerThreadPool#".concat(String.valueOf(i + 1)), this);
      AppMethodBeat.o(52627);
    }
    
    public final boolean duB()
    {
      AppMethodBeat.i(52628);
      if (Build.VERSION.SDK_INT >= 23)
      {
        boolean bool = this.handler.getLooper().getQueue().isIdle();
        AppMethodBeat.o(52628);
        return bool;
      }
      AppMethodBeat.o(52628);
      return false;
    }
    
    final void duG()
    {
      AppMethodBeat.i(52635);
      if (getState() >= 0)
      {
        HandlerThread localHandlerThread = this.oNc;
        if ((localHandlerThread != null) && (!localHandlerThread.isInterrupted())) {
          try
          {
            localHandlerThread.quit();
            localHandlerThread.interrupt();
            AppMethodBeat.o(52635);
            return;
          }
          catch (SecurityException localSecurityException) {}
        }
      }
      AppMethodBeat.o(52635);
    }
    
    protected final boolean isHeldExclusively()
    {
      AppMethodBeat.i(52630);
      if (getState() != 0)
      {
        AppMethodBeat.o(52630);
        return true;
      }
      AppMethodBeat.o(52630);
      return false;
    }
    
    public final boolean isLocked()
    {
      AppMethodBeat.i(52634);
      boolean bool = isHeldExclusively();
      AppMethodBeat.o(52634);
      return bool;
    }
    
    public final void println(String paramString)
    {
      if (!this.ytg) {}
      for (boolean bool = true;; bool = false)
      {
        this.ytg = bool;
        return;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(52629);
      d.this.a(this);
      AppMethodBeat.o(52629);
    }
    
    protected final boolean tryAcquire(int paramInt)
    {
      AppMethodBeat.i(52631);
      if (compareAndSetState(0, 1))
      {
        setExclusiveOwnerThread(Thread.currentThread());
        AppMethodBeat.o(52631);
        return true;
      }
      AppMethodBeat.o(52631);
      return false;
    }
    
    public final boolean tryLock()
    {
      AppMethodBeat.i(52633);
      boolean bool = tryAcquire(1);
      AppMethodBeat.o(52633);
      return bool;
    }
    
    protected final boolean tryRelease(int paramInt)
    {
      AppMethodBeat.i(52632);
      setExclusiveOwnerThread(null);
      setState(0);
      AppMethodBeat.o(52632);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.g.b.d
 * JD-Core Version:    0.7.0.1
 */