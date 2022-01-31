package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

final class g$45
  implements c.a
{
  g$45(g paramg, i parami) {}
  
  public final void CF(String paramString)
  {
    AppMethodBeat.i(9100);
    ab.i("MicroMsg.MsgHandler", "secureTunnel callback fail");
    HashMap localHashMap = new HashMap();
    localHashMap.put("err_desc", paramString);
    this.vqm.a(this.uZa, "secureTunnel:fail", localHashMap);
    AppMethodBeat.o(9100);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(154969);
    ab.i("MicroMsg.MsgHandler", "secureTunnel callback success");
    HashMap localHashMap = new HashMap();
    localHashMap.put("respbuf", paramString);
    this.vqm.a(this.uZa, "secureTunnel:ok", localHashMap);
    AppMethodBeat.o(154969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.45
 * JD-Core Version:    0.7.0.1
 */