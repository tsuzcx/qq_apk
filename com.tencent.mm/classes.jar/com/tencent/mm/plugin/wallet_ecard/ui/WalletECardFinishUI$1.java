package com.tencent.mm.plugin.wallet_ecard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletECardFinishUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WalletECardFinishUI$1(WalletECardFinishUI paramWalletECardFinishUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(48144);
    ab.i("MicroMsg.WalletECardFinishUI", "press back btn");
    WalletECardFinishUI.a(this.uzL).performClick();
    AppMethodBeat.o(48144);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI.1
 * JD-Core Version:    0.7.0.1
 */