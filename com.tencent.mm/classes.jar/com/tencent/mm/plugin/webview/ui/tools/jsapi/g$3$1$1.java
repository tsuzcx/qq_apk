package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class g$3$1$1
  implements g.d.a
{
  g$3$1$1(g.3.1 param1) {}
  
  public final void r(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(154921);
    ab.i("MicroMsg.MsgHandler", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      this.vqo.vqn.vqm.a(this.vqo.vqn.uZa, "launchApplication:ok", null);
      AppMethodBeat.o(154921);
      return;
    }
    this.vqo.vqn.vqm.a(this.vqo.vqn.uZa, "launchApplication:fail", null);
    AppMethodBeat.o(154921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.3.1.1
 * JD-Core Version:    0.7.0.1
 */