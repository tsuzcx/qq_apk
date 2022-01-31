package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;

final class WalletForgotPwdUI$a$1
  implements View.OnClickListener
{
  WalletForgotPwdUI$a$1(WalletForgotPwdUI.a parama, Bankcard paramBankcard) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46283);
    if ((this.tNr != null) && (this.tNr.field_bankcardState == 1))
    {
      paramView = new c.a(WalletForgotPwdUI.a.a(this.tZh));
      paramView.Rf(2131305084);
      paramView.Ri(2131305085).a(new WalletForgotPwdUI.a.1.1(this));
      paramView.Rj(2131296977);
      paramView.rG(false);
      paramView.aLZ().show();
      AppMethodBeat.o(46283);
      return;
    }
    WalletForgotPwdUI.a(this.tZh.tZg, this.tNr);
    WalletForgotPwdUI.a(this.tZh.tZg, false);
    WalletForgotPwdUI.a(this.tZh.tZg);
    AppMethodBeat.o(46283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.a.1
 * JD-Core Version:    0.7.0.1
 */