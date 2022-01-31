package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class WalletBankcardManageUI$3
  implements MenuItem.OnMenuItemClickListener
{
  WalletBankcardManageUI$3(WalletBankcardManageUI paramWalletBankcardManageUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(45765);
    this.tTk.finish();
    h.qsU.e(14422, new Object[] { Integer.valueOf(4) });
    AppMethodBeat.o(45765);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.3
 * JD-Core Version:    0.7.0.1
 */