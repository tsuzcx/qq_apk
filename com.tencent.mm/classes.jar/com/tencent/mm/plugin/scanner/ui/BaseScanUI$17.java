package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.sdk.platformtools.ak;

final class BaseScanUI$17
  extends ak
{
  BaseScanUI$17(BaseScanUI paramBaseScanUI)
  {
    AppMethodBeat.i(80929);
    AppMethodBeat.o(80929);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(138472);
    if ((!BaseScanUI.C(this.qwI)) && (BaseScanUI.a(this.qwI) != null) && (BaseScanUI.t(this.qwI))) {
      BaseScanUI.a(this.qwI).a(this.qwI);
    }
    AppMethodBeat.o(138472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.17
 * JD-Core Version:    0.7.0.1
 */