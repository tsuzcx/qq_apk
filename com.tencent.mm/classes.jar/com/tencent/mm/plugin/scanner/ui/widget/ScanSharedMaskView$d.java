package com.tencent.mm.plugin.scanner.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ScanSharedMaskView$d
  implements View.OnClickListener
{
  ScanSharedMaskView$d(ScanSharedMaskView paramScanSharedMaskView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(52450);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    localObject = ScanSharedMaskView.b(this.yyU);
    if (localObject != null) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
    a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(52450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView.d
 * JD-Core Version:    0.7.0.1
 */