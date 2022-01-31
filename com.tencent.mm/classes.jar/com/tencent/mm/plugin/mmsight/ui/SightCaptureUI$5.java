package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.e.b;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.ui.cameraglview.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class SightCaptureUI$5
  implements e.b
{
  SightCaptureUI$5(SightCaptureUI paramSightCaptureUI) {}
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramArrayOfByte == null) || (paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      y.e("MicroMsg.SightCaptureUI", "onPictureYuvTaken, data is null!!");
      SightCaptureUI.y(this.mqB);
      return;
    }
    y.i("MicroMsg.SightCaptureUI", "data frameWidth %s frameHeight %s rotate %s deviceDegree %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    SightCaptureUI.z(this.mqB);
    SightCaptureUI.A(this.mqB);
    SightCaptureUI.b(this.mqB, paramInt1);
    SightCaptureUI.c(this.mqB, paramInt2);
    SightCaptureUI.d(this.mqB, paramInt3);
    SightCaptureUI.e(this.mqB, paramInt4);
    if (SightCaptureUI.B(this.mqB) != null)
    {
      j.mji.z(SightCaptureUI.B(this.mqB));
      SightCaptureUI.a(this.mqB, null);
    }
    SightCaptureUI.a(this.mqB, j.mji.f(Integer.valueOf(paramArrayOfByte.length)));
    System.arraycopy(paramArrayOfByte, 0, SightCaptureUI.B(this.mqB), 0, paramArrayOfByte.length);
    SightCaptureUI.a(this.mqB, e.b(new Runnable()
    {
      public final void run()
      {
        SightCaptureUI.C(SightCaptureUI.5.this.mqB);
      }
    }, "SightCaptureUI_saveCaptureBitmap"));
    SightCaptureUI.D(this.mqB).start();
    k.d(true, d.Im("TIME_RECODER_2_PLAY"));
    if (SightCaptureUI.E(this.mqB))
    {
      if (Math.abs(paramInt3 - paramInt4) == 0) {}
      for (paramInt3 = 180;; paramInt3 = 0)
      {
        paramArrayOfByte = d.d(paramArrayOfByte, paramInt1, paramInt2, paramInt3 % 360);
        SightCaptureUI.c(this.mqB).a(paramArrayOfByte, true, 0);
        paramInt2 = paramInt3;
        SightCaptureUI.b(this.mqB, paramArrayOfByte);
        SightCaptureUI.f(this.mqB, paramInt2);
        SightCaptureUI.g(this.mqB, 3);
        SightCaptureUI.G(this.mqB).post(new SightCaptureUI.5.2(this));
        if ((SightCaptureUI.a(this.mqB).scene != 1) && (SightCaptureUI.a(this.mqB).scene != 2)) {
          break;
        }
        h.nFQ.f(13819, new Object[] { Integer.valueOf(1), Integer.valueOf(SightCaptureUI.a(this.mqB).scene), SightCaptureUI.a(this.mqB).mfz, Long.valueOf(bk.UX()) });
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
      SightCaptureUI.c(this.mqB).a(paramArrayOfByte, false, paramInt2);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.5
 * JD-Core Version:    0.7.0.1
 */