package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.qafpapi.QAFPNative;

public final class a
  implements com.tencent.mm.ak.f
{
  c dhw;
  private c.a diC;
  Object djX;
  int zdA;
  int zdB;
  long zdC;
  int zdD;
  boolean zdE;
  e zdF;
  private a zdG;
  boolean zdH;
  boolean zdI;
  int zdJ;
  int zdK;
  private boolean zdL;
  long zdM;
  int zdN;
  private boolean zdO;
  byte[] zdz;
  
  public a()
  {
    AppMethodBeat.i(28263);
    this.zdz = new byte[10240];
    this.zdA = 0;
    this.zdB = 0;
    this.zdC = 0L;
    this.zdD = 0;
    this.zdE = false;
    this.zdF = null;
    this.djX = new Object();
    this.zdG = null;
    this.zdH = false;
    this.zdI = false;
    this.zdJ = 0;
    this.zdL = false;
    this.zdO = false;
    this.diC = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] arg1, int paramAnonymousInt)
      {
        AppMethodBeat.i(28259);
        f.a locala = new f.a();
        long l;
        for (;;)
        {
          synchronized (a.this.djX)
          {
            int i;
            if (a.this.zdD == 408)
            {
              ae.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPProcessTV");
              i = QAFPNative.QAFPProcessTV(???, paramAnonymousInt);
              l = bu.fpO() - a.this.zdM;
              ae.d("MicroMsg.MusicFingerPrintRecorder", "QAFPProcess clientid:%d pcm:%d ret:%d dur:%d usetime:%d", new Object[] { Integer.valueOf(a.this.zdJ), Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), Long.valueOf(l), Long.valueOf(locala.abs()) });
              if (l <= a.this.zdN * 3000 + 4000) {
                break label414;
              }
              ??? = new byte[10240];
              ??? = new f.a();
              if (a.this.zdD == 408)
              {
                ae.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPGetAudioFingerPrintTV");
                paramAnonymousInt = QAFPNative.QAFPGetAudioFingerPrintTV((byte[])???);
                ae.d("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d outLen:%d time:%d", new Object[] { Integer.valueOf(a.this.zdJ), Integer.valueOf(paramAnonymousInt), Long.valueOf(???.abs()) });
                if ((paramAnonymousInt < 10240) && (paramAnonymousInt > 0)) {
                  break;
                }
                ae.e("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d  out ret:%d  !stop record now", new Object[] { Integer.valueOf(a.this.zdJ), Integer.valueOf(paramAnonymousInt) });
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
        synchronized (a.this.zdz)
        {
          System.arraycopy(???, 0, a.this.zdz, 0, paramAnonymousInt);
          a.this.zdA = paramAnonymousInt;
          ??? = a.this;
          if (a.this.zdN >= 3)
          {
            bool = true;
            ((a)???).zdI = bool;
            a.this.zdB = ((int)(l / 1000L));
            a.this.aIq();
            ??? = a.this;
            ???.zdN += 1;
            label414:
            if (a.this.zdI)
            {
              ae.w("MicroMsg.MusicFingerPrintRecorder", "client:%d stop now! duration:%d  ", new Object[] { Integer.valueOf(a.this.zdJ), Long.valueOf(l) });
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
  private void a(cwj paramcwj, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 28270
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 81	com/tencent/mm/plugin/shake/d/a/a:zdO	Z
    //   12: ifne +30 -> 42
    //   15: aload_0
    //   16: getfield 71	com/tencent/mm/plugin/shake/d/a/a:zdG	Lcom/tencent/mm/plugin/shake/d/a/a$a;
    //   19: aload_1
    //   20: lload_2
    //   21: iload 4
    //   23: invokeinterface 97 5 0
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 81	com/tencent/mm/plugin/shake/d/a/a:zdO	Z
    //   33: sipush 28270
    //   36: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: ldc 99
    //   44: ldc 101
    //   46: invokestatic 107	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   0	63	1	paramcwj	cwj
    //   0	63	2	paramLong	long
    //   0	63	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	39	58	finally
    //   42	55	58	finally
  }
  
  private void ra(final boolean paramBoolean)
  {
    AppMethodBeat.i(28269);
    ae.d("MicroMsg.MusicFingerPrintRecorder", "tryCallBack, directFail = %s", new Object[] { Boolean.FALSE });
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28260);
        if (this.zdQ)
        {
          a.a(a.this, null, -1L, paramBoolean);
          AppMethodBeat.o(28260);
          return;
        }
        if (!a.this.zdE)
        {
          ae.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack netscen not return.");
          AppMethodBeat.o(28260);
          return;
        }
        if (a.this.dhw != null)
        {
          ae.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack device not ready!");
          AppMethodBeat.o(28260);
          return;
        }
        if (a.this.zdF != null)
        {
          a locala = a.this;
          cwj localcwj = a.this.zdF.dSO();
          e locale = a.this.zdF;
          long l2 = bu.fpO();
          long l1 = l2;
          if (locale.zdU > 0L)
          {
            l1 = l2;
            if (locale.zdU < l2) {
              l1 = locale.zdU;
            }
          }
          a.a(locala, localcwj, l1, paramBoolean);
          AppMethodBeat.o(28260);
          return;
        }
        a.a(a.this, null, -1L, paramBoolean);
        AppMethodBeat.o(28260);
      }
    });
    AppMethodBeat.o(28269);
  }
  
  public final boolean PF()
  {
    AppMethodBeat.i(28266);
    ae.d("MicroMsg.MusicFingerPrintRecorder", "stopRecord now clientid:%d", new Object[] { Integer.valueOf(this.zdJ) });
    bc.ajj().b(367, this);
    bc.ajj().b(408, this);
    synchronized (this.zdz)
    {
      this.zdA = 0;
      if (this.dhw != null)
      {
        this.dhw.PF();
        this.dhw = null;
      }
      AppMethodBeat.o(28266);
      return true;
    }
  }
  
  public final boolean a(int paramInt, a arg2)
  {
    AppMethodBeat.i(28267);
    PF();
    synchronized (this.djX)
    {
      this.zdK = QAFPNative.QAFPGetVersion();
      dSL();
      this.zdD = paramInt;
      this.zdG = ???;
      this.zdI = false;
      this.zdH = false;
      this.zdE = false;
      this.zdO = false;
      bc.ajj().a(367, this);
      bc.ajj().a(408, this);
      this.zdJ = ((int)bu.fpO());
      ae.d("MicroMsg.MusicFingerPrintRecorder", "startRecord now clientid:%d", new Object[] { Integer.valueOf(this.zdJ) });
      this.dhw = new c(8000, 1, 4);
      this.dhw.dhY = -19;
      this.dhw.dij = this.diC;
      if (!this.dhw.PO())
      {
        ae.e("MicroMsg.MusicFingerPrintRecorder", "start record failed");
        reset();
        AppMethodBeat.o(28267);
        return false;
      }
    }
    synchronized (this.djX)
    {
      paramInt = QAFPNative.QAFPReset();
      ae.d("MicroMsg.MusicFingerPrintRecorder", "QAFPReset ret:%d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt < 0)
      {
        ae.e("MicroMsg.MusicFingerPrintRecorder", "init failed QAFPReset:%d clientid:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.zdJ) });
        reset();
        AppMethodBeat.o(28267);
        return false;
      }
      this.zdC = bu.fpO();
      this.zdM = bu.fpO();
      this.zdN = 0;
      AppMethodBeat.o(28267);
      return true;
    }
  }
  
  final void aIq()
  {
    AppMethodBeat.i(28271);
    bc.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28261);
        if (a.this.zdH)
        {
          ae.e("MicroMsg.MusicFingerPrintRecorder", "tryStartNetscene clientid: %d but netscene is running.", new Object[] { Integer.valueOf(a.this.zdJ) });
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
          synchronized (a.this.zdz)
          {
            if (a.this.zdA <= 0)
            {
              AppMethodBeat.o(28261);
              return;
            }
            byte[] arrayOfByte1 = new byte[a.this.zdA];
            System.arraycopy(a.this.zdz, 0, arrayOfByte1, 0, a.this.zdA);
            a.this.zdA = 0;
            l = a.this.zdC;
            a.this.zdH = true;
            i = a.this.zdD;
            j = a.this.zdB;
            k = a.this.zdJ;
            bool = a.this.zdI;
            m = a.this.zdK;
            if (i == 367)
            {
              ??? = new f(arrayOfByte1, j, l, k, bool, m);
              bc.ajj().a((n)???, 0);
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
  
  public final boolean dSL()
  {
    boolean bool = false;
    AppMethodBeat.i(28264);
    for (;;)
    {
      int i;
      synchronized (this.djX)
      {
        if (this.zdL)
        {
          ae.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit already inited");
          AppMethodBeat.o(28264);
          return false;
        }
        i = QAFPNative.QAFPInit();
        ae.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit ret:%d", new Object[] { Integer.valueOf(i) });
        if (i >= 0)
        {
          this.zdL = true;
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
  
  public final boolean dSM()
  {
    boolean bool = false;
    AppMethodBeat.i(28265);
    synchronized (this.djX)
    {
      if (!this.zdL)
      {
        ae.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease never inited");
        AppMethodBeat.o(28265);
        return false;
      }
      int i = QAFPNative.QAFPRelease();
      ae.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease ret:%d", new Object[] { Integer.valueOf(i) });
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
    ae.d("MicroMsg.MusicFingerPrintRecorder", "onSceneEnd errType = %s, errCode = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.zdH = false;
    if (((e)paramn).dSN())
    {
      ae.d("MicroMsg.MusicFingerPrintRecorder", "NetSceneShakeMedia isRecogSuccess stop now ! clientid:%d", new Object[] { Integer.valueOf(this.zdJ) });
      PF();
      this.zdF = ((e)paramn);
      this.zdE = true;
      ra(false);
      AppMethodBeat.o(28272);
      return;
    }
    if ((this.zdA == 0) && (this.zdI))
    {
      ae.d("MicroMsg.MusicFingerPrintRecorder", "recog failed . clientid:%d", new Object[] { Integer.valueOf(this.zdJ) });
      this.zdF = null;
      this.zdE = true;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        ra(false);
      }
      for (;;)
      {
        bc.ajj().b(367, this);
        bc.ajj().b(408, this);
        AppMethodBeat.o(28272);
        return;
        ra(true);
      }
    }
    ae.d("MicroMsg.MusicFingerPrintRecorder", "NetScene try again clientId:%d", new Object[] { Integer.valueOf(this.zdJ) });
    aIq();
    AppMethodBeat.o(28272);
  }
  
  final void reset()
  {
    AppMethodBeat.i(28268);
    ae.d("MicroMsg.MusicFingerPrintRecorder", "reset recorder clientid:%d", new Object[] { Integer.valueOf(this.zdJ) });
    if (this.dhw != null)
    {
      this.dhw.PF();
      this.dhw = null;
    }
    ra(false);
    AppMethodBeat.o(28268);
  }
  
  public static abstract interface a
  {
    public abstract void b(cwj paramcwj, long paramLong, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.a
 * JD-Core Version:    0.7.0.1
 */