package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.ai;

final class g$d
  implements ai
{
  volatile boolean cyH;
  volatile boolean ftW;
  volatile boolean hyp;
  volatile boolean hyq;
  g.d.a vrK;
  
  g$d(g.d.a parama)
  {
    this.vrK = parama;
  }
  
  public final void dZ(boolean paramBoolean)
  {
    AppMethodBeat.i(9213);
    this.ftW = true;
    this.hyp = paramBoolean;
    if ((this.hyq) && (this.vrK != null)) {
      this.vrK.r(this.cyH, paramBoolean);
    }
    AppMethodBeat.o(9213);
  }
  
  final void ea(boolean paramBoolean)
  {
    AppMethodBeat.i(9214);
    this.cyH = paramBoolean;
    this.hyq = true;
    if ((this.ftW) && (this.vrK != null)) {
      this.vrK.r(paramBoolean, this.hyp);
    }
    AppMethodBeat.o(9214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.d
 * JD-Core Version:    0.7.0.1
 */