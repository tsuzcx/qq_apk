package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;

final class WalletOrderInfoOldUI$11
  implements View.OnLongClickListener
{
  WalletOrderInfoOldUI$11(WalletOrderInfoOldUI paramWalletOrderInfoOldUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(71053);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
    if ((paramView.getId() == 2131306777) || (paramView.getId() == 2131306805)) {}
    try
    {
      paramView = (String)paramView.getTag();
      Toast.makeText(this.DhC, 2131765540, 0).show();
      this.DhC.getContext();
      com.tencent.mm.pluginsdk.i.a.b(paramView, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(71053);
      return true;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.WalletOrderInfoOldUI", paramView, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.11
 * JD-Core Version:    0.7.0.1
 */