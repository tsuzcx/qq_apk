package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.protocal.protobuf.dcf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import org.json.JSONObject;

final class WalletLqtDetailUI$34
  implements View.OnClickListener
{
  WalletLqtDetailUI$34(WalletLqtDetailUI paramWalletLqtDetailUI, JSONObject paramJSONObject, dcf paramdcf, ViewGroup paramViewGroup) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68813);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    com.tencent.mm.plugin.report.service.h.IzE.a(22449, new Object[] { Integer.valueOf(2) });
    Log.i("MicroMsg.WalletLqtDetailUI", "go to lqt plan list");
    WalletLqtDetailUI.a(this.OpW, this.OpX, this.OpY, this.OpZ);
    ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startLqtFixedDepositPlanListUseCase(this.OpW.getContext(), new Bundle());
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vtu, Boolean.TRUE);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.34
 * JD-Core Version:    0.7.0.1
 */