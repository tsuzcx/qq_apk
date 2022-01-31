package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.p;
import java.util.TimerTask;

final class f$3
  extends TimerTask
{
  f$3(p paramp, ak paramak) {}
  
  public final void run()
  {
    AppMethodBeat.i(23511);
    if (this.oBu != null)
    {
      this.oBu.dismiss();
      this.mFP.sendEmptyMessage(0);
    }
    AppMethodBeat.o(23511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.f.3
 * JD-Core Version:    0.7.0.1
 */