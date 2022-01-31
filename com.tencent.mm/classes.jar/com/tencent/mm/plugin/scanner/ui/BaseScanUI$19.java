package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class BaseScanUI$19
  extends ak
{
  BaseScanUI$19(BaseScanUI paramBaseScanUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(138475);
    if ((BaseScanUI.a(this.qwI) != null) && (BaseScanUI.t(this.qwI)) && (!BaseScanUI.Q(this.qwI)) && (paramMessage.what == 0))
    {
      BaseScanUI.a(this.qwI, System.currentTimeMillis());
      paramMessage = BaseScanUI.a(this.qwI);
      BaseScanUI localBaseScanUI = this.qwI;
      if ((paramMessage.eoH != null) && (paramMessage.miS)) {
        try
        {
          paramMessage.cjB();
          paramMessage.eoH.autoFocus(localBaseScanUI);
          AppMethodBeat.o(138475);
          return;
        }
        catch (RuntimeException paramMessage)
        {
          ab.w("MicroMsg.scanner.ScanCamera", "autoFocus() " + paramMessage.getMessage());
        }
      }
    }
    AppMethodBeat.o(138475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.19
 * JD-Core Version:    0.7.0.1
 */