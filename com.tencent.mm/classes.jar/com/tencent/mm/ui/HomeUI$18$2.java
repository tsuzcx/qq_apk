package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.sdk.platformtools.Log;

final class HomeUI$18$2
  implements Runnable
{
  HomeUI$18$2(HomeUI.18 param18) {}
  
  public final void run()
  {
    AppMethodBeat.i(272759);
    try
    {
      f.fBA();
      AppMethodBeat.o(272759);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.LauncherUI.HomeUI", "loadFilesToReport error message : " + localThrowable.getMessage());
      AppMethodBeat.o(272759);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.18.2
 * JD-Core Version:    0.7.0.1
 */