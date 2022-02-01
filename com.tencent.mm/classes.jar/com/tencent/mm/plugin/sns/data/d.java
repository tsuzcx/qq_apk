package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int sud = 0;
  public int zti = -1;
  public int ztj = -1;
  public boolean ztk = false;
  public int ztl = -1;
  public String ztm = "";
  public String ztn = "";
  public String zto = "";
  public int ztp = -1;
  public int ztq = 0;
  public boolean ztr = false;
  public int zts = -1;
  public boolean ztt = false;
  public int ztu = -1;
  public int ztv = 0;
  
  private static boolean Qn(int paramInt)
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
  
  public final void dWf()
  {
    this.ztj = -1;
    this.zts = -1;
    this.zti = -1;
    this.ztm = "";
    this.ztn = "";
    this.zto = "";
    this.ztr = false;
    this.ztk = false;
    this.ztt = false;
    this.ztu = -1;
    this.ztl = -1;
    this.ztp = -1;
    this.ztq = 0;
    this.sud = 0;
    this.ztv = 0;
  }
  
  public final boolean dWg()
  {
    AppMethodBeat.i(95065);
    if (this.ztp == 2)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.ztj == -1)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.ztp != this.ztl)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (Qn(this.ztp))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (Qn(this.ztl))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.ztq > 1) || (this.sud > 1))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.zto != null) && (!this.zto.equals("")))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.ztm != null) && (!this.ztm.equals("")))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.zti != this.ztj)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    AppMethodBeat.o(95065);
    return false;
  }
  
  public final boolean dWh()
  {
    AppMethodBeat.i(95066);
    if (this.zts == -1)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.ztl != this.ztu)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (Qn(this.ztu))
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.ztv > 1)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if ((this.ztn != null) && (!this.ztn.equals("")))
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.ztj != this.zts)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    AppMethodBeat.o(95066);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.d
 * JD-Core Version:    0.7.0.1
 */