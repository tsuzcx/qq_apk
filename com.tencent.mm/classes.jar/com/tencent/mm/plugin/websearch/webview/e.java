package com.tencent.mm.plugin.websearch.webview;

import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.x;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchChromeClient;", "Lcom/tencent/xweb/WebChromeClient;", "()V", "TAG", "", "onConsoleMessage", "", "consoleMessage", "Landroid/webkit/ConsoleMessage;", "ui-websearch_release"})
public final class e
  extends x
{
  private final String TAG = "MicroMsg.WebSearch.WebSearchChromeClient";
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    String str2 = null;
    AppMethodBeat.i(197942);
    String str3 = this.TAG;
    Integer localInteger;
    Object localObject;
    if (paramConsoleMessage != null)
    {
      localInteger = Integer.valueOf(paramConsoleMessage.lineNumber());
      if (paramConsoleMessage != null)
      {
        localObject = paramConsoleMessage.messageLevel();
        if (localObject != null)
        {
          str1 = ((ConsoleMessage.MessageLevel)localObject).name();
          localObject = str1;
          if (str1 != null) {
            break label61;
          }
        }
      }
      localObject = "";
      label61:
      if (paramConsoleMessage == null) {
        break label129;
      }
    }
    label129:
    for (String str1 = paramConsoleMessage.message();; str1 = null)
    {
      if (paramConsoleMessage != null) {
        str2 = paramConsoleMessage.sourceId();
      }
      Log.i(str3, "onConsoleMessage %d %s %s %s", new Object[] { localInteger, localObject, str1, str2 });
      boolean bool = super.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(197942);
      return bool;
      localInteger = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.e
 * JD-Core Version:    0.7.0.1
 */