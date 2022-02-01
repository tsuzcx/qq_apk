package com.tencent.mm.ui.chatting;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

final class z$1
  extends ap
{
  z$1(z paramz, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(34790);
    if ((this.GpV.nrj == null) || (!az.afw()))
    {
      AppMethodBeat.o(34790);
      return;
    }
    ad.d("MicroMsg.EggMgr", "post start egg");
    this.GpV.a(this.GpV.GpT, this.GpV.nrj);
    AppMethodBeat.o(34790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.z.1
 * JD-Core Version:    0.7.0.1
 */