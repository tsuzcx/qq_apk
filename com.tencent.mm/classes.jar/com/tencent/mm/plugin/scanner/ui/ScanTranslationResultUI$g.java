package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ScanTranslationResultUI$g
  implements View.OnClickListener
{
  ScanTranslationResultUI$g(ScanTranslationResultUI paramScanTranslationResultUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(162354);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    ScanTranslationResultUI.j(this.CNd);
    a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(162354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationResultUI.g
 * JD-Core Version:    0.7.0.1
 */