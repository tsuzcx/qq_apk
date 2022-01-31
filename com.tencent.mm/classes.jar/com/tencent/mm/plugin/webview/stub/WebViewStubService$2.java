package com.tencent.mm.plugin.webview.stub;

import android.os.RemoteException;
import com.tencent.mm.h.a.nb;
import com.tencent.mm.h.a.nb.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class WebViewStubService$2
  extends c<nb>
{
  WebViewStubService$2(WebViewStubService paramWebViewStubService)
  {
    this.udX = nb.class.getName().hashCode();
  }
  
  private boolean a(nb paramnb)
  {
    if (!(paramnb instanceof nb)) {}
    for (;;)
    {
      return false;
      if ((WebViewStubService.i(this.rkg) != null) && (!WebViewStubService.i(this.rkg).containsKey(paramnb.bWI.filePath))) {
        continue;
      }
      if (WebViewStubService.i(this.rkg) != null) {
        WebViewStubService.i(this.rkg).remove(paramnb.bWI.filePath);
      }
      y.d("MicroMsg.WebViewStubService", "result: " + paramnb.bWI.result);
      try
      {
        Iterator localIterator = WebViewStubService.h(this.rkg).iterator();
        while (localIterator.hasNext()) {
          ((WebViewStubCallbackWrapper)localIterator.next()).rno.e(paramnb.bWI.filePath, paramnb.bWI.result, paramnb.bWI.bIj, paramnb.bWI.bIk);
        }
        return false;
      }
      catch (RemoteException paramnb)
      {
        y.printErrStackTrace("MicroMsg.WebViewStubService", paramnb, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubService.2
 * JD-Core Version:    0.7.0.1
 */