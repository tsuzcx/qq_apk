package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.TimerTask;

final class n$3
  extends TimerTask
{
  n$3(ProgressDialog paramProgressDialog, ak paramak) {}
  
  public final void run()
  {
    AppMethodBeat.i(23603);
    if (this.kTo != null)
    {
      this.kTo.dismiss();
      this.mFP.sendEmptyMessage(0);
    }
    AppMethodBeat.o(23603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.n.3
 * JD-Core Version:    0.7.0.1
 */