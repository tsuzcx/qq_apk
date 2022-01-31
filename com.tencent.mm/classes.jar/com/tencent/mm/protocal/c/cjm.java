package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class cjm
  extends com.tencent.mm.bv.a
{
  public String jxi;
  public String sxM;
  public boolean tXo;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sxM == null) {
        throw new b("Not all required fields were included: Username");
      }
      if (this.jxi == null) {
        throw new b("Not all required fields were included: Language");
      }
      if (this.sxM != null) {
        paramVarArgs.d(1, this.sxM);
      }
      if (this.jxi != null) {
        paramVarArgs.d(2, this.jxi);
      }
      paramVarArgs.aA(3, this.tXo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sxM == null) {
        break label334;
      }
    }
    label334:
    for (paramInt = d.a.a.b.b.a.e(1, this.sxM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jxi != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.jxi);
      }
      return i + (d.a.a.b.b.a.dQ(3) + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sxM == null) {
          throw new b("Not all required fields were included: Username");
        }
        if (this.jxi != null) {
          break;
        }
        throw new b("Not all required fields were included: Language");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cjm localcjm = (cjm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcjm.sxM = locala.xpH.readString();
          return 0;
        case 2: 
          localcjm.jxi = locala.xpH.readString();
          return 0;
        }
        localcjm.tXo = locala.cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cjm
 * JD-Core Version:    0.7.0.1
 */