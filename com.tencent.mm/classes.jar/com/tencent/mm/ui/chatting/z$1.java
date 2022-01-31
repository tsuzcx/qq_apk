package com.tencent.mm.ui.chatting;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class z$1
  extends ak
{
  z$1(z paramz, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(30916);
    if ((this.zBG.kmd == null) || (!aw.RG()))
    {
      AppMethodBeat.o(30916);
      return;
    }
    ab.d("MicroMsg.EggMgr", "post start egg");
    this.zBG.a(this.zBG.zBF, this.zBG.kmd);
    AppMethodBeat.o(30916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.z.1
 * JD-Core Version:    0.7.0.1
 */