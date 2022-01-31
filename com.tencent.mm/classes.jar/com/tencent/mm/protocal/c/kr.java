package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class kr
  extends com.tencent.mm.bv.a
{
  public String kSy;
  public String sFG;
  public String sFH;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kSy == null) {
        throw new b("Not all required fields were included: IconUrl");
      }
      if (this.kSy != null) {
        paramVarArgs.d(1, this.kSy);
      }
      if (this.sFG != null) {
        paramVarArgs.d(2, this.sFG);
      }
      if (this.sFH != null) {
        paramVarArgs.d(3, this.sFH);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kSy == null) {
        break label321;
      }
    }
    label321:
    for (int i = d.a.a.b.b.a.e(1, this.kSy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sFG != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sFG);
      }
      i = paramInt;
      if (this.sFH != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sFH);
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
        if (this.kSy != null) {
          break;
        }
        throw new b("Not all required fields were included: IconUrl");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        kr localkr = (kr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localkr.kSy = locala.xpH.readString();
          return 0;
        case 2: 
          localkr.sFG = locala.xpH.readString();
          return 0;
        }
        localkr.sFH = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.kr
 * JD-Core Version:    0.7.0.1
 */