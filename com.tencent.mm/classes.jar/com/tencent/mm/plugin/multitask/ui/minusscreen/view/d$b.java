package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.view.recyclerview.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class d$b
  implements View.OnClickListener
{
  d$b(d paramd, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(196627);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = this.FKV.FKU;
    if (paramView != null) {
      paramView.a(this.FLb, this.tDl);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(196627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.d.b
 * JD-Core Version:    0.7.0.1
 */