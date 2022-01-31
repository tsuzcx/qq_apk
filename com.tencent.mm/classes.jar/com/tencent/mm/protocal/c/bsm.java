package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class bsm
  extends com.tencent.mm.bv.a
{
  public int sAr;
  public String syc;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.syc == null) {
        throw new b("Not all required fields were included: ProductID");
      }
      if (this.syc != null) {
        paramVarArgs.d(1, this.syc);
      }
      paramVarArgs.gB(2, this.sAr);
      return 0;
    }
    if (paramInt == 1) {
      if (this.syc == null) {
        break label244;
      }
    }
    label244:
    for (paramInt = d.a.a.b.b.a.e(1, this.syc) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.sAr);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.syc != null) {
          break;
        }
        throw new b("Not all required fields were included: ProductID");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        bsm localbsm = (bsm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbsm.syc = locala.xpH.readString();
          return 0;
        }
        localbsm.sAr = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bsm
 * JD-Core Version:    0.7.0.1
 */