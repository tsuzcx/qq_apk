package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class cko
  extends com.tencent.mm.bv.a
{
  public String sRA;
  public int ssy;
  public boolean tXT;
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
      if (this.tXp != null) {
        paramVarArgs.d(1, this.tXp);
      }
      if (this.sRA != null) {
        paramVarArgs.d(2, this.sRA);
      }
      paramVarArgs.aA(3, this.tXT);
      paramVarArgs.gB(4, this.ssy);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tXp == null) {
        break label369;
      }
    }
    label369:
    for (paramInt = d.a.a.b.b.a.e(1, this.tXp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sRA != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sRA);
      }
      return i + (d.a.a.b.b.a.dQ(3) + 1) + d.a.a.a.gy(4, this.ssy);
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
        if (this.sRA != null) {
          break;
        }
        throw new b("Not all required fields were included: Text");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cko localcko = (cko)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcko.tXp = locala.xpH.readString();
          return 0;
        case 2: 
          localcko.sRA = locala.xpH.readString();
          return 0;
        case 3: 
          localcko.tXT = locala.cUr();
          return 0;
        }
        localcko.ssy = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cko
 * JD-Core Version:    0.7.0.1
 */