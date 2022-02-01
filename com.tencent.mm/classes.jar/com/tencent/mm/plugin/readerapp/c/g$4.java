package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.sdk.platformtools.bt;

final class g$4
  implements Runnable
{
  g$4(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(102671);
    if (!com.tencent.mm.kernel.g.afw())
    {
      AppMethodBeat.o(102671);
      return;
    }
    bt.z(d.apW(), "ReaderApp_", 604800000L);
    AppMethodBeat.o(102671);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(102672);
    String str = super.toString() + "|onAccountPostReset";
    AppMethodBeat.o(102672);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.g.4
 * JD-Core Version:    0.7.0.1
 */