package com.tencent.mm.plugin.websearch.a.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$b
  implements View.OnClickListener
{
  c$b(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(198080);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.PAz.onBackPressed();
    a.a(this, "com/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(198080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.c.b
 * JD-Core Version:    0.7.0.1
 */