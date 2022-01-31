package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  public static void a(e parame, String paramString1, String paramString2)
  {
    AppMethodBeat.i(2143);
    try
    {
      boolean bool = bo.isNullOrNil(paramString1);
      if (bool)
      {
        AppMethodBeat.o(2143);
        return;
      }
      paramString2 = bo.nullAsNil(paramString2);
      ab.i("MicroMsg.TopStory.TopStoryJsEventNotifier", "lxl notifyJsEvent %s %s", new Object[] { paramString1, paramString2 });
      paramString1 = String.format("javascript:window['%s'] && %s(%s)", new Object[] { paramString1, paramString1, paramString2 });
      if ((parame != null) && (parame.tmg != null)) {
        parame.tmg.evaluateJavascript(paramString1, null);
      }
      AppMethodBeat.o(2143);
      return;
    }
    catch (Exception parame)
    {
      ab.printErrStackTrace("MicroMsg.TopStory.TopStoryJsEventNotifier", parame, "notifyJsEvent", new Object[0]);
      AppMethodBeat.o(2143);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.a
 * JD-Core Version:    0.7.0.1
 */