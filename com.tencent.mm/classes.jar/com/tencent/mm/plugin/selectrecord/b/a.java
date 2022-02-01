package com.tencent.mm.plugin.selectrecord.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ev;

public final class a
{
  public static a yRX = null;
  public ev yRY;
  public int yRZ;
  public int ySa;
  public int ySb;
  public int ySc;
  public int ySd;
  public int ySe;
  public int ySf;
  public long ySg;
  public int ySh;
  public int ySi;
  public int ySj;
  public int ySk;
  public int ySl;
  public long ySm;
  public long ySn;
  
  public a()
  {
    AppMethodBeat.i(193991);
    this.yRY = null;
    this.yRZ = 0;
    this.ySa = 0;
    this.ySb = 0;
    this.ySc = 0;
    this.ySd = 0;
    this.ySe = 0;
    this.ySf = 0;
    this.ySg = 0L;
    this.ySh = 0;
    this.ySi = 0;
    this.ySj = 0;
    this.ySk = 0;
    this.ySl = 0;
    this.ySm = 0L;
    this.ySn = 0L;
    this.yRY = new ev();
    AppMethodBeat.o(193991);
  }
  
  public static a dQt()
  {
    AppMethodBeat.i(193989);
    if (yRX == null) {
      dQu();
    }
    a locala = yRX;
    AppMethodBeat.o(193989);
    return locala;
  }
  
  public static void dQu()
  {
    AppMethodBeat.i(193990);
    yRX = new a();
    AppMethodBeat.o(193990);
  }
  
  public final void dQv()
  {
    this.ySc += 1;
  }
  
  public final void dQw()
  {
    this.ySd += 1;
  }
  
  public final void dQx()
  {
    this.ySj += 1;
  }
  
  public final void qS(boolean paramBoolean)
  {
    ev localev = this.yRY;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localev.ekk = i;
      return;
    }
  }
  
  public final void zB(long paramLong)
  {
    this.yRY.ekn = paramLong;
  }
  
  public final void zC(long paramLong)
  {
    if (paramLong > this.ySg) {
      this.yRY.ekw = (paramLong - this.ySg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.b.a
 * JD-Core Version:    0.7.0.1
 */