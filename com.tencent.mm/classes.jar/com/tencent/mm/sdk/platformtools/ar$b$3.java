package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ar$b$3
  implements Runnable
{
  ar$b$3(ar.b paramb, ar.c paramc, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(93421);
    synchronized (ar.f(this.yoM.yoG))
    {
      ar.b.a(this.yoM, this.yoL);
    }
    synchronized (this.yoM.yoG)
    {
      ar.g(this.yoM.yoG);
      if (this.yoO != null) {
        this.yoO.run();
      }
      AppMethodBeat.o(93421);
      return;
      localObject2 = finally;
      AppMethodBeat.o(93421);
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ar.b.3
 * JD-Core Version:    0.7.0.1
 */