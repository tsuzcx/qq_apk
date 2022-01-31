package com.tencent.mm.plugin.topstory.ui.webview;

import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import com.tencent.xweb.j;

public final class a
  extends j
{
  public final void a(WebView paramWebView, int paramInt) {}
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, f paramf)
  {
    y.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsAlert %s %s", new Object[] { paramString1, paramString2 });
    return super.a(paramWebView, paramString1, paramString2, paramf);
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, e parame)
  {
    y.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsPrompt %s %s", new Object[] { paramString1, paramString2 });
    return super.a(paramWebView, paramString1, paramString2, paramString3, parame);
  }
  
  public final boolean b(WebView paramWebView, String paramString1, String paramString2, f paramf)
  {
    y.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsConfirm %s %s", new Object[] { paramString1, paramString2 });
    return super.b(paramWebView, paramString1, paramString2, paramf);
  }
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    y.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onConsoleMessage %d %s %s %s", new Object[] { Integer.valueOf(paramConsoleMessage.lineNumber()), paramConsoleMessage.messageLevel().name(), paramConsoleMessage.message(), paramConsoleMessage.sourceId() });
    if ((paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) && (!bk.bl(paramConsoleMessage.message())) && (paramConsoleMessage.message().contains("SyntaxError"))) {
      ao.BG(22);
    }
    return super.onConsoleMessage(paramConsoleMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.a
 * JD-Core Version:    0.7.0.1
 */