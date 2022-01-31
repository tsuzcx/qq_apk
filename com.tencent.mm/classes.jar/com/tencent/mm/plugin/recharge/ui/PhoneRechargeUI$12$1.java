package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.plugin.recharge.model.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class PhoneRechargeUI$12$1
  implements Runnable
{
  PhoneRechargeUI$12$1(PhoneRechargeUI.12 param12, String paramString) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis();
    a locala = PhoneRechargeUI.a(this.nrd.nrb, this.nrc);
    y.d("MicroMsg.PhoneRechargeUI", "handle cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    ai.d(new PhoneRechargeUI.12.1.1(this, locala));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.12.1
 * JD-Core Version:    0.7.0.1
 */