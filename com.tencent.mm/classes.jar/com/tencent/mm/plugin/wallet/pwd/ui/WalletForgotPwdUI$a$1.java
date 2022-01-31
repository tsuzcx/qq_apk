package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

final class WalletForgotPwdUI$a$1
  implements View.OnClickListener
{
  WalletForgotPwdUI$a$1(WalletForgotPwdUI.a parama, Bankcard paramBankcard) {}
  
  public final void onClick(View paramView)
  {
    if ((this.qge != null) && (this.qge.field_bankcardState == 1))
    {
      paramView = new c.a(WalletForgotPwdUI.a.a(this.qoU));
      paramView.Iq(a.i.wallet_forget_pwd_expired_desc);
      paramView.Is(a.i.wallet_forget_pwd_expired_qa).a(new WalletForgotPwdUI.a.1.1(this));
      paramView.It(a.i.app_i_known);
      paramView.nW(false);
      paramView.aoP().show();
      return;
    }
    WalletForgotPwdUI.a(this.qoU.qoT, this.qge);
    WalletForgotPwdUI.a(this.qoU.qoT, false);
    WalletForgotPwdUI.a(this.qoU.qoT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.a.1
 * JD-Core Version:    0.7.0.1
 */