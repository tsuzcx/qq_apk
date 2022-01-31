package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;

final class WalletBankcardManageUI$7
  implements View.OnClickListener
{
  WalletBankcardManageUI$7(WalletBankcardManageUI paramWalletBankcardManageUI, f paramf) {}
  
  public final void onClick(View paramView)
  {
    paramView = new rc();
    paramView.caq.userName = this.qkm.qub;
    paramView.caq.cas = bk.aM(this.qkm.quc, "");
    paramView.caq.scene = 1071;
    paramView.caq.cat = 0;
    a.udP.m(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.7
 * JD-Core Version:    0.7.0.1
 */