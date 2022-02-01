package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;

final class PluginWePkg$2
  implements a.a
{
  PluginWePkg$2(PluginWePkg paramPluginWePkg) {}
  
  public final void cdr()
  {
    AppMethodBeat.i(209368);
    try
    {
      c.cep();
      ae.i("MicroMsg.GameJsServerCommLibPkg", "load");
      AppMethodBeat.o(209368);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.WePkg.PluginWePkg", localException, "", new Object[0]);
      g.yxI.idkeyStat(859L, 19L, 1L, false);
      AppMethodBeat.o(209368);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.PluginWePkg.2
 * JD-Core Version:    0.7.0.1
 */