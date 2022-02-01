package com.tencent.mm.plugin.webview.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.xweb.WebView;

public final class a
{
  public WebView Cjl = null;
  public boolean CkP = false;
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final boolean _customEnterFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(205343);
    ac.i("MicroMsg.CustomFullscreenApi", "_customEnterFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    paramBoolean = un(paramBoolean);
    AppMethodBeat.o(205343);
    return paramBoolean;
  }
  
  public final boolean un(boolean paramBoolean)
  {
    AppMethodBeat.i(205344);
    ac.i("MicroMsg.CustomFullscreenApi", "setCustomEnterFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.Cjl == null) || (!this.Cjl.isXWalkKernel()))
    {
      AppMethodBeat.o(205344);
      return false;
    }
    if (!((b)g.ab(b.class)).isMpUrl(this.Cjl.getUrl()))
    {
      AppMethodBeat.o(205344);
      return false;
    }
    this.Cjl.disableVideoJsCallback(paramBoolean);
    this.CkP = paramBoolean;
    AppMethodBeat.o(205344);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.b.a
 * JD-Core Version:    0.7.0.1
 */