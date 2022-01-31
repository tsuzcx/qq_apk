package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class i$1
  extends ak
{
  i$1(i parami) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(81154);
    if ((paramMessage != null) && (paramMessage.what == 1) && (this.qzl.ivt != null)) {
      this.qzl.ivt.setVisibility(0);
    }
    AppMethodBeat.o(81154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.i.1
 * JD-Core Version:    0.7.0.1
 */