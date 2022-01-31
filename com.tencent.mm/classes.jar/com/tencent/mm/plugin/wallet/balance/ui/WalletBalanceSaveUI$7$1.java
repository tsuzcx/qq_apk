package com.tencent.mm.plugin.wallet.balance.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;

final class WalletBalanceSaveUI$7$1
  implements Runnable
{
  WalletBalanceSaveUI$7$1(WalletBalanceSaveUI.7 param7, Bitmap paramBitmap) {}
  
  public final void run()
  {
    if ((this.qhB.qhx.qgs != null) && (this.qhB.qgW != null) && (this.qhB.qgW.getTag() != null) && (this.qhB.qgW.getTag().equals(this.qhB.qhx.qgs.field_bindSerial))) {
      this.qhB.qgW.setImageBitmap(this.ara);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.7.1
 * JD-Core Version:    0.7.0.1
 */