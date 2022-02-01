package com.tencent.mm.plugin.normsg.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
{
  public static boolean wuX;
  
  static
  {
    AppMethodBeat.i(149091);
    wuX = false;
    long l = System.nanoTime();
    try
    {
      wuX = c.p.ag();
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("MicroMsg.NormalMsgSource.DADH", localThrowable, "unexpected exception.", new Object[0]);
      wuX = false;
      return;
    }
    finally
    {
      ad.i("MicroMsg.NormalMsgSource.DADH", "CDA, result: %b, time: %d ns", new Object[] { Boolean.valueOf(wuX), Long.valueOf(System.nanoTime() - l) });
      AppMethodBeat.o(149091);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.e
 * JD-Core Version:    0.7.0.1
 */