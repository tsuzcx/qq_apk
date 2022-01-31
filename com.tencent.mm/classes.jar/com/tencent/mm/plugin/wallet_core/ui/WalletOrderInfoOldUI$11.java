package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.f.a;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletOrderInfoOldUI$11
  implements View.OnLongClickListener
{
  WalletOrderInfoOldUI$11(WalletOrderInfoOldUI paramWalletOrderInfoOldUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(47484);
    if ((paramView.getId() == 2131829265) || (paramView.getId() == 2131829275)) {}
    try
    {
      paramView = (String)paramView.getTag();
      Toast.makeText(this.urV, 2131305326, 0).show();
      this.urV.getContext();
      a.b(paramView, paramView);
      AppMethodBeat.o(47484);
      return true;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WalletOrderInfoOldUI", paramView, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.11
 * JD-Core Version:    0.7.0.1
 */