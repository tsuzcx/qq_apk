package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aeb;
import com.tencent.mm.autogen.a.aeb.a;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

class MsgHandler$90
  extends IListener<aeb>
{
  MsgHandler$90(j paramj, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(297233);
    this.__eventId = aeb.class.getName().hashCode();
    AppMethodBeat.o(297233);
  }
  
  private boolean a(aeb paramaeb)
  {
    AppMethodBeat.i(297240);
    Log.d("TAG", "webViewWillCloseWindowEvent callback");
    if (j.k(this.XjI) != null) {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("closeWindow. result: %d", paramaeb.iip.result);
        j.k(this.XjI).ioZ();
        j.k(this.XjI).aF(localBundle);
        Log.d("MicroMsg.MsgHandler", "closeWindow. result: %d", new Object[] { Integer.valueOf(paramaeb.iip.result) });
        if (paramaeb.iip.result == -1)
        {
          this.XjI.callback(j.j(this.XjI), "get_h5_transaction_request:ok", null);
          dead();
          AppMethodBeat.o(297240);
          return true;
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.MsgHandler", localRemoteException, "", new Object[0]);
          continue;
          this.XjI.callback(j.j(this.XjI), "get_h5_transaction_request:cancel", null);
        }
      }
    }
    AppMethodBeat.o(297240);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.MsgHandler.90
 * JD-Core Version:    0.7.0.1
 */