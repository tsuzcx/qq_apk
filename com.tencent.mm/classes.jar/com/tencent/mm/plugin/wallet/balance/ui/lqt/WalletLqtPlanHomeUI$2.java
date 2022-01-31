package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletLqtPlanHomeUI$2
  implements AdapterView.OnItemClickListener
{
  WalletLqtPlanHomeUI$2(WalletLqtPlanHomeUI paramWalletLqtPlanHomeUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(45605);
    ab.i("MicroMsg.WalletLqtPlanHomeUI", "pos: %s", new Object[] { Integer.valueOf(paramInt) });
    paramAdapterView.getAdapter().getItem(paramInt);
    AppMethodBeat.o(45605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.2
 * JD-Core Version:    0.7.0.1
 */