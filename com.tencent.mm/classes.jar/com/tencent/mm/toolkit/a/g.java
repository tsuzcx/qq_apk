package com.tencent.mm.toolkit.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.toolkit.a.a.d;

public final class g
  implements d
{
  private final com.tencent.mm.toolkit.a.a.c OvK;
  private final a OvL;
  
  public g()
  {
    AppMethodBeat.i(196825);
    this.OvL = new a();
    this.OvK = new b(this.OvL);
    AppMethodBeat.o(196825);
  }
  
  public final int e(c paramc)
  {
    AppMethodBeat.i(196827);
    this.OvK.b(paramc);
    while (paramc.mState == 2030) {
      try
      {
        Thread.sleep(paramc.gGc().getTimeout());
        this.OvK.b(paramc);
      }
      catch (InterruptedException localInterruptedException)
      {
        boolean bool = e.DEBUG;
        paramc.mState = 2040;
        a.a(paramc, 1301, localInterruptedException.getLocalizedMessage());
      }
    }
    AppMethodBeat.o(196827);
    return 0;
  }
  
  public final void f(c paramc)
  {
    AppMethodBeat.i(196828);
    if (e.DEBUG)
    {
      new StringBuilder("Request finish, id = ").append(paramc.mId).append(", state = ").append(paramc.mState);
      e.gGd();
    }
    AppMethodBeat.o(196828);
  }
  
  public final d jG(Context paramContext)
  {
    AppMethodBeat.i(196826);
    this.OvK.gS(paramContext);
    AppMethodBeat.o(196826);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.g
 * JD-Core Version:    0.7.0.1
 */