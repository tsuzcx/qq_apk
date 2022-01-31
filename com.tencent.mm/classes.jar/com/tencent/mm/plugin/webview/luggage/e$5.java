package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.KeyboardLinearLayout.a;

final class e$5
  implements KeyboardLinearLayout.a
{
  e$5(e parame) {}
  
  public final void sJ(int paramInt)
  {
    AppMethodBeat.i(153087);
    ab.i("MicroMsg.LuggageMMWebPage", "onKeyBoardStateChange, state = ".concat(String.valueOf(paramInt)));
    if (!e.e(this.uRQ))
    {
      ab.i("MicroMsg.LuggageMMWebPage", "background ignored");
      AppMethodBeat.o(153087);
      return;
    }
    e.a(this.uRQ, e.c(this.uRQ), paramInt);
    if (paramInt == -3)
    {
      if ((e.b(this.uRQ) != null) && (e.b(this.uRQ).getVisibility() == 0)) {
        e.b(this.uRQ).dhc();
      }
      e.a(this.uRQ, e.c(this.uRQ).getKeyBoardHeight());
      AppMethodBeat.o(153087);
      return;
    }
    e.a(this.uRQ, 0);
    AppMethodBeat.o(153087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.5
 * JD-Core Version:    0.7.0.1
 */