package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class WeCoinBalanceDetailView$c
  implements View.OnClickListener
{
  WeCoinBalanceDetailView$c(WeCoinBalanceDetailView paramWeCoinBalanceDetailView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(212791);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinBalanceDetailView$updateData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    WeCoinBalanceDetailView.a(this.HOK, 22);
    this.HOK.finish();
    a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinBalanceDetailView$updateData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(212791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinBalanceDetailView.c
 * JD-Core Version:    0.7.0.1
 */