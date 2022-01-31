package com.tencent.mm.plugin.offline.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.l;
import java.util.HashMap;

final class WalletOfflineCoinPurseUI$30$1$1
  implements Runnable
{
  WalletOfflineCoinPurseUI$30$1$1(WalletOfflineCoinPurseUI.30.1 param1, String paramString, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(43537);
    ab.i("MicroMsg.WalletOfflineCoinPurseUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { this.pnT, this.pnU.pnQ });
    if (WalletOfflineCoinPurseUI.K(this.pnU.pnS.pny).containsKey(this.pnT))
    {
      int i = ((Integer)WalletOfflineCoinPurseUI.K(this.pnU.pnS.pny).get(this.pnT)).intValue();
      if (this.pnU.pnR.getItem(i) != null)
      {
        this.pnU.pnR.getItem(i).setIcon(new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a(this.val$bitmap, this.pnU.pnS.pny.getResources().getDimensionPixelOffset(2131428824), this.pnU.pnS.pny.getResources().getDimensionPixelOffset(2131428824), true, false)));
        this.pnU.pnS.gEx.dPa();
      }
    }
    AppMethodBeat.o(43537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.30.1.1
 * JD-Core Version:    0.7.0.1
 */