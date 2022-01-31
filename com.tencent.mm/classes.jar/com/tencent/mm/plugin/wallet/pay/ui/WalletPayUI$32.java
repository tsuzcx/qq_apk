package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletPayUI$32
  implements View.OnClickListener
{
  WalletPayUI$32(WalletPayUI paramWalletPayUI, CheckedTextView paramCheckedTextView1, CheckedTextView paramCheckedTextView2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46074);
    this.tXx.setChecked(false);
    this.tXy.setChecked(true);
    WalletPayUI.a(this.tXq, true);
    WalletPayUI.e(this.tXq);
    AppMethodBeat.o(46074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.32
 * JD-Core Version:    0.7.0.1
 */