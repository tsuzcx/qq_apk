package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
{
  long Hnt;
  private int SNA;
  private int SNB;
  private int SNC;
  private int SND;
  private int SNE;
  String SNF;
  int SNG;
  int SNH;
  long SNI;
  int SNJ;
  long SNK;
  long SNL;
  boolean SNM;
  boolean SNN;
  private int SNj;
  private long SNk;
  int SNl = 0;
  private int SNm;
  long SNn;
  int SNo;
  int SNp;
  private int SNq;
  private int SNr;
  private int SNs;
  int SNt;
  int SNu;
  public int SNv = 0;
  private int SNw;
  private int SNx;
  private int SNy;
  private int SNz;
  private long mwJ;
  int roomId;
  
  public final void anN(int paramInt)
  {
    AppMethodBeat.i(29477);
    if (this.SNI == 0L)
    {
      AppMethodBeat.o(29477);
      return;
    }
    this.SNj = paramInt;
    this.SNk = Util.ticksToNow(this.SNI);
    AppMethodBeat.o(29477);
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(29479);
    if (this.SNI == 0L)
    {
      AppMethodBeat.o(29479);
      return;
    }
    this.SNm = ((int)(Util.ticksToNow(this.SNI) / 1000L));
    AppMethodBeat.o(29479);
  }
  
  public final void hCA()
  {
    AppMethodBeat.i(29480);
    if (this.SNL == 0L)
    {
      AppMethodBeat.o(29480);
      return;
    }
    long l = Util.ticksToNow(this.SNL) / 1000L;
    if (l < 2L) {
      this.SNw += 1;
    }
    for (;;)
    {
      this.SNL = 0L;
      AppMethodBeat.o(29480);
      return;
      if (l < 6L) {
        this.SNx += 1;
      } else if (l < 11L) {
        this.SNy += 1;
      } else if (l < 21L) {
        this.SNz += 1;
      } else if (l < 31L) {
        this.SNA += 1;
      } else if (l < 41L) {
        this.SNB += 1;
      } else if (l < 51L) {
        this.SNC += 1;
      } else if (l < 61L) {
        this.SND += 1;
      } else {
        this.SNE += 1;
      }
    }
  }
  
  public final void hCy()
  {
    AppMethodBeat.i(29478);
    if (this.SNI == 0L)
    {
      AppMethodBeat.o(29478);
      return;
    }
    this.mwJ = Util.ticksToNow(this.SNI);
    AppMethodBeat.o(29478);
  }
  
  public final void hCz()
  {
    this.SNs += 1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(29481);
    String str = this.SNj + "," + this.SNk + "," + this.mwJ + "," + this.SNl + "," + this.SNm + "," + this.SNn + "," + this.SNo + "," + this.SNp + "," + this.SNq + "," + this.SNr + "," + this.SNs + "," + this.SNt + "," + this.SNu + "," + this.SNv + "," + this.SNw + "," + this.SNx + "," + this.SNy + "," + this.SNz + "," + this.SNA + "," + this.SNB + "," + this.SNC + "," + this.SND + "," + this.SNE + "," + this.SNF + "," + this.roomId + "," + this.Hnt + "," + this.SNG + "," + this.SNH;
    AppMethodBeat.o(29481);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.f
 * JD-Core Version:    0.7.0.1
 */