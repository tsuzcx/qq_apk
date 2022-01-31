package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WebViewUI$b
  implements b
{
  public final String vgI = "weixin://addfriend/";
  
  private WebViewUI$b(WebViewUI paramWebViewUI) {}
  
  public final boolean ait(String paramString)
  {
    AppMethodBeat.i(7888);
    if (!this.vgz.igV.ddV().jy(5))
    {
      ab.e("MicroMsg.WebViewUI", "AddFriendHandler, permission fail");
      AppMethodBeat.o(7888);
      return true;
    }
    paramString = paramString.substring(19);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7888);
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("from_webview", true);
    localBundle.putString("userName", paramString);
    try
    {
      this.vgz.igU.a(8, localBundle, this.vgz.hashCode());
      AppMethodBeat.o(7888);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.w("MicroMsg.WebViewUI", "AddFriendHandler, ex = " + paramString.getMessage());
      }
    }
  }
  
  public final boolean aiz(String paramString)
  {
    AppMethodBeat.i(7887);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7887);
      return false;
    }
    boolean bool = u.x(paramString, "weixin://addfriend/");
    AppMethodBeat.o(7887);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b
 * JD-Core Version:    0.7.0.1
 */