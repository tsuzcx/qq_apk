package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  public static void a(e parame, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126548);
    try
    {
      boolean bool = bt.isNullOrNil(paramString1);
      if (bool)
      {
        AppMethodBeat.o(126548);
        return;
      }
      paramString2 = bt.nullAsNil(paramString2);
      ad.i("MicroMsg.TopStory.TopStoryJsEventNotifier", "lxl notifyJsEvent %s %s", new Object[] { paramString1, paramString2 });
      paramString1 = String.format("javascript:window['%s'] && %s(%s)", new Object[] { paramString1, paramString1, paramString2 });
      if ((parame != null) && (parame.yST != null)) {
        parame.yST.evaluateJavascript(paramString1, null);
      }
      AppMethodBeat.o(126548);
      return;
    }
    catch (Exception parame)
    {
      ad.printErrStackTrace("MicroMsg.TopStory.TopStoryJsEventNotifier", parame, "notifyJsEvent", new Object[0]);
      AppMethodBeat.o(126548);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.a
 * JD-Core Version:    0.7.0.1
 */