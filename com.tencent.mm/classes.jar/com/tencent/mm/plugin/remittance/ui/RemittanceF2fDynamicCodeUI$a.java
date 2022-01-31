package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class RemittanceF2fDynamicCodeUI$a
  implements am.a
{
  private RemittanceF2fDynamicCodeUI$a(RemittanceF2fDynamicCodeUI paramRemittanceF2fDynamicCodeUI) {}
  
  public final boolean tC()
  {
    y.d("MicroMsg.RemittanceF2fDynamicCodeUI", "timer expired");
    if (RemittanceF2fDynamicCodeUI.e(this.nDP)) {
      return true;
    }
    RemittanceF2fDynamicCodeUI.a(this.nDP, System.currentTimeMillis());
    RemittanceF2fDynamicCodeUI.f(this.nDP);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.a
 * JD-Core Version:    0.7.0.1
 */