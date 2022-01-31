package com.tencent.mm.ui.base;

import android.app.Activity;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t$7
  implements Runnable
{
  t$7(o paramo, Activity paramActivity, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(106877);
    this.zmZ.showAtLocation(this.gjR.getWindow().getDecorView(), 48, 0, this.znd);
    AppMethodBeat.o(106877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.t.7
 * JD-Core Version:    0.7.0.1
 */