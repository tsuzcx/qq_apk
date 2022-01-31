package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.picker.a;

final class WalletCardElementUI$17
  implements View.OnClickListener
{
  WalletCardElementUI$17(WalletCardElementUI paramWalletCardElementUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new a(this.qCj.mController.uMN);
    paramView.woo = new WalletCardElementUI.17.1(this, paramView);
    if ((WalletCardElementUI.q(this.qCj) > 0) && (WalletCardElementUI.r(this.qCj) > 0) && (WalletCardElementUI.s(this.qCj) > 0)) {
      paramView.ao(WalletCardElementUI.q(this.qCj), WalletCardElementUI.r(this.qCj), WalletCardElementUI.s(this.qCj));
    }
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.17
 * JD-Core Version:    0.7.0.1
 */