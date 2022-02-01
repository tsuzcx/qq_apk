package com.tencent.mm.plugin.selectrecord.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.et;

public final class a
{
  public static a yBW = null;
  public et yBX;
  public int yBY;
  public int yBZ;
  public int yCa;
  public int yCb;
  public int yCc;
  public int yCd;
  public int yCe;
  public long yCf;
  public int yCg;
  public int yCh;
  public int yCi;
  public int yCj;
  public int yCk;
  public long yCl;
  public long yCm;
  
  public a()
  {
    AppMethodBeat.i(207395);
    this.yBX = null;
    this.yBY = 0;
    this.yBZ = 0;
    this.yCa = 0;
    this.yCb = 0;
    this.yCc = 0;
    this.yCd = 0;
    this.yCe = 0;
    this.yCf = 0L;
    this.yCg = 0;
    this.yCh = 0;
    this.yCi = 0;
    this.yCj = 0;
    this.yCk = 0;
    this.yCl = 0L;
    this.yCm = 0L;
    this.yBX = new et();
    AppMethodBeat.o(207395);
  }
  
  public static a dNa()
  {
    AppMethodBeat.i(207393);
    if (yBW == null) {
      dNb();
    }
    a locala = yBW;
    AppMethodBeat.o(207393);
    return locala;
  }
  
  public static void dNb()
  {
    AppMethodBeat.i(207394);
    yBW = new a();
    AppMethodBeat.o(207394);
  }
  
  public final void dNc()
  {
    this.yCb += 1;
  }
  
  public final void dNd()
  {
    this.yCc += 1;
  }
  
  public final void dNe()
  {
    this.yCi += 1;
  }
  
  public final void qL(boolean paramBoolean)
  {
    et localet = this.yBX;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localet.eiA = i;
      return;
    }
  }
  
  public final void ze(long paramLong)
  {
    this.yBX.eiD = paramLong;
  }
  
  public final void zf(long paramLong)
  {
    if (paramLong > this.yCf) {
      this.yBX.eiO = (paramLong - this.yCf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.b.a
 * JD-Core Version:    0.7.0.1
 */