package com.tencent.mm.plugin.offline.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.d;

final class WalletOfflineCoinPurseUI$19
  implements Runnable
{
  WalletOfflineCoinPurseUI$19(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, Integer paramInteger, Bitmap paramBitmap, ImageView paramImageView) {}
  
  public final void run()
  {
    AppMethodBeat.i(43525);
    int i = this.pnO.intValue();
    Bitmap localBitmap = d.a(this.val$bitmap, i, i, true, false);
    this.kCm.setImageBitmap(localBitmap);
    AppMethodBeat.o(43525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.19
 * JD-Core Version:    0.7.0.1
 */