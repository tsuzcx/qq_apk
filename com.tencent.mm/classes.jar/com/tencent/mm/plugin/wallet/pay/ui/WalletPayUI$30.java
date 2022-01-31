package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.c.ad;

final class WalletPayUI$30
  implements View.OnClickListener
{
  WalletPayUI$30(WalletPayUI paramWalletPayUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46072);
    int i;
    if (this.tXq.mPayInfo == null)
    {
      i = 0;
      if (this.tXq.mPayInfo != null) {
        break label96;
      }
    }
    label96:
    for (paramView = "";; paramView = this.tXq.mPayInfo.cnI)
    {
      ad.e(i, paramView, 12, "");
      l.a(this.tXq.getContext(), this.tXq.qrf, this.tXq.tVQ.uhU, new WalletPayUI.30.1(this), null);
      AppMethodBeat.o(46072);
      return;
      i = this.tXq.mPayInfo.cCD;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.30
 * JD-Core Version:    0.7.0.1
 */