package com.tencent.mm.plugin.recharge.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

final class PhoneRechargeUI$3
  implements MenuItem.OnMenuItemClickListener
{
  PhoneRechargeUI$3(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(44254);
    if (!PhoneRechargeUI.a(this.pWp, PhoneRechargeUI.i(this.pWp).tTY, PhoneRechargeUI.i(this.pWp).fjP)) {}
    try
    {
      paramMenuItem = URLDecoder.decode(PhoneRechargeUI.i(this.pWp).url, "utf-8");
      PhoneRechargeUI.c(this.pWp, paramMenuItem);
      AppMethodBeat.o(44254);
      return false;
    }
    catch (UnsupportedEncodingException paramMenuItem)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.PhoneRechargeUI", paramMenuItem, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.3
 * JD-Core Version:    0.7.0.1
 */