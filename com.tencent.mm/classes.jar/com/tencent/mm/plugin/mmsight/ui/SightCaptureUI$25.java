package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.e;

final class SightCaptureUI$25
  implements MMSightRecordButton.c
{
  SightCaptureUI$25(SightCaptureUI paramSightCaptureUI) {}
  
  public final void uR(int paramInt)
  {
    AppMethodBeat.i(55224);
    if (SightCaptureUI.j(this.oQf) != null) {
      SightCaptureUI.j(this.oQf).d(true, true, paramInt);
    }
    AppMethodBeat.o(55224);
  }
  
  public final void uS(int paramInt)
  {
    AppMethodBeat.i(55225);
    if (SightCaptureUI.j(this.oQf) != null) {
      SightCaptureUI.j(this.oQf).d(false, true, paramInt);
    }
    AppMethodBeat.o(55225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.25
 * JD-Core Version:    0.7.0.1
 */