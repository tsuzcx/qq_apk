package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.sh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;

final class RemittanceBusiResultUI$5
  implements View.OnClickListener
{
  RemittanceBusiResultUI$5(RemittanceBusiResultUI paramRemittanceBusiResultUI, sh paramsh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67994);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.RemittanceBusiResultUI", "app type: %s", new Object[] { Integer.valueOf(this.CsS.type) });
    if (this.CsS.type == 1)
    {
      RemittanceBusiResultUI.i(this.CsP);
      paramView = new wq();
      paramView.ecI.userName = this.CsS.KDV;
      paramView.ecI.ecK = Util.nullAs(this.CsS.KDW, "");
      paramView.ecI.scene = 1034;
      paramView.ecI.ecL = 0;
      EventCenter.instance.publish(paramView);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(67994);
      return;
      if (this.CsS.type == 2)
      {
        RemittanceBusiResultUI.i(this.CsP);
        f.p(this.CsP.getContext(), this.CsS.url, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.5
 * JD-Core Version:    0.7.0.1
 */