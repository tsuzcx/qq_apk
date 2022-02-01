package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class n$2
  implements View.OnLongClickListener
{
  n$2(n paramn) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(82692);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
    n.g(this.QxO);
    a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(82692);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n.2
 * JD-Core Version:    0.7.0.1
 */