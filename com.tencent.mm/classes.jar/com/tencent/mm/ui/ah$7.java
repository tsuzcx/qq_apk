package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

final class ah$7
  implements Runnable
{
  ah$7(ah paramah) {}
  
  public final void run()
  {
    AppMethodBeat.i(33500);
    ah.a(this.adHs, true);
    MMHandlerThread.removeRunnable(ah.d(this.adHs));
    MMHandlerThread.postToMainThreadDelayed(ah.d(this.adHs), 300L);
    AppMethodBeat.o(33500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.ah.7
 * JD-Core Version:    0.7.0.1
 */