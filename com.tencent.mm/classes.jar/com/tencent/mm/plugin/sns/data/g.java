package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public int EVk = 0;
  public int QmF = -1;
  public int QmG = -1;
  public boolean QmH = false;
  public int QmI = -1;
  public String QmJ = "";
  public String QmK = "";
  public String QmL = "";
  public int QmM = -1;
  public int QmN = 0;
  public boolean QmO = false;
  public int QmP = -1;
  public boolean QmQ = false;
  public int QmR = -1;
  public int QmS = 0;
  
  private static boolean akm(int paramInt)
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
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 35: 
    case 40: 
    case 41: 
    default: 
      return false;
    }
    return true;
  }
  
  public final void heJ()
  {
    this.QmG = -1;
    this.QmP = -1;
    this.QmF = -1;
    this.QmJ = "";
    this.QmK = "";
    this.QmL = "";
    this.QmO = false;
    this.QmH = false;
    this.QmQ = false;
    this.QmR = -1;
    this.QmI = -1;
    this.QmM = -1;
    this.QmN = 0;
    this.EVk = 0;
    this.QmS = 0;
  }
  
  public final boolean heK()
  {
    AppMethodBeat.i(95065);
    if (this.QmM == 2)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.QmG == -1)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.QmM != this.QmI)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (akm(this.QmM))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (akm(this.QmI))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.QmN > 1) || (this.EVk > 1))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.QmL != null) && (!this.QmL.equals("")))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.QmJ != null) && (!this.QmJ.equals("")))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.QmF != this.QmG)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    AppMethodBeat.o(95065);
    return false;
  }
  
  public final boolean heL()
  {
    AppMethodBeat.i(95066);
    if (this.QmP == -1)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.QmI != this.QmR)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (akm(this.QmR))
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.QmS > 1)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if ((this.QmK != null) && (!this.QmK.equals("")))
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.QmG != this.QmP)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    AppMethodBeat.o(95066);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.g
 * JD-Core Version:    0.7.0.1
 */