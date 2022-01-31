package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

final class SightCaptureUI$11
  implements Runnable
{
  SightCaptureUI$11(SightCaptureUI paramSightCaptureUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(55197);
    String str = com.tencent.mm.plugin.mmsight.d.TX(SightCaptureUI.p(this.oQf).getFilePath());
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(55197);
      return;
    }
    str = str + "\n" + String.format("FPS: %s", new Object[] { Float.valueOf(SightCaptureUI.p(this.oQf).Xv()) });
    str = str + "\n" + String.format("TIME_RECODER_2_PLAY: %s", new Object[] { Long.valueOf(com.tencent.mm.plugin.mmsight.d.Ua("TIME_RECODER_2_PLAY")) });
    al.d(new SightCaptureUI.11.1(this, str + "\n" + String.format("CPU: cur %s max:%s", new Object[] { m.Lr(), m.Lp() })));
    AppMethodBeat.o(55197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.11
 * JD-Core Version:    0.7.0.1
 */