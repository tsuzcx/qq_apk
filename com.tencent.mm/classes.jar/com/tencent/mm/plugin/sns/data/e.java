package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public int DDA = -1;
  public int DDB = 0;
  public boolean DDC = false;
  public int DDD = -1;
  public boolean DDE = false;
  public int DDF = -1;
  public int DDG = 0;
  public int DDt = -1;
  public int DDu = -1;
  public boolean DDv = false;
  public int DDw = -1;
  public String DDx = "";
  public String DDy = "";
  public String DDz = "";
  public int uUn = 0;
  
  private static boolean Yi(int paramInt)
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
  
  public final void eZq()
  {
    this.DDu = -1;
    this.DDD = -1;
    this.DDt = -1;
    this.DDx = "";
    this.DDy = "";
    this.DDz = "";
    this.DDC = false;
    this.DDv = false;
    this.DDE = false;
    this.DDF = -1;
    this.DDw = -1;
    this.DDA = -1;
    this.DDB = 0;
    this.uUn = 0;
    this.DDG = 0;
  }
  
  public final boolean eZr()
  {
    AppMethodBeat.i(95065);
    if (this.DDA == 2)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.DDu == -1)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.DDA != this.DDw)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (Yi(this.DDA))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (Yi(this.DDw))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.DDB > 1) || (this.uUn > 1))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.DDz != null) && (!this.DDz.equals("")))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if ((this.DDx != null) && (!this.DDx.equals("")))
    {
      AppMethodBeat.o(95065);
      return true;
    }
    if (this.DDt != this.DDu)
    {
      AppMethodBeat.o(95065);
      return true;
    }
    AppMethodBeat.o(95065);
    return false;
  }
  
  public final boolean eZs()
  {
    AppMethodBeat.i(95066);
    if (this.DDD == -1)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.DDw != this.DDF)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (Yi(this.DDF))
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.DDG > 1)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if ((this.DDy != null) && (!this.DDy.equals("")))
    {
      AppMethodBeat.o(95066);
      return true;
    }
    if (this.DDu != this.DDD)
    {
      AppMethodBeat.o(95066);
      return true;
    }
    AppMethodBeat.o(95066);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.e
 * JD-Core Version:    0.7.0.1
 */