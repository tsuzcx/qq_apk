package com.tencent.mm.protocal.c;

public final class yk
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kRN;
  public int svA;
  public String svB;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      if (this.kRN != null) {
        paramVarArgs.d(2, this.kRN);
      }
      paramVarArgs.gB(3, this.svA);
      if (this.svB != null) {
        paramVarArgs.d(4, this.svB);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label328;
      }
    }
    label328:
    for (paramInt = d.a.a.b.b.a.e(1, this.bGw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kRN != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kRN);
      }
      i += d.a.a.a.gy(3, this.svA);
      paramInt = i;
      if (this.svB != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.svB);
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
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        yk localyk = (yk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localyk.bGw = locala.xpH.readString();
          return 0;
        case 2: 
          localyk.kRN = locala.xpH.readString();
          return 0;
        case 3: 
          localyk.svA = locala.xpH.oD();
          return 0;
        }
        localyk.svB = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.yk
 * JD-Core Version:    0.7.0.1
 */