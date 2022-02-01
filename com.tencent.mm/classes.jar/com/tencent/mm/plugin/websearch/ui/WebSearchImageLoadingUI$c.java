package com.tencent.mm.plugin.websearch.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class WebSearchImageLoadingUI$c
  implements View.OnClickListener
{
  WebSearchImageLoadingUI$c(WebSearchImageLoadingUI paramWebSearchImageLoadingUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(224527);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI$onError$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.DVl.finish();
    a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI$onError$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(224527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchImageLoadingUI.c
 * JD-Core Version:    0.7.0.1
 */