package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBalanceManagerUI$8
  implements View.OnClickListener
{
  WalletBalanceManagerUI$8(WalletBalanceManagerUI paramWalletBalanceManagerUI, WalletBalanceManagerUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163862);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    switch (this.CzO.uxt)
    {
    default: 
      ad.i("MicroMsg.WalletBalanceManagerUI", "unknown entrance type");
    }
    for (;;)
    {
      e.agr(46);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163862);
      return;
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.CzO.ozD);
      paramView.putExtra("showShare", false);
      paramView.putExtra("geta8key_username", u.aAm());
      paramView.putExtra(e.m.IVa, true);
      e.an(this.CzL.getContext(), paramView);
      continue;
      paramView = new vm();
      paramView.dJF.userName = this.CzO.CzQ;
      paramView.dJF.dJH = this.CzO.CzR;
      paramView.dJF.scene = 1034;
      paramView.dJF.dJI = 0;
      com.tencent.mm.sdk.b.a.IbL.l(paramView);
      continue;
      if (this.CzO.ozD.equals("wxpay://lqp/balanceQuotaState"))
      {
        paramView = new Intent();
        d.b(this.CzL.getContext(), "wallet_ecard", ".ui.WalletECardLogoutUI", paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.8
 * JD-Core Version:    0.7.0.1
 */