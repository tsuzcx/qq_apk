package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.picker.b;

final class WalletCardElementUI$13
  implements View.OnClickListener
{
  WalletCardElementUI$13(WalletCardElementUI paramWalletCardElementUI, String[] paramArrayOfString) {}
  
  public final void onClick(View paramView)
  {
    paramView = new b(this.qCj.mController.uMN, this.qCl);
    paramView.wov = new WalletCardElementUI.13.1(this, paramView);
    paramView.IC(WalletCardElementUI.i(this.qCj));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.13
 * JD-Core Version:    0.7.0.1
 */