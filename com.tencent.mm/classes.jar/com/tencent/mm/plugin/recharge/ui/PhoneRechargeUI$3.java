package com.tencent.mm.plugin.recharge.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

final class PhoneRechargeUI$3
  implements MenuItem.OnMenuItemClickListener
{
  PhoneRechargeUI$3(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (!PhoneRechargeUI.a(this.nrb, PhoneRechargeUI.i(this.nrb).qkP, PhoneRechargeUI.i(this.nrb).dTJ)) {}
    try
    {
      paramMenuItem = URLDecoder.decode(PhoneRechargeUI.i(this.nrb).url, "utf-8");
      PhoneRechargeUI.c(this.nrb, paramMenuItem);
      return false;
    }
    catch (UnsupportedEncodingException paramMenuItem)
    {
      y.printErrStackTrace("MicroMsg.PhoneRechargeUI", paramMenuItem, "", new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.3
 * JD-Core Version:    0.7.0.1
 */