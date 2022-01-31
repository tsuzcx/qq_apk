package com.tencent.mm.sdk.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class c
  implements a
{
  private static final c.b ysT;
  private static final RuntimePermission ysU;
  private volatile int cgb;
  private String name;
  private final AtomicInteger ysK;
  private final BlockingQueue<Runnable> ysL;
  private final HashSet<c.c> ysM;
  private final HashSet<c.c> ysN;
  private final Condition ysO;
  private int ysP;
  private long ysQ;
  private volatile c.b ysR;
  private volatile int ysS;
  private final ReentrantLock yss;
  
  static
  {
    AppMethodBeat.i(52625);
    ysT = new a();
    ysU = new RuntimePermission("modifyThread");
    AppMethodBeat.o(52625);
  }
  
  public c(String paramString, int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue)
  {
    AppMethodBeat.i(52615);
    this.ysK = new AtomicInteger(-536870912);
    this.yss = new ReentrantLock();
    this.ysM = new HashSet();
    this.ysN = new HashSet();
    this.ysO = this.yss.newCondition();
    if ((paramInt1 < 0) || (paramInt2 <= 0) || (paramInt2 < paramInt1))
    {
      paramString = new IllegalArgumentException();
      AppMethodBeat.o(52615);
      throw paramString;
    }
    if ((paramBlockingQueue == null) || (paramString == null))
    {
      paramString = new NullPointerException();
      AppMethodBeat.o(52615);
      throw paramString;
    }
    this.cgb = paramInt1;
    this.name = paramString;
    this.ysS = paramInt2;
    this.ysL = paramBlockingQueue;
    this.ysR = new a();
    AppMethodBeat.o(52615);
  }
  
  public c(String paramString, BlockingQueue<Runnable> paramBlockingQueue)
  {
    AppMethodBeat.i(52614);
    this.ysK = new AtomicInteger(-536870912);
    this.yss = new ReentrantLock();
    this.ysM = new HashSet();
    this.ysN = new HashSet();
    this.ysO = this.yss.newCondition();
    if ((paramBlockingQueue == null) || (paramString == null))
    {
      paramString = new NullPointerException();
      AppMethodBeat.o(52614);
      throw paramString;
    }
    this.name = paramString;
    this.cgb = 6;
    this.ysS = 6;
    this.ysL = paramBlockingQueue;
    this.ysR = new a();
    AppMethodBeat.o(52614);
  }
  
  private boolean Nk(int paramInt)
  {
    AppMethodBeat.i(52603);
    boolean bool = this.ysK.compareAndSet(paramInt, paramInt - 1);
    AppMethodBeat.o(52603);
    return bool;
  }
  
  private void Nl(int paramInt)
  {
    AppMethodBeat.i(52605);
    int i;
    do
    {
      i = this.ysK.get();
    } while (((paramInt == -536870912) || (!hm(i, paramInt))) && (!this.ysK.compareAndSet(i, 0x1FFFFFFF & i | paramInt)));
    AppMethodBeat.o(52605);
  }
  
  private void a(c.c paramc)
  {
    AppMethodBeat.i(52609);
    ReentrantLock localReentrantLock = this.yss;
    localReentrantLock.lock();
    if (paramc != null) {}
    try
    {
      this.ysM.remove(paramc);
      dux();
      duy();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(52609);
    }
  }
  
  private void a(c.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(52610);
    ReentrantLock localReentrantLock = this.yss;
    if (((this.ysK.get() & 0x1FFFFFFF) > this.cgb) || (paramBoolean))
    {
      dux();
      localReentrantLock.lock();
    }
    for (;;)
    {
      try
      {
        this.ysQ += paramc.ysX;
        paramc.ysX = 0L;
        this.ysM.remove(paramc);
        localReentrantLock.unlock();
        duy();
        AppMethodBeat.o(52610);
        return;
      }
      finally
      {
        localReentrantLock.unlock();
        AppMethodBeat.o(52610);
      }
      localReentrantLock.lock();
      try
      {
        this.ysQ += paramc.ysX;
        paramc.ysX = 0L;
        paramc.release(1);
        this.ysN.add(paramc);
        localReentrantLock.unlock();
      }
      finally
      {
        localReentrantLock.unlock();
        AppMethodBeat.o(52610);
      }
    }
  }
  
  private boolean a(Runnable paramRunnable, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(52608);
    int i;
    int k;
    do
    {
      i = this.ysK.get();
      k = i & 0xE0000000;
      if ((k < 0) || ((k == 0) && (paramRunnable == null) && (!this.ysL.isEmpty()))) {
        break label301;
      }
      AppMethodBeat.o(52608);
      return false;
      if (this.ysK.compareAndSet(i, i + 1)) {
        break;
      }
      i = this.ysK.get();
    } while ((i & 0xE0000000) != k);
    int j;
    label301:
    for (;;)
    {
      int m = i & 0x1FFFFFFF;
      if (m < 536870911) {
        if (!paramBoolean) {
          break label123;
        }
      }
      label123:
      for (j = this.cgb; m >= j; j = this.ysS)
      {
        AppMethodBeat.o(52608);
        return false;
      }
      break;
      for (;;)
      {
        try
        {
          localc = new c.c(this, paramRunnable);
        }
        finally
        {
          c.c localc;
          ReentrantLock localReentrantLock;
          continue;
          i = 0;
          j = 0;
        }
        try
        {
          localReentrantLock = this.yss;
          localReentrantLock.lock();
          try
          {
            i = this.ysK.get() & 0xE0000000;
            if ((i >= 0) && ((i != 0) || (paramRunnable != null))) {
              continue;
            }
            this.ysM.add(localc);
            i = this.ysM.size();
            if (i > this.ysP) {
              this.ysP = i;
            }
            j = 1;
            localReentrantLock.unlock();
            paramBoolean = bool;
            if (j != 0)
            {
              localc.id = i;
              d.ysm.execute(localc);
              paramBoolean = true;
            }
            if (!paramBoolean) {}
            return paramBoolean;
          }
          finally
          {
            localReentrantLock.unlock();
            AppMethodBeat.o(52608);
          }
          paramRunnable = finally;
        }
        finally
        {
          a(localc);
          AppMethodBeat.o(52608);
        }
      }
    }
  }
  
  private void ap(Runnable paramRunnable)
  {
    AppMethodBeat.i(52607);
    this.ysR.a(paramRunnable, this);
    AppMethodBeat.o(52607);
  }
  
  private boolean duA()
  {
    AppMethodBeat.i(52613);
    if ((this.ysK.get() & 0xE0000000) >= 0)
    {
      AppMethodBeat.o(52613);
      return false;
    }
    ReentrantLock localReentrantLock = this.yss;
    localReentrantLock.lock();
    try
    {
      Iterator localIterator = this.ysN.iterator();
      if (localIterator.hasNext())
      {
        c.c localc = (c.c)localIterator.next();
        localc.ysW = null;
        d.ysm.execute(localc);
        localIterator.remove();
        return true;
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(52613);
    }
  }
  
  private void dux()
  {
    AppMethodBeat.i(52604);
    while (!Nk(this.ysK.get())) {}
    AppMethodBeat.o(52604);
  }
  
  private void duy()
  {
    AppMethodBeat.i(52606);
    for (;;)
    {
      int j = this.ysK.get();
      if (j < 0) {}
      for (int i = 1; (i != 0) || (hm(j, 1073741824)) || (((0xE0000000 & j) == 0) && (!this.ysL.isEmpty())); i = 0)
      {
        AppMethodBeat.o(52606);
        return;
      }
      if ((0x1FFFFFFF & j) != 0)
      {
        AppMethodBeat.o(52606);
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
        AppMethodBeat.o(52606);
      }
    }
  }
  
  private Runnable duz()
  {
    AppMethodBeat.i(52611);
    int i = this.ysK.get();
    int j = 0xE0000000 & i;
    if ((j >= 0) && ((j >= 536870912) || (this.ysL.isEmpty())))
    {
      dux();
      AppMethodBeat.o(52611);
      return null;
    }
    j = 0x1FFFFFFF & i;
    if ((j > this.ysS) && ((j > 1) || (this.ysL.isEmpty())) && (Nk(i)))
    {
      AppMethodBeat.o(52611);
      return null;
    }
    Runnable localRunnable = (Runnable)this.ysL.poll();
    AppMethodBeat.o(52611);
    return localRunnable;
  }
  
  private static boolean hm(int paramInt1, int paramInt2)
  {
    return paramInt1 >= paramInt2;
  }
  
  private List<Runnable> shutdownNow()
  {
    int i = 0;
    AppMethodBeat.i(52618);
    ReentrantLock localReentrantLock1 = this.yss;
    localReentrantLock1.lock();
    try
    {
      Nl(536870912);
      ReentrantLock localReentrantLock2 = this.yss;
      localReentrantLock2.lock();
      try
      {
        Iterator localIterator = this.ysM.iterator();
        while (localIterator.hasNext())
        {
          localIterator.next();
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
      AppMethodBeat.o(52618);
    }
    BlockingQueue localBlockingQueue = this.ysL;
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
    duy();
    AppMethodBeat.o(52618);
    return localArrayList;
  }
  
  /* Error */
  final void b(c.c paramc)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: ldc_w 275
    //   6: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 281	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12: astore 9
    //   14: aload_1
    //   15: getfield 221	com/tencent/mm/sdk/g/b/c$c:ysW	Ljava/lang/Runnable;
    //   18: ifnonnull +212 -> 230
    //   21: aload_0
    //   22: invokespecial 283	com/tencent/mm/sdk/g/b/c:duz	()Ljava/lang/Runnable;
    //   25: astore 6
    //   27: aload_1
    //   28: aconst_null
    //   29: putfield 221	com/tencent/mm/sdk/g/b/c$c:ysW	Ljava/lang/Runnable;
    //   32: aload_1
    //   33: iconst_1
    //   34: invokevirtual 161	com/tencent/mm/sdk/g/b/c$c:release	(I)Z
    //   37: pop
    //   38: iconst_1
    //   39: istore_2
    //   40: iconst_0
    //   41: istore 5
    //   43: aload 6
    //   45: astore 7
    //   47: aload 6
    //   49: ifnonnull +22 -> 71
    //   52: iload 5
    //   54: ifeq +355 -> 409
    //   57: iload_2
    //   58: istore 4
    //   60: aload_0
    //   61: invokespecial 283	com/tencent/mm/sdk/g/b/c:duz	()Ljava/lang/Runnable;
    //   64: astore 7
    //   66: aload 7
    //   68: ifnull +341 -> 409
    //   71: iload_2
    //   72: istore 4
    //   74: aload_1
    //   75: iconst_1
    //   76: invokevirtual 286	com/tencent/mm/sdk/g/b/c$c:acquire	(I)V
    //   79: iload_2
    //   80: istore 4
    //   82: aload_0
    //   83: getfield 76	com/tencent/mm/sdk/g/b/c:ysK	Ljava/util/concurrent/atomic/AtomicInteger;
    //   86: invokevirtual 128	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   89: ldc 241
    //   91: invokestatic 131	com/tencent/mm/sdk/g/b/c:hm	(II)Z
    //   94: ifne +30 -> 124
    //   97: iload_2
    //   98: istore 4
    //   100: invokestatic 289	java/lang/Thread:interrupted	()Z
    //   103: ifeq +36 -> 139
    //   106: iload_2
    //   107: istore 4
    //   109: aload_0
    //   110: getfield 76	com/tencent/mm/sdk/g/b/c:ysK	Ljava/util/concurrent/atomic/AtomicInteger;
    //   113: invokevirtual 128	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   116: ldc 241
    //   118: invokestatic 131	com/tencent/mm/sdk/g/b/c:hm	(II)Z
    //   121: ifeq +18 -> 139
    //   124: iload_2
    //   125: istore 4
    //   127: aload 9
    //   129: invokevirtual 292	java/lang/Thread:isInterrupted	()Z
    //   132: istore 5
    //   134: iload 5
    //   136: ifeq +273 -> 409
    //   139: aload_0
    //   140: aload 9
    //   142: aload 7
    //   144: invokevirtual 296	com/tencent/mm/sdk/g/b/c:beforeExecute	(Ljava/lang/Thread;Ljava/lang/Runnable;)V
    //   147: aload 8
    //   149: astore 6
    //   151: aload 7
    //   153: invokeinterface 299 1 0
    //   158: invokestatic 302	com/tencent/mm/sdk/g/b/c$c:duB	()Z
    //   161: istore 5
    //   163: iload_2
    //   164: istore_3
    //   165: iload 5
    //   167: ifne +33 -> 200
    //   170: aload_0
    //   171: invokespecial 283	com/tencent/mm/sdk/g/b/c:duz	()Ljava/lang/Runnable;
    //   174: astore 6
    //   176: aload_1
    //   177: aload 6
    //   179: putfield 221	com/tencent/mm/sdk/g/b/c$c:ysW	Ljava/lang/Runnable;
    //   182: iload_2
    //   183: istore_3
    //   184: aload 6
    //   186: ifnull +14 -> 200
    //   189: getstatic 189	com/tencent/mm/sdk/g/d:ysm	Lcom/tencent/mm/sdk/g/a/e;
    //   192: aload_1
    //   193: invokeinterface 195 2 0
    //   198: iconst_0
    //   199: istore_3
    //   200: iload_3
    //   201: istore 4
    //   203: aload_1
    //   204: aload_1
    //   205: getfield 158	com/tencent/mm/sdk/g/b/c$c:ysX	J
    //   208: lconst_1
    //   209: ladd
    //   210: putfield 158	com/tencent/mm/sdk/g/b/c$c:ysX	J
    //   213: iload_3
    //   214: istore 4
    //   216: aload_1
    //   217: iconst_1
    //   218: invokevirtual 161	com/tencent/mm/sdk/g/b/c$c:release	(I)Z
    //   221: pop
    //   222: aconst_null
    //   223: astore 6
    //   225: iload_3
    //   226: istore_2
    //   227: goto -184 -> 43
    //   230: aload_1
    //   231: getfield 221	com/tencent/mm/sdk/g/b/c$c:ysW	Ljava/lang/Runnable;
    //   234: astore 6
    //   236: goto -209 -> 27
    //   239: astore 7
    //   241: aload 7
    //   243: astore 6
    //   245: ldc_w 275
    //   248: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: aload 7
    //   253: astore 6
    //   255: aload 7
    //   257: athrow
    //   258: astore 7
    //   260: aload 6
    //   262: ifnonnull +184 -> 446
    //   265: invokestatic 302	com/tencent/mm/sdk/g/b/c$c:duB	()Z
    //   268: ifne +178 -> 446
    //   271: aload_0
    //   272: invokespecial 283	com/tencent/mm/sdk/g/b/c:duz	()Ljava/lang/Runnable;
    //   275: astore 6
    //   277: aload_1
    //   278: aload 6
    //   280: putfield 221	com/tencent/mm/sdk/g/b/c$c:ysW	Ljava/lang/Runnable;
    //   283: aload 6
    //   285: ifnull +161 -> 446
    //   288: getstatic 189	com/tencent/mm/sdk/g/d:ysm	Lcom/tencent/mm/sdk/g/a/e;
    //   291: aload_1
    //   292: invokeinterface 195 2 0
    //   297: iconst_0
    //   298: istore_2
    //   299: ldc_w 275
    //   302: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aload 7
    //   307: athrow
    //   308: astore 6
    //   310: aload_1
    //   311: aload_1
    //   312: getfield 158	com/tencent/mm/sdk/g/b/c$c:ysX	J
    //   315: lconst_1
    //   316: ladd
    //   317: putfield 158	com/tencent/mm/sdk/g/b/c$c:ysX	J
    //   320: aload_1
    //   321: iconst_1
    //   322: invokevirtual 161	com/tencent/mm/sdk/g/b/c$c:release	(I)Z
    //   325: pop
    //   326: ldc_w 275
    //   329: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   332: aload 6
    //   334: athrow
    //   335: astore 6
    //   337: iload_2
    //   338: ifeq +9 -> 347
    //   341: aload_0
    //   342: aload_1
    //   343: iconst_1
    //   344: invokespecial 304	com/tencent/mm/sdk/g/b/c:a	(Lcom/tencent/mm/sdk/g/b/c$c;Z)V
    //   347: ldc_w 275
    //   350: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   353: aload 6
    //   355: athrow
    //   356: astore 7
    //   358: aload 7
    //   360: astore 6
    //   362: ldc_w 275
    //   365: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: aload 7
    //   370: astore 6
    //   372: aload 7
    //   374: athrow
    //   375: astore 7
    //   377: aload 7
    //   379: astore 6
    //   381: new 272	java/lang/Error
    //   384: dup
    //   385: aload 7
    //   387: invokespecial 307	java/lang/Error:<init>	(Ljava/lang/Throwable;)V
    //   390: astore 8
    //   392: aload 7
    //   394: astore 6
    //   396: ldc_w 275
    //   399: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   402: aload 7
    //   404: astore 6
    //   406: aload 8
    //   408: athrow
    //   409: iload_2
    //   410: ifeq +16 -> 426
    //   413: aload_0
    //   414: aload_1
    //   415: iconst_0
    //   416: invokespecial 304	com/tencent/mm/sdk/g/b/c:a	(Lcom/tencent/mm/sdk/g/b/c$c;Z)V
    //   419: ldc_w 275
    //   422: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   425: return
    //   426: ldc_w 275
    //   429: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   432: return
    //   433: astore 6
    //   435: iload 4
    //   437: istore_2
    //   438: goto -101 -> 337
    //   441: astore 6
    //   443: goto -133 -> 310
    //   446: goto -147 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	449	0	this	c
    //   0	449	1	paramc	c.c
    //   39	399	2	i	int
    //   164	62	3	j	int
    //   58	378	4	k	int
    //   41	125	5	bool	boolean
    //   25	259	6	localObject1	Object
    //   308	25	6	localObject2	Object
    //   335	19	6	localObject3	Object
    //   360	45	6	localObject4	Object
    //   433	1	6	localObject5	Object
    //   441	1	6	localObject6	Object
    //   45	107	7	localObject7	Object
    //   239	17	7	localRuntimeException	java.lang.RuntimeException
    //   258	48	7	localObject8	Object
    //   356	17	7	localError1	java.lang.Error
    //   375	28	7	localThrowable	java.lang.Throwable
    //   1	406	8	localError2	java.lang.Error
    //   12	129	9	localThread	Thread
    // Exception table:
    //   from	to	target	type
    //   151	158	239	java/lang/RuntimeException
    //   151	158	258	finally
    //   245	251	258	finally
    //   255	258	258	finally
    //   362	368	258	finally
    //   372	375	258	finally
    //   381	392	258	finally
    //   396	402	258	finally
    //   406	409	258	finally
    //   299	308	308	finally
    //   310	335	335	finally
    //   151	158	356	java/lang/Error
    //   151	158	375	java/lang/Throwable
    //   60	66	433	finally
    //   74	79	433	finally
    //   82	97	433	finally
    //   100	106	433	finally
    //   109	124	433	finally
    //   127	134	433	finally
    //   203	213	433	finally
    //   216	222	433	finally
    //   139	147	441	finally
    //   158	163	441	finally
    //   170	182	441	finally
    //   189	198	441	finally
    //   265	283	441	finally
    //   288	297	441	finally
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable) {}
  
  public void execute(Runnable paramRunnable)
  {
    int j = 1;
    AppMethodBeat.i(52616);
    if (paramRunnable == null)
    {
      paramRunnable = new NullPointerException();
      AppMethodBeat.o(52616);
      throw paramRunnable;
    }
    int k = this.ysK.get();
    int i = k;
    if ((k & 0x1FFFFFFF) < this.cgb)
    {
      if (a(paramRunnable, true))
      {
        AppMethodBeat.o(52616);
        return;
      }
      i = this.ysK.get();
    }
    if (i < 0) {
      i = 1;
    }
    while ((i != 0) && (this.ysL.offer(paramRunnable))) {
      if (duA())
      {
        AppMethodBeat.o(52616);
        return;
        i = 0;
      }
      else
      {
        k = this.ysK.get();
        if (k < 0) {}
        for (i = j; (i == 0) && (remove(paramRunnable)); i = 0)
        {
          ap(paramRunnable);
          AppMethodBeat.o(52616);
          return;
        }
        if ((k & 0x1FFFFFFF) == 0) {
          a(null, false);
        }
        AppMethodBeat.o(52616);
        return;
      }
    }
    if (!a(paramRunnable, false)) {
      ap(paramRunnable);
    }
    AppMethodBeat.o(52616);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(52622);
    shutdown();
    AppMethodBeat.o(52622);
  }
  
  public final int getCorePoolSize()
  {
    return this.cgb;
  }
  
  public boolean isShutdown()
  {
    AppMethodBeat.i(52619);
    if (this.ysK.get() < 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(52619);
      return true;
    }
    AppMethodBeat.o(52619);
    return false;
  }
  
  public final void r(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(52621);
    d.ysm.r(new c.1(this, paramRunnable), paramLong);
    AppMethodBeat.o(52621);
  }
  
  public final boolean remove(Runnable paramRunnable)
  {
    AppMethodBeat.i(52623);
    boolean bool = this.ysL.remove(paramRunnable);
    duy();
    AppMethodBeat.o(52623);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(52620);
    shutdownNow();
    Nl(-536870912);
    AppMethodBeat.o(52620);
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(52617);
    ReentrantLock localReentrantLock = this.yss;
    localReentrantLock.lock();
    try
    {
      Nl(0);
      localReentrantLock.unlock();
      duy();
      AppMethodBeat.o(52617);
      return;
    }
    finally
    {
      localReentrantLock.unlock();
      AppMethodBeat.o(52617);
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(52624);
    Object localObject1 = this.yss;
    ((ReentrantLock)localObject1).lock();
    label264:
    for (;;)
    {
      int m;
      try
      {
        long l = this.ysQ;
        int k = this.ysM.size();
        Iterator localIterator = this.ysM.iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          c.c localc = (c.c)localIterator.next();
          l += localc.ysX;
          boolean bool = localc.isLocked();
          if (!bool) {
            break label264;
          }
          i += 1;
          continue;
        }
        ((ReentrantLock)localObject1).unlock();
        m = this.ysK.get();
        if (m < 0)
        {
          j = 1;
          if (j == 0) {
            break label238;
          }
          localObject1 = "Running";
          localObject1 = super.toString() + "[" + (String)localObject1 + ", pool size = " + k + ", active threads = " + i + ", queued tasks = " + this.ysL.size() + ", completed tasks = " + l + "]";
          AppMethodBeat.o(52624);
          return localObject1;
        }
      }
      finally
      {
        ((ReentrantLock)localObject1).unlock();
        AppMethodBeat.o(52624);
      }
      int j = 0;
      continue;
      label238:
      if (hm(m, 1610612736)) {
        localObject1 = "Terminated";
      } else {
        localObject1 = "Shutting down";
      }
    }
  }
  
  public static final class a
    implements c.b
  {
    public final void a(Runnable paramRunnable, c paramc)
    {
      AppMethodBeat.i(52594);
      paramRunnable = new RejectedExecutionException("Task " + paramRunnable.toString() + " rejected from " + paramc.toString());
      AppMethodBeat.o(52594);
      throw paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.g.b.c
 * JD-Core Version:    0.7.0.1
 */