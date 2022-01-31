package com.tencent.mm.plugin.wallet.balance.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;

final class WalletBalanceFetchUI$17$1
  implements Runnable
{
  WalletBalanceFetchUI$17$1(WalletBalanceFetchUI.17 param17, Bitmap paramBitmap) {}
  
  public final void run()
  {
    if ((WalletBalanceFetchUI.a(this.qgX.qgO) != null) && (this.qgX.qgW != null) && (this.qgX.qgW.getTag() != null) && (this.qgX.qgW.getTag().equals(WalletBalanceFetchUI.a(this.qgX.qgO).field_bindSerial))) {
      this.qgX.qgW.setImageBitmap(this.ara);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.17.1
 * JD-Core Version:    0.7.0.1
 */