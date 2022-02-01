package com.tencent.mm.plugin.voiceprint.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voiceprint.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.a.b;
import d.z;

public final class p
{
  public static int djH = 100;
  public int Bzx;
  public b Cnp;
  public String Cnq;
  public boolean Cnr;
  public a Cns;
  public a Cnt;
  public com.tencent.mm.modelvoice.m cYc;
  public String fileName;
  private int nZX;
  public long pzU;
  
  public p()
  {
    AppMethodBeat.i(186684);
    this.cYc = null;
    this.nZX = 0;
    this.fileName = "";
    this.pzU = 0L;
    this.Bzx = 0;
    this.Cnr = false;
    this.Cnt = null;
    this.Cns = new a(new b() {});
    AppMethodBeat.o(186684);
  }
  
  public final boolean GB()
  {
    long l = 0L;
    AppMethodBeat.i(29808);
    this.Cns.te(false);
    this.Cnr = false;
    ae.d("MicroMsg.VoicePrintRecoder", "stop Record :" + this.fileName);
    try
    {
      ae.d("MicroMsg.VoicePrintRecoder", "stop synchronized Record :" + this.fileName);
      if (this.cYc != null) {
        this.cYc.PF();
      }
      if (this.Bzx != 2)
      {
        this.fileName = null;
        this.Cnr = false;
        ae.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName);
        this.Bzx = -1;
        ae.d("MicroMsg.VoicePrintRecoder", "bLongEnough " + this.Cnr);
        boolean bool = this.Cnr;
        AppMethodBeat.o(29808);
        return bool;
      }
    }
    finally
    {
      AppMethodBeat.o(29808);
    }
    if (this.pzU <= 0L)
    {
      label194:
      this.nZX = ((int)l);
      if (this.nZX >= 1000) {
        break label277;
      }
      ae.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName + " by voiceLen: " + this.nZX);
      this.fileName = "";
      this.Cnr = false;
    }
    for (;;)
    {
      this.fileName = "";
      break;
      l = bu.aO(this.pzU);
      break label194;
      label277:
      this.Cnr = true;
      ae.d("MicroMsg.VoicePrintRecoder", "Stop file success: " + this.fileName);
    }
  }
  
  public static abstract interface a
  {
    public abstract void exS();
  }
  
  final class b
    extends Thread
  {
    aq handler;
    
    public b()
    {
      AppMethodBeat.i(29805);
      this.handler = new aq()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(29804);
          if (p.b(p.this) <= 0)
          {
            AppMethodBeat.o(29804);
            return;
          }
          p.c(p.this);
          AppMethodBeat.o(29804);
        }
      };
      AppMethodBeat.o(29805);
    }
    
    public final void run()
    {
      AppMethodBeat.i(29806);
      if (p.d(p.this) == null)
      {
        ae.e("MicroMsg.VoicePrintRecoder", "Stop Record Failed recorder == null");
        AppMethodBeat.o(29806);
        return;
      }
      synchronized (p.this)
      {
        String str = m.ch(p.e(p.this), true);
        ae.d("MicroMsg.VoicePrintRecoder", "fullPathName %s", new Object[] { str });
        p.this.Cnq = str;
        p.this.Cns.te(true);
        if (!p.d(p.this).gF(str))
        {
          p.f(p.this);
          ae.d("MicroMsg.VoicePrintRecoder", "Thread Start Record  Error fileName[" + p.e(p.this) + "]");
          p.d(p.this).PF();
          p.g(p.this);
          p.this.Cns.te(true);
          if (p.h(p.this) != null) {
            p.h(p.this).exS();
          }
          AppMethodBeat.o(29806);
          return;
        }
        if (p.h(p.this) != null) {
          p.h(p.this);
        }
        p.a(p.this, bu.HQ());
        ae.d("MicroMsg.VoicePrintRecoder", "Thread Started Record fileName[" + p.e(p.this) + "]");
        this.handler.sendEmptyMessageDelayed(0, 1L);
        AppMethodBeat.o(29806);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.p
 * JD-Core Version:    0.7.0.1
 */