package com.tencent.mm.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.p;

final class DataTransferUI$1
  extends ak
{
  DataTransferUI$1(DataTransferUI paramDataTransferUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(29190);
    if ((DataTransferUI.a(this.yWa) != null) && (DataTransferUI.a(this.yWa).isShowing()))
    {
      ab.e("MicroMsg.DataTransferUI", "dialog has shown for a long time, auto dismiss it...");
      DataTransferUI.a(this.yWa).dismiss();
      this.yWa.finish();
    }
    AppMethodBeat.o(29190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.DataTransferUI.1
 * JD-Core Version:    0.7.0.1
 */