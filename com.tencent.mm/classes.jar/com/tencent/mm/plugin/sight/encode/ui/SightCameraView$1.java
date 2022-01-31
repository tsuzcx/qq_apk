package com.tencent.mm.plugin.sight.encode.ui;

import com.tencent.mm.plugin.sight.encode.a.a;
import com.tencent.mm.plugin.sight.encode.a.a.a;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class SightCameraView$1
  implements am.a
{
  SightCameraView$1(SightCameraView paramSightCameraView) {}
  
  public final boolean tC()
  {
    float f = (float)this.oiM.oiz.bBA() / this.oiM.oiG;
    if ((Float.compare(f, 0.0F) <= 0) && (System.currentTimeMillis() - SightCameraView.a(this.oiM) > 20000L))
    {
      y.e("MicroMsg.SightCameraView", "ERROR record duration, %dms !!!", new Object[] { Long.valueOf(20000L) });
      this.oiM.aPl();
      return false;
    }
    if ((Float.compare(f, 1.0F) > 0) && (this.oiM.oiz.bBB() == a.a.ohh)) {
      if (!this.oiM.oiz.bBz()) {
        SightCameraView.b(this.oiM);
      }
    }
    for (;;)
    {
      return true;
      this.oiM.aB(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightCameraView.1
 * JD-Core Version:    0.7.0.1
 */