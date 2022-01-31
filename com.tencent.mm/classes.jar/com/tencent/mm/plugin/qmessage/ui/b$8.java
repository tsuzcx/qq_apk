package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.TimerTask;

final class b$8
  extends TimerTask
{
  b$8(ProgressDialog paramProgressDialog, ak paramak) {}
  
  public final void run()
  {
    AppMethodBeat.i(24109);
    if (this.kTo != null)
    {
      this.kTo.dismiss();
      this.mFP.sendEmptyMessage(0);
    }
    AppMethodBeat.o(24109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.b.8
 * JD-Core Version:    0.7.0.1
 */