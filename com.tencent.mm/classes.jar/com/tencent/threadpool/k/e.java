package com.tencent.threadpool.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.concurrent.Future;

public enum e
  implements a
{
  static
  {
    AppMethodBeat.i(226856);
    ahCT = new e("INSTANCE");
    ahCU = new e[] { ahCT };
    AppMethodBeat.o(226856);
  }
  
  private e() {}
  
  public final Future<?> bq(Runnable paramRunnable)
  {
    AppMethodBeat.i(226859);
    paramRunnable = h.ahAA.bm(paramRunnable);
    AppMethodBeat.o(226859);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.threadpool.k.e
 * JD-Core Version:    0.7.0.1
 */