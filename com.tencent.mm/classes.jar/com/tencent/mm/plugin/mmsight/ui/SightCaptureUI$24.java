package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class SightCaptureUI$24
  implements MMSightRecordButton.d
{
  SightCaptureUI$24(SightCaptureUI paramSightCaptureUI) {}
  
  public final void aKS()
  {
    y.v("MicroMsg.TestCaptureUiEvent", "onSimpleTap %s", new Object[] { bk.csb().toString() });
    if (SightCaptureUI.n(this.mqB) != null)
    {
      y.i("MicroMsg.SightCaptureUI", "onSimpleTap, mediaRecorder.status: %s", new Object[] { SightCaptureUI.n(this.mqB).bjq() });
      SightCaptureUI.n(this.mqB).cancel();
    }
    com.tencent.mm.plugin.mmsight.d.Il("TIME_RECODER_2_PLAY");
    SightCaptureUI.o(this.mqB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.24
 * JD-Core Version:    0.7.0.1
 */