package com.tencent.mm.plugin.webview.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.WebView;

public final class a
{
  public WebView AQY = null;
  public boolean ASC = false;
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final boolean _customEnterFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(189714);
    ad.i("MicroMsg.CustomFullscreenApi", "_customEnterFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    paramBoolean = tl(paramBoolean);
    AppMethodBeat.o(189714);
    return paramBoolean;
  }
  
  public final boolean tl(boolean paramBoolean)
  {
    AppMethodBeat.i(189715);
    ad.i("MicroMsg.CustomFullscreenApi", "setCustomEnterFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.AQY == null) || (!this.AQY.isXWalkKernel()))
    {
      AppMethodBeat.o(189715);
      return false;
    }
    if (!((b)g.ab(b.class)).isMpUrl(this.AQY.getUrl()))
    {
      AppMethodBeat.o(189715);
      return false;
    }
    this.AQY.disableVideoJsCallback(paramBoolean);
    this.ASC = paramBoolean;
    AppMethodBeat.o(189715);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.b.a
 * JD-Core Version:    0.7.0.1
 */