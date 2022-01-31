package com.tencent.mm.plugin.webview.luggage;

import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b;

final class e$4
  implements WebViewInputFooter.b
{
  e$4(e parame) {}
  
  public final void cbe()
  {
    this.rca.BW(0);
  }
  
  public final void cbf()
  {
    if ((e.c(this.rca) != null) && (e.c(this.rca).getKeyBoardHeight() > 0)) {
      this.rca.BW(e.c(this.rca).getKeyBoardHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.4
 * JD-Core Version:    0.7.0.1
 */