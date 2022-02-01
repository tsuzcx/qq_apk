package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Log.LogImp;

public final class s
{
  public static int cyW()
  {
    AppMethodBeat.i(239307);
    if (Log.getImpl() != null)
    {
      int i = Log.getImpl().getLogLevel(0L);
      AppMethodBeat.o(239307);
      return i;
    }
    AppMethodBeat.o(239307);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.s
 * JD-Core Version:    0.7.0.1
 */