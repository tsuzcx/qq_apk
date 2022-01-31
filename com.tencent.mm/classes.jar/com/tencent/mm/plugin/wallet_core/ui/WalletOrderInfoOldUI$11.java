package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.f.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class WalletOrderInfoOldUI$11
  implements View.OnLongClickListener
{
  WalletOrderInfoOldUI$11(WalletOrderInfoOldUI paramWalletOrderInfoOldUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    if ((paramView.getId() == a.f.wallet_order_info_desc) || (paramView.getId() == a.f.wallet_order_info_trans_id)) {}
    try
    {
      paramView = (String)paramView.getTag();
      Toast.makeText(this.qEN, a.i.wallet_order_info_copy_success, 0).show();
      a.a(this.qEN.mController.uMN, paramView, paramView);
      return true;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.WalletOrderInfoOldUI", paramView, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.11
 * JD-Core Version:    0.7.0.1
 */