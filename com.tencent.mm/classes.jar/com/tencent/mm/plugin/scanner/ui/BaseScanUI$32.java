package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BaseScanUI$32
  implements View.OnClickListener
{
  BaseScanUI$32(BaseScanUI paramBaseScanUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(169984);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/scanner/ui/BaseScanUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    BaseScanUI.x(this.yqg);
    a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(169984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.32
 * JD-Core Version:    0.7.0.1
 */