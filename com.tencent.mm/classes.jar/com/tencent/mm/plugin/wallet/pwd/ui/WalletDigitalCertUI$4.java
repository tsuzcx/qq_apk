package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.ui.d;

final class WalletDigitalCertUI$4
  extends d
{
  WalletDigitalCertUI$4(WalletDigitalCertUI paramWalletDigitalCertUI) {}
  
  public final void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof x))
    {
      paramView = (x)paramView.getTag();
      h.a(this.qoE, this.qoE.getString(a.i.wallet_password_setting_digitalcert_del_alert, new Object[] { paramView.tVv }), "", this.qoE.getString(a.i.app_delete), this.qoE.getString(a.i.app_cancel), true, new WalletDigitalCertUI.4.1(this, paramView), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.4
 * JD-Core Version:    0.7.0.1
 */