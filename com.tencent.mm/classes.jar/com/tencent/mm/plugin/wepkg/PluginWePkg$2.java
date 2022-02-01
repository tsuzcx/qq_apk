package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

final class PluginWePkg$2
  implements a.a
{
  PluginWePkg$2(PluginWePkg paramPluginWePkg) {}
  
  public final void cBm()
  {
    AppMethodBeat.i(200140);
    try
    {
      d.cCf();
      b.vC();
      AppMethodBeat.o(200140);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WePkg.PluginWePkg", localException, "", new Object[0]);
      h.CyF.idkeyStat(859L, 19L, 1L, false);
      AppMethodBeat.o(200140);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.PluginWePkg.2
 * JD-Core Version:    0.7.0.1
 */