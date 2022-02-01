package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.wallet_core.ui.f;

final class WalletBalanceManagerUI$8
  implements View.OnClickListener
{
  WalletBalanceManagerUI$8(WalletBalanceManagerUI paramWalletBalanceManagerUI, WalletBalanceManagerUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163862);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    switch (this.Hwp.uSc)
    {
    default: 
      Log.i("MicroMsg.WalletBalanceManagerUI", "unknown entrance type");
    }
    for (;;)
    {
      f.aqm(46);
      a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163862);
      return;
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.Hwp.pTL);
      paramView.putExtra("showShare", false);
      paramView.putExtra("geta8key_username", z.aTY());
      paramView.putExtra(e.p.OzJ, true);
      f.aA(this.Hwm.getContext(), paramView);
      continue;
      paramView = new wq();
      paramView.ecI.userName = this.Hwp.Hwr;
      paramView.ecI.ecK = this.Hwp.Hws;
      paramView.ecI.scene = 1034;
      paramView.ecI.ecL = 0;
      EventCenter.instance.publish(paramView);
      continue;
      if (this.Hwp.pTL.equals("wxpay://lqp/balanceQuotaState"))
      {
        paramView = new Intent();
        c.b(this.Hwm.getContext(), "wallet_ecard", ".ui.WalletECardLogoutUI", paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.8
 * JD-Core Version:    0.7.0.1
 */