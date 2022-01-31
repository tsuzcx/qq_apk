package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class p$6
  implements Runnable
{
  p$6(p paramp, Activity paramActivity) {}
  
  public final void run()
  {
    AppMethodBeat.i(81206);
    p localp = this.qAf;
    Activity localActivity = this.val$activity;
    this.val$activity.getString(2131297087);
    localp.eeN = h.b(localActivity, this.val$activity.getString(2131302249), true, new p.6.1(this));
    AppMethodBeat.o(81206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.p.6
 * JD-Core Version:    0.7.0.1
 */