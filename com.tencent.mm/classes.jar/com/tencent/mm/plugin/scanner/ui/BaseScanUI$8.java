package com.tencent.mm.plugin.scanner.ui;

import android.hardware.Camera.Parameters;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.plugin.scanner.model.n;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class BaseScanUI$8
  implements View.OnClickListener
{
  BaseScanUI$8(BaseScanUI paramBaseScanUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(138462);
    if (BaseScanUI.a(this.qwI) != null)
    {
      n.qux.CF(2);
      if (!BaseScanUI.a(this.qwI).oHg)
      {
        paramView = BaseScanUI.a(this.qwI);
        ab.i("MicroMsg.scanner.ScanCamera", "openFlash, camera: %s, isPreviewing: %s", new Object[] { paramView.eoH, Boolean.valueOf(paramView.miS) });
        if ((paramView.eoH != null) && (paramView.miS)) {}
        try
        {
          paramView.oHg = true;
          Camera.Parameters localParameters = paramView.eoH.getParameters();
          if ((!bo.es(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("torch")))
          {
            localParameters.setFlashMode("torch");
            paramView.eoH.setParameters(localParameters);
            ab.i("MicroMsg.scanner.ScanCamera", "open flash");
          }
          for (;;)
          {
            paramView = BaseScanUI.p(this.qwI);
            ab.i("MicroMsg.ScannerFlashSwitcher", "openFlashStatus");
            paramView.qBb.setImageResource(2131231943);
            AppMethodBeat.o(138462);
            return;
            ab.i("MicroMsg.scanner.ScanCamera", "camera not support flash!!");
          }
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.scanner.ScanCamera", paramView, "openFlash error: %s", new Object[] { paramView.getMessage() });
          }
        }
      }
      BaseScanUI.a(this.qwI).bQR();
      BaseScanUI.p(this.qwI).cji();
    }
    AppMethodBeat.o(138462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.8
 * JD-Core Version:    0.7.0.1
 */