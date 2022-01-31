package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.a.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class p$a
{
  public static p.b vJB;
  
  public static p.b dkR()
  {
    AppMethodBeat.i(27227);
    if (vJB == null)
    {
      ab.w("MicroMsg.IPluginEvent.Factory", "get shake mgr is null, new default");
      vJB = new c();
    }
    p.b localb = vJB;
    AppMethodBeat.o(27227);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.p.a
 * JD-Core Version:    0.7.0.1
 */