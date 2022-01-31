package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MenuItem;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;

final class WalletLqtSaveFetchUI$16$1
  implements x.a
{
  WalletLqtSaveFetchUI$16$1(WalletLqtSaveFetchUI.16 param16, String paramString, l paraml) {}
  
  public final void l(final String paramString, final Bitmap paramBitmap)
  {
    ai.d(new Runnable()
    {
      public final void run()
      {
        y.i("MicroMsg.WalletLqtSaveFetchUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramString, WalletLqtSaveFetchUI.16.1.this.mNB });
        if (WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.16.1.this.qjj.qiZ).containsKey(paramString))
        {
          int i = ((Integer)WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.16.1.this.qjj.qiZ).get(paramString)).intValue();
          if (WalletLqtSaveFetchUI.16.1.this.mNC.getItem(i) != null)
          {
            WalletLqtSaveFetchUI.16.1.this.mNC.getItem(i).setIcon(new BitmapDrawable(c.a(paramBitmap, WalletLqtSaveFetchUI.16.1.this.qjj.qiZ.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), WalletLqtSaveFetchUI.16.1.this.qjj.qiZ.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false)));
            WalletLqtSaveFetchUI.16.1.this.qjj.fnd.cKf();
          }
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.16.1
 * JD-Core Version:    0.7.0.1
 */