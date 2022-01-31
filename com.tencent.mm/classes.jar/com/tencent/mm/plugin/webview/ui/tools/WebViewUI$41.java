package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.ah.d;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.MMWebView;

final class WebViewUI$41
  implements ah.d
{
  WebViewUI$41(WebViewUI paramWebViewUI) {}
  
  public final void aha(String paramString)
  {
    AppMethodBeat.i(153249);
    WebViewUI.a(this.vgz, paramString, true, 9);
    AppMethodBeat.o(153249);
  }
  
  public final void bmh()
  {
    AppMethodBeat.i(153252);
    if (WebViewUI.P(this.vgz) != null) {
      WebViewUI.P(this.vgz).dismiss();
    }
    AppMethodBeat.o(153252);
  }
  
  public final void d(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(153251);
    if (WebViewUI.P(this.vgz) != null) {
      WebViewUI.P(this.vgz).dismiss();
    }
    WebViewUI.a(this.vgz, h.b(this.vgz, this.vgz.getString(2131301992), true, paramOnCancelListener));
    AppMethodBeat.o(153251);
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(153250);
    if (this.vgz.pOd == null)
    {
      AppMethodBeat.o(153250);
      return;
    }
    if (WebViewUI.H(this.vgz))
    {
      AppMethodBeat.o(153250);
      return;
    }
    if ((this.vgz.pOd.canGoBack()) && (this.vgz.vew))
    {
      this.vgz.aZy();
      AppMethodBeat.o(153250);
      return;
    }
    m.vdm.close();
    this.vgz.finish();
    AppMethodBeat.o(153250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.41
 * JD-Core Version:    0.7.0.1
 */