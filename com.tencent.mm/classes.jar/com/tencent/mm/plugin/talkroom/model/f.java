package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class f
{
  private long eBS;
  int nMZ;
  long nNa;
  private int tcA;
  private int tcB;
  private int tcC;
  private int tcD;
  private int tcE;
  private int tcF;
  String tcG;
  int tcH;
  int tcI;
  long tcJ;
  int tcK;
  long tcL;
  long tcM;
  boolean tcN;
  boolean tcO;
  private int tck;
  private long tcl;
  int tcm = 0;
  private int tcn;
  long tco;
  int tcp;
  int tcq;
  private int tcr;
  private int tcs;
  private int tct;
  int tcu;
  int tcv;
  public int tcw = 0;
  private int tcx;
  private int tcy;
  private int tcz;
  
  public final void Gp(int paramInt)
  {
    AppMethodBeat.i(25795);
    if (this.tcJ == 0L)
    {
      AppMethodBeat.o(25795);
      return;
    }
    this.tck = paramInt;
    this.tcl = bo.av(this.tcJ);
    AppMethodBeat.o(25795);
  }
  
  public final void cHA()
  {
    AppMethodBeat.i(25796);
    if (this.tcJ == 0L)
    {
      AppMethodBeat.o(25796);
      return;
    }
    this.eBS = bo.av(this.tcJ);
    AppMethodBeat.o(25796);
  }
  
  public final void cHB()
  {
    AppMethodBeat.i(25797);
    if (this.tcJ == 0L)
    {
      AppMethodBeat.o(25797);
      return;
    }
    this.tcn = ((int)(bo.av(this.tcJ) / 1000L));
    AppMethodBeat.o(25797);
  }
  
  public final void cHC()
  {
    this.tct += 1;
  }
  
  public final void cHD()
  {
    AppMethodBeat.i(25798);
    if (this.tcM == 0L)
    {
      AppMethodBeat.o(25798);
      return;
    }
    long l = bo.av(this.tcM) / 1000L;
    if (l < 2L) {
      this.tcx += 1;
    }
    for (;;)
    {
      this.tcM = 0L;
      AppMethodBeat.o(25798);
      return;
      if (l < 6L) {
        this.tcy += 1;
      } else if (l < 11L) {
        this.tcz += 1;
      } else if (l < 21L) {
        this.tcA += 1;
      } else if (l < 31L) {
        this.tcB += 1;
      } else if (l < 41L) {
        this.tcC += 1;
      } else if (l < 51L) {
        this.tcD += 1;
      } else if (l < 61L) {
        this.tcE += 1;
      } else {
        this.tcF += 1;
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(25799);
    String str = this.tck + "," + this.tcl + "," + this.eBS + "," + this.tcm + "," + this.tcn + "," + this.tco + "," + this.tcp + "," + this.tcq + "," + this.tcr + "," + this.tcs + "," + this.tct + "," + this.tcu + "," + this.tcv + "," + this.tcw + "," + this.tcx + "," + this.tcy + "," + this.tcz + "," + this.tcA + "," + this.tcB + "," + this.tcC + "," + this.tcD + "," + this.tcE + "," + this.tcF + "," + this.tcG + "," + this.nMZ + "," + this.nNa + "," + this.tcH + "," + this.tcI;
    AppMethodBeat.o(25799);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.f
 * JD-Core Version:    0.7.0.1
 */