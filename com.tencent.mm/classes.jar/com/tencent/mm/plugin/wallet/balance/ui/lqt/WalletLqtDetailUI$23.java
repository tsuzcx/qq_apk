package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.ccg;
import com.tencent.mm.sdk.platformtools.ad;

final class WalletLqtDetailUI$23
  implements View.OnClickListener
{
  WalletLqtDetailUI$23(WalletLqtDetailUI paramWalletLqtDetailUI, ccg paramccg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68810);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    ad.i("MicroMsg.WalletLqtDetailUI", "go to lqt plan home");
    localObject = new Intent(this.CBs.getContext(), WalletLqtPlanBeforeHomeUI.class);
    paramView = this.CBs;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    g.yhR.f(16807, new Object[] { Integer.valueOf(2), Integer.valueOf(1), "", "", Integer.valueOf(this.CBu.GVY) });
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.23
 * JD-Core Version:    0.7.0.1
 */