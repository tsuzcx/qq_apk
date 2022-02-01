package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.wallet_core.ui.f;

final class WalletBalanceManagerUI$3
  implements MenuItem.OnMenuItemClickListener
{
  WalletBalanceManagerUI$3(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(68648);
    paramMenuItem = new Intent();
    if (!Util.isNullOrNil(this.Hwm.Hwc.HVG))
    {
      Log.i("MicroMsg.WalletBalanceManagerUI", "carson: entry_url: %s", new Object[] { this.Hwm.Hwc.HVG });
      paramMenuItem.putExtra("rawUrl", this.Hwm.Hwc.HVG);
    }
    for (;;)
    {
      paramMenuItem.putExtra("showShare", false);
      paramMenuItem.putExtra("geta8key_username", z.aTY());
      paramMenuItem.putExtra("KPublisherId", "pay_blance_list");
      paramMenuItem.putExtra("geta8key_scene", 33);
      paramMenuItem.putExtra(e.p.OzJ, true);
      f.aA(this.Hwm.getContext(), paramMenuItem);
      f.aqm(16);
      h.CyF.a(16503, new Object[] { Integer.valueOf(1), "balanceBill" });
      AppMethodBeat.o(68648);
      return true;
      paramMenuItem.putExtra("rawUrl", this.Hwm.Hwc.HVF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.3
 * JD-Core Version:    0.7.0.1
 */