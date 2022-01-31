package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class SightCaptureUI$1
  implements Runnable
{
  SightCaptureUI$1(SightCaptureUI paramSightCaptureUI, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(55180);
    ab.i("MicroMsg.SightCaptureUI", "connect cost %sms", new Object[] { Long.valueOf(bo.av(this.ngG)) });
    j.d(SightCaptureUI.a(this.oQf).fcu);
    SightCaptureUI.b(this.oQf);
    AppMethodBeat.o(55180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.1
 * JD-Core Version:    0.7.0.1
 */