package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebViewStubService$9
  implements Runnable
{
  WebViewStubService$9(WebViewStubService paramWebViewStubService, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(153167);
    this.uZy.startActivity(this.val$intent);
    AppMethodBeat.o(153167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubService.9
 * JD-Core Version:    0.7.0.1
 */