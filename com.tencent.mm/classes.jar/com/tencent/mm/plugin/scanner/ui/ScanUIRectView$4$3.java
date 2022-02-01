package com.tencent.mm.plugin.scanner.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qbar.c;
import com.tencent.scanlib.a.a;
import com.tencent.scanlib.a.f;

final class ScanUIRectView$4$3
  implements Runnable
{
  ScanUIRectView$4$3(ScanUIRectView.4 param4, long paramLong, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(314591);
    try
    {
      if ((this.OPa == ScanUIRectView.l(this.Pck.Pcg)) && (this.OPa != 0L) && (this.val$param != null) && (this.val$param.containsKey("param_zoom_ratio")))
      {
        float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
        Log.i("MicroMsg.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
        if ((f > 0.0F) && (ScanUIRectView.n(this.Pck.Pcg)) && (ScanUIRectView.o(this.Pck.Pcg).boa()))
        {
          int i = (int)(((a)ScanUIRectView.p(this.Pck.Pcg)).jXI() * f);
          ((a)ScanUIRectView.q(this.Pck.Pcg)).aHc(i);
          c localc = c.ahqH;
          localc.ahqV += 1;
          localc.ahqW *= f;
          localc.ahqX = (System.currentTimeMillis() - localc.OTD);
          Log.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", new Object[] { Integer.valueOf(localc.ahqV), Float.valueOf(f), Float.valueOf(localc.ahqW), Long.valueOf(localc.ahqX) });
        }
      }
      AppMethodBeat.o(314591);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ScanUIRectView", localException, "zoomToScale exception", new Object[0]);
      AppMethodBeat.o(314591);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanUIRectView.4.3
 * JD-Core Version:    0.7.0.1
 */