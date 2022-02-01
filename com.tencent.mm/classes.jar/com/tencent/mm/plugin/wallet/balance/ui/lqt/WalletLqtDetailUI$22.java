package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bsy;
import com.tencent.mm.sdk.platformtools.ad;

final class WalletLqtDetailUI$22
  implements View.OnClickListener
{
  WalletLqtDetailUI$22(WalletLqtDetailUI paramWalletLqtDetailUI, bsy parambsy) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68811);
    ad.i("MicroMsg.WalletLqtDetailUI", "go to lqt auto charge home");
    Object localObject = new Intent(this.zIT.getContext(), WalletLqtBalanceAutoTransferUI.class);
    paramView = this.zIT;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    h.vKh.f(16807, new Object[] { Integer.valueOf(2), Integer.valueOf(1), "", "", Integer.valueOf(this.zJb.DPY) });
    AppMethodBeat.o(68811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.22
 * JD-Core Version:    0.7.0.1
 */