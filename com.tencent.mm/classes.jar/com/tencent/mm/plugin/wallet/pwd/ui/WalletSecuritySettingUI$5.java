package com.tencent.mm.plugin.wallet.pwd.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.as.p.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.s;

final class WalletSecuritySettingUI$5
  implements p.a
{
  WalletSecuritySettingUI$5(WalletSecuritySettingUI paramWalletSecuritySettingUI, IconPreference paramIconPreference) {}
  
  public final void h(String paramString, Bitmap paramBitmap)
  {
    y.i("MicroMsg.WalletSecuritySettingUI", "alvinluo icon url: %s", new Object[] { paramString });
    this.qqc.drawable = new BitmapDrawable(this.qqb.mController.uMN.getResources(), paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.5
 * JD-Core Version:    0.7.0.1
 */