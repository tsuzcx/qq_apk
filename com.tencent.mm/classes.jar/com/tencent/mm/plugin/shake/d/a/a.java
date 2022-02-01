package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.qafpapi.QAFPNative;

public final class a
  implements i
{
  private byte[] JnX;
  private int JnY;
  private int JnZ;
  private long Joa;
  private int Job;
  private boolean Joc;
  private e Jod;
  private a.a Joe;
  private boolean Jof;
  private boolean Jog;
  private int Joh;
  private int Joi;
  private boolean Joj;
  private long Jok;
  private int Jol;
  private boolean Jom;
  private c frx;
  private c.a fsC;
  private Object tnh;
  
  public a()
  {
    AppMethodBeat.i(28263);
    this.JnX = new byte[10240];
    this.JnY = 0;
    this.JnZ = 0;
    this.Joa = 0L;
    this.Job = e.arZ();
    this.Joc = false;
    this.Jod = null;
    this.tnh = new Object();
    this.Joe = null;
    this.Jof = false;
    this.Jog = false;
    this.Joh = 0;
    this.Joj = false;
    this.Jom = false;
    this.fsC = new c.a()
    {
      public final void cC(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] arg1, int paramAnonymousInt)
      {
        AppMethodBeat.i(28259);
        f.a locala = new f.a();
        long l;
        for (;;)
        {
          synchronized (a.a(a.this))
          {
            int i;
            if (a.b(a.this) == 408)
            {
              Log.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPProcessTV");
              i = QAFPNative.QAFPProcessTV(???, paramAnonymousInt);
              l = Util.nowMilliSecond() - a.c(a.this);
              Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPProcess clientid:%d pcm:%d ret:%d dur:%d usetime:%d", new Object[] { Integer.valueOf(a.d(a.this)), Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), Long.valueOf(l), Long.valueOf(locala.avE()) });
              if (l <= a.e(a.this) * 3000 + 4000) {
                break label410;
              }
              ??? = new byte[10240];
              ??? = new f.a();
              if (a.b(a.this) == 408)
              {
                Log.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPGetAudioFingerPrintTV");
                paramAnonymousInt = QAFPNative.QAFPGetAudioFingerPrintTV((byte[])???);
                Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d outLen:%d time:%d", new Object[] { Integer.valueOf(a.d(a.this)), Integer.valueOf(paramAnonymousInt), Long.valueOf(???.avE()) });
                if ((paramAnonymousInt < 10240) && (paramAnonymousInt > 0)) {
                  break;
                }
                Log.e("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d  out ret:%d  !stop record now", new Object[] { Integer.valueOf(a.d(a.this)), Integer.valueOf(paramAnonymousInt) });
                a.f(a.this);
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
        synchronized (a.g(a.this))
        {
          System.arraycopy(???, 0, a.g(a.this), 0, paramAnonymousInt);
          a.a(a.this, paramAnonymousInt);
          ??? = a.this;
          if (a.e(a.this) >= 3)
          {
            bool = true;
            a.a((a)???, bool);
            a.b(a.this, (int)(l / 1000L));
            a.h(a.this);
            a.i(a.this);
            label410:
            if (a.j(a.this))
            {
              Log.w("MicroMsg.MusicFingerPrintRecorder", "client:%d stop now! duration:%d  ", new Object[] { Integer.valueOf(a.d(a.this)), Long.valueOf(l) });
              a.f(a.this);
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
  
  /* Error */
  private void a(dyy paramdyy, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 28270
    //   5: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 86	com/tencent/mm/plugin/shake/d/a/a:Jom	Z
    //   12: ifne +30 -> 42
    //   15: aload_0
    //   16: getfield 76	com/tencent/mm/plugin/shake/d/a/a:Joe	Lcom/tencent/mm/plugin/shake/d/a/a$a;
    //   19: aload_1
    //   20: lload_2
    //   21: iload 4
    //   23: invokeinterface 105 5 0
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 86	com/tencent/mm/plugin/shake/d/a/a:Jom	Z
    //   33: sipush 28270
    //   36: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: ldc 107
    //   44: ldc 109
    //   46: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: sipush 28270
    //   52: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: goto -16 -> 39
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	a
    //   0	63	1	paramdyy	dyy
    //   0	63	2	paramLong	long
    //   0	63	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	39	58	finally
    //   42	55	58	finally
  }
  
  private void blz()
  {
    AppMethodBeat.i(28271);
    bh.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28261);
        if (a.n(a.this))
        {
          Log.e("MicroMsg.MusicFingerPrintRecorder", "tryStartNetscene clientid: %d but netscene is running.", new Object[] { Integer.valueOf(a.d(a.this)) });
          AppMethodBeat.o(28261);
          return;
        }
        synchronized (a.g(a.this))
        {
          if (a.o(a.this) <= 0)
          {
            AppMethodBeat.o(28261);
            return;
          }
          byte[] arrayOfByte = new byte[a.o(a.this)];
          System.arraycopy(a.g(a.this), 0, arrayOfByte, 0, a.o(a.this));
          a.a(a.this, 0);
          long l = a.p(a.this);
          a.q(a.this);
          ??? = e.a(a.b(a.this), arrayOfByte, a.r(a.this), l, a.d(a.this), a.j(a.this), a.s(a.this));
          bh.aGY().a((q)???, 0);
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
    Log.d("MicroMsg.MusicFingerPrintRecorder", "reset recorder clientid:%d", new Object[] { Integer.valueOf(this.Joh) });
    if (this.frx != null)
    {
      this.frx.aeJ();
      this.frx = null;
    }
    xU(false);
    AppMethodBeat.o(28268);
  }
  
  private void xU(final boolean paramBoolean)
  {
    AppMethodBeat.i(28269);
    Log.d("MicroMsg.MusicFingerPrintRecorder", "tryCallBack, directFail = %s", new Object[] { Boolean.FALSE });
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28260);
        if (this.Joo)
        {
          a.a(a.this, null, -1L, paramBoolean);
          AppMethodBeat.o(28260);
          return;
        }
        if (!a.k(a.this))
        {
          Log.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack netscen not return.");
          AppMethodBeat.o(28260);
          return;
        }
        if (a.l(a.this) != null)
        {
          Log.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack device not ready!");
          AppMethodBeat.o(28260);
          return;
        }
        if (a.m(a.this) != null)
        {
          a locala = a.this;
          dyy localdyy = a.m(a.this).fHQ();
          e locale = a.m(a.this);
          long l2 = Util.nowMilliSecond();
          long l1 = l2;
          if (locale.Jos > 0L)
          {
            l1 = l2;
            if (locale.Jos < l2) {
              l1 = locale.Jos;
            }
          }
          a.a(locala, localdyy, l1, paramBoolean);
          AppMethodBeat.o(28260);
          return;
        }
        a.a(a.this, null, -1L, paramBoolean);
        AppMethodBeat.o(28260);
      }
    });
    AppMethodBeat.o(28269);
  }
  
  public final boolean a(int paramInt, a.a arg2)
  {
    AppMethodBeat.i(28267);
    aeJ();
    synchronized (this.tnh)
    {
      this.Joi = QAFPNative.QAFPGetVersion();
      fHN();
      this.Job = paramInt;
      this.Joe = ???;
      this.Jog = false;
      this.Jof = false;
      this.Joc = false;
      this.Jom = false;
      bh.aGY().a(367, this);
      bh.aGY().a(408, this);
      this.Joh = ((int)Util.nowMilliSecond());
      Log.d("MicroMsg.MusicFingerPrintRecorder", "startRecord now clientid:%d", new Object[] { Integer.valueOf(this.Joh) });
      this.frx = new c(8000, 1, 4);
      this.frx.frZ = -19;
      this.frx.fsk = this.fsC;
      if (!this.frx.aeU())
      {
        Log.e("MicroMsg.MusicFingerPrintRecorder", "start record failed");
        reset();
        AppMethodBeat.o(28267);
        return false;
      }
    }
    synchronized (this.tnh)
    {
      paramInt = QAFPNative.QAFPReset();
      Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPReset ret:%d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt < 0)
      {
        Log.e("MicroMsg.MusicFingerPrintRecorder", "init failed QAFPReset:%d clientid:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Joh) });
        reset();
        AppMethodBeat.o(28267);
        return false;
      }
      this.Joa = Util.nowMilliSecond();
      this.Jok = Util.nowMilliSecond();
      this.Jol = 0;
      AppMethodBeat.o(28267);
      return true;
    }
  }
  
  public final boolean aeJ()
  {
    AppMethodBeat.i(28266);
    Log.d("MicroMsg.MusicFingerPrintRecorder", "stopRecord now clientid:%d", new Object[] { Integer.valueOf(this.Joh) });
    bh.aGY().b(367, this);
    bh.aGY().b(408, this);
    synchronized (this.JnX)
    {
      this.JnY = 0;
      if (this.frx != null)
      {
        this.frx.aeJ();
        this.frx = null;
      }
      AppMethodBeat.o(28266);
      return true;
    }
  }
  
  public final boolean fHN()
  {
    boolean bool = false;
    AppMethodBeat.i(28264);
    for (;;)
    {
      int i;
      synchronized (this.tnh)
      {
        if (this.Joj)
        {
          Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit already inited");
          AppMethodBeat.o(28264);
          return false;
        }
        i = QAFPNative.QAFPInit();
        Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit ret:%d", new Object[] { Integer.valueOf(i) });
        if (i >= 0)
        {
          this.Joj = true;
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
  
  public final boolean fHO()
  {
    boolean bool = false;
    AppMethodBeat.i(28265);
    synchronized (this.tnh)
    {
      if (!this.Joj)
      {
        Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease never inited");
        AppMethodBeat.o(28265);
        return false;
      }
      int i = QAFPNative.QAFPRelease();
      Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease ret:%d", new Object[] { Integer.valueOf(i) });
      if (i >= 0) {
        bool = true;
      }
      AppMethodBeat.o(28265);
      return bool;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(28272);
    if ((paramq.getType() != 367) && (paramq.getType() != 408))
    {
      AppMethodBeat.o(28272);
      return;
    }
    Log.d("MicroMsg.MusicFingerPrintRecorder", "onSceneEnd errType = %s, errCode = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.Jof = false;
    if (((e)paramq).fHP())
    {
      Log.d("MicroMsg.MusicFingerPrintRecorder", "NetSceneShakeMedia isRecogSuccess stop now ! clientid:%d", new Object[] { Integer.valueOf(this.Joh) });
      aeJ();
      this.Jod = ((e)paramq);
      this.Joc = true;
      xU(false);
      AppMethodBeat.o(28272);
      return;
    }
    if ((this.JnY == 0) && (this.Jog))
    {
      Log.d("MicroMsg.MusicFingerPrintRecorder", "recog failed . clientid:%d", new Object[] { Integer.valueOf(this.Joh) });
      this.Jod = null;
      this.Joc = true;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        xU(false);
      }
      for (;;)
      {
        bh.aGY().b(367, this);
        bh.aGY().b(408, this);
        AppMethodBeat.o(28272);
        return;
        xU(true);
      }
    }
    Log.d("MicroMsg.MusicFingerPrintRecorder", "NetScene try again clientId:%d", new Object[] { Integer.valueOf(this.Joh) });
    blz();
    AppMethodBeat.o(28272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.a
 * JD-Core Version:    0.7.0.1
 */