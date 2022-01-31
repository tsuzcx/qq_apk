package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLDecoder;

final class WebViewUI$x
  implements b
{
  private WebViewUI$x(WebViewUI paramWebViewUI) {}
  
  public final boolean ait(String paramString)
  {
    AppMethodBeat.i(7977);
    paramString = paramString.substring(25);
    try
    {
      paramString = URLDecoder.decode(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putString("nowUrl", WebViewUI.R(this.vgz));
      localBundle.putString("tweetid", bo.nullAsNil(this.vgz.getIntent().getStringExtra("tweetid")));
      localBundle.putString("htmlData", paramString);
      localBundle.putInt("type", this.vgz.getIntent().getIntExtra("type", 0));
      this.vgz.igU.a(3, localBundle, this.vgz.hashCode());
      AppMethodBeat.o(7977);
      return true;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.WebViewUI", "edw ViewImageGetHtmlHandler handleUrl, ex = " + paramString.getMessage());
      AppMethodBeat.o(7977);
    }
    return false;
  }
  
  public final boolean aiz(String paramString)
  {
    AppMethodBeat.i(7976);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7976);
      return false;
    }
    boolean bool = u.x(paramString, "weixin://private/gethtml/");
    AppMethodBeat.o(7976);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.x
 * JD-Core Version:    0.7.0.1
 */