package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.media.widget.camerarecordview.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

final class SightCaptureUITest$17
  implements Runnable
{
  SightCaptureUITest$17(SightCaptureUITest paramSightCaptureUITest) {}
  
  public final void run()
  {
    AppMethodBeat.i(150476);
    String str = d.TX(SightCaptureUITest.c(this.oQq).Xe());
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(150476);
      return;
    }
    str = str + "\n" + String.format("TIME_RECODER_2_PLAY: %s", new Object[] { Long.valueOf(d.Ua("TIME_RECODER_2_PLAY")) });
    al.d(new SightCaptureUITest.17.1(this, str + "\n" + String.format("CPU: cur %s max:%s", new Object[] { m.Lr(), m.Lp() })));
    AppMethodBeat.o(150476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.17
 * JD-Core Version:    0.7.0.1
 */