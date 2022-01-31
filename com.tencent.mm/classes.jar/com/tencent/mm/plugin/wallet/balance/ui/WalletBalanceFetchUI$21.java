package com.tencent.mm.plugin.wallet.balance.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.sdk.platformtools.al;

final class WalletBalanceFetchUI$21
  implements x.a
{
  WalletBalanceFetchUI$21(WalletBalanceFetchUI paramWalletBalanceFetchUI, ImageView paramImageView) {}
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(45382);
    al.d(new WalletBalanceFetchUI.21.1(this, paramBitmap));
    AppMethodBeat.o(45382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.21
 * JD-Core Version:    0.7.0.1
 */