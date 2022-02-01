package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract interface d
{
  public abstract int getDurationMs();
  
  public abstract Bitmap getFrameAtTime(long paramLong);
  
  public abstract int getScaledHeight();
  
  public abstract int getScaledWidth();
  
  public abstract void init(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void release();
  
  public abstract void reuseBitmap(Bitmap paramBitmap);
  
  public static final class a
  {
    private Lock aHh;
    private volatile int size;
    private LinkedBlockingQueue<d> uOf;
    private final int uOg;
    private Callable<d> uOh;
    
    public a(int paramInt, Callable<d> paramCallable)
    {
      AppMethodBeat.i(107638);
      this.size = 0;
      this.aHh = new ReentrantLock();
      this.uOg = paramInt;
      this.uOf = new LinkedBlockingQueue(paramInt);
      this.uOh = paramCallable;
      AppMethodBeat.o(107638);
    }
    
    private d dee()
    {
      AppMethodBeat.i(107640);
      Object localObject;
      if (this.uOh == null)
      {
        localObject = new IllegalStateException("fetcher generator can not be null.");
        AppMethodBeat.o(107640);
        throw ((Throwable)localObject);
      }
      long l = bs.Gn();
      try
      {
        localObject = (d)this.uOh.call();
        ac.d("FetcherPool", "time flee, construct fetcher instance cost %d", new Object[] { Long.valueOf(bs.aO(l)) });
        AppMethodBeat.o(107640);
        return localObject;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("FetcherPool", localException, " fetcher generater call error %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(107640);
        throw localException;
      }
    }
    
    public final void a(d paramd)
    {
      AppMethodBeat.i(107641);
      ac.d("FetcherPool", "reuseFetcher");
      if (paramd == null)
      {
        ac.e("FetcherPool", "Null object can not be reused.");
        AppMethodBeat.o(107641);
        return;
      }
      if (this.uOf == null)
      {
        paramd.release();
        AppMethodBeat.o(107641);
        return;
      }
      if (this.uOf.contains(paramd))
      {
        paramd = new IllegalStateException("fetcher already in pool");
        AppMethodBeat.o(107641);
        throw paramd;
      }
      this.uOf.offer(paramd);
      AppMethodBeat.o(107641);
    }
    
    public final d ded()
    {
      AppMethodBeat.i(107639);
      long l = bs.Gn();
      ac.d("FetcherPool", "acquireFetcher");
      if (this.uOf == null)
      {
        ac.d("FetcherPool", "acquireFetcher no pool directly return null");
        AppMethodBeat.o(107639);
        return null;
      }
      this.aHh.lock();
      ac.d("FetcherPool", "pool.size() %d, size %d, maxFetcherSize %d", new Object[] { Integer.valueOf(this.uOf.size()), Integer.valueOf(this.size), Integer.valueOf(this.uOg) });
      if (this.uOf == null)
      {
        this.aHh.unlock();
        AppMethodBeat.o(107639);
        return null;
      }
      if ((this.uOf.isEmpty()) && (this.size < this.uOg))
      {
        ac.d("FetcherPool", "new fetcher");
        this.size += 1;
        this.aHh.unlock();
      }
      for (d locald = dee();; locald = (d)this.uOf.poll(5L, TimeUnit.SECONDS))
      {
        ac.d("FetcherPool", "time flee, acquireFetcher cost time %d", new Object[] { Long.valueOf(bs.aO(l)) });
        AppMethodBeat.o(107639);
        return locald;
        ac.d("FetcherPool", "waiting fetcher");
        this.aHh.unlock();
      }
    }
    
    /* Error */
    public final void destroy()
    {
      // Byte code:
      //   0: ldc 181
      //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 45	com/tencent/mm/plugin/mmsight/segment/d$a:uOf	Ljava/util/concurrent/LinkedBlockingQueue;
      //   9: ifnonnull +9 -> 18
      //   12: ldc 181
      //   14: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   17: return
      //   18: aload_0
      //   19: getfield 37	com/tencent/mm/plugin/mmsight/segment/d$a:aHh	Ljava/util/concurrent/locks/Lock;
      //   22: invokeinterface 142 1 0
      //   27: aload_0
      //   28: getfield 45	com/tencent/mm/plugin/mmsight/segment/d$a:uOf	Ljava/util/concurrent/LinkedBlockingQueue;
      //   31: ifnonnull +18 -> 49
      //   34: aload_0
      //   35: getfield 37	com/tencent/mm/plugin/mmsight/segment/d$a:aHh	Ljava/util/concurrent/locks/Lock;
      //   38: invokeinterface 155 1 0
      //   43: ldc 181
      //   45: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: return
      //   49: aload_0
      //   50: getfield 45	com/tencent/mm/plugin/mmsight/segment/d$a:uOf	Ljava/util/concurrent/LinkedBlockingQueue;
      //   53: invokevirtual 185	java/util/concurrent/LinkedBlockingQueue:iterator	()Ljava/util/Iterator;
      //   56: astore_1
      //   57: aload_1
      //   58: invokeinterface 190 1 0
      //   63: ifeq +60 -> 123
      //   66: aload_1
      //   67: invokeinterface 193 1 0
      //   72: checkcast 6	com/tencent/mm/plugin/mmsight/segment/d
      //   75: invokeinterface 122 1 0
      //   80: goto -23 -> 57
      //   83: astore_1
      //   84: ldc 79
      //   86: aload_1
      //   87: ldc 195
      //   89: iconst_1
      //   90: anewarray 4	java/lang/Object
      //   93: dup
      //   94: iconst_0
      //   95: aload_1
      //   96: invokevirtual 103	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   99: aastore
      //   100: invokestatic 107	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   103: aload_0
      //   104: aconst_null
      //   105: putfield 45	com/tencent/mm/plugin/mmsight/segment/d$a:uOf	Ljava/util/concurrent/LinkedBlockingQueue;
      //   108: aload_0
      //   109: getfield 37	com/tencent/mm/plugin/mmsight/segment/d$a:aHh	Ljava/util/concurrent/locks/Lock;
      //   112: invokeinterface 155 1 0
      //   117: ldc 181
      //   119: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   122: return
      //   123: aload_0
      //   124: aconst_null
      //   125: putfield 45	com/tencent/mm/plugin/mmsight/segment/d$a:uOf	Ljava/util/concurrent/LinkedBlockingQueue;
      //   128: aload_0
      //   129: getfield 37	com/tencent/mm/plugin/mmsight/segment/d$a:aHh	Ljava/util/concurrent/locks/Lock;
      //   132: invokeinterface 155 1 0
      //   137: ldc 181
      //   139: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   142: return
      //   143: astore_1
      //   144: aload_0
      //   145: aconst_null
      //   146: putfield 45	com/tencent/mm/plugin/mmsight/segment/d$a:uOf	Ljava/util/concurrent/LinkedBlockingQueue;
      //   149: aload_0
      //   150: getfield 37	com/tencent/mm/plugin/mmsight/segment/d$a:aHh	Ljava/util/concurrent/locks/Lock;
      //   153: invokeinterface 155 1 0
      //   158: ldc 181
      //   160: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   163: aload_1
      //   164: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	165	0	this	a
      //   56	11	1	localIterator	java.util.Iterator
      //   83	13	1	localException	Exception
      //   143	21	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   49	57	83	java/lang/Exception
      //   57	80	83	java/lang/Exception
      //   49	57	143	finally
      //   57	80	143	finally
      //   84	103	143	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.d
 * JD-Core Version:    0.7.0.1
 */