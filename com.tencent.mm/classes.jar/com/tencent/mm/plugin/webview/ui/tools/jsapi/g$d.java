package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.pluginsdk.model.app.am;

final class g$d
  implements am
{
  volatile boolean bRf;
  volatile boolean edU;
  volatile boolean ggq;
  volatile boolean ggr;
  g.d.a rAI;
  
  g$d(g.d.a parama)
  {
    this.rAI = parama;
  }
  
  public final void cW(boolean paramBoolean)
  {
    this.edU = true;
    this.ggq = paramBoolean;
    if ((this.ggr) && (this.rAI != null)) {
      this.rAI.q(this.bRf, paramBoolean);
    }
  }
  
  final void cX(boolean paramBoolean)
  {
    this.bRf = paramBoolean;
    this.ggr = true;
    if ((this.edU) && (this.rAI != null)) {
      this.rAI.q(paramBoolean, this.ggq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.d
 * JD-Core Version:    0.7.0.1
 */