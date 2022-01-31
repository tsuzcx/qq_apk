package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

final class WebViewStubService$5
  extends n.a
{
  private final byte[] dhN = new byte[0];
  
  WebViewStubService$5(WebViewStubService paramWebViewStubService) {}
  
  public final void et(int paramInt)
  {
    synchronized (this.dhN)
    {
      try
      {
        Object localObject2 = s.ccc();
        Bundle localBundle = new Bundle();
        localBundle.putString("webview_network_type", (String)localObject2);
        localObject2 = WebViewStubService.h(this.rkg).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((WebViewStubCallbackWrapper)((Iterator)localObject2).next()).rno.b(90, localBundle);
        }
        localObject1 = finally;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.WebViewStubService", "notify network change failed :%s", new Object[] { localException.getMessage() });
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubService.5
 * JD-Core Version:    0.7.0.1
 */