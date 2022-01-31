package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.pluginsdk.ui.applet.n;

final class g$36
  implements n
{
  g$36(g paramg, i parami) {}
  
  public final void lg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      g.a(this.rzi, this.rzk, "add_contact:fail", null);
      return;
    case -2: 
      g.a(this.rzi, this.rzk, "add_contact:added", null);
      return;
    case 0: 
      g.a(this.rzi, this.rzk, "add_contact:cancel", null);
      return;
    case -1: 
      g.a(this.rzi, this.rzk, "add_contact:fail", null);
      return;
    }
    g.a(this.rzi, this.rzk, "add_contact:ok", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.36
 * JD-Core Version:    0.7.0.1
 */