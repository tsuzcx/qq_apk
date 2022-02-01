package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.a.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class n$a
{
  public static n.b BNu;
  
  public static n.b euP()
  {
    AppMethodBeat.i(30930);
    if (BNu == null)
    {
      ad.w("MicroMsg.IPluginEvent.Factory", "get shake mgr is null, new default");
      BNu = new c();
    }
    n.b localb = BNu;
    AppMethodBeat.o(30930);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.n.a
 * JD-Core Version:    0.7.0.1
 */