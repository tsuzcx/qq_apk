package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;

final class RemittanceDetailUI$18$1
  implements a.a
{
  RemittanceDetailUI$18$1(RemittanceDetailUI.18 param18) {}
  
  public final boolean run(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(45017);
    if (paramInt1 == 2)
    {
      this.qqj.qpY.chx();
      AppMethodBeat.o(45017);
      return true;
    }
    if ((paramInt1 == 0) && (paramBoolean)) {
      this.qqj.qpY.chx();
    }
    AppMethodBeat.o(45017);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.18.1
 * JD-Core Version:    0.7.0.1
 */