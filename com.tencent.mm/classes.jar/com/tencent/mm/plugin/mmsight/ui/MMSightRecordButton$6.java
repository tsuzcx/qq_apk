package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.sdk.platformtools.y;

final class MMSightRecordButton$6
  implements Runnable
{
  MMSightRecordButton$6(MMSightRecordButton paramMMSightRecordButton) {}
  
  public final void run()
  {
    y.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.e(this.moU)) });
    if (MMSightRecordButton.e(this.moU)) {
      MMSightRecordButton.f(this.moU);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.6
 * JD-Core Version:    0.7.0.1
 */