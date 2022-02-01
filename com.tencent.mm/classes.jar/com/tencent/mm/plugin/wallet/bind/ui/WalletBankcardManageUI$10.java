package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.wallet_core.ui.f;
import java.util.Date;

final class WalletBankcardManageUI$10
  implements View.OnClickListener
{
  final int HDz = 1000;
  
  WalletBankcardManageUI$10(WalletBankcardManageUI paramWalletBankcardManageUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69110);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    if (paramView.getId() == 2131310195)
    {
      paramView = com.tencent.mm.plugin.wallet_core.model.g.fQl();
      if (paramView.bJw())
      {
        com.tencent.mm.ui.base.h.c(this.HDv, paramView.ANp, this.HDv.getString(2131755998), true);
        a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69110);
        return;
      }
      f.aqm(19);
      this.HDv.fOa();
      com.tencent.mm.plugin.report.service.h.CyF.a(14422, new Object[] { Integer.valueOf(2) });
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(69110);
      return;
      if (paramView.getId() == 2131310199)
      {
        localObject = paramView.getTag();
        long l = new Date().getTime();
        paramView.setTag(Long.valueOf(l));
        if ((localObject != null) && (l - ((Long)localObject).longValue() < 1000L))
        {
          a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69110);
          return;
        }
        paramView = new Intent();
        paramView.putExtra(e.p.OzJ, true);
        paramView.putExtra("rawUrl", WalletBankcardManageUI.a(this.HDv).field_loan_jump_url);
        f.aA(this.HDv.getContext(), paramView);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NVW, Integer.valueOf(WalletBankcardManageUI.a(this.HDv).field_red_dot_index));
        f.aqm(6);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.10
 * JD-Core Version:    0.7.0.1
 */