package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.d.a;
import com.tencent.mm.plugin.scanner.model.b;
import com.tencent.mm.plugin.scanner.model.z;
import com.tencent.mm.sdk.platformtools.ac;

final class BaseScanUI$26
  implements DialogInterface.OnCancelListener
{
  BaseScanUI$26(BaseScanUI paramBaseScanUI, long paramLong) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(199518);
    ac.i("MicroMsg.ScanUI", "alvinluo processGoodsImage onCancel and resumeScan");
    if ((BaseScanUI.c(this.xce) instanceof a))
    {
      paramDialogInterface = (a)BaseScanUI.c(this.xce);
      long l = this.wYk;
      b localb = paramDialogInterface.xaY;
      if (localb != null) {
        localb.wB(l);
      }
      paramDialogInterface = paramDialogInterface.xaX;
      if (paramDialogInterface != null) {
        paramDialogInterface.wB(l);
      }
    }
    z.a(2, false, System.currentTimeMillis(), true);
    BaseScanUI.q(this.xce);
    AppMethodBeat.o(199518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.26
 * JD-Core Version:    0.7.0.1
 */