package com.tencent.mm.sdk.b.b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mm.sdk.b.d.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class c
  implements a
{
  private static final RuntimePermission aaU = new RuntimePermission("modifyThread");
  private final ReentrantLock aaA = new ReentrantLock();
  private final AtomicInteger aaT = new AtomicInteger(-536870912);
  private volatile com.tencent.mm.sdk.b.c.d aaV;
  private volatile e aaW;
  private volatile int aaX;
  private volatile int aaY;
  private volatile int aaZ;
  private volatile boolean aba = false;
  private final BlockingQueue<Runnable> abb;
  private final BlockingQueue<Runnable> abc;
  private int abd;
  private long abe;
  private d abf;
  private final Condition abg = this.aaA.newCondition();
  private final HashSet<f> abh = new HashSet();
  private final HashSet<f> abi = new HashSet();
  
  public c(int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue, com.tencent.mm.sdk.b.c.d paramd, e parame, d paramd1)
  {
    this.aaY = paramInt1;
    this.aaX = paramInt2;
    this.aaZ = paramInt1;
    this.abb = paramBlockingQueue;
    this.aaV = paramd;
    this.aaW = parame;
    this.abc = new LinkedBlockingDeque();
    this.abf = paramd1;
  }
  
  private void a(f paramf, boolean paramBoolean)
  {
    if ((this.aaT.get() & 0xE0000000) >= 0) {
      paramBoolean = true;
    }
    if (paramBoolean) {
      lM();
    }
    localReentrantLock = this.aaA;
    localReentrantLock.lock();
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.abe += paramf.abm;
        this.abh.remove(paramf);
        paramf.abj.quit();
        paramf.release(1);
        paramf.abk = null;
        paramf.abl = null;
        localReentrantLock.unlock();
        lR();
        return;
      }
      finally
      {
        localReentrantLock.unlock();
      }
      this.abi.add(paramf);
    }
  }
  
  private boolean a(Runnable paramRunnable, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    int i;
    int k;
    boolean bool1;
    label56:
    do
    {
      i = this.aaT.get();
      k = i & 0xE0000000;
      if (k < 0) {
        break label368;
      }
      bool1 = bool3;
      if (k == 0)
      {
        bool1 = bool3;
        if (paramRunnable == null)
        {
          if (!lP()) {
            break label368;
          }
          bool1 = bool3;
        }
      }
      return bool1;
      if (this.aaT.compareAndSet(i, i + 1)) {
        break;
      }
      i = this.aaT.get();
    } while ((i & 0xE0000000) != k);
    label368:
    for (;;)
    {
      int m = i & 0x1FFFFFFF;
      bool1 = bool3;
      if (m >= 536870911) {
        break;
      }
      if (paramBoolean) {}
      for (int j = this.aaY; m >= j; j = this.aaZ) {
        return false;
      }
      break label56;
      for (;;)
      {
        try
        {
          localf = new f(this, paramRunnable);
        }
        finally
        {
          HandlerThread localHandlerThread;
          ReentrantLock localReentrantLock;
          f localf = null;
          continue;
          i = 0;
          continue;
        }
        try
        {
          localHandlerThread = localf.abj;
          paramBoolean = bool2;
          if (localHandlerThread == null) {
            continue;
          }
          localReentrantLock = this.aaA;
          localReentrantLock.lock();
          try
          {
            i = this.aaT.get() & 0xE0000000;
            if ((i >= 0) && ((i != 0) || (paramRunnable != null))) {
              continue;
            }
            if (localHandlerThread.isAlive()) {
              throw new IllegalThreadStateException();
            }
          }
          finally
          {
            localReentrantLock.unlock();
          }
          paramBoolean = b(i(paramRunnable), this.aaX);
        }
        finally
        {
          b(localf);
        }
      }
      if (paramBoolean)
      {
        localReentrantLock.unlock();
        b(localf);
        return false;
      }
      this.abh.add(localf);
      i = this.abh.size();
      if (i > this.abd) {
        this.abd = i;
      }
      i = 1;
      localReentrantLock.unlock();
      paramBoolean = bool2;
      if (i != 0)
      {
        localf.abj.start();
        localf.handler = new Handler(localf.abj.getLooper());
        localf.handler.post(localf);
        paramBoolean = true;
      }
      bool1 = paramBoolean;
      if (paramBoolean) {
        break;
      }
      b(localf);
      return paramBoolean;
    }
  }
  
  private static boolean ah(int paramInt1, int paramInt2)
  {
    return paramInt1 >= paramInt2;
  }
  
  private void b(f paramf)
  {
    ReentrantLock localReentrantLock = this.aaA;
    localReentrantLock.lock();
    if (paramf != null) {}
    try
    {
      paramf.abj.quit();
      this.abh.remove(paramf);
      lM();
      lR();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  private boolean b(String paramString, int paramInt)
  {
    ReentrantLock localReentrantLock = this.aaA;
    localReentrantLock.lock();
    try
    {
      Iterator localIterator = this.abh.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (localf.isLocked())
        {
          boolean bool = paramString.equals(localf.abl);
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
    }
  }
  
  private int getActiveCount()
  {
    ReentrantLock localReentrantLock = this.aaA;
    localReentrantLock.lock();
    int i = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.abh.iterator();
        if (localIterator.hasNext())
        {
          boolean bool = ((f)localIterator.next()).isLocked();
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
      }
    }
  }
  
  private static String i(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return "";
    }
    if ((paramRunnable instanceof b)) {
      return ((b)paramRunnable).getKey();
    }
    return paramRunnable.getClass().getName();
  }
  
  private void j(Runnable paramRunnable)
  {
    this.aaW.l(paramRunnable);
  }
  
  private void lM()
  {
    int i;
    do
    {
      i = this.aaT.get();
    } while (!this.aaT.compareAndSet(i, i - 1));
  }
  
  private boolean lN()
  {
    if ((this.aaT.get() & 0xE0000000) >= 0) {
      return false;
    }
    ReentrantLock localReentrantLock = this.aaA;
    localReentrantLock.lock();
    try
    {
      Iterator localIterator = this.abi.iterator();
      f localf;
      while (localIterator.hasNext())
      {
        localf = (f)localIterator.next();
        if ((!localf.abn) && (localf.abj.isAlive()))
        {
          localf.abk = null;
          localf.abl = i(null);
          localf.handler.post(localf);
          localIterator.remove();
          return true;
        }
      }
      if (localIterator.hasNext())
      {
        localf = (f)localIterator.next();
        localf.abk = null;
        localf.abl = i(null);
        localf.handler.post(localf);
        localIterator.remove();
        com.tencent.mm.sdk.platformtools.f.b("HandlerThreadPool", "[notifyWorker] fallback! thread id:%s %s", new Object[] { Integer.valueOf(localf.abj.getThreadId()), localf.abl });
        return true;
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  private Runnable lO()
  {
    int i = this.aaT.get() & 0xE0000000;
    if ((i >= 0) && ((i >= 536870912) || (lP()))) {
      localObject1 = null;
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject2 = (Runnable)this.abb.poll();
          localObject1 = localObject2;
        } while (localObject2 != null);
        localObject1 = localObject2;
      } while (getActiveCount() >= this.aaX);
      localObject1 = localObject2;
    } while (this.abc.isEmpty());
    this.abc.size();
    Object localObject1 = (Runnable)this.abc.poll();
    Object localObject2 = this.abf;
    i((Runnable)localObject1);
    ((d)localObject2).lG();
    return localObject1;
  }
  
  private boolean lP()
  {
    return (this.abb.isEmpty()) && (this.abc.isEmpty());
  }
  
  /* Error */
  private void lQ()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/tencent/mm/sdk/b/b/c:aaA	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 115	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 79	com/tencent/mm/sdk/b/b/c:abh	Ljava/util/HashSet;
    //   13: invokevirtual 218	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   16: astore_3
    //   17: aload_3
    //   18: invokeinterface 223 1 0
    //   23: ifeq +53 -> 76
    //   26: aload_3
    //   27: invokeinterface 227 1 0
    //   32: checkcast 119	com/tencent/mm/sdk/b/b/f
    //   35: astore_3
    //   36: aload_3
    //   37: getfield 130	com/tencent/mm/sdk/b/b/f:abj	Landroid/os/HandlerThread;
    //   40: astore 4
    //   42: aload 4
    //   44: invokevirtual 315	android/os/HandlerThread:isInterrupted	()Z
    //   47: ifne +29 -> 76
    //   50: aload_3
    //   51: invokevirtual 318	com/tencent/mm/sdk/b/b/f:tryLock	()Z
    //   54: istore_1
    //   55: iload_1
    //   56: ifeq +20 -> 76
    //   59: aload 4
    //   61: invokevirtual 136	android/os/HandlerThread:quit	()Z
    //   64: pop
    //   65: aload 4
    //   67: invokevirtual 321	android/os/HandlerThread:interrupt	()V
    //   70: aload_3
    //   71: iconst_1
    //   72: invokevirtual 140	com/tencent/mm/sdk/b/b/f:release	(I)Z
    //   75: pop
    //   76: aload_2
    //   77: invokevirtual 151	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   80: return
    //   81: astore 4
    //   83: ldc_w 272
    //   86: aload 4
    //   88: invokevirtual 324	java/lang/SecurityException:toString	()Ljava/lang/String;
    //   91: invokestatic 328	com/tencent/mm/sdk/platformtools/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_3
    //   95: iconst_1
    //   96: invokevirtual 140	com/tencent/mm/sdk/b/b/f:release	(I)Z
    //   99: pop
    //   100: goto -24 -> 76
    //   103: astore_3
    //   104: aload_2
    //   105: invokevirtual 151	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   108: aload_3
    //   109: athrow
    //   110: astore 4
    //   112: aload_3
    //   113: iconst_1
    //   114: invokevirtual 140	com/tencent/mm/sdk/b/b/f:release	(I)Z
    //   117: pop
    //   118: aload 4
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	c
    //   54	2	1	bool	boolean
    //   4	101	2	localReentrantLock	ReentrantLock
    //   16	79	3	localObject1	Object
    //   103	10	3	localObject2	Object
    //   40	26	4	localHandlerThread	HandlerThread
    //   81	6	4	localSecurityException	java.lang.SecurityException
    //   110	9	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   59	70	81	java/lang/SecurityException
    //   9	55	103	finally
    //   70	76	103	finally
    //   94	100	103	finally
    //   112	121	103	finally
    //   59	70	110	finally
    //   83	94	110	finally
  }
  
  private void lR()
  {
    for (;;)
    {
      int j = this.aaT.get();
      if (j < 0) {}
      for (int i = 1; (i != 0) || (ah(j, 1073741824)) || (((0xE0000000 & j) == 0) && (!lP())); i = 0) {
        return;
      }
      if ((0x1FFFFFFF & j) != 0)
      {
        lQ();
        return;
      }
      ReentrantLock localReentrantLock = this.aaA;
      localReentrantLock.lock();
      try
      {
        if (this.aaT.compareAndSet(j, 1073741824))
        {
          this.aaT.set(1610612736);
          this.abg.signalAll();
          return;
        }
        localReentrantLock.unlock();
      }
      finally
      {
        localReentrantLock.unlock();
      }
    }
  }
  
  private String lT()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("print:\n-------------------------------------------------------------------------\n");
    ReentrantLock localReentrantLock = this.aaA;
    try
    {
      localReentrantLock.lock();
      Iterator localIterator = this.abh.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        localStringBuilder.append(String.format("worker[%s]:", new Object[] { localf.abj.getName() }));
        int i = 0;
        while (i < localf.abm)
        {
          localStringBuilder.append("*");
          i += 1;
        }
        localStringBuilder.append("\n");
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    return localObject.toString();
  }
  
  /* Error */
  final void a(f paramf)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_1
    //   4: getfield 130	com/tencent/mm/sdk/b/b/f:abj	Landroid/os/HandlerThread;
    //   7: astore 9
    //   9: aload_1
    //   10: getfield 144	com/tencent/mm/sdk/b/b/f:abk	Ljava/lang/Runnable;
    //   13: ifnonnull +148 -> 161
    //   16: aload_0
    //   17: invokespecial 372	com/tencent/mm/sdk/b/b/c:lO	()Ljava/lang/Runnable;
    //   20: astore 6
    //   22: aload_1
    //   23: aload 6
    //   25: invokestatic 185	com/tencent/mm/sdk/b/b/c:i	(Ljava/lang/Runnable;)Ljava/lang/String;
    //   28: putfield 148	com/tencent/mm/sdk/b/b/f:abl	Ljava/lang/String;
    //   31: aload_1
    //   32: aconst_null
    //   33: putfield 144	com/tencent/mm/sdk/b/b/f:abk	Ljava/lang/Runnable;
    //   36: aload_1
    //   37: iconst_1
    //   38: invokevirtual 140	com/tencent/mm/sdk/b/b/f:release	(I)Z
    //   41: pop
    //   42: iconst_1
    //   43: istore_2
    //   44: iconst_0
    //   45: istore 5
    //   47: aload 6
    //   49: astore 7
    //   51: aload 6
    //   53: ifnonnull +21 -> 74
    //   56: iload 5
    //   58: ifeq +92 -> 150
    //   61: iload_2
    //   62: istore_3
    //   63: aload_0
    //   64: invokespecial 372	com/tencent/mm/sdk/b/b/c:lO	()Ljava/lang/Runnable;
    //   67: astore 7
    //   69: aload 7
    //   71: ifnull +79 -> 150
    //   74: iload_2
    //   75: istore_3
    //   76: aload_1
    //   77: iconst_1
    //   78: invokevirtual 375	com/tencent/mm/sdk/b/b/f:acquire	(I)V
    //   81: iload_2
    //   82: istore_3
    //   83: aload_0
    //   84: getfield 61	com/tencent/mm/sdk/b/b/c:aaT	Ljava/util/concurrent/atomic/AtomicInteger;
    //   87: invokevirtual 109	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   90: ldc_w 291
    //   93: invokestatic 331	com/tencent/mm/sdk/b/b/c:ah	(II)Z
    //   96: ifne +29 -> 125
    //   99: iload_2
    //   100: istore_3
    //   101: invokestatic 378	java/lang/Thread:interrupted	()Z
    //   104: ifeq +66 -> 170
    //   107: iload_2
    //   108: istore_3
    //   109: aload_0
    //   110: getfield 61	com/tencent/mm/sdk/b/b/c:aaT	Ljava/util/concurrent/atomic/AtomicInteger;
    //   113: invokevirtual 109	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   116: ldc_w 291
    //   119: invokestatic 331	com/tencent/mm/sdk/b/b/c:ah	(II)Z
    //   122: ifeq +48 -> 170
    //   125: iload_2
    //   126: istore_3
    //   127: aload 9
    //   129: invokevirtual 315	android/os/HandlerThread:isInterrupted	()Z
    //   132: ifne +38 -> 170
    //   135: iload_2
    //   136: istore_3
    //   137: aload 9
    //   139: invokevirtual 136	android/os/HandlerThread:quit	()Z
    //   142: pop
    //   143: iload_2
    //   144: istore_3
    //   145: aload 9
    //   147: invokevirtual 321	android/os/HandlerThread:interrupt	()V
    //   150: iload_2
    //   151: ifeq +9 -> 160
    //   154: aload_0
    //   155: aload_1
    //   156: iconst_0
    //   157: invokespecial 380	com/tencent/mm/sdk/b/b/c:a	(Lcom/tencent/mm/sdk/b/b/f;Z)V
    //   160: return
    //   161: aload_1
    //   162: getfield 144	com/tencent/mm/sdk/b/b/f:abk	Ljava/lang/Runnable;
    //   165: astore 6
    //   167: goto -145 -> 22
    //   170: aload_1
    //   171: aload 7
    //   173: invokestatic 185	com/tencent/mm/sdk/b/b/c:i	(Ljava/lang/Runnable;)Ljava/lang/String;
    //   176: putfield 148	com/tencent/mm/sdk/b/b/f:abl	Ljava/lang/String;
    //   179: aload_0
    //   180: aload 9
    //   182: aload 7
    //   184: invokevirtual 384	com/tencent/mm/sdk/b/b/c:beforeExecute	(Ljava/lang/Thread;Ljava/lang/Runnable;)V
    //   187: aload 8
    //   189: astore 6
    //   191: aload 7
    //   193: invokeinterface 387 1 0
    //   198: aload_0
    //   199: aload 7
    //   201: aconst_null
    //   202: invokevirtual 391	com/tencent/mm/sdk/b/b/c:afterExecute	(Ljava/lang/Runnable;Ljava/lang/Throwable;)V
    //   205: aload_1
    //   206: invokevirtual 394	com/tencent/mm/sdk/b/b/f:lU	()Z
    //   209: istore 5
    //   211: iload_2
    //   212: istore 4
    //   214: iload 5
    //   216: ifne +15 -> 231
    //   219: aload_1
    //   220: getfield 209	com/tencent/mm/sdk/b/b/f:handler	Landroid/os/Handler;
    //   223: aload_1
    //   224: invokevirtual 213	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   227: pop
    //   228: iconst_0
    //   229: istore 4
    //   231: iload 4
    //   233: istore_3
    //   234: aload_1
    //   235: aload_1
    //   236: getfield 122	com/tencent/mm/sdk/b/b/f:abm	J
    //   239: lconst_1
    //   240: ladd
    //   241: putfield 122	com/tencent/mm/sdk/b/b/f:abm	J
    //   244: iload 4
    //   246: istore_3
    //   247: aload_1
    //   248: iconst_1
    //   249: invokevirtual 140	com/tencent/mm/sdk/b/b/f:release	(I)Z
    //   252: pop
    //   253: iload 4
    //   255: istore_3
    //   256: getstatic 399	com/tencent/mm/sdk/b/d:aap	Z
    //   259: ifeq +157 -> 416
    //   262: iload 4
    //   264: istore_3
    //   265: ldc_w 272
    //   268: aload_0
    //   269: invokespecial 401	com/tencent/mm/sdk/b/b/c:lT	()Ljava/lang/String;
    //   272: invokestatic 404	com/tencent/mm/sdk/platformtools/f:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: aconst_null
    //   276: astore 6
    //   278: iload 4
    //   280: istore_2
    //   281: goto -234 -> 47
    //   284: astore 8
    //   286: aload 8
    //   288: astore 6
    //   290: aload 8
    //   292: athrow
    //   293: astore 8
    //   295: aload_0
    //   296: aload 7
    //   298: aload 6
    //   300: invokevirtual 391	com/tencent/mm/sdk/b/b/c:afterExecute	(Ljava/lang/Runnable;Ljava/lang/Throwable;)V
    //   303: aload 6
    //   305: ifnonnull +125 -> 430
    //   308: aload_1
    //   309: invokevirtual 394	com/tencent/mm/sdk/b/b/f:lU	()Z
    //   312: ifne +118 -> 430
    //   315: aload_1
    //   316: getfield 209	com/tencent/mm/sdk/b/b/f:handler	Landroid/os/Handler;
    //   319: aload_1
    //   320: invokevirtual 213	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   323: pop
    //   324: iconst_0
    //   325: istore_2
    //   326: aload 8
    //   328: athrow
    //   329: astore 6
    //   331: iload_2
    //   332: istore_3
    //   333: aload_1
    //   334: aload_1
    //   335: getfield 122	com/tencent/mm/sdk/b/b/f:abm	J
    //   338: lconst_1
    //   339: ladd
    //   340: putfield 122	com/tencent/mm/sdk/b/b/f:abm	J
    //   343: iload_2
    //   344: istore_3
    //   345: aload_1
    //   346: iconst_1
    //   347: invokevirtual 140	com/tencent/mm/sdk/b/b/f:release	(I)Z
    //   350: pop
    //   351: iload_2
    //   352: istore_3
    //   353: getstatic 399	com/tencent/mm/sdk/b/d:aap	Z
    //   356: ifeq +15 -> 371
    //   359: iload_2
    //   360: istore_3
    //   361: ldc_w 272
    //   364: aload_0
    //   365: invokespecial 401	com/tencent/mm/sdk/b/b/c:lT	()Ljava/lang/String;
    //   368: invokestatic 404	com/tencent/mm/sdk/platformtools/f:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: iload_2
    //   372: istore_3
    //   373: aload 6
    //   375: athrow
    //   376: astore 6
    //   378: iload_3
    //   379: ifeq +9 -> 388
    //   382: aload_0
    //   383: aload_1
    //   384: iconst_1
    //   385: invokespecial 380	com/tencent/mm/sdk/b/b/c:a	(Lcom/tencent/mm/sdk/b/b/f;Z)V
    //   388: aload 6
    //   390: athrow
    //   391: astore 8
    //   393: aload 8
    //   395: astore 6
    //   397: aload 8
    //   399: athrow
    //   400: astore 8
    //   402: aload 8
    //   404: astore 6
    //   406: new 368	java/lang/Error
    //   409: dup
    //   410: aload 8
    //   412: invokespecial 407	java/lang/Error:<init>	(Ljava/lang/Throwable;)V
    //   415: athrow
    //   416: aconst_null
    //   417: astore 6
    //   419: iload 4
    //   421: istore_2
    //   422: goto -375 -> 47
    //   425: astore 6
    //   427: goto -96 -> 331
    //   430: goto -104 -> 326
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	this	c
    //   0	433	1	paramf	f
    //   43	379	2	i	int
    //   62	317	3	j	int
    //   212	208	4	k	int
    //   45	170	5	bool	boolean
    //   20	284	6	localObject1	Object
    //   329	45	6	localObject2	Object
    //   376	13	6	localObject3	Object
    //   395	23	6	localObject4	Object
    //   425	1	6	localObject5	Object
    //   49	248	7	localObject6	Object
    //   1	187	8	localObject7	Object
    //   284	7	8	localRuntimeException	java.lang.RuntimeException
    //   293	34	8	localObject8	Object
    //   391	7	8	localError	java.lang.Error
    //   400	11	8	localThrowable	Throwable
    //   7	174	9	localHandlerThread	HandlerThread
    // Exception table:
    //   from	to	target	type
    //   191	198	284	java/lang/RuntimeException
    //   191	198	293	finally
    //   290	293	293	finally
    //   397	400	293	finally
    //   406	416	293	finally
    //   326	329	329	finally
    //   63	69	376	finally
    //   76	81	376	finally
    //   83	99	376	finally
    //   101	107	376	finally
    //   109	125	376	finally
    //   127	135	376	finally
    //   137	143	376	finally
    //   145	150	376	finally
    //   234	244	376	finally
    //   247	253	376	finally
    //   256	262	376	finally
    //   265	275	376	finally
    //   333	343	376	finally
    //   345	351	376	finally
    //   353	359	376	finally
    //   361	371	376	finally
    //   373	376	376	finally
    //   191	198	391	java/lang/Error
    //   191	198	400	java/lang/Throwable
    //   170	187	425	finally
    //   198	211	425	finally
    //   219	228	425	finally
    //   295	303	425	finally
    //   308	324	425	finally
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable) {}
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable) {}
  
  public void execute(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      throw new NullPointerException();
    }
    int j = this.aaT.get();
    int i = j;
    if ((j & 0x1FFFFFFF) < this.aaY) {
      if (!a(paramRunnable, true)) {}
    }
    label150:
    label214:
    label219:
    label234:
    do
    {
      do
      {
        do
        {
          return;
          i = this.aaT.get();
          String str = i(paramRunnable);
          if (i < 0) {}
          for (j = 1; (j != 0) && (b(str, this.aaX)); j = 0)
          {
            this.abc.offer(paramRunnable);
            this.abf.lF();
            return;
          }
          if (i >= 0) {
            break;
          }
          i = 1;
          if ((i == 0) || (!this.abb.offer(paramRunnable))) {
            break label234;
          }
        } while (lN());
        j = this.aaT.get();
        if (j < 0)
        {
          i = 1;
          if (i != 0) {
            continue;
          }
          boolean bool1 = this.abb.remove(paramRunnable);
          boolean bool2 = this.abc.remove(paramRunnable);
          lR();
          if ((!bool1) && (!bool2)) {
            break label214;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label219;
          }
          j(paramRunnable);
          return;
          i = 0;
          break;
          i = 0;
          break label150;
        }
      } while ((j & 0x1FFFFFFF) != 0);
      a(null, false);
      return;
    } while (a(paramRunnable, false));
    j(paramRunnable);
  }
  
  public final com.tencent.mm.sdk.b.c.d lS()
  {
    return this.aaV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.b.c
 * JD-Core Version:    0.7.0.1
 */