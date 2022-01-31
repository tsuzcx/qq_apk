package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.webview.model.ac.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.MMWebView;

final class WebViewUI$60
  implements ac.d
{
  WebViewUI$60(WebViewUI paramWebViewUI) {}
  
  public final void Se(String paramString)
  {
    WebViewUI.a(this.rpH, paramString, true, 9);
  }
  
  public final void aIJ()
  {
    if (WebViewUI.aQ(this.rpH) != null) {
      WebViewUI.aQ(this.rpH).dismiss();
    }
  }
  
  public final void c(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (WebViewUI.aQ(this.rpH) != null) {
      WebViewUI.aQ(this.rpH).dismiss();
    }
    WebViewUI.a(this.rpH, com.tencent.mm.ui.base.h.b(this.rpH, this.rpH.getString(R.l.oauth_logining), true, paramOnCancelListener));
  }
  
  public final void goBack()
  {
    if (this.rpH.niQ == null) {}
    while (WebViewUI.aI(this.rpH)) {
      return;
    }
    if ((this.rpH.niQ.canGoBack()) && (this.rpH.rnH))
    {
      this.rpH.cdU();
      return;
    }
    h.rnm.close();
    this.rpH.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.60
 * JD-Core Version:    0.7.0.1
 */