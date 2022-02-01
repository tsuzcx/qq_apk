package com.tencent.mm.plugin.webcanvas;

import com.tencent.luggage.game.b.e;
import com.tencent.magicbrush.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine$mbLogDelegateRegistry$1", "Lcom/tencent/luggage/game/handler/MBLogDelegateRegistry;", "loadNativeLibs", "", "webview-sdk_release"})
public final class k$f
  extends e
{
  public final void OP()
  {
    AppMethodBeat.i(209208);
    super.OP();
    b.loadLibrary("gamelog_delegate");
    AppMethodBeat.o(209208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.k.f
 * JD-Core Version:    0.7.0.1
 */