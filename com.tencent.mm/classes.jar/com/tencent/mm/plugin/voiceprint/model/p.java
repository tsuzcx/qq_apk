package com.tencent.mm.plugin.voiceprint.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voiceprint.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.ah;
import kotlin.g.a.b;

public final class p
{
  public static int hxV = 100;
  public int SFv;
  public String UtA;
  public boolean UtB;
  public a UtC;
  public a UtD;
  public b Utz;
  public String fileName;
  public com.tencent.mm.modelvoice.m hlu;
  private int vza;
  public long xxM;
  
  public p()
  {
    AppMethodBeat.i(272665);
    this.hlu = null;
    this.vza = 0;
    this.fileName = "";
    this.xxM = 0L;
    this.SFv = 0;
    this.UtB = false;
    this.UtD = null;
    this.UtC = new a(new b() {});
    AppMethodBeat.o(272665);
  }
  
  public final boolean stop()
  {
    long l = 0L;
    AppMethodBeat.i(29808);
    this.UtC.Ge(false);
    this.UtB = false;
    Log.d("MicroMsg.VoicePrintRecoder", "stop Record :" + this.fileName);
    try
    {
      Log.d("MicroMsg.VoicePrintRecoder", "stop synchronized Record :" + this.fileName);
      if (this.hlu != null) {
        this.hlu.aGH();
      }
      if (this.SFv != 2)
      {
        this.fileName = null;
        this.UtB = false;
        Log.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName);
        this.SFv = -1;
        Log.d("MicroMsg.VoicePrintRecoder", "bLongEnough " + this.UtB);
        boolean bool = this.UtB;
        AppMethodBeat.o(29808);
        return bool;
      }
    }
    finally
    {
      AppMethodBeat.o(29808);
    }
    if (this.xxM <= 0L)
    {
      label194:
      this.vza = ((int)l);
      if (this.vza >= 1000) {
        break label277;
      }
      Log.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName + " by voiceLen: " + this.vza);
      this.fileName = "";
      this.UtB = false;
    }
    for (;;)
    {
      this.fileName = "";
      break;
      l = Util.ticksToNow(this.xxM);
      break label194;
      label277:
      this.UtB = true;
      Log.d("MicroMsg.VoicePrintRecoder", "Stop file success: " + this.fileName);
    }
  }
  
  public static abstract interface a
  {
    public abstract void hUQ();
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
        String str = m.dt(p.e(p.this), true);
        Log.d("MicroMsg.VoicePrintRecoder", "fullPathName %s", new Object[] { str });
        p.this.UtA = str;
        p.this.UtC.Ge(true);
        if (!p.d(p.this).jL(str))
        {
          p.f(p.this);
          Log.d("MicroMsg.VoicePrintRecoder", "Thread Start Record  Error fileName[" + p.e(p.this) + "]");
          p.d(p.this).aGH();
          p.g(p.this);
          p.this.UtC.Ge(true);
          if (p.h(p.this) != null) {
            p.h(p.this).hUQ();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.p
 * JD-Core Version:    0.7.0.1
 */