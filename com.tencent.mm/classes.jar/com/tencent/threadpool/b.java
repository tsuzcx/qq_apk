package com.tencent.threadpool;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class b
  extends AbstractExecutorService
{
  private static final e ahAj;
  public static ConcurrentLinkedQueue<WeakReference<b>> ahzY;
  private final ReentrantLock EWY;
  private final HashSet<b> ahAa;
  private final LinkedList<b> ahAb;
  private final Condition ahAc;
  private int ahAd;
  private long ahAe;
  private volatile ThreadFactory ahAf;
  private volatile e ahAg;
  private volatile long ahAh;
  private volatile int ahAi;
  public final AtomicInteger ahzX;
  public final BlockingQueue<Runnable> ahzZ;
  private volatile int hsI;
  public volatile String name;
  
  static
  {
    AppMethodBeat.i(183133);
    ahzY = new ConcurrentLinkedQueue();
    ahAj = new a();
    AppMethodBeat.o(183133);
  }
  
  public b(String paramString, int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue)
  {
    this(paramString, paramInt1, paramInt2, paramBlockingQueue, null);
  }
  
  public b(String paramString, int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue, e parame) {}
  
  @Deprecated
  private b(String paramString, int paramInt1, int paramInt2, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, e parame)
  {
    this(paramString, paramInt1, paramInt2, paramTimeUnit, paramBlockingQueue, Executors.defaultThreadFactory(), parame);
    AppMethodBeat.i(183120);
    AppMethodBeat.o(183120);
  }
  
  private b(String paramString, int paramInt1, int paramInt2, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory, e parame)
  {
    AppMethodBeat.i(183121);
    this.ahzX = new AtomicInteger(-536870912);
    this.EWY = new ReentrantLock();
    this.ahAa = new HashSet();
    this.ahAb = new LinkedList();
    this.ahAc = this.EWY.newCondition();
    if ((paramInt1 < 0) || (paramInt2 <= 0) || (paramInt2 < paramInt1) || (9223372036854775807L < 0L))
    {
      paramString = new IllegalArgumentException();
      AppMethodBeat.o(183121);
      throw paramString;
    }
    if ((paramBlockingQueue == null) || (paramThreadFactory == null) || (parame == null))
    {
      paramString = new NullPointerException();
      AppMethodBeat.o(183121);
      throw paramString;
    }
    this.hsI = paramInt1;
    this.ahAi = paramInt2;
    this.ahzZ = paramBlockingQueue;
    this.ahAh = paramTimeUnit.toNanos(9223372036854775807L);
    this.ahAf = paramThreadFactory;
    this.ahAg = parame;
    this.name = paramString;
    AppMethodBeat.o(183121);
  }
  
  private void Ov(boolean paramBoolean)
  {
    AppMethodBeat.i(183112);
    ReentrantLock localReentrantLock = this.EWY;
    localReentrantLock.lock();
    try
    {
      Iterator localIterator = this.ahAa.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        ((b)localIterator.next()).jYR();
      } while (!paramBoolean);
      return;
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(183112);
    }
  }
  
  private void a(b paramb)
  {
    AppMethodBeat.i(183115);
    ReentrantLock localReentrantLock = this.EWY;
    localReentrantLock.lock();
    if (paramb != null) {}
    try
    {
      this.ahAa.remove(paramb);
      jYN();
      jYO();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(183115);
    }
  }
  
  private void a(b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(183116);
    paramb.release(1);
    if (paramBoolean) {
      jYN();
    }
    localReentrantLock = this.EWY;
    localReentrantLock.lock();
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.ahAe += paramb.ahAl.get();
        this.ahAa.remove(paramb);
        paramb.ahAk = null;
        paramb.dBj = null;
        return;
      }
      finally
      {
        localReentrantLock.unlock();
        jYO();
        AppMethodBeat.o(183116);
      }
      if (paramb.ahAm.compareAndSet(false, true))
      {
        this.ahAb.add(paramb);
        paramb = jYP();
        if (paramb != null) {
          bi(paramb);
        }
      }
    }
  }
  
  public static boolean aHo(int paramInt)
  {
    return paramInt < 0;
  }
  
  private void aHp(int paramInt)
  {
    AppMethodBeat.i(183110);
    int i;
    do
    {
      i = this.ahzX.get();
    } while ((!pL(i, paramInt)) && (!this.ahzX.compareAndSet(i, 0x1FFFFFFF & i | paramInt)));
    AppMethodBeat.o(183110);
  }
  
  private boolean b(Runnable paramRunnable, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(183114);
    int i;
    int k;
    do
    {
      i = this.ahzX.get();
      k = i & 0xE0000000;
      if (h.ahAA.isShutdown())
      {
        AppMethodBeat.o(183114);
        return false;
      }
      if ((k < 0) || ((k == 0) && (paramRunnable == null) && (!this.ahzZ.isEmpty()))) {
        break label303;
      }
      AppMethodBeat.o(183114);
      return false;
      if (this.ahzX.compareAndSet(i, i + 1)) {
        break;
      }
      i = this.ahzX.get();
    } while ((i & 0xE0000000) != k);
    label141:
    label303:
    for (;;)
    {
      int m = i & 0x1FFFFFFF;
      if (m < 536870911) {
        if (!paramBoolean) {
          break label141;
        }
      }
      for (int j = this.hsI; m >= j; j = this.ahAi)
      {
        AppMethodBeat.o(183114);
        return false;
      }
      break;
      for (;;)
      {
        try
        {
          localb = new b(paramRunnable);
        }
        finally
        {
          b localb;
          ReentrantLock localReentrantLock;
          continue;
          i = 0;
        }
        try
        {
          localReentrantLock = this.EWY;
          localReentrantLock.lock();
          try
          {
            i = this.ahzX.get() & 0xE0000000;
            if ((i >= 0) && ((i != 0) || (paramRunnable != null))) {
              continue;
            }
            this.ahAa.add(localb);
            i = this.ahAa.size();
            if (i > this.ahAd) {
              this.ahAd = i;
            }
            i = 1;
            localReentrantLock.unlock();
            paramBoolean = bool;
            if (i != 0)
            {
              localb.start();
              paramBoolean = true;
            }
            if (!paramBoolean) {}
            return paramBoolean;
          }
          finally
          {
            localReentrantLock.unlock();
            AppMethodBeat.o(183114);
          }
          paramRunnable = finally;
        }
        finally
        {
          a(localb);
          AppMethodBeat.o(183114);
        }
      }
    }
  }
  
  private void bh(Runnable paramRunnable)
  {
    AppMethodBeat.i(183113);
    this.ahAg.rejectedExecution(paramRunnable, this);
    AppMethodBeat.o(183113);
  }
  
  private boolean bi(Runnable paramRunnable)
  {
    AppMethodBeat.i(183123);
    if ((this.ahzX.get() & 0xE0000000) >= 0)
    {
      AppMethodBeat.o(183123);
      return false;
    }
    ReentrantLock localReentrantLock = this.EWY;
    localReentrantLock.lock();
    try
    {
      if (this.ahAb.isEmpty()) {}
      for (b localb = null; localb != null; localb = (b)this.ahAb.remove())
      {
        localb.ahAm.compareAndSet(true, false);
        localb.bj(paramRunnable);
        localb.start();
        return true;
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(183123);
    }
  }
  
  private void jYN()
  {
    AppMethodBeat.i(183109);
    int i;
    do
    {
      i = this.ahzX.get();
    } while (!this.ahzX.compareAndSet(i, i - 1));
    AppMethodBeat.o(183109);
  }
  
  private void jYO()
  {
    AppMethodBeat.i(183111);
    ReentrantLock localReentrantLock;
    for (;;)
    {
      int j = this.ahzX.get();
      if (j < 0) {}
      for (int i = 1; (i != 0) || (pL(j, 1073741824)) || (((0xE0000000 & j) == 0) && (!this.ahzZ.isEmpty())); i = 0)
      {
        AppMethodBeat.o(183111);
        return;
      }
      if ((0x1FFFFFFF & j) != 0)
      {
        Ov(true);
        AppMethodBeat.o(183111);
        return;
      }
      localReentrantLock = this.EWY;
      localReentrantLock.lock();
      try
      {
        boolean bool = this.ahzX.compareAndSet(j, 1073741824);
        if (bool) {
          try
          {
            iFm();
            this.ahzX.set(1610612736);
            this.ahAc.signalAll();
            return;
          }
          finally
          {
            this.ahzX.set(1610612736);
            this.ahAc.signalAll();
            AppMethodBeat.o(183111);
          }
        }
        localReentrantLock.unlock();
      }
      finally
      {
        localReentrantLock.unlock();
        AppMethodBeat.o(183111);
      }
    }
  }
  
  private Runnable jYP()
  {
    AppMethodBeat.i(183117);
    int i = this.ahzX.get() & 0xE0000000;
    if ((i >= 0) && ((i >= 536870912) || (this.ahzZ.isEmpty())))
    {
      jYN();
      AppMethodBeat.o(183117);
      return null;
    }
    Runnable localRunnable = (Runnable)this.ahzZ.poll();
    AppMethodBeat.o(183117);
    return localRunnable;
  }
  
  public static boolean pK(int paramInt1, int paramInt2)
  {
    return paramInt1 < paramInt2;
  }
  
  private static boolean pL(int paramInt1, int paramInt2)
  {
    return paramInt1 >= paramInt2;
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable) {}
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(183128);
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.EWY;
    paramTimeUnit.lock();
    try
    {
      for (;;)
      {
        boolean bool = pL(this.ahzX.get(), 1610612736);
        if (bool) {
          break;
        }
        if (paramLong <= 0L) {
          return false;
        }
        paramLong = this.ahAc.awaitNanos(paramLong);
      }
      return true;
    }
    finally
    {
      paramTimeUnit.unlock();
      AppMethodBeat.o(183128);
    }
  }
  
  /* Error */
  final void b(b paramb)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc_w 337
    //   5: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 343	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   11: astore 6
    //   13: aload_1
    //   14: getfield 213	com/tencent/threadpool/b$b:ahAk	Ljava/lang/Runnable;
    //   17: astore 4
    //   19: aload_1
    //   20: aconst_null
    //   21: putfield 213	com/tencent/threadpool/b$b:ahAk	Ljava/lang/Runnable;
    //   24: aload_1
    //   25: iconst_1
    //   26: invokevirtual 197	com/tencent/threadpool/b$b:release	(I)Z
    //   29: pop
    //   30: aload 4
    //   32: astore 5
    //   34: aload 4
    //   36: ifnonnull +14 -> 50
    //   39: aload_0
    //   40: invokespecial 234	com/tencent/threadpool/b:jYP	()Ljava/lang/Runnable;
    //   43: astore 5
    //   45: aload 5
    //   47: ifnull +119 -> 166
    //   50: aload_1
    //   51: iconst_1
    //   52: invokevirtual 346	com/tencent/threadpool/b$b:acquire	(I)V
    //   55: aload_0
    //   56: getfield 104	com/tencent/threadpool/b:ahzX	Ljava/util/concurrent/atomic/AtomicInteger;
    //   59: invokevirtual 244	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   62: ldc_w 318
    //   65: invokestatic 248	com/tencent/threadpool/b:pL	(II)Z
    //   68: ifeq +28 -> 96
    //   71: aload 6
    //   73: invokevirtual 349	java/lang/Thread:isInterrupted	()Z
    //   76: ifne +20 -> 96
    //   79: aload_1
    //   80: invokevirtual 175	com/tencent/threadpool/b$b:jYR	()V
    //   83: aload_0
    //   84: aload_1
    //   85: iconst_1
    //   86: invokespecial 351	com/tencent/threadpool/b:a	(Lcom/tencent/threadpool/b$b;Z)V
    //   89: ldc_w 337
    //   92: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: return
    //   96: aload_0
    //   97: aload 6
    //   99: aload 5
    //   101: invokevirtual 355	com/tencent/threadpool/b:beforeExecute	(Ljava/lang/Thread;Ljava/lang/Runnable;)V
    //   104: aload 5
    //   106: invokeinterface 358 1 0
    //   111: aload_0
    //   112: aload 5
    //   114: aconst_null
    //   115: invokevirtual 360	com/tencent/threadpool/b:afterExecute	(Ljava/lang/Runnable;Ljava/lang/Throwable;)V
    //   118: aload_1
    //   119: getfield 203	com/tencent/threadpool/b$b:ahAl	Ljava/util/concurrent/atomic/AtomicLong;
    //   122: invokevirtual 363	java/util/concurrent/atomic/AtomicLong:getAndIncrement	()J
    //   125: pop2
    //   126: aload_0
    //   127: invokespecial 234	com/tencent/threadpool/b:jYP	()Ljava/lang/Runnable;
    //   130: astore 4
    //   132: aload 4
    //   134: ifnull +250 -> 384
    //   137: aload_1
    //   138: aload 4
    //   140: invokevirtual 297	com/tencent/threadpool/b$b:bj	(Ljava/lang/Runnable;)V
    //   143: aload_1
    //   144: getstatic 259	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   147: aload_1
    //   148: invokeinterface 367 2 0
    //   153: putfield 217	com/tencent/threadpool/b$b:dBj	Ljava/util/concurrent/Future;
    //   156: iconst_0
    //   157: istore_2
    //   158: iload_2
    //   159: istore_3
    //   160: aload_1
    //   161: iconst_1
    //   162: invokevirtual 197	com/tencent/threadpool/b$b:release	(I)Z
    //   165: pop
    //   166: iload_2
    //   167: ifeq +191 -> 358
    //   170: aload_0
    //   171: aload_1
    //   172: iconst_0
    //   173: invokespecial 351	com/tencent/threadpool/b:a	(Lcom/tencent/threadpool/b$b;Z)V
    //   176: ldc_w 337
    //   179: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: return
    //   183: astore 6
    //   185: aload 6
    //   187: astore 4
    //   189: ldc_w 337
    //   192: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: aload 6
    //   197: astore 4
    //   199: aload 6
    //   201: athrow
    //   202: astore 6
    //   204: aload_0
    //   205: aload 5
    //   207: aload 4
    //   209: invokevirtual 360	com/tencent/threadpool/b:afterExecute	(Ljava/lang/Runnable;Ljava/lang/Throwable;)V
    //   212: ldc_w 337
    //   215: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aload 6
    //   220: athrow
    //   221: astore 4
    //   223: aload_1
    //   224: getfield 203	com/tencent/threadpool/b$b:ahAl	Ljava/util/concurrent/atomic/AtomicLong;
    //   227: invokevirtual 363	java/util/concurrent/atomic/AtomicLong:getAndIncrement	()J
    //   230: pop2
    //   231: aload_0
    //   232: invokespecial 234	com/tencent/threadpool/b:jYP	()Ljava/lang/Runnable;
    //   235: astore 5
    //   237: aload 5
    //   239: ifnull +140 -> 379
    //   242: aload_1
    //   243: aload 5
    //   245: invokevirtual 297	com/tencent/threadpool/b$b:bj	(Ljava/lang/Runnable;)V
    //   248: aload_1
    //   249: getstatic 259	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   252: aload_1
    //   253: invokeinterface 367 2 0
    //   258: putfield 217	com/tencent/threadpool/b$b:dBj	Ljava/util/concurrent/Future;
    //   261: iconst_0
    //   262: istore_2
    //   263: iload_2
    //   264: istore_3
    //   265: aload_1
    //   266: iconst_1
    //   267: invokevirtual 197	com/tencent/threadpool/b$b:release	(I)Z
    //   270: pop
    //   271: iload_2
    //   272: istore_3
    //   273: ldc_w 337
    //   276: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: iload_2
    //   280: istore_3
    //   281: aload 4
    //   283: athrow
    //   284: astore 4
    //   286: iload_3
    //   287: ifeq +9 -> 296
    //   290: aload_0
    //   291: aload_1
    //   292: iconst_1
    //   293: invokespecial 351	com/tencent/threadpool/b:a	(Lcom/tencent/threadpool/b$b;Z)V
    //   296: ldc_w 337
    //   299: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: aload 4
    //   304: athrow
    //   305: astore 6
    //   307: aload 6
    //   309: astore 4
    //   311: ldc_w 337
    //   314: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: aload 6
    //   319: astore 4
    //   321: aload 6
    //   323: athrow
    //   324: astore 6
    //   326: aload 6
    //   328: astore 4
    //   330: new 336	java/lang/Error
    //   333: dup
    //   334: aload 6
    //   336: invokespecial 370	java/lang/Error:<init>	(Ljava/lang/Throwable;)V
    //   339: astore 7
    //   341: aload 6
    //   343: astore 4
    //   345: ldc_w 337
    //   348: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   351: aload 6
    //   353: astore 4
    //   355: aload 7
    //   357: athrow
    //   358: ldc_w 337
    //   361: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   364: return
    //   365: astore 4
    //   367: iconst_1
    //   368: istore_3
    //   369: goto -83 -> 286
    //   372: astore 4
    //   374: iconst_0
    //   375: istore_3
    //   376: goto -90 -> 286
    //   379: iconst_1
    //   380: istore_2
    //   381: goto -118 -> 263
    //   384: iconst_1
    //   385: istore_2
    //   386: goto -228 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	this	b
    //   0	389	1	paramb	b
    //   1	385	2	i	int
    //   159	217	3	j	int
    //   17	191	4	localObject1	Object
    //   221	61	4	localObject2	Object
    //   284	19	4	localObject3	Object
    //   309	45	4	localObject4	Object
    //   365	1	4	localObject5	Object
    //   372	1	4	localObject6	Object
    //   32	212	5	localObject7	Object
    //   11	87	6	localThread	Thread
    //   183	17	6	localRuntimeException	java.lang.RuntimeException
    //   202	17	6	localObject8	Object
    //   305	17	6	localError1	java.lang.Error
    //   324	28	6	localThrowable	Throwable
    //   339	17	7	localError2	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   104	111	183	java/lang/RuntimeException
    //   189	195	202	finally
    //   199	202	202	finally
    //   311	317	202	finally
    //   321	324	202	finally
    //   330	341	202	finally
    //   345	351	202	finally
    //   355	358	202	finally
    //   96	104	221	finally
    //   111	118	221	finally
    //   204	221	221	finally
    //   160	166	284	finally
    //   265	271	284	finally
    //   273	279	284	finally
    //   281	284	284	finally
    //   104	111	305	java/lang/Error
    //   104	111	324	finally
    //   39	45	365	finally
    //   50	83	365	finally
    //   118	132	365	finally
    //   223	237	365	finally
    //   137	156	372	finally
    //   242	261	372	finally
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable) {}
  
  public void execute(Runnable paramRunnable)
  {
    int j = 1;
    AppMethodBeat.i(183122);
    if (paramRunnable == null)
    {
      paramRunnable = new NullPointerException();
      AppMethodBeat.o(183122);
      throw paramRunnable;
    }
    int k = this.ahzX.get();
    int i = k;
    if ((k & 0x1FFFFFFF) < this.hsI)
    {
      if (b(paramRunnable, true))
      {
        AppMethodBeat.o(183122);
        return;
      }
      i = this.ahzX.get();
    }
    if (i < 0)
    {
      i = 1;
      if ((i == 0) || (!this.ahzZ.offer(paramRunnable))) {
        break label197;
      }
      k = this.ahzX.get();
      if (k >= 0) {
        break label157;
      }
    }
    label157:
    for (i = j;; i = 0)
    {
      if (i != 0) {
        break label162;
      }
      boolean bool = this.ahzZ.remove(paramRunnable);
      jYO();
      if (!bool) {
        break label162;
      }
      bh(paramRunnable);
      AppMethodBeat.o(183122);
      return;
      i = 0;
      break;
    }
    label162:
    if ((k & 0x1FFFFFFF) == 0)
    {
      b(null, false);
      AppMethodBeat.o(183122);
      return;
    }
    bi(null);
    AppMethodBeat.o(183122);
    return;
    label197:
    if (!b(paramRunnable, false)) {
      bh(paramRunnable);
    }
    AppMethodBeat.o(183122);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(183129);
    shutdown();
    AppMethodBeat.o(183129);
  }
  
  protected void iFm()
  {
    AppMethodBeat.i(183132);
    Iterator localIterator = ahzY.iterator();
    while (localIterator.hasNext()) {
      if (this == (b)((WeakReference)localIterator.next()).get()) {
        localIterator.remove();
      }
    }
    AppMethodBeat.o(183132);
  }
  
  public boolean isShutdown()
  {
    AppMethodBeat.i(183126);
    if (this.ahzX.get() < 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(183126);
      return true;
    }
    AppMethodBeat.o(183126);
    return false;
  }
  
  public boolean isTerminated()
  {
    AppMethodBeat.i(183127);
    boolean bool = pL(this.ahzX.get(), 1610612736);
    AppMethodBeat.o(183127);
    return bool;
  }
  
  public final long jYQ()
  {
    AppMethodBeat.i(183130);
    ReentrantLock localReentrantLock = this.EWY;
    localReentrantLock.lock();
    try
    {
      long l1 = this.ahAe;
      Iterator localIterator = this.ahAa.iterator();
      while (localIterator.hasNext())
      {
        long l2 = ((b)localIterator.next()).ahAl.get();
        l1 = l2 + l1;
      }
      return l1;
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(183130);
    }
  }
  
  public void shutdown()
  {
    AppMethodBeat.i(183124);
    ReentrantLock localReentrantLock = this.EWY;
    localReentrantLock.lock();
    try
    {
      aHp(0);
      Ov(false);
      localReentrantLock.unlock();
      jYO();
      AppMethodBeat.o(183124);
      return;
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(183124);
    }
  }
  
  public List<Runnable> shutdownNow()
  {
    int i = 0;
    AppMethodBeat.i(183125);
    ReentrantLock localReentrantLock1 = this.EWY;
    localReentrantLock1.lock();
    try
    {
      aHp(536870912);
      ReentrantLock localReentrantLock2 = this.EWY;
      localReentrantLock2.lock();
      try
      {
        Iterator localIterator = this.ahAa.iterator();
        while (localIterator.hasNext())
        {
          ((b)localIterator.next()).jYR();
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
      AppMethodBeat.o(183125);
    }
    BlockingQueue localBlockingQueue = this.ahzZ;
    ArrayList localArrayList = new ArrayList();
    localBlockingQueue.drainTo(localArrayList);
    if (!localBlockingQueue.isEmpty())
    {
      Runnable[] arrayOfRunnable = (Runnable[])localBlockingQueue.toArray(new Runnable[0]);
      int j = arrayOfRunnable.length;
      while (i < j)
      {
        Runnable localRunnable = arrayOfRunnable[i];
        if (localBlockingQueue.remove(localRunnable)) {
          localArrayList.add(localRunnable);
        }
        i += 1;
      }
    }
    localReentrantLock1.unlock();
    jYO();
    AppMethodBeat.o(183125);
    return localArrayList;
  }
  
  public String toString()
  {
    AppMethodBeat.i(183131);
    Object localObject1 = this.EWY;
    StringBuilder localStringBuilder = new StringBuilder();
    ((ReentrantLock)localObject1).lock();
    for (;;)
    {
      int j;
      try
      {
        long l = this.ahAe;
        int k = this.ahAa.size();
        Iterator localIterator = this.ahAa.iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          l += localb.ahAl.get();
          j = i;
          if (localb.isLocked())
          {
            j = i + 1;
            localStringBuilder.append(localb.mhl);
          }
          i = j;
          continue;
        }
        ((ReentrantLock)localObject1).unlock();
        j = this.ahzX.get();
        if (pK(j, 0))
        {
          localObject1 = "Running";
          localObject1 = super.toString() + "[" + (String)localObject1 + ", pool size = " + k + ", active threads = " + i + ", queued tasks = " + this.ahzZ.size() + ", completed tasks = " + l + ", running tasks = " + localStringBuilder + "]";
          AppMethodBeat.o(183131);
          return localObject1;
        }
      }
      finally
      {
        ((ReentrantLock)localObject1).unlock();
        AppMethodBeat.o(183131);
      }
      if (pL(j, 1610612736)) {
        localObject1 = "Terminated";
      } else {
        localObject1 = "Shutting down";
      }
    }
  }
  
  public static final class a
    implements e
  {
    public final void rejectedExecution(Runnable paramRunnable, b paramb)
    {
      AppMethodBeat.i(183099);
      paramRunnable = new RejectedExecutionException("Task " + paramRunnable.toString() + " rejected from " + paramb.toString());
      AppMethodBeat.o(183099);
      throw paramRunnable;
    }
  }
  
  final class b
    extends AbstractQueuedSynchronizer
    implements com.tencent.threadpool.i.h
  {
    Runnable ahAk;
    AtomicLong ahAl;
    AtomicBoolean ahAm;
    Future dBj;
    String mhl;
    
    b(Runnable paramRunnable)
    {
      AppMethodBeat.i(183100);
      this.ahAl = new AtomicLong(0L);
      this.ahAm = new AtomicBoolean(false);
      setState(-1);
      bj(paramRunnable);
      AppMethodBeat.o(183100);
    }
    
    final void bj(Runnable paramRunnable)
    {
      AppMethodBeat.i(183101);
      this.ahAk = paramRunnable;
      if (paramRunnable == null)
      {
        this.mhl = (b.a(b.this) + "#Worker");
        AppMethodBeat.o(183101);
        return;
      }
      if ((paramRunnable instanceof com.tencent.threadpool.i.h))
      {
        this.mhl = ((com.tencent.threadpool.i.h)paramRunnable).getKey();
        AppMethodBeat.o(183101);
        return;
      }
      this.mhl = (b.a(b.this) + "#" + paramRunnable.getClass().getName());
      AppMethodBeat.o(183101);
    }
    
    public final String getKey()
    {
      return this.mhl;
    }
    
    protected final boolean isHeldExclusively()
    {
      AppMethodBeat.i(183105);
      if (getState() != 0)
      {
        AppMethodBeat.o(183105);
        return true;
      }
      AppMethodBeat.o(183105);
      return false;
    }
    
    public final boolean isLocked()
    {
      AppMethodBeat.i(183108);
      boolean bool = isHeldExclusively();
      AppMethodBeat.o(183108);
      return bool;
    }
    
    final void jYR()
    {
      AppMethodBeat.i(183103);
      d.ahAq.i("ForkThreadPoolExecutor", "[releaseWork] name=" + b.a(b.this), new Object[0]);
      if ((this.dBj != null) && (!this.dBj.isDone())) {
        this.dBj.cancel(true);
      }
      AppMethodBeat.o(183103);
    }
    
    public final void run()
    {
      AppMethodBeat.i(183104);
      b.this.b(this);
      AppMethodBeat.o(183104);
    }
    
    final void start()
    {
      AppMethodBeat.i(183102);
      this.dBj = h.ahAA.bm(this);
      AppMethodBeat.o(183102);
    }
    
    protected final boolean tryAcquire(int paramInt)
    {
      AppMethodBeat.i(183106);
      if (compareAndSetState(0, 1))
      {
        setExclusiveOwnerThread(Thread.currentThread());
        AppMethodBeat.o(183106);
        return true;
      }
      AppMethodBeat.o(183106);
      return false;
    }
    
    protected final boolean tryRelease(int paramInt)
    {
      AppMethodBeat.i(183107);
      setExclusiveOwnerThread(null);
      setState(0);
      AppMethodBeat.o(183107);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.b
 * JD-Core Version:    0.7.0.1
 */