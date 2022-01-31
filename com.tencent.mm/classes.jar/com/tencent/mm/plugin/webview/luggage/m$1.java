package com.tencent.mm.plugin.webview.luggage;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.bag.g.a;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;

final class m$1
  implements SwipeBackLayout.a
{
  m$1(m paramm, g.a parama) {}
  
  public final boolean aZ(boolean paramBoolean)
  {
    AppMethodBeat.i(6201);
    if (this.uSI != null)
    {
      paramBoolean = this.uSI.aZ(paramBoolean);
      AppMethodBeat.o(6201);
      return paramBoolean;
    }
    AppMethodBeat.o(6201);
    return false;
  }
  
  public final void g(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(6199);
    if (this.uSI != null) {
      this.uSI.bl(paramFloat);
    }
    AppMethodBeat.o(6199);
  }
  
  public final void l(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(6200);
    if (this.uSI != null) {
      this.uSI.l(paramMotionEvent);
    }
    AppMethodBeat.o(6200);
  }
  
  public final void uA() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.m.1
 * JD-Core Version:    0.7.0.1
 */