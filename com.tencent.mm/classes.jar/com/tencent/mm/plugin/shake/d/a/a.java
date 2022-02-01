package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.az;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.qafpapi.QAFPNative;

public final class a
  implements com.tencent.mm.ak.g
{
  c cVe;
  private c.a cWj;
  Object cXD;
  byte[] xyF;
  int xyG;
  int xyH;
  long xyI;
  int xyJ;
  boolean xyK;
  e xyL;
  private a xyM;
  boolean xyN;
  boolean xyO;
  int xyP;
  int xyQ;
  private boolean xyR;
  long xyS;
  int xyT;
  private boolean xyU;
  
  public a()
  {
    AppMethodBeat.i(28263);
    this.xyF = new byte[10240];
    this.xyG = 0;
    this.xyH = 0;
    this.xyI = 0L;
    this.xyJ = 0;
    this.xyK = false;
    this.xyL = null;
    this.cXD = new Object();
    this.xyM = null;
    this.xyN = false;
    this.xyO = false;
    this.xyP = 0;
    this.xyR = false;
    this.xyU = false;
    this.cWj = new c.a()
    {
      public final void cf(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] arg1, int paramAnonymousInt)
      {
        AppMethodBeat.i(28259);
        f.a locala = new f.a();
        long l;
        for (;;)
        {
          synchronized (a.this.cXD)
          {
            int i;
            if (a.this.xyJ == 408)
            {
              ac.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPProcessTV");
              i = QAFPNative.QAFPProcessTV(???, paramAnonymousInt);
              l = bs.eWj() - a.this.xyS;
              ac.d("MicroMsg.MusicFingerPrintRecorder", "QAFPProcess clientid:%d pcm:%d ret:%d dur:%d usetime:%d", new Object[] { Integer.valueOf(a.this.xyP), Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), Long.valueOf(l), Long.valueOf(locala.YH()) });
              if (l <= a.this.xyT * 3000 + 4000) {
                break label414;
              }
              ??? = new byte[10240];
              ??? = new f.a();
              if (a.this.xyJ == 408)
              {
                ac.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPGetAudioFingerPrintTV");
                paramAnonymousInt = QAFPNative.QAFPGetAudioFingerPrintTV((byte[])???);
                ac.d("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d outLen:%d time:%d", new Object[] { Integer.valueOf(a.this.xyP), Integer.valueOf(paramAnonymousInt), Long.valueOf(???.YH()) });
                if ((paramAnonymousInt < 10240) && (paramAnonymousInt > 0)) {
                  break;
                }
                ac.e("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d  out ret:%d  !stop record now", new Object[] { Integer.valueOf(a.this.xyP), Integer.valueOf(paramAnonymousInt) });
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
        synchronized (a.this.xyF)
        {
          System.arraycopy(???, 0, a.this.xyF, 0, paramAnonymousInt);
          a.this.xyG = paramAnonymousInt;
          ??? = a.this;
          if (a.this.xyT >= 3)
          {
            bool = true;
            ((a)???).xyO = bool;
            a.this.xyH = ((int)(l / 1000L));
            a.this.aEU();
            ??? = a.this;
            ???.xyT += 1;
            label414:
            if (a.this.xyO)
            {
              ac.w("MicroMsg.MusicFingerPrintRecorder", "client:%d stop now! duration:%d  ", new Object[] { Integer.valueOf(a.this.xyP), Long.valueOf(l) });
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
  private void a(cqk paramcqk, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 28270
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 81	com/tencent/mm/plugin/shake/d/a/a:xyU	Z
    //   12: ifne +30 -> 42
    //   15: aload_0
    //   16: getfield 71	com/tencent/mm/plugin/shake/d/a/a:xyM	Lcom/tencent/mm/plugin/shake/d/a/a$a;
    //   19: aload_1
    //   20: lload_2
    //   21: iload 4
    //   23: invokeinterface 97 5 0
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 81	com/tencent/mm/plugin/shake/d/a/a:xyU	Z
    //   33: sipush 28270
    //   36: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: ldc 99
    //   44: ldc 101
    //   46: invokestatic 107	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   0	63	1	paramcqk	cqk
    //   0	63	2	paramLong	long
    //   0	63	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	39	58	finally
    //   42	55	58	finally
  }
  
  private void qr(final boolean paramBoolean)
  {
    AppMethodBeat.i(28269);
    ac.d("MicroMsg.MusicFingerPrintRecorder", "tryCallBack, directFail = %s", new Object[] { Boolean.FALSE });
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28260);
        if (this.xyW)
        {
          a.a(a.this, null, -1L, paramBoolean);
          AppMethodBeat.o(28260);
          return;
        }
        if (!a.this.xyK)
        {
          ac.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack netscen not return.");
          AppMethodBeat.o(28260);
          return;
        }
        if (a.this.cVe != null)
        {
          ac.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack device not ready!");
          AppMethodBeat.o(28260);
          return;
        }
        if (a.this.xyL != null)
        {
          a locala = a.this;
          cqk localcqk = a.this.xyL.dDO();
          e locale = a.this.xyL;
          long l2 = bs.eWj();
          long l1 = l2;
          if (locale.xza > 0L)
          {
            l1 = l2;
            if (locale.xza < l2) {
              l1 = locale.xza;
            }
          }
          a.a(locala, localcqk, l1, paramBoolean);
          AppMethodBeat.o(28260);
          return;
        }
        a.a(a.this, null, -1L, paramBoolean);
        AppMethodBeat.o(28260);
      }
    });
    AppMethodBeat.o(28269);
  }
  
  public final boolean NX()
  {
    AppMethodBeat.i(28266);
    ac.d("MicroMsg.MusicFingerPrintRecorder", "stopRecord now clientid:%d", new Object[] { Integer.valueOf(this.xyP) });
    az.agi().b(367, this);
    az.agi().b(408, this);
    synchronized (this.xyF)
    {
      this.xyG = 0;
      if (this.cVe != null)
      {
        this.cVe.NX();
        this.cVe = null;
      }
      AppMethodBeat.o(28266);
      return true;
    }
  }
  
  public final boolean a(int paramInt, a arg2)
  {
    AppMethodBeat.i(28267);
    NX();
    synchronized (this.cXD)
    {
      this.xyQ = QAFPNative.QAFPGetVersion();
      dDL();
      this.xyJ = paramInt;
      this.xyM = ???;
      this.xyO = false;
      this.xyN = false;
      this.xyK = false;
      this.xyU = false;
      az.agi().a(367, this);
      az.agi().a(408, this);
      this.xyP = ((int)bs.eWj());
      ac.d("MicroMsg.MusicFingerPrintRecorder", "startRecord now clientid:%d", new Object[] { Integer.valueOf(this.xyP) });
      this.cVe = new c(8000, 1, 4);
      this.cVe.cVG = -19;
      this.cVe.cVR = this.cWj;
      if (!this.cVe.Og())
      {
        ac.e("MicroMsg.MusicFingerPrintRecorder", "start record failed");
        reset();
        AppMethodBeat.o(28267);
        return false;
      }
    }
    synchronized (this.cXD)
    {
      paramInt = QAFPNative.QAFPReset();
      ac.d("MicroMsg.MusicFingerPrintRecorder", "QAFPReset ret:%d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt < 0)
      {
        ac.e("MicroMsg.MusicFingerPrintRecorder", "init failed QAFPReset:%d clientid:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.xyP) });
        reset();
        AppMethodBeat.o(28267);
        return false;
      }
      this.xyI = bs.eWj();
      this.xyS = bs.eWj();
      this.xyT = 0;
      AppMethodBeat.o(28267);
      return true;
    }
  }
  
  final void aEU()
  {
    AppMethodBeat.i(28271);
    az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28261);
        if (a.this.xyN)
        {
          ac.e("MicroMsg.MusicFingerPrintRecorder", "tryStartNetscene clientid: %d but netscene is running.", new Object[] { Integer.valueOf(a.this.xyP) });
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
          synchronized (a.this.xyF)
          {
            if (a.this.xyG <= 0)
            {
              AppMethodBeat.o(28261);
              return;
            }
            byte[] arrayOfByte1 = new byte[a.this.xyG];
            System.arraycopy(a.this.xyF, 0, arrayOfByte1, 0, a.this.xyG);
            a.this.xyG = 0;
            l = a.this.xyI;
            a.this.xyN = true;
            i = a.this.xyJ;
            j = a.this.xyH;
            k = a.this.xyP;
            bool = a.this.xyO;
            m = a.this.xyQ;
            if (i == 367)
            {
              ??? = new f(arrayOfByte1, j, l, k, bool, m);
              az.agi().a((n)???, 0);
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
  
  public final boolean dDL()
  {
    boolean bool = false;
    AppMethodBeat.i(28264);
    for (;;)
    {
      int i;
      synchronized (this.cXD)
      {
        if (this.xyR)
        {
          ac.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit already inited");
          AppMethodBeat.o(28264);
          return false;
        }
        i = QAFPNative.QAFPInit();
        ac.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit ret:%d", new Object[] { Integer.valueOf(i) });
        if (i >= 0)
        {
          this.xyR = true;
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
  
  public final boolean dDM()
  {
    boolean bool = false;
    AppMethodBeat.i(28265);
    synchronized (this.cXD)
    {
      if (!this.xyR)
      {
        ac.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease never inited");
        AppMethodBeat.o(28265);
        return false;
      }
      int i = QAFPNative.QAFPRelease();
      ac.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease ret:%d", new Object[] { Integer.valueOf(i) });
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
    ac.d("MicroMsg.MusicFingerPrintRecorder", "onSceneEnd errType = %s, errCode = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.xyN = false;
    if (((e)paramn).dDN())
    {
      ac.d("MicroMsg.MusicFingerPrintRecorder", "NetSceneShakeMedia isRecogSuccess stop now ! clientid:%d", new Object[] { Integer.valueOf(this.xyP) });
      NX();
      this.xyL = ((e)paramn);
      this.xyK = true;
      qr(false);
      AppMethodBeat.o(28272);
      return;
    }
    if ((this.xyG == 0) && (this.xyO))
    {
      ac.d("MicroMsg.MusicFingerPrintRecorder", "recog failed . clientid:%d", new Object[] { Integer.valueOf(this.xyP) });
      this.xyL = null;
      this.xyK = true;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        qr(false);
      }
      for (;;)
      {
        az.agi().b(367, this);
        az.agi().b(408, this);
        AppMethodBeat.o(28272);
        return;
        qr(true);
      }
    }
    ac.d("MicroMsg.MusicFingerPrintRecorder", "NetScene try again clientId:%d", new Object[] { Integer.valueOf(this.xyP) });
    aEU();
    AppMethodBeat.o(28272);
  }
  
  final void reset()
  {
    AppMethodBeat.i(28268);
    ac.d("MicroMsg.MusicFingerPrintRecorder", "reset recorder clientid:%d", new Object[] { Integer.valueOf(this.xyP) });
    if (this.cVe != null)
    {
      this.cVe.NX();
      this.cVe = null;
    }
    qr(false);
    AppMethodBeat.o(28268);
  }
  
  public static abstract interface a
  {
    public abstract void b(cqk paramcqk, long paramLong, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.a
 * JD-Core Version:    0.7.0.1
 */