package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BaseScanUI$31
  implements View.OnClickListener
{
  BaseScanUI$31(BaseScanUI paramBaseScanUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(169984);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/scanner/ui/BaseScanUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    BaseScanUI.z(this.CJV);
    a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(169984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.31
 * JD-Core Version:    0.7.0.1
 */