package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class AppPanel$3
  implements Runnable
{
  AppPanel$3(AppPanel paramAppPanel) {}
  
  public final void run()
  {
    AppMethodBeat.i(27743);
    ab.e("MicroMsg.AppPanel", "initAppGrid ANR!");
    h.qsU.j(999L, 2L, 1L);
    AppMethodBeat.o(27743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel.3
 * JD-Core Version:    0.7.0.1
 */