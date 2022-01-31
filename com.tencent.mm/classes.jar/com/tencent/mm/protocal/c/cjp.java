package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class cjp
  extends com.tencent.mm.bv.a
{
  public String hRf;
  public String tXp;
  public long tXr;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tXp == null) {
        throw new b("Not all required fields were included: Talker");
      }
      if (this.hRf == null) {
        throw new b("Not all required fields were included: NickName");
      }
      if (this.tXp != null) {
        paramVarArgs.d(1, this.tXp);
      }
      if (this.hRf != null) {
        paramVarArgs.d(2, this.hRf);
      }
      paramVarArgs.Y(3, this.tXr);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tXp == null) {
        break label337;
      }
    }
    label337:
    for (paramInt = d.a.a.b.b.a.e(1, this.tXp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hRf != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.hRf);
      }
      return i + d.a.a.a.X(3, this.tXr);
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
        if (this.hRf != null) {
          break;
        }
        throw new b("Not all required fields were included: NickName");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cjp localcjp = (cjp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcjp.tXp = locala.xpH.readString();
          return 0;
        case 2: 
          localcjp.hRf = locala.xpH.readString();
          return 0;
        }
        localcjp.tXr = locala.xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cjp
 * JD-Core Version:    0.7.0.1
 */