package com.tencent.mm.protocal.c;

public final class bbl
  extends com.tencent.mm.bv.a
{
  public String bSM;
  public String ePR;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ePR != null) {
        paramVarArgs.d(1, this.ePR);
      }
      if (this.bSM != null) {
        paramVarArgs.d(2, this.bSM);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.ePR == null) {
        break label234;
      }
    }
    label234:
    for (paramInt = d.a.a.b.b.a.e(1, this.ePR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bSM != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.bSM);
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
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        bbl localbbl = (bbl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbbl.ePR = locala.xpH.readString();
          return 0;
        }
        localbbl.bSM = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bbl
 * JD-Core Version:    0.7.0.1
 */