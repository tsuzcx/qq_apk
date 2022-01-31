package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class ceg
  extends com.tencent.mm.bv.a
{
  public int tAA;
  public String tpY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tpY == null) {
        throw new b("Not all required fields were included: Ip");
      }
      if (this.tpY != null) {
        paramVarArgs.d(1, this.tpY);
      }
      paramVarArgs.gB(2, this.tAA);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tpY == null) {
        break label244;
      }
    }
    label244:
    for (paramInt = d.a.a.b.b.a.e(1, this.tpY) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.tAA);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tpY != null) {
          break;
        }
        throw new b("Not all required fields were included: Ip");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        ceg localceg = (ceg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localceg.tpY = locala.xpH.readString();
          return 0;
        }
        localceg.tAA = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ceg
 * JD-Core Version:    0.7.0.1
 */