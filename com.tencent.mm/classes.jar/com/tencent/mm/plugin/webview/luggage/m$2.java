package com.tencent.mm.plugin.webview.luggage;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.bag.g.a;
import com.tencent.mm.ui.widget.SwipeBackLayout.b;

final class m$2
  implements SwipeBackLayout.b
{
  m$2(m paramm, g.a parama) {}
  
  public final boolean aZ(boolean paramBoolean)
  {
    AppMethodBeat.i(6204);
    if (this.uSI != null)
    {
      paramBoolean = this.uSI.aZ(paramBoolean);
      AppMethodBeat.o(6204);
      return paramBoolean;
    }
    AppMethodBeat.o(6204);
    return false;
  }
  
  public final void bk(float paramFloat)
  {
    AppMethodBeat.i(6202);
    if (this.uSI != null) {
      this.uSI.bl(paramFloat);
    }
    AppMethodBeat.o(6202);
  }
  
  public final void l(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(6203);
    if (this.uSI != null) {
      this.uSI.l(paramMotionEvent);
    }
    AppMethodBeat.o(6203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.m.2
 * JD-Core Version:    0.7.0.1
 */