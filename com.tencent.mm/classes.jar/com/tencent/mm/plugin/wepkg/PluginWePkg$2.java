package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;

final class PluginWePkg$2
  implements a.a
{
  PluginWePkg$2(PluginWePkg paramPluginWePkg) {}
  
  public final void ccc()
  {
    AppMethodBeat.i(214440);
    try
    {
      c.cda();
      ad.i("MicroMsg.GameJsServerCommLibPkg", "load");
      AppMethodBeat.o(214440);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.WePkg.PluginWePkg", localException, "", new Object[0]);
      g.yhR.idkeyStat(859L, 19L, 1L, false);
      AppMethodBeat.o(214440);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.PluginWePkg.2
 * JD-Core Version:    0.7.0.1
 */