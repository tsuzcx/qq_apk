package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.sdk.platformtools.y;

final class SightCaptureUI$18
  implements Runnable
{
  SightCaptureUI$18(SightCaptureUI paramSightCaptureUI) {}
  
  public final void run()
  {
    if (SightCaptureUI.e(this.mqB) != 4)
    {
      y.e("MicroMsg.SightCaptureUI", "checkPreviewStatusRunnable, not previewing now!!!");
      SightCaptureUI.g(this.mqB, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.18
 * JD-Core Version:    0.7.0.1
 */