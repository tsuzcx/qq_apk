package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class ckl
  extends com.tencent.mm.bv.a
{
  public String tXM;
  public String tXN;
  public String tXO;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tXM == null) {
        throw new b("Not all required fields were included: Plugin");
      }
      if (this.tXN == null) {
        throw new b("Not all required fields were included: ActivityPath");
      }
      if (this.tXM != null) {
        paramVarArgs.d(1, this.tXM);
      }
      if (this.tXN != null) {
        paramVarArgs.d(2, this.tXN);
      }
      if (this.tXO != null) {
        paramVarArgs.d(3, this.tXO);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tXM == null) {
        break label357;
      }
    }
    label357:
    for (int i = d.a.a.b.b.a.e(1, this.tXM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tXN != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tXN);
      }
      i = paramInt;
      if (this.tXO != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tXO);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tXM == null) {
          throw new b("Not all required fields were included: Plugin");
        }
        if (this.tXN != null) {
          break;
        }
        throw new b("Not all required fields were included: ActivityPath");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        ckl localckl = (ckl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localckl.tXM = locala.xpH.readString();
          return 0;
        case 2: 
          localckl.tXN = locala.xpH.readString();
          return 0;
        }
        localckl.tXO = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ckl
 * JD-Core Version:    0.7.0.1
 */