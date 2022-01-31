package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class WalletCardElementUI$16
  implements View.OnClickListener
{
  WalletCardElementUI$16(WalletCardElementUI paramWalletCardElementUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.qCj.mController.uMN, WalletSelectProfessionUI.class);
    paramView.putExtra("key_profession_list", WalletCardElementUI.o(this.qCj));
    this.qCj.startActivityForResult(paramView, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.16
 * JD-Core Version:    0.7.0.1
 */