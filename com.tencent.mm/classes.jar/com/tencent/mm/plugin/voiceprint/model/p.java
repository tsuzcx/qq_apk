package com.tencent.mm.plugin.voiceprint.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voiceprint.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.a.b;
import kotlin.x;

public final class p
{
  public static int dAR = 100;
  public int FKi;
  public b GRo;
  public String GRp;
  public boolean GRq;
  public a GRr;
  public a GRs;
  public com.tencent.mm.modelvoice.m doF;
  public String fileName;
  private int pkT;
  public long qPl;
  
  public p()
  {
    AppMethodBeat.i(232124);
    this.doF = null;
    this.pkT = 0;
    this.fileName = "";
    this.qPl = 0L;
    this.FKi = 0;
    this.GRq = false;
    this.GRs = null;
    this.GRr = new a(new b() {});
    AppMethodBeat.o(232124);
  }
  
  public final boolean Qt()
  {
    long l = 0L;
    AppMethodBeat.i(29808);
    this.GRr.wN(false);
    this.GRq = false;
    Log.d("MicroMsg.VoicePrintRecoder", "stop Record :" + this.fileName);
    try
    {
      Log.d("MicroMsg.VoicePrintRecoder", "stop synchronized Record :" + this.fileName);
      if (this.doF != null) {
        this.doF.ZZ();
      }
      if (this.FKi != 2)
      {
        this.fileName = null;
        this.GRq = false;
        Log.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName);
        this.FKi = -1;
        Log.d("MicroMsg.VoicePrintRecoder", "bLongEnough " + this.GRq);
        boolean bool = this.GRq;
        AppMethodBeat.o(29808);
        return bool;
      }
    }
    finally
    {
      AppMethodBeat.o(29808);
    }
    if (this.qPl <= 0L)
    {
      label194:
      this.pkT = ((int)l);
      if (this.pkT >= 1000) {
        break label277;
      }
      Log.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName + " by voiceLen: " + this.pkT);
      this.fileName = "";
      this.GRq = false;
    }
    for (;;)
    {
      this.fileName = "";
      break;
      l = Util.ticksToNow(this.qPl);
      break label194;
      label277:
      this.GRq = true;
      Log.d("MicroMsg.VoicePrintRecoder", "Stop file success: " + this.fileName);
    }
  }
  
  public static abstract interface a
  {
    public abstract void fEG();
  }
  
  final class b
    extends Thread
  {
    MMHandler handler;
    
    public b()
    {
      AppMethodBeat.i(29805);
      this.handler = new MMHandler()
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
        Log.e("MicroMsg.VoicePrintRecoder", "Stop Record Failed recorder == null");
        AppMethodBeat.o(29806);
        return;
      }
      synchronized (p.this)
      {
        String str = m.cz(p.e(p.this), true);
        Log.d("MicroMsg.VoicePrintRecoder", "fullPathName %s", new Object[] { str });
        p.this.GRp = str;
        p.this.GRr.wN(true);
        if (!p.d(p.this).hw(str))
        {
          p.f(p.this);
          Log.d("MicroMsg.VoicePrintRecoder", "Thread Start Record  Error fileName[" + p.e(p.this) + "]");
          p.d(p.this).ZZ();
          p.g(p.this);
          p.this.GRr.wN(true);
          if (p.h(p.this) != null) {
            p.h(p.this).fEG();
          }
          AppMethodBeat.o(29806);
          return;
        }
        if (p.h(p.this) != null) {
          p.h(p.this);
        }
        p.a(p.this, Util.currentTicks());
        Log.d("MicroMsg.VoicePrintRecoder", "Thread Started Record fileName[" + p.e(p.this) + "]");
        this.handler.sendEmptyMessageDelayed(0, 1L);
        AppMethodBeat.o(29806);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.p
 * JD-Core Version:    0.7.0.1
 */