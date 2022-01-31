package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.ui.t;
import com.tencent.mm.wallet_core.c.ad;

final class WalletPayUI$29
  extends t
{
  WalletPayUI$29(WalletPayUI paramWalletPayUI) {}
  
  public final void bhX()
  {
    AppMethodBeat.i(46067);
    s.cRG();
    int i;
    if (!s.cRH().cUm())
    {
      if (this.tXq.mPayInfo != null) {
        break label65;
      }
      i = 0;
      if (this.tXq.mPayInfo != null) {
        break label79;
      }
    }
    label65:
    label79:
    for (String str = "";; str = this.tXq.mPayInfo.cnI)
    {
      ad.e(i, str, 6, "");
      this.tXq.cSf();
      AppMethodBeat.o(46067);
      return;
      i = this.tXq.mPayInfo.cCD;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.29
 * JD-Core Version:    0.7.0.1
 */