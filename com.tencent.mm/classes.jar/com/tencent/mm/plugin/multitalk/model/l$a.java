package com.tencent.mm.plugin.multitalk.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class l$a
  implements Runnable
{
  int index;
  
  l$a(l paraml, int paramInt)
  {
    this.index = paramInt;
  }
  
  public final void run()
  {
    AppMethodBeat.i(54065);
    Looper.prepare();
    ab.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "start drawer handler");
    this.oUw.oUq[this.index] = new ak();
    Looper.loop();
    AppMethodBeat.o(54065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.l.a
 * JD-Core Version:    0.7.0.1
 */