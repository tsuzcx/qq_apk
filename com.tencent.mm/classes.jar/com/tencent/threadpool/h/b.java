package com.tencent.threadpool.h;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.c.c;
import com.tencent.threadpool.d.a;
import com.tencent.threadpool.i.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
  extends a
  implements Handler.Callback
{
  private final a ahBV;
  private final Handler ahBW;
  
  public b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(183349);
    this.ahBW = com.tencent.threadpool.e.d.a("ColdPoolLeader", this);
    this.ahBV = new a(paramInt1, paramInt2);
    AppMethodBeat.o(183349);
  }
  
  protected final void ayG()
  {
    AppMethodBeat.i(183351);
    this.ahBV.shutdown();
    AppMethodBeat.o(183351);
  }
  
  public final String getName()
  {
    return "ColdPool";
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(226910);
    paramMessage = paramMessage.obj;
    if ((paramMessage instanceof k))
    {
      this.ahBV.execute((k)paramMessage);
      AppMethodBeat.o(226910);
      return true;
    }
    AppMethodBeat.o(226910);
    return false;
  }
  
  public final void i(k<?> paramk)
  {
    AppMethodBeat.i(183350);
    this.ahBW.removeCallbacksAndMessages(paramk);
    this.ahBV.remove(paramk);
    AppMethodBeat.o(183350);
  }
  
  protected final a.a jZr()
  {
    return this.ahBV;
  }
  
  public final List<String> jZs()
  {
    AppMethodBeat.i(183352);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.ahBV.getQueue().iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      if ((localRunnable instanceof k)) {
        localLinkedList.add(((k)localRunnable).getKey());
      } else {
        localLinkedList.add(localRunnable.toString());
      }
    }
    AppMethodBeat.o(183352);
    return localLinkedList;
  }
  
  final class a
    extends ThreadPoolExecutor
    implements a.a
  {
    private int ahBX;
    private int ahBY;
    private int hsI;
    
    a(int paramInt1, int paramInt2)
    {
      super(paramInt2, 10L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new ThreadFactory()new RejectedExecutionHandler
      {
        AtomicInteger ahCa;
        
        public final Thread newThread(Runnable paramAnonymousRunnable)
        {
          AppMethodBeat.i(183342);
          paramAnonymousRunnable = c.a("ColdPool#" + this.ahCa.getAndIncrement(), paramAnonymousRunnable, 5);
          AppMethodBeat.o(183342);
          return paramAnonymousRunnable;
        }
      }, new RejectedExecutionHandler()
      {
        public final void rejectedExecution(Runnable paramAnonymousRunnable, ThreadPoolExecutor paramAnonymousThreadPoolExecutor) {}
      });
      AppMethodBeat.i(183345);
      this.ahBY = 1;
      this.hsI = paramInt1;
      this.ahBX = paramInt2;
      AppMethodBeat.o(183345);
    }
    
    protected final void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
    {
      AppMethodBeat.i(183348);
      super.afterExecute(paramRunnable, paramThrowable);
      if ((getQueue().isEmpty()) && (getCorePoolSize() > this.hsI))
      {
        setCorePoolSize(this.hsI);
        this.ahBY = 1;
        com.tencent.threadpool.d.ahAq.w("ColdPool", "reset to corePoolSize(%s)", new Object[] { Integer.valueOf(this.hsI) });
      }
      AppMethodBeat.o(183348);
    }
    
    public final void execute(Runnable paramRunnable)
    {
      AppMethodBeat.i(226903);
      int i = getCorePoolSize();
      if ((getQueue().size() >= this.ahBY * 10) && (i + 1 <= this.ahBX))
      {
        setCorePoolSize(i + 1);
        com.tencent.threadpool.d.ahAq.w("ColdPool", "increment to expand cold pool; queue size=%s currentCoreSize=%s bufferSizeFactor=%s", new Object[] { Integer.valueOf(getQueue().size()), Integer.valueOf(i), Integer.valueOf(this.ahBY) });
        this.ahBY += 1;
      }
      super.execute(paramRunnable);
      AppMethodBeat.o(226903);
    }
    
    public final void h(k<?> paramk)
    {
      AppMethodBeat.i(183347);
      long l = paramk.getDelay(TimeUnit.MILLISECONDS);
      if (l <= 0L)
      {
        execute(paramk);
        AppMethodBeat.o(183347);
        return;
      }
      b.a(b.this).sendMessageAtTime(b.a(b.this).obtainMessage(0, paramk), l + SystemClock.uptimeMillis());
      AppMethodBeat.o(183347);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.h.b
 * JD-Core Version:    0.7.0.1
 */