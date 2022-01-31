package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.y;

final class SightCaptureUI$19$1$1
  implements Runnable
{
  SightCaptureUI$19$1$1(SightCaptureUI.19.1 param1) {}
  
  public final void run()
  {
    y.i("MicroMsg.SightCaptureUI", "onTextureUpdate");
    if (SightCaptureUI.S(this.mqJ.mqI.mqB) == null) {
      return;
    }
    SightCaptureUI.S(this.mqJ.mqI.mqB).setAlpha(1.0F);
    SightCaptureUI.g(this.mqJ.mqI.mqB, 4);
    SightCaptureUI.F(this.mqJ.mqI.mqB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.19.1.1
 * JD-Core Version:    0.7.0.1
 */