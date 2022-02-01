package com.tencent.mm.plugin.webview.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.xweb.WebView;

public final class a
{
  public WebView Eep = null;
  public boolean EfT = false;
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final boolean _customEnterFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(213774);
    ae.i("MicroMsg.CustomFullscreenApi", "_customEnterFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    paramBoolean = vj(paramBoolean);
    AppMethodBeat.o(213774);
    return paramBoolean;
  }
  
  public final boolean vj(boolean paramBoolean)
  {
    AppMethodBeat.i(213775);
    ae.i("MicroMsg.CustomFullscreenApi", "setCustomEnterFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.Eep == null) || (!this.Eep.isXWalkKernel()))
    {
      AppMethodBeat.o(213775);
      return false;
    }
    if (!((b)g.ab(b.class)).isMpUrl(this.Eep.getUrl()))
    {
      AppMethodBeat.o(213775);
      return false;
    }
    this.Eep.disableVideoJsCallback(paramBoolean);
    this.EfT = paramBoolean;
    AppMethodBeat.o(213775);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.b.a
 * JD-Core Version:    0.7.0.1
 */