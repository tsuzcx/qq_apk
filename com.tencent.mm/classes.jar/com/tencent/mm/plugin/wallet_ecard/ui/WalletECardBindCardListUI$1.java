package com.tencent.mm.plugin.wallet_ecard.ui;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.protocal.c.fv;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.d.g;

final class WalletECardBindCardListUI$1
  implements AdapterView.OnItemClickListener
{
  WalletECardBindCardListUI$1(WalletECardBindCardListUI paramWalletECardBindCardListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    y.i("MicroMsg.WalletECardBindCardListUI", "position: %d", new Object[] { Integer.valueOf(paramInt) });
    int i = paramAdapterView.getAdapter().getItemViewType(paramInt);
    WalletECardBindCardListUI.a(this.qKH).getClass();
    if (i == 1)
    {
      y.d("MicroMsg.WalletECardBindCardListUI", "click add item: %s", new Object[] { Integer.valueOf(WalletECardBindCardListUI.b(this.qKH)) });
      WalletECardBindCardListUI.c(this.qKH);
      return;
    }
    paramAdapterView = (fv)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView == null)
    {
      y.w("MicroMsg.WalletECardBindCardListUI", "empty item");
      return;
    }
    this.qKH.cNk().m(new Object[] { paramAdapterView });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.1
 * JD-Core Version:    0.7.0.1
 */