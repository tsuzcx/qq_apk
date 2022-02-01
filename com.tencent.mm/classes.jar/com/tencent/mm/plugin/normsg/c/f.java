package com.tencent.mm.plugin.normsg.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.sdk.platformtools.ae;

public final class f
{
  public static boolean wKI;
  
  static
  {
    AppMethodBeat.i(149091);
    wKI = false;
    long l = System.nanoTime();
    try
    {
      wKI = c.p.ag();
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.NormalMsgSource.DADH", localThrowable, "unexpected exception.", new Object[0]);
      wKI = false;
      return;
    }
    finally
    {
      ae.i("MicroMsg.NormalMsgSource.DADH", "CDA, result: %b, time: %d ns", new Object[] { Boolean.valueOf(wKI), Long.valueOf(System.nanoTime() - l) });
      AppMethodBeat.o(149091);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.f
 * JD-Core Version:    0.7.0.1
 */