package com.tencent.mm.plugin.voiceprint.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voiceprint.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.b;
import d.z;

public final class p
{
  public static int diF = 100;
  public b BVO;
  public String BVP;
  public boolean BVQ;
  public a BVR;
  public a BVS;
  public int BhZ;
  public com.tencent.mm.modelvoice.m cXf;
  public String fileName;
  private int nUr;
  public long pto;
  
  public p()
  {
    AppMethodBeat.i(193405);
    this.cXf = null;
    this.nUr = 0;
    this.fileName = "";
    this.pto = 0L;
    this.BhZ = 0;
    this.BVQ = false;
    this.BVS = null;
    this.BVR = new a(new b() {});
    AppMethodBeat.o(193405);
  }
  
  public final boolean Gv()
  {
    long l = 0L;
    AppMethodBeat.i(29808);
    this.BVR.sX(false);
    this.BVQ = false;
    ad.d("MicroMsg.VoicePrintRecoder", "stop Record :" + this.fileName);
    try
    {
      ad.d("MicroMsg.VoicePrintRecoder", "stop synchronized Record :" + this.fileName);
      if (this.cXf != null) {
        this.cXf.PG();
      }
      if (this.BhZ != 2)
      {
        this.fileName = null;
        this.BVQ = false;
        ad.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName);
        this.BhZ = -1;
        ad.d("MicroMsg.VoicePrintRecoder", "bLongEnough " + this.BVQ);
        boolean bool = this.BVQ;
        AppMethodBeat.o(29808);
        return bool;
      }
    }
    finally
    {
      AppMethodBeat.o(29808);
    }
    if (this.pto <= 0L)
    {
      label194:
      this.nUr = ((int)l);
      if (this.nUr >= 1000) {
        break label277;
      }
      ad.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName + " by voiceLen: " + this.nUr);
      this.fileName = "";
      this.BVQ = false;
    }
    for (;;)
    {
      this.fileName = "";
      break;
      l = bt.aO(this.pto);
      break label194;
      label277:
      this.BVQ = true;
      ad.d("MicroMsg.VoicePrintRecoder", "Stop file success: " + this.fileName);
    }
  }
  
  public static abstract interface a
  {
    public abstract void eum();
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
        String str = m.cd(p.e(p.this), true);
        ad.d("MicroMsg.VoicePrintRecoder", "fullPathName %s", new Object[] { str });
        p.this.BVP = str;
        p.this.BVR.sX(true);
        if (!p.d(p.this).gz(str))
        {
          p.f(p.this);
          ad.d("MicroMsg.VoicePrintRecoder", "Thread Start Record  Error fileName[" + p.e(p.this) + "]");
          p.d(p.this).PG();
          p.g(p.this);
          p.this.BVR.sX(true);
          if (p.h(p.this) != null) {
            p.h(p.this).eum();
          }
          AppMethodBeat.o(29806);
          return;
        }
        if (p.h(p.this) != null) {
          p.h(p.this);
        }
        p.a(p.this, bt.HI());
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