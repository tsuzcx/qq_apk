package com.tencent.mm.plugin.multitalk.a;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class k$1
  implements Runnable
{
  public k$1(k paramk) {}
  
  public final void run()
  {
    Looper.prepare();
    y.i("MicroMsg.MT.MultiTalkVideoNativeReceiver", "start native drawer handler");
    this.muw.muu = new ah();
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.k.1
 * JD-Core Version:    0.7.0.1
 */