package com.tencent.mm.plugin.recharge.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recharge.model.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class PhoneRechargeUI$12$1
  implements Runnable
{
  PhoneRechargeUI$12$1(PhoneRechargeUI.12 param12, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(44264);
    long l = System.currentTimeMillis();
    a locala = PhoneRechargeUI.a(this.pWr.pWp, this.pWq);
    ab.d("MicroMsg.PhoneRechargeUI", "handle cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    al.d(new PhoneRechargeUI.12.1.1(this, locala));
    AppMethodBeat.o(44264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.12.1
 * JD-Core Version:    0.7.0.1
 */