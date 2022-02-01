package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.protocal.protobuf.dtx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import org.json.JSONObject;

final class WalletLqtDetailUI$37
  implements View.OnClickListener
{
  WalletLqtDetailUI$37(WalletLqtDetailUI paramWalletLqtDetailUI, JSONObject paramJSONObject, dtx paramdtx, ViewGroup paramViewGroup) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68812);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.WalletLqtDetailUI", "go to lqt make plan");
    WalletLqtDetailUI.a(this.VeZ, this.Vfb, this.Vfc, this.Vfd);
    com.tencent.mm.plugin.report.service.h.OAn.b(22449, new Object[] { Integer.valueOf(2) });
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startLqtFixedDepositMakePlanUseCase(this.VeZ.getContext(), new Bundle());
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acUZ, Boolean.TRUE);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.37
 * JD-Core Version:    0.7.0.1
 */