package com.tencent.mm.plugin.textstatus.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class g$d
  implements View.OnClickListener
{
  g$d(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(236231);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/textstatus/ui/ProfileCardView$fixLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.MKp.gmx();
    a.a(this, "com/tencent/mm/plugin/textstatus/ui/ProfileCardView$fixLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(236231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.g.d
 * JD-Core Version:    0.7.0.1
 */