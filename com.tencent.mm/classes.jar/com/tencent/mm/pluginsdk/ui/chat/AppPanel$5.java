package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.f.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

final class AppPanel$5
  extends b
{
  AppPanel$5(AppPanel paramAppPanel) {}
  
  public final String getKey()
  {
    return "initAppGrid";
  }
  
  public final void run()
  {
    AppMethodBeat.i(31458);
    Log.e("MicroMsg.AppPanel", "initAppGrid ANR!");
    h.CyF.n(999L, 2L, 1L);
    AppMethodBeat.o(31458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel.5
 * JD-Core Version:    0.7.0.1
 */