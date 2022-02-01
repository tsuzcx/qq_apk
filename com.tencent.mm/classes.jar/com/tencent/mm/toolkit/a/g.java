package com.tencent.mm.toolkit.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.toolkit.a.a.d;

public final class g
  implements d
{
  private final com.tencent.mm.toolkit.a.a.c VPa;
  private final a VPb;
  
  public g()
  {
    AppMethodBeat.i(220817);
    this.VPb = new a();
    this.VPa = new b(this.VPb);
    AppMethodBeat.o(220817);
  }
  
  public final int e(c paramc)
  {
    AppMethodBeat.i(220821);
    this.VPa.b(paramc);
    while (paramc.mState == 2030) {
      try
      {
        Thread.sleep(paramc.hEP().getTimeout());
        this.VPa.b(paramc);
      }
      catch (InterruptedException localInterruptedException)
      {
        boolean bool = e.DEBUG;
        paramc.mState = 2040;
        a.a(paramc, 1301, localInterruptedException.getLocalizedMessage());
      }
    }
    AppMethodBeat.o(220821);
    return 0;
  }
  
  public final void f(c paramc)
  {
    AppMethodBeat.i(220822);
    if (e.DEBUG)
    {
      new StringBuilder("Request finish, id = ").append(paramc.mId).append(", state = ").append(paramc.mState);
      e.hEQ();
    }
    AppMethodBeat.o(220822);
  }
  
  public final d kF(Context paramContext)
  {
    AppMethodBeat.i(220818);
    this.VPa.fB(paramContext);
    AppMethodBeat.o(220818);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.g
 * JD-Core Version:    0.7.0.1
 */