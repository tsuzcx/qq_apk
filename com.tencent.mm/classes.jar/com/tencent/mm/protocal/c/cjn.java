package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class cjn
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kVs;
  public String tXp;
  public long tXq;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tXp == null) {
        throw new b("Not all required fields were included: Talker");
      }
      if (this.bGw == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.kVs == null) {
        throw new b("Not all required fields were included: Content");
      }
      if (this.tXp != null) {
        paramVarArgs.d(1, this.tXp);
      }
      if (this.bGw != null) {
        paramVarArgs.d(2, this.bGw);
      }
      if (this.kVs != null) {
        paramVarArgs.d(3, this.kVs);
      }
      paramVarArgs.Y(4, this.tXq);
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
      if (this.bGw != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bGw);
      }
      i = paramInt;
      if (this.kVs != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kVs);
      }
      return i + d.a.a.a.X(4, this.tXq);
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
        if (this.bGw == null) {
          throw new b("Not all required fields were included: Title");
        }
        if (this.kVs != null) {
          break;
        }
        throw new b("Not all required fields were included: Content");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cjn localcjn = (cjn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcjn.tXp = locala.xpH.readString();
          return 0;
        case 2: 
          localcjn.bGw = locala.xpH.readString();
          return 0;
        case 3: 
          localcjn.kVs = locala.xpH.readString();
          return 0;
        }
        localcjn.tXq = locala.xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cjn
 * JD-Core Version:    0.7.0.1
 */