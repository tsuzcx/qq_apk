package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class SightCaptureUI$9
  implements Runnable
{
  SightCaptureUI$9(SightCaptureUI paramSightCaptureUI, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    y.l("MicroMsg.SightCaptureUI", "call stop callback now, currentStatus: %s", new Object[] { SightCaptureUI.uk(SightCaptureUI.e(this.mqB)) });
    SightCaptureUI.h(this.mqB).a(e.a.mhi);
    SightCaptureUI.A(this.mqB);
    long l = com.tencent.mm.plugin.mmsight.d.Im("TIME_RECODER_2_PLAY");
    com.tencent.mm.sdk.f.e.post(new SightCaptureUI.9.1(this, l), "BigSightFFMpegRecorder_markAfterCaptureFinish_idkeystat");
    y.v("MicroMsg.TestCaptureUiEvent", "doStopRecorderAndStartPreviewDone %s", new Object[] { bk.csb().toString() });
    y.i("MicroMsg.SightCaptureUI", "stop finish, filepath: %s %s time_takevideo %s", new Object[] { SightCaptureUI.n(this.mqB).bjl(), Long.valueOf(com.tencent.mm.vfs.e.aeQ(SightCaptureUI.n(this.mqB).bjl())), Long.valueOf(l) });
    SightCaptureUI.a(this.mqB, SightCaptureUI.n(this.mqB).Wv());
    SightCaptureUI.z(this.mqB);
    SightCaptureUI.K(this.mqB);
    SightCaptureUI.L(this.mqB);
    ai.l(SightCaptureUI.M(this.mqB), 1000L);
    if ((SightCaptureUI.a(this.mqB).scene == 1) || (SightCaptureUI.a(this.mqB).scene == 2)) {
      h.nFQ.f(13819, new Object[] { Integer.valueOf(2), Integer.valueOf(SightCaptureUI.a(this.mqB).scene), SightCaptureUI.a(this.mqB).mfz, Long.valueOf(bk.UX()) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.9
 * JD-Core Version:    0.7.0.1
 */