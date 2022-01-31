package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.e.b;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.ui.cameraglview.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class SightCaptureUI$6
  implements e.b
{
  SightCaptureUI$6(SightCaptureUI paramSightCaptureUI) {}
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(55190);
    if ((paramArrayOfByte == null) || (paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      ab.e("MicroMsg.SightCaptureUI", "onPictureYuvTaken, data is null!!");
      SightCaptureUI.z(this.oQf);
      AppMethodBeat.o(55190);
      return;
    }
    ab.i("MicroMsg.SightCaptureUI", "data frameWidth %s frameHeight %s rotate %s deviceDegree %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    SightCaptureUI.A(this.oQf);
    SightCaptureUI.B(this.oQf);
    SightCaptureUI.b(this.oQf, paramInt1);
    SightCaptureUI.c(this.oQf, paramInt2);
    SightCaptureUI.d(this.oQf, paramInt3);
    SightCaptureUI.e(this.oQf, paramInt4);
    if (SightCaptureUI.C(this.oQf) != null)
    {
      j.oJp.O(SightCaptureUI.C(this.oQf));
      SightCaptureUI.a(this.oQf, null);
    }
    SightCaptureUI.a(this.oQf, j.oJp.f(Integer.valueOf(paramArrayOfByte.length)));
    System.arraycopy(paramArrayOfByte, 0, SightCaptureUI.C(this.oQf), 0, paramArrayOfByte.length);
    SightCaptureUI.a(this.oQf, com.tencent.mm.sdk.g.d.h(new SightCaptureUI.6.1(this), "SightCaptureUI_saveCaptureBitmap"));
    SightCaptureUI.E(this.oQf).start();
    k.e(true, com.tencent.mm.plugin.mmsight.d.Ua("TIME_RECODER_2_PLAY"));
    if (SightCaptureUI.F(this.oQf))
    {
      if (Math.abs(paramInt3 - paramInt4) == 0) {}
      for (paramInt3 = 180;; paramInt3 = 0)
      {
        paramArrayOfByte = com.tencent.mm.plugin.mmsight.d.d(paramArrayOfByte, paramInt1, paramInt2, paramInt3 % 360);
        SightCaptureUI.e(this.oQf).a(paramArrayOfByte, true, 0);
        paramInt2 = paramInt3;
        SightCaptureUI.b(this.oQf, paramArrayOfByte);
        SightCaptureUI.f(this.oQf, paramInt2);
        SightCaptureUI.g(this.oQf, 3);
        SightCaptureUI.H(this.oQf).post(new SightCaptureUI.6.2(this));
        if ((SightCaptureUI.a(this.oQf).scene == 1) || (SightCaptureUI.a(this.oQf).scene == 2) || (SightCaptureUI.a(this.oQf).scene == 7)) {
          h.qsU.e(13819, new Object[] { Integer.valueOf(1), Integer.valueOf(SightCaptureUI.a(this.oQf).scene), SightCaptureUI.a(this.oQf).oFX, Long.valueOf(bo.aox()) });
        }
        AppMethodBeat.o(55190);
        return;
      }
    }
    if (paramInt4 == 180) {}
    for (paramInt1 = paramInt3 + paramInt4;; paramInt1 = paramInt3)
    {
      paramInt2 = paramInt1;
      if (paramInt1 > 360) {
        paramInt2 = paramInt1 - 360;
      }
      SightCaptureUI.e(this.oQf).a(paramArrayOfByte, false, paramInt2);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.6
 * JD-Core Version:    0.7.0.1
 */