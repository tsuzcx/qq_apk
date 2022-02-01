package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class MMSightRecordButton$6
  implements Runnable
{
  MMSightRecordButton$6(MMSightRecordButton paramMMSightRecordButton) {}
  
  public final void run()
  {
    AppMethodBeat.i(94536);
    Log.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.f(this.Lch)) });
    if (MMSightRecordButton.f(this.Lch)) {
      MMSightRecordButton.g(this.Lch);
    }
    AppMethodBeat.o(94536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.6
 * JD-Core Version:    0.7.0.1
 */