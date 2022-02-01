package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WebViewSearchContentInputFooter$1
  implements View.OnClickListener
{
  WebViewSearchContentInputFooter$1(WebViewSearchContentInputFooter paramWebViewSearchContentInputFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(82290);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.JAG.hide();
    a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(82290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.1
 * JD-Core Version:    0.7.0.1
 */