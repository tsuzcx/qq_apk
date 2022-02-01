package com.tencent.mm.plugin.webview.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/prefecher/WebPrefetcherJsApiConfigManager;", "", "()V", "TAG", "", "canUpdateRandomStr", "", "Ljava/lang/Integer;", "enableDigestVerify", "enablePrefetcherJsWebCodeCache", "", "enablePrefetcherJsXWebCodeCache", "webView", "Lcom/tencent/xweb/WebView;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b WPQ;
  private static Integer WPR;
  private static Integer WPS;
  
  static
  {
    AppMethodBeat.i(294598);
    WPQ = new b();
    AppMethodBeat.o(294598);
  }
  
  public static final boolean iwv()
  {
    AppMethodBeat.i(294590);
    if (WPR != null)
    {
      localInteger = WPR;
      if (localInteger == null) {}
      while (localInteger.intValue() != 1)
      {
        AppMethodBeat.o(294590);
        return false;
      }
      AppMethodBeat.o(294590);
      return true;
    }
    WPR = Integer.valueOf(((c)h.ax(c.class)).a(c.a.zgC, 1));
    Log.i("MicroMsg.WebPrefetcherJsApiConfigManager ", s.X("enableDigestVerify ", WPR));
    Integer localInteger = WPR;
    if (localInteger == null) {}
    while (localInteger.intValue() != 1)
    {
      AppMethodBeat.o(294590);
      return false;
    }
    AppMethodBeat.o(294590);
    return true;
  }
  
  public static final boolean iww()
  {
    AppMethodBeat.i(294593);
    if (WPS != null)
    {
      localInteger = WPS;
      if (localInteger == null) {}
      while (localInteger.intValue() != 1)
      {
        AppMethodBeat.o(294593);
        return false;
      }
      AppMethodBeat.o(294593);
      return true;
    }
    WPS = Integer.valueOf(((c)h.ax(c.class)).a(c.a.zgD, 1));
    Log.i("MicroMsg.WebPrefetcherJsApiConfigManager ", s.X("canUpdateRandomStr ", WPS));
    Integer localInteger = WPS;
    if (localInteger == null) {}
    while (localInteger.intValue() != 1)
    {
      AppMethodBeat.o(294593);
      return false;
    }
    AppMethodBeat.o(294593);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.b
 * JD-Core Version:    0.7.0.1
 */