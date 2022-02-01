package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class o$a
{
  public static o.b XNT;
  
  public static o.b iGH()
  {
    AppMethodBeat.i(30930);
    if (XNT == null)
    {
      Log.w("MicroMsg.IPluginEvent.Factory", "get shake mgr is null, new default");
      XNT = new c();
    }
    o.b localb = XNT;
    AppMethodBeat.o(30930);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.o.a
 * JD-Core Version:    0.7.0.1
 */