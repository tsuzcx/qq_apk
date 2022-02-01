package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ae.a;

public final class s
{
  public static int cbh()
  {
    AppMethodBeat.i(190713);
    if (ae.fon() != null)
    {
      int i = ae.fon().getLogLevel(0L);
      AppMethodBeat.o(190713);
      return i;
    }
    AppMethodBeat.o(190713);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.s
 * JD-Core Version:    0.7.0.1
 */