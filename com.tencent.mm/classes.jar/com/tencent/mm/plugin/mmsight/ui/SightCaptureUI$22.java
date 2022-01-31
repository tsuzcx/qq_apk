package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class SightCaptureUI$22
  implements MMSightRecordButton.a
{
  SightCaptureUI$22(SightCaptureUI paramSightCaptureUI) {}
  
  public final void bkb()
  {
    y.i("MicroMsg.TestCaptureUiEvent", "onErrorUp: %s", new Object[] { bk.csb().toString() });
    if (SightCaptureUI.n(this.mqB) != null)
    {
      SightCaptureUI.n(this.mqB).cancel();
      if (SightCaptureUI.j(this.mqB) == 0) {
        SightCaptureUI.o(this.mqB);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.22
 * JD-Core Version:    0.7.0.1
 */