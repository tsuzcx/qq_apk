package com.tencent.mm.toolkit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.toolkit.a.a.d;

public final class g
  implements d
{
  public final com.tencent.mm.toolkit.a.a.c HdT;
  private final a HdU;
  
  public g()
  {
    AppMethodBeat.i(193036);
    this.HdU = new a();
    this.HdT = new b(this.HdU);
    AppMethodBeat.o(193036);
  }
  
  public final int e(c paramc)
  {
    AppMethodBeat.i(193037);
    this.HdT.b(paramc);
    while (paramc.mState == 2030) {
      try
      {
        Thread.sleep(paramc.fef().getTimeout());
        this.HdT.b(paramc);
      }
      catch (InterruptedException localInterruptedException)
      {
        boolean bool = e.DEBUG;
        paramc.mState = 2040;
        a.a(paramc, 1301, localInterruptedException.getLocalizedMessage());
      }
    }
    AppMethodBeat.o(193037);
    return 0;
  }
  
  public final void f(c paramc)
  {
    AppMethodBeat.i(193038);
    if (e.DEBUG)
    {
      new StringBuilder("Request finish, id = ").append(paramc.mId).append(", state = ").append(paramc.mState);
      e.feg();
    }
    AppMethodBeat.o(193038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.g
 * JD-Core Version:    0.7.0.1
 */