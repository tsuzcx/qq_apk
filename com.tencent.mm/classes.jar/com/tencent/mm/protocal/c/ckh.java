package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class ckh
  extends com.tencent.mm.bv.a
{
  public int pyo;
  public String sRA;
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
      paramVarArgs.gB(3, this.pyo);
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
      if (this.sRA != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sRA);
      }
      return i + d.a.a.a.gy(3, this.pyo);
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
        ckh localckh = (ckh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localckh.tXp = locala.xpH.readString();
          return 0;
        case 2: 
          localckh.sRA = locala.xpH.readString();
          return 0;
        }
        localckh.pyo = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ckh
 * JD-Core Version:    0.7.0.1
 */