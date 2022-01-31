package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView.a;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$k
  implements FontChooserView.a
{
  private WebViewUI$k(WebViewUI paramWebViewUI) {}
  
  public final void xc(int paramInt)
  {
    int j = 2;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      WebViewUI.f(this.rpH, i);
      try
      {
        if (this.rpH.gGn.cdg())
        {
          this.rpH.gGn.eI(16384, i);
          this.rpH.gGn.eI(16388, i);
        }
        return;
      }
      catch (Exception localException)
      {
        y.w("MicroMsg.WebViewUI", "onCheckedChanged, ex = " + localException.getMessage());
      }
      i = 1;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.k
 * JD-Core Version:    0.7.0.1
 */