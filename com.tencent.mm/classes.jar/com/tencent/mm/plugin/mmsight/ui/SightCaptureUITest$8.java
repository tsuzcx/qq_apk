package com.tencent.mm.plugin.mmsight.ui;

import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.a;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.recordvideo.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

final class SightCaptureUITest$8
  implements a.f.a.b<com.tencent.mm.media.widget.camerarecordview.a.b, y>
{
  SightCaptureUITest$8(SightCaptureUITest paramSightCaptureUITest, long paramLong) {}
  
  private y a(com.tencent.mm.media.widget.camerarecordview.a.b paramb)
  {
    AppMethodBeat.i(150454);
    ab.b("MicroMsg.SightCaptureUI", "call stop callback now, currentStatus: %s", new Object[] { SightCaptureUITest.zB(SightCaptureUITest.e(this.oQq)) });
    SightCaptureUITest.c(this.oQq).stopPreview();
    SightCaptureUITest.a(this.oQq, paramb);
    long l = bo.av(this.ngG);
    Object localObject1 = SightCaptureUITest.c(this.oQq).Xe();
    Object localObject2 = SightCaptureUITest.B(this.oQq);
    Object localObject3 = c.qbf;
    int i = c.cgk();
    localObject3 = c.qbf;
    k.a((String)localObject1, (bby)localObject2, i, c.cgl());
    k.e(false, l);
    ab.v("MicroMsg.SightCaptureUIEvent", "doStopRecorderAndStartPreviewDone %s", new Object[] { bo.dtY().toString() });
    ab.i("MicroMsg.SightCaptureUI", "stop finish, filepath: %s %s time_takevideo %s", new Object[] { SightCaptureUITest.c(this.oQq).Xe(), Long.valueOf(e.avI(SightCaptureUITest.c(this.oQq).Xe())), Long.valueOf(l) });
    SightCaptureUITest.c(this.oQq).stopPreview();
    localObject3 = this.oQq;
    localObject1 = SightCaptureUITest.c(this.oQq).faU;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.media.widget.b.b)localObject1).Al();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    SightCaptureUITest.b((SightCaptureUITest)localObject3, (String)localObject1);
    SightCaptureUITest.C(this.oQq);
    SightCaptureUITest.c(this.oQq, paramb.fbn);
    al.p(SightCaptureUITest.D(this.oQq), 1000L);
    if ((SightCaptureUITest.d(this.oQq).scene == 1) || (SightCaptureUITest.d(this.oQq).scene == 2) || (SightCaptureUITest.d(this.oQq).scene == 7)) {
      h.qsU.e(13819, new Object[] { Integer.valueOf(2), Integer.valueOf(SightCaptureUITest.d(this.oQq).scene), SightCaptureUITest.d(this.oQq).oFX, Long.valueOf(bo.aox()) });
    }
    AppMethodBeat.o(150454);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.8
 * JD-Core Version:    0.7.0.1
 */