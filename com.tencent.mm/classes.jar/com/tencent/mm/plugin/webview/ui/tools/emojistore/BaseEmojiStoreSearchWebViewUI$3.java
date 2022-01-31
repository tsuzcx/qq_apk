package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.q;

final class BaseEmojiStoreSearchWebViewUI$3
  implements Runnable
{
  BaseEmojiStoreSearchWebViewUI$3(BaseEmojiStoreSearchWebViewUI paramBaseEmojiStoreSearchWebViewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(8289);
    BaseEmojiStoreSearchWebViewUI.a(this.vje).clearFocus();
    this.vje.hideVKB();
    AppMethodBeat.o(8289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI.3
 * JD-Core Version:    0.7.0.1
 */