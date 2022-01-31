package com.tencent.mm.plugin.subapp.c;

import android.os.Message;
import com.tencent.mm.ah.j.b;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class i$a
  implements Runnable
{
  ah handler;
  
  public i$a(final i parami)
  {
    this.handler = new ah()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        if (i.c(i.a.this.pvU) <= 0) {
          return;
        }
        paramAnonymousMessage = new StringBuilder("On Part :");
        if (i.a.this.pvU.pvN == null) {}
        for (boolean bool = true;; bool = false)
        {
          y.d("MicroMsg.VoiceRemindRecorder", bool);
          i.d(i.a.this.pvU);
          if (i.a.this.pvU.pvN == null) {
            break;
          }
          i.a.this.pvU.pvN.Ku();
          return;
        }
      }
    };
  }
  
  public final void run()
  {
    if (i.e(this.pvU) == null)
    {
      y.e("MicroMsg.VoiceRemindRecorder", "Stop Record Failed recorder == null");
      return;
    }
    synchronized (this.pvU)
    {
      if (!i.e(this.pvU).cD(h.bh(i.a(this.pvU), true)))
      {
        i.PD(i.a(this.pvU));
        i.f(this.pvU);
        y.d("MicroMsg.VoiceRemindRecorder", "Thread Start Record  Error fileName[" + i.a(this.pvU) + "]");
        i.g(this.pvU);
      }
      i.a(this.pvU, bk.UZ());
      y.d("MicroMsg.VoiceRemindRecorder", "Thread Started Record fileName[" + i.a(this.pvU) + "] time:" + bk.cp(i.h(this.pvU)));
      this.handler.sendEmptyMessageDelayed(0, 1L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.i.a
 * JD-Core Version:    0.7.0.1
 */