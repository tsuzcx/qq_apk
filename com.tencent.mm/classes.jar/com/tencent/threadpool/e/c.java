package com.tencent.threadpool.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public final class c
  implements g
{
  public final void ayG() {}
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(183281);
    h.ahAA.bn(paramRunnable);
    AppMethodBeat.o(183281);
  }
  
  public final String getTag()
  {
    AppMethodBeat.i(183282);
    String str = "IOScheduler@" + hashCode();
    AppMethodBeat.o(183282);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.threadpool.e.c
 * JD-Core Version:    0.7.0.1
 */