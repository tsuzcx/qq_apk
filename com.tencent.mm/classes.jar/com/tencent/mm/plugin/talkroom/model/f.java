package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

public final class f
{
  private int BEW;
  private long BEX;
  int BEY = 0;
  private int BEZ;
  boolean BFA;
  long BFa;
  int BFb;
  int BFc;
  private int BFd;
  private int BFe;
  private int BFf;
  int BFg;
  int BFh;
  public int BFi = 0;
  private int BFj;
  private int BFk;
  private int BFl;
  private int BFm;
  private int BFn;
  private int BFo;
  private int BFp;
  private int BFq;
  private int BFr;
  String BFs;
  int BFt;
  int BFu;
  long BFv;
  int BFw;
  long BFx;
  long BFy;
  boolean BFz;
  private long gyt;
  int roomId;
  long uXg;
  
  public final void Tt(int paramInt)
  {
    AppMethodBeat.i(29477);
    if (this.BFv == 0L)
    {
      AppMethodBeat.o(29477);
      return;
    }
    this.BEW = paramInt;
    this.BEX = bu.aO(this.BFv);
    AppMethodBeat.o(29477);
  }
  
  public final void ers()
  {
    AppMethodBeat.i(29478);
    if (this.BFv == 0L)
    {
      AppMethodBeat.o(29478);
      return;
    }
    this.gyt = bu.aO(this.BFv);
    AppMethodBeat.o(29478);
  }
  
  public final void ert()
  {
    this.BFf += 1;
  }
  
  public final void eru()
  {
    AppMethodBeat.i(29480);
    if (this.BFy == 0L)
    {
      AppMethodBeat.o(29480);
      return;
    }
    long l = bu.aO(this.BFy) / 1000L;
    if (l < 2L) {
      this.BFj += 1;
    }
    for (;;)
    {
      this.BFy = 0L;
      AppMethodBeat.o(29480);
      return;
      if (l < 6L) {
        this.BFk += 1;
      } else if (l < 11L) {
        this.BFl += 1;
      } else if (l < 21L) {
        this.BFm += 1;
      } else if (l < 31L) {
        this.BFn += 1;
      } else if (l < 41L) {
        this.BFo += 1;
      } else if (l < 51L) {
        this.BFp += 1;
      } else if (l < 61L) {
        this.BFq += 1;
      } else {
        this.BFr += 1;
      }
    }
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(29479);
    if (this.BFv == 0L)
    {
      AppMethodBeat.o(29479);
      return;
    }
    this.BEZ = ((int)(bu.aO(this.BFv) / 1000L));
    AppMethodBeat.o(29479);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(29481);
    String str = this.BEW + "," + this.BEX + "," + this.gyt + "," + this.BEY + "," + this.BEZ + "," + this.BFa + "," + this.BFb + "," + this.BFc + "," + this.BFd + "," + this.BFe + "," + this.BFf + "," + this.BFg + "," + this.BFh + "," + this.BFi + "," + this.BFj + "," + this.BFk + "," + this.BFl + "," + this.BFm + "," + this.BFn + "," + this.BFo + "," + this.BFp + "," + this.BFq + "," + this.BFr + "," + this.BFs + "," + this.roomId + "," + this.uXg + "," + this.BFt + "," + this.BFu;
    AppMethodBeat.o(29481);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.f
 * JD-Core Version:    0.7.0.1
 */