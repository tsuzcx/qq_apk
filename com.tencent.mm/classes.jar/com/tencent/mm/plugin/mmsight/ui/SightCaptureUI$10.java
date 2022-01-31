package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.compatible.e.m;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;

final class SightCaptureUI$10
  implements Runnable
{
  SightCaptureUI$10(SightCaptureUI paramSightCaptureUI) {}
  
  public final void run()
  {
    String str = com.tencent.mm.plugin.mmsight.d.Ik(SightCaptureUI.n(this.mqB).bjl());
    if (bk.bl(str)) {
      return;
    }
    str = str + "\n" + String.format("FPS: %s", new Object[] { Float.valueOf(SightCaptureUI.n(this.mqB).bjn()) });
    str = str + "\n" + String.format("TIME_RECODER_2_PLAY: %s", new Object[] { Long.valueOf(com.tencent.mm.plugin.mmsight.d.Im("TIME_RECODER_2_PLAY")) });
    ai.d(new SightCaptureUI.10.1(this, str + "\n" + String.format("CPU: cur %s max:%s", new Object[] { m.yU(), m.yS() })));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.10
 * JD-Core Version:    0.7.0.1
 */