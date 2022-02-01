package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class ad$1$1
  implements Runnable
{
  ad$1$1(ad.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(114619);
    if (ad.eYc().cNL())
    {
      Log.i("MicroMsg.SubCoreMultiTalk", "multitalk resume on app foreground");
      q localq = ad.eYc();
      if (localq.Fsz != null)
      {
        Log.i("MicroMsg.MT.MultiTalkManager", "on multitalk resume");
        localq.a(localq.Fsz.FsP, localq.Fsz.FsQ);
        localq.eXr();
      }
      AppMethodBeat.o(114619);
      return;
    }
    Log.i("MicroMsg.SubCoreMultiTalk", "do not need resume multitalk ");
    AppMethodBeat.o(114619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.ad.1.1
 * JD-Core Version:    0.7.0.1
 */