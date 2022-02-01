package com.tencent.mm.plugin.webcanvas;

import com.tencent.luggage.game.b.d;
import com.tencent.magicbrush.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$mbLogDelegateRegistry$1", "Lcom/tencent/luggage/game/handler/MBLogDelegateRegistry;", "loadNativeLibs", "", "webview-sdk_release"})
public final class c$s
  extends d
{
  public final void CB()
  {
    AppMethodBeat.i(224471);
    super.CB();
    b.loadLibrary("gamelog_delegate");
    AppMethodBeat.o(224471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.c.s
 * JD-Core Version:    0.7.0.1
 */