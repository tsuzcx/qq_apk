package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.h.a.tf;
import com.tencent.mm.h.a.tf.b;
import java.util.HashMap;
import java.util.Map;

final class g$40
  implements Runnable
{
  g$40(g paramg, tf paramtf, i parami) {}
  
  public final void run()
  {
    if (this.qln.ccP.retCode == 0)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("buffer", this.qln.ccP.buffer);
      g.a(this.rzi, this.rzk, "handleWCPayWalletBuffer:ok", localHashMap);
      return;
    }
    if (this.qln.ccP.retCode == -2)
    {
      g.a(this.rzi, this.rzk, "handleWCPayWalletBuffer:null", null);
      return;
    }
    g.a(this.rzi, this.rzk, "handleWCPayWalletBuffer:fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.40
 * JD-Core Version:    0.7.0.1
 */