package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

final class SightCaptureUI$26
  implements MMSightRecordButton.d
{
  SightCaptureUI$26(SightCaptureUI paramSightCaptureUI) {}
  
  public final void bpa()
  {
    AppMethodBeat.i(55226);
    ab.v("MicroMsg.TestCaptureUiEvent", "onSimpleTap %s", new Object[] { bo.dtY().toString() });
    if (SightCaptureUI.p(this.oQf) != null)
    {
      ab.i("MicroMsg.SightCaptureUI", "onSimpleTap, mediaRecorder.status: %s", new Object[] { SightCaptureUI.p(this.oQf).Xw() });
      SightCaptureUI.p(this.oQf).cancel();
    }
    com.tencent.mm.plugin.mmsight.d.TZ("TIME_RECODER_2_PLAY");
    SightCaptureUI.q(this.oQf);
    AppMethodBeat.o(55226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.26
 * JD-Core Version:    0.7.0.1
 */