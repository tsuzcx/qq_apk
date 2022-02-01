package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
{
  private int FPN;
  private long FPO;
  int FPP = 0;
  private int FPQ;
  long FPR;
  int FPS;
  int FPT;
  private int FPU;
  private int FPV;
  private int FPW;
  int FPX;
  int FPY;
  public int FPZ = 0;
  private int FQa;
  private int FQb;
  private int FQc;
  private int FQd;
  private int FQe;
  private int FQf;
  private int FQg;
  private int FQh;
  private int FQi;
  String FQj;
  int FQk;
  int FQl;
  long FQm;
  int FQn;
  long FQo;
  long FQp;
  boolean FQq;
  boolean FQr;
  private long hlg;
  int roomId;
  long ypH;
  
  public final void abp(int paramInt)
  {
    AppMethodBeat.i(29477);
    if (this.FQm == 0L)
    {
      AppMethodBeat.o(29477);
      return;
    }
    this.FPN = paramInt;
    this.FPO = Util.ticksToNow(this.FQm);
    AppMethodBeat.o(29477);
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(29479);
    if (this.FQm == 0L)
    {
      AppMethodBeat.o(29479);
      return;
    }
    this.FPQ = ((int)(Util.ticksToNow(this.FQm) / 1000L));
    AppMethodBeat.o(29479);
  }
  
  public final void ftV()
  {
    AppMethodBeat.i(29478);
    if (this.FQm == 0L)
    {
      AppMethodBeat.o(29478);
      return;
    }
    this.hlg = Util.ticksToNow(this.FQm);
    AppMethodBeat.o(29478);
  }
  
  public final void ftW()
  {
    this.FPW += 1;
  }
  
  public final void ftX()
  {
    AppMethodBeat.i(29480);
    if (this.FQp == 0L)
    {
      AppMethodBeat.o(29480);
      return;
    }
    long l = Util.ticksToNow(this.FQp) / 1000L;
    if (l < 2L) {
      this.FQa += 1;
    }
    for (;;)
    {
      this.FQp = 0L;
      AppMethodBeat.o(29480);
      return;
      if (l < 6L) {
        this.FQb += 1;
      } else if (l < 11L) {
        this.FQc += 1;
      } else if (l < 21L) {
        this.FQd += 1;
      } else if (l < 31L) {
        this.FQe += 1;
      } else if (l < 41L) {
        this.FQf += 1;
      } else if (l < 51L) {
        this.FQg += 1;
      } else if (l < 61L) {
        this.FQh += 1;
      } else {
        this.FQi += 1;
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(29481);
    String str = this.FPN + "," + this.FPO + "," + this.hlg + "," + this.FPP + "," + this.FPQ + "," + this.FPR + "," + this.FPS + "," + this.FPT + "," + this.FPU + "," + this.FPV + "," + this.FPW + "," + this.FPX + "," + this.FPY + "," + this.FPZ + "," + this.FQa + "," + this.FQb + "," + this.FQc + "," + this.FQd + "," + this.FQe + "," + this.FQf + "," + this.FQg + "," + this.FQh + "," + this.FQi + "," + this.FQj + "," + this.roomId + "," + this.ypH + "," + this.FQk + "," + this.FQl;
    AppMethodBeat.o(29481);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.f
 * JD-Core Version:    0.7.0.1
 */