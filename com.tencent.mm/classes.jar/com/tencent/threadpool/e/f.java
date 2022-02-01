package com.tencent.threadpool.e;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.d;
import com.tencent.threadpool.d.a;
import com.tencent.threadpool.d.b;
import com.tencent.threadpool.j.c;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public final class f<E>
  extends e<E>
{
  f() {}
  
  f(E paramE)
  {
    super(paramE);
  }
  
  private g jZo()
  {
    AppMethodBeat.i(183310);
    if ((com.tencent.threadpool.j.a.jZA() == null) && (Looper.myLooper() == null))
    {
      localObject = new RuntimeException(String.format("fail to create DefaultScheduler. Current thread[%s-%s] without a Looper or Serial.", new Object[] { Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()) }));
      AppMethodBeat.o(183310);
      throw ((Throwable)localObject);
    }
    Object localObject = new g()
    {
      private com.tencent.threadpool.d.a ahBB;
      
      public final void ayG()
      {
        AppMethodBeat.i(183305);
        this.ahBB.removeCallbacksAndMessages(null);
        AppMethodBeat.o(183305);
      }
      
      public final void execute(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(183303);
        this.ahBB.post(paramAnonymousRunnable);
        AppMethodBeat.o(183303);
      }
      
      public final String getTag()
      {
        AppMethodBeat.i(183304);
        if ((this.ahBB instanceof c))
        {
          str = this.ahBB.getSerialTag();
          AppMethodBeat.o(183304);
          return str;
        }
        String str = com.tencent.threadpool.j.a.m(this.ahBB.getLooper());
        AppMethodBeat.o(183304);
        return str;
      }
    };
    AppMethodBeat.o(183310);
    return localObject;
  }
  
  public final void begin()
  {
    AppMethodBeat.i(183307);
    Object localObject = this;
    if (!this.vSL.compareAndSet(false, true))
    {
      d.ahAq.w("Pipeline", "this pipeline has begin.", new Object[0]);
      AppMethodBeat.o(183307);
      return;
    }
    while (((e)localObject).ahBw != null) {
      localObject = ((e)localObject).ahBw;
    }
    ((e)localObject).b(((e)localObject).ahBu);
    AppMethodBeat.o(183307);
  }
  
  public final <R> f<R> c(a<E, R> parama)
  {
    AppMethodBeat.i(183306);
    Objects.requireNonNull(parama);
    f localf = new f();
    localf.ahBt = jZm();
    localf.ahBw = this;
    this.ahBx = localf;
    this.ahBu = parama;
    AppMethodBeat.o(183306);
    return localf;
  }
  
  final a<Throwable, ?> jZi()
  {
    for (Object localObject = this; (localObject != null) && (((e)localObject).ahBv == null); localObject = ((e)localObject).ahBx) {}
    if (localObject != null) {
      return ((e)localObject).ahBv;
    }
    return null;
  }
  
  public final E jZk()
  {
    AppMethodBeat.i(183308);
    if (this.ahBs == null)
    {
      localObject = com.tencent.threadpool.j.a.jZA();
      String str;
      if (localObject == null)
      {
        str = com.tencent.threadpool.j.a.m(Looper.myLooper());
        localObject = this;
      }
      while (((e)localObject).ahBw != null) {
        if (((e)localObject).ahBt.getTag().equals(str))
        {
          localObject = new RuntimeException("this pipeline will happen dead lock in future. please to check it. serialTag=".concat(String.valueOf(str)));
          AppMethodBeat.o(183308);
          throw ((Throwable)localObject);
          str = ((com.tencent.threadpool.j.a)localObject).tag;
          localObject = this;
        }
        else
        {
          localObject = ((e)localObject).ahBw;
        }
      }
    }
    begin();
    Object localObject = super.jZk();
    AppMethodBeat.o(183308);
    return localObject;
  }
  
  public final g jZm()
  {
    AppMethodBeat.i(183309);
    if (this.ahBt == null)
    {
      localg = jZo();
      AppMethodBeat.o(183309);
      return localg;
    }
    g localg = this.ahBt;
    AppMethodBeat.o(183309);
    return localg;
  }
  
  public final f<E> jZn()
  {
    this.ahBt = ahBo;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.e.f
 * JD-Core Version:    0.7.0.1
 */