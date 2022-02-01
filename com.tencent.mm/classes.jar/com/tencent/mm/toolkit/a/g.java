package com.tencent.mm.toolkit.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.toolkit.a.a.d;

public final class g
  implements d
{
  private final com.tencent.mm.toolkit.a.a.c JlR;
  private final a JlS;
  
  public g()
  {
    AppMethodBeat.i(189013);
    this.JlS = new a();
    this.JlR = new b(this.JlS);
    AppMethodBeat.o(189013);
  }
  
  public final int e(c paramc)
  {
    AppMethodBeat.i(189015);
    this.JlR.b(paramc);
    while (paramc.mState == 2030) {
      try
      {
        Thread.sleep(paramc.fyo().getTimeout());
        this.JlR.b(paramc);
      }
      catch (InterruptedException localInterruptedException)
      {
        boolean bool = e.DEBUG;
        paramc.mState = 2040;
        a.a(paramc, 1301, localInterruptedException.getLocalizedMessage());
      }
    }
    AppMethodBeat.o(189015);
    return 0;
  }
  
  public final void f(c paramc)
  {
    AppMethodBeat.i(189016);
    if (e.DEBUG)
    {
      new StringBuilder("Request finish, id = ").append(paramc.mId).append(", state = ").append(paramc.mState);
      e.fyp();
    }
    AppMethodBeat.o(189016);
  }
  
  public final d jK(Context paramContext)
  {
    AppMethodBeat.i(189014);
    this.JlR.gi(paramContext);
    AppMethodBeat.o(189014);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.g
 * JD-Core Version:    0.7.0.1
 */