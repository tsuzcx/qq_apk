package com.tencent.mm.ui.base;

import android.app.Activity;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t$6
  implements Runnable
{
  t$6(o paramo, Activity paramActivity, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(142237);
    this.HAu.showAtLocation(this.iuN.getWindow().getDecorView(), 48, 0, this.HAw);
    AppMethodBeat.o(142237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.t.6
 * JD-Core Version:    0.7.0.1
 */