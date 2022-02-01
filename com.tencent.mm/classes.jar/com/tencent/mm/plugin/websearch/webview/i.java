package com.tencent.mm.plugin.websearch.webview;

import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.z;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchChromeClient;", "Lcom/tencent/xweb/WebChromeClient;", "()V", "TAG", "", "onConsoleMessage", "", "consoleMessage", "Landroid/webkit/ConsoleMessage;", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends z
{
  private final String TAG = "MicroMsg.WebSearch.WebSearchChromeClient";
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    String str2 = null;
    AppMethodBeat.i(315235);
    String str3 = this.TAG;
    Integer localInteger;
    Object localObject;
    label28:
    String str1;
    if (paramConsoleMessage == null)
    {
      localInteger = null;
      if (paramConsoleMessage != null) {
        break label94;
      }
      localObject = "";
      if (paramConsoleMessage != null) {
        break label129;
      }
      str1 = null;
      label35:
      if (paramConsoleMessage != null) {
        break label138;
      }
    }
    for (;;)
    {
      Log.i(str3, "onConsoleMessage %d %s %s %s", new Object[] { localInteger, localObject, str1, str2 });
      boolean bool = super.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(315235);
      return bool;
      localInteger = Integer.valueOf(paramConsoleMessage.lineNumber());
      break;
      label94:
      localObject = paramConsoleMessage.messageLevel();
      if (localObject == null)
      {
        localObject = "";
        break label28;
      }
      str1 = ((ConsoleMessage.MessageLevel)localObject).name();
      localObject = str1;
      if (str1 != null) {
        break label28;
      }
      localObject = "";
      break label28;
      label129:
      str1 = paramConsoleMessage.message();
      break label35;
      label138:
      str2 = paramConsoleMessage.sourceId();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.i
 * JD-Core Version:    0.7.0.1
 */