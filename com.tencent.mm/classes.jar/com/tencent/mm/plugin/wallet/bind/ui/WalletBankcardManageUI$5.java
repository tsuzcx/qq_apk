package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class WalletBankcardManageUI$5
  implements MenuItem.OnMenuItemClickListener
{
  WalletBankcardManageUI$5(WalletBankcardManageUI paramWalletBankcardManageUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(69105);
    this.HDv.finish();
    h.CyF.a(14422, new Object[] { Integer.valueOf(4) });
    AppMethodBeat.o(69105);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.5
 * JD-Core Version:    0.7.0.1
 */