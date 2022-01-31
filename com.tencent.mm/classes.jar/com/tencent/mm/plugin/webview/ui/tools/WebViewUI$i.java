package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WebViewUI$i
  implements b
{
  private final String vgS = "weixin://feedback/";
  
  private WebViewUI$i(WebViewUI paramWebViewUI) {}
  
  public final boolean ait(String paramString)
  {
    AppMethodBeat.i(7947);
    paramString = new Bundle();
    paramString.putInt("MMActivity.OverrideEnterAnimation", 0);
    paramString.putInt("MMActivity.OverrideExitAnimation", 2131034228);
    try
    {
      this.vgz.igU.a(7, paramString, this.vgz.hashCode());
      AppMethodBeat.o(7947);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.w("MicroMsg.WebViewUI", "FeedbackJumpHandler, ex = " + paramString.getMessage());
      }
    }
  }
  
  public final boolean aiz(String paramString)
  {
    AppMethodBeat.i(7946);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7946);
      return false;
    }
    boolean bool = u.x(paramString, "weixin://feedback/");
    AppMethodBeat.o(7946);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i
 * JD-Core Version:    0.7.0.1
 */