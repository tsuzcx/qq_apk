package com.tencent.mm.plugin.offline.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.c;

final class WalletOfflineCoinPurseUI$19
  implements Runnable
{
  WalletOfflineCoinPurseUI$19(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, Integer paramInteger, Bitmap paramBitmap, ImageView paramImageView) {}
  
  public final void run()
  {
    int i = this.mNz.intValue();
    Bitmap localBitmap = c.a(this.ara, i, i, true, false);
    this.izf.setImageBitmap(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.19
 * JD-Core Version:    0.7.0.1
 */