package com.tencent.mm.plugin.normsg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
{
  public static boolean MvA;
  
  static
  {
    AppMethodBeat.i(149091);
    MvA = false;
    long l = System.nanoTime();
    try
    {
      MvA = c.p.ag();
      Log.i("MicroMsg.NormalMsgSource.DADH", "CDA, result: %b, time: %d ns", new Object[] { Boolean.valueOf(MvA), Long.valueOf(System.nanoTime() - l) });
      AppMethodBeat.o(149091);
      return;
    }
    finally
    {
      try
      {
        Log.printErrStackTrace("MicroMsg.NormalMsgSource.DADH", localThrowable, "unexpected exception.", new Object[0]);
        MvA = false;
        return;
      }
      finally
      {
        Log.i("MicroMsg.NormalMsgSource.DADH", "CDA, result: %b, time: %d ns", new Object[] { Boolean.valueOf(MvA), Long.valueOf(System.nanoTime() - l) });
        AppMethodBeat.o(149091);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.f
 * JD-Core Version:    0.7.0.1
 */