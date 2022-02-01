package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.pluginsdk.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class o$a
{
  public static o.b JSX;
  
  public static d eir()
  {
    AppMethodBeat.i(258251);
    d locald = g.eir();
    AppMethodBeat.o(258251);
    return locald;
  }
  
  public static o.b glW()
  {
    AppMethodBeat.i(30930);
    if (JSX == null)
    {
      Log.w("MicroMsg.IPluginEvent.Factory", "get shake mgr is null, new default");
      JSX = new c();
    }
    o.b localb = JSX;
    AppMethodBeat.o(30930);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.o.a
 * JD-Core Version:    0.7.0.1
 */