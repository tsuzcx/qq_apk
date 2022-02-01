package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class f
{
  private int BnA;
  long BnB;
  int BnC;
  int BnD;
  private int BnE;
  private int BnF;
  private int BnG;
  int BnH;
  int BnI;
  public int BnJ = 0;
  private int BnK;
  private int BnL;
  private int BnM;
  private int BnN;
  private int BnO;
  private int BnP;
  private int BnQ;
  private int BnR;
  private int BnS;
  String BnT;
  int BnU;
  int BnV;
  long BnW;
  int BnX;
  long BnY;
  long BnZ;
  private int Bnx;
  private long Bny;
  int Bnz = 0;
  boolean Boa;
  boolean Bob;
  private long gvM;
  int roomId;
  long uLt;
  
  public final void SM(int paramInt)
  {
    AppMethodBeat.i(29477);
    if (this.BnW == 0L)
    {
      AppMethodBeat.o(29477);
      return;
    }
    this.Bnx = paramInt;
    this.Bny = bt.aO(this.BnW);
    AppMethodBeat.o(29477);
  }
  
  public final void enL()
  {
    AppMethodBeat.i(29478);
    if (this.BnW == 0L)
    {
      AppMethodBeat.o(29478);
      return;
    }
    this.gvM = bt.aO(this.BnW);
    AppMethodBeat.o(29478);
  }
  
  public final void enM()
  {
    this.BnG += 1;
  }
  
  public final void enN()
  {
    AppMethodBeat.i(29480);
    if (this.BnZ == 0L)
    {
      AppMethodBeat.o(29480);
      return;
    }
    long l = bt.aO(this.BnZ) / 1000L;
    if (l < 2L) {
      this.BnK += 1;
    }
    for (;;)
    {
      this.BnZ = 0L;
      AppMethodBeat.o(29480);
      return;
      if (l < 6L) {
        this.BnL += 1;
      } else if (l < 11L) {
        this.BnM += 1;
      } else if (l < 21L) {
        this.BnN += 1;
      } else if (l < 31L) {
        this.BnO += 1;
      } else if (l < 41L) {
        this.BnP += 1;
      } else if (l < 51L) {
        this.BnQ += 1;
      } else if (l < 61L) {
        this.BnR += 1;
      } else {
        this.BnS += 1;
      }
    }
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(29479);
    if (this.BnW == 0L)
    {
      AppMethodBeat.o(29479);
      return;
    }
    this.BnA = ((int)(bt.aO(this.BnW) / 1000L));
    AppMethodBeat.o(29479);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(29481);
    String str = this.Bnx + "," + this.Bny + "," + this.gvM + "," + this.Bnz + "," + this.BnA + "," + this.BnB + "," + this.BnC + "," + this.BnD + "," + this.BnE + "," + this.BnF + "," + this.BnG + "," + this.BnH + "," + this.BnI + "," + this.BnJ + "," + this.BnK + "," + this.BnL + "," + this.BnM + "," + this.BnN + "," + this.BnO + "," + this.BnP + "," + this.BnQ + "," + this.BnR + "," + this.BnS + "," + this.BnT + "," + this.roomId + "," + this.uLt + "," + this.BnU + "," + this.BnV;
    AppMethodBeat.o(29481);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.f
 * JD-Core Version:    0.7.0.1
 */