package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.qafpapi.QAFPNative;

public final class b
  implements h
{
  private int PAP;
  private k.a PAS;
  private byte[] PAX;
  private int PAY;
  private int PAZ;
  private long PBa;
  private int PBb;
  private boolean PBc;
  private f PBd;
  private boolean PBe;
  private boolean PBf;
  private int PBg;
  private boolean PBh;
  private long PBi;
  private int PBj;
  private boolean PBk;
  private c hvI;
  private c.a hwR;
  private Object wrI;
  
  public b()
  {
    AppMethodBeat.i(28263);
    this.PAX = new byte[10240];
    this.PAY = 0;
    this.PAZ = 0;
    this.PBa = 0L;
    this.PBb = f.aLV();
    this.PBc = false;
    this.PBd = null;
    this.wrI = new Object();
    this.PAS = null;
    this.PBe = false;
    this.PBf = false;
    this.PAP = 0;
    this.PBh = false;
    this.PBk = false;
    this.hwR = new c.a()
    {
      public final void ds(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] arg1, int paramAnonymousInt)
      {
        AppMethodBeat.i(28259);
        f.a locala = new f.a();
        long l;
        for (;;)
        {
          synchronized (b.a(b.this))
          {
            int i;
            if (b.b(b.this) == 408)
            {
              Log.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPProcessTV");
              i = QAFPNative.QAFPProcessTV(???, paramAnonymousInt);
              l = Util.nowMilliSecond() - b.c(b.this);
              Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPProcess clientid:%d pcm:%d ret:%d dur:%d usetime:%d", new Object[] { Integer.valueOf(b.d(b.this)), Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), Long.valueOf(l), Long.valueOf(locala.aPY()) });
              if (l <= b.e(b.this) * 3000 + 4000) {
                break label410;
              }
              ??? = new byte[10240];
              ??? = new f.a();
              if (b.b(b.this) == 408)
              {
                Log.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPGetAudioFingerPrintTV");
                paramAnonymousInt = QAFPNative.QAFPGetAudioFingerPrintTV((byte[])???);
                Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d outLen:%d time:%d", new Object[] { Integer.valueOf(b.d(b.this)), Integer.valueOf(paramAnonymousInt), Long.valueOf(???.aPY()) });
                if ((paramAnonymousInt < 10240) && (paramAnonymousInt > 0)) {
                  break;
                }
                Log.e("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d  out ret:%d  !stop record now", new Object[] { Integer.valueOf(b.d(b.this)), Integer.valueOf(paramAnonymousInt) });
                b.f(b.this);
                AppMethodBeat.o(28259);
              }
            }
            else
            {
              i = QAFPNative.QAFPProcess(???, paramAnonymousInt);
            }
          }
          paramAnonymousInt = QAFPNative.QAFPGetAudioFingerPrint((byte[])???);
        }
        synchronized (b.g(b.this))
        {
          System.arraycopy(???, 0, b.g(b.this), 0, paramAnonymousInt);
          b.a(b.this, paramAnonymousInt);
          ??? = b.this;
          if (b.e(b.this) >= 3)
          {
            bool = true;
            b.a((b)???, bool);
            b.b(b.this, (int)(l / 1000L));
            b.h(b.this);
            b.i(b.this);
            label410:
            if (b.j(b.this))
            {
              Log.w("MicroMsg.MusicFingerPrintRecorder", "client:%d stop now! duration:%d  ", new Object[] { Integer.valueOf(b.d(b.this)), Long.valueOf(l) });
              b.f(b.this);
            }
            AppMethodBeat.o(28259);
            return;
          }
          boolean bool = false;
        }
      }
    };
    AppMethodBeat.o(28263);
  }
  
  private void CT(final boolean paramBoolean)
  {
    AppMethodBeat.i(28269);
    Log.d("MicroMsg.MusicFingerPrintRecorder", "tryCallBack, directFail = %s", new Object[] { Boolean.FALSE });
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28260);
        if (this.PBm)
        {
          b.a(b.this, null, -1L, paramBoolean);
          AppMethodBeat.o(28260);
          return;
        }
        if (!b.k(b.this))
        {
          Log.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack netscen not return.");
          AppMethodBeat.o(28260);
          return;
        }
        if (b.l(b.this) != null)
        {
          Log.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack device not ready!");
          AppMethodBeat.o(28260);
          return;
        }
        if (b.m(b.this) != null)
        {
          b localb = b.this;
          esc localesc = b.m(b.this).gXF();
          f localf = b.m(b.this);
          long l2 = Util.nowMilliSecond();
          long l1 = l2;
          if (localf.PBq > 0L)
          {
            l1 = l2;
            if (localf.PBq < l2) {
              l1 = localf.PBq;
            }
          }
          b.a(localb, localesc, l1, paramBoolean);
          AppMethodBeat.o(28260);
          return;
        }
        b.a(b.this, null, -1L, paramBoolean);
        AppMethodBeat.o(28260);
      }
    });
    AppMethodBeat.o(28269);
  }
  
  /* Error */
  private void a(esc paramesc, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 28270
    //   5: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 84	com/tencent/mm/plugin/shake/c/a/b:PBk	Z
    //   12: ifne +30 -> 42
    //   15: aload_0
    //   16: getfield 74	com/tencent/mm/plugin/shake/c/a/b:PAS	Lcom/tencent/mm/plugin/shake/c/a/k$a;
    //   19: aload_1
    //   20: lload_2
    //   21: iload 4
    //   23: invokeinterface 132 5 0
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 84	com/tencent/mm/plugin/shake/c/a/b:PBk	Z
    //   33: sipush 28270
    //   36: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: ldc 97
    //   44: ldc 134
    //   46: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: sipush 28270
    //   52: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: goto -16 -> 39
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	b
    //   0	63	1	paramesc	esc
    //   0	63	2	paramLong	long
    //   0	63	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	39	58	finally
    //   42	55	58	finally
  }
  
  private void bJu()
  {
    AppMethodBeat.i(28271);
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28261);
        if (b.n(b.this))
        {
          Log.e("MicroMsg.MusicFingerPrintRecorder", "tryStartNetscene clientid: %d but netscene is running.", new Object[] { Integer.valueOf(b.d(b.this)) });
          AppMethodBeat.o(28261);
          return;
        }
        synchronized (b.g(b.this))
        {
          if (b.o(b.this) <= 0)
          {
            AppMethodBeat.o(28261);
            return;
          }
          byte[] arrayOfByte = new byte[b.o(b.this)];
          System.arraycopy(b.g(b.this), 0, arrayOfByte, 0, b.o(b.this));
          b.a(b.this, 0);
          long l = b.p(b.this);
          b.q(b.this);
          ??? = f.a(b.b(b.this), arrayOfByte, b.r(b.this), l, b.d(b.this), b.j(b.this), b.s(b.this));
          bh.aZW().a((p)???, 0);
          AppMethodBeat.o(28261);
          return;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(28262);
        String str = super.toString() + "|tryStartNetscene";
        AppMethodBeat.o(28262);
        return str;
      }
    });
    AppMethodBeat.o(28271);
  }
  
  private void reset()
  {
    AppMethodBeat.i(28268);
    Log.d("MicroMsg.MusicFingerPrintRecorder", "reset recorder clientid:%d", new Object[] { Integer.valueOf(this.PAP) });
    if (this.hvI != null)
    {
      this.hvI.aGH();
      this.hvI = null;
    }
    CT(false);
    AppMethodBeat.o(28268);
  }
  
  public final boolean a(int paramInt, k.a arg2)
  {
    AppMethodBeat.i(273680);
    aGH();
    if (??? == null)
    {
      Log.e("MicroMsg.MusicFingerPrintRecorder", "start record failed call back is null");
      AppMethodBeat.o(273680);
      return false;
    }
    synchronized (this.wrI)
    {
      this.PBg = QAFPNative.QAFPGetVersion();
      gXD();
      this.PBb = paramInt;
      this.PAS = ???;
      this.PBf = false;
      this.PBe = false;
      this.PBc = false;
      this.PBk = false;
      bh.aZW().a(367, this);
      bh.aZW().a(408, this);
      this.PAP = ((int)Util.nowMilliSecond());
      Log.d("MicroMsg.MusicFingerPrintRecorder", "startRecord now clientid:%d", new Object[] { Integer.valueOf(this.PAP) });
      this.hvI = new c(8000, 1, 4);
      this.hvI.hwn = -19;
      this.hvI.hwy = this.hwR;
      if (!this.hvI.aGR())
      {
        Log.e("MicroMsg.MusicFingerPrintRecorder", "start record failed");
        reset();
        AppMethodBeat.o(273680);
        return false;
      }
    }
    synchronized (this.wrI)
    {
      paramInt = QAFPNative.QAFPReset();
      Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPReset ret:%d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt < 0)
      {
        Log.e("MicroMsg.MusicFingerPrintRecorder", "init failed QAFPReset:%d clientid:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.PAP) });
        reset();
        AppMethodBeat.o(273680);
        return false;
      }
      this.PBa = Util.nowMilliSecond();
      this.PBi = Util.nowMilliSecond();
      this.PBj = 0;
      AppMethodBeat.o(273680);
      return true;
    }
  }
  
  public final boolean aGH()
  {
    AppMethodBeat.i(28266);
    Log.d("MicroMsg.MusicFingerPrintRecorder", "stopRecord now clientid:%d", new Object[] { Integer.valueOf(this.PAP) });
    bh.aZW().b(367, this);
    bh.aZW().b(408, this);
    synchronized (this.PAX)
    {
      this.PAY = 0;
      if (this.hvI != null)
      {
        this.hvI.aGH();
        this.hvI = null;
      }
      AppMethodBeat.o(28266);
      return true;
    }
  }
  
  public final boolean gXD()
  {
    boolean bool = false;
    AppMethodBeat.i(28264);
    for (;;)
    {
      int i;
      synchronized (this.wrI)
      {
        if (this.PBh)
        {
          Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit already inited");
          AppMethodBeat.o(28264);
          return false;
        }
        i = QAFPNative.QAFPInit();
        Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit ret:%d", new Object[] { Integer.valueOf(i) });
        if (i >= 0)
        {
          this.PBh = true;
          break label98;
          AppMethodBeat.o(28264);
          return bool;
        }
      }
      label98:
      if (i >= 0) {
        bool = true;
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(28272);
    if ((paramp.getType() != 367) && (paramp.getType() != 408))
    {
      AppMethodBeat.o(28272);
      return;
    }
    Log.d("MicroMsg.MusicFingerPrintRecorder", "onSceneEnd errType = %s, errCode = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.PBe = false;
    if (((f)paramp).gXE())
    {
      Log.d("MicroMsg.MusicFingerPrintRecorder", "NetSceneShakeMedia isRecogSuccess stop now ! clientid:%d", new Object[] { Integer.valueOf(this.PAP) });
      aGH();
      this.PBd = ((f)paramp);
      this.PBc = true;
      CT(false);
      AppMethodBeat.o(28272);
      return;
    }
    if ((this.PAY == 0) && (this.PBf))
    {
      Log.d("MicroMsg.MusicFingerPrintRecorder", "recog failed . clientid:%d", new Object[] { Integer.valueOf(this.PAP) });
      this.PBd = null;
      this.PBc = true;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        CT(false);
      }
      for (;;)
      {
        bh.aZW().b(367, this);
        bh.aZW().b(408, this);
        AppMethodBeat.o(28272);
        return;
        CT(true);
      }
    }
    Log.d("MicroMsg.MusicFingerPrintRecorder", "NetScene try again clientId:%d", new Object[] { Integer.valueOf(this.PAP) });
    bJu();
    AppMethodBeat.o(28272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.b
 * JD-Core Version:    0.7.0.1
 */