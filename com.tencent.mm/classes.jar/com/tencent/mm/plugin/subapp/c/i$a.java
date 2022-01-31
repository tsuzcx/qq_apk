package com.tencent.mm.plugin.subapp.c;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j.b;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class i$a
  implements Runnable
{
  ak handler;
  
  public i$a(final i parami)
  {
    AppMethodBeat.i(25296);
    this.handler = new ak()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(25295);
        if (i.c(i.a.this.sXA) <= 0)
        {
          AppMethodBeat.o(25295);
          return;
        }
        paramAnonymousMessage = new StringBuilder("On Part :");
        if (i.a.this.sXA.sXt == null) {}
        for (boolean bool = true;; bool = false)
        {
          ab.d("MicroMsg.VoiceRemindRecorder", bool);
          i.d(i.a.this.sXA);
          if (i.a.this.sXA.sXt != null) {
            i.a.this.sXA.sXt.adp();
          }
          AppMethodBeat.o(25295);
          return;
        }
      }
    };
    AppMethodBeat.o(25296);
  }
  
  public final void run()
  {
    AppMethodBeat.i(25297);
    if (i.e(this.sXA) == null)
    {
      ab.e("MicroMsg.VoiceRemindRecorder", "Stop Record Failed recorder == null");
      AppMethodBeat.o(25297);
      return;
    }
    synchronized (this.sXA)
    {
      if (!i.e(this.sXA).eH(h.bE(i.a(this.sXA), true)))
      {
        i.adT(i.a(this.sXA));
        i.f(this.sXA);
        ab.d("MicroMsg.VoiceRemindRecorder", "Thread Start Record  Error fileName[" + i.a(this.sXA) + "]");
        i.g(this.sXA);
      }
      i.a(this.sXA, bo.yB());
      ab.d("MicroMsg.VoiceRemindRecorder", "Thread Started Record fileName[" + i.a(this.sXA) + "] time:" + bo.av(i.h(this.sXA)));
      this.handler.sendEmptyMessageDelayed(0, 1L);
      AppMethodBeat.o(25297);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.i.a
 * JD-Core Version:    0.7.0.1
 */