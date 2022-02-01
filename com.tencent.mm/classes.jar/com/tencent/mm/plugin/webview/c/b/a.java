package com.tencent.mm.plugin.webview.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.WebView;

public final class a
{
  public WebView DMr = null;
  public boolean DNU = false;
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final boolean _customEnterFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(213945);
    ad.i("MicroMsg.CustomFullscreenApi", "_customEnterFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    paramBoolean = vb(paramBoolean);
    AppMethodBeat.o(213945);
    return paramBoolean;
  }
  
  public final boolean vb(boolean paramBoolean)
  {
    AppMethodBeat.i(213946);
    ad.i("MicroMsg.CustomFullscreenApi", "setCustomEnterFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.DMr == null) || (!this.DMr.isXWalkKernel()))
    {
      AppMethodBeat.o(213946);
      return false;
    }
    if (!((b)g.ab(b.class)).isMpUrl(this.DMr.getUrl()))
    {
      AppMethodBeat.o(213946);
      return false;
    }
    this.DMr.disableVideoJsCallback(paramBoolean);
    this.DNU = paramBoolean;
    AppMethodBeat.o(213946);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.b.a
 * JD-Core Version:    0.7.0.1
 */