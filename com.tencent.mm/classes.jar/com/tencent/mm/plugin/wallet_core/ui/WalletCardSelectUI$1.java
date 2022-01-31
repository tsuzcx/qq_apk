package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class WalletCardSelectUI$1
  implements AdapterView.OnItemClickListener
{
  WalletCardSelectUI$1(WalletCardSelectUI paramWalletCardSelectUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(47296);
    paramAdapterView = WalletCardSelectUI.a(this.upv).IF(paramInt);
    if (!bo.isNullOrNil(paramAdapterView.uhD))
    {
      h.a(this.upv, paramAdapterView.uhD, null, true, null);
      AppMethodBeat.o(47296);
      return;
    }
    if (paramAdapterView.cTv()) {
      WalletCardSelectUI.a(this.upv, paramInt);
    }
    for (;;)
    {
      this.upv.enableOptionMenu(true);
      AppMethodBeat.o(47296);
      return;
      WalletCardSelectUI.b(this.upv, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI.1
 * JD-Core Version:    0.7.0.1
 */