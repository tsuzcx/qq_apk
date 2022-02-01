package com.tencent.mm.plugin.selectrecord.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.kk;

public final class a
{
  public static a Jct = null;
  public int JcA;
  public int JcB;
  public long JcC;
  public int JcD;
  public int JcE;
  public int JcF;
  public int JcG;
  public int JcH;
  public long JcI;
  public long JcJ;
  public kk Jcu;
  public int Jcv;
  public int Jcw;
  public int Jcx;
  public int Jcy;
  public int Jcz;
  
  public a()
  {
    AppMethodBeat.i(255121);
    this.Jcu = null;
    this.Jcv = 0;
    this.Jcw = 0;
    this.Jcx = 0;
    this.Jcy = 0;
    this.Jcz = 0;
    this.JcA = 0;
    this.JcB = 0;
    this.JcC = 0L;
    this.JcD = 0;
    this.JcE = 0;
    this.JcF = 0;
    this.JcG = 0;
    this.JcH = 0;
    this.JcI = 0L;
    this.JcJ = 0L;
    this.Jcu = new kk();
    AppMethodBeat.o(255121);
  }
  
  public static a fFx()
  {
    AppMethodBeat.i(255119);
    if (Jct == null) {
      fFy();
    }
    a locala = Jct;
    AppMethodBeat.o(255119);
    return locala;
  }
  
  public static void fFy()
  {
    AppMethodBeat.i(255120);
    Jct = new a();
    AppMethodBeat.o(255120);
  }
  
  public final void PZ(long paramLong)
  {
    this.Jcu.gNd = paramLong;
  }
  
  public final void Qa(long paramLong)
  {
    if (paramLong > this.JcC) {
      this.Jcu.gNm = (paramLong - this.JcC);
    }
  }
  
  public final void fFA()
  {
    this.Jcz += 1;
  }
  
  public final void fFB()
  {
    this.JcF += 1;
  }
  
  public final void fFz()
  {
    this.Jcy += 1;
  }
  
  public final void xL(boolean paramBoolean)
  {
    kk localkk = this.Jcu;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localkk.gNa = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.b.a
 * JD-Core Version:    0.7.0.1
 */