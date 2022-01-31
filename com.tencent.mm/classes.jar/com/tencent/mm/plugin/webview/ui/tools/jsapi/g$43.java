package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.n;

final class g$43
  implements n
{
  g$43(g paramg, i parami) {}
  
  public final void nP(int paramInt)
  {
    AppMethodBeat.i(154965);
    switch (paramInt)
    {
    default: 
      this.vqm.a(this.uZa, "add_contact:fail", null);
      AppMethodBeat.o(154965);
      return;
    case -2: 
      this.vqm.a(this.uZa, "add_contact:added", null);
      AppMethodBeat.o(154965);
      return;
    case 0: 
      this.vqm.a(this.uZa, "add_contact:cancel", null);
      AppMethodBeat.o(154965);
      return;
    case -1: 
      this.vqm.a(this.uZa, "add_contact:fail", null);
      AppMethodBeat.o(154965);
      return;
    }
    this.vqm.a(this.uZa, "add_contact:ok", null);
    AppMethodBeat.o(154965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.43
 * JD-Core Version:    0.7.0.1
 */