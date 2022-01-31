package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.n;

final class g$115
  implements n
{
  g$115(g paramg, i parami) {}
  
  public final void nP(int paramInt)
  {
    AppMethodBeat.i(155035);
    switch (paramInt)
    {
    default: 
      this.vqm.a(this.uZa, "quickly_add_contact:fail", null);
      AppMethodBeat.o(155035);
      return;
    case -2: 
      this.vqm.a(this.uZa, "quickly_add_contact:added", null);
      AppMethodBeat.o(155035);
      return;
    case 0: 
      this.vqm.a(this.uZa, "quickly_add_contact:cancel", null);
      AppMethodBeat.o(155035);
      return;
    case -1: 
      this.vqm.a(this.uZa, "quickly_add_contact:fail", null);
      AppMethodBeat.o(155035);
      return;
    }
    this.vqm.a(this.uZa, "quickly_add_contact:ok", null);
    AppMethodBeat.o(155035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.115
 * JD-Core Version:    0.7.0.1
 */