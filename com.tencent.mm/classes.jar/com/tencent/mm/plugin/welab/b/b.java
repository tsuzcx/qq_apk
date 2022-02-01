package com.tencent.mm.plugin.welab.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.List;

public final class b
  implements a
{
  public final void g(final List<c> paramList, final List<d> paramList1, final List<Integer> paramList2)
  {
    AppMethodBeat.i(146248);
    h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146247);
        b.h(paramList, paramList1, paramList2);
        AppMethodBeat.o(146247);
      }
    }, "cross_welab");
    AppMethodBeat.o(146248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.b.b
 * JD-Core Version:    0.7.0.1
 */