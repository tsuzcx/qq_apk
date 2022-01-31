package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class d$a
{
  private Lock mHZ;
  private final int oKA;
  private Callable<d> oKB;
  private LinkedBlockingQueue<d> oKz;
  private volatile int size;
  
  public d$a(int paramInt, Callable<d> paramCallable)
  {
    AppMethodBeat.i(3637);
    this.size = 0;
    this.mHZ = new ReentrantLock();
    this.oKA = paramInt;
    this.oKz = new LinkedBlockingQueue(paramInt);
    this.oKB = paramCallable;
    AppMethodBeat.o(3637);
  }
  
  private d bRB()
  {
    AppMethodBeat.i(3639);
    Object localObject;
    if (this.oKB == null)
    {
      localObject = new IllegalStateException("fetcher generator can not be null.");
      AppMethodBeat.o(3639);
      throw ((Throwable)localObject);
    }
    long l = bo.yB();
    try
    {
      localObject = (d)this.oKB.call();
      ab.d("FetcherPool", "time flee, construct fetcher instance cost %d", new Object[] { Long.valueOf(bo.av(l)) });
      AppMethodBeat.o(3639);
      return localObject;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("FetcherPool", localException, " fetcher generater call error %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(3639);
      throw localException;
    }
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(3640);
    ab.d("FetcherPool", "reuseFetcher");
    if (paramd == null)
    {
      ab.e("FetcherPool", "Null object can not be reused.");
      AppMethodBeat.o(3640);
      return;
    }
    if (this.oKz == null)
    {
      paramd.release();
      AppMethodBeat.o(3640);
      return;
    }
    if (this.oKz.contains(paramd))
    {
      paramd = new IllegalStateException("fetcher already in pool");
      AppMethodBeat.o(3640);
      throw paramd;
    }
    this.oKz.offer(paramd);
    AppMethodBeat.o(3640);
  }
  
  public final d bRA()
  {
    AppMethodBeat.i(3638);
    long l = bo.yB();
    ab.d("FetcherPool", "acquireFetcher");
    if (this.oKz == null)
    {
      ab.d("FetcherPool", "acquireFetcher no pool directly return null");
      AppMethodBeat.o(3638);
      return null;
    }
    this.mHZ.lock();
    ab.d("FetcherPool", "pool.size() %d, size %d, maxFetcherSize %d", new Object[] { Integer.valueOf(this.oKz.size()), Integer.valueOf(this.size), Integer.valueOf(this.oKA) });
    if (this.oKz == null)
    {
      this.mHZ.unlock();
      AppMethodBeat.o(3638);
      return null;
    }
    if ((this.oKz.isEmpty()) && (this.size < this.oKA))
    {
      ab.d("FetcherPool", "new fetcher");
      this.size += 1;
      this.mHZ.unlock();
    }
    for (d locald = bRB();; locald = (d)this.oKz.poll(5L, TimeUnit.SECONDS))
    {
      ab.d("FetcherPool", "time flee, acquireFetcher cost time %d", new Object[] { Long.valueOf(bo.av(l)) });
      AppMethodBeat.o(3638);
      return locald;
      ab.d("FetcherPool", "waiting fetcher");
      this.mHZ.unlock();
    }
  }
  
  /* Error */
  public final void destroy()
  {
    // Byte code:
    //   0: sipush 3641
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 44	com/tencent/mm/plugin/mmsight/segment/d$a:oKz	Ljava/util/concurrent/LinkedBlockingQueue;
    //   10: ifnonnull +10 -> 20
    //   13: sipush 3641
    //   16: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aload_0
    //   21: getfield 36	com/tencent/mm/plugin/mmsight/segment/d$a:mHZ	Ljava/util/concurrent/locks/Lock;
    //   24: invokeinterface 138 1 0
    //   29: aload_0
    //   30: getfield 44	com/tencent/mm/plugin/mmsight/segment/d$a:oKz	Ljava/util/concurrent/LinkedBlockingQueue;
    //   33: ifnonnull +19 -> 52
    //   36: aload_0
    //   37: getfield 36	com/tencent/mm/plugin/mmsight/segment/d$a:mHZ	Ljava/util/concurrent/locks/Lock;
    //   40: invokeinterface 151 1 0
    //   45: sipush 3641
    //   48: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: return
    //   52: aload_0
    //   53: getfield 44	com/tencent/mm/plugin/mmsight/segment/d$a:oKz	Ljava/util/concurrent/LinkedBlockingQueue;
    //   56: invokevirtual 180	java/util/concurrent/LinkedBlockingQueue:iterator	()Ljava/util/Iterator;
    //   59: astore_1
    //   60: aload_1
    //   61: invokeinterface 185 1 0
    //   66: ifeq +61 -> 127
    //   69: aload_1
    //   70: invokeinterface 188 1 0
    //   75: checkcast 6	com/tencent/mm/plugin/mmsight/segment/d
    //   78: invokeinterface 119 1 0
    //   83: goto -23 -> 60
    //   86: astore_1
    //   87: ldc 77
    //   89: aload_1
    //   90: ldc 190
    //   92: iconst_1
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: aload_1
    //   99: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   102: aastore
    //   103: invokestatic 105	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_0
    //   107: aconst_null
    //   108: putfield 44	com/tencent/mm/plugin/mmsight/segment/d$a:oKz	Ljava/util/concurrent/LinkedBlockingQueue;
    //   111: aload_0
    //   112: getfield 36	com/tencent/mm/plugin/mmsight/segment/d$a:mHZ	Ljava/util/concurrent/locks/Lock;
    //   115: invokeinterface 151 1 0
    //   120: sipush 3641
    //   123: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: return
    //   127: aload_0
    //   128: aconst_null
    //   129: putfield 44	com/tencent/mm/plugin/mmsight/segment/d$a:oKz	Ljava/util/concurrent/LinkedBlockingQueue;
    //   132: aload_0
    //   133: getfield 36	com/tencent/mm/plugin/mmsight/segment/d$a:mHZ	Ljava/util/concurrent/locks/Lock;
    //   136: invokeinterface 151 1 0
    //   141: sipush 3641
    //   144: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: return
    //   148: astore_1
    //   149: aload_0
    //   150: aconst_null
    //   151: putfield 44	com/tencent/mm/plugin/mmsight/segment/d$a:oKz	Ljava/util/concurrent/LinkedBlockingQueue;
    //   154: aload_0
    //   155: getfield 36	com/tencent/mm/plugin/mmsight/segment/d$a:mHZ	Ljava/util/concurrent/locks/Lock;
    //   158: invokeinterface 151 1 0
    //   163: sipush 3641
    //   166: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_1
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	a
    //   59	11	1	localIterator	java.util.Iterator
    //   86	13	1	localException	Exception
    //   148	22	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   52	60	86	java/lang/Exception
    //   60	83	86	java/lang/Exception
    //   52	60	148	finally
    //   60	83	148	finally
    //   87	106	148	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.d.a
 * JD-Core Version:    0.7.0.1
 */