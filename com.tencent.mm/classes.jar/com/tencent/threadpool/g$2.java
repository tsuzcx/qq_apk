package com.tencent.threadpool;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class g$2
  implements Executor
{
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(183141);
    h.ahAA.bm(paramRunnable);
    AppMethodBeat.o(183141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.threadpool.g.2
 * JD-Core Version:    0.7.0.1
 */