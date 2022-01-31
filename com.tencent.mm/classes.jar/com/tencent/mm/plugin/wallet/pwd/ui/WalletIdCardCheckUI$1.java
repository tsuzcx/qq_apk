package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletIdCardCheckUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WalletIdCardCheckUI$1(WalletIdCardCheckUI paramWalletIdCardCheckUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(46322);
    ab.i("Micromsg.WalletIdCardCheckUI", "onbackbtn click");
    this.tZC.finish();
    AppMethodBeat.o(46322);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI.1
 * JD-Core Version:    0.7.0.1
 */