package com.tencent.mm.plugin.scanner.box;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class BoxDialogView$k
  implements View.OnClickListener
{
  BoxDialogView$k(BoxDialogView paramBoxDialogView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(52093);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/scanner/box/BoxDialogView$init$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.yAL.OV(4);
    a.a(this, "com/tencent/mm/plugin/scanner/box/BoxDialogView$init$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(52093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BoxDialogView.k
 * JD-Core Version:    0.7.0.1
 */