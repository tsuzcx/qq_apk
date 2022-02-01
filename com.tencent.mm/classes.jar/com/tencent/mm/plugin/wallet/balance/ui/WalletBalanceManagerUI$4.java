package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.bs.d;
import com.tencent.mm.cn.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ae;
import com.tencent.mm.plugin.wallet.balance.model.lqt.o;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.g;

final class WalletBalanceManagerUI$4
  implements View.OnClickListener
{
  WalletBalanceManagerUI$4(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(163858);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    ad.i("MicroMsg.WalletBalanceManagerUI", "click action entry");
    if (WalletBalanceManagerUI.e(this.CzL).type == 1)
    {
      if (bt.isNullOrNil(WalletBalanceManagerUI.e(this.CzL).CVO))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163858);
        return;
      }
      if (WalletBalanceManagerUI.e(this.CzL).CVO.startsWith("weixin://wcpay/lqt/detail"))
      {
        ae.parseUrl(WalletBalanceManagerUI.e(this.CzL).CVO);
        paramView = new Intent();
        paramView.putExtra("key_account_type", 1);
        d.b(this.CzL.getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramView);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163858);
      return;
      if (WalletBalanceManagerUI.e(this.CzL).CVO.startsWith("weixin://wcpay/lqt/save"))
      {
        ae.parseUrl(WalletBalanceManagerUI.e(this.CzL).CVO);
        paramView = ae.aDR(WalletBalanceManagerUI.e(this.CzL).CVO);
        localObject = g.c(this.CzL.getContext(), false, null);
        new o().aED().b(new com.tencent.mm.vending.c.a() {});
        continue;
        if (WalletBalanceManagerUI.e(this.CzL).type == 2) {
          e.n(this.CzL.getContext(), WalletBalanceManagerUI.e(this.CzL).pkW, true);
        } else if (WalletBalanceManagerUI.e(this.CzL).type == 3) {
          e.v(WalletBalanceManagerUI.e(this.CzL).CVP, WalletBalanceManagerUI.e(this.CzL).CVQ, 0, 1061);
        } else {
          ad.w("MicroMsg.WalletBalanceManagerUI", "unknown type: %s", new Object[] { Integer.valueOf(WalletBalanceManagerUI.e(this.CzL).type) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.4
 * JD-Core Version:    0.7.0.1
 */