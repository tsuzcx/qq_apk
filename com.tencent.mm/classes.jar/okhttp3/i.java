package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.b.d;
import okhttp3.internal.b.g.a;
import okhttp3.internal.g.g;

public final class i
{
  static final Executor executor;
  final int ajMf;
  private final long ajMg;
  final Runnable ajMh;
  final Deque<okhttp3.internal.b.c> ajMi;
  final d ajMj;
  boolean ajMk;
  
  static
  {
    AppMethodBeat.i(186617);
    if (!i.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      executor = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.internal.c.threadFactory("OkHttp ConnectionPool", true));
      AppMethodBeat.o(186617);
      return;
    }
  }
  
  public i()
  {
    this(TimeUnit.MINUTES);
  }
  
  private i(TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(186613);
    this.ajMh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186540);
        long l1;
        do
        {
          l1 = i.this.BX(System.nanoTime());
          if (l1 == -1L)
          {
            AppMethodBeat.o(186540);
            return;
          }
        } while (l1 <= 0L);
        long l2 = l1 / 1000000L;
        try
        {
          label67:
          synchronized (i.this)
          {
            i.this.wait(l2, (int)(l1 - l2 * 1000000L));
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          break label67;
        }
      }
    };
    this.ajMi = new ArrayDeque();
    this.ajMj = new d();
    this.ajMf = 5;
    this.ajMg = paramTimeUnit.toNanos(5L);
    if (5L <= 0L)
    {
      paramTimeUnit = new IllegalArgumentException("keepAliveDuration <= 0: 5");
      AppMethodBeat.o(186613);
      throw paramTimeUnit;
    }
    AppMethodBeat.o(186613);
  }
  
  final long BX(long paramLong)
  {
    AppMethodBeat.i(186644);
    Object localObject1 = null;
    long l1 = -9223372036854775808L;
    for (;;)
    {
      int j;
      int i;
      int k;
      try
      {
        Iterator localIterator = this.ajMi.iterator();
        j = 0;
        i = 0;
        if (localIterator.hasNext())
        {
          okhttp3.internal.b.c localc = (okhttp3.internal.b.c)localIterator.next();
          List localList = localc.ajPq;
          k = 0;
          if (k < localList.size())
          {
            Object localObject3 = (Reference)localList.get(k);
            if (((Reference)localObject3).get() != null)
            {
              k += 1;
              continue;
            }
            localObject3 = (g.a)localObject3;
            String str = "A connection to " + localc.ajPk.ajNZ.ajIN + " was leaked. Did you forget to close a response body?";
            g.kIq().Z(str, ((g.a)localObject3).ajPC);
            localList.remove(k);
            localc.ajPo = true;
            if (!localList.isEmpty()) {
              continue;
            }
            localc.ajPr = (paramLong - this.ajMg);
            k = 0;
            break label361;
          }
          k = localList.size();
          break label361;
          long l2 = paramLong - localc.ajPr;
          if (l2 > l1)
          {
            localObject1 = localc;
            l1 = l2;
            break label373;
          }
        }
        else
        {
          if ((l1 >= this.ajMg) || (j > this.ajMf))
          {
            this.ajMi.remove(localObject1);
            okhttp3.internal.c.closeQuietly(localObject1.cBb);
            AppMethodBeat.o(186644);
            return 0L;
          }
          if (j > 0)
          {
            paramLong = this.ajMg;
            return paramLong - l1;
          }
          if (i > 0)
          {
            paramLong = this.ajMg;
            return paramLong;
          }
          this.ajMk = false;
          return -1L;
        }
      }
      finally
      {
        AppMethodBeat.o(186644);
      }
      label361:
      if (k > 0)
      {
        i += 1;
        continue;
        label373:
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.i
 * JD-Core Version:    0.7.0.1
 */