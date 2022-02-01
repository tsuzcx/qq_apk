package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.ui.f;

final class WalletLqtDetailUI$20
  implements View.OnClickListener
{
  WalletLqtDetailUI$20(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213948);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    Log.i("MicroMsg.WalletLqtDetailUI", "click security entry, url type is : %d", new Object[] { Integer.valueOf(WalletLqtDetailUI.d(this.Hyi).MMw.Myg) });
    h.CyF.a(17084, new Object[] { Integer.valueOf(21) });
    if (WalletLqtDetailUI.d(this.Hyi).MMw.Myg == 2)
    {
      paramView = WalletLqtDetailUI.d(this.Hyi).MMw.yUB;
      Log.i("MicroMsg.WalletLqtDetailUI", "jump to h5 with url : %s", new Object[] { paramView });
      f.o(this.Hyi, paramView, false);
    }
    for (;;)
    {
      if (WalletLqtDetailUI.k(this.Hyi).getVisibility() == 0)
      {
        g.aAi();
        g.aAh().azQ().set(ar.a.Oon, Integer.valueOf(-1));
      }
      a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(213948);
      return;
      if (WalletLqtDetailUI.d(this.Hyi).MMw.Myg == 3)
      {
        paramView = WalletLqtDetailUI.d(this.Hyi).MMw.KZR;
        localObject = WalletLqtDetailUI.d(this.Hyi).MMw.yUB;
        Log.i("MicroMsg.WalletLqtDetailUI", "jump to tinyapp with username : %s, path : %s", new Object[] { paramView, localObject });
        f.u(paramView, (String)localObject, 0, 1061);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.20
 * JD-Core Version:    0.7.0.1
 */