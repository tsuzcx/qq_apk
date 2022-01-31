package com.tencent.mm.plugin.wallet_core.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.l;
import java.util.HashMap;

final class h$1$1$1
  implements Runnable
{
  h$1$1$1(h.1.1 param1, String paramString, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(47154);
    ab.i("MicroMsg.WalletBankcardBottomSheetHelper", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { this.pnT, this.unf.und });
    if (this.unf.une.umY.containsKey(this.pnT))
    {
      int i = ((Integer)this.unf.une.umY.get(this.pnT)).intValue();
      if (this.unf.pnR.getItem(i) != null)
      {
        this.unf.pnR.getItem(i).setIcon(new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a(this.val$bitmap, ah.getResources().getDimensionPixelOffset(2131428824), ah.getResources().getDimensionPixelOffset(2131428824), true, false)));
        this.unf.une.umZ.dPa();
      }
    }
    AppMethodBeat.o(47154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.h.1.1.1
 * JD-Core Version:    0.7.0.1
 */