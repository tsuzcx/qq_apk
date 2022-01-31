package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.l;
import java.util.HashMap;

final class WalletLqtSaveFetchUI$2$1$1
  implements Runnable
{
  WalletLqtSaveFetchUI$2$1$1(WalletLqtSaveFetchUI.2.1 param1, String paramString, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(142310);
    ab.i("MicroMsg.WalletLqtSaveFetchUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { this.pnT, this.tSb.pnQ });
    if (WalletLqtSaveFetchUI.l(this.tSb.tSa.tRZ).containsKey(this.pnT))
    {
      int i = ((Integer)WalletLqtSaveFetchUI.l(this.tSb.tSa.tRZ).get(this.pnT)).intValue();
      if ((i < this.tSb.pnR.size()) && (this.tSb.pnR.getItem(i) != null))
      {
        this.tSb.pnR.getItem(i).setIcon(new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a(this.val$bitmap, this.tSb.tSa.tRZ.getResources().getDimensionPixelOffset(2131428824), this.tSb.tSa.tRZ.getResources().getDimensionPixelOffset(2131428824), true, false)));
        this.tSb.tSa.gEx.dPa();
      }
    }
    AppMethodBeat.o(142310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.2.1.1
 * JD-Core Version:    0.7.0.1
 */