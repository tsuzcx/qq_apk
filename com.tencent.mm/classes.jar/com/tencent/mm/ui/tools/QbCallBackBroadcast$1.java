package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Log;

final class QbCallBackBroadcast$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(39121);
    if (aa.heb() != null)
    {
      Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "foregroundRunnable, onEnterPage");
      aa.heb().bCA();
      aa.heb().Dw(true);
      aa.heb().gcN();
      AppMethodBeat.o(39121);
      return;
    }
    Log.i("MicroMsg.FilesFloatBall.QbCallBackBroadcast", "foregroundRunnable, FilesFloatBallHelper is null");
    AppMethodBeat.o(39121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.tools.QbCallBackBroadcast.1
 * JD-Core Version:    0.7.0.1
 */