package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class ckg
  extends com.tencent.mm.bv.a
{
  public int pyo;
  public String sFP;
  public String sRA;
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
      if (this.sRA == null) {
        throw new b("Not all required fields were included: Text");
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
      if (this.sRA != null) {
        paramVarArgs.d(2, this.sRA);
      }
      if (this.sRE != null) {
        paramVarArgs.d(3, this.sRE);
      }
      if (this.sFP != null) {
        paramVarArgs.d(4, this.sFP);
      }
      paramVarArgs.gB(5, this.pyo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tXp == null) {
        break label515;
      }
    }
    label515:
    for (int i = d.a.a.b.b.a.e(1, this.tXp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sRA != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sRA);
      }
      i = paramInt;
      if (this.sRE != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sRE);
      }
      paramInt = i;
      if (this.sFP != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sFP);
      }
      return paramInt + d.a.a.a.gy(5, this.pyo);
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
        if (this.sRA == null) {
          throw new b("Not all required fields were included: Text");
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
        ckg localckg = (ckg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localckg.tXp = locala.xpH.readString();
          return 0;
        case 2: 
          localckg.sRA = locala.xpH.readString();
          return 0;
        case 3: 
          localckg.sRE = locala.xpH.readString();
          return 0;
        case 4: 
          localckg.sFP = locala.xpH.readString();
          return 0;
        }
        localckg.pyo = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ckg
 * JD-Core Version:    0.7.0.1
 */