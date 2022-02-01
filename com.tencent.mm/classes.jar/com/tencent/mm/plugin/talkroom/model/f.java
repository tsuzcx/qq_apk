package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class f
{
  private long fXv;
  int roomId;
  long sAY;
  private int yIG;
  private long yIH;
  int yII = 0;
  private int yIJ;
  long yIK;
  int yIL;
  int yIM;
  private int yIN;
  private int yIO;
  private int yIP;
  int yIQ;
  int yIR;
  public int yIS = 0;
  private int yIT;
  private int yIU;
  private int yIV;
  private int yIW;
  private int yIX;
  private int yIY;
  private int yIZ;
  private int yJa;
  private int yJb;
  String yJc;
  int yJd;
  int yJe;
  long yJf;
  int yJg;
  long yJh;
  long yJi;
  boolean yJj;
  boolean yJk;
  
  public final void OW(int paramInt)
  {
    AppMethodBeat.i(29477);
    if (this.yJf == 0L)
    {
      AppMethodBeat.o(29477);
      return;
    }
    this.yIG = paramInt;
    this.yIH = bt.aS(this.yJf);
    AppMethodBeat.o(29477);
  }
  
  public final void dMU()
  {
    AppMethodBeat.i(29478);
    if (this.yJf == 0L)
    {
      AppMethodBeat.o(29478);
      return;
    }
    this.fXv = bt.aS(this.yJf);
    AppMethodBeat.o(29478);
  }
  
  public final void dMV()
  {
    this.yIP += 1;
  }
  
  public final void dMW()
  {
    AppMethodBeat.i(29480);
    if (this.yJi == 0L)
    {
      AppMethodBeat.o(29480);
      return;
    }
    long l = bt.aS(this.yJi) / 1000L;
    if (l < 2L) {
      this.yIT += 1;
    }
    for (;;)
    {
      this.yJi = 0L;
      AppMethodBeat.o(29480);
      return;
      if (l < 6L) {
        this.yIU += 1;
      } else if (l < 11L) {
        this.yIV += 1;
      } else if (l < 21L) {
        this.yIW += 1;
      } else if (l < 31L) {
        this.yIX += 1;
      } else if (l < 41L) {
        this.yIY += 1;
      } else if (l < 51L) {
        this.yIZ += 1;
      } else if (l < 61L) {
        this.yJa += 1;
      } else {
        this.yJb += 1;
      }
    }
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(29479);
    if (this.yJf == 0L)
    {
      AppMethodBeat.o(29479);
      return;
    }
    this.yIJ = ((int)(bt.aS(this.yJf) / 1000L));
    AppMethodBeat.o(29479);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(29481);
    String str = this.yIG + "," + this.yIH + "," + this.fXv + "," + this.yII + "," + this.yIJ + "," + this.yIK + "," + this.yIL + "," + this.yIM + "," + this.yIN + "," + this.yIO + "," + this.yIP + "," + this.yIQ + "," + this.yIR + "," + this.yIS + "," + this.yIT + "," + this.yIU + "," + this.yIV + "," + this.yIW + "," + this.yIX + "," + this.yIY + "," + this.yIZ + "," + this.yJa + "," + this.yJb + "," + this.yJc + "," + this.roomId + "," + this.sAY + "," + this.yJd + "," + this.yJe;
    AppMethodBeat.o(29481);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.f
 * JD-Core Version:    0.7.0.1
 */