package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.ab;

final class SightCaptureUITest$16$1$1
  implements Runnable
{
  SightCaptureUITest$16$1$1(SightCaptureUITest.16.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(150470);
    ab.i("MicroMsg.SightCaptureUI", "onTextureUpdate");
    if (SightCaptureUITest.I(this.oQw.oQv.oQq) == null)
    {
      AppMethodBeat.o(150470);
      return;
    }
    SightCaptureUITest.I(this.oQw.oQv.oQq).setAlpha(1.0F);
    SightCaptureUITest.a(this.oQw.oQv.oQq, 4);
    SightCaptureUITest.y(this.oQw.oQv.oQq);
    SightCaptureUITest.N(this.oQw.oQv.oQq);
    AppMethodBeat.o(150470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.16.1.1
 * JD-Core Version:    0.7.0.1
 */