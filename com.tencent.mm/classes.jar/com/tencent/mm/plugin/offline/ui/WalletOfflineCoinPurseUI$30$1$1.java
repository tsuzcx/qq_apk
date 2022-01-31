package com.tencent.mm.plugin.offline.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MenuItem;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;

final class WalletOfflineCoinPurseUI$30$1$1
  implements Runnable
{
  WalletOfflineCoinPurseUI$30$1$1(WalletOfflineCoinPurseUI.30.1 param1, String paramString, Bitmap paramBitmap) {}
  
  public final void run()
  {
    y.i("MicroMsg.WalletOfflineCoinPurseUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { this.mNE, this.mNF.mNB });
    if (WalletOfflineCoinPurseUI.L(this.mNF.mND.mNj).containsKey(this.mNE))
    {
      int i = ((Integer)WalletOfflineCoinPurseUI.L(this.mNF.mND.mNj).get(this.mNE)).intValue();
      if (this.mNF.mNC.getItem(i) != null)
      {
        this.mNF.mNC.getItem(i).setIcon(new BitmapDrawable(c.a(this.ara, this.mNF.mND.mNj.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), this.mNF.mND.mNj.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false)));
        this.mNF.mND.fnd.cKf();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.30.1.1
 * JD-Core Version:    0.7.0.1
 */