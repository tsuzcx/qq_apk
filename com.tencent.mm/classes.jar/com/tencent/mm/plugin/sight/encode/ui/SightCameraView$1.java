package com.tencent.mm.plugin.sight.encode.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.encode.a.a;
import com.tencent.mm.plugin.sight.encode.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class SightCameraView$1
  implements ap.a
{
  SightCameraView$1(SightCameraView paramSightCameraView) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(25108);
    float f = (float)this.qWZ.qWM.cmZ() / this.qWZ.qWT;
    if ((Float.compare(f, 0.0F) <= 0) && (System.currentTimeMillis() - SightCameraView.a(this.qWZ) > 20000L))
    {
      ab.e("MicroMsg.SightCameraView", "ERROR record duration, %dms !!!", new Object[] { Long.valueOf(20000L) });
      this.qWZ.bvq();
      AppMethodBeat.o(25108);
      return false;
    }
    if ((Float.compare(f, 1.0F) > 0) && (this.qWZ.qWM.cna() == a.a.qVw)) {
      if (!this.qWZ.qWM.Cp()) {
        SightCameraView.b(this.qWZ);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(25108);
      return true;
      this.qWZ.aZ(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightCameraView.1
 * JD-Core Version:    0.7.0.1
 */