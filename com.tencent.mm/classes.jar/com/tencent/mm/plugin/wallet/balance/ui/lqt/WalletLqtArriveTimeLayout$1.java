package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.protocal.c.bjx;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class WalletLqtArriveTimeLayout$1
  implements View.OnClickListener
{
  WalletLqtArriveTimeLayout$1(WalletLqtArriveTimeLayout paramWalletLqtArriveTimeLayout) {}
  
  public final void onClick(View paramView)
  {
    WalletLqtArriveTimeLayout.a(this.qhL);
    paramView = (WalletLqtArriveTimeLayout.b)paramView.getTag();
    if ((WalletLqtArriveTimeLayout.b(this.qhL) != null) && (WalletLqtArriveTimeLayout.b(this.qhL).size() > paramView.index))
    {
      paramView.Vd.setChecked(true);
      WalletLqtArriveTimeLayout.a(this.qhL, (bjx)WalletLqtArriveTimeLayout.b(this.qhL).get(paramView.index));
    }
    for (;;)
    {
      WalletLqtArriveTimeLayout.c(this.qhL);
      y.i("MicroMsg.WalletLqtArriveTimeLayout", "click item: %s, %s", new Object[] { Integer.valueOf(paramView.index), paramView.haW.getText() });
      return;
      WalletLqtArriveTimeLayout.a(this.qhL, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtArriveTimeLayout.1
 * JD-Core Version:    0.7.0.1
 */