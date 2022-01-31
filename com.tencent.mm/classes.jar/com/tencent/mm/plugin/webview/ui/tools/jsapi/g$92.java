package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.h.a.ul;
import com.tencent.mm.h.a.ul.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;

final class g$92
  extends c<ul>
{
  g$92(g paramg)
  {
    this.udX = ul.class.getName().hashCode();
  }
  
  private boolean a(ul paramul)
  {
    y.d("TAG", "webViewWillCloseWindowEvent callback");
    if (g.D(this.rzi) != null) {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("closeWindow. result: %d", paramul.ceQ.result);
        g.D(this.rzi).cde();
        g.D(this.rzi).N(localBundle);
        y.d("MicroMsg.MsgHandler", "closeWindow. result: %d", new Object[] { Integer.valueOf(paramul.ceQ.result) });
        if (paramul.ceQ.result == -1)
        {
          g.a(this.rzi, g.j(this.rzi), "get_h5_transaction_request:ok", null);
          a.udP.d(this);
          return true;
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.MsgHandler", localRemoteException, "", new Object[0]);
          continue;
          g.a(this.rzi, g.j(this.rzi), "get_h5_transaction_request:cancel", null);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.92
 * JD-Core Version:    0.7.0.1
 */