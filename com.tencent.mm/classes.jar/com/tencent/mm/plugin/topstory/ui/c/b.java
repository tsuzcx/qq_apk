package com.tencent.mm.plugin.topstory.ui.c;

import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.q;
import com.tencent.xweb.z;

public final class b
  extends z
{
  public final void a(WebView paramWebView, int paramInt) {}
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(126551);
    Log.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsAlert %s %s", new Object[] { paramString1, paramString2 });
    boolean bool = super.a(paramWebView, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(126551);
    return bool;
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, q paramq)
  {
    AppMethodBeat.i(126550);
    Log.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsPrompt %s %s", new Object[] { paramString1, paramString2 });
    boolean bool = super.a(paramWebView, paramString1, paramString2, paramString3, paramq);
    AppMethodBeat.o(126550);
    return bool;
  }
  
  public final boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(126549);
    Log.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsConfirm %s %s", new Object[] { paramString1, paramString2 });
    boolean bool = super.b(paramWebView, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(126549);
    return bool;
  }
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(126552);
    Log.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onConsoleMessage %d %s %s %s", new Object[] { Integer.valueOf(paramConsoleMessage.lineNumber()), paramConsoleMessage.messageLevel().name(), paramConsoleMessage.message(), paramConsoleMessage.sourceId() });
    if ((paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) && (!Util.isNullOrNil(paramConsoleMessage.message())))
    {
      f.Ozc.b(19153, new Object[] { Integer.valueOf(aj.asY(1)), paramConsoleMessage.messageLevel(), Integer.valueOf(1) });
      if (!paramConsoleMessage.message().contains("SyntaxError")) {
        break label137;
      }
      as.atf(22);
    }
    for (;;)
    {
      boolean bool = super.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(126552);
      return bool;
      label137:
      if (paramConsoleMessage.message().contains("Maximum call stack size exceeded")) {
        as.atf(33);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.c.b
 * JD-Core Version:    0.7.0.1
 */