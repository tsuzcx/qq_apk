package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.pluginsdk.wallet.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class g$39
  implements b.a
{
  g$39(g paramg, i parami) {}
  
  public final void onSuccess(String paramString)
  {
    y.i("MicroMsg.MsgHandler", "secureTunnel callback success");
    HashMap localHashMap = new HashMap();
    localHashMap.put("respbuf", paramString);
    g.a(this.rzi, this.rzk, "secureTunnel:ok", localHashMap);
  }
  
  public final void uv(String paramString)
  {
    y.i("MicroMsg.MsgHandler", "secureTunnel callback fail");
    HashMap localHashMap = new HashMap();
    localHashMap.put("err_desc", paramString);
    g.a(this.rzi, this.rzk, "secureTunnel:fail", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.39
 * JD-Core Version:    0.7.0.1
 */