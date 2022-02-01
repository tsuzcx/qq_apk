package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.sdk.platformtools.PlaySound;

final class BaseScanUI$40
  implements Runnable
{
  BaseScanUI$40(BaseScanUI paramBaseScanUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(314523);
    PlaySound.play(this.OYm, l.i.qrcode_completed_2);
    AppMethodBeat.o(314523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.40
 * JD-Core Version:    0.7.0.1
 */