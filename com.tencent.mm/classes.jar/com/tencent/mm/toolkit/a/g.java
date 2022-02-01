package com.tencent.mm.toolkit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.toolkit.a.a.d;

public final class g
  implements d
{
  public final com.tencent.mm.toolkit.a.a.c FEQ;
  private final a FER;
  
  public g()
  {
    AppMethodBeat.i(189815);
    this.FER = new a();
    this.FEQ = new b(this.FER);
    AppMethodBeat.o(189815);
  }
  
  public final int e(c paramc)
  {
    AppMethodBeat.i(189816);
    this.FEQ.b(paramc);
    while (paramc.mState == 2030) {
      try
      {
        Thread.sleep(paramc.eOB().getTimeout());
        this.FEQ.b(paramc);
      }
      catch (InterruptedException localInterruptedException)
      {
        boolean bool = e.DEBUG;
        paramc.mState = 2040;
        a.a(paramc, 1301, localInterruptedException.getLocalizedMessage());
      }
    }
    AppMethodBeat.o(189816);
    return 0;
  }
  
  public final void f(c paramc)
  {
    AppMethodBeat.i(189817);
    if (e.DEBUG)
    {
      new StringBuilder("Request finish, id = ").append(paramc.mId).append(", state = ").append(paramc.mState);
      e.eOC();
    }
    AppMethodBeat.o(189817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.g
 * JD-Core Version:    0.7.0.1
 */