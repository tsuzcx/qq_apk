package com.tencent.mm.protocal.c;

public final class yc
  extends com.tencent.mm.bv.a
{
  public int bRv;
  public String bVA;
  public String label;
  public double lat;
  public double lng;
  public boolean sWO = false;
  public boolean sWP = false;
  public boolean sWQ = false;
  public boolean sWR = false;
  public boolean sWS = false;
  
  public final yc EM(int paramInt)
  {
    this.bRv = paramInt;
    this.sWQ = true;
    return this;
  }
  
  public final yc Yh(String paramString)
  {
    this.label = paramString;
    this.sWR = true;
    return this;
  }
  
  public final yc Yi(String paramString)
  {
    this.bVA = paramString;
    this.sWS = true;
    return this;
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sWO == true) {
        paramVarArgs.b(1, this.lng);
      }
      if (this.sWP == true) {
        paramVarArgs.b(2, this.lat);
      }
      if (this.sWQ == true) {
        paramVarArgs.gB(3, this.bRv);
      }
      if (this.label != null) {
        paramVarArgs.d(4, this.label);
      }
      if (this.bVA != null) {
        paramVarArgs.d(5, this.bVA);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sWO != true) {
        break label433;
      }
    }
    label433:
    for (int i = d.a.a.b.b.a.dQ(1) + 8 + 0;; i = 0)
    {
      paramInt = i;
      if (this.sWP == true) {
        paramInt = i + (d.a.a.b.b.a.dQ(2) + 8);
      }
      i = paramInt;
      if (this.sWQ == true) {
        i = paramInt + d.a.a.a.gy(3, this.bRv);
      }
      paramInt = i;
      if (this.label != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.label);
      }
      i = paramInt;
      if (this.bVA != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.bVA);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        yc localyc = (yc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localyc.lng = locala.xpH.readDouble();
          localyc.sWO = true;
          return 0;
        case 2: 
          localyc.lat = locala.xpH.readDouble();
          localyc.sWP = true;
          return 0;
        case 3: 
          localyc.bRv = locala.xpH.oD();
          localyc.sWQ = true;
          return 0;
        case 4: 
          localyc.label = locala.xpH.readString();
          localyc.sWR = true;
          return 0;
        }
        localyc.bVA = locala.xpH.readString();
        localyc.sWS = true;
        return 0;
      }
      return -1;
    }
  }
  
  public final yc y(double paramDouble)
  {
    this.lng = paramDouble;
    this.sWO = true;
    return this;
  }
  
  public final yc z(double paramDouble)
  {
    this.lat = paramDouble;
    this.sWP = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.yc
 * JD-Core Version:    0.7.0.1
 */