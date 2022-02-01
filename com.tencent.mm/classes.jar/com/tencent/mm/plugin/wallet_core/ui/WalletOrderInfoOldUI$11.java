package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.sdk.platformtools.ac;

final class WalletOrderInfoOldUI$11
  implements View.OnLongClickListener
{
  WalletOrderInfoOldUI$11(WalletOrderInfoOldUI paramWalletOrderInfoOldUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(71053);
    if ((paramView.getId() == 2131306777) || (paramView.getId() == 2131306805)) {}
    try
    {
      paramView = (String)paramView.getTag();
      Toast.makeText(this.BHk, 2131765540, 0).show();
      this.BHk.getContext();
      a.b(paramView, paramView);
      AppMethodBeat.o(71053);
      return true;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.WalletOrderInfoOldUI", paramView, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.11
 * JD-Core Version:    0.7.0.1
 */