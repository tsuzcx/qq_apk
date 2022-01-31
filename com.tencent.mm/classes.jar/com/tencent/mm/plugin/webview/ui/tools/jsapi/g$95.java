package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class g$95
  implements d.b
{
  g$95(g paramg, String paramString, i parami) {}
  
  public final void b(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(155012);
    ab.i("MicroMsg.MsgHandler", "doUploadVoice, on cdn finish,  is success : %s, mediaid : %s, local id is : %s", new Object[] { Boolean.valueOf(paramBoolean), paramString2, paramString1 });
    if ((!bo.isNullOrNil(paramString1)) && (paramString1.equals(this.uUf)))
    {
      com.tencent.mm.plugin.webview.modeltools.g.dcD().a(this);
      if (g.E(this.vqm) != null)
      {
        g.E(this.vqm).dismiss();
        g.a(this.vqm, null);
      }
      if (!paramBoolean)
      {
        this.vqm.a(this.uZa, "uploadVoice:fail", null);
        AppMethodBeat.o(155012);
        return;
      }
      paramString1 = new HashMap();
      paramString1.put("serverId", paramString2);
      this.vqm.a(this.uZa, "uploadVoice:ok", paramString1);
    }
    AppMethodBeat.o(155012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.95
 * JD-Core Version:    0.7.0.1
 */