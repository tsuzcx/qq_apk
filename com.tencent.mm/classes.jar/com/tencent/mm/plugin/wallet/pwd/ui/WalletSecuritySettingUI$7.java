package com.tencent.mm.plugin.wallet.pwd.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.r.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.IconPreference;
import java.util.Map;

final class WalletSecuritySettingUI$7
  implements r.a
{
  WalletSecuritySettingUI$7(WalletSecuritySettingUI paramWalletSecuritySettingUI, IconPreference paramIconPreference) {}
  
  public final void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    AppMethodBeat.i(69796);
    ad.i("MicroMsg.WalletSecuritySettingUI", "alvinluo icon url: %s", new Object[] { paramString1 });
    this.CNM.drawable = new BitmapDrawable(this.CNK.getContext().getResources(), paramBitmap);
    WalletSecuritySettingUI.b(this.CNK).remove(paramString1);
    AppMethodBeat.o(69796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.7
 * JD-Core Version:    0.7.0.1
 */