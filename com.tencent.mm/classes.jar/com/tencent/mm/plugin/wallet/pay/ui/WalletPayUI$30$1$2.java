package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletPayUI$30$1$2
  implements View.OnClickListener
{
  WalletPayUI$30$1$2(WalletPayUI.30.1 param1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46069);
    ab.i(this.tXw.tXv.tXq.TAG, "Balance amount not meet, after favor selection! payWithNewBankcard");
    this.tXw.tXv.tXq.b(false, 0, "");
    AppMethodBeat.o(46069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.30.1.2
 * JD-Core Version:    0.7.0.1
 */