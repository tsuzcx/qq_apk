package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$59
  implements Runnable
{
  WebViewUI$59(WebViewUI paramWebViewUI, Uri paramUri) {}
  
  public final void run()
  {
    WebViewUI localWebViewUI = this.rpH;
    Object localObject = this.gLS;
    if ((localWebViewUI == null) || (localObject == null))
    {
      y.i("MicroMsg.AppInfoLogic", "launchApp failed, context or uri is null.");
      return;
    }
    y.i("MicroMsg.AppInfoLogic", "try to launchApp with uri.");
    localObject = new Intent("android.intent.action.VIEW", (Uri)localObject);
    ((Intent)localObject).addFlags(268435456);
    g.a(localWebViewUI, (Intent)localObject, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.59
 * JD-Core Version:    0.7.0.1
 */