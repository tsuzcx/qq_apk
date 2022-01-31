package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.plugin.recharge.model.a;
import com.tencent.mm.plugin.recharge.ui.form.c.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h.a;
import java.util.List;

final class PhoneRechargeUI$13
  implements h.a
{
  PhoneRechargeUI$13(PhoneRechargeUI paramPhoneRechargeUI, List paramList, String paramString) {}
  
  public final void wv(int paramInt)
  {
    y.d("MicroMsg.PhoneRechargeUI", "choose: %d", new Object[] { Integer.valueOf(paramInt) });
    PhoneRechargeUI.b(this.nrb).setInput(new a((String)this.nrf.get(paramInt), this.nrg, 1));
    PhoneRechargeUI.n(this.nrb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.13
 * JD-Core Version:    0.7.0.1
 */