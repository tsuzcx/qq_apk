package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.protocal.protobuf.dcf;
import com.tencent.mm.protocal.protobuf.dri;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.ui.g;

final class WalletLqtDetailUI$22
  implements View.OnClickListener
{
  WalletLqtDetailUI$22(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(186592);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    Log.i("MicroMsg.WalletLqtDetailUI", "click security entry, url type is : %d", new Object[] { Integer.valueOf(WalletLqtDetailUI.d(this.OpW).TYr.TJG) });
    com.tencent.mm.plugin.report.service.h.IzE.a(17084, new Object[] { Integer.valueOf(21) });
    if (WalletLqtDetailUI.d(this.OpW).TYr.TJG == 2)
    {
      paramView = WalletLqtDetailUI.d(this.OpW).TYr.Eyy;
      Log.i("MicroMsg.WalletLqtDetailUI", "jump to h5 with url : %s", new Object[] { paramView });
      g.o(this.OpW, paramView, false);
    }
    for (;;)
    {
      if (WalletLqtDetailUI.k(this.OpW).getVisibility() == 0)
      {
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDG, Integer.valueOf(-1));
        Log.i("MicroMsg.WalletLqtDetailUI", "report click security reddot");
        com.tencent.mm.plugin.report.service.h.IzE.a(17084, new Object[] { Integer.valueOf(23) });
      }
      a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(186592);
      return;
      if (WalletLqtDetailUI.d(this.OpW).TYr.TJG == 3)
      {
        paramView = WalletLqtDetailUI.d(this.OpW).TYr.Sba;
        localObject = WalletLqtDetailUI.d(this.OpW).TYr.Eyy;
        Log.i("MicroMsg.WalletLqtDetailUI", "jump to tinyapp with username : %s, path : %s", new Object[] { paramView, localObject });
        g.v(paramView, (String)localObject, 0, 1061);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.22
 * JD-Core Version:    0.7.0.1
 */