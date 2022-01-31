package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.g.d.a;

final class WalletLqtDetailUI$1
  implements d.a
{
  WalletLqtDetailUI$1(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void aE(Object paramObject)
  {
    if (WalletLqtDetailUI.a(this.qil) != null) {
      WalletLqtDetailUI.a(this.qil).dismiss();
    }
    y.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed: %s", new Object[] { paramObject });
    if (paramObject != null) {
      if (!(paramObject instanceof String)) {
        break label64;
      }
    }
    label64:
    for (paramObject = paramObject.toString();; paramObject = this.qil.getString(a.i.wallet_lqt_network_error))
    {
      Toast.makeText(this.qil, paramObject, 1).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.1
 * JD-Core Version:    0.7.0.1
 */