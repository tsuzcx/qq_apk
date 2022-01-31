package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.bq.d;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.wallet.balance.a.a.l;
import com.tencent.mm.plugin.wallet_core.model.j;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.g;

final class WalletBalanceManagerUI$5
  implements View.OnClickListener
{
  WalletBalanceManagerUI$5(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(142283);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBalanceManagerUI", "click action entry");
    if (WalletBalanceManagerUI.f(this.tOJ).type == 1)
    {
      if (bo.isNullOrNil(WalletBalanceManagerUI.f(this.tOJ).ugX))
      {
        AppMethodBeat.o(142283);
        return;
      }
      if (WalletBalanceManagerUI.f(this.tOJ).ugX.startsWith("weixin://wcpay/lqt/detail"))
      {
        com.tencent.mm.plugin.wallet.balance.a.a.ab.parseUrl(WalletBalanceManagerUI.f(this.tOJ).ugX);
        paramView = new Intent();
        paramView.putExtra("key_account_type", 1);
        d.b(this.tOJ.getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramView);
        AppMethodBeat.o(142283);
        return;
      }
      if (WalletBalanceManagerUI.f(this.tOJ).ugX.startsWith("weixin://wcpay/lqt/save"))
      {
        com.tencent.mm.plugin.wallet.balance.a.a.ab.parseUrl(WalletBalanceManagerUI.f(this.tOJ).ugX);
        paramView = com.tencent.mm.plugin.wallet.balance.a.a.ab.aeQ(WalletBalanceManagerUI.f(this.tOJ).ugX);
        final Dialog localDialog = g.c(this.tOJ.getContext(), false, null);
        new l().adl().b(new a() {});
        AppMethodBeat.o(142283);
      }
    }
    else
    {
      if (WalletBalanceManagerUI.f(this.tOJ).type == 2)
      {
        e.m(this.tOJ.getContext(), WalletBalanceManagerUI.f(this.tOJ).kXd, true);
        AppMethodBeat.o(142283);
        return;
      }
      if (WalletBalanceManagerUI.f(this.tOJ).type == 3)
      {
        e.q(WalletBalanceManagerUI.f(this.tOJ).ugY, WalletBalanceManagerUI.f(this.tOJ).ugZ, 0, 1061);
        AppMethodBeat.o(142283);
        return;
      }
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.WalletBalanceManagerUI", "unknown type: %s", new Object[] { Integer.valueOf(WalletBalanceManagerUI.f(this.tOJ).type) });
    }
    AppMethodBeat.o(142283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.5
 * JD-Core Version:    0.7.0.1
 */