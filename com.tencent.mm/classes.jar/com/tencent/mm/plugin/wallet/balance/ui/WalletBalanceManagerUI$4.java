package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.by.c;
import com.tencent.mm.cw.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ah;
import com.tencent.mm.plugin.wallet.balance.model.lqt.o;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.protocal.protobuf.dri;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.g;
import com.tencent.mm.wallet_core.ui.i;

final class WalletBalanceManagerUI$4
  implements View.OnClickListener
{
  WalletBalanceManagerUI$4(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(163858);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    Log.i("MicroMsg.WalletBalanceManagerUI", "click action entry");
    if (WalletBalanceManagerUI.e(this.OnZ).type == 1)
    {
      if (Util.isNullOrNil(WalletBalanceManagerUI.e(this.OnZ).OOM))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163858);
        return;
      }
      if (WalletBalanceManagerUI.e(this.OnZ).OOM.startsWith("weixin://wcpay/lqt/detail"))
      {
        ah.bgq(WalletBalanceManagerUI.e(this.OnZ).OOM);
        paramView = new Intent();
        paramView.putExtra("key_account_type", 1);
        c.b(this.OnZ.getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramView);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163858);
      return;
      if (WalletBalanceManagerUI.e(this.OnZ).OOM.startsWith("weixin://wcpay/lqt/save"))
      {
        ah.bgq(WalletBalanceManagerUI.e(this.OnZ).OOM);
        paramView = ah.bgr(WalletBalanceManagerUI.e(this.OnZ).OOM);
        localObject = i.c(this.OnZ.getContext(), false, null);
        new o().bhW().b(new com.tencent.mm.vending.c.a() {});
        continue;
        if (WalletBalanceManagerUI.e(this.OnZ).type == 2) {
          g.o(this.OnZ.getContext(), WalletBalanceManagerUI.e(this.OnZ).ugh, true);
        } else if (WalletBalanceManagerUI.e(this.OnZ).type == 3) {
          g.v(WalletBalanceManagerUI.e(this.OnZ).OON, WalletBalanceManagerUI.e(this.OnZ).OOO, 0, 1061);
        } else {
          Log.w("MicroMsg.WalletBalanceManagerUI", "unknown type: %s", new Object[] { Integer.valueOf(WalletBalanceManagerUI.e(this.OnZ).type) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.4
 * JD-Core Version:    0.7.0.1
 */