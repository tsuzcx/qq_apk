package com.tencent.mm.plugin.webview.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;

public final class a
{
  public WebView PNe = null;
  public boolean POV = false;
  
  public final boolean CW(boolean paramBoolean)
  {
    AppMethodBeat.i(206840);
    Log.i("MicroMsg.CustomFullscreenApi", "setCustomEnterFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.PNe == null) || (!this.PNe.isXWalkKernel()))
    {
      AppMethodBeat.o(206840);
      return false;
    }
    if (!((c)h.ae(c.class)).isMpUrl(this.PNe.getUrl()))
    {
      AppMethodBeat.o(206840);
      return false;
    }
    this.PNe.disableVideoJsCallback(paramBoolean);
    this.POV = paramBoolean;
    AppMethodBeat.o(206840);
    return true;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final boolean _customEnterFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(206839);
    Log.i("MicroMsg.CustomFullscreenApi", "_customEnterFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    paramBoolean = CW(paramBoolean);
    AppMethodBeat.o(206839);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.b.a
 * JD-Core Version:    0.7.0.1
 */