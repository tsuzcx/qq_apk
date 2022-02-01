package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

final class ah$8
  implements Runnable
{
  ah$8(ah paramah) {}
  
  public final void run()
  {
    AppMethodBeat.i(33501);
    if (ah.g(this.adHs))
    {
      Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "remove setTagRunnable");
      MMHandlerThread.removeRunnable(ah.d(this.adHs));
    }
    AppMethodBeat.o(33501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.ah.8
 * JD-Core Version:    0.7.0.1
 */