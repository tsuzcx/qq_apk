package com.tencent.mm.toolkit.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.toolkit.a.a.d;

public final class g
  implements d
{
  private final com.tencent.mm.toolkit.a.a.c adtf;
  private final a adtg;
  
  public g()
  {
    AppMethodBeat.i(231996);
    this.adtg = new a();
    this.adtf = new b(this.adtg);
    AppMethodBeat.o(231996);
  }
  
  public final int e(c paramc)
  {
    AppMethodBeat.i(232011);
    this.adtf.b(paramc);
    while (paramc.mState == 2030) {
      try
      {
        Thread.sleep(paramc.jhc().getTimeout());
        this.adtf.b(paramc);
      }
      catch (InterruptedException localInterruptedException)
      {
        boolean bool = e.DEBUG;
        paramc.mState = 2040;
        a.a(paramc, 1301, localInterruptedException.getLocalizedMessage());
      }
    }
    AppMethodBeat.o(232011);
    return 0;
  }
  
  public final void f(c paramc)
  {
    AppMethodBeat.i(232017);
    if (e.DEBUG)
    {
      new StringBuilder("Request finish, id = ").append(paramc.mId).append(", state = ").append(paramc.mState);
      e.jhd();
    }
    AppMethodBeat.o(232017);
  }
  
  public final d mI(Context paramContext)
  {
    AppMethodBeat.i(232001);
    this.adtf.jt(paramContext);
    AppMethodBeat.o(232001);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.g
 * JD-Core Version:    0.7.0.1
 */