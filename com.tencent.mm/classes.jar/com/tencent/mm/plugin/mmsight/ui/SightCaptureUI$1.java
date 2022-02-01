package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class SightCaptureUI$1
  implements Runnable
{
  SightCaptureUI$1(SightCaptureUI paramSightCaptureUI, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(94632);
    ad.i("MicroMsg.SightCaptureUI", "connect cost %sms", new Object[] { Long.valueOf(bt.aS(this.rKB)) });
    k.d(SightCaptureUI.a(this.tLo).gCB);
    SightCaptureUI.b(this.tLo);
    AppMethodBeat.o(94632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.1
 * JD-Core Version:    0.7.0.1
 */