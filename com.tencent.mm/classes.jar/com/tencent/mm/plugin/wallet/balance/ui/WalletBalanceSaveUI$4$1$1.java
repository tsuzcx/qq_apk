package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.l;
import java.util.HashMap;

final class WalletBalanceSaveUI$4$1$1
  implements Runnable
{
  WalletBalanceSaveUI$4$1$1(WalletBalanceSaveUI.4.1 param1, String paramString, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(45472);
    ab.i("MicroMsg.WalletBalanceSaveUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { this.pnT, this.tOV.pnQ });
    if (WalletBalanceSaveUI.d(this.tOV.tOU.tOS).containsKey(this.pnT))
    {
      int i = ((Integer)WalletBalanceSaveUI.d(this.tOV.tOU.tOS).get(this.pnT)).intValue();
      if (this.tOV.pnR.getItem(i) != null)
      {
        this.tOV.pnR.getItem(i).setIcon(new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a(this.val$bitmap, this.tOV.tOU.tOS.getResources().getDimensionPixelOffset(2131428824), this.tOV.tOU.tOS.getResources().getDimensionPixelOffset(2131428824), true, false)));
        this.tOV.tOU.tOT.dPa();
      }
    }
    AppMethodBeat.o(45472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.4.1.1
 * JD-Core Version:    0.7.0.1
 */