package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.p;
import java.util.TimerTask;

final class j$5
  extends TimerTask
{
  j$5(p paramp, ak paramak) {}
  
  public final void run()
  {
    AppMethodBeat.i(23552);
    if (this.oBu != null)
    {
      this.oBu.dismiss();
      this.mFP.sendEmptyMessage(0);
    }
    AppMethodBeat.o(23552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.j.5
 * JD-Core Version:    0.7.0.1
 */