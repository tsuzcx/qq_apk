package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public int JPY = -1;
  public int JPZ = -1;
  public boolean JQa = false;
  public int JQb = -1;
  public String JQc = "";
  public String JQd = "";
  public String JQe = "";
  public int JQf = -1;
  public int JQg = 0;
  public boolean JQh = false;
  public int JQi = -1;
  public boolean JQj = false;
  public int JQk = -1;
  public int JQl = 0;
  public int zKD = 0;
  
  private static boolean afy(int paramInt)
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
  
  public final void fNi()
  {
    this.JPZ = -1;
    this.JQi = -1;
    this.JPY = -1;
    this.JQc = "";
    this.JQd = "";
    this.JQe = "";
    this.JQh = false;
    this.JQa = false;
    this.JQj = false;
    this.JQk = -1;
    this.JQb = -1;
    this.JQf = -1;
    this.JQg = 0;
    this.zKD = 0;
    this.JQl = 0;
  }
  
  public final boolean fNj()
  {
    AppMethodBeat.i(95065);
    if (this.JQf == 2)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.JPZ == -1)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.JQf != this.JQb)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (afy(this.JQf))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (afy(this.JQb))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.JQg > 1) || (this.zKD > 1))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.JQe != null) && (!this.JQe.equals("")))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.JQc != null) && (!this.JQc.equals("")))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.JPY != this.JPZ)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    AppMethodBeat.o(95065);
    return false;
  }
  
  public final boolean fNk()
  {
    AppMethodBeat.i(95066);
    if (this.JQi == -1)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.JQb != this.JQk)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (afy(this.JQk))
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.JQl > 1)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if ((this.JQd != null) && (!this.JQd.equals("")))
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.JPZ != this.JQi)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    AppMethodBeat.o(95066);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.g
 * JD-Core Version:    0.7.0.1
 */