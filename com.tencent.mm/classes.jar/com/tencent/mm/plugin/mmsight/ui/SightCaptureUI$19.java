package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SightCaptureUI$19
  implements Runnable
{
  SightCaptureUI$19(SightCaptureUI paramSightCaptureUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(55212);
    if (SightCaptureUI.g(this.oQf) != 4)
    {
      ab.e("MicroMsg.SightCaptureUI", "checkPreviewStatusRunnable, not previewing now!!!");
      SightCaptureUI.g(this.oQf, 9);
    }
    AppMethodBeat.o(55212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.19
 * JD-Core Version:    0.7.0.1
 */