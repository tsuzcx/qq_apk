package com.tencent.mm.plugin.voiceprint.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voiceprint.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.b;
import d.y;

public final class p
{
  public static int cZR = 100;
  public com.tencent.mm.modelvoice.m cOw;
  public String fileName;
  private int mRf;
  public long omg;
  public int yDk;
  public b zdN;
  public String zdO;
  public boolean zdP;
  public a zdQ;
  public a zdR;
  
  public p()
  {
    AppMethodBeat.i(191273);
    this.cOw = null;
    this.mRf = 0;
    this.fileName = "";
    this.omg = 0L;
    this.yDk = 0;
    this.zdP = false;
    this.zdR = null;
    this.zdQ = new a(new b() {});
    AppMethodBeat.o(191273);
  }
  
  public final boolean Ft()
  {
    long l = 0L;
    AppMethodBeat.i(29808);
    this.zdQ.rn(false);
    this.zdP = false;
    ad.d("MicroMsg.VoicePrintRecoder", "stop Record :" + this.fileName);
    try
    {
      ad.d("MicroMsg.VoicePrintRecoder", "stop synchronized Record :" + this.fileName);
      if (this.cOw != null) {
        this.cOw.Ob();
      }
      if (this.yDk != 2)
      {
        this.fileName = null;
        this.zdP = false;
        ad.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName);
        this.yDk = -1;
        ad.d("MicroMsg.VoicePrintRecoder", "bLongEnough " + this.zdP);
        boolean bool = this.zdP;
        AppMethodBeat.o(29808);
        return bool;
      }
    }
    finally
    {
      AppMethodBeat.o(29808);
    }
    if (this.omg <= 0L)
    {
      label194:
      this.mRf = ((int)l);
      if (this.mRf >= 1000) {
        break label277;
      }
      ad.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName + " by voiceLen: " + this.mRf);
      this.fileName = "";
      this.zdP = false;
    }
    for (;;)
    {
      this.fileName = "";
      break;
      l = bt.aS(this.omg);
      break label194;
      label277:
      this.zdP = true;
      ad.d("MicroMsg.VoicePrintRecoder", "Stop file success: " + this.fileName);
    }
  }
  
  public static abstract interface a
  {
    public abstract void dRr();
  }
  
  final class b
    extends Thread
  {
    ap handler;
    
    public b()
    {
      AppMethodBeat.i(29805);
      this.handler = new ap()
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
        ad.e("MicroMsg.VoicePrintRecoder", "Stop Record Failed recorder == null");
        AppMethodBeat.o(29806);
        return;
      }
      synchronized (p.this)
      {
        String str = m.bP(p.e(p.this), true);
        ad.d("MicroMsg.VoicePrintRecoder", "fullPathName %s", new Object[] { str });
        p.this.zdO = str;
        p.this.zdQ.rn(true);
        if (!p.d(p.this).fO(str))
        {
          p.f(p.this);
          ad.d("MicroMsg.VoicePrintRecoder", "Thread Start Record  Error fileName[" + p.e(p.this) + "]");
          p.d(p.this).Ob();
          p.g(p.this);
          p.this.zdQ.rn(true);
          if (p.h(p.this) != null) {
            p.h(p.this).dRr();
          }
          AppMethodBeat.o(29806);
          return;
        }
        if (p.h(p.this) != null) {
          p.h(p.this);
        }
        p.a(p.this, bt.GC());
        ad.d("MicroMsg.VoicePrintRecoder", "Thread Started Record fileName[" + p.e(p.this) + "]");
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