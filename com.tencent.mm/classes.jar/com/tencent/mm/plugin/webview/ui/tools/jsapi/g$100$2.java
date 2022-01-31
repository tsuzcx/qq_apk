package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fr;
import com.tencent.mm.g.a.fr.b;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class g$100$2
  implements Runnable
{
  g$100$2(g.100 param100, fr paramfr) {}
  
  public final void run()
  {
    AppMethodBeat.i(155018);
    if (this.vrt.ctU.aLC)
    {
      if (g.E(this.vrs.vqm) != null)
      {
        g.E(this.vrs.vqm).dismiss();
        g.a(this.vrs.vqm, null);
      }
      if (bo.isNullOrNil(this.vrt.ctU.content))
      {
        this.vrs.vqm.a(this.vrs.uZa, "translateVoice:fail", null);
        AppMethodBeat.o(155018);
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("translateResult", this.vrt.ctU.content);
      this.vrs.vqm.a(this.vrs.uZa, "translateVoice:ok", localHashMap);
    }
    AppMethodBeat.o(155018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.100.2
 * JD-Core Version:    0.7.0.1
 */