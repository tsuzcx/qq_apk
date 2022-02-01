package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dtx;
import com.tencent.mm.wallet_core.ui.i;
import org.json.JSONObject;

final class WalletLqtDetailUI$4
  implements View.OnClickListener
{
  WalletLqtDetailUI$4(WalletLqtDetailUI paramWalletLqtDetailUI, JSONObject paramJSONObject, dtx paramdtx, ViewGroup paramViewGroup) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68790);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    WalletLqtDetailUI.a(this.VeZ, this.Vfb, this.Vfc, this.Vfd);
    paramView = (String)this.Vfd.getTag();
    i.o(this.VeZ, paramView, false);
    h.OAn.b(16807, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.Vfc.Krl });
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.4
 * JD-Core Version:    0.7.0.1
 */