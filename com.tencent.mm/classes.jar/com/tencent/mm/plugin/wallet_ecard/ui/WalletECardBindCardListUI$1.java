package com.tencent.mm.plugin.wallet_ecard.ui;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.hg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.d.g;

final class WalletECardBindCardListUI$1
  implements AdapterView.OnItemClickListener
{
  WalletECardBindCardListUI$1(WalletECardBindCardListUI paramWalletECardBindCardListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(48115);
    ab.i("MicroMsg.WalletECardBindCardListUI", "position: %d", new Object[] { Integer.valueOf(paramInt) });
    int i = paramAdapterView.getAdapter().getItemViewType(paramInt);
    WalletECardBindCardListUI.a(this.uzF).getClass();
    if (i == 1)
    {
      ab.d("MicroMsg.WalletECardBindCardListUI", "click add item: %s", new Object[] { Integer.valueOf(WalletECardBindCardListUI.b(this.uzF)) });
      this.uzF.cXc();
      AppMethodBeat.o(48115);
      return;
    }
    paramAdapterView = (hg)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView == null)
    {
      ab.w("MicroMsg.WalletECardBindCardListUI", "empty item");
      AppMethodBeat.o(48115);
      return;
    }
    this.uzF.getNetController().p(new Object[] { paramAdapterView });
    AppMethodBeat.o(48115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.1
 * JD-Core Version:    0.7.0.1
 */