package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView.a;
import com.tencent.mm.sdk.platformtools.ab;

final class WebViewUI$j
  implements FontChooserView.a
{
  private WebViewUI$j(WebViewUI paramWebViewUI) {}
  
  public final void Da(int paramInt)
  {
    int j = 2;
    AppMethodBeat.i(7948);
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      WebViewUI.c(this.vgz, i);
      try
      {
        if (this.vgz.igU.ddb())
        {
          this.vgz.igU.gN(16384, i);
          this.vgz.igU.gN(16388, i);
        }
        AppMethodBeat.o(7948);
        return;
      }
      catch (Exception localException)
      {
        ab.w("MicroMsg.WebViewUI", "onCheckedChanged, ex = " + localException.getMessage());
        AppMethodBeat.o(7948);
      }
      i = 1;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.j
 * JD-Core Version:    0.7.0.1
 */