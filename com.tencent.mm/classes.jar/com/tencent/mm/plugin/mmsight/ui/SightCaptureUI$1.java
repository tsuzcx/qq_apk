package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class SightCaptureUI$1
  implements Runnable
{
  SightCaptureUI$1(SightCaptureUI paramSightCaptureUI, long paramLong) {}
  
  public final void run()
  {
    y.i("MicroMsg.SightCaptureUI", "connect cost %sms", new Object[] { Long.valueOf(bk.cp(this.kKd)) });
    j.c(SightCaptureUI.a(this.mqB).mfr);
    SightCaptureUI.b(this.mqB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.1
 * JD-Core Version:    0.7.0.1
 */