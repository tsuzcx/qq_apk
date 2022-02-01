package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

final class s$1
  implements EditHintPasswdView.a
{
  s$1(s params) {}
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(71122);
    if (paramBoolean)
    {
      this.PbS.gLK();
      h.IzE.a(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    }
    AppMethodBeat.o(71122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.s.1
 * JD-Core Version:    0.7.0.1
 */