package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

final class u$1
  implements EditHintPasswdView.a
{
  u$1(u paramu) {}
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(71155);
    if (paramBoolean)
    {
      this.VSI.ilb();
      h.OAn.b(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    }
    AppMethodBeat.o(71155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.u.1
 * JD-Core Version:    0.7.0.1
 */