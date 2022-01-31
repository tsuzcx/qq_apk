package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletPayUI$28
  implements View.OnClickListener
{
  WalletPayUI$28(WalletPayUI paramWalletPayUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46066);
    if (this.tXq.tWJ) {
      this.tXq.tWS.setImageResource(2130839890);
    }
    for (this.tXq.tWJ = false;; this.tXq.tWJ = true)
    {
      this.tXq.tWW.notifyDataSetChanged();
      AppMethodBeat.o(46066);
      return;
      this.tXq.tWS.setImageResource(2130839893);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.28
 * JD-Core Version:    0.7.0.1
 */