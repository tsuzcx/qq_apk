package com.tencent.mm.plugin.scanner.ui.widget;

import android.graphics.PointF;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.scanner.model.ae;
import d.g.b.y.a;
import d.g.b.y.f;
import d.l;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$1$1$1", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$$special$$inlined$apply$lambda$1"})
final class ScanCodeMaskView$m
  implements View.OnClickListener
{
  ScanCodeMaskView$m(int paramInt, PointF paramPointF, y.f paramf, ScanCodeMaskView paramScanCodeMaskView, y.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(170054);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ScanCodeMaskView.a(this.yNL, this.ojd);
    paramView = ScanCodeMaskView.d(this.yNL);
    if (paramView != null) {
      paramView.Pn(this.ojd);
    }
    paramView = ((Iterable)ScanCodeMaskView.e(this.yNL)).iterator();
    while (paramView.hasNext()) {
      ((View)paramView.next()).setOnClickListener(null);
    }
    a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(170054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView.m
 * JD-Core Version:    0.7.0.1
 */