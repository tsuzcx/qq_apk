package com.tencent.threadpool.h;

import com.tencent.threadpool.d.a;
import com.tencent.threadpool.d.e;
import com.tencent.threadpool.i.k;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a
  implements d
{
  private final AtomicBoolean ahBU = new AtomicBoolean(false);
  
  protected abstract void ayG();
  
  public final <V> com.tencent.threadpool.i.d<V> f(k<V> paramk)
  {
    if (!this.ahBU.get())
    {
      if (!paramk.isCancelled())
      {
        jZr().h(paramk);
        return paramk;
      }
      com.tencent.threadpool.d.ahAq.w("[BasePool#input] task=%s pool=%s", paramk.getKey() + "#" + paramk.ahCs, new Object[] { getName() });
    }
    for (;;)
    {
      return null;
      com.tencent.threadpool.d.ahAo.h(paramk.getKey(), paramk.ahCs, getName());
    }
  }
  
  public final boolean isShutdown()
  {
    return this.ahBU.get();
  }
  
  protected abstract a jZr();
  
  public final void shutdown()
  {
    if (this.ahBU.compareAndSet(false, true)) {
      ayG();
    }
  }
  
  public static abstract interface a
  {
    public abstract void h(k<?> paramk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.h.a
 * JD-Core Version:    0.7.0.1
 */