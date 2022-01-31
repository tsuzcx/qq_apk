package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.PriorityBlockingQueue;

final class n$c
  extends PriorityBlockingQueue<Runnable>
{
  public n$c()
  {
    super(11, new n.c.1());
    AppMethodBeat.i(79593);
    AppMethodBeat.o(79593);
  }
  
  private static String Z(Runnable paramRunnable)
  {
    AppMethodBeat.i(79594);
    if ((paramRunnable instanceof f.c))
    {
      if ((((f.c)paramRunnable).vOi instanceof l))
      {
        paramRunnable = String.format("priority = %d, urlKey = %s", new Object[] { Integer.valueOf(((l)((f.c)paramRunnable).vOi).priority), ((f.c)paramRunnable).vOi.dlZ() });
        AppMethodBeat.o(79594);
        return paramRunnable;
      }
      paramRunnable = String.format("unknown request = %s", new Object[] { ((f.c)paramRunnable).vOi });
      AppMethodBeat.o(79594);
      return paramRunnable;
    }
    paramRunnable = String.format("unknown runnable = %s", new Object[] { paramRunnable });
    AppMethodBeat.o(79594);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.n.c
 * JD-Core Version:    0.7.0.1
 */