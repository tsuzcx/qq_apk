package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class WalletRealNameVerifyUI$1
  implements View.OnClickListener
{
  WalletRealNameVerifyUI$1(WalletRealNameVerifyUI paramWalletRealNameVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.qse.mController.uMN, WalletSelectProfessionUI.class);
    paramView.putExtra("key_profession_list", WalletRealNameVerifyUI.a(this.qse));
    this.qse.startActivityForResult(paramView, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.1
 * JD-Core Version:    0.7.0.1
 */