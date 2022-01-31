package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class WalletSwitchWalletCurrencyUI$1
  implements AdapterView.OnItemClickListener
{
  WalletSwitchWalletCurrencyUI$1(WalletSwitchWalletCurrencyUI paramWalletSwitchWalletCurrencyUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = WalletSwitchWalletCurrencyUI.a(this.qGP).AY(paramInt);
    WalletSwitchWalletCurrencyUI.a(this.qGP, WalletSwitchWalletCurrencyUI.a(this.qGP).qGQ);
    if ((paramView != null) && ((WalletSwitchWalletCurrencyUI.b(this.qGP) == null) || (!WalletSwitchWalletCurrencyUI.b(this.qGP).field_wallet_tpa_country.equals(paramView.field_wallet_tpa_country))))
    {
      WalletSwitchWalletCurrencyUI.b(this.qGP, paramView);
      paramAdapterView = this.qGP;
      paramView = paramView.field_wallet_tpa_country;
      y.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doSetUserWallet walletid = " + paramView);
      paramAdapterView.a(new com.tencent.mm.plugin.wallet_core.c.p(paramView), true, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSwitchWalletCurrencyUI.1
 * JD-Core Version:    0.7.0.1
 */