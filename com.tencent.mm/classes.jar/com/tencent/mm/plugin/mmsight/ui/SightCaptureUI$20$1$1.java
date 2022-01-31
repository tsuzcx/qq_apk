package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.ab;

final class SightCaptureUI$20$1$1
  implements Runnable
{
  SightCaptureUI$20$1$1(SightCaptureUI.20.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(55213);
    ab.i("MicroMsg.SightCaptureUI", "onTextureUpdate");
    if (SightCaptureUI.T(this.oQn.oQm.oQf) == null)
    {
      AppMethodBeat.o(55213);
      return;
    }
    SightCaptureUI.T(this.oQn.oQm.oQf).setAlpha(1.0F);
    SightCaptureUI.g(this.oQn.oQm.oQf, 4);
    SightCaptureUI.G(this.oQn.oQm.oQf);
    AppMethodBeat.o(55213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.20.1.1
 * JD-Core Version:    0.7.0.1
 */