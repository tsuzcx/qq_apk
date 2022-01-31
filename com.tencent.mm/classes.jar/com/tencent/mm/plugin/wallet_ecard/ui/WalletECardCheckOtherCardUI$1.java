package com.tencent.mm.plugin.wallet_ecard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletECardCheckOtherCardUI$1
  implements View.OnClickListener
{
  WalletECardCheckOtherCardUI$1(WalletECardCheckOtherCardUI paramWalletECardCheckOtherCardUI) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.WalletECardCheckOtherCardUI", "do check card");
    if ((WalletECardCheckOtherCardUI.a(this.qKM).YL()) && (WalletECardCheckOtherCardUI.b(this.qKM).YL()))
    {
      paramView = WalletECardCheckOtherCardUI.a(this.qKM).getText();
      String str = WalletECardCheckOtherCardUI.b(this.qKM).getText();
      this.qKM.cNk().m(new Object[] { paramView, str });
      return;
    }
    y.w("MicroMsg.WalletECardCheckOtherCardUI", "input invalid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI.1
 * JD-Core Version:    0.7.0.1
 */