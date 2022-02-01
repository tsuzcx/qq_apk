package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.q;

final class OfflineAlertView$8
  implements View.OnClickListener
{
  OfflineAlertView$8(OfflineAlertView paramOfflineAlertView, q paramq) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(271190);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/offline/ui/OfflineAlertView$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.GDE.dismiss();
    h.IzE.a(18930, new Object[] { Integer.valueOf(this.GDL.OQq), Integer.valueOf(2) });
    a.a(this, "com/tencent/mm/plugin/offline/ui/OfflineAlertView$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(271190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView.8
 * JD-Core Version:    0.7.0.1
 */