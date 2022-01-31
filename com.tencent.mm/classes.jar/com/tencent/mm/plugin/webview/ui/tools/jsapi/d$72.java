package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

final class d$72
  implements Runnable
{
  d$72(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(154920);
    String str = d.a(this.voP, "html");
    if (d.hB(str, this.voX))
    {
      if ((d.n(this.voP) == null) || (d.d(this.voP) == null)) {
        break label108;
      }
      try
      {
        d.n(this.voP).I(1, d.d(this.voP).getUrl(), str);
        AppMethodBeat.o(154920);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        ab.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[] { localRemoteException.getMessage() });
        AppMethodBeat.o(154920);
        return;
      }
    }
    ab.e("MicroMsg.JsApiHandler", "failed to write Html file");
    label108:
    AppMethodBeat.o(154920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.72
 * JD-Core Version:    0.7.0.1
 */