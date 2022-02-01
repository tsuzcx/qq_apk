package com.tencent.mm.plugin.scanner.ui.widget;

import android.graphics.PointF;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.scanner.model.ag;
import java.util.Iterator;
import kotlin.g.b.z.a;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$1$1$1", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$$special$$inlined$apply$lambda$1"})
final class ScanCodeMaskView$m
  implements View.OnClickListener
{
  ScanCodeMaskView$m(int paramInt, PointF paramPointF, z.f paramf, ScanCodeMaskView paramScanCodeMaskView, z.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(170054);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    ScanCodeMaskView.a(this.CRD, this.puW);
    paramView = ScanCodeMaskView.d(this.CRD);
    if (paramView != null) {
      paramView.WK(this.puW);
    }
    paramView = ((Iterable)ScanCodeMaskView.e(this.CRD)).iterator();
    while (paramView.hasNext()) {
      ((View)paramView.next()).setOnClickListener(null);
    }
    a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(170054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView.m
 * JD-Core Version:    0.7.0.1
 */