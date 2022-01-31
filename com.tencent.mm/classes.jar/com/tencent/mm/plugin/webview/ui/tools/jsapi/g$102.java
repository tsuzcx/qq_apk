package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.g.a.wf.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

final class g$102
  extends c<wf>
{
  g$102(g paramg)
  {
    AppMethodBeat.i(155020);
    this.__eventId = wf.class.getName().hashCode();
    AppMethodBeat.o(155020);
  }
  
  private boolean a(wf paramwf)
  {
    AppMethodBeat.i(155021);
    ab.d("TAG", "webViewWillCloseWindowEvent callback");
    if (g.l(this.vqm) != null) {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("closeWindow. result: %d", paramwf.cNw.result);
        g.l(this.vqm).dcZ();
        g.l(this.vqm).af(localBundle);
        ab.d("MicroMsg.MsgHandler", "closeWindow. result: %d", new Object[] { Integer.valueOf(paramwf.cNw.result) });
        if (paramwf.cNw.result == -1)
        {
          this.vqm.a(g.k(this.vqm), "get_h5_transaction_request:ok", null);
          a.ymk.d(this);
          AppMethodBeat.o(155021);
          return true;
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.MsgHandler", localRemoteException, "", new Object[0]);
          continue;
          this.vqm.a(g.k(this.vqm), "get_h5_transaction_request:cancel", null);
        }
      }
    }
    AppMethodBeat.o(155021);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.102
 * JD-Core Version:    0.7.0.1
 */