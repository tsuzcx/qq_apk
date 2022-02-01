package com.tencent.mm.plugin.scanner.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ScanSharedMaskView$c
  implements View.OnClickListener
{
  ScanSharedMaskView$c(ScanSharedMaskView paramScanSharedMaskView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(52449);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    localObject = ScanSharedMaskView.a(this.yOU);
    if (localObject != null) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
    a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(52449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView.c
 * JD-Core Version:    0.7.0.1
 */