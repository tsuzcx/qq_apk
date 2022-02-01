package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.a.c;
import com.tencent.mm.sdk.platformtools.ae;

public final class o$a
{
  public static o.b FbY;
  
  public static o.b fcK()
  {
    AppMethodBeat.i(30930);
    if (FbY == null)
    {
      ae.w("MicroMsg.IPluginEvent.Factory", "get shake mgr is null, new default");
      FbY = new c();
    }
    o.b localb = FbY;
    AppMethodBeat.o(30930);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.o.a
 * JD-Core Version:    0.7.0.1
 */