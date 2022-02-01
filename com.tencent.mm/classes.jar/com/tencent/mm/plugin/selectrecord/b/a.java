package com.tencent.mm.plugin.selectrecord.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.nd;

public final class a
{
  public static a Pmi = null;
  public nd Pmj;
  public int Pmk;
  public int Pml;
  public int Pmm;
  public int Pmn;
  public int Pmo;
  public int Pmp;
  public int Pmq;
  public long Pmr;
  public int Pms;
  public int Pmt;
  public int Pmu;
  public int Pmv;
  public int Pmw;
  public long Pmx;
  public long Pmy;
  
  public a()
  {
    AppMethodBeat.i(266729);
    this.Pmj = null;
    this.Pmk = 0;
    this.Pml = 0;
    this.Pmm = 0;
    this.Pmn = 0;
    this.Pmo = 0;
    this.Pmp = 0;
    this.Pmq = 0;
    this.Pmr = 0L;
    this.Pms = 0;
    this.Pmt = 0;
    this.Pmu = 0;
    this.Pmv = 0;
    this.Pmw = 0;
    this.Pmx = 0L;
    this.Pmy = 0L;
    this.Pmj = new nd();
    AppMethodBeat.o(266729);
  }
  
  public static a gUF()
  {
    AppMethodBeat.i(266717);
    if (Pmi == null) {
      gUG();
    }
    a locala = Pmi;
    AppMethodBeat.o(266717);
    return locala;
  }
  
  public static void gUG()
  {
    AppMethodBeat.i(266721);
    Pmi = new a();
    AppMethodBeat.o(266721);
  }
  
  public final void CC(boolean paramBoolean)
  {
    nd localnd = this.Pmj;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localnd.jdi = i;
      return;
    }
  }
  
  public final void gUH()
  {
    this.Pmn += 1;
  }
  
  public final void gUI()
  {
    this.Pmo += 1;
  }
  
  public final void gUJ()
  {
    this.Pmu += 1;
  }
  
  public final void ud(long paramLong)
  {
    this.Pmj.jdl = paramLong;
  }
  
  public final void ue(long paramLong)
  {
    if (paramLong > this.Pmr) {
      this.Pmj.jdu = (paramLong - this.Pmr);
    }
  }
  
  public final void uf(long paramLong)
  {
    this.Pmj.jdy = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.b.a
 * JD-Core Version:    0.7.0.1
 */