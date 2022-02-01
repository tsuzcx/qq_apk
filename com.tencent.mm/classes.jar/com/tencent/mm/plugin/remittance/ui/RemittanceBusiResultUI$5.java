package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.rf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.f;

final class RemittanceBusiResultUI$5
  implements View.OnClickListener
{
  RemittanceBusiResultUI$5(RemittanceBusiResultUI paramRemittanceBusiResultUI, rf paramrf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67994);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.i("MicroMsg.RemittanceBusiResultUI", "app type: %s", new Object[] { Integer.valueOf(this.ysb.type) });
    if (this.ysb.type == 1)
    {
      RemittanceBusiResultUI.i(this.yrY);
      paramView = new vq();
      paramView.dKT.userName = this.ysb.GfA;
      paramView.dKT.dKV = bu.bI(this.ysb.GfB, "");
      paramView.dKT.scene = 1034;
      paramView.dKT.dKW = 0;
      com.tencent.mm.sdk.b.a.IvT.l(paramView);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(67994);
      return;
      if (this.ysb.type == 2)
      {
        RemittanceBusiResultUI.i(this.yrY);
        f.p(this.yrY.getContext(), this.ysb.url, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.5
 * JD-Core Version:    0.7.0.1
 */