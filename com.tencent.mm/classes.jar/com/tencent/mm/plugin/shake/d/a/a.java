package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.qafpapi.QAFPNative;

public final class a
  implements i
{
  boolean DiA;
  int DiB;
  int DiC;
  private boolean DiD;
  long DiE;
  int DiF;
  private boolean DiG;
  byte[] Dir;
  int Dis;
  int Dit;
  long Diu;
  int Div;
  boolean Diw;
  e Dix;
  private a.a Diy;
  boolean Diz;
  Object dBh;
  c dyI;
  private c.a dzN;
  
  public a()
  {
    AppMethodBeat.i(28263);
    this.Dir = new byte[10240];
    this.Dis = 0;
    this.Dit = 0;
    this.Diu = 0L;
    this.Div = 0;
    this.Diw = false;
    this.Dix = null;
    this.dBh = new Object();
    this.Diy = null;
    this.Diz = false;
    this.DiA = false;
    this.DiB = 0;
    this.DiD = false;
    this.DiG = false;
    this.dzN = new c.a()
    {
      public final void cj(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] arg1, int paramAnonymousInt)
      {
        AppMethodBeat.i(28259);
        f.a locala = new f.a();
        long l;
        for (;;)
        {
          synchronized (a.this.dBh)
          {
            int i;
            if (a.this.Div == 408)
            {
              Log.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPProcessTV");
              i = QAFPNative.QAFPProcessTV(???, paramAnonymousInt);
              l = Util.nowMilliSecond() - a.this.DiE;
              Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPProcess clientid:%d pcm:%d ret:%d dur:%d usetime:%d", new Object[] { Integer.valueOf(a.this.DiB), Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), Long.valueOf(l), Long.valueOf(locala.apr()) });
              if (l <= a.this.DiF * 3000 + 4000) {
                break label414;
              }
              ??? = new byte[10240];
              ??? = new f.a();
              if (a.this.Div == 408)
              {
                Log.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPGetAudioFingerPrintTV");
                paramAnonymousInt = QAFPNative.QAFPGetAudioFingerPrintTV((byte[])???);
                Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d outLen:%d time:%d", new Object[] { Integer.valueOf(a.this.DiB), Integer.valueOf(paramAnonymousInt), Long.valueOf(???.apr()) });
                if ((paramAnonymousInt < 10240) && (paramAnonymousInt > 0)) {
                  break;
                }
                Log.e("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d  out ret:%d  !stop record now", new Object[] { Integer.valueOf(a.this.DiB), Integer.valueOf(paramAnonymousInt) });
                a.this.reset();
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
        synchronized (a.this.Dir)
        {
          System.arraycopy(???, 0, a.this.Dir, 0, paramAnonymousInt);
          a.this.Dis = paramAnonymousInt;
          ??? = a.this;
          if (a.this.DiF >= 3)
          {
            bool = true;
            ((a)???).DiA = bool;
            a.this.Dit = ((int)(l / 1000L));
            a.this.bck();
            ??? = a.this;
            ???.DiF += 1;
            label414:
            if (a.this.DiA)
            {
              Log.w("MicroMsg.MusicFingerPrintRecorder", "client:%d stop now! duration:%d  ", new Object[] { Integer.valueOf(a.this.DiB), Long.valueOf(l) });
              a.this.reset();
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
  private void a(dpc paramdpc, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 28270
    //   5: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 80	com/tencent/mm/plugin/shake/d/a/a:DiG	Z
    //   12: ifne +30 -> 42
    //   15: aload_0
    //   16: getfield 70	com/tencent/mm/plugin/shake/d/a/a:Diy	Lcom/tencent/mm/plugin/shake/d/a/a$a;
    //   19: aload_1
    //   20: lload_2
    //   21: iload 4
    //   23: invokeinterface 97 5 0
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 80	com/tencent/mm/plugin/shake/d/a/a:DiG	Z
    //   33: sipush 28270
    //   36: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: ldc 99
    //   44: ldc 101
    //   46: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: sipush 28270
    //   52: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: goto -16 -> 39
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	a
    //   0	63	1	paramdpc	dpc
    //   0	63	2	paramLong	long
    //   0	63	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	39	58	finally
    //   42	55	58	finally
  }
  
  private void uw(final boolean paramBoolean)
  {
    AppMethodBeat.i(28269);
    Log.d("MicroMsg.MusicFingerPrintRecorder", "tryCallBack, directFail = %s", new Object[] { Boolean.FALSE });
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28260);
        if (this.DiI)
        {
          a.a(a.this, null, -1L, paramBoolean);
          AppMethodBeat.o(28260);
          return;
        }
        if (!a.this.Diw)
        {
          Log.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack netscen not return.");
          AppMethodBeat.o(28260);
          return;
        }
        if (a.this.dyI != null)
        {
          Log.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack device not ready!");
          AppMethodBeat.o(28260);
          return;
        }
        if (a.this.Dix != null)
        {
          a locala = a.this;
          dpc localdpc = a.this.Dix.eUP();
          e locale = a.this.Dix;
          long l2 = Util.nowMilliSecond();
          long l1 = l2;
          if (locale.DiM > 0L)
          {
            l1 = l2;
            if (locale.DiM < l2) {
              l1 = locale.DiM;
            }
          }
          a.a(locala, localdpc, l1, paramBoolean);
          AppMethodBeat.o(28260);
          return;
        }
        a.a(a.this, null, -1L, paramBoolean);
        AppMethodBeat.o(28260);
      }
    });
    AppMethodBeat.o(28269);
  }
  
  public final boolean ZZ()
  {
    AppMethodBeat.i(28266);
    Log.d("MicroMsg.MusicFingerPrintRecorder", "stopRecord now clientid:%d", new Object[] { Integer.valueOf(this.DiB) });
    bg.azz().b(367, this);
    bg.azz().b(408, this);
    synchronized (this.Dir)
    {
      this.Dis = 0;
      if (this.dyI != null)
      {
        this.dyI.ZZ();
        this.dyI = null;
      }
      AppMethodBeat.o(28266);
      return true;
    }
  }
  
  public final boolean a(int paramInt, a.a arg2)
  {
    AppMethodBeat.i(28267);
    ZZ();
    synchronized (this.dBh)
    {
      this.DiC = QAFPNative.QAFPGetVersion();
      eUM();
      this.Div = paramInt;
      this.Diy = ???;
      this.DiA = false;
      this.Diz = false;
      this.Diw = false;
      this.DiG = false;
      bg.azz().a(367, this);
      bg.azz().a(408, this);
      this.DiB = ((int)Util.nowMilliSecond());
      Log.d("MicroMsg.MusicFingerPrintRecorder", "startRecord now clientid:%d", new Object[] { Integer.valueOf(this.DiB) });
      this.dyI = new c(8000, 1, 4);
      this.dyI.dzk = -19;
      this.dyI.dzv = this.dzN;
      if (!this.dyI.aai())
      {
        Log.e("MicroMsg.MusicFingerPrintRecorder", "start record failed");
        reset();
        AppMethodBeat.o(28267);
        return false;
      }
    }
    synchronized (this.dBh)
    {
      paramInt = QAFPNative.QAFPReset();
      Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPReset ret:%d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt < 0)
      {
        Log.e("MicroMsg.MusicFingerPrintRecorder", "init failed QAFPReset:%d clientid:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.DiB) });
        reset();
        AppMethodBeat.o(28267);
        return false;
      }
      this.Diu = Util.nowMilliSecond();
      this.DiE = Util.nowMilliSecond();
      this.DiF = 0;
      AppMethodBeat.o(28267);
      return true;
    }
  }
  
  final void bck()
  {
    AppMethodBeat.i(28271);
    bg.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28261);
        if (a.this.Diz)
        {
          Log.e("MicroMsg.MusicFingerPrintRecorder", "tryStartNetscene clientid: %d but netscene is running.", new Object[] { Integer.valueOf(a.this.DiB) });
          AppMethodBeat.o(28261);
          return;
        }
        for (;;)
        {
          long l;
          int i;
          int j;
          int k;
          boolean bool;
          int m;
          synchronized (a.this.Dir)
          {
            if (a.this.Dis <= 0)
            {
              AppMethodBeat.o(28261);
              return;
            }
            byte[] arrayOfByte1 = new byte[a.this.Dis];
            System.arraycopy(a.this.Dir, 0, arrayOfByte1, 0, a.this.Dis);
            a.this.Dis = 0;
            l = a.this.Diu;
            a.this.Diz = true;
            i = a.this.Div;
            j = a.this.Dit;
            k = a.this.DiB;
            bool = a.this.DiA;
            m = a.this.DiC;
            if (i == 367)
            {
              ??? = new f(arrayOfByte1, j, l, k, bool, m);
              bg.azz().a((q)???, 0);
              AppMethodBeat.o(28261);
              return;
            }
          }
          if (i == 408) {
            ??? = new g(arrayOfByte2, j, l, k, bool, m);
          } else {
            ??? = null;
          }
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
  
  public final boolean eUM()
  {
    boolean bool = false;
    AppMethodBeat.i(28264);
    for (;;)
    {
      int i;
      synchronized (this.dBh)
      {
        if (this.DiD)
        {
          Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit already inited");
          AppMethodBeat.o(28264);
          return false;
        }
        i = QAFPNative.QAFPInit();
        Log.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit ret:%d", new Object[] { Integer.valueOf(i) });
        if (i >= 0)
        {
          this.DiD = true;
          break label96;
          AppMethodBeat.o(28264);
          return bool;
        }
      }
      label96:
      if (i >= 0) {
        bool = true;
      }
    }
  }
  
  public final boolean eUN()
  {
    boolean bool = false;
    AppMethodBeat.i(28265);
    synchronized (this.dBh)
    {
      if (!this.DiD)
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
    this.Diz = false;
    if (((e)paramq).eUO())
    {
      Log.d("MicroMsg.MusicFingerPrintRecorder", "NetSceneShakeMedia isRecogSuccess stop now ! clientid:%d", new Object[] { Integer.valueOf(this.DiB) });
      ZZ();
      this.Dix = ((e)paramq);
      this.Diw = true;
      uw(false);
      AppMethodBeat.o(28272);
      return;
    }
    if ((this.Dis == 0) && (this.DiA))
    {
      Log.d("MicroMsg.MusicFingerPrintRecorder", "recog failed . clientid:%d", new Object[] { Integer.valueOf(this.DiB) });
      this.Dix = null;
      this.Diw = true;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        uw(false);
      }
      for (;;)
      {
        bg.azz().b(367, this);
        bg.azz().b(408, this);
        AppMethodBeat.o(28272);
        return;
        uw(true);
      }
    }
    Log.d("MicroMsg.MusicFingerPrintRecorder", "NetScene try again clientId:%d", new Object[] { Integer.valueOf(this.DiB) });
    bck();
    AppMethodBeat.o(28272);
  }
  
  final void reset()
  {
    AppMethodBeat.i(28268);
    Log.d("MicroMsg.MusicFingerPrintRecorder", "reset recorder clientid:%d", new Object[] { Integer.valueOf(this.DiB) });
    if (this.dyI != null)
    {
      this.dyI.ZZ();
      this.dyI = null;
    }
    uw(false);
    AppMethodBeat.o(28268);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.a
 * JD-Core Version:    0.7.0.1
 */