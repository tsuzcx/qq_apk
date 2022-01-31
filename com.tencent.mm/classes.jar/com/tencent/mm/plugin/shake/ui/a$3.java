package com.tencent.mm.plugin.shake.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.TimerTask;

final class a$3
  extends TimerTask
{
  a$3(ProgressDialog paramProgressDialog, ak paramak) {}
  
  public final void run()
  {
    AppMethodBeat.i(24691);
    if (this.kTo != null)
    {
      this.kTo.dismiss();
      this.mFP.sendEmptyMessage(0);
    }
    AppMethodBeat.o(24691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.a.3
 * JD-Core Version:    0.7.0.1
 */