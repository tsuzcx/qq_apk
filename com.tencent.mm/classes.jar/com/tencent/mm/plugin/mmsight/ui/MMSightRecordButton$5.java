package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.sdk.platformtools.y;

final class MMSightRecordButton$5
  implements Runnable
{
  MMSightRecordButton$5(MMSightRecordButton paramMMSightRecordButton) {}
  
  public final void run()
  {
    y.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.a(this.moU)), Boolean.valueOf(MMSightRecordButton.b(this.moU)) });
    if (!MMSightRecordButton.a(this.moU))
    {
      MMSightRecordButton.c(this.moU);
      if (MMSightRecordButton.d(this.moU) != null) {
        MMSightRecordButton.d(this.moU).aKP();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.5
 * JD-Core Version:    0.7.0.1
 */