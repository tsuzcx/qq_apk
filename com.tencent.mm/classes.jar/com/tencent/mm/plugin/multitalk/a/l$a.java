package com.tencent.mm.plugin.multitalk.a;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

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
    Looper.prepare();
    y.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "start drawer handler");
    this.muH.muB[this.index] = new ah();
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.l.a
 * JD-Core Version:    0.7.0.1
 */