package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class cjx
  extends com.tencent.mm.bv.a
{
  public int tXB;
  public String tXp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tXp == null) {
        throw new b("Not all required fields were included: Talker");
      }
      if (this.tXp != null) {
        paramVarArgs.d(1, this.tXp);
      }
      paramVarArgs.gB(2, this.tXB);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tXp == null) {
        break label244;
      }
    }
    label244:
    for (paramInt = d.a.a.b.b.a.e(1, this.tXp) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.tXB);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tXp != null) {
          break;
        }
        throw new b("Not all required fields were included: Talker");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cjx localcjx = (cjx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcjx.tXp = locala.xpH.readString();
          return 0;
        }
        localcjx.tXB = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cjx
 * JD-Core Version:    0.7.0.1
 */