package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class n$5
  implements View.OnClickListener
{
  n$5(n paramn) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(82696);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.QxO.hide();
    a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(82696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n.5
 * JD-Core Version:    0.7.0.1
 */