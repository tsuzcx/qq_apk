package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.a;

final class SightCaptureUITest$22
  implements MMSightRecordButton.c
{
  SightCaptureUITest$22(SightCaptureUITest paramSightCaptureUITest) {}
  
  public final void uR(int paramInt)
  {
    AppMethodBeat.i(150486);
    if (SightCaptureUITest.c(this.oQq) != null) {
      SightCaptureUITest.c(this.oQq).a(true, true, paramInt);
    }
    AppMethodBeat.o(150486);
  }
  
  public final void uS(int paramInt)
  {
    AppMethodBeat.i(150487);
    if (SightCaptureUITest.c(this.oQq) != null) {
      SightCaptureUITest.c(this.oQq).a(false, true, paramInt);
    }
    AppMethodBeat.o(150487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.22
 * JD-Core Version:    0.7.0.1
 */