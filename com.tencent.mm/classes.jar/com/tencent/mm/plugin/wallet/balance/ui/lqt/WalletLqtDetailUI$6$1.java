package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;

final class WalletLqtDetailUI$6$1
  implements Runnable
{
  WalletLqtDetailUI$6$1(WalletLqtDetailUI.6 param6) {}
  
  public final void run()
  {
    if (WalletLqtDetailUI.a(this.qio.qil) != null) {
      WalletLqtDetailUI.a(this.qio.qil).dismiss();
    }
    Toast.makeText(this.qio.qil, this.qio.qil.getString(a.i.wallet_lqt_close_account_finish), 1).show();
    this.qio.qil.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.6.1
 * JD-Core Version:    0.7.0.1
 */