package com.tencent.mm.plugin.topstory.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public static void a(e parame, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126548);
    try
    {
      boolean bool = Util.isNullOrNil(paramString1);
      if (bool)
      {
        AppMethodBeat.o(126548);
        return;
      }
      paramString2 = Util.nullAsNil(paramString2);
      Log.i("MicroMsg.TopStory.TopStoryJsEventNotifier", "notifyJsEvent %s %s", new Object[] { paramString1, paramString2 });
      paramString1 = String.format("javascript:window['%s'] && %s(%s)", new Object[] { paramString1, paramString1, paramString2 });
      if ((parame != null) && (parame.Gqy != null)) {
        parame.Gqy.evaluateJavascript(paramString1, null);
      }
      AppMethodBeat.o(126548);
      return;
    }
    catch (Exception parame)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryJsEventNotifier", parame, "notifyJsEvent", new Object[0]);
      AppMethodBeat.o(126548);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.a
 * JD-Core Version:    0.7.0.1
 */