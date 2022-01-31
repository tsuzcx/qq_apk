package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class p$b
  extends Thread
{
  ak handler;
  
  public p$b(p paramp)
  {
    AppMethodBeat.i(26124);
    this.handler = new p.b.1(this, paramp);
    AppMethodBeat.o(26124);
  }
  
  public final void run()
  {
    AppMethodBeat.i(26125);
    if (p.d(this.trH) == null)
    {
      ab.e("MicroMsg.VoicePrintRecoder", "Stop Record Failed recorder == null");
      AppMethodBeat.o(26125);
      return;
    }
    synchronized (this.trH)
    {
      String str = m.bE(p.e(this.trH), true);
      ab.d("MicroMsg.VoicePrintRecoder", "fullPathName %s", new Object[] { str });
      this.trH.trE = str;
      if (p.f(this.trH) != null) {
        p.f(this.trH).requestFocus();
      }
      if (!p.d(this.trH).eH(str))
      {
        p.g(this.trH);
        ab.d("MicroMsg.VoicePrintRecoder", "Thread Start Record  Error fileName[" + p.e(this.trH) + "]");
        p.d(this.trH).Et();
        p.h(this.trH);
        if (p.f(this.trH) != null) {
          p.f(this.trH).Mh();
        }
        if (p.i(this.trH) != null) {
          p.i(this.trH).cLj();
        }
        AppMethodBeat.o(26125);
        return;
      }
      if (p.i(this.trH) != null) {
        p.i(this.trH);
      }
      p.a(this.trH, bo.yB());
      ab.d("MicroMsg.VoicePrintRecoder", "Thread Started Record fileName[" + p.e(this.trH) + "]");
      this.handler.sendEmptyMessageDelayed(0, 1L);
      AppMethodBeat.o(26125);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.p.b
 * JD-Core Version:    0.7.0.1
 */