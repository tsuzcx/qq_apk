package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public int rvG = 0;
  public int xMA = -1;
  public int xMB = -1;
  public boolean xMC = false;
  public int xMD = -1;
  public String xME = "";
  public String xMF = "";
  public String xMG = "";
  public int xMH = -1;
  public int xMI = 0;
  public boolean xMJ = false;
  public int xMK = -1;
  public boolean xML = false;
  public int xMM = -1;
  public int xMN = 0;
  
  private static boolean NZ(int paramInt)
  {
    switch (paramInt)
    {
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 16: 
    case 17: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 27: 
    default: 
      return false;
    }
    return true;
  }
  
  public final void dGs()
  {
    this.xMB = -1;
    this.xMK = -1;
    this.xMA = -1;
    this.xME = "";
    this.xMF = "";
    this.xMG = "";
    this.xMJ = false;
    this.xMC = false;
    this.xML = false;
    this.xMM = -1;
    this.xMD = -1;
    this.xMH = -1;
    this.xMI = 0;
    this.rvG = 0;
    this.xMN = 0;
  }
  
  public final boolean dGt()
  {
    AppMethodBeat.i(95065);
    if (this.xMH == 2)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.xMB == -1)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.xMH != this.xMD)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (NZ(this.xMH))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (NZ(this.xMD))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.xMI > 1) || (this.rvG > 1))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.xMG != null) && (!this.xMG.equals("")))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.xME != null) && (!this.xME.equals("")))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.xMA != this.xMB)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    AppMethodBeat.o(95065);
    return false;
  }
  
  public final boolean dGu()
  {
    AppMethodBeat.i(95066);
    if (this.xMK == -1)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.xMD != this.xMM)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (NZ(this.xMM))
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.xMN > 1)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if ((this.xMF != null) && (!this.xMF.equals("")))
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.xMB != this.xMK)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    AppMethodBeat.o(95066);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.c
 * JD-Core Version:    0.7.0.1
 */