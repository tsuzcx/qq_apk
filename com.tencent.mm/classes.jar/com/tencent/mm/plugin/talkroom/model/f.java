package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
{
  long DPJ;
  private int MjO;
  private long MjP;
  int MjQ = 0;
  private int MjR;
  long MjS;
  int MjT;
  int MjU;
  private int MjV;
  private int MjW;
  private int MjX;
  int MjY;
  int MjZ;
  public int Mka = 0;
  private int Mkb;
  private int Mkc;
  private int Mkd;
  private int Mke;
  private int Mkf;
  private int Mkg;
  private int Mkh;
  private int Mki;
  private int Mkj;
  String Mkk;
  int Mkl;
  int Mkm;
  long Mkn;
  int Mko;
  long Mkp;
  long Mkq;
  boolean Mkr;
  boolean Mks;
  private long jWP;
  int roomId;
  
  public final void aiL(int paramInt)
  {
    AppMethodBeat.i(29477);
    if (this.Mkn == 0L)
    {
      AppMethodBeat.o(29477);
      return;
    }
    this.MjO = paramInt;
    this.MjP = Util.ticksToNow(this.Mkn);
    AppMethodBeat.o(29477);
  }
  
  public final void exitRoom()
  {
    AppMethodBeat.i(29479);
    if (this.Mkn == 0L)
    {
      AppMethodBeat.o(29479);
      return;
    }
    this.MjR = ((int)(Util.ticksToNow(this.Mkn) / 1000L));
    AppMethodBeat.o(29479);
  }
  
  public final void gix()
  {
    AppMethodBeat.i(29478);
    if (this.Mkn == 0L)
    {
      AppMethodBeat.o(29478);
      return;
    }
    this.jWP = Util.ticksToNow(this.Mkn);
    AppMethodBeat.o(29478);
  }
  
  public final void giy()
  {
    this.MjX += 1;
  }
  
  public final void giz()
  {
    AppMethodBeat.i(29480);
    if (this.Mkq == 0L)
    {
      AppMethodBeat.o(29480);
      return;
    }
    long l = Util.ticksToNow(this.Mkq) / 1000L;
    if (l < 2L) {
      this.Mkb += 1;
    }
    for (;;)
    {
      this.Mkq = 0L;
      AppMethodBeat.o(29480);
      return;
      if (l < 6L) {
        this.Mkc += 1;
      } else if (l < 11L) {
        this.Mkd += 1;
      } else if (l < 21L) {
        this.Mke += 1;
      } else if (l < 31L) {
        this.Mkf += 1;
      } else if (l < 41L) {
        this.Mkg += 1;
      } else if (l < 51L) {
        this.Mkh += 1;
      } else if (l < 61L) {
        this.Mki += 1;
      } else {
        this.Mkj += 1;
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(29481);
    String str = this.MjO + "," + this.MjP + "," + this.jWP + "," + this.MjQ + "," + this.MjR + "," + this.MjS + "," + this.MjT + "," + this.MjU + "," + this.MjV + "," + this.MjW + "," + this.MjX + "," + this.MjY + "," + this.MjZ + "," + this.Mka + "," + this.Mkb + "," + this.Mkc + "," + this.Mkd + "," + this.Mke + "," + this.Mkf + "," + this.Mkg + "," + this.Mkh + "," + this.Mki + "," + this.Mkj + "," + this.Mkk + "," + this.roomId + "," + this.DPJ + "," + this.Mkl + "," + this.Mkm;
    AppMethodBeat.o(29481);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.f
 * JD-Core Version:    0.7.0.1
 */