package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.n;
import com.tencent.xweb.WebView;

final class BaseEmojiStoreSearchWebViewUI$a
  extends WebViewUI.i
{
  private BaseEmojiStoreSearchWebViewUI$a(BaseEmojiStoreSearchWebViewUI paramBaseEmojiStoreSearchWebViewUI)
  {
    super(paramBaseEmojiStoreSearchWebViewUI);
  }
  
  public final void a(WebView paramWebView, String paramString)
  {
    y.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "onPageFinished url:%s", new Object[] { paramString });
    super.a(paramWebView, paramString);
    this.rsY.showOptionMenu(false);
    BaseEmojiStoreSearchWebViewUI.a(this.rsY).setSearchContent(this.rsY.bVk);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.b(paramWebView, paramString, paramBitmap);
    this.rsY.showOptionMenu(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI.a
 * JD-Core Version:    0.7.0.1
 */