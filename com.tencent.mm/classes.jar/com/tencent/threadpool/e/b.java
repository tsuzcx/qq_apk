package com.tencent.threadpool.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public final class b
  implements g
{
  public final void ayG() {}
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(183279);
    h.ahAA.bo(paramRunnable);
    AppMethodBeat.o(183279);
  }
  
  public final String getTag()
  {
    AppMethodBeat.i(183280);
    String str = "ComputeScheduler@" + hashCode();
    AppMethodBeat.o(183280);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.threadpool.e.b
 * JD-Core Version:    0.7.0.1
 */