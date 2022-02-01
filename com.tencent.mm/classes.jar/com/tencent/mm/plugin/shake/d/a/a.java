package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.qafpapi.QAFPNative;

public final class a
  implements com.tencent.mm.al.f
{
  c dgu;
  private c.a dhz;
  Object diV;
  int yNA;
  private boolean yNB;
  long yNC;
  int yND;
  private boolean yNE;
  byte[] yNp;
  int yNq;
  int yNr;
  long yNs;
  int yNt;
  boolean yNu;
  e yNv;
  private a yNw;
  boolean yNx;
  boolean yNy;
  int yNz;
  
  public a()
  {
    AppMethodBeat.i(28263);
    this.yNp = new byte[10240];
    this.yNq = 0;
    this.yNr = 0;
    this.yNs = 0L;
    this.yNt = 0;
    this.yNu = false;
    this.yNv = null;
    this.diV = new Object();
    this.yNw = null;
    this.yNx = false;
    this.yNy = false;
    this.yNz = 0;
    this.yNB = false;
    this.yNE = false;
    this.dhz = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] arg1, int paramAnonymousInt)
      {
        AppMethodBeat.i(28259);
        f.a locala = new f.a();
        long l;
        for (;;)
        {
          synchronized (a.this.diV)
          {
            int i;
            if (a.this.yNt == 408)
            {
              ad.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPProcessTV");
              i = QAFPNative.QAFPProcessTV(???, paramAnonymousInt);
              l = bt.flT() - a.this.yNC;
              ad.d("MicroMsg.MusicFingerPrintRecorder", "QAFPProcess clientid:%d pcm:%d ret:%d dur:%d usetime:%d", new Object[] { Integer.valueOf(a.this.yNz), Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), Long.valueOf(l), Long.valueOf(locala.abj()) });
              if (l <= a.this.yND * 3000 + 4000) {
                break label414;
              }
              ??? = new byte[10240];
              ??? = new f.a();
              if (a.this.yNt == 408)
              {
                ad.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPGetAudioFingerPrintTV");
                paramAnonymousInt = QAFPNative.QAFPGetAudioFingerPrintTV((byte[])???);
                ad.d("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d outLen:%d time:%d", new Object[] { Integer.valueOf(a.this.yNz), Integer.valueOf(paramAnonymousInt), Long.valueOf(???.abj()) });
                if ((paramAnonymousInt < 10240) && (paramAnonymousInt > 0)) {
                  break;
                }
                ad.e("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d  out ret:%d  !stop record now", new Object[] { Integer.valueOf(a.this.yNz), Integer.valueOf(paramAnonymousInt) });
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
        synchronized (a.this.yNp)
        {
          System.arraycopy(???, 0, a.this.yNp, 0, paramAnonymousInt);
          a.this.yNq = paramAnonymousInt;
          ??? = a.this;
          if (a.this.yND >= 3)
          {
            bool = true;
            ((a)???).yNy = bool;
            a.this.yNr = ((int)(l / 1000L));
            a.this.aHZ();
            ??? = a.this;
            ???.yND += 1;
            label414:
            if (a.this.yNy)
            {
              ad.w("MicroMsg.MusicFingerPrintRecorder", "client:%d stop now! duration:%d  ", new Object[] { Integer.valueOf(a.this.yNz), Long.valueOf(l) });
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
  private void a(cvp paramcvp, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 28270
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 81	com/tencent/mm/plugin/shake/d/a/a:yNE	Z
    //   12: ifne +30 -> 42
    //   15: aload_0
    //   16: getfield 71	com/tencent/mm/plugin/shake/d/a/a:yNw	Lcom/tencent/mm/plugin/shake/d/a/a$a;
    //   19: aload_1
    //   20: lload_2
    //   21: iload 4
    //   23: invokeinterface 97 5 0
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 81	com/tencent/mm/plugin/shake/d/a/a:yNE	Z
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
    //   0	63	1	paramcvp	cvp
    //   0	63	2	paramLong	long
    //   0	63	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	39	58	finally
    //   42	55	58	finally
  }
  
  private void qT(final boolean paramBoolean)
  {
    AppMethodBeat.i(28269);
    ad.d("MicroMsg.MusicFingerPrintRecorder", "tryCallBack, directFail = %s", new Object[] { Boolean.FALSE });
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28260);
        if (this.yNG)
        {
          a.a(a.this, null, -1L, paramBoolean);
          AppMethodBeat.o(28260);
          return;
        }
        if (!a.this.yNu)
        {
          ad.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack netscen not return.");
          AppMethodBeat.o(28260);
          return;
        }
        if (a.this.dgu != null)
        {
          ad.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack device not ready!");
          AppMethodBeat.o(28260);
          return;
        }
        if (a.this.yNv != null)
        {
          a locala = a.this;
          cvp localcvp = a.this.yNv.dPr();
          e locale = a.this.yNv;
          long l2 = bt.flT();
          long l1 = l2;
          if (locale.yNK > 0L)
          {
            l1 = l2;
            if (locale.yNK < l2) {
              l1 = locale.yNK;
            }
          }
          a.a(locala, localcvp, l1, paramBoolean);
          AppMethodBeat.o(28260);
          return;
        }
        a.a(a.this, null, -1L, paramBoolean);
        AppMethodBeat.o(28260);
      }
    });
    AppMethodBeat.o(28269);
  }
  
  public final boolean PG()
  {
    AppMethodBeat.i(28266);
    ad.d("MicroMsg.MusicFingerPrintRecorder", "stopRecord now clientid:%d", new Object[] { Integer.valueOf(this.yNz) });
    ba.aiU().b(367, this);
    ba.aiU().b(408, this);
    synchronized (this.yNp)
    {
      this.yNq = 0;
      if (this.dgu != null)
      {
        this.dgu.PG();
        this.dgu = null;
      }
      AppMethodBeat.o(28266);
      return true;
    }
  }
  
  public final boolean a(int paramInt, a arg2)
  {
    AppMethodBeat.i(28267);
    PG();
    synchronized (this.diV)
    {
      this.yNA = QAFPNative.QAFPGetVersion();
      dPo();
      this.yNt = paramInt;
      this.yNw = ???;
      this.yNy = false;
      this.yNx = false;
      this.yNu = false;
      this.yNE = false;
      ba.aiU().a(367, this);
      ba.aiU().a(408, this);
      this.yNz = ((int)bt.flT());
      ad.d("MicroMsg.MusicFingerPrintRecorder", "startRecord now clientid:%d", new Object[] { Integer.valueOf(this.yNz) });
      this.dgu = new c(8000, 1, 4);
      this.dgu.dgW = -19;
      this.dgu.dhh = this.dhz;
      if (!this.dgu.PP())
      {
        ad.e("MicroMsg.MusicFingerPrintRecorder", "start record failed");
        reset();
        AppMethodBeat.o(28267);
        return false;
      }
    }
    synchronized (this.diV)
    {
      paramInt = QAFPNative.QAFPReset();
      ad.d("MicroMsg.MusicFingerPrintRecorder", "QAFPReset ret:%d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt < 0)
      {
        ad.e("MicroMsg.MusicFingerPrintRecorder", "init failed QAFPReset:%d clientid:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.yNz) });
        reset();
        AppMethodBeat.o(28267);
        return false;
      }
      this.yNs = bt.flT();
      this.yNC = bt.flT();
      this.yND = 0;
      AppMethodBeat.o(28267);
      return true;
    }
  }
  
  final void aHZ()
  {
    AppMethodBeat.i(28271);
    ba.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28261);
        if (a.this.yNx)
        {
          ad.e("MicroMsg.MusicFingerPrintRecorder", "tryStartNetscene clientid: %d but netscene is running.", new Object[] { Integer.valueOf(a.this.yNz) });
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
          synchronized (a.this.yNp)
          {
            if (a.this.yNq <= 0)
            {
              AppMethodBeat.o(28261);
              return;
            }
            byte[] arrayOfByte1 = new byte[a.this.yNq];
            System.arraycopy(a.this.yNp, 0, arrayOfByte1, 0, a.this.yNq);
            a.this.yNq = 0;
            l = a.this.yNs;
            a.this.yNx = true;
            i = a.this.yNt;
            j = a.this.yNr;
            k = a.this.yNz;
            bool = a.this.yNy;
            m = a.this.yNA;
            if (i == 367)
            {
              ??? = new f(arrayOfByte1, j, l, k, bool, m);
              ba.aiU().a((n)???, 0);
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
  
  public final boolean dPo()
  {
    boolean bool = false;
    AppMethodBeat.i(28264);
    for (;;)
    {
      int i;
      synchronized (this.diV)
      {
        if (this.yNB)
        {
          ad.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit already inited");
          AppMethodBeat.o(28264);
          return false;
        }
        i = QAFPNative.QAFPInit();
        ad.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit ret:%d", new Object[] { Integer.valueOf(i) });
        if (i >= 0)
        {
          this.yNB = true;
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
  
  public final boolean dPp()
  {
    boolean bool = false;
    AppMethodBeat.i(28265);
    synchronized (this.diV)
    {
      if (!this.yNB)
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
    this.yNx = false;
    if (((e)paramn).dPq())
    {
      ad.d("MicroMsg.MusicFingerPrintRecorder", "NetSceneShakeMedia isRecogSuccess stop now ! clientid:%d", new Object[] { Integer.valueOf(this.yNz) });
      PG();
      this.yNv = ((e)paramn);
      this.yNu = true;
      qT(false);
      AppMethodBeat.o(28272);
      return;
    }
    if ((this.yNq == 0) && (this.yNy))
    {
      ad.d("MicroMsg.MusicFingerPrintRecorder", "recog failed . clientid:%d", new Object[] { Integer.valueOf(this.yNz) });
      this.yNv = null;
      this.yNu = true;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        qT(false);
      }
      for (;;)
      {
        ba.aiU().b(367, this);
        ba.aiU().b(408, this);
        AppMethodBeat.o(28272);
        return;
        qT(true);
      }
    }
    ad.d("MicroMsg.MusicFingerPrintRecorder", "NetScene try again clientId:%d", new Object[] { Integer.valueOf(this.yNz) });
    aHZ();
    AppMethodBeat.o(28272);
  }
  
  final void reset()
  {
    AppMethodBeat.i(28268);
    ad.d("MicroMsg.MusicFingerPrintRecorder", "reset recorder clientid:%d", new Object[] { Integer.valueOf(this.yNz) });
    if (this.dgu != null)
    {
      this.dgu.PG();
      this.dgu = null;
    }
    qT(false);
    AppMethodBeat.o(28268);
  }
  
  public static abstract interface a
  {
    public abstract void b(cvp paramcvp, long paramLong, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.a
 * JD-Core Version:    0.7.0.1
 */