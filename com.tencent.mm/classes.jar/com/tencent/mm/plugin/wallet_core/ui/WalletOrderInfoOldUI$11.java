package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;

final class WalletOrderInfoOldUI$11
  implements View.OnLongClickListener
{
  WalletOrderInfoOldUI$11(WalletOrderInfoOldUI paramWalletOrderInfoOldUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(71053);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    if ((paramView.getId() == 2131310238) || (paramView.getId() == 2131310266)) {}
    try
    {
      paramView = (String)paramView.getTag();
      Toast.makeText(this.Iir, 2131767989, 0).show();
      ClipboardHelper.setText(this.Iir.getContext(), paramView, paramView);
      a.a(true, this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(71053);
      return true;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WalletOrderInfoOldUI", paramView, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.11
 * JD-Core Version:    0.7.0.1
 */