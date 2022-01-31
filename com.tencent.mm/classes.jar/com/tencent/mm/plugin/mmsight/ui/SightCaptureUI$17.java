package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.y;

final class SightCaptureUI$17
  implements Runnable
{
  SightCaptureUI$17(SightCaptureUI paramSightCaptureUI) {}
  
  public final void run()
  {
    if ((SightCaptureUI.e(this.mqB) == 7) && (SightCaptureUI.i(this.mqB) != null))
    {
      y.i("MicroMsg.SightCaptureUI", "showRecoderProgressBar");
      MMSightRecordButton localMMSightRecordButton = SightCaptureUI.i(this.mqB);
      y.i("MicroMsg.MMSightRecordButton", "showProgressBar");
      localMMSightRecordButton.moA.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.17
 * JD-Core Version:    0.7.0.1
 */