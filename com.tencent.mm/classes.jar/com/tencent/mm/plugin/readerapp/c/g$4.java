package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.sdk.platformtools.bo;

final class g$4
  implements Runnable
{
  g$4(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(76767);
    if (!com.tencent.mm.kernel.g.RG())
    {
      AppMethodBeat.o(76767);
      return;
    }
    bo.q(c.YK(), "ReaderApp_", 604800000L);
    AppMethodBeat.o(76767);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(76768);
    String str = super.toString() + "|onAccountPostReset";
    AppMethodBeat.o(76768);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.g.4
 * JD-Core Version:    0.7.0.1
 */