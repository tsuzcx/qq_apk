package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uz;
import com.tencent.mm.g.a.uz.b;
import java.util.HashMap;
import java.util.Map;

final class g$46
  implements Runnable
{
  g$46(g paramg, uz paramuz, i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(154970);
    if (this.tUy.cLy.retCode == 0)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("buffer", this.tUy.cLy.buffer);
      this.vqm.a(this.uZa, "handleWCPayWalletBuffer:ok", localHashMap);
      AppMethodBeat.o(154970);
      return;
    }
    if (this.tUy.cLy.retCode == -2)
    {
      this.vqm.a(this.uZa, "handleWCPayWalletBuffer:null", null);
      AppMethodBeat.o(154970);
      return;
    }
    this.vqm.a(this.uZa, "handleWCPayWalletBuffer:fail", null);
    AppMethodBeat.o(154970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.46
 * JD-Core Version:    0.7.0.1
 */