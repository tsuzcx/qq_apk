package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class g$40$1
  implements Runnable
{
  g$40$1(g.40 param40) {}
  
  public final void run()
  {
    AppMethodBeat.i(154962);
    String str = ar.ad(this.vqO.vqN);
    ab.i("MicroMsg.MsgHandler", "after parse to json data : %s", new Object[] { str });
    if (g.E(this.vqO.vqm) != null) {
      g.E(this.vqO.vqm).dismiss();
    }
    ab.i("MicroMsg.MsgHandler", "after parse to json data : %s", new Object[] { str });
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", Integer.valueOf(1));
    localHashMap.put("localIds", str);
    this.vqO.vqm.a(g.k(this.vqO.vqm), "chooseHaowanMedia:ok", localHashMap);
    AppMethodBeat.o(154962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.40.1
 * JD-Core Version:    0.7.0.1
 */