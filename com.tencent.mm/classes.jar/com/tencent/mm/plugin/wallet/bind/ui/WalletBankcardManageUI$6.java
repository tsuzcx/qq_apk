package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBankcardManageUI$6
  implements View.OnClickListener
{
  WalletBankcardManageUI$6(WalletBankcardManageUI paramWalletBankcardManageUI, f paramf) {}
  
  public final void onClick(View paramView)
  {
    if (!bk.bl(this.qkm.qtZ)) {
      e.l(this.qkk.mController.uMN, this.qkm.qtZ, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.6
 * JD-Core Version:    0.7.0.1
 */