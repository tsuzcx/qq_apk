package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;

final class WalletPayUI$30
  implements View.OnClickListener
{
  WalletPayUI$30(WalletPayUI paramWalletPayUI, CheckedTextView paramCheckedTextView1, CheckedTextView paramCheckedTextView2) {}
  
  public final void onClick(View paramView)
  {
    this.qoc.setChecked(true);
    this.qod.setChecked(false);
    WalletPayUI.a(this.qnV, false);
    WalletPayUI.e(this.qnV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.30
 * JD-Core Version:    0.7.0.1
 */