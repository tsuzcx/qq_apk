package com.tencent.tbs.one.impl.common.statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class b$1
  implements ThreadFactory
{
  private final AtomicInteger a;
  
  b$1()
  {
    AppMethodBeat.i(174199);
    this.a = new AtomicInteger(1);
    AppMethodBeat.o(174199);
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(174200);
    paramRunnable = new Thread(paramRunnable, "StatisticExecutor #" + this.a.getAndIncrement());
    AppMethodBeat.o(174200);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.b.1
 * JD-Core Version:    0.7.0.1
 */