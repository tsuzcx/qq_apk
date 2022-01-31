package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

final class SightCaptureUITest$21
  implements MMSightRecordButton.a
{
  SightCaptureUITest$21(SightCaptureUITest paramSightCaptureUITest) {}
  
  public final void bRP()
  {
    AppMethodBeat.i(150485);
    ab.i("MicroMsg.SightCaptureUIEvent", "onErrorUp: %s", new Object[] { bo.dtY().toString() });
    SightCaptureUITest.n(this.oQq);
    AppMethodBeat.o(150485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.21
 * JD-Core Version:    0.7.0.1
 */