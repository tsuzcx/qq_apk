package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.protocal.protobuf.bum;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bs;

final class WalletLqtDetailUI$6
  implements View.OnClickListener
{
  WalletLqtDetailUI$6(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68792);
    paramView = new ut();
    paramView.dxt.userName = WalletLqtDetailUI.d(this.Bbf).FxI.username;
    paramView.dxt.dxv = bs.bG(WalletLqtDetailUI.d(this.Bbf).FxI.path, "");
    paramView.dxt.scene = 1061;
    paramView.dxt.dxw = 0;
    a.GpY.l(paramView);
    AppMethodBeat.o(68792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.6
 * JD-Core Version:    0.7.0.1
 */