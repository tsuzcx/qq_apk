package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ScanCardUI$3
  implements View.OnClickListener
{
  ScanCardUI$3(ScanCardUI paramScanCardUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(118352);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/scanner/ui/ScanCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    ScanCardUI.c(this.Pam);
    a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(118352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanCardUI.3
 * JD-Core Version:    0.7.0.1
 */