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
import com.tencent.mm.ui.f.r;
import com.tencent.mm.wallet_core.ui.g;

final class WalletBalanceManagerUI$3
  implements MenuItem.OnMenuItemClickListener
{
  WalletBalanceManagerUI$3(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(68648);
    paramMenuItem = new Intent();
    if (!Util.isNullOrNil(this.OnZ.OnP.ONH))
    {
      Log.i("MicroMsg.WalletBalanceManagerUI", "carson: entry_url: %s", new Object[] { this.OnZ.OnP.ONH });
      paramMenuItem.putExtra("rawUrl", this.OnZ.OnP.ONH);
    }
    for (;;)
    {
      paramMenuItem.putExtra("showShare", false);
      paramMenuItem.putExtra("geta8key_username", z.bcZ());
      paramMenuItem.putExtra("KPublisherId", "pay_blance_list");
      paramMenuItem.putExtra("geta8key_scene", 33);
      paramMenuItem.putExtra(f.r.VSX, true);
      g.aJ(this.OnZ.getContext(), paramMenuItem);
      g.azK(16);
      h.IzE.a(16503, new Object[] { Integer.valueOf(1), "balanceBill" });
      AppMethodBeat.o(68648);
      return true;
      paramMenuItem.putExtra("rawUrl", this.OnZ.OnP.ONG);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.3
 * JD-Core Version:    0.7.0.1
 */