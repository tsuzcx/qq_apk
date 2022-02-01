package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;

final class RemittanceBusiResultUI$5
  implements View.OnClickListener
{
  RemittanceBusiResultUI$5(RemittanceBusiResultUI paramRemittanceBusiResultUI, rd paramrd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67994);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.RemittanceBusiResultUI", "app type: %s", new Object[] { Integer.valueOf(this.yck.type) });
    if (this.yck.type == 1)
    {
      RemittanceBusiResultUI.i(this.ych);
      paramView = new vm();
      paramView.dJF.userName = this.yck.FNb;
      paramView.dJF.dJH = bt.bI(this.yck.FNc, "");
      paramView.dJF.scene = 1034;
      paramView.dJF.dJI = 0;
      com.tencent.mm.sdk.b.a.IbL.l(paramView);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(67994);
      return;
      if (this.yck.type == 2)
      {
        RemittanceBusiResultUI.i(this.ych);
        e.o(this.ych.getContext(), this.yck.url, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.5
 * JD-Core Version:    0.7.0.1
 */