package com.tencent.mm.plugin.record.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class h$1
  extends ak
{
  h$1(h paramh, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(24228);
    if (paramMessage.what == 1)
    {
      ab.d("MicroMsg.RecordMsgBaseAdapter", "do play music");
      this.pZx.notifyDataSetChanged();
    }
    AppMethodBeat.o(24228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.h.1
 * JD-Core Version:    0.7.0.1
 */