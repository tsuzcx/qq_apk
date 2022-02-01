package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class OfflineAlertView$12
  implements View.OnClickListener
{
  OfflineAlertView$12(OfflineAlertView paramOfflineAlertView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(189942);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/OfflineAlertView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    com.tencent.mm.plugin.offline.c.a.gc(this.wOR.getContext());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/OfflineAlertView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(189942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView.12
 * JD-Core Version:    0.7.0.1
 */