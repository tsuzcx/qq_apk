package com.tencent.mm.plugin.normsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.Normsg.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
{
  public static boolean pie;
  
  static
  {
    AppMethodBeat.i(10438);
    pie = false;
    long l = System.nanoTime();
    try
    {
      pie = Normsg.b.bXj();
      return;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.NormalMsgSource.DADH", localThrowable, "unexpected exception.", new Object[0]);
      pie = false;
      return;
    }
    finally
    {
      ab.i("MicroMsg.NormalMsgSource.DADH", "CDA, result: %b, time: %d ns", new Object[] { Boolean.valueOf(pie), Long.valueOf(System.nanoTime() - l) });
      AppMethodBeat.o(10438);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.e
 * JD-Core Version:    0.7.0.1
 */