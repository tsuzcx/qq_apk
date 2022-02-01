package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av.a;

final class RemittanceF2fDynamicCodeUI$a
  implements av.a
{
  private RemittanceF2fDynamicCodeUI$a(RemittanceF2fDynamicCodeUI paramRemittanceF2fDynamicCodeUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(68187);
    ad.d("MicroMsg.RemittanceF2fDynamicCodeUI", "timer expired");
    if (RemittanceF2fDynamicCodeUI.e(this.yfD))
    {
      AppMethodBeat.o(68187);
      return true;
    }
    RemittanceF2fDynamicCodeUI.a(this.yfD, System.currentTimeMillis());
    RemittanceF2fDynamicCodeUI.f(this.yfD);
    AppMethodBeat.o(68187);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.a
 * JD-Core Version:    0.7.0.1
 */