package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class WalletRealNameVerifyUI$2
  implements View.OnClickListener
{
  WalletRealNameVerifyUI$2(WalletRealNameVerifyUI paramWalletRealNameVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("GetAddress", true);
    paramView.putExtra("ShowSelectedLocation", false);
    paramView.putExtra("IsRealNameVerifyScene", true);
    paramView.putExtra("IsNeedShowSearchBar", true);
    d.c(this.qse.mController.uMN, ".ui.tools.MultiStageCitySelectUI", paramView, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.2
 * JD-Core Version:    0.7.0.1
 */