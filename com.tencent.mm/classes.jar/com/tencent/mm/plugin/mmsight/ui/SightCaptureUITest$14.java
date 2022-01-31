package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SightCaptureUITest$14
  implements Runnable
{
  SightCaptureUITest$14(SightCaptureUITest paramSightCaptureUITest) {}
  
  public final void run()
  {
    AppMethodBeat.i(150468);
    if ((SightCaptureUITest.e(this.oQq) == 7) && (SightCaptureUITest.h(this.oQq) != null))
    {
      ab.i("MicroMsg.SightCaptureUI", "showRecoderProgressBar");
      SightCaptureUITest.h(this.oQq).bRN();
    }
    AppMethodBeat.o(150468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.14
 * JD-Core Version:    0.7.0.1
 */