package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.az;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.qafpapi.QAFPNative;

public final class a
  implements com.tencent.mm.al.g
{
  c cXI;
  private c.a cYN;
  Object dah;
  private boolean wnA;
  long wnB;
  int wnC;
  private boolean wnD;
  byte[] wno;
  int wnp;
  int wnq;
  long wnr;
  int wns;
  boolean wnt;
  e wnu;
  private a wnv;
  boolean wnw;
  boolean wnx;
  int wny;
  int wnz;
  
  public a()
  {
    AppMethodBeat.i(28263);
    this.wno = new byte[10240];
    this.wnp = 0;
    this.wnq = 0;
    this.wnr = 0L;
    this.wns = 0;
    this.wnt = false;
    this.wnu = null;
    this.dah = new Object();
    this.wnv = null;
    this.wnw = false;
    this.wnx = false;
    this.wny = 0;
    this.wnA = false;
    this.wnD = false;
    this.cYN = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] arg1, int paramAnonymousInt)
      {
        AppMethodBeat.i(28259);
        f.a locala = new f.a();
        long l;
        for (;;)
        {
          synchronized (a.this.dah)
          {
            int i;
            if (a.this.wns == 408)
            {
              ad.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPProcessTV");
              i = QAFPNative.QAFPProcessTV(???, paramAnonymousInt);
              l = bt.eGO() - a.this.wnB;
              ad.d("MicroMsg.MusicFingerPrintRecorder", "QAFPProcess clientid:%d pcm:%d ret:%d dur:%d usetime:%d", new Object[] { Integer.valueOf(a.this.wny), Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), Long.valueOf(l), Long.valueOf(locala.XK()) });
              if (l <= a.this.wnC * 3000 + 4000) {
                break label414;
              }
              ??? = new byte[10240];
              ??? = new f.a();
              if (a.this.wns == 408)
              {
                ad.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPGetAudioFingerPrintTV");
                paramAnonymousInt = QAFPNative.QAFPGetAudioFingerPrintTV((byte[])???);
                ad.d("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d outLen:%d time:%d", new Object[] { Integer.valueOf(a.this.wny), Integer.valueOf(paramAnonymousInt), Long.valueOf(???.XK()) });
                if ((paramAnonymousInt < 10240) && (paramAnonymousInt > 0)) {
                  break;
                }
                ad.e("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d  out ret:%d  !stop record now", new Object[] { Integer.valueOf(a.this.wny), Integer.valueOf(paramAnonymousInt) });
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
        synchronized (a.this.wno)
        {
          System.arraycopy(???, 0, a.this.wno, 0, paramAnonymousInt);
          a.this.wnp = paramAnonymousInt;
          ??? = a.this;
          if (a.this.wnC >= 3)
          {
            bool = true;
            ((a)???).wnx = bool;
            a.this.wnq = ((int)(l / 1000L));
            a.this.ayc();
            ??? = a.this;
            ???.wnC += 1;
            label414:
            if (a.this.wnx)
            {
              ad.w("MicroMsg.MusicFingerPrintRecorder", "client:%d stop now! duration:%d  ", new Object[] { Integer.valueOf(a.this.wny), Long.valueOf(l) });
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
  private void a(cld paramcld, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 28270
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 81	com/tencent/mm/plugin/shake/d/a/a:wnD	Z
    //   12: ifne +30 -> 42
    //   15: aload_0
    //   16: getfield 71	com/tencent/mm/plugin/shake/d/a/a:wnv	Lcom/tencent/mm/plugin/shake/d/a/a$a;
    //   19: aload_1
    //   20: lload_2
    //   21: iload 4
    //   23: invokeinterface 97 5 0
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 81	com/tencent/mm/plugin/shake/d/a/a:wnD	Z
    //   33: sipush 28270
    //   36: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: ldc 99
    //   44: ldc 101
    //   46: invokestatic 107	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: sipush 28270
    //   52: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: goto -16 -> 39
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	a
    //   0	63	1	paramcld	cld
    //   0	63	2	paramLong	long
    //   0	63	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	39	58	finally
    //   42	55	58	finally
  }
  
  private void ps(final boolean paramBoolean)
  {
    AppMethodBeat.i(28269);
    ad.d("MicroMsg.MusicFingerPrintRecorder", "tryCallBack, directFail = %s", new Object[] { Boolean.FALSE });
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28260);
        if (this.wnF)
        {
          a.a(a.this, null, -1L, paramBoolean);
          AppMethodBeat.o(28260);
          return;
        }
        if (!a.this.wnt)
        {
          ad.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack netscen not return.");
          AppMethodBeat.o(28260);
          return;
        }
        if (a.this.cXI != null)
        {
          ad.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack device not ready!");
          AppMethodBeat.o(28260);
          return;
        }
        if (a.this.wnu != null)
        {
          a locala = a.this;
          cld localcld = a.this.wnu.dpE();
          e locale = a.this.wnu;
          long l2 = bt.eGO();
          long l1 = l2;
          if (locale.wnJ > 0L)
          {
            l1 = l2;
            if (locale.wnJ < l2) {
              l1 = locale.wnJ;
            }
          }
          a.a(locala, localcld, l1, paramBoolean);
          AppMethodBeat.o(28260);
          return;
        }
        a.a(a.this, null, -1L, paramBoolean);
        AppMethodBeat.o(28260);
      }
    });
    AppMethodBeat.o(28269);
  }
  
  public final boolean Ob()
  {
    AppMethodBeat.i(28266);
    ad.d("MicroMsg.MusicFingerPrintRecorder", "stopRecord now clientid:%d", new Object[] { Integer.valueOf(this.wny) });
    az.aeS().b(367, this);
    az.aeS().b(408, this);
    synchronized (this.wno)
    {
      this.wnp = 0;
      if (this.cXI != null)
      {
        this.cXI.Ob();
        this.cXI = null;
      }
      AppMethodBeat.o(28266);
      return true;
    }
  }
  
  public final boolean a(int paramInt, a arg2)
  {
    AppMethodBeat.i(28267);
    Ob();
    synchronized (this.dah)
    {
      this.wnz = QAFPNative.QAFPGetVersion();
      dpB();
      this.wns = paramInt;
      this.wnv = ???;
      this.wnx = false;
      this.wnw = false;
      this.wnt = false;
      this.wnD = false;
      az.aeS().a(367, this);
      az.aeS().a(408, this);
      this.wny = ((int)bt.eGO());
      ad.d("MicroMsg.MusicFingerPrintRecorder", "startRecord now clientid:%d", new Object[] { Integer.valueOf(this.wny) });
      this.cXI = new c(8000, 1, 4);
      this.cXI.cYk = -19;
      this.cXI.cYv = this.cYN;
      if (!this.cXI.Ok())
      {
        ad.e("MicroMsg.MusicFingerPrintRecorder", "start record failed");
        reset();
        AppMethodBeat.o(28267);
        return false;
      }
    }
    synchronized (this.dah)
    {
      paramInt = QAFPNative.QAFPReset();
      ad.d("MicroMsg.MusicFingerPrintRecorder", "QAFPReset ret:%d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt < 0)
      {
        ad.e("MicroMsg.MusicFingerPrintRecorder", "init failed QAFPReset:%d clientid:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.wny) });
        reset();
        AppMethodBeat.o(28267);
        return false;
      }
      this.wnr = bt.eGO();
      this.wnB = bt.eGO();
      this.wnC = 0;
      AppMethodBeat.o(28267);
      return true;
    }
  }
  
  final void ayc()
  {
    AppMethodBeat.i(28271);
    az.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28261);
        if (a.this.wnw)
        {
          ad.e("MicroMsg.MusicFingerPrintRecorder", "tryStartNetscene clientid: %d but netscene is running.", new Object[] { Integer.valueOf(a.this.wny) });
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
          synchronized (a.this.wno)
          {
            if (a.this.wnp <= 0)
            {
              AppMethodBeat.o(28261);
              return;
            }
            byte[] arrayOfByte1 = new byte[a.this.wnp];
            System.arraycopy(a.this.wno, 0, arrayOfByte1, 0, a.this.wnp);
            a.this.wnp = 0;
            l = a.this.wnr;
            a.this.wnw = true;
            i = a.this.wns;
            j = a.this.wnq;
            k = a.this.wny;
            bool = a.this.wnx;
            m = a.this.wnz;
            if (i == 367)
            {
              ??? = new f(arrayOfByte1, j, l, k, bool, m);
              az.aeS().a((n)???, 0);
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
  
  public final boolean dpB()
  {
    boolean bool = false;
    AppMethodBeat.i(28264);
    for (;;)
    {
      int i;
      synchronized (this.dah)
      {
        if (this.wnA)
        {
          ad.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit already inited");
          AppMethodBeat.o(28264);
          return false;
        }
        i = QAFPNative.QAFPInit();
        ad.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit ret:%d", new Object[] { Integer.valueOf(i) });
        if (i >= 0)
        {
          this.wnA = true;
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
  
  public final boolean dpC()
  {
    boolean bool = false;
    AppMethodBeat.i(28265);
    synchronized (this.dah)
    {
      if (!this.wnA)
      {
        ad.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease never inited");
        AppMethodBeat.o(28265);
        return false;
      }
      int i = QAFPNative.QAFPRelease();
      ad.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease ret:%d", new Object[] { Integer.valueOf(i) });
      if (i >= 0) {
        bool = true;
      }
      AppMethodBeat.o(28265);
      return bool;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(28272);
    if ((paramn.getType() != 367) && (paramn.getType() != 408))
    {
      AppMethodBeat.o(28272);
      return;
    }
    ad.d("MicroMsg.MusicFingerPrintRecorder", "onSceneEnd errType = %s, errCode = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.wnw = false;
    if (((e)paramn).dpD())
    {
      ad.d("MicroMsg.MusicFingerPrintRecorder", "NetSceneShakeMedia isRecogSuccess stop now ! clientid:%d", new Object[] { Integer.valueOf(this.wny) });
      Ob();
      this.wnu = ((e)paramn);
      this.wnt = true;
      ps(false);
      AppMethodBeat.o(28272);
      return;
    }
    if ((this.wnp == 0) && (this.wnx))
    {
      ad.d("MicroMsg.MusicFingerPrintRecorder", "recog failed . clientid:%d", new Object[] { Integer.valueOf(this.wny) });
      this.wnu = null;
      this.wnt = true;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        ps(false);
      }
      for (;;)
      {
        az.aeS().b(367, this);
        az.aeS().b(408, this);
        AppMethodBeat.o(28272);
        return;
        ps(true);
      }
    }
    ad.d("MicroMsg.MusicFingerPrintRecorder", "NetScene try again clientId:%d", new Object[] { Integer.valueOf(this.wny) });
    ayc();
    AppMethodBeat.o(28272);
  }
  
  final void reset()
  {
    AppMethodBeat.i(28268);
    ad.d("MicroMsg.MusicFingerPrintRecorder", "reset recorder clientid:%d", new Object[] { Integer.valueOf(this.wny) });
    if (this.cXI != null)
    {
      this.cXI.Ob();
      this.cXI = null;
    }
    ps(false);
    AppMethodBeat.o(28268);
  }
  
  public static abstract interface a
  {
    public abstract void b(cld paramcld, long paramLong, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.a
 * JD-Core Version:    0.7.0.1
 */