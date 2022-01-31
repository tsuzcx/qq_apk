package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

final class SightCaptureUI$10
  implements Runnable
{
  SightCaptureUI$10(SightCaptureUI paramSightCaptureUI, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(55195);
    ab.b("MicroMsg.SightCaptureUI", "call stop callback now, currentStatus: %s", new Object[] { SightCaptureUI.zA(SightCaptureUI.g(this.oQf)) });
    SightCaptureUI.j(this.oQf).a(e.a.oHs);
    SightCaptureUI.B(this.oQf);
    long l = com.tencent.mm.plugin.mmsight.d.Ua("TIME_RECODER_2_PLAY");
    com.tencent.mm.sdk.g.d.post(new SightCaptureUI.10.1(this, l), "BigSightFFMpegRecorder_markAfterCaptureFinish_idkeystat");
    ab.v("MicroMsg.TestCaptureUiEvent", "doStopRecorderAndStartPreviewDone %s", new Object[] { bo.dtY().toString() });
    ab.i("MicroMsg.SightCaptureUI", "stop finish, filepath: %s %s time_takevideo %s", new Object[] { SightCaptureUI.p(this.oQf).getFilePath(), Long.valueOf(com.tencent.mm.vfs.e.avI(SightCaptureUI.p(this.oQf).getFilePath())), Long.valueOf(l) });
    SightCaptureUI.a(this.oQf, SightCaptureUI.p(this.oQf).Al());
    SightCaptureUI.A(this.oQf);
    SightCaptureUI.L(this.oQf);
    SightCaptureUI.M(this.oQf);
    al.p(SightCaptureUI.N(this.oQf), 1000L);
    if ((SightCaptureUI.a(this.oQf).scene == 1) || (SightCaptureUI.a(this.oQf).scene == 2) || (SightCaptureUI.a(this.oQf).scene == 7)) {
      h.qsU.e(13819, new Object[] { Integer.valueOf(2), Integer.valueOf(SightCaptureUI.a(this.oQf).scene), SightCaptureUI.a(this.oQf).oFX, Long.valueOf(bo.aox()) });
    }
    AppMethodBeat.o(55195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.10
 * JD-Core Version:    0.7.0.1
 */