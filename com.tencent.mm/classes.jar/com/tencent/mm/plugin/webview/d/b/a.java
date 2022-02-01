package com.tencent.mm.plugin.webview.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;

public final class a
{
  public WebView IQP = null;
  public boolean ISC = false;
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final boolean _customEnterFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(224453);
    Log.i("MicroMsg.CustomFullscreenApi", "_customEnterFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    paramBoolean = zb(paramBoolean);
    AppMethodBeat.o(224453);
    return paramBoolean;
  }
  
  public final boolean zb(boolean paramBoolean)
  {
    AppMethodBeat.i(224454);
    Log.i("MicroMsg.CustomFullscreenApi", "setCustomEnterFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.IQP == null) || (!this.IQP.isXWalkKernel()))
    {
      AppMethodBeat.o(224454);
      return false;
    }
    if (!((b)g.af(b.class)).isMpUrl(this.IQP.getUrl()))
    {
      AppMethodBeat.o(224454);
      return false;
    }
    this.IQP.disableVideoJsCallback(paramBoolean);
    this.ISC = paramBoolean;
    AppMethodBeat.o(224454);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.b.a
 * JD-Core Version:    0.7.0.1
 */