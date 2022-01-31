package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletPayUI$31
  implements View.OnClickListener
{
  WalletPayUI$31(WalletPayUI paramWalletPayUI, CheckedTextView paramCheckedTextView1, CheckedTextView paramCheckedTextView2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46073);
    this.tXx.setChecked(true);
    this.tXy.setChecked(false);
    WalletPayUI.a(this.tXq, false);
    WalletPayUI.e(this.tXq);
    AppMethodBeat.o(46073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.31
 * JD-Core Version:    0.7.0.1
 */