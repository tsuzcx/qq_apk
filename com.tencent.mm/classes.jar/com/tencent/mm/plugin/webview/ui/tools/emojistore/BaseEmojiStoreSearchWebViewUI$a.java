package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.q;
import com.tencent.xweb.WebView;

final class BaseEmojiStoreSearchWebViewUI$a
  extends WebViewUI.h
{
  private BaseEmojiStoreSearchWebViewUI$a(BaseEmojiStoreSearchWebViewUI paramBaseEmojiStoreSearchWebViewUI)
  {
    super(paramBaseEmojiStoreSearchWebViewUI);
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(8291);
    ab.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "onPageFinished url:%s", new Object[] { paramString });
    super.b(paramWebView, paramString);
    this.vje.showOptionMenu(false);
    BaseEmojiStoreSearchWebViewUI.a(this.vje).setSearchContent(this.vje.query);
    AppMethodBeat.o(8291);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(8292);
    super.b(paramWebView, paramString, paramBitmap);
    this.vje.showOptionMenu(false);
    AppMethodBeat.o(8292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI.a
 * JD-Core Version:    0.7.0.1
 */