package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.pluginsdk.n;

final class WebViewStubService$1$2
  implements Runnable
{
  WebViewStubService$1$2(WebViewStubService.1 param1, Bundle paramBundle1, Bundle paramBundle2) {}
  
  public final void run()
  {
    AppMethodBeat.i(7106);
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.putExtras(this.cax);
    localIntent.putExtra("isFromWebView", true);
    localIntent.putExtra("_stat_obj", this.hyb);
    a.gmO.q(localIntent, this.uZB.uZy);
    AppMethodBeat.o(7106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubService.1.2
 * JD-Core Version:    0.7.0.1
 */