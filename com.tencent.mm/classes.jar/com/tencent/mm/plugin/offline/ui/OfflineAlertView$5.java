package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.q;

final class OfflineAlertView$5
  implements View.OnClickListener
{
  OfflineAlertView$5(OfflineAlertView paramOfflineAlertView, q paramq) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213618);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/offline/ui/OfflineAlertView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.AKx.dismiss();
    h.CyF.a(18930, new Object[] { Integer.valueOf(this.AKA.HYq), Integer.valueOf(2) });
    a.a(this, "com/tencent/mm/plugin/offline/ui/OfflineAlertView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(213618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView.5
 * JD-Core Version:    0.7.0.1
 */