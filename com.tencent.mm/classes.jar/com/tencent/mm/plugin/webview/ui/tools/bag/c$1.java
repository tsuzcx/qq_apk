package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$1
  implements g.a
{
  c$1(c paramc) {}
  
  public final boolean aZ(boolean paramBoolean)
  {
    AppMethodBeat.i(8152);
    if (paramBoolean)
    {
      this.vhB.vhz.bm(1.0F);
      this.vhB.vhz.f(this.vhB.vhA, 21);
      AppMethodBeat.o(8152);
      return true;
    }
    this.vhB.vhz.bm(0.0F);
    AppMethodBeat.o(8152);
    return false;
  }
  
  public final void bl(float paramFloat)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(8150);
    f localf = this.vhB.vhz;
    if (paramFloat < 0.15F) {
      paramFloat = 0.0F;
    }
    for (;;)
    {
      localf.bm(paramFloat);
      AppMethodBeat.o(8150);
      return;
      float f2 = 2.0F * paramFloat;
      paramFloat = f1;
      if (f2 <= 1.0F) {
        paramFloat = f2;
      }
    }
  }
  
  public final void l(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(8151);
    this.vhB.vhA = paramMotionEvent.getRawX();
    AppMethodBeat.o(8151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.c.1
 * JD-Core Version:    0.7.0.1
 */