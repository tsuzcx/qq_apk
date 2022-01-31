package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

final class q$1
  implements EditHintPasswdView.a
{
  q$1(q paramq) {}
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(47587);
    if (paramBoolean)
    {
      this.utp.cVU();
      h.qsU.e(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    }
    AppMethodBeat.o(47587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.q.1
 * JD-Core Version:    0.7.0.1
 */