package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.picker.a;

final class WalletCardElementUI$14
  implements View.OnClickListener
{
  WalletCardElementUI$14(WalletCardElementUI paramWalletCardElementUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new a(this.qCj.mController.uMN);
    paramView.woo = new WalletCardElementUI.14.1(this, paramView);
    if ((WalletCardElementUI.k(this.qCj) > 0) && (WalletCardElementUI.l(this.qCj) > 0) && (WalletCardElementUI.m(this.qCj) > 0)) {
      paramView.ao(WalletCardElementUI.k(this.qCj), WalletCardElementUI.l(this.qCj), WalletCardElementUI.m(this.qCj));
    }
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.14
 * JD-Core Version:    0.7.0.1
 */