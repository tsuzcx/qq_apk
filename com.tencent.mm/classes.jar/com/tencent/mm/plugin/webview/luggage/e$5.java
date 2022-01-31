package com.tencent.mm.plugin.webview.luggage;

import android.view.KeyEvent;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a;

final class e$5
  implements WebViewSearchContentInputFooter.a
{
  e$5(e parame) {}
  
  public final void a(WebViewSearchContentInputFooter paramWebViewSearchContentInputFooter)
  {
    if (paramWebViewSearchContentInputFooter.getVisibility() == 0) {
      b(paramWebViewSearchContentInputFooter);
    }
  }
  
  public final void b(WebViewSearchContentInputFooter paramWebViewSearchContentInputFooter)
  {
    this.rca.rbA.clearMatches();
    paramWebViewSearchContentInputFooter.reset();
    e.d(this.rca).q(0, 0, true);
    this.rca.rbA.findAllAsync(paramWebViewSearchContentInputFooter.getSearchContent());
  }
  
  public final boolean c(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public final void cbg()
  {
    e.a(this.rca, 0);
    this.rca.rbA.clearMatches();
    e.d(this.rca).cgS();
  }
  
  public final void cbh()
  {
    this.rca.rbA.findNext(false);
  }
  
  public final void cbi()
  {
    this.rca.rbA.findNext(true);
  }
  
  public final void onShow()
  {
    e.a(this.rca, e.d(this.rca).getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.5
 * JD-Core Version:    0.7.0.1
 */