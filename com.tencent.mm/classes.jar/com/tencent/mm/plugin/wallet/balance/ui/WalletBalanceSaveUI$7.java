package com.tencent.mm.plugin.wallet.balance.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.sdk.platformtools.al;

final class WalletBalanceSaveUI$7
  implements x.a
{
  WalletBalanceSaveUI$7(WalletBalanceSaveUI paramWalletBalanceSaveUI, ImageView paramImageView) {}
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(45478);
    al.d(new WalletBalanceSaveUI.7.1(this, paramBitmap));
    AppMethodBeat.o(45478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.7
 * JD-Core Version:    0.7.0.1
 */