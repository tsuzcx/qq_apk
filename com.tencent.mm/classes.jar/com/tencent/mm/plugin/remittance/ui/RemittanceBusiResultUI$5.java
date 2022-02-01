package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.sa;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.g;

final class RemittanceBusiResultUI$5
  implements View.OnClickListener
{
  RemittanceBusiResultUI$5(RemittanceBusiResultUI paramRemittanceBusiResultUI, sa paramsa) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67994);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i("MicroMsg.RemittanceBusiResultUI", "app type: %s", new Object[] { Integer.valueOf(this.Iqw.type) });
    if (this.Iqw.type == 1)
    {
      RemittanceBusiResultUI.k(this.Iqt);
      paramView = new xw();
      paramView.fWN.userName = this.Iqw.RFn;
      paramView.fWN.fWP = Util.nullAs(this.Iqw.RFo, "");
      paramView.fWN.scene = 1034;
      paramView.fWN.fWQ = 0;
      EventCenter.instance.publish(paramView);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(67994);
      return;
      if (this.Iqw.type == 2)
      {
        RemittanceBusiResultUI.k(this.Iqt);
        g.p(this.Iqt.getContext(), this.Iqw.url, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.5
 * JD-Core Version:    0.7.0.1
 */