package com.tencent.mm.toolkit.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.toolkit.a.a.d;

public final class g
  implements d
{
  private final com.tencent.mm.toolkit.a.a.c IRj;
  private final a IRk;
  
  public g()
  {
    AppMethodBeat.i(211582);
    this.IRk = new a();
    this.IRj = new b(this.IRk);
    AppMethodBeat.o(211582);
  }
  
  public final int e(c paramc)
  {
    AppMethodBeat.i(211584);
    this.IRj.b(paramc);
    while (paramc.mState == 2030) {
      try
      {
        Thread.sleep(paramc.fun().getTimeout());
        this.IRj.b(paramc);
      }
      catch (InterruptedException localInterruptedException)
      {
        boolean bool = e.DEBUG;
        paramc.mState = 2040;
        a.a(paramc, 1301, localInterruptedException.getLocalizedMessage());
      }
    }
    AppMethodBeat.o(211584);
    return 0;
  }
  
  public final void f(c paramc)
  {
    AppMethodBeat.i(211585);
    if (e.DEBUG)
    {
      new StringBuilder("Request finish, id = ").append(paramc.mId).append(", state = ").append(paramc.mState);
      e.fuo();
    }
    AppMethodBeat.o(211585);
  }
  
  public final d jD(Context paramContext)
  {
    AppMethodBeat.i(211583);
    this.IRj.gc(paramContext);
    AppMethodBeat.o(211583);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.g
 * JD-Core Version:    0.7.0.1
 */