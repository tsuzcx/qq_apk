package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class EmojiStoreSearchWebViewUI
  extends BaseEmojiStoreSearchWebViewUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void z(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80478);
    Log.i("MicroMsg.emoji.EmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", new Object[] { Integer.valueOf(paramInt) });
    super.z(paramInt, paramBundle);
    AppMethodBeat.o(80478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.emojistore.EmojiStoreSearchWebViewUI
 * JD-Core Version:    0.7.0.1
 */