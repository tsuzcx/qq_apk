package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WebViewUI$a
  implements b
{
  private WebViewUI$a(WebViewUI paramWebViewUI) {}
  
  public final boolean ait(String paramString)
  {
    AppMethodBeat.i(7886);
    if (!this.vgz.igV.ddW().dqv())
    {
      ab.e("MicroMsg.WebViewUI", "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", new Object[] { paramString });
      AppMethodBeat.o(7886);
      return true;
    }
    try
    {
      this.vgz.igU.bN(paramString, this.vgz.igV.ddV().jy(7));
      AppMethodBeat.o(7886);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.w("MicroMsg.WebViewUI", "ActivityJumpHandler, ex = " + paramString.getMessage());
      }
    }
  }
  
  public final boolean aiz(String paramString)
  {
    AppMethodBeat.i(7885);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7885);
      return false;
    }
    boolean bool = u.x(paramString, "weixin://jump/");
    AppMethodBeat.o(7885);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.a
 * JD-Core Version:    0.7.0.1
 */