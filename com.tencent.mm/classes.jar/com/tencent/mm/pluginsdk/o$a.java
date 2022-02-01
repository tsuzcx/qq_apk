package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.a.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class o$a
{
  public static o.b EJA;
  
  public static o.b eYW()
  {
    AppMethodBeat.i(30930);
    if (EJA == null)
    {
      ad.w("MicroMsg.IPluginEvent.Factory", "get shake mgr is null, new default");
      EJA = new c();
    }
    o.b localb = EJA;
    AppMethodBeat.o(30930);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.o.a
 * JD-Core Version:    0.7.0.1
 */