package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Map;

final class d$71
  implements Runnable
{
  d$71(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(153330);
    Map localMap = d.M(this.voW.split(","));
    String str = d.a(this.voP, "hosts");
    if (d.D(str, localMap))
    {
      if ((d.n(this.voP) == null) || (d.d(this.voP) == null)) {
        break label118;
      }
      try
      {
        d.n(this.voP).I(0, d.d(this.voP).getUrl(), str);
        AppMethodBeat.o(153330);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        ab.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[] { localRemoteException.getMessage() });
        AppMethodBeat.o(153330);
        return;
      }
    }
    ab.e("MicroMsg.JsApiHandler", "failed to write Hosts file");
    label118:
    AppMethodBeat.o(153330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.71
 * JD-Core Version:    0.7.0.1
 */