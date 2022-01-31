package com.tencent.mm.plugin.wallet_core.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MenuItem;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;

final class f$1$1$1
  implements Runnable
{
  f$1$1$1(f.1.1 param1, String paramString, Bitmap paramBitmap) {}
  
  public final void run()
  {
    y.i("MicroMsg.WalletBankcardBottomSheetHelper", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { this.mNE, this.qAv.qAt });
    if (this.qAv.qAu.qAq.containsKey(this.mNE))
    {
      int i = ((Integer)this.qAv.qAu.qAq.get(this.mNE)).intValue();
      if (this.qAv.mNC.getItem(i) != null)
      {
        this.qAv.mNC.getItem(i).setIcon(new BitmapDrawable(c.a(this.ara, ae.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), ae.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false)));
        this.qAv.qAu.qAr.cKf();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.f.1.1.1
 * JD-Core Version:    0.7.0.1
 */