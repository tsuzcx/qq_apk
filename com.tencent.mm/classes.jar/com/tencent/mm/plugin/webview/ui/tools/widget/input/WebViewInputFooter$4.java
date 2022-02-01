package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.MMEditText;

final class WebViewInputFooter$4
  implements View.OnClickListener
{
  WebViewInputFooter$4(WebViewInputFooter paramWebViewInputFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(82314);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    c.i(WebViewInputFooter.d(this.XrU)).aEg(WebViewInputFooter.l(this.XrU)).b(g.a.afIH).Nc(true).a(new c.a()
    {
      public final void Tw(String paramAnonymousString)
      {
        AppMethodBeat.i(82312);
        if (WebViewInputFooter.k(WebViewInputFooter.4.this.XrU) != null)
        {
          paramAnonymousString = WebViewInputFooter.k(WebViewInputFooter.4.this.XrU);
          WebViewInputFooter.d(WebViewInputFooter.4.this.XrU).getText();
          paramAnonymousString.iuy();
        }
        paramAnonymousString = WebViewInputFooter.4.this.XrU;
        paramAnonymousString.XrQ.clearComposingText();
        paramAnonymousString.XrQ.setText("");
        AppMethodBeat.o(82312);
      }
      
      public final void Tx(String paramAnonymousString) {}
      
      public final void eY(String paramAnonymousString)
      {
        AppMethodBeat.i(164038);
        if (WebViewInputFooter.b(WebViewInputFooter.4.this.XrU) != null) {
          Toast.makeText(WebViewInputFooter.b(WebViewInputFooter.4.this.XrU), "exceed max-length", 0).show();
        }
        AppMethodBeat.o(164038);
      }
    });
    a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(82314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.4
 * JD-Core Version:    0.7.0.1
 */