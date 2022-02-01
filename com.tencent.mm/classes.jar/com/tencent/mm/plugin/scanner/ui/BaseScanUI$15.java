package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BaseScanUI$15
  implements View.OnClickListener
{
  BaseScanUI$15(BaseScanUI paramBaseScanUI)
  {
    AppMethodBeat.i(161004);
    AppMethodBeat.o(161004);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(314575);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/scanner/ui/BaseScanUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    BaseScanUI.H(this.OYm);
    a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(314575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.15
 * JD-Core Version:    0.7.0.1
 */