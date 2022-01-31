package com.tencent.mm.plugin.wallet.pwd.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.p.a;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletBalancePrivacyMMHeaderPreference$1
  implements p.a
{
  WalletBalancePrivacyMMHeaderPreference$1(WalletBalancePrivacyMMHeaderPreference paramWalletBalancePrivacyMMHeaderPreference, ImageView paramImageView) {}
  
  public final void i(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(46207);
    ab.i("MicroMsg.WalletBalancePrivacyMMHeaderPreference", "alvinluo icon url: %s", new Object[] { paramString });
    this.tYp.setImageBitmap(paramBitmap);
    AppMethodBeat.o(46207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyMMHeaderPreference.1
 * JD-Core Version:    0.7.0.1
 */