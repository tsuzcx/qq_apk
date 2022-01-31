package com.tencent.mm.plugin.webview.ui.tools;

import android.view.KeyEvent;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a;
import com.tencent.mm.ui.widget.MMWebView;

final class WebViewUI$15
  implements WebViewSearchContentInputFooter.a
{
  WebViewUI$15(WebViewUI paramWebViewUI) {}
  
  public final void a(WebViewSearchContentInputFooter paramWebViewSearchContentInputFooter)
  {
    if (paramWebViewSearchContentInputFooter.getVisibility() == 0) {
      b(paramWebViewSearchContentInputFooter);
    }
  }
  
  public final void b(WebViewSearchContentInputFooter paramWebViewSearchContentInputFooter)
  {
    this.rpH.niQ.clearMatches();
    paramWebViewSearchContentInputFooter.reset();
    this.rpH.rnD.q(0, 0, true);
    WebViewUI.c(this.rpH, false);
    this.rpH.niQ.findAllAsync(paramWebViewSearchContentInputFooter.getSearchContent());
  }
  
  public final boolean c(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0)) {
      h.nFQ.a(480L, 6L, 1L, false);
    }
    return false;
  }
  
  public final void cbg()
  {
    WebViewUI.c(this.rpH, 0);
    this.rpH.niQ.clearMatches();
    this.rpH.rnD.cgS();
  }
  
  public final void cbh()
  {
    h.nFQ.a(480L, 5L, 1L, false);
    this.rpH.niQ.findNext(false);
  }
  
  public final void cbi()
  {
    h.nFQ.a(480L, 4L, 1L, false);
    this.rpH.niQ.findNext(true);
  }
  
  public final void onShow() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.15
 * JD-Core Version:    0.7.0.1
 */