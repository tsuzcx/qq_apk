package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class ab$1
  extends ak
{
  ab$1(ab paramab, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(36363);
    super.handleMessage(paramMessage);
    if ((ab.a(this.rfP) >= 5) || (System.currentTimeMillis() - ab.b(this.rfP) > 300000L))
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.RemoveSnsTask", "cleanCount: " + ab.a(this.rfP));
      ab.ocf = false;
      AppMethodBeat.o(36363);
      return;
    }
    if (ab.c(this.rfP))
    {
      AppMethodBeat.o(36363);
      return;
    }
    if (ab.ocf) {
      new ab.a(this.rfP).v(new String[] { "" });
    }
    AppMethodBeat.o(36363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ab.1
 * JD-Core Version:    0.7.0.1
 */