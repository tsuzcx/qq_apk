package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WalletSecuritySettingUI$2
  implements View.OnClickListener
{
  WalletSecuritySettingUI$2(WalletSecuritySettingUI paramWalletSecuritySettingUI) {}
  
  public final void onClick(View paramView)
  {
    if ((WalletSecuritySettingUI.a(this.qqb) != null) && (bk.bl(WalletSecuritySettingUI.a(this.qqb).qqd))) {
      y.e("MicroMsg.WalletSecuritySettingUI", "alivnluo jump h5 url is null");
    }
    do
    {
      return;
      if ((WalletSecuritySettingUI.a(this.qqb) != null) && (WalletSecuritySettingUI.a(this.qqb).jumpType == 1) && (!bk.bl(WalletSecuritySettingUI.a(this.qqb).qqd)))
      {
        paramView = new Intent();
        y.i("MicroMsg.WalletSecuritySettingUI", "alvinluo jump url: %s", new Object[] { WalletSecuritySettingUI.a(this.qqb).qqd });
        paramView.putExtra("rawUrl", WalletSecuritySettingUI.a(this.qqb).qqd);
        d.b(this.qqb, "webview", ".ui.tools.WebViewUI", paramView);
        return;
      }
    } while ((WalletSecuritySettingUI.a(this.qqb) == null) || (WalletSecuritySettingUI.a(this.qqb).jumpType != 2));
    bk.bl(WalletSecuritySettingUI.a(this.qqb).qqe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.2
 * JD-Core Version:    0.7.0.1
 */