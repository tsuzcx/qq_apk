package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class p$b
  extends Thread
{
  ah handler;
  
  public p$b(p paramp)
  {
    this.handler = new p.b.1(this, paramp);
  }
  
  public final void run()
  {
    if (p.d(this.pLL) == null)
    {
      y.e("MicroMsg.VoicePrintRecoder", "Stop Record Failed recorder == null");
      return;
    }
    synchronized (this.pLL)
    {
      String str = m.bh(p.e(this.pLL), true);
      y.d("MicroMsg.VoicePrintRecoder", "fullPathName %s", new Object[] { str });
      this.pLL.pLI = str;
      if (p.f(this.pLL) != null) {
        p.f(this.pLL).requestFocus();
      }
      if (!p.d(this.pLL).cD(str))
      {
        p.g(this.pLL);
        y.d("MicroMsg.VoicePrintRecoder", "Thread Start Record  Error fileName[" + p.e(this.pLL) + "]");
        p.d(this.pLL).uh();
        p.h(this.pLL);
        if (p.f(this.pLL) != null) {
          p.f(this.pLL).zE();
        }
        if (p.i(this.pLL) != null) {
          p.i(this.pLL).bPd();
        }
        return;
      }
    }
    p.a(this.pLL, bk.UZ());
    y.d("MicroMsg.VoicePrintRecoder", "Thread Started Record fileName[" + p.e(this.pLL) + "]");
    this.handler.sendEmptyMessageDelayed(0, 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.p.b
 * JD-Core Version:    0.7.0.1
 */