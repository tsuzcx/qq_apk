package com.tencent.tbs.one.impl.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public final class e
  extends d
{
  private AtomicInteger b;
  private Executor c;
  private boolean d;
  private List<c> e;
  
  public e(Executor paramExecutor)
  {
    AppMethodBeat.i(173938);
    this.b = new AtomicInteger();
    this.e = new ArrayList();
    this.c = paramExecutor;
    AppMethodBeat.o(173938);
  }
  
  public final void a()
  {
    AppMethodBeat.i(173940);
    this.b.incrementAndGet();
    AppMethodBeat.o(173940);
  }
  
  public final void a(c paramc)
  {
    int i = 0;
    AppMethodBeat.i(173939);
    paramc.b = this;
    this.d = true;
    paramc.a();
    this.d = false;
    paramc = (c[])this.e.toArray(new c[0]);
    this.e.clear();
    int j = paramc.length;
    while (i < j)
    {
      Runnable localRunnable = paramc[i];
      this.c.execute(localRunnable);
      i += 1;
    }
    AppMethodBeat.o(173939);
  }
  
  public final void b()
  {
    AppMethodBeat.i(173942);
    if ((this.b.decrementAndGet() <= 0) && (this.a != null)) {
      this.a.a();
    }
    AppMethodBeat.o(173942);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(173941);
    if (this.d)
    {
      this.e.add(paramc);
      AppMethodBeat.o(173941);
      return;
    }
    this.c.execute(paramc);
    AppMethodBeat.o(173941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.a.e
 * JD-Core Version:    0.7.0.1
 */