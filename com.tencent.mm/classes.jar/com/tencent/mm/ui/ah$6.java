package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

final class ah$6
  implements Runnable
{
  ah$6(ah paramah) {}
  
  public final void run()
  {
    AppMethodBeat.i(33499);
    ah.a(this.adHs, true);
    MMHandlerThread.removeRunnable(ah.d(this.adHs));
    MMHandlerThread.postToMainThread(ah.d(this.adHs));
    AppMethodBeat.o(33499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.ah.6
 * JD-Core Version:    0.7.0.1
 */