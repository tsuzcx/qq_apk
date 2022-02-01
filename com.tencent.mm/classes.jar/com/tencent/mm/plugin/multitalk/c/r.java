package com.tencent.mm.plugin.multitalk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Log.LogImp;

public final class r
{
  public static int dqY()
  {
    AppMethodBeat.i(285163);
    if (Log.getImpl() != null)
    {
      int i = Log.getImpl().getLogLevel(0L);
      AppMethodBeat.o(285163);
      return i;
    }
    AppMethodBeat.o(285163);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.r
 * JD-Core Version:    0.7.0.1
 */