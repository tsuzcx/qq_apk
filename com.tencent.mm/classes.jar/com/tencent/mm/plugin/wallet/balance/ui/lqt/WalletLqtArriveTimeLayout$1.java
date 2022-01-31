package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsw;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class WalletLqtArriveTimeLayout$1
  implements View.OnClickListener
{
  WalletLqtArriveTimeLayout$1(WalletLqtArriveTimeLayout paramWalletLqtArriveTimeLayout) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45503);
    WalletLqtArriveTimeLayout.a(this.tPg);
    paramView = (WalletLqtArriveTimeLayout.b)paramView.getTag();
    if ((WalletLqtArriveTimeLayout.b(this.tPg) != null) && (WalletLqtArriveTimeLayout.b(this.tPg).size() > paramView.index))
    {
      paramView.VQ.setChecked(true);
      WalletLqtArriveTimeLayout.a(this.tPg, (bsw)WalletLqtArriveTimeLayout.b(this.tPg).get(paramView.index));
    }
    for (;;)
    {
      WalletLqtArriveTimeLayout.c(this.tPg);
      ab.i("MicroMsg.WalletLqtArriveTimeLayout", "click item: %s, %s", new Object[] { Integer.valueOf(paramView.index), paramView.iJG.getText() });
      AppMethodBeat.o(45503);
      return;
      WalletLqtArriveTimeLayout.a(this.tPg, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtArriveTimeLayout.1
 * JD-Core Version:    0.7.0.1
 */