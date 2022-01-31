package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;

final class WebViewUI$40
  implements Runnable
{
  WebViewUI$40(WebViewUI paramWebViewUI, Uri paramUri) {}
  
  public final void run()
  {
    AppMethodBeat.i(153248);
    WebViewUI localWebViewUI = this.vgz;
    Object localObject = this.ini;
    if ((localWebViewUI == null) || (localObject == null))
    {
      ab.i("MicroMsg.AppInfoLogic", "launchApp failed, context or uri is null.");
      AppMethodBeat.o(153248);
      return;
    }
    ab.i("MicroMsg.AppInfoLogic", "try to launchApp with uri.");
    localObject = new Intent("android.intent.action.VIEW", (Uri)localObject);
    ((Intent)localObject).addFlags(268435456);
    g.a(localWebViewUI, (Intent)localObject, null, null, null);
    AppMethodBeat.o(153248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.40
 * JD-Core Version:    0.7.0.1
 */