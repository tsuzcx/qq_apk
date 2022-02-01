package com.tencent.mm.plugin.scanner.box;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class BaseBoxDialogView$j
  implements View.OnClickListener
{
  BaseBoxDialogView$j(BaseBoxDialogView paramBaseBoxDialogView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(240232);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.CCb.Wr(4);
    a.a(this, "com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(240232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BaseBoxDialogView.j
 * JD-Core Version:    0.7.0.1
 */