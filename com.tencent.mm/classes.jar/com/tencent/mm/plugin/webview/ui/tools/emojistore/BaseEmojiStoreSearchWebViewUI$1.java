package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseEmojiStoreSearchWebViewUI$1
  implements View.OnTouchListener
{
  BaseEmojiStoreSearchWebViewUI$1(BaseEmojiStoreSearchWebViewUI paramBaseEmojiStoreSearchWebViewUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(8288);
    this.vje.hideVKB();
    AppMethodBeat.o(8288);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI.1
 * JD-Core Version:    0.7.0.1
 */