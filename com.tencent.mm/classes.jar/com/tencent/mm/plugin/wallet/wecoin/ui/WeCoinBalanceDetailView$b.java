package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class WeCoinBalanceDetailView$b
  implements MenuItem.OnMenuItemClickListener
{
  WeCoinBalanceDetailView$b(WeCoinBalanceDetailView paramWeCoinBalanceDetailView) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(212790);
    WeCoinBalanceDetailView.a(this.HOK, 23);
    this.HOK.finish();
    AppMethodBeat.o(212790);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinBalanceDetailView.b
 * JD-Core Version:    0.7.0.1
 */