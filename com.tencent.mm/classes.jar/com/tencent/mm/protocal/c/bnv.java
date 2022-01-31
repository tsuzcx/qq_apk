package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class bnv
  extends com.tencent.mm.bv.a
{
  public long tAB;
  public String tGE;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tGE == null) {
        throw new b("Not all required fields were included: Query");
      }
      if (this.tGE != null) {
        paramVarArgs.d(1, this.tGE);
      }
      paramVarArgs.Y(2, this.tAB);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tGE == null) {
        break label244;
      }
    }
    label244:
    for (paramInt = d.a.a.b.b.a.e(1, this.tGE) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.X(2, this.tAB);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tGE != null) {
          break;
        }
        throw new b("Not all required fields were included: Query");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        bnv localbnv = (bnv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbnv.tGE = locala.xpH.readString();
          return 0;
        }
        localbnv.tAB = locala.xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bnv
 * JD-Core Version:    0.7.0.1
 */