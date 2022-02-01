package com.tencent.mm.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class MMCollapsibleTextView$l
  implements View.OnClickListener
{
  MMCollapsibleTextView$l(MMCollapsibleTextView paramMMCollapsibleTextView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(140956);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/widget/MMCollapsibleTextView$setupCollapseButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    MMCollapsibleTextView.b(this.Ybc);
    a.a(this, "com/tencent/mm/ui/widget/MMCollapsibleTextView$setupCollapseButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(140956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMCollapsibleTextView.l
 * JD-Core Version:    0.7.0.1
 */