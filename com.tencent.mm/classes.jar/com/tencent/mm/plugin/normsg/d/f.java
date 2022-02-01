package com.tencent.mm.plugin.normsg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
{
  public static boolean Gzs;
  
  static
  {
    AppMethodBeat.i(149091);
    Gzs = false;
    long l = System.nanoTime();
    try
    {
      Gzs = c.p.ag();
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.NormalMsgSource.DADH", localThrowable, "unexpected exception.", new Object[0]);
      Gzs = false;
      return;
    }
    finally
    {
      Log.i("MicroMsg.NormalMsgSource.DADH", "CDA, result: %b, time: %d ns", new Object[] { Boolean.valueOf(Gzs), Long.valueOf(System.nanoTime() - l) });
      AppMethodBeat.o(149091);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.f
 * JD-Core Version:    0.7.0.1
 */