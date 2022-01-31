package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.y;

public class EmojiStoreSearchWebViewUI
  extends BaseEmojiStoreSearchWebViewUI
{
  protected final void s(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.emoji.EmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", new Object[] { Integer.valueOf(paramInt) });
    super.s(paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.emojistore.EmojiStoreSearchWebViewUI
 * JD-Core Version:    0.7.0.1
 */