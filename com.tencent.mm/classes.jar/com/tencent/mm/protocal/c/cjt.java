package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class cjt
  extends com.tencent.mm.bv.a
{
  public String sxM;
  public long tAB;
  public boolean tXy;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sxM == null) {
        throw new b("Not all required fields were included: Username");
      }
      if (this.sxM != null) {
        paramVarArgs.d(1, this.sxM);
      }
      paramVarArgs.Y(2, this.tAB);
      paramVarArgs.aA(3, this.tXy);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sxM == null) {
        break label275;
      }
    }
    label275:
    for (paramInt = d.a.a.b.b.a.e(1, this.sxM) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.X(2, this.tAB) + (d.a.a.b.b.a.dQ(3) + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sxM != null) {
          break;
        }
        throw new b("Not all required fields were included: Username");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cjt localcjt = (cjt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcjt.sxM = locala.xpH.readString();
          return 0;
        case 2: 
          localcjt.tAB = locala.xpH.oE();
          return 0;
        }
        localcjt.tXy = locala.cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cjt
 * JD-Core Version:    0.7.0.1
 */