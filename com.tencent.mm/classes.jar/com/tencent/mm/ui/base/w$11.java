package com.tencent.mm.ui.base;

import android.app.Activity;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class w$11
  implements Runnable
{
  w$11(r paramr, Activity paramActivity, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(142237);
    this.Wnd.showAtLocation(this.fgc.getWindow().getDecorView(), 48, 0, this.Wnf);
    AppMethodBeat.o(142237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.w.11
 * JD-Core Version:    0.7.0.1
 */