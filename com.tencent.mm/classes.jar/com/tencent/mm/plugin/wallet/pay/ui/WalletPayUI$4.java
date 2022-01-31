package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class WalletPayUI$4
  implements DialogInterface.OnClickListener
{
  WalletPayUI$4(WalletPayUI paramWalletPayUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46037);
    ab.i(this.tXq.TAG, "click continue pay");
    if ((this.tXq.mPayInfo != null) && (this.tXq.qrf != null) && (this.tXq.qrf.ujl != null) && (this.tXq.qrf.ujl.size() > 0))
    {
      if (this.tXq.mPayInfo.cCD != 8) {
        break label155;
      }
      h.qsU.e(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(3), ((Orders.Commodity)this.tXq.qrf.ujl.get(0)).cnJ });
    }
    for (;;)
    {
      WalletPayUI.g(this.tXq);
      AppMethodBeat.o(46037);
      return;
      label155:
      h.qsU.e(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), ((Orders.Commodity)this.tXq.qrf.ujl.get(0)).cnJ });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.4
 * JD-Core Version:    0.7.0.1
 */