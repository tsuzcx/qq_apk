package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.d.c;
import rx.internal.c.j;
import rx.internal.util.unsafe.MpmcArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public abstract class d<T>
  implements j
{
  private final long akdv = 67L;
  private final AtomicReference<Future<?>> akdw = new AtomicReference();
  Queue<T> eJb;
  final int maxSize = 0;
  final int oQY = 0;
  
  public d()
  {
    this((byte)0);
  }
  
  private d(byte paramByte)
  {
    if (UnsafeAccess.isUnsafeAvailable()) {}
    for (this.eJb = new MpmcArrayQueue(Math.max(this.maxSize, 1024));; this.eJb = new ConcurrentLinkedQueue())
    {
      start();
      return;
    }
  }
  
  protected abstract T kKx();
  
  public final void shutdown()
  {
    Future localFuture = (Future)this.akdw.getAndSet(null);
    if (localFuture != null) {
      localFuture.cancel(false);
    }
  }
  
  public final void start()
  {
    for (;;)
    {
      if (this.akdw.get() != null) {
        label10:
        return;
      }
      Object localObject = rx.internal.c.d.kR();
      try
      {
        localObject = ((ScheduledExecutorService)localObject).scheduleAtFixedRate(new Runnable()
        {
          public final void run()
          {
            int j = 0;
            int i = 0;
            AppMethodBeat.i(90198);
            int k = d.this.eJb.size();
            if (k < d.this.oQY)
            {
              j = d.this.maxSize;
              while (i < j - k)
              {
                d.this.eJb.add(d.this.kKx());
                i += 1;
              }
              AppMethodBeat.o(90198);
              return;
            }
            if (k > d.this.maxSize)
            {
              int m = d.this.maxSize;
              i = j;
              while (i < k - m)
              {
                d.this.eJb.poll();
                i += 1;
              }
            }
            AppMethodBeat.o(90198);
          }
        }, this.akdv, this.akdv, TimeUnit.SECONDS);
        if (this.akdw.compareAndSet(null, localObject)) {
          break label10;
        }
        ((Future)localObject).cancel(false);
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        c.l(localRejectedExecutionException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.util.d
 * JD-Core Version:    0.7.0.1
 */