package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class rb
  extends com.tencent.mm.bv.a
{
  public String key;
  public long sOI;
  public String sOJ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.key == null) {
        throw new b("Not all required fields were included: key");
      }
      if (this.key != null) {
        paramVarArgs.d(1, this.key);
      }
      paramVarArgs.Y(2, this.sOI);
      if (this.sOJ != null) {
        paramVarArgs.d(3, this.sOJ);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label305;
      }
    }
    label305:
    for (paramInt = d.a.a.b.b.a.e(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.X(2, this.sOI);
      paramInt = i;
      if (this.sOJ != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sOJ);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.key != null) {
          break;
        }
        throw new b("Not all required fields were included: key");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        rb localrb = (rb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localrb.key = locala.xpH.readString();
          return 0;
        case 2: 
          localrb.sOI = locala.xpH.oE();
          return 0;
        }
        localrb.sOJ = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.rb
 * JD-Core Version:    0.7.0.1
 */