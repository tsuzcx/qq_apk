package com.tencent.mm.plugin.voiceprint.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voiceprint.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.b;
import d.y;

public final class p
{
  public static int cXn = 100;
  public b Awt;
  public String Awu;
  public boolean Awv;
  public a Aww;
  public a Awx;
  public com.tencent.mm.modelvoice.m cLR;
  public String fileName;
  private int ntv;
  public long oPG;
  public int zQy;
  
  public p()
  {
    AppMethodBeat.i(196102);
    this.cLR = null;
    this.ntv = 0;
    this.fileName = "";
    this.oPG = 0L;
    this.zQy = 0;
    this.Awv = false;
    this.Awx = null;
    this.Aww = new a(new b() {});
    AppMethodBeat.o(196102);
  }
  
  public final boolean Fb()
  {
    long l = 0L;
    AppMethodBeat.i(29808);
    this.Aww.so(false);
    this.Awv = false;
    ac.d("MicroMsg.VoicePrintRecoder", "stop Record :" + this.fileName);
    try
    {
      ac.d("MicroMsg.VoicePrintRecoder", "stop synchronized Record :" + this.fileName);
      if (this.cLR != null) {
        this.cLR.NX();
      }
      if (this.zQy != 2)
      {
        this.fileName = null;
        this.Awv = false;
        ac.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName);
        this.zQy = -1;
        ac.d("MicroMsg.VoicePrintRecoder", "bLongEnough " + this.Awv);
        boolean bool = this.Awv;
        AppMethodBeat.o(29808);
        return bool;
      }
    }
    finally
    {
      AppMethodBeat.o(29808);
    }
    if (this.oPG <= 0L)
    {
      label194:
      this.ntv = ((int)l);
      if (this.ntv >= 1000) {
        break label277;
      }
      ac.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName + " by voiceLen: " + this.ntv);
      this.fileName = "";
      this.Awv = false;
    }
    for (;;)
    {
      this.fileName = "";
      break;
      l = bs.aO(this.oPG);
      break label194;
      label277:
      this.Awv = true;
      ac.d("MicroMsg.VoicePrintRecoder", "Stop file success: " + this.fileName);
    }
  }
  
  public static abstract interface a
  {
    public abstract void egB();
  }
  
  final class b
    extends Thread
  {
    ao handler;
    
    public b()
    {
      AppMethodBeat.i(29805);
      this.handler = new ao()
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
        ac.e("MicroMsg.VoicePrintRecoder", "Stop Record Failed recorder == null");
        AppMethodBeat.o(29806);
        return;
      }
      synchronized (p.this)
      {
        String str = m.bW(p.e(p.this), true);
        ac.d("MicroMsg.VoicePrintRecoder", "fullPathName %s", new Object[] { str });
        p.this.Awu = str;
        p.this.Aww.so(true);
        if (!p.d(p.this).fE(str))
        {
          p.f(p.this);
          ac.d("MicroMsg.VoicePrintRecoder", "Thread Start Record  Error fileName[" + p.e(p.this) + "]");
          p.d(p.this).NX();
          p.g(p.this);
          p.this.Aww.so(true);
          if (p.h(p.this) != null) {
            p.h(p.this).egB();
          }
          AppMethodBeat.o(29806);
          return;
        }
        if (p.h(p.this) != null) {
          p.h(p.this);
        }
        p.a(p.this, bs.Gn());
        ac.d("MicroMsg.VoicePrintRecoder", "Thread Started Record fileName[" + p.e(p.this) + "]");
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