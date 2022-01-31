package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;

final class WalletPayUI$31
  implements View.OnClickListener
{
  WalletPayUI$31(WalletPayUI paramWalletPayUI, CheckedTextView paramCheckedTextView1, CheckedTextView paramCheckedTextView2) {}
  
  public final void onClick(View paramView)
  {
    this.qoc.setChecked(false);
    this.qod.setChecked(true);
    WalletPayUI.a(this.qnV, true);
    WalletPayUI.e(this.qnV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.31
 * JD-Core Version:    0.7.0.1
 */