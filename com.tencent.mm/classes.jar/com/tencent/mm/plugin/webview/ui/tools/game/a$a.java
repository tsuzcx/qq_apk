package com.tencent.mm.plugin.webview.ui.tools.game;

import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.i;
import com.tencent.mm.plugin.wepkg.c;

final class a$a
  extends i
{
  a$a(a parama, MMWebViewWithJsApi paramMMWebViewWithJsApi)
  {
    super(paramMMWebViewWithJsApi);
  }
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(8656);
    if (this.vmw.vmq != null) {
      this.vmw.vmq.a(paramConsoleMessage);
    }
    boolean bool = super.onConsoleMessage(paramConsoleMessage);
    AppMethodBeat.o(8656);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.a.a
 * JD-Core Version:    0.7.0.1
 */