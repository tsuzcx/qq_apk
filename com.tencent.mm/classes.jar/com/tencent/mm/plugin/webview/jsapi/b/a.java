package com.tencent.mm.plugin.webview.jsapi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.api.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;

public final class a
{
  public WebView WDl = null;
  public boolean WFi = false;
  
  public final boolean IE(boolean paramBoolean)
  {
    AppMethodBeat.i(295250);
    Log.i("MicroMsg.CustomFullscreenApi", "setCustomEnterFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.WDl == null) || (!this.WDl.isXWalkKernel()))
    {
      AppMethodBeat.o(295250);
      return false;
    }
    if (!((c)h.ax(c.class)).isMpUrl(this.WDl.getUrl()))
    {
      AppMethodBeat.o(295250);
      return false;
    }
    this.WDl.disableVideoJsCallback(paramBoolean);
    this.WFi = paramBoolean;
    AppMethodBeat.o(295250);
    return true;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final boolean _customEnterFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(295239);
    Log.i("MicroMsg.CustomFullscreenApi", "_customEnterFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    paramBoolean = IE(paramBoolean);
    AppMethodBeat.o(295239);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.b.a
 * JD-Core Version:    0.7.0.1
 */