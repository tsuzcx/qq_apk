package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.sdk.platformtools.ac;

final class WalletLqtDetailUI$21
  implements View.OnClickListener
{
  WalletLqtDetailUI$21(WalletLqtDetailUI paramWalletLqtDetailUI, bxp parambxp) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68810);
    ac.i("MicroMsg.WalletLqtDetailUI", "go to lqt plan home");
    Object localObject = new Intent(this.Bbf.getContext(), WalletLqtPlanBeforeHomeUI.class);
    paramView = this.Bbf;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    h.wUl.f(16807, new Object[] { Integer.valueOf(2), Integer.valueOf(1), "", "", Integer.valueOf(this.Bbn.Fmp) });
    AppMethodBeat.o(68810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.21
 * JD-Core Version:    0.7.0.1
 */