package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public int wAg = -1;
  public int wAh = -1;
  public boolean wAi = false;
  public int wAj = -1;
  public int wAk = 0;
  public String wAl = "";
  public String wAm = "";
  public String wAn = "";
  public int wAo = -1;
  public int wAp = 0;
  public boolean wAq = false;
  public int wAr = -1;
  public boolean wAs = false;
  public int wAt = -1;
  public int wAu = 0;
  
  private static boolean LX(int paramInt)
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
  
  public final void drT()
  {
    this.wAh = -1;
    this.wAr = -1;
    this.wAg = -1;
    this.wAl = "";
    this.wAm = "";
    this.wAn = "";
    this.wAq = false;
    this.wAi = false;
    this.wAs = false;
    this.wAt = -1;
    this.wAj = -1;
    this.wAo = -1;
    this.wAp = 0;
    this.wAk = 0;
    this.wAu = 0;
  }
  
  public final boolean drU()
  {
    AppMethodBeat.i(95065);
    if (this.wAo == 2)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.wAh == -1)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.wAo != this.wAj)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (LX(this.wAo))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (LX(this.wAj))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.wAp > 1) || (this.wAk > 1))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.wAn != null) && (!this.wAn.equals("")))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.wAl != null) && (!this.wAl.equals("")))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.wAg != this.wAh)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    AppMethodBeat.o(95065);
    return false;
  }
  
  public final boolean drV()
  {
    AppMethodBeat.i(95066);
    if (this.wAr == -1)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.wAj != this.wAt)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (LX(this.wAt))
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.wAu > 1)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if ((this.wAm != null) && (!this.wAm.equals("")))
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.wAh != this.wAr)
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