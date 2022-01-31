package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

final class SightCaptureUI$24
  implements MMSightRecordButton.a
{
  SightCaptureUI$24(SightCaptureUI paramSightCaptureUI) {}
  
  public final void bRP()
  {
    AppMethodBeat.i(55223);
    ab.i("MicroMsg.TestCaptureUiEvent", "onErrorUp: %s", new Object[] { bo.dtY().toString() });
    if (SightCaptureUI.p(this.oQf) != null)
    {
      SightCaptureUI.p(this.oQf).cancel();
      if (SightCaptureUI.l(this.oQf) == 0) {
        SightCaptureUI.q(this.oQf);
      }
    }
    AppMethodBeat.o(55223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.24
 * JD-Core Version:    0.7.0.1
 */