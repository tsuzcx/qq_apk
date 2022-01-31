package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class ckf
  extends com.tencent.mm.bv.a
{
  public int pyo;
  public String sFP;
  public String sRE;
  public String tXp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tXp == null) {
        throw new b("Not all required fields were included: Talker");
      }
      if (this.sRE == null) {
        throw new b("Not all required fields were included: MD5");
      }
      if (this.sFP == null) {
        throw new b("Not all required fields were included: ProductId");
      }
      if (this.tXp != null) {
        paramVarArgs.d(1, this.tXp);
      }
      if (this.sRE != null) {
        paramVarArgs.d(2, this.sRE);
      }
      if (this.sFP != null) {
        paramVarArgs.d(3, this.sFP);
      }
      paramVarArgs.gB(4, this.pyo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tXp == null) {
        break label428;
      }
    }
    label428:
    for (int i = d.a.a.b.b.a.e(1, this.tXp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sRE != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sRE);
      }
      i = paramInt;
      if (this.sFP != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sFP);
      }
      return i + d.a.a.a.gy(4, this.pyo);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tXp == null) {
          throw new b("Not all required fields were included: Talker");
        }
        if (this.sRE == null) {
          throw new b("Not all required fields were included: MD5");
        }
        if (this.sFP != null) {
          break;
        }
        throw new b("Not all required fields were included: ProductId");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        ckf localckf = (ckf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localckf.tXp = locala.xpH.readString();
          return 0;
        case 2: 
          localckf.sRE = locala.xpH.readString();
          return 0;
        case 3: 
          localckf.sFP = locala.xpH.readString();
          return 0;
        }
        localckf.pyo = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ckf
 * JD-Core Version:    0.7.0.1
 */