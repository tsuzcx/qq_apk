package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class ayk
  extends com.tencent.mm.bv.a
{
  public String sxM;
  public double tuu;
  public long tuv;
  
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
      paramVarArgs.b(2, this.tuu);
      paramVarArgs.Y(3, this.tuv);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sxM == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = d.a.a.b.b.a.e(1, this.sxM) + 0;; paramInt = 0)
    {
      return paramInt + (d.a.a.b.b.a.dQ(2) + 8) + d.a.a.a.X(3, this.tuv);
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
        ayk localayk = (ayk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localayk.sxM = locala.xpH.readString();
          return 0;
        case 2: 
          localayk.tuu = locala.xpH.readDouble();
          return 0;
        }
        localayk.tuv = locala.xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ayk
 * JD-Core Version:    0.7.0.1
 */