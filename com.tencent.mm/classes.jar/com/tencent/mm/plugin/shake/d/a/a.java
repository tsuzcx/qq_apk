package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qafpapi.QAFPNative;

public final class a
  implements f
{
  c ciR;
  private c.a cjU;
  Object clk;
  int qOA;
  long qOB;
  int qOC;
  boolean qOD;
  e qOE;
  private a.a qOF;
  boolean qOG;
  boolean qOH;
  int qOI;
  int qOJ;
  private boolean qOK;
  long qOL;
  int qOM;
  private boolean qON;
  byte[] qOy;
  int qOz;
  
  public a()
  {
    AppMethodBeat.i(24593);
    this.qOy = new byte[10240];
    this.qOz = 0;
    this.qOA = 0;
    this.qOB = 0L;
    this.qOC = 0;
    this.qOD = false;
    this.qOE = null;
    this.clk = new Object();
    this.qOF = null;
    this.qOG = false;
    this.qOH = false;
    this.qOI = 0;
    this.qOK = false;
    this.qON = false;
    this.cjU = new a.1(this);
    AppMethodBeat.o(24593);
  }
  
  /* Error */
  private void a(com.tencent.mm.protocal.protobuf.bvk parambvk, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 24600
    //   5: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 74	com/tencent/mm/plugin/shake/d/a/a:qON	Z
    //   12: ifne +30 -> 42
    //   15: aload_0
    //   16: getfield 64	com/tencent/mm/plugin/shake/d/a/a:qOF	Lcom/tencent/mm/plugin/shake/d/a/a$a;
    //   19: aload_1
    //   20: lload_2
    //   21: iload 4
    //   23: invokeinterface 93 5 0
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 74	com/tencent/mm/plugin/shake/d/a/a:qON	Z
    //   33: sipush 24600
    //   36: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: ldc 95
    //   44: ldc 97
    //   46: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: sipush 24600
    //   52: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: goto -16 -> 39
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	a
    //   0	63	1	parambvk	com.tencent.mm.protocal.protobuf.bvk
    //   0	63	2	paramLong	long
    //   0	63	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	39	58	finally
    //   42	55	58	finally
  }
  
  private void kK(boolean paramBoolean)
  {
    AppMethodBeat.i(24599);
    ab.d("MicroMsg.MusicFingerPrintRecorder", "tryCallBack, directFail = %s", new Object[] { Boolean.FALSE });
    al.d(new a.2(this, paramBoolean));
    AppMethodBeat.o(24599);
  }
  
  public final boolean Et()
  {
    AppMethodBeat.i(24596);
    ab.d("MicroMsg.MusicFingerPrintRecorder", "stopRecord now clientid:%d", new Object[] { Integer.valueOf(this.qOI) });
    aw.Rc().b(367, this);
    aw.Rc().b(408, this);
    synchronized (this.qOy)
    {
      this.qOz = 0;
      if (this.ciR != null)
      {
        this.ciR.Et();
        this.ciR = null;
      }
      AppMethodBeat.o(24596);
      return true;
    }
  }
  
  public final boolean a(int paramInt, a.a arg2)
  {
    AppMethodBeat.i(24597);
    Et();
    synchronized (this.clk)
    {
      this.qOJ = QAFPNative.QAFPGetVersion();
      clO();
      this.qOC = paramInt;
      this.qOF = ???;
      this.qOH = false;
      this.qOG = false;
      this.qOD = false;
      this.qON = false;
      aw.Rc().a(367, this);
      aw.Rc().a(408, this);
      this.qOI = ((int)bo.aoy());
      ab.d("MicroMsg.MusicFingerPrintRecorder", "startRecord now clientid:%d", new Object[] { Integer.valueOf(this.qOI) });
      this.ciR = new c(8000, 1, 4);
      this.ciR.cjs = -19;
      this.ciR.cjD = this.cjU;
      if (!this.ciR.EC())
      {
        ab.e("MicroMsg.MusicFingerPrintRecorder", "start record failed");
        reset();
        AppMethodBeat.o(24597);
        return false;
      }
    }
    synchronized (this.clk)
    {
      paramInt = QAFPNative.QAFPReset();
      ab.d("MicroMsg.MusicFingerPrintRecorder", "QAFPReset ret:%d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt < 0)
      {
        ab.e("MicroMsg.MusicFingerPrintRecorder", "init failed QAFPReset:%d clientid:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.qOI) });
        reset();
        AppMethodBeat.o(24597);
        return false;
      }
      this.qOB = bo.aoy();
      this.qOL = bo.aoy();
      this.qOM = 0;
      AppMethodBeat.o(24597);
      return true;
    }
  }
  
  final void ahb()
  {
    AppMethodBeat.i(24601);
    aw.RO().ac(new a.3(this));
    AppMethodBeat.o(24601);
  }
  
  public final boolean clO()
  {
    boolean bool = false;
    AppMethodBeat.i(24594);
    for (;;)
    {
      int i;
      synchronized (this.clk)
      {
        if (this.qOK)
        {
          ab.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit already inited");
          AppMethodBeat.o(24594);
          return false;
        }
        i = QAFPNative.QAFPInit();
        ab.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit ret:%d", new Object[] { Integer.valueOf(i) });
        if (i >= 0)
        {
          this.qOK = true;
          break label96;
          AppMethodBeat.o(24594);
          return bool;
        }
      }
      label96:
      if (i >= 0) {
        bool = true;
      }
    }
  }
  
  public final boolean clP()
  {
    boolean bool = false;
    AppMethodBeat.i(24595);
    synchronized (this.clk)
    {
      if (!this.qOK)
      {
        ab.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease never inited");
        AppMethodBeat.o(24595);
        return false;
      }
      int i = QAFPNative.QAFPRelease();
      ab.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease ret:%d", new Object[] { Integer.valueOf(i) });
      if (i >= 0) {
        bool = true;
      }
      AppMethodBeat.o(24595);
      return bool;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(24602);
    if ((paramm.getType() != 367) && (paramm.getType() != 408))
    {
      AppMethodBeat.o(24602);
      return;
    }
    ab.d("MicroMsg.MusicFingerPrintRecorder", "onSceneEnd errType = %s, errCode = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.qOG = false;
    if (((e)paramm).clQ())
    {
      ab.d("MicroMsg.MusicFingerPrintRecorder", "NetSceneShakeMedia isRecogSuccess stop now ! clientid:%d", new Object[] { Integer.valueOf(this.qOI) });
      Et();
      this.qOE = ((e)paramm);
      this.qOD = true;
      kK(false);
      AppMethodBeat.o(24602);
      return;
    }
    if ((this.qOz == 0) && (this.qOH))
    {
      ab.d("MicroMsg.MusicFingerPrintRecorder", "recog failed . clientid:%d", new Object[] { Integer.valueOf(this.qOI) });
      this.qOE = null;
      this.qOD = true;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        kK(false);
      }
      for (;;)
      {
        aw.Rc().b(367, this);
        aw.Rc().b(408, this);
        AppMethodBeat.o(24602);
        return;
        kK(true);
      }
    }
    ab.d("MicroMsg.MusicFingerPrintRecorder", "NetScene try again clientId:%d", new Object[] { Integer.valueOf(this.qOI) });
    ahb();
    AppMethodBeat.o(24602);
  }
  
  final void reset()
  {
    AppMethodBeat.i(24598);
    ab.d("MicroMsg.MusicFingerPrintRecorder", "reset recorder clientid:%d", new Object[] { Integer.valueOf(this.qOI) });
    if (this.ciR != null)
    {
      this.ciR.Et();
      this.ciR = null;
    }
    kK(false);
    AppMethodBeat.o(24598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.a
 * JD-Core Version:    0.7.0.1
 */