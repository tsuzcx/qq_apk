package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_core.model.n.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WalletBindCardResultUI$5
  implements View.OnClickListener
{
  WalletBindCardResultUI$5(WalletBindCardResultUI paramWalletBindCardResultUI) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.WalletBindCardResultUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[] { WalletBindCardResultUI.c(this.qBf), WalletBindCardResultUI.d(this.qBf), Integer.valueOf(WalletBindCardResultUI.e(this.qBf)) });
    this.qBf.hD(2);
    paramView = new rc();
    paramView.caq.userName = WalletBindCardResultUI.c(this.qBf);
    paramView.caq.cas = bk.aM(WalletBindCardResultUI.d(this.qBf), "");
    paramView.caq.scene = 1034;
    paramView.caq.cat = 0;
    if (WalletBindCardResultUI.e(this.qBf) > 0) {
      paramView.caq.cau = WalletBindCardResultUI.e(this.qBf);
    }
    a.udP.m(paramView);
    if ((!bk.bl(WalletBindCardResultUI.f(this.qBf).qut.qwu)) && (WalletBindCardResultUI.f(this.qBf).qur.qqG > 0L))
    {
      WalletBindCardResultUI.a(this.qBf, true);
      return;
    }
    WalletBindCardResultUI.a(this.qBf, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI.5
 * JD-Core Version:    0.7.0.1
 */