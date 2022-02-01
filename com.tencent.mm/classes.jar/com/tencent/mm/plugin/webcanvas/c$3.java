package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$4", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "webview-sdk_release"})
public final class c$3
  extends o.a
{
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(224470);
    p.h(paramString, "activity");
    this.DQa.evaluateJavascript("WeixinCore.emit('background')", null);
    AppMethodBeat.o(224470);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(224469);
    p.h(paramString, "activity");
    this.DQa.evaluateJavascript("WeixinCore.emit('foreground')", null);
    AppMethodBeat.o(224469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.c.3
 * JD-Core Version:    0.7.0.1
 */