package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.f.b.c;
import com.tencent.mm.f.b.c.a;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qafpapi.QAFPNative;

public final class a
  implements f
{
  c bCc;
  private c.a bDg = new a.1(this);
  Object ikx = new Object();
  int oaA;
  private boolean oaB = false;
  long oaC;
  int oaD;
  private boolean oaE = false;
  byte[] oap = new byte[10240];
  int oaq = 0;
  int oar = 0;
  long oas = 0L;
  int oat = 0;
  boolean oau = false;
  e oav = null;
  private a.a oaw = null;
  boolean oax = false;
  boolean oay = false;
  int oaz = 0;
  
  /* Error */
  private void a(com.tencent.mm.protocal.c.bly parambly, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 68	com/tencent/mm/plugin/shake/d/a/a:oaE	Z
    //   6: ifne +24 -> 30
    //   9: aload_0
    //   10: getfield 58	com/tencent/mm/plugin/shake/d/a/a:oaw	Lcom/tencent/mm/plugin/shake/d/a/a$a;
    //   13: aload_1
    //   14: lload_2
    //   15: iload 4
    //   17: invokeinterface 84 5 0
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 68	com/tencent/mm/plugin/shake/d/a/a:oaE	Z
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: ldc 86
    //   32: ldc 88
    //   34: invokestatic 94	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: goto -10 -> 27
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	a
    //   0	45	1	parambly	com.tencent.mm.protocal.c.bly
    //   0	45	2	paramLong	long
    //   0	45	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	27	40	finally
    //   30	37	40	finally
  }
  
  private void iH(boolean paramBoolean)
  {
    y.d("MicroMsg.MusicFingerPrintRecorder", "tryCallBack, directFail = %s", new Object[] { Boolean.valueOf(false) });
    ai.d(new a.2(this, paramBoolean));
  }
  
  final void Om()
  {
    au.DS().O(new a.3(this));
  }
  
  public final boolean a(int paramInt, a.a arg2)
  {
    uh();
    synchronized (this.ikx)
    {
      this.oaA = QAFPNative.QAFPGetVersion();
      bAu();
      this.oat = paramInt;
      this.oaw = ???;
      this.oay = false;
      this.oax = false;
      this.oau = false;
      this.oaE = false;
      au.Dk().a(367, this);
      au.Dk().a(408, this);
      this.oaz = ((int)bk.UY());
      y.d("MicroMsg.MusicFingerPrintRecorder", "startRecord now clientid:%d", new Object[] { Integer.valueOf(this.oaz) });
      this.bCc = new c(8000, 1, 4);
      this.bCc.bCE = -19;
      this.bCc.bCP = this.bDg;
      if (!this.bCc.uq())
      {
        y.e("MicroMsg.MusicFingerPrintRecorder", "start record failed");
        reset();
        return false;
      }
    }
    synchronized (this.ikx)
    {
      paramInt = QAFPNative.QAFPReset();
      y.d("MicroMsg.MusicFingerPrintRecorder", "QAFPReset ret:%d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt < 0)
      {
        y.e("MicroMsg.MusicFingerPrintRecorder", "init failed QAFPReset:%d clientid:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.oaz) });
        reset();
        return false;
      }
    }
    this.oas = bk.UY();
    this.oaC = bk.UY();
    this.oaD = 0;
    return true;
  }
  
  public final boolean bAu()
  {
    boolean bool = false;
    for (;;)
    {
      int i;
      synchronized (this.ikx)
      {
        if (this.oaB)
        {
          y.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit already inited");
          return false;
        }
        i = QAFPNative.QAFPInit();
        y.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit ret:%d", new Object[] { Integer.valueOf(i) });
        if (i >= 0)
        {
          this.oaB = true;
          break label72;
          return bool;
        }
      }
      label72:
      if (i >= 0) {
        bool = true;
      }
    }
  }
  
  public final boolean bAv()
  {
    boolean bool = false;
    synchronized (this.ikx)
    {
      if (!this.oaB)
      {
        y.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease never inited");
        return false;
      }
      int i = QAFPNative.QAFPRelease();
      y.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease ret:%d", new Object[] { Integer.valueOf(i) });
      if (i >= 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm.getType() != 367) && (paramm.getType() != 408)) {
      return;
    }
    y.d("MicroMsg.MusicFingerPrintRecorder", "onSceneEnd errType = %s, errCode = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.oax = false;
    if (((e)paramm).bAw())
    {
      y.d("MicroMsg.MusicFingerPrintRecorder", "NetSceneShakeMedia isRecogSuccess stop now ! clientid:%d", new Object[] { Integer.valueOf(this.oaz) });
      uh();
      this.oav = ((e)paramm);
      this.oau = true;
      iH(false);
      return;
    }
    if ((this.oaq == 0) && (this.oay))
    {
      y.d("MicroMsg.MusicFingerPrintRecorder", "recog failed . clientid:%d", new Object[] { Integer.valueOf(this.oaz) });
      this.oav = null;
      this.oau = true;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        iH(false);
      }
      for (;;)
      {
        au.Dk().b(367, this);
        au.Dk().b(408, this);
        return;
        iH(true);
      }
    }
    y.d("MicroMsg.MusicFingerPrintRecorder", "NetScene try again clientId:%d", new Object[] { Integer.valueOf(this.oaz) });
    Om();
  }
  
  final void reset()
  {
    y.d("MicroMsg.MusicFingerPrintRecorder", "reset recorder clientid:%d", new Object[] { Integer.valueOf(this.oaz) });
    if (this.bCc != null)
    {
      this.bCc.uh();
      this.bCc = null;
    }
    iH(false);
  }
  
  public final boolean uh()
  {
    y.d("MicroMsg.MusicFingerPrintRecorder", "stopRecord now clientid:%d", new Object[] { Integer.valueOf(this.oaz) });
    au.Dk().b(367, this);
    au.Dk().b(408, this);
    synchronized (this.oap)
    {
      this.oaq = 0;
      if (this.bCc != null)
      {
        this.bCc.uh();
        this.bCc = null;
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.a
 * JD-Core Version:    0.7.0.1
 */