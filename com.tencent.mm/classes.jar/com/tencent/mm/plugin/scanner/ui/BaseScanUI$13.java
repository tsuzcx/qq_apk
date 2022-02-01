package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;

final class BaseScanUI$13
  implements u.g
{
  BaseScanUI$13(BaseScanUI paramBaseScanUI)
  {
    AppMethodBeat.i(169972);
    AppMethodBeat.o(169972);
  }
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(314573);
    if (params.jmw()) {
      params.oh(102, l.i.OKE);
    }
    AppMethodBeat.o(314573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.13
 * JD-Core Version:    0.7.0.1
 */