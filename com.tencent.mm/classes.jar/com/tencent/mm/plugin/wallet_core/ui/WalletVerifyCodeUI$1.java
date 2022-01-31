package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.ui.widget.b.c.a;

final class WalletVerifyCodeUI$1
  implements View.OnClickListener
{
  WalletVerifyCodeUI$1(WalletVerifyCodeUI paramWalletVerifyCodeUI, Bankcard paramBankcard) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47691);
    paramView = this.uul.getProcess();
    int i;
    if ((WalletVerifyCodeUI.a(this.uul)) && (paramView != null) && ("PayProcess".equals(paramView.bzC())))
    {
      if (this.tNr == null) {
        break label230;
      }
      if (this.tNr.cTf()) {
        i = 1;
      }
    }
    for (;;)
    {
      paramView = new c.a(this.uul.getContext());
      paramView.Rb(2131305690);
      paramView.avn(this.uul.getString(2131305689, new Object[] { this.uul.cWa() }));
      paramView.rG(true);
      paramView.Ri(2131305688);
      paramView.Rj(2131305687);
      paramView.a(new WalletVerifyCodeUI.1.1(this, i));
      paramView.b(new WalletVerifyCodeUI.1.2(this, i));
      paramView.aLZ().show();
      h.qsU.e(15443, new Object[] { Integer.valueOf(1) });
      WalletVerifyCodeUI.b(this.uul);
      AppMethodBeat.o(47691);
      return;
      if (this.tNr.cTg())
      {
        i = 3;
      }
      else
      {
        i = 2;
        continue;
        this.uul.cWb();
        AppMethodBeat.o(47691);
        return;
        label230:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.1
 * JD-Core Version:    0.7.0.1
 */