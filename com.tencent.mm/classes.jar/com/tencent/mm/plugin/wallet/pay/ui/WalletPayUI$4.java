package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class WalletPayUI$4
  implements DialogInterface.OnClickListener
{
  WalletPayUI$4(WalletPayUI paramWalletPayUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.WalletPayUI", "click continue pay");
    if ((this.qnV.nDu != null) && (this.qnV.nEh != null) && (this.qnV.nEh.qwN != null) && (this.qnV.nEh.qwN.size() > 0))
    {
      if (this.qnV.nDu.bUV != 8) {
        break label140;
      }
      h.nFQ.f(15368, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(3), ((Orders.Commodity)this.qnV.nEh.qwN.get(0)).bMY });
    }
    for (;;)
    {
      WalletPayUI.g(this.qnV);
      return;
      label140:
      h.nFQ.f(15368, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), ((Orders.Commodity)this.qnV.nEh.qwN.get(0)).bMY });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.4
 * JD-Core Version:    0.7.0.1
 */