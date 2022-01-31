package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;

final class WebViewStubService$7
  extends n.a
{
  private final byte[] dZg;
  
  WebViewStubService$7(WebViewStubService paramWebViewStubService)
  {
    AppMethodBeat.i(155693);
    this.dZg = new byte[0];
    AppMethodBeat.o(155693);
  }
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(155694);
    synchronized (this.dZg)
    {
      try
      {
        Object localObject2 = u.dcf();
        Bundle localBundle = new Bundle();
        localBundle.putString("webview_network_type", (String)localObject2);
        localObject2 = WebViewStubService.f(this.uZy).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((WebViewStubCallbackWrapper)((Iterator)localObject2).next()).vdZ.e(90, localBundle);
        }
        localObject1 = finally;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.WebViewStubService", "notify network change failed :%s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(155694);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubService.7
 * JD-Core Version:    0.7.0.1
 */