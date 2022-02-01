package com.tencent.mm.ui.chatting;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;

final class z$1
  extends ao
{
  z$1(z paramz, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(34790);
    if ((this.HPN.nUj == null) || (!az.agM()))
    {
      AppMethodBeat.o(34790);
      return;
    }
    ac.d("MicroMsg.EggMgr", "post start egg");
    this.HPN.a(this.HPN.HPL, this.HPN.nUj);
    AppMethodBeat.o(34790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.z.1
 * JD-Core Version:    0.7.0.1
 */