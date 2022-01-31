package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class d$a
{
  Lock kmn = new ReentrantLock();
  LinkedBlockingQueue<d> mlt = new LinkedBlockingQueue(4);
  private final int mlu = 4;
  private Callable<d> mlv;
  private volatile int size = 0;
  
  public d$a(Callable<d> paramCallable)
  {
    this.mlv = paramCallable;
  }
  
  private d bjO()
  {
    if (this.mlv == null) {
      throw new IllegalStateException("fetcher generator can not be null.");
    }
    long l = bk.UZ();
    try
    {
      d locald = (d)this.mlv.call();
      y.d("FetcherPool", "time flee, construct fetcher instance cost %d", new Object[] { Long.valueOf(bk.cp(l)) });
      return locald;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("FetcherPool", localException, " fetcher generater call error %s", new Object[] { localException.getMessage() });
      throw localException;
    }
  }
  
  public final void a(d paramd)
  {
    y.d("FetcherPool", "reuseFetcher");
    if (paramd == null)
    {
      y.e("FetcherPool", "Null object can not be reused.");
      return;
    }
    if (this.mlt == null)
    {
      paramd.release();
      return;
    }
    if (this.mlt.contains(paramd)) {
      throw new IllegalStateException("fetcher already in pool");
    }
    this.mlt.offer(paramd);
  }
  
  public final d bjN()
  {
    long l = bk.UZ();
    y.d("FetcherPool", "acquireFetcher");
    if (this.mlt == null)
    {
      y.d("FetcherPool", "acquireFetcher no pool directly return null");
      return null;
    }
    this.kmn.lock();
    y.d("FetcherPool", "pool.size() %d, size %d, maxFetcherSize %d", new Object[] { Integer.valueOf(this.mlt.size()), Integer.valueOf(this.size), Integer.valueOf(this.mlu) });
    if (this.mlt == null)
    {
      this.kmn.unlock();
      return null;
    }
    if ((this.mlt.isEmpty()) && (this.size < this.mlu))
    {
      y.d("FetcherPool", "new fetcher");
      this.size += 1;
      this.kmn.unlock();
    }
    for (d locald = bjO();; locald = (d)this.mlt.poll(5L, TimeUnit.SECONDS))
    {
      y.d("FetcherPool", "time flee, acquireFetcher cost time %d", new Object[] { Long.valueOf(bk.cp(l)) });
      return locald;
      y.d("FetcherPool", "waiting fetcher");
      this.kmn.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.d.a
 * JD-Core Version:    0.7.0.1
 */