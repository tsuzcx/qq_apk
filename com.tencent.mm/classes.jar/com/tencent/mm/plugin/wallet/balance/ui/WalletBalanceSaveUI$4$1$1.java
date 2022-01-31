package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MenuItem;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;
import java.util.HashMap;

final class WalletBalanceSaveUI$4$1$1
  implements Runnable
{
  WalletBalanceSaveUI$4$1$1(WalletBalanceSaveUI.4.1 param1, String paramString, Bitmap paramBitmap) {}
  
  public final void run()
  {
    y.i("MicroMsg.WalletBalanceSaveUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { this.mNE, this.qhA.mNB });
    if (WalletBalanceSaveUI.d(this.qhA.qhz.qhx).containsKey(this.mNE))
    {
      int i = ((Integer)WalletBalanceSaveUI.d(this.qhA.qhz.qhx).get(this.mNE)).intValue();
      if (this.qhA.mNC.getItem(i) != null)
      {
        this.qhA.mNC.getItem(i).setIcon(new BitmapDrawable(com.tencent.mm.sdk.platformtools.c.a(this.ara, this.qhA.qhz.qhx.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), this.qhA.qhz.qhx.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false)));
        this.qhA.qhz.qhy.cKf();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.4.1.1
 * JD-Core Version:    0.7.0.1
 */