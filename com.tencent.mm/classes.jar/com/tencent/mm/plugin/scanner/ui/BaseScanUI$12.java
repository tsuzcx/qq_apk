package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.sdk.platformtools.PlaySound;

final class BaseScanUI$12
  implements Runnable
{
  BaseScanUI$12(BaseScanUI paramBaseScanUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(169971);
    PlaySound.play(this.IPw, l.i.qrcode_completed_2);
    AppMethodBeat.o(169971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.12
 * JD-Core Version:    0.7.0.1
 */