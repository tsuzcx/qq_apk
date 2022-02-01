package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BaseScanUI$17
  implements View.OnClickListener
{
  BaseScanUI$17(BaseScanUI paramBaseScanUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(314563);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/scanner/ui/BaseScanUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    BaseScanUI.b(this.OYm, 1);
    this.OYm.onBackPressed();
    BaseScanUI.b(this.OYm, 4);
    a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(314563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.17
 * JD-Core Version:    0.7.0.1
 */