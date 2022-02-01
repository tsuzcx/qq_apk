package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.a.c;
import com.tencent.mm.sdk.platformtools.ac;

public final class n$a
{
  public static n.b DfE;
  
  public static n.b eKi()
  {
    AppMethodBeat.i(30930);
    if (DfE == null)
    {
      ac.w("MicroMsg.IPluginEvent.Factory", "get shake mgr is null, new default");
      DfE = new c();
    }
    n.b localb = DfE;
    AppMethodBeat.o(30930);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.n.a
 * JD-Core Version:    0.7.0.1
 */