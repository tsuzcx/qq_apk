package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public int slg = 0;
  public int zcA = 0;
  public boolean zcB = false;
  public int zcC = -1;
  public boolean zcD = false;
  public int zcE = -1;
  public int zcF = 0;
  public int zcs = -1;
  public int zct = -1;
  public boolean zcu = false;
  public int zcv = -1;
  public String zcw = "";
  public String zcx = "";
  public String zcy = "";
  public int zcz = -1;
  
  private static boolean PG(int paramInt)
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
  
  public final void dSF()
  {
    this.zct = -1;
    this.zcC = -1;
    this.zcs = -1;
    this.zcw = "";
    this.zcx = "";
    this.zcy = "";
    this.zcB = false;
    this.zcu = false;
    this.zcD = false;
    this.zcE = -1;
    this.zcv = -1;
    this.zcz = -1;
    this.zcA = 0;
    this.slg = 0;
    this.zcF = 0;
  }
  
  public final boolean dSG()
  {
    AppMethodBeat.i(95065);
    if (this.zcz == 2)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.zct == -1)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.zcz != this.zcv)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (PG(this.zcz))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (PG(this.zcv))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.zcA > 1) || (this.slg > 1))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.zcy != null) && (!this.zcy.equals("")))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.zcw != null) && (!this.zcw.equals("")))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.zcs != this.zct)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    AppMethodBeat.o(95065);
    return false;
  }
  
  public final boolean dSH()
  {
    AppMethodBeat.i(95066);
    if (this.zcC == -1)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.zcv != this.zcE)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (PG(this.zcE))
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.zcF > 1)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if ((this.zcx != null) && (!this.zcx.equals("")))
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.zct != this.zcC)
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