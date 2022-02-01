package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class o$a
{
  public static o.b QSc;
  
  public static d eRW()
  {
    AppMethodBeat.i(292749);
    d locald = g.eRW();
    AppMethodBeat.o(292749);
    return locald;
  }
  
  public static o.b hfN()
  {
    AppMethodBeat.i(30930);
    if (QSc == null)
    {
      Log.w("MicroMsg.IPluginEvent.Factory", "get shake mgr is null, new default");
      QSc = new c();
    }
    o.b localb = QSc;
    AppMethodBeat.o(30930);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.o.a
 * JD-Core Version:    0.7.0.1
 */