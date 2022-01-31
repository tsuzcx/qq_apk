package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URLDecoder;

final class WebViewUI$z
  implements b
{
  private WebViewUI$z(WebViewUI paramWebViewUI) {}
  
  public final boolean Tq(String paramString)
  {
    paramString = paramString.substring(25);
    try
    {
      paramString = URLDecoder.decode(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putString("nowUrl", WebViewUI.aS(this.rpH));
      localBundle.putString("tweetid", bk.pm(this.rpH.getIntent().getStringExtra("tweetid")));
      localBundle.putString("htmlData", paramString);
      localBundle.putInt("type", this.rpH.getIntent().getIntExtra("type", 0));
      this.rpH.gGn.a(3, localBundle, this.rpH.hashCode());
      return true;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.WebViewUI", "edw ViewImageGetHtmlHandler handleUrl, ex = " + paramString.getMessage());
    }
    return false;
  }
  
  public final boolean Ty(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return s.n(paramString, "weixin://private/gethtml/");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.z
 * JD-Core Version:    0.7.0.1
 */