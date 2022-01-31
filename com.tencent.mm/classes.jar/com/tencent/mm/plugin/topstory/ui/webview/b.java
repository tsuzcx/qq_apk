package com.tencent.mm.plugin.topstory.ui.webview;

import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.WebView;
import com.tencent.xweb.i;
import com.tencent.xweb.j;
import com.tencent.xweb.p;

public final class b
  extends p
{
  public final void a(WebView paramWebView, int paramInt) {}
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, j paramj)
  {
    AppMethodBeat.i(2146);
    ab.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsAlert %s %s", new Object[] { paramString1, paramString2 });
    boolean bool = super.a(paramWebView, paramString1, paramString2, paramj);
    AppMethodBeat.o(2146);
    return bool;
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, i parami)
  {
    AppMethodBeat.i(2145);
    ab.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsPrompt %s %s", new Object[] { paramString1, paramString2 });
    boolean bool = super.a(paramWebView, paramString1, paramString2, paramString3, parami);
    AppMethodBeat.o(2145);
    return bool;
  }
  
  public final boolean b(WebView paramWebView, String paramString1, String paramString2, j paramj)
  {
    AppMethodBeat.i(2144);
    ab.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsConfirm %s %s", new Object[] { paramString1, paramString2 });
    boolean bool = super.b(paramWebView, paramString1, paramString2, paramj);
    AppMethodBeat.o(2144);
    return bool;
  }
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(2147);
    ab.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onConsoleMessage %d %s %s %s", new Object[] { Integer.valueOf(paramConsoleMessage.lineNumber()), paramConsoleMessage.messageLevel().name(), paramConsoleMessage.message(), paramConsoleMessage.sourceId() });
    if ((paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) && (!bo.isNullOrNil(paramConsoleMessage.message())) && (paramConsoleMessage.message().contains("SyntaxError"))) {
      an.Jw(22);
    }
    boolean bool = super.onConsoleMessage(paramConsoleMessage);
    AppMethodBeat.o(2147);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.b
 * JD-Core Version:    0.7.0.1
 */