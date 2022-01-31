package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.ad;

final class WalletPayUI$2
  implements View.OnClickListener
{
  WalletPayUI$2(WalletPayUI paramWalletPayUI) {}
  
  public final void onClick(View paramView)
  {
    int j = 0;
    AppMethodBeat.i(46035);
    s.cRG();
    int i;
    if (s.cRH().cUm())
    {
      if (this.tXq.mPayInfo == null)
      {
        i = 0;
        if (this.tXq.mPayInfo != null) {
          break label141;
        }
        paramView = "";
        label45:
        ad.e(i, paramView, 6, "");
      }
    }
    else
    {
      if (this.tXq.qrf.ujn != 1) {
        break label183;
      }
      s.cRG();
      if (s.cRH().cUm())
      {
        if (this.tXq.mPayInfo != null) {
          break label155;
        }
        i = j;
        label93:
        if (this.tXq.mPayInfo != null) {
          break label169;
        }
      }
    }
    label141:
    label155:
    label169:
    for (paramView = "";; paramView = this.tXq.mPayInfo.cnI)
    {
      ad.e(i, paramView, 5, "");
      WalletPayUI.f(this.tXq);
      AppMethodBeat.o(46035);
      return;
      i = this.tXq.mPayInfo.cCD;
      break;
      paramView = this.tXq.mPayInfo.cnI;
      break label45;
      i = this.tXq.mPayInfo.cCD;
      break label93;
    }
    label183:
    ab.i(this.tXq.TAG, "SimpleReg , assigned userinfo pay! payWithNewBankcard");
    s.cRG();
    if (s.cRH().cUm())
    {
      if (this.tXq.mPayInfo != null) {
        break label258;
      }
      i = 0;
      if (this.tXq.mPayInfo != null) {
        break label272;
      }
    }
    label258:
    label272:
    for (paramView = "";; paramView = this.tXq.mPayInfo.cnI)
    {
      ad.e(i, paramView, 5, "");
      this.tXq.b(false, 0, "");
      AppMethodBeat.o(46035);
      return;
      i = this.tXq.mPayInfo.cCD;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.2
 * JD-Core Version:    0.7.0.1
 */