package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.wallet_core.ui.f;

final class OfflineAlertView$7
  implements View.OnClickListener
{
  OfflineAlertView$7(OfflineAlertView paramOfflineAlertView, r paramr) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(189938);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/offline/ui/OfflineAlertView$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (this.wOX.oGc == 2) {
      f.aY(this.wOR.getContext(), this.wOX.url);
    }
    for (;;)
    {
      g.yxI.f(20258, new Object[] { Integer.valueOf(2) });
      a.a(this, "com/tencent/mm/plugin/offline/ui/OfflineAlertView$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(189938);
      return;
      if (this.wOX.oGc == 3) {
        f.u(this.wOX.Dnv, this.wOX.Dnw, 0, 1000);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView.7
 * JD-Core Version:    0.7.0.1
 */