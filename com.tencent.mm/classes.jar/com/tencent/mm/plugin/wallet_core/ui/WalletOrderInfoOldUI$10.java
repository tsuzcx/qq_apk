package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;

final class WalletOrderInfoOldUI$10
  implements View.OnLongClickListener
{
  WalletOrderInfoOldUI$10(WalletOrderInfoOldUI paramWalletOrderInfoOldUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(71053);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
    if ((paramView.getId() == a.f.wallet_order_info_desc) || (paramView.getId() == a.f.wallet_order_info_trans_id)) {}
    try
    {
      paramView = (String)paramView.getTag();
      Toast.makeText(this.VRm, a.i.wallet_order_info_copy_success, 0).show();
      ClipboardHelper.setText(this.VRm.getContext(), paramView, paramView);
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
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.10
 * JD-Core Version:    0.7.0.1
 */