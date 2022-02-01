package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.e;
import com.tencent.mm.sdk.platformtools.ae;

final class HomeUI$16$2
  implements Runnable
{
  HomeUI$16$2(HomeUI.16 param16) {}
  
  public final void run()
  {
    AppMethodBeat.i(186959);
    try
    {
      e.dNF();
      AppMethodBeat.o(186959);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.LauncherUI.HomeUI", "loadFilesToReport error message : " + localThrowable.getMessage());
      AppMethodBeat.o(186959);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.16.2
 * JD-Core Version:    0.7.0.1
 */