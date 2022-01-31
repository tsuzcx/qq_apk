package com.tencent.mm.plugin.webview.ui.tools.jsapi;

final class g$6
  implements Runnable
{
  g$6(g paramg, i parami) {}
  
  public final void run()
  {
    if (this.rzk.rAO.equals("login")) {
      g.a(this.rzi, this.rzk, g.cgz());
    }
    while (!this.rzk.rAO.equals("authorize")) {
      return;
    }
    g.b(this.rzi, this.rzk, g.cgz());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.6
 * JD-Core Version:    0.7.0.1
 */