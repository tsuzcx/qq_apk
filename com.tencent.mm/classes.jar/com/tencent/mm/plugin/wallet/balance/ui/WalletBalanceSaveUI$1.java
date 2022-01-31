package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletBalanceSaveUI$1
  implements View.OnClickListener
{
  WalletBalanceSaveUI$1(WalletBalanceSaveUI paramWalletBalanceSaveUI) {}
  
  public final void onClick(View paramView)
  {
    this.qhx.nzU = bk.getDouble(this.qhx.iKG.getText(), 0.0D);
    if ((this.qhx.nzU > 0.0D) && (this.qhx.iKG.YL()))
    {
      this.qhx.bTt();
      return;
    }
    com.tencent.mm.ui.base.s.makeText(this.qhx.mController.uMN, a.i.wallet_balance_save_input_invalid, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.1
 * JD-Core Version:    0.7.0.1
 */