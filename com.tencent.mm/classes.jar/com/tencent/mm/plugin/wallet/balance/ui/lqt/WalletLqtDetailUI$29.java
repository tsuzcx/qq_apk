package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.sdk.platformtools.Log;

final class WalletLqtDetailUI$29
  implements View.OnClickListener
{
  WalletLqtDetailUI$29(WalletLqtDetailUI paramWalletLqtDetailUI, ctg paramctg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68810);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    Log.i("MicroMsg.WalletLqtDetailUI", "go to lqt plan home");
    localObject = new Intent(this.Hyi.getContext(), WalletLqtPlanBeforeHomeUI.class);
    paramView = this.Hyi;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    h.CyF.a(16807, new Object[] { Integer.valueOf(2), Integer.valueOf(1), "", "", Integer.valueOf(this.Hyk.Myf) });
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.29
 * JD-Core Version:    0.7.0.1
 */