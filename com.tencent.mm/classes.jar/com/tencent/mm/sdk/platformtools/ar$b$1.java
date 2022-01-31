package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

final class ar$b$1
  implements Runnable
{
  ar$b$1(ar.b paramb, ar.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(93419);
    try
    {
      this.yoL.yoS.await();
      AppMethodBeat.o(93419);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      AppMethodBeat.o(93419);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ar.b.1
 * JD-Core Version:    0.7.0.1
 */