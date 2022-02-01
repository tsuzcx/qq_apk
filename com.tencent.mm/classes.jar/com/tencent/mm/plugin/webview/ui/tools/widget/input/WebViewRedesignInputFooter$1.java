package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WebViewRedesignInputFooter$1
  implements View.OnClickListener
{
  WebViewRedesignInputFooter$1(WebViewRedesignInputFooter paramWebViewRedesignInputFooter, View paramView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(214252);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.Qzj.setVisibility(8);
    this.Qzk.hide();
    this.Qzk.hcg();
    a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewRedesignInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(214252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter.1
 * JD-Core Version:    0.7.0.1
 */