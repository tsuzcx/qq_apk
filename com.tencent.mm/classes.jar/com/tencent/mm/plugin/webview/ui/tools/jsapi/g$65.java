package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.a;

final class g$65
  implements a
{
  g$65(g paramg, i parami) {}
  
  public final void eb(boolean paramBoolean)
  {
    AppMethodBeat.i(154986);
    if (paramBoolean)
    {
      this.vqm.a(this.uZa, "install_download_task:ok", null);
      AppMethodBeat.o(154986);
      return;
    }
    this.vqm.a(this.uZa, "install_download_task:fail", null);
    AppMethodBeat.o(154986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.65
 * JD-Core Version:    0.7.0.1
 */