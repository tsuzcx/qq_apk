package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;

final class WalletLqtSaveFetchUI$15$1
  implements Runnable
{
  WalletLqtSaveFetchUI$15$1(WalletLqtSaveFetchUI.15 param15, Bitmap paramBitmap) {}
  
  public final void run()
  {
    if ((WalletLqtSaveFetchUI.d(this.qji.qiZ) != null) && (WalletLqtSaveFetchUI.e(this.qji.qiZ) != null) && (WalletLqtSaveFetchUI.e(this.qji.qiZ).getTag() != null) && (WalletLqtSaveFetchUI.e(this.qji.qiZ).getTag().equals(WalletLqtSaveFetchUI.d(this.qji.qiZ).field_bindSerial))) {
      WalletLqtSaveFetchUI.e(this.qji.qiZ).setImageBitmap(this.ara);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.15.1
 * JD-Core Version:    0.7.0.1
 */