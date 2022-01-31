package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class g$80
  implements d.b
{
  g$80(g paramg, String paramString1, String paramString2, i parami) {}
  
  public final void b(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(155001);
    ab.i("MicroMsg.MsgHandler", this.isO + " on cdn finish,  is success : %s, mediaid : %s, local id is : %s, mediaUrl : %s", new Object[] { Boolean.valueOf(paramBoolean), paramString2, paramString1, paramString3 });
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
        this.vqm.a(this.uZa, this.isO + ":fail", null);
        AppMethodBeat.o(155001);
        return;
      }
      paramString1 = new HashMap();
      paramString1.put("serverId", paramString2);
      paramString1.put("mediaUrl", paramString3);
      this.vqm.a(this.uZa, this.isO + ":ok", paramString1);
    }
    AppMethodBeat.o(155001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.80
 * JD-Core Version:    0.7.0.1
 */