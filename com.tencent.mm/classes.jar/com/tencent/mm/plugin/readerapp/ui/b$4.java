package com.tencent.mm.plugin.readerapp.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.TimerTask;

final class b$4
  extends TimerTask
{
  b$4(ProgressDialog paramProgressDialog, ak paramak) {}
  
  public final void run()
  {
    AppMethodBeat.i(76789);
    if (this.kTo != null)
    {
      this.kTo.dismiss();
      this.mFP.sendEmptyMessage(0);
    }
    AppMethodBeat.o(76789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.b.4
 * JD-Core Version:    0.7.0.1
 */