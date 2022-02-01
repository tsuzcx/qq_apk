package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dcf;
import com.tencent.mm.wallet_core.ui.g;
import org.json.JSONObject;

final class WalletLqtDetailUI$5
  implements View.OnClickListener
{
  WalletLqtDetailUI$5(WalletLqtDetailUI paramWalletLqtDetailUI, JSONObject paramJSONObject, dcf paramdcf, ViewGroup paramViewGroup) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68791);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    WalletLqtDetailUI.a(this.OpW, this.OpX, this.OpY, this.OpZ);
    g.v(this.OpY.Sba, this.OpY.Eyy, 0, 1061);
    h.IzE.a(16807, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.OpY.Eyy, this.OpY.Sba });
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.5
 * JD-Core Version:    0.7.0.1
 */