package com.tencent.mm.plugin.webview.luggage;

import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.KeyboardLinearLayout.a;

final class e$7
  implements KeyboardLinearLayout.a
{
  e$7(e parame) {}
  
  public final void rD(int paramInt)
  {
    y.i("MicroMsg.LuggageMMWebPage", "onKeyBoardStateChange, state = " + paramInt);
    e.a(this.rca, e.c(this.rca), paramInt);
    if ((paramInt == -3) && (e.b(this.rca) != null) && (e.b(this.rca).getVisibility() == 0)) {
      e.b(this.rca).cgV();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.7
 * JD-Core Version:    0.7.0.1
 */