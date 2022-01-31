package com.tencent.mm.plugin.wallet.pwd.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.p.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.IconPreference;
import java.util.Map;

final class WalletSecuritySettingUI$7
  implements p.a
{
  WalletSecuritySettingUI$7(WalletSecuritySettingUI paramWalletSecuritySettingUI, IconPreference paramIconPreference) {}
  
  public final void i(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(46399);
    ab.i("MicroMsg.WalletSecuritySettingUI", "alvinluo icon url: %s", new Object[] { paramString });
    this.uaB.drawable = new BitmapDrawable(this.uaz.getContext().getResources(), paramBitmap);
    WalletSecuritySettingUI.b(this.uaz).remove(paramString);
    AppMethodBeat.o(46399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.7
 * JD-Core Version:    0.7.0.1
 */