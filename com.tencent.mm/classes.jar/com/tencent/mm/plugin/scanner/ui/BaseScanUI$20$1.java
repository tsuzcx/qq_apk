package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class BaseScanUI$20$1
  implements n.c
{
  BaseScanUI$20$1(BaseScanUI.20 param20) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(138476);
    if (this.qwN.qwM != null) {
      paraml.hx(1, 2131303080);
    }
    paraml.hx(0, 2131296422);
    if (k.cjG())
    {
      paraml.hx(2, 2131302902);
      ab.i("MicroMsg.scanner.BaseScanUI", "show history list");
    }
    AppMethodBeat.o(138476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.20.1
 * JD-Core Version:    0.7.0.1
 */