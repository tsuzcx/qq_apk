package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

public final class f
{
  private long gcc;
  int roomId;
  long tIG;
  private int zVT;
  private long zVU;
  int zVV = 0;
  private int zVW;
  long zVX;
  int zVY;
  int zVZ;
  private int zWa;
  private int zWb;
  private int zWc;
  int zWd;
  int zWe;
  public int zWf = 0;
  private int zWg;
  private int zWh;
  private int zWi;
  private int zWj;
  private int zWk;
  private int zWl;
  private int zWm;
  private int zWn;
  private int zWo;
  String zWp;
  int zWq;
  int zWr;
  long zWs;
  int zWt;
  long zWu;
  long zWv;
  boolean zWw;
  boolean zWx;
  
  public final void Rc(int paramInt)
  {
    AppMethodBeat.i(29477);
    if (this.zWs == 0L)
    {
      AppMethodBeat.o(29477);
      return;
    }
    this.zVT = paramInt;
    this.zVU = bs.aO(this.zWs);
    AppMethodBeat.o(29477);
  }
  
  public final void ebu()
  {
    AppMethodBeat.i(29478);
    if (this.zWs == 0L)
    {
      AppMethodBeat.o(29478);
      return;
    }
    this.gcc = bs.aO(this.zWs);
    AppMethodBeat.o(29478);
  }
  
  public final void ebv()
  {
    this.zWc += 1;
  }
  
  public final void ebw()
  {
    AppMethodBeat.i(29480);
    if (this.zWv == 0L)
    {
      AppMethodBeat.o(29480);
      return;
    }
    long l = bs.aO(this.zWv) / 1000L;
    if (l < 2L) {
      this.zWg += 1;
    }
    for (;;)
    {
      this.zWv = 0L;
      AppMethodBeat.o(29480);
      return;
      if (l < 6L) {
        this.zWh += 1;
      } else if (l < 11L) {
        this.zWi += 1;
      } else if (l < 21L) {
        this.zWj += 1;
      } else if (l < 31L) {
        this.zWk += 1;
      } else if (l < 41L) {
        this.zWl += 1;
      } else if (l < 51L) {
        this.zWm += 1;
      } else if (l < 61L) {
        this.zWn += 1;
      } else {
        this.zWo += 1;
      }
    }
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(29479);
    if (this.zWs == 0L)
    {
      AppMethodBeat.o(29479);
      return;
    }
    this.zVW = ((int)(bs.aO(this.zWs) / 1000L));
    AppMethodBeat.o(29479);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(29481);
    String str = this.zVT + "," + this.zVU + "," + this.gcc + "," + this.zVV + "," + this.zVW + "," + this.zVX + "," + this.zVY + "," + this.zVZ + "," + this.zWa + "," + this.zWb + "," + this.zWc + "," + this.zWd + "," + this.zWe + "," + this.zWf + "," + this.zWg + "," + this.zWh + "," + this.zWi + "," + this.zWj + "," + this.zWk + "," + this.zWl + "," + this.zWm + "," + this.zWn + "," + this.zWo + "," + this.zWp + "," + this.roomId + "," + this.tIG + "," + this.zWq + "," + this.zWr;
    AppMethodBeat.o(29481);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.f
 * JD-Core Version:    0.7.0.1
 */