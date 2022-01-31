package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SightCaptureUITest$15
  implements Runnable
{
  SightCaptureUITest$15(SightCaptureUITest paramSightCaptureUITest) {}
  
  public final void run()
  {
    AppMethodBeat.i(150469);
    if (SightCaptureUITest.e(this.oQq) != 4)
    {
      ab.e("MicroMsg.SightCaptureUI", "checkPreviewStatusRunnable, not previewing now!!!");
      SightCaptureUITest.a(this.oQq, 9);
    }
    AppMethodBeat.o(150469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.15
 * JD-Core Version:    0.7.0.1
 */