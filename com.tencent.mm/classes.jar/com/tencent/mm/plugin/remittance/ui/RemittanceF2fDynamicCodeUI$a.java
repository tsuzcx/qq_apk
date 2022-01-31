package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class RemittanceF2fDynamicCodeUI$a
  implements ap.a
{
  private RemittanceF2fDynamicCodeUI$a(RemittanceF2fDynamicCodeUI paramRemittanceF2fDynamicCodeUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(45058);
    ab.d("MicroMsg.RemittanceF2fDynamicCodeUI", "timer expired");
    if (RemittanceF2fDynamicCodeUI.e(this.qqI))
    {
      AppMethodBeat.o(45058);
      return true;
    }
    RemittanceF2fDynamicCodeUI.a(this.qqI, System.currentTimeMillis());
    RemittanceF2fDynamicCodeUI.f(this.qqI);
    AppMethodBeat.o(45058);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.a
 * JD-Core Version:    0.7.0.1
 */