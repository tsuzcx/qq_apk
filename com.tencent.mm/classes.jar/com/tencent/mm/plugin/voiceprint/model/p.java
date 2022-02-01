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
  public static int ftG = 100;
  public int Mef;
  public String NHA;
  public boolean NHB;
  public a NHC;
  public a NHD;
  public b NHz;
  public com.tencent.mm.modelvoice.m fhj;
  public String fileName;
  private int snc;
  public long urr;
  
  public p()
  {
    AppMethodBeat.i(283567);
    this.fhj = null;
    this.snc = 0;
    this.fileName = "";
    this.urr = 0L;
    this.Mef = 0;
    this.NHB = false;
    this.NHD = null;
    this.NHC = new a(new b() {});
    AppMethodBeat.o(283567);
  }
  
  public final boolean TV()
  {
    long l = 0L;
    AppMethodBeat.i(29808);
    this.NHC.AF(false);
    this.NHB = false;
    Log.d("MicroMsg.VoicePrintRecoder", "stop Record :" + this.fileName);
    try
    {
      Log.d("MicroMsg.VoicePrintRecoder", "stop synchronized Record :" + this.fileName);
      if (this.fhj != null) {
        this.fhj.aeJ();
      }
      if (this.Mef != 2)
      {
        this.fileName = null;
        this.NHB = false;
        Log.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName);
        this.Mef = -1;
        Log.d("MicroMsg.VoicePrintRecoder", "bLongEnough " + this.NHB);
        boolean bool = this.NHB;
        AppMethodBeat.o(29808);
        return bool;
      }
    }
    finally
    {
      AppMethodBeat.o(29808);
    }
    if (this.urr <= 0L)
    {
      label194:
      this.snc = ((int)l);
      if (this.snc >= 1000) {
        break label277;
      }
      Log.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName + " by voiceLen: " + this.snc);
      this.fileName = "";
      this.NHB = false;
    }
    for (;;)
    {
      this.fileName = "";
      break;
      l = Util.ticksToNow(this.urr);
      break label194;
      label277:
      this.NHB = true;
      Log.d("MicroMsg.VoicePrintRecoder", "Stop file success: " + this.fileName);
    }
  }
  
  public static abstract interface a
  {
    public abstract void gwT();
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
        String str = m.cN(p.e(p.this), true);
        Log.d("MicroMsg.VoicePrintRecoder", "fullPathName %s", new Object[] { str });
        p.this.NHA = str;
        p.this.NHC.AF(true);
        if (!p.d(p.this).ik(str))
        {
          p.f(p.this);
          Log.d("MicroMsg.VoicePrintRecoder", "Thread Start Record  Error fileName[" + p.e(p.this) + "]");
          p.d(p.this).aeJ();
          p.g(p.this);
          p.this.NHC.AF(true);
          if (p.h(p.this) != null) {
            p.h(p.this).gwT();
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