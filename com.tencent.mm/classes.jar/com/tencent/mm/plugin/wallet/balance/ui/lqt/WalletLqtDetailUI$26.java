package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.protocal.protobuf.dtx;
import com.tencent.mm.protocal.protobuf.ekd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.ui.i;

final class WalletLqtDetailUI$26
  implements View.OnClickListener
{
  WalletLqtDetailUI$26(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(316461);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    Log.i("MicroMsg.WalletLqtDetailUI", "click security entry, url type is : %d", new Object[] { Integer.valueOf(WalletLqtDetailUI.d(this.VeZ).abpj.aaZv) });
    com.tencent.mm.plugin.report.service.h.OAn.b(17084, new Object[] { Integer.valueOf(21) });
    if (WalletLqtDetailUI.d(this.VeZ).abpj.aaZv == 2)
    {
      paramView = WalletLqtDetailUI.d(this.VeZ).abpj.Krl;
      Log.i("MicroMsg.WalletLqtDetailUI", "jump to h5 with url : %s", new Object[] { paramView });
      i.o(this.VeZ, paramView, false);
    }
    for (;;)
    {
      if (WalletLqtDetailUI.n(this.VeZ).getVisibility() == 0)
      {
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adgD, Integer.valueOf(-1));
        Log.i("MicroMsg.WalletLqtDetailUI", "report click security reddot");
        com.tencent.mm.plugin.report.service.h.OAn.b(17084, new Object[] { Integer.valueOf(23) });
      }
      a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(316461);
      return;
      if (WalletLqtDetailUI.d(this.VeZ).abpj.aaZv == 3)
      {
        paramView = WalletLqtDetailUI.d(this.VeZ).abpj.YYZ;
        localObject = WalletLqtDetailUI.d(this.VeZ).abpj.Krl;
        Log.i("MicroMsg.WalletLqtDetailUI", "jump to tinyapp with username : %s, path : %s", new Object[] { paramView, localObject });
        i.y(paramView, (String)localObject, 0, 1061);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.26
 * JD-Core Version:    0.7.0.1
 */