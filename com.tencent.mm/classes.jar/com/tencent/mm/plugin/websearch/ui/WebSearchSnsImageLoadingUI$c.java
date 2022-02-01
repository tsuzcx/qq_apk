package com.tencent.mm.plugin.websearch.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class WebSearchSnsImageLoadingUI$c
  implements View.OnClickListener
{
  WebSearchSnsImageLoadingUI$c(WebSearchSnsImageLoadingUI paramWebSearchSnsImageLoadingUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(198021);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/websearch/ui/WebSearchSnsImageLoadingUI$onError$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.IGR.finish();
    a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchSnsImageLoadingUI$onError$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(198021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI.c
 * JD-Core Version:    0.7.0.1
 */